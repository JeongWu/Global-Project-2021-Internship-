"use strict";
// Class definition
	
var KTDatatableJsonRemoteDemo = function() {
    // basic demo 
    var belong = function() {
		var myId = document.getElementById('param');
		console.log(myId.value);
        var datatable = $('#team_members').KTDatatable({
            // datasource definition
            data: {
                type: 'remote',
                source: {
                    read: {
                        url: '/api/team-histories/datatables/member/'+ myId.value,
						params: {
						}
                    },
                },
                pageSize: 10,
            },

            // layout definition
            layout: {
                scroll: false, // enable/disable datatable scroll both horizontal and vertical when needed.
                footer: false // display/hide footer
            },

            // column sorting
            sortable: false,

            pagination: true,

            search: {
                input: $('#kt_datatable_search_query'),
                key: 'generalSearch'
            },

            // columns definition
            columns: [{
                field: 'teamMemberId.team.teamSeq',
                title: '#',
                width: 20,
                textAlign: 'left',
            }, {
                field: 'teamMemberId.member.name',
                title: 'MEMBER',
				textAlign: 'center',
            },  {
                field: 'applyBeginDate',
                title: 'PERIOD',
 				type: 'String',
				textAlign: 'center',
                template: function(row) {
				return '<span>'+ row.teamMemberId.applyBeginDate
                + ' ~ ' + row.applyEndDate +'</span>';
			},	
            },
			{
                field: 'teamManagerFlag',
                title: 'TEAM MANAGER / LEAD',
				textAlign: 'center',
				template: function(row) {
					var status = {
					'Y': {'title': 'YES',},
					'N': {'title': 'NO',},
				};
				return '<span>' + status[row.teamManagerFlag].title 
                + ' / ' + status[row.teamLeadFlag].title +'</span>';
			},				
            },			{
                
                field: 'teamMemberId.member.updatedDate',
                title: 'Edit',
				textAlign: 'center',
            },
			{
                field: 'justification',
                title: 'Justification',
				textAlign: 'center',
                template: function(row) {
                    var output = ''
                    output = '<span data-toggle="tooltip" data-placement="top" data-trigger="focus"\
                    title="'+row.justification+'"><span class="d-inline-block text-truncate" style="max-width: 150px;">'+row.justification+'</span></span>';
                    return output;
			},
            }
			]

        });

        $('#kt_datatable_search_teamManager').on('change', function() {
            var n = $(this).val();
             if ($(this).is(':checked')){
                n = 'Y';
            } else {
                n = 'N';
            }
            datatable.search(n.toLowerCase(), 'teamManagerFlag');
        });

        $('#kt_datatable_search_teamLead').on('change', function() {
            var n = $(this).val();
            if ($(this).is(':checked')){
               n = 'Y';
           } else {
               n = 'N';
           }
            datatable.search(n.toLowerCase(), 'teamLeadFlag');
        });

        $('#kt_datatable_search_teamManager, #kt_datatable_search_teamLead').selectpicker();	
        
        $('#reset').on('click', function(e) {
            e.preventDefault();
            $('.datatable-input').each(function() {
                $(this).val('');
                $(this).prop("checked", false);
                datatable.setDataSourceParam('query', {});
                datatable.reload();
            });
        });

		$('#kt_datatable_search_level').on('change', function() {
			datatable.search($(this).val().toLowerCase(), 'level');
		});
		
		$("#kt_datatable_search_justification").on("change keyup paste", function () {
      datatable.search($(this).val().toLowerCase(), "justification");
    });
		$("#kt_datatable_search_memberName").on("change keyup paste", function () {
      datatable.search($(this).val().toLowerCase(), "teamMemberId.member.name");
    });

    };

    return {
        // public functions
        init: function() {
			belong();
        }
    };
}();

jQuery(document).ready(function() {
    KTDatatableJsonRemoteDemo.init();
});
