"use strict";
// Class definition

//Objective datatable
var OkrsListDatatable = function() {
    // Private functions
    var objNo = 0;
    var objArray = new Array();

    // OKRs table
    var _showTable = function() {
        var datatable = $('#kt_datatable_okr').KTDatatable({
            // datasource definition
            data: {
                type: 'remote',
                source: {
                    read: {
                        url: '/api/datatables/okr',
                        params: {
                            id : $('#objectiveId').val(),
                        },
                    },
                },
                pageSize: 10, // display 20 records per page
                serverPaging: false,
                serverFiltering: false,
                serverSorting: false,
            },

            // layout definition
            layout: {
                scroll: false, // enable/disable datatable scroll both horizontal and vertical when needed.
                footer: false, // display/hide footer
            },

            // column sorting
            sortable: false,

            pagination: false,

            search: {
                input: $('#kt_subheader_search_form'),
                delay: 400,
                key: 'generalSearch'
            },

            // columns definition
            columns: [{
                field: 'RecordID',
                title: '#',
                sortable: 'asc',
                width: 40,
                type: 'number',
                selector: false,
                textAlign: 'left',
                template: function(row) {
                    objNo = row.objNo;
                    objArray[row.id] = row;

                    return '<span class="font-weight-bolder">' + row.objNo + '</span>';
                }
            },
            {
                field: 'name',
                title: 'Objective',
                width: 100,
                template: function(row) {
                    return '<div contenteditable="false">'+row.objName+'</div>';
                }
            },
            {
                field: 'progress',
                title: 'Progress',
                width: 250,
                template: function(row) {
                    return '\
							<div class="progress progress-xs mx-3 w-100">\
								<div class="progress-bar bg-success" role="progressbar" style="width: '+row.percentage+'%;" aria-valuenow="'+row.percentage+'" aria-valuemin="0" aria-valuemax="100"></div>\
							</div>\
						';
                }
            },
            {
                field: 'percent',
                title: '%',
                width: 100,
                template: function(row) {
                    return '<span class="font-weight-bolder text-dark">'+row.percentage+'%</span>';
                }
            },
            {
                field: 'Actions',
                title: 'Actions',
                sortable: false,
                width: 130,
                overflow: 'visible',
                autoHide: false,
                template: function(row) {
                    return '\
                        <a href="javascript:;" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon mr-2" title="Edit details" data-record-id="' + row.id + '">\
                            <span class="svg-icon svg-icon-md">\
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">\
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\
                                        <rect x="0" y="0" width="24" height="24"/>\
                                        <path d="M12.2674799,18.2323597 L12.0084872,5.45852451 C12.0004303,5.06114792 12.1504154,4.6768183 12.4255037,4.38993949 L15.0030167,1.70195304 L17.5910752,4.40093695 C17.8599071,4.6812911 18.0095067,5.05499603 18.0083938,5.44341307 L17.9718262,18.2062508 C17.9694575,19.0329966 17.2985816,19.701953 16.4718324,19.701953 L13.7671717,19.701953 C12.9505952,19.701953 12.2840328,19.0487684 12.2674799,18.2323597 Z" fill="#000000" fill-rule="nonzero" transform="translate(14.701953, 10.701953) rotate(-135.000000) translate(-14.701953, -10.701953) "/>\
                                        <path d="M12.9,2 C13.4522847,2 13.9,2.44771525 13.9,3 C13.9,3.55228475 13.4522847,4 12.9,4 L6,4 C4.8954305,4 4,4.8954305 4,6 L4,18 C4,19.1045695 4.8954305,20 6,20 L18,20 C19.1045695,20 20,19.1045695 20,18 L20,13 C20,12.4477153 20.4477153,12 21,12 C21.5522847,12 22,12.4477153 22,13 L22,18 C22,20.209139 20.209139,22 18,22 L6,22 C3.790861,22 2,20.209139 2,18 L2,6 C2,3.790861 3.790861,2 6,2 L12.9,2 Z" fill="#000000" fill-rule="nonzero" opacity="0.3"/>\
                                    </g>\
                                </svg>\
                            </span>\
                        </a>\
                    ';
                },
            }]
        });

        //Trigger when the edit button is clicked
        datatable.on('click', '[data-record-id]', function() {
			//console.log($(this).data('record-id'));
            //console.log(objArray[id]);

            //Objective ID
            var id = $(this).data('record-id');
            
            //set form fields
			$('#edit-name-input').val(objArray[id].objName),
			$('#edit-level-select').val(objArray[id].level),
            
            //call a function to handle Objective form submit
            _handleFormEditOkr($(this).data('record-id'));

            //show Objective editer form modal
            $('#kt_datatable_edit_okr_modal').modal('show');
		});
    };

    return {
        // public functions
        init: function() {
            _showTable();
        },
    };
}();

