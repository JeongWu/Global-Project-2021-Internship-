$(document).ready(function () {
    let action = '';
    const table = $('#keyResultTable').DataTable({paging: false, info: false, filter: false, ordering: false});
    const objectiveLevels = JSON.parse(localStorage.getItem('objLevels'));
    const taskTypes = JSON.parse(localStorage.getItem('taskTypes'));
    const taskMetrics = JSON.parse(localStorage.getItem('taskMetrics'));
    const taskIndicators = JSON.parse(localStorage.getItem('taskIndicators'));

    function addKeyResult() {
        var rowNode = table.row.add([
            //init a blank select, options will be added later
            '<div class="form-group"><select class="custom-select objective-level">\
                <option value="">Level</option>\
            </select></div>\
            ',
            '<div class="form-group"><input type="text" class="key-result form-control w-100"></div>',
            '<div class="row form-group justify-content-center">\
                <select class="custom-select col mr-2 task-type" style="width: 33%">\
                    <option selected="selected" value="">Task Type</option>\
                </select>\
                <select class="custom-select col mr-2 task-metric" style="width: 33%">\
                    <option selected="selected" value="">Task Metric</option>\
                </select>\
                <select class="custom-select col mr-2 task-indicator" style="width: 33%">\
                    <option selected="selected" value="">Task Indicator</option>\
                </select>\
            </div>',
            '\
            <div class="form-group dropdown dropdown-inline" data-toggle="tooltip" title="" data-placement="left"\
                        data-original-title="Quick actions">\
                    <button type="button" class="btn btn-clean btn-hover-light-primary btn-sm btn-icon search-key-result" data-toggle="modal" data-target="#kt_datatable_modal_keyresult">\
                        <i class="flaticon2-search"></i>\
                    </button>\
            </div>'

        ]).draw(true).node();
        $(rowNode).addClass('row-key-result');
        // initialize select options for select, add a class called 'initialized' to mark it as no need to initialize next time user click the + button
        $('.objective-level').not('.initialized').each(function () {
            $(this).addClass('initialized');
            const select = $(this);
            $.each(objectiveLevels, function (index, level) {
                select.append($("<option></option>").attr('value', level.code).text(level.codeName));
            })
        })
        $('.task-type').not('.initialized').each(function () {
            $(this).addClass('initialized');
            const select = $(this);
            $.each(taskTypes, function (index, taskType) {
                select.append($("<option></option>").attr('value', taskType.code).text(taskType.codeName));
            })
        })
        $('.task-metric').not('.initialized').each(function () {
            $(this).addClass('initialized');
            const select = $(this);
            $.each(taskMetrics, function (index, taskMetric) {
                select.append($("<option></option>").attr('value', taskMetric.code).text(taskMetric.codeName));
            })
        })
        $('.task-indicator').not('.initialized').each(function () {
            $(this).addClass('initialized');
            const select = $(this);
            $.each(taskIndicators, function (index, taskIndicator) {
                select.append($("<option></option>").attr('value', taskIndicator.code).text(taskIndicator.codeName));
            })
        })
    }

    // add 3 rows by default
    for (let i = 1; i < 4; i++) {
        addKeyResult();
    }

    let fv = initializeFormValidation();

    $('#btnAddKeyResult').on('click', function () {
        addKeyResult();
        fv.resetForm(false);
        $('#formOKRs div.fv-plugins-message-container').remove();
        fv = initializeFormValidation();//re-initialize form validation to apply to newly added row
    });

    $('.submit-option').on('click', function () {
        action = $(this).val();
    })

    function initializeFormValidation() {
        return FormValidation.formValidation(
            document.getElementById('formOKRs'),
            {
                fields: {
                    objective: {
                        validators: {
                            notEmpty: {
                                message: 'Please type in objective'
                            }
                        }
                    },
                    levelSelectOption: {
                        selector: 'select.objective-level',
                        validators: {
                            notEmpty: {
                                message: 'Please select'
                            }
                        }
                    },
                    keyResults: {
                        selector: 'input.key-result',
                        validators: {
                            notEmpty: {
                                message: 'Key Result is required'
                            }
                        }
                    }
                },
                plugins: {
                    trigger: new FormValidation.plugins.Trigger(),
                    bootstrap: new FormValidation.plugins.Bootstrap(),
                    submitButton: new FormValidation.plugins.SubmitButton(),
                }
            }
        ).on('core.form.valid', function () {
            const year = $('#year').val();
            const quarter = $('#quarter').val();
            const objective = $('#objective').val();
            var keyResults = [];
            $('tr.row-key-result').each(function () {
                const level = $(this).find('select.objective-level').val();
                const kresult = $(this).find('input.key-result').val();
                const taskType = $(this).find('select.task-type').val();
                const taskMetric = $(this).find('select.task-metric').val();
                const taskIndicator = $(this).find('select.task-indicator').val();
                var keyResult = {
                    objectiveLevel: level,
                    keyResult: kresult,
                    taskType: taskType,
                    taskMetric: taskMetric,
                    taskIndicator: taskIndicator
                };
                keyResults.push(keyResult);
            })

            $.ajax({
                url: '/company/okrs/add',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    year: year,
                    quarter: quarter,
                    objective: objective,
                    key_results: keyResults
                }),
                success: function (result) {
                    if (result.success) {
                        if (action === 'saveAndAddNew') {
                            window.location.href = '/company/okrs/add';
                        } else if (action === 'saveAndRelation') {
                            window.location.href = '/';
                        } else if (action === 'saveAndExit') {
                            window.location.href = '/';
                        }
                    }
                }
            })
        });
    }

    KTDatatableModalForKeyResult.init();
    $(".search-key-result").on("click",function(){
        var rowIndex=$(this).closest('tr').index();
        localStorage.setItem("index",rowIndex)
    })
})
