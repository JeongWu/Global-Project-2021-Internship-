"use strict";
// Class definition

//Company Datatable
var CompanyDatatable = function() {
	
	// Private functions
    // show datatable
    var _showTable = function() {
        var datatable = $('#kt_datatable_company').KTDatatable({
            // datasource definition
            data: {
                type: 'remote',
                source: {
                    read: {
                        url: '/api/datatables/company',
                        params: {
                            level: 'C',
                            quarter: 4,
                            year: 2020,
                        },
                    },
                },
                pageSize: 10, // display 20 records per page
                //serverPaging: true,
                //serverFiltering: true,
                //serverSorting: true,
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
                width: 20,
                type: 'number',
                selector: false,
                textAlign: 'left',
                template: function(data) {
                    return '<span class="font-weight-bolder">' + data.id + '</span>';
                }
            },
            {
                field: 'name',
                title: 'Company',
                width: 200,
                template: function(data) {
                    var output = '';
                    var stateNo = KTUtil.getRandomInt(0, 7);
                    var states = [
                        'success',
                        'primary',
                        'danger',
                        'success',
                        'warning',
                        'dark',
                        'primary',
                        'info'];
                    var state = states[stateNo];

                    output = '<div class="d-flex align-items-center">\
                        <div class="symbol symbol-40 symbol-'+state+' flex-shrink-0">\
                            <div class="symbol-label">' + data.name.substring(0, 1) + '</div>\
                        </div>\
                        <div class="ml-2">\
                            <div class="text-dark-75 font-weight-bold line-height-sm">' + data.name + '</div>\
                        </div>\
                    </div>';
                    

                    return output;
                }
            },
            {
                field: 'progress',
                title: 'Progress',
                width: 200,
                template: function(row) {
                    return '\
							<div class="progress progress-xs mx-3 w-100">\
								<div class="progress-bar bg-success" role="progressbar" style="width: ' + row.percentage + '%;" aria-valuenow="' + row.percentage + '" aria-valuemin="0" aria-valuemax="100"></div>\
							</div>\
						';
                }
            },
            {
                field: 'percent',
                title: '%',
                width: 30,
                template: function(row) {
                    return '<span class="font-weight-bolder text-dark">' + row.percentage + '%</span>';
                }
            },
            {
                field: 'Actions',
                title: 'Actions',
                sortable: false,
                width: 130,
                overflow: 'visible',
                autoHide: false,
                template: function(data) {
                    return '\
                        <a href="javascript:;" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon mr-2" title="Edit details" data-record-id="' + data.id + '">\
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

        datatable.on('click', '[data-record-id]', function() {
            console.log($(this).data('record-id'));     
            //_handleFormEditCompany($(this).data('record-id'));
            //$('#kt_datatable_edit_company_modal').modal('show');
        });
    };

    return {
        // public functions
        init: function() {
            _showTable();
        },
    };
}();

//Company Objective Datatable
var OkrsListDatatable = function() {
    //Private Variables
    var objNo = 0;
    var objArray = new Array();

	// Private functions
    // show OKRs table
    var _showTable = function() {
        var datatable = $('#kt_datatable_okr').KTDatatable({
            // datasource definition
            data: {
                type: 'remote',
                source: {
                    read: {
                        url: '/api/datatables/company/okrs',
                        params: {
                            level: 'C',
                            quarter: 4,
                            year: 2020,
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

			detail: {
				title: 'Load sub table',
				content: subTableInit,
			},

            search: {
                input: $('#kt_subheader_search_form'),
                delay: 400,
                key: 'generalSearch'
            },

            // columns definition
            columns: [
			{
				field: 'id',
				title: '',
				sortable: false,
				width: 30,
				textAlign: 'center',
			},
			{
                field: 'RecordID',
                title: '#',
                sortable: 'asc',
                width: 40,
                type: 'number',
                selector: false,
                textAlign: 'left',
                template: function(row) {
					//The Last Objective Number
					objNo = row.objNo;
					//An array with objective IDs
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
								<div class="progress-bar bg-success" role="progressbar" style="width: ' + row.percentage + '%;" aria-valuenow="' + row.percentage + '" aria-valuemin="0" aria-valuemax="100"></div>\
							</div>\
						';
                }
            },
            {
                field: 'percent',
                title: '%',
                width: 100,
                template: function(row) {
                    return '<span class="font-weight-bolder text-dark">' + row.percentage + '%</span>';
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
                        <a href="/objective/'+row.id+'" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon mr-2">\
                            <span class="svg-icon svg-icon-md">\
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" class="svg-icon">\
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\
                                        <rect x="0" y="0" width="24" height="24"/>\
                                        <path d="M7,3 L17,3 C19.209139,3 21,4.790861 21,7 C21,9.209139 19.209139,11 17,11 L7,11 C4.790861,11 3,9.209139 3,7 C3,4.790861 4.790861,3 7,3 Z M7,9 C8.1045695,9 9,8.1045695 9,7 C9,5.8954305 8.1045695,5 7,5 C5.8954305,5 5,5.8954305 5,7 C5,8.1045695 5.8954305,9 7,9 Z" fill="#000000"/>\
                                        <path d="M7,13 L17,13 C19.209139,13 21,14.790861 21,17 C21,19.209139 19.209139,21 17,21 L7,21 C4.790861,21 3,19.209139 3,17 C3,14.790861 4.790861,13 7,13 Z M17,19 C18.1045695,19 19,18.1045695 19,17 C19,15.8954305 18.1045695,15 17,15 C15.8954305,15 15,15.8954305 15,17 C15,18.1045695 15.8954305,19 17,19 Z" fill="#000000" opacity="0.3"/>\
                                    </g>\
                                </svg>\
                            </span>\
                        </a>\
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

		//Trigger when Edit button is clicked
        datatable.on('click', '[data-record-id]', function() {
			//console.log($(this).data('record-id'));
			//console.log(objArray[id]);
			
			//Objective ID
			var id = $(this).data('record-id');
		
			//Set field values
			$('#edit-name-input').val(objArray[id].objName),
			$('#edit-level-select').val(objArray[id].level),
			
			//Call a function that handle Objective's modification
			handleFormEditOkr($(this).data('record-id'));
			
			//Show up a form modal
            $('#kt_datatable_edit_okr_modal').modal('show');
		});

		//Show Objective's Key Results Datatable
		function subTableInit(e) {
			//console.log("data : ",e.data.id);

			$('<div/>').attr('id', 'child_data_ajax_' + e.data.id).appendTo(e.detailCell).KTDatatable({
				data: {
					type: 'remote',
					source: {
						read: {
							url: '/api/datatables/objective/krs',
							params: {
								// Get Key Results by Objective ID
								objectiveId: e.data.id,
							},
						},
					},
					pageSize: 5,
					serverPaging: false,
					serverFiltering: false,
					serverSorting: false,
				},

				// layout definition
			layout: {
					scroll: false,
					footer: false,

					// enable/disable datatable spinner.
					spinner: {
						type: 1,
						theme: 'default',
					},
				},

				sortable: false,

				pagination: false,

				// columns definition
				columns: [
					{
						field: 'RecordID',
						title: '#',
						sortable: false,
						width: 30,
						template: function(row) {
							return '<span class="font-weight-bolder">' + row.krNo + '</span>';
						}
					}, {
						field: 'name',
						title: 'KEY RESULT',
						width: 100,
						template: function(row) {
							return '<div contenteditable="false">'+row.krName+'</div>';
						}
					}, {
						field: 'progress',
						title: 'PROGRESS',
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
					}],
			});
		}
    };

    var _buttonSpinnerClasses = 'spinner spinner-right spinner-white pr-15';

	//Handle a form to add Objective
	var _handleFormAddOkr = function() {

		var form = KTUtil.getById('add_okr_form');
		//var formSubmitUrl = KTUtil.attr(form, 'action');
		var formSubmitButton = KTUtil.getById('add_okr_form_submit');

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
									message: 'Objective is required'
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
				
		        FormValidation.utils.fetch('api/okr/add', {
                    method: 'POST',
                    dataType: 'json',
		            params: {
                        name: $('#add-name-input').val(),
                        no : objNo,
                        memberId: $('#memberId').val(),
						level: 'C',
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

	//Handle a form to edit an objective
    var _handleFormEditOkr = function(id) {
		var form = KTUtil.getById('edit_okr_form');
		//var formSubmitUrl = KTUtil.attr(form, 'action');
		var formSubmitButton = KTUtil.getById('edit_okr_form_submit');

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
									message: 'Objective is required'
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
				
		        FormValidation.utils.fetch('api/okr/edit', {
                    method: 'POST',
                    dataType: 'json',
		            params: { 
                        id: id,
                        name: $('#edit-name-input').val(),
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
            _handleFormAddOkr();
        },
    };
}();

//Team datatable
var TeamsListDatatable = function() {
	
	// Private functions
    // show datatable
    var _showTable = function() {
        var datatable = $('#kt_datatable_team').KTDatatable({
            // datasource definition
            data: {
                type: 'remote',
                source: {
                    read: {
						url: '/api/datatables/teams',
						params: {
                            quarter: 4,
                            year: 2020,
                        },
                    },
                },
                pageSize: 10, // display 20 records per page
                //serverPaging: true,
                //serverFiltering: true,
                //serverSorting: true,
            },

            // layout definition
            layout: {
                scroll: false, // enable/disable datatable scroll both horizontal and vertical when needed.
                footer: false, // display/hide footer
            },

            // column sorting
            sortable: true,

            pagination: true,

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
                width: 20,
                type: 'number',
                selector: false,
                textAlign: 'left',
                template: function(data) {
                    return '<span class="font-weight-bolder">' + data.id + '</span>';
                }
            },
            {
                field: 'name',
                title: 'Team',
                width: 200,
                template: function(data) {
                    var output = '';
                    var stateNo = KTUtil.getRandomInt(0, 7);
                    var states = [
                        'success',
                        'primary',
                        'danger',
                        'success',
                        'warning',
                        'dark',
                        'primary',
                        'info'];
                    var state = states[stateNo];

                    output = '<div class="d-flex align-items-center">\
                        <div class="symbol symbol-40 symbol-'+state+' flex-shrink-0">\
                            <div class="symbol-label">' + data.name.substring(0, 1) + '</div>\
                        </div>\
                        <div class="ml-2">\
                            <div class="text-dark-75 font-weight-bold line-height-sm">' + data.name + '</div>\
                        </div>\
                    </div>';
                    

                    return output;
                }
            },
            {
                field: 'progress',
                title: 'Progress',
                width: 200,
                template: function(data) {
                    return '\
							<div class="progress progress-xs mx-3 w-100">\
								<div class="progress-bar bg-success" role="progressbar" style="width: ' + data.percentage + '%;" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>\
							</div>\
						';
                }
            },
            {
                field: 'percent',
                title: '%',
                width: 30,
                template: function(data) {
                    return '<span class="font-weight-bolder text-dark">' + data.percentage + '%</span>';
                }
            },
            {
                field: 'Actions',
                title: 'Actions',
                sortable: false,
                width: 130,
                overflow: 'visible',
                autoHide: false,
                template: function(data) {
                    return '\
                        <a href="/okr/'+data.id+'" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon mr-2">\
                            <span class="svg-icon svg-icon-md">\
                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" class="svg-icon">\
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\
                                        <rect x="0" y="0" width="24" height="24"/>\
                                        <path d="M7,3 L17,3 C19.209139,3 21,4.790861 21,7 C21,9.209139 19.209139,11 17,11 L7,11 C4.790861,11 3,9.209139 3,7 C3,4.790861 4.790861,3 7,3 Z M7,9 C8.1045695,9 9,8.1045695 9,7 C9,5.8954305 8.1045695,5 7,5 C5.8954305,5 5,5.8954305 5,7 C5,8.1045695 5.8954305,9 7,9 Z" fill="#000000"/>\
                                        <path d="M7,13 L17,13 C19.209139,13 21,14.790861 21,17 C21,19.209139 19.209139,21 17,21 L7,21 C4.790861,21 3,19.209139 3,17 C3,14.790861 4.790861,13 7,13 Z M17,19 C18.1045695,19 19,18.1045695 19,17 C19,15.8954305 18.1045695,15 17,15 C15.8954305,15 15,15.8954305 15,17 C15,18.1045695 15.8954305,19 17,19 Z" fill="#000000" opacity="0.3"/>\
                                    </g>\
                                </svg>\
                            </span>\
                        </a>\
                        <a href="javascript:;" class="btn btn-sm btn-default btn-text-primary btn-hover-primary btn-icon mr-2" title="Edit details" data-record-id="' + data.id + '">\
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
			
			//a function to handle a team edit form    
            _handleFormEditTeam($(this).data('record-id'));
			
			//show a team edit modal form
			$('#kt_datatable_edit_team_modal').modal('show');
        });
    };

    var _buttonSpinnerClasses = 'spinner spinner-right spinner-white pr-15';

	//a function to handle adding team
	var _handleFormAddTeam = function() {
		var form = KTUtil.getById('add_team_form');
		//var formSubmitUrl = KTUtil.attr(form, 'action');
		var formSubmitButton = KTUtil.getById('add_team_form_submit');

		if (!form) {
			return;
		}

		FormValidation
		    .formValidation(
		        form,
		        {
		            fields: {
						okrName: {
							validators: {
								notEmpty: {
									message: 'Name is required'
								}
							}
						}
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
				
		        FormValidation.utils.fetch('/api/team/add', {
                    method: 'POST',
                    dataType: 'json',
		            params: {
                        name: $('#add_name_field').val(),
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

	//a function to handle editing team information
    var _handleFormEditTeam = function(id) {
		var form = KTUtil.getById('edit_team_form');
		//var formSubmitUrl = KTUtil.attr(form, 'action');
		var formSubmitButton = KTUtil.getById('edit_team_form_submit');

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
									message: 'Name is required'
								}
							}
						}
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
				
		        FormValidation.utils.fetch('/api/team/edit', {
                    method: 'POST',
                    dataType: 'json',
		            params: {
                        id: id,
                        name: $('#edit_name_field').val(),
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
            _showTable();
            _handleFormAddTeam();
        },
    };
}();

jQuery(document).ready(function() {
    CompanyDatatable.init();
    OkrsListDatatable.init();
    TeamsListDatatable.init();
});