//Objective's Key Results datatable
var KrsListDatatable = function() {
    //Private Variables
    var krNo = 0;
    var krArray = new Array();

    // Private functions

    // show Key Result table
    var _showTable = function() {
        var datatable = $('#kt_datatable_kr').KTDatatable({
            // datasource definition
            data: {
                type: 'remote',
                source: {
                    read: {
                        url: '/api/datatables/objective/krs',
                        params: {
                            objectiveId : $('#objectiveId').val(),
                        },
                    },
                },
                pageSize: 10, // display 20 records per page
                serverPaging: false,
                serverFiltering: false,
                serverSorting: false,
            },

            // layout definition
            layout: {
                scroll: false, // enable/disable datatable scroll both horizontal and vertical when needed.
                footer: false, // display/hide footer
            },

            // column sorting
            sortable: false,

            pagination: false,

            search: {
                input: $('#kt_subheader_search_form'),
                delay: 400,
                key: 'generalSearch'
            },

            // columns definition
            columns: [{
                field: 'RecordID',
                title: '#',
                sortable: 'asc',
                width: 40,
                type: 'number',
                selector: false,
                textAlign: 'left',
                template: function(row) {
                    krNo = row.krNo;
                    krArray[row.id] = row;

                    return '<span class="font-weight-bolder">' + row.krNo + '</span>';
                }
            },
            {
                field: 'name',
                title: 'Name',
                width: 100,
                template: function(row) {
                    return '<div contenteditable="false">'+row.krName+'</div>';
                }
            },
            {
                field: 'progress',
                title: 'Progress',
                width: 250,
                template: function(row) {
                    return '\
							<div class="progress progress-xs mx-3 w-100">\
								<div class="progress-bar bg-success" role="progressbar" style="width: '+row.pctOfKrComplete+'%;" aria-valuenow="'+row.pctOfKrComplete+'" aria-valuemin="0" aria-valuemax="100"></div>\
							</div>\
						';
                }
            },
            {
                field: 'percent',
                title: '%',
                width: 100,
                template: function(row) {
                    return '<span class="font-weight-bolder text-dark">'+row.pctOfKrComplete+'%</span>';
                }
            },
            {
                field: 'Actions',
                title: 'Actions',
                sortable: false,
                width: 130,
                overflow: 'visible',
                autoHide: false,
                template: function(row) {
                    return '\
                        <a href="javascript:;" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon mr-2" title="Edit details" data-record-id="' + row.id + '">\
                            <span class="svg-icon svg-icon-md">\
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">\
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\
                                        <rect x="0" y="0" width="24" height="24"/>\
                                        <path d="M12.2674799,18.2323597 L12.0084872,5.45852451 C12.0004303,5.06114792 12.1504154,4.6768183 12.4255037,4.38993949 L15.0030167,1.70195304 L17.5910752,4.40093695 C17.8599071,4.6812911 18.0095067,5.05499603 18.0083938,5.44341307 L17.9718262,18.2062508 C17.9694575,19.0329966 17.2985816,19.701953 16.4718324,19.701953 L13.7671717,19.701953 C12.9505952,19.701953 12.2840328,19.0487684 12.2674799,18.2323597 Z" fill="#000000" fill-rule="nonzero" transform="translate(14.701953, 10.701953) rotate(-135.000000) translate(-14.701953, -10.701953) "/>\
                                        <path d="M12.9,2 C13.4522847,2 13.9,2.44771525 13.9,3 C13.9,3.55228475 13.4522847,4 12.9,4 L6,4 C4.8954305,4 4,4.8954305 4,6 L4,18 C4,19.1045695 4.8954305,20 6,20 L18,20 C19.1045695,20 20,19.1045695 20,18 L20,13 C20,12.4477153 20.4477153,12 21,12 C21.5522847,12 22,12.4477153 22,13 L22,18 C22,20.209139 20.209139,22 18,22 L6,22 C3.790861,22 2,20.209139 2,18 L2,6 C2,3.790861 3.790861,2 6,2 L12.9,2 Z" fill="#000000" fill-rule="nonzero" opacity="0.3"/>\
                                    </g>\
                                </svg>\
                            </span>\
                        </a>\
                        <a href="javascript:;" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon" title="Delete">\
                            <span class="svg-icon svg-icon-md">\
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">\
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\
                                        <rect x="0" y="0" width="24" height="24"/>\
                                        <path d="M6,8 L6,20.5 C6,21.3284271 6.67157288,22 7.5,22 L16.5,22 C17.3284271,22 18,21.3284271 18,20.5 L18,8 L6,8 Z" fill="#000000" fill-rule="nonzero"/>\
                                        <path d="M14,4.5 L14,4 C14,3.44771525 13.5522847,3 13,3 L11,3 C10.4477153,3 10,3.44771525 10,4 L10,4.5 L5.5,4.5 C5.22385763,4.5 5,4.72385763 5,5 L5,5.5 C5,5.77614237 5.22385763,6 5.5,6 L18.5,6 C18.7761424,6 19,5.77614237 19,5.5 L19,5 C19,4.72385763 18.7761424,4.5 18.5,4.5 L14,4.5 Z" fill="#000000" opacity="0.3"/>\
                                    </g>\
                                </svg>\
                            </span>\
                        </a>\
                    ';
                },
            }]
        });

        //Trigger when the edit button is clicked
        datatable.on('click', '[data-record-id]', function() {
			//console.log($(this).data('record-id'));
            //console.log(krArray[id]);
            
            //Key Result ID
            var id = $(this).data('record-id');
            
            //set form fields
			$('#edit-name-input').val(krArray[id].krName);
			$('#edit-percentage-input').val(krArray[id].pctOfKrComplete);
            
            //set Percentage slider's value
            _handlePercentageSliderStartingPoint(krArray[id].pctOfKrComplete);

            //a function call for handling Key Result editor form
            _handleFormEditKr(id);

            //show Key Result editor form modal
            $('#kt_datatable_edit_key_result_modal').modal('show');
		});
    };

    //Key Result percentage slider creation and modification handler
    var _handlePercentageSlider = function() {
        // init slider
        var slider = document.getElementById('kt_nouislider_percentage');

        noUiSlider.create(slider, {
            start: [ 0 ],
            connect: [true, false],
            step: 1,
            range: {
                'min': [ 0 ],
                'max': [ 100 ]
            },
            format: wNumb({
                decimals: 0,
                postfix: '%', 
            })
        });

        // init slider input
        var sliderInput = document.getElementById('edit-percentage-input');

        slider.noUiSlider.on('update', function( values, handle ) {
            sliderInput.value = values[handle];
        });

        sliderInput.addEventListener('change', function(){
            slider.noUiSlider.set(this.value);
        });
    }

    //set Key Result percentage slider Starting Point
    var _handlePercentageSliderStartingPoint = function(startPercentage) {
        //get slider
        var slider = document.getElementById('kt_nouislider_percentage');
        
        //set slider start value
        slider.noUiSlider.updateOptions({
            start: [ startPercentage ],
        });
    }

    var _buttonSpinnerClasses = 'spinner spinner-right spinner-white pr-15';

    //handle and submit a form that add Key Results
	var _handleFormAddKr = function() {
		var form = KTUtil.getById('add_kr_form');
		//var formSubmitUrl = KTUtil.attr(form, 'action');
		var formSubmitButton = KTUtil.getById('add_kr_form_submit');

		if (!form) {
			return;
		}

		FormValidation
		    .formValidation(
		        form,
		        {
		            fields: {
						name: {
							validators: {
								notEmpty: {
									message: 'required'
								}
							}
						},
		            },
		            plugins: {
						trigger: new FormValidation.plugins.Trigger(),
						submitButton: new FormValidation.plugins.SubmitButton(),
	            		//defaultSubmit: new FormValidation.plugins.DefaultSubmit(), // Uncomment this line to enable normal button submit after form validation
						bootstrap: new FormValidation.plugins.Bootstrap({
						//	eleInvalidClass: '', // Repace with uncomment to hide bootstrap validation icons
						//	eleValidClass: '',   // Repace with uncomment to hide bootstrap validation icons
						})
		            }
		        }
		    )
		    .on('core.form.valid', function() {
				// Show loading state on button
				KTUtil.btnWait(formSubmitButton, _buttonSpinnerClasses, "Please wait");

				// Simulate Ajax request
				setTimeout(function() {
					KTUtil.btnRelease(formSubmitButton);
				}, 2000);

				// Form Validation & Ajax Submission: https://formvalidation.io/guide/examples/using-ajax-to-submit-the-form
				
		        FormValidation.utils.fetch('/api/kr/add', {
                    method: 'POST',
                    dataType: 'json',
		            params: {
                        name: $('#add-name-input').val(),
                        no : krNo,
						objectiveId: $('#objectiveId').val(),
		            },
		        }).then(function(response) { // Return valid JSON
					// Release button
					KTUtil.btnRelease(formSubmitButton);

					if (response && typeof response === 'object' && response.status && response.status == 'success') {
						Swal.fire({
			                text: "All is cool!",
			                icon: "success",
			                buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn font-weight-bold btn-light-primary"
							}
			            }).then(function() {
                            location.reload();
						});
					} else {
						Swal.fire({
			                text: "Sorry, something went wrong, please try again.",
			                icon: "error",
			                buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn font-weight-bold btn-light-primary"
							}
			            }).then(function() {
							KTUtil.scrollTop();
						});
					}
		        });
		    })
			.on('core.form.invalid', function() {
				/* Swal.fire({
					text: "Sorry, looks like there are some errors detected, please try again.",
					icon: "error",
					buttonsStyling: false,
					confirmButtonText: "Ok, got it!",
					customClass: {
						confirmButton: "btn font-weight-bold btn-light-primary"
					}
				}).then(function() {
					KTUtil.scrollTop();
				}); */
		    });
    }

    //handle and submit a form that edit Key Results
    var _handleFormEditKr = function(id) {
		var form = KTUtil.getById('edit_kr_form');
		//var formSubmitUrl = KTUtil.attr(form, 'action');
		var formSubmitButton = KTUtil.getById('edit_kr_form_submit');

		if (!form) {
			return;
		}

		FormValidation
		    .formValidation(
		        form,
		        {
		            fields: {
						name: {
							validators: {
								notEmpty: {
									message: 'required'
								}
							}
						},
		            },
		            plugins: {
						trigger: new FormValidation.plugins.Trigger(),
						submitButton: new FormValidation.plugins.SubmitButton(),
	            		//defaultSubmit: new FormValidation.plugins.DefaultSubmit(), // Uncomment this line to enable normal button submit after form validation
						bootstrap: new FormValidation.plugins.Bootstrap({
						//	eleInvalidClass: '', // Repace with uncomment to hide bootstrap validation icons
						//	eleValidClass: '',   // Repace with uncomment to hide bootstrap validation icons
						})
		            }
		        }
		    )
		    .on('core.form.valid', function() {
				// Show loading state on button
				KTUtil.btnWait(formSubmitButton, _buttonSpinnerClasses, "Please wait");

				// Simulate Ajax request
				setTimeout(function() {
					KTUtil.btnRelease(formSubmitButton);
				}, 2000);

				// Form Validation & Ajax Submission: https://formvalidation.io/guide/examples/using-ajax-to-submit-the-form
				
		        FormValidation.utils.fetch('/api/kr/edit', {
                    method: 'POST',
                    dataType: 'json',
		            params: { 
                        id: id,
                        name: $('#edit-name-input').val(),
						percentage: $('#edit-percentage-input').val().replace('%',''),
		            },
		        }).then(function(response) { // Return valid JSON
					// Release button
					KTUtil.btnRelease(formSubmitButton);

					if (response && typeof response === 'object' && response.status && response.status == 'success') {
						Swal.fire({
			                text: "All is cool!",
			                icon: "success",
			                buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn font-weight-bold btn-light-primary"
							}
			            }).then(function() {
							location.reload();
						});
					} else {
						Swal.fire({
			                text: "Sorry, something went wrong, please try again.",
			                icon: "error",
			                buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn font-weight-bold btn-light-primary"
							}
			            }).then(function() {
							KTUtil.scrollTop();
						});
					}
		        });
		    })
			.on('core.form.invalid', function() {
				/* Swal.fire({
					text: "Sorry, looks like there are some errors detected, please try again.",
					icon: "error",
					buttonsStyling: false,
					confirmButtonText: "Ok, got it!",
					customClass: {
						confirmButton: "btn font-weight-bold btn-light-primary"
					}
				}).then(function() {
					KTUtil.scrollTop();
				}); */
            });
    }

    return {
        // public functions
        init: function() {
            _showTable();
            _handlePercentageSlider();
            _handleFormAddKr();
        },
    };
}();

//Weekly check-ins datatables
var WeeklyCheckInsListDatatable = function() {
    //Private variables
    
    //Plan-PL 
    //Done-DN 
    //Problem-PR 
    //Review&Feedback-RF
    var pl_no = 0;
    var dn_no = 0;
    var pr_no = 0;
    var rf_no = 0;

    // Private functions
    var options = {
        
        // datasource definition
        data: {
            type: 'remote',
            source: {
                read: {
                    url: '/api/weekly/checkin',
                    params: {
                        objectiveId : $('#objectiveId').val(),
                        week: 1,
                        type: 'PL'
                    },
                },
            },
            pageSize: 10, // display 20 records per page
            serverPaging: false,
            serverFiltering: false,
            serverSorting: false,
        },

        // layout definition
        layout: {
            scroll: false, // enable/disable datatable scroll both horizontal and vertical when needed.
            footer: false, // display/hide footer
        },

        // column sorting
        sortable: false,

        pagination: false,

        search: {
            input: $('#kt_subheader_search_form'),
            delay: 400,
            key: 'generalSearch'
        },

        // columns definition
        columns: [{
            field: 'id',
            title: '',
            sortable: false,
            width: 20,
            selector: {
                class: ''
            },
            textAlign: 'center',
        },{
            field: 'no',
            title: '#',
            sortable: 'asc',
            width: 40,
            type: 'number',
            selector: false,
            textAlign: 'left',
            template: function(row) {
                if(row.type == 'PL')
                    pl_no = row.no;
                else if(row.type == 'DN')
                    dn_no = row.no;
                else if(row.type == 'PR')
                    pr_no = row.no;
                else if(row.type == 'RF')
                    rf_no = row.no;

                return '<span class="font-weight-bolder">' + row.no + '</span>';
            }
        },
        {
            field: 'content',
            title: 'Plan',
            width: 360,
            template: function(row) {
                return '<div contenteditable="false">'+row.content+'</div>';
            }
        },
        {
            field: 'Actions',
            title: 'Actions',
            sortable: false,
            width: 100,
            overflow: 'visible',
            autoHide: false,
            template: function(row) {
                return '\
                    <a href="javascript:;" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon mr-2" title="Edit details" data-record-id="' + row.id + '">\
                        <span class="svg-icon svg-icon-md">\
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">\
                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\
                                    <rect x="0" y="0" width="24" height="24"/>\
                                    <path d="M12.2674799,18.2323597 L12.0084872,5.45852451 C12.0004303,5.06114792 12.1504154,4.6768183 12.4255037,4.38993949 L15.0030167,1.70195304 L17.5910752,4.40093695 C17.8599071,4.6812911 18.0095067,5.05499603 18.0083938,5.44341307 L17.9718262,18.2062508 C17.9694575,19.0329966 17.2985816,19.701953 16.4718324,19.701953 L13.7671717,19.701953 C12.9505952,19.701953 12.2840328,19.0487684 12.2674799,18.2323597 Z" fill="#000000" fill-rule="nonzero" transform="translate(14.701953, 10.701953) rotate(-135.000000) translate(-14.701953, -10.701953) "/>\
                                    <path d="M12.9,2 C13.4522847,2 13.9,2.44771525 13.9,3 C13.9,3.55228475 13.4522847,4 12.9,4 L6,4 C4.8954305,4 4,4.8954305 4,6 L4,18 C4,19.1045695 4.8954305,20 6,20 L18,20 C19.1045695,20 20,19.1045695 20,18 L20,13 C20,12.4477153 20.4477153,12 21,12 C21.5522847,12 22,12.4477153 22,13 L22,18 C22,20.209139 20.209139,22 18,22 L6,22 C3.790861,22 2,20.209139 2,18 L2,6 C2,3.790861 3.790861,2 6,2 L12.9,2 Z" fill="#000000" fill-rule="nonzero" opacity="0.3"/>\
                                </g>\
                            </svg>\
                        </span>\
                    </a>\
                    <a href="javascript:;" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon" title="Delete">\
                        <span class="svg-icon svg-icon-md">\
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">\
                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\
                                    <rect x="0" y="0" width="24" height="24"/>\
                                    <path d="M6,8 L6,20.5 C6,21.3284271 6.67157288,22 7.5,22 L16.5,22 C17.3284271,22 18,21.3284271 18,20.5 L18,8 L6,8 Z" fill="#000000" fill-rule="nonzero"/>\
                                    <path d="M14,4.5 L14,4 C14,3.44771525 13.5522847,3 13,3 L11,3 C10.4477153,3 10,3.44771525 10,4 L10,4.5 L5.5,4.5 C5.22385763,4.5 5,4.72385763 5,5 L5,5.5 C5,5.77614237 5.22385763,6 5.5,6 L18.5,6 C18.7761424,6 19,5.77614237 19,5.5 L19,5 C19,4.72385763 18.7761424,4.5 18.5,4.5 L14,4.5 Z" fill="#000000" opacity="0.3"/>\
                                </g>\
                            </svg>\
                        </span>\
                    </a>\
                ';
            },
        }],
    };

    //Weekly Plans table
    var _showTableWeeklyPlan = function() {
        // enable extension
        options.extensions = {
            // boolean or object (extension options)
            checkbox: true,
        };
        options.search = {
            input: $('#kt_datatable_search_query_2'),
            key: 'generalSearch'
        };

        var datatable = $('#kt_datatable_plan').KTDatatable(options);

        //Trigger when the checkbox is checked
        datatable.on(
            'datatable-on-check datatable-on-uncheck',
            function(e) {
                var checkedNodes = datatable.rows('.datatable-row-active').nodes();
                var count = checkedNodes.length;
                $('#kt_datatable_selected_plans').html(count);
                if (count > 0) {
                    $('#kt_datatable_group_action_form_plan').collapse('show');
                } else {
                    $('#kt_datatable_group_action_form_plan').collapse('hide');
                }
            }
        );

        //Update the selected plans' statuses to done
        $('#kt_datatable_done_plans').on('click', function(){
            //selected plans IDs
            var ids = datatable.rows('.datatable-row-active')
                        .nodes().find('.checkbox > [type="checkbox"]')
                        .map(function(i, chk) {
                            return $(chk).val();
                        });
            console.log("ids: ",ids);

            //update plan to done
            _updateToDone(ids);

        });
    };

    //Weekly Done table
    var _showTableWeeklyDone = function() {
        // enable extension
        options.extensions = {
            // boolean or object (extension options)
            checkbox: false,
        };

        //Query parameters
        options.data.source.read.params = {
            objectiveId : $('#objectiveId').val(),
            week: 1,
            type: 'DN'
        };

        //Change column title to Done
        options.columns[2].title = 'Done';

        var datatable = $('#kt_datatable_done').KTDatatable(options);
        datatable.columns('id').visible(false);

    };

    //Weekly Problem table
    var _showTableWeeklyProblem = function() {
        // enable extension
        options.extensions = {
            // boolean or object (extension options)
            checkbox: true,
        };

        //Query parameters
        options.data.source.read.params = {
            objectiveId : $('#objectiveId').val(),
            week: 1,
            type: 'PR'
        };

        //Change column title to Problem
        options.columns[2].title = 'Problem';

        var datatable = $('#kt_datatable_problem').KTDatatable(options);

        //Trigger when the checkbox is checked
        datatable.on(
            'datatable-on-check datatable-on-uncheck',
            function(e) {
                var checkedNodes = datatable.rows('.datatable-row-active').nodes();
                var count = checkedNodes.length;
                $('#kt_datatable_selected_problems').html(count);
                if (count > 0) {
                    $('#kt_datatable_group_action_form_problem').collapse('show');
                } else {
                    $('#kt_datatable_group_action_form_problem').collapse('hide');
                }
            }
        );

        //Update the selected problems' statuses to done
        $('#kt_datatable_done_problems').on('click', function(){
            var ids = datatable.rows('.datatable-row-active')
                        .nodes().find('.checkbox > [type="checkbox"]')
                        .map(function(i, chk) {
                            return $(chk).val();
                        });
            console.log("ids: ",ids);

            //update plan to done
            _updateToDone(ids);

        });
    };

    //Weekly Done table
    var _showTableWeeklyReviewAndFeedback = function() {
        // enable extension
        options.extensions = {
            // boolean or object (extension options)
            checkbox: false,
        };

        //Query parameters
        options.data.source.read.params = {
            objectiveId : $('#objectiveId').val(),
            week: 1,
            type: 'RF'
        };

        //Change column title to Review & Feedback
        options.columns[2].title = 'Review & Feedback';

        var datatable = $('#kt_datatable_review_feedback').KTDatatable(options);
        datatable.columns('id').visible(false);
    };

    //Update Weekly Check-in's type to Done
    var _updateToDone = function(selectedIDs){
        var no = dn_no;
        console.log("before no : ",no);
        var data = new Array();

        for (var i = 0; i < selectedIDs.length; i++) {
            no++;
            console.log("after no : ", no);
            data.push({
                'no' : no, 
                'id' : selectedIDs[i]
            });
        }

        $.post("/api/weekly/checkin/update",
                JSON.stringify({
                    data
                }),
        function(response, status){

            if (response && typeof response === 'object' && response.status && response.status == 'success') {
                Swal.fire({
                    text: "All is cool!",
                    icon: "success",
                    buttonsStyling: false,
                    confirmButtonText: "Ok, got it!",
                    customClass: {
                        confirmButton: "btn font-weight-bold btn-light-primary"
                    }
                }).then(function() {
                    location.reload();
                });
            } else {
                Swal.fire({
                    text: "Sorry, something went wrong, please try again.",
                    icon: "error",
                    buttonsStyling: false,
                    confirmButtonText: "Ok, got it!",
                    customClass: {
                        confirmButton: "btn font-weight-bold btn-light-primary"
                    }
                }).then(function() {
                    KTUtil.scrollTop();
                });
            }
        });
    }

    var _buttonSpinnerClasses = 'spinner spinner-right spinner-white pr-15';

    //Weekly Plan add
    var _handleFormAddWeeklyPlan = function() {
        $('#add_plan_form_submit').on('click', function(){
            var content = $('#add-plan-input').val();
            var sequence = pl_no;
            var week = 1;
            var type = 'PL';    
            var objectiveId = $('#objectiveId').val();
            _handleFormAddWeeklyCheckIn('add_plan_form', 'add_plan_form_submit', content, sequence, week, type, objectiveId);
        });
    }

    //Weekly Problem add
    var _handleFormAddWeeklyProblem = function() {
        $('#add_problem_form_submit').on('click', function(){
            var content = $('#add-problem-input').val();
            var sequence = pr_no;
            var week = 1;
            var type = 'PR';
            var objectiveId = $('#objectiveId').val();
            _handleFormAddWeeklyCheckIn('add_problem_form', 'add_problem_form_submit', content, sequence, week, type, objectiveId);
        });
    }

    //Weekly Review & Feedback add
    var _handleFormAddWeeklyReviewAndFeedback = function() {
        $('#add_review_feedback_form_submit').on('click', function(){
            var content = $('#add-review-feedback-input').val();
            var sequence = rf_no;
            var week = 1;
            var type = 'RF';
            var objectiveId = $('#objectiveId').val();
            _handleFormAddWeeklyCheckIn('add_review_feedback_form', 'add_review_feedback_form_submit', content, sequence, week, type, objectiveId);
        });
    }

    //A handler funtion to add Weekly Plan, Problem and Review&Feedback
	var _handleFormAddWeeklyCheckIn = function(formId, formSubmitId, content, sequence, week, type, objectiveId) {

        console.log(formId, formSubmitId, content, sequence, week, type, objectiveId);

		var form = KTUtil.getById(formId);
		//var formSubmitUrl = KTUtil.attr(form, 'action');
		var formSubmitButton = KTUtil.getById(formSubmitId);

		if (!form) {
			return;
		}

		FormValidation
		    .formValidation(
		        form,
		        {
		            fields: {
						content: {
							validators: {
								notEmpty: {
									message: 'required'
								}
							}
						},
		            },
		            plugins: {
						trigger: new FormValidation.plugins.Trigger(),
						submitButton: new FormValidation.plugins.SubmitButton(),
	            		//defaultSubmit: new FormValidation.plugins.DefaultSubmit(), // Uncomment this line to enable normal button submit after form validation
						bootstrap: new FormValidation.plugins.Bootstrap({
						//	eleInvalidClass: '', // Repace with uncomment to hide bootstrap validation icons
						//	eleValidClass: '',   // Repace with uncomment to hide bootstrap validation icons
						})
		            }
		        }
		    )
		    .on('core.form.valid', function() {
				// Show loading state on button
				KTUtil.btnWait(formSubmitButton, _buttonSpinnerClasses, "Please wait");

				// Simulate Ajax request
				setTimeout(function() {
					KTUtil.btnRelease(formSubmitButton);
				}, 2000);

				// Form Validation & Ajax Submission: https://formvalidation.io/guide/examples/using-ajax-to-submit-the-form
				
		        FormValidation.utils.fetch('/api/weekly/checkin/add', {
                    method: 'POST',
                    dataType: 'json',
		            params: {
                        content : content,
                        no : sequence,
                        week: week,
                        type: type,
						objectiveId: objectiveId,
		            },
		        }).then(function(response) { // Return valid JSON
					// Release button
					KTUtil.btnRelease(formSubmitButton);

					if (response && typeof response === 'object' && response.status && response.status == 'success') {
						Swal.fire({
			                text: "All is cool!",
			                icon: "success",
			                buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn font-weight-bold btn-light-primary"
							}
			            }).then(function() {
                            location.reload();
						});
					} else {
						Swal.fire({
			                text: "Sorry, something went wrong, please try again.",
			                icon: "error",
			                buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn font-weight-bold btn-light-primary"
							}
			            }).then(function() {
							KTUtil.scrollTop();
						});
					}
		        });
		    })
			.on('core.form.invalid', function() {
				/* Swal.fire({
					text: "Sorry, looks like there are some errors detected, please try again.",
					icon: "error",
					buttonsStyling: false,
					confirmButtonText: "Ok, got it!",
					customClass: {
						confirmButton: "btn font-weight-bold btn-light-primary"
					}
				}).then(function() {
					KTUtil.scrollTop();
				}); */
		    });
    }

    //A handler function to edit Plan, Problem and Review&Feedback
    var _handleFormEditWeeklyCheckIn = function(id) {
		var form = KTUtil.getById('edit_plan_form');
		//var formSubmitUrl = KTUtil.attr(form, 'action');
		var formSubmitButton = KTUtil.getById('edit_plan_form_submit');

		if (!form) {
			return;
		}

		FormValidation
		    .formValidation(
		        form,
		        {
		            fields: {
						content: {
							validators: {
								notEmpty: {
									message: 'required'
								}
							}
						},
		            },
		            plugins: {
						trigger: new FormValidation.plugins.Trigger(),
						submitButton: new FormValidation.plugins.SubmitButton(),
	            		//defaultSubmit: new FormValidation.plugins.DefaultSubmit(), // Uncomment this line to enable normal button submit after form validation
						bootstrap: new FormValidation.plugins.Bootstrap({
						//	eleInvalidClass: '', // Repace with uncomment to hide bootstrap validation icons
						//	eleValidClass: '',   // Repace with uncomment to hide bootstrap validation icons
						})
		            }
		        }
		    )
		    .on('core.form.valid', function() {
				// Show loading state on button
				KTUtil.btnWait(formSubmitButton, _buttonSpinnerClasses, "Please wait");

				// Simulate Ajax request
				setTimeout(function() {
					KTUtil.btnRelease(formSubmitButton);
				}, 2000);

				// Form Validation & Ajax Submission: https://formvalidation.io/guide/examples/using-ajax-to-submit-the-form
				
		        FormValidation.utils.fetch('/api/weekly/checkin/edit', {
                    method: 'POST',
                    dataType: 'json',
		            params: { 
                        id: id,
                        content: $('#edit-plan-input').val(),
		            },
		        }).then(function(response) { // Return valid JSON
					// Release button
					KTUtil.btnRelease(formSubmitButton);

					if (response && typeof response === 'object' && response.status && response.status == 'success') {
						Swal.fire({
			                text: "All is cool! Now you submit this form",
			                icon: "success",
			                buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn font-weight-bold btn-light-primary"
							}
			            }).then(function() {
							location.reload();
						});
					} else {
						Swal.fire({
			                text: "Sorry, something went wrong, please try again.",
			                icon: "error",
			                buttonsStyling: false,
							confirmButtonText: "Ok, got it!",
							customClass: {
								confirmButton: "btn font-weight-bold btn-light-primary"
							}
			            }).then(function() {
							KTUtil.scrollTop();
						});
					}
		        });
		    })
			.on('core.form.invalid', function() {
				/* Swal.fire({
					text: "Sorry, looks like there are some errors detected, please try again.",
					icon: "error",
					buttonsStyling: false,
					confirmButtonText: "Ok, got it!",
					customClass: {
						confirmButton: "btn font-weight-bold btn-light-primary"
					}
				}).then(function() {
					KTUtil.scrollTop();
				}); */
            });
    }

    return {
        // public functions
        init: function() {
            _showTableWeeklyPlan();
            _handleFormAddWeeklyPlan();
            _showTableWeeklyDone();
            _showTableWeeklyProblem();
            _showTableWeeklyReviewAndFeedback();
            _handleFormAddWeeklyProblem();
            _handleFormAddWeeklyReviewAndFeedback();
        },
    };
}();

jQuery(document).ready(function() {

    var teamId = $('#teamId').val();
    console.log("teamId : ",teamId);

    var memberId = $('#memberId').val();
    console.log("memberId : ",memberId);

    var okrId = $('#okrId').val();
    console.log("okrId : ",okrId);

    OkrsListDatatable.init();

    KrsListDatatable.init();

    WeeklyCheckInsListDatatable.init();
});