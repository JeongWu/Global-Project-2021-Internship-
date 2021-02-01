"use strict";
// Class definition

var KTAppsProjectsListDatatable = (function () {
  // Private functions

  // basic demo
  var _demo = function () {
    var datatable = $("#kt_datatable").KTDatatable({
      // datasource definition
      data: {
        type: "remote",
        source: {
          read: {
            url:"/api/datatables/team"
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
      sortable: true,

      pagination: true,

      search: {
        input: $("#kt_datatable_search_query"),
        delay: 400,
        key: "generalSearch",
      },

      // columns definition
      columns: [
        {
          field: "TEAM_SEQ",
          title: "#",
          sortable: "asc",
          width: 40,
          type: "number",
          selector: false,
          textAlign: "left",
          template: function (data) {
            return (
              '<span class="font-weight-bolder">' + data.teamSeq + "</span>"
            );
          },
        },
        {
          field: "NAME",
          title: "Team",
          width: 200,
          template: function (data) {
            var output = "";
            var stateNo = KTUtil.getRandomInt(0, 7);
            var states = [
              "success",
              "primary",
              "danger",
              "success",
              "warning",
              "dark",
              "primary",
              "info",
            ];
            var state = states[stateNo];

            output =
              '<div class="d-flex align-items-center">\
                        <div class="symbol symbol-40 symbol-' +
              state +
              ' flex-shrink-0">\
                            <div class="symbol-label">' +
              data.name.substring(0, 1) +
              '</div>\
                        </div>\
                        <div class="ml-2">\
                            <div class="text-dark-75 font-weight-bold line-height-sm">' +
              data.name +
              "</div>\
                        </div>\
                    </div>";

            return output;
          },
        },

        {
          field: "Division",
          title: "Division",
          template: function (data) {
            var output = "";

            output +=
              '<div class="font-weight-bolder font-size-lg mb-0">' +
              data.division.name +
              "</div>";

            return output;
          },
        },
        {
          field: "Type",
          title: "TEAM Type",
          autoHide: false,
          // callback function support for column rendering
          template: function (data) {
            var status = {
              1: {
                title: "TEAM",
                state: "danger",
              },
              2: {
                title: "SQUAD",
                state: "primary",
              },
              3: {
                title: "TFT",
                state: "success",
              },
            };
           
            var statusNo=1;
            if(data.teamType==="SQUAD")
            statusNo=2;
            else if(data.teamType==="TFT")
            statusNo=3;

            return (
              '<span class="label label-' +
              status[statusNo].state +
              ' label-dot mr-2"></span><span class="font-weight-bold text-' +
              status[statusNo].state +
              '">' +
              status[statusNo].title +
              "</span>"
            );
          },
        },
        {
            field: "TEAM_MANAGER",
            title: "TEAM MANGER",
            template: function(data) {
                var number = KTUtil.getRandomInt(1, 14);
                var user_img = '100_' + number + '.jpg';

                var output = '';
                if (number > 8) {
                    output = '<div class="d-flex align-items-center">\
                    <div class="symbol symbol-40 symbol-circle  symbol-sm flex-shrink-0">\
                            <img class="" src="assets/media/users/' + user_img + '" alt="photo">\
                        </div>\
                                           </div>';
                }
                else {
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
                    <div class="symbol symbol-40 symbol-circle symbol-light-' +state+' flex-shrink-0">\
                            <span class="symbol-label font-size-h4">' + data.name.substring(0, 1) + '</span>\
                        </div>\
                                    </div>';
                }

                return output;
            }
        },
        {
            field: "MEMBERS",
            title: "MEMBERS",
            template: function(data) {
                var number = KTUtil.getRandomInt(1, 14);
                var user_img = '100_' + number + '.jpg';

                var output = '';
                if (number > 8) {
                    output = '<div class="d-flex align-items-center">\
                    <div class="symbol symbol-40 symbol-circle  symbol-sm flex-shrink-0">\
                            <img class="" src="assets/media/users/' + user_img + '" alt="photo">\
                        </div>\
                                           </div>';
                }
                else {
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
                    <div class="symbol symbol-40 symbol-circle symbol-light-' +state+' flex-shrink-0">\
                            <span class="symbol-label font-size-h4">' + data.name.substring(0, 1) + '</span>\
                        </div>\
                                    </div>';
                }

                return output;
            }
        },
        {
          field: "Status",
          title: "Active",
          // callback function support for column rendering
          template: function (data) {
            var status = {
              1: {
                title: "Active",
                class: "label-light-primary",
              },
              2: {
                title: "inActive",
                class: " label-light-danger",
              },
              // 3: {
              //   title: "Canceled",
              //   class: " label-light-primary",
              // },
              // 4: {
              //   title: "Success",
              //   class: " label-light-success",
              // },
              // 5: {
              //   title: "Info",
              //   class: " label-light-info",
              // },
              // 6: {
              //   title: "Danger",
              //   class: " label-light-danger",
              // },
              // 7: {
              //   title: "Warning",
              //   class: " label-light-warning",
              // },
            };
            var statusNo=data.useFlag==='Y'?1:2;
            return (
              '<span class="label font-weight-bold label-lg ' +
              status[statusNo].class +
              ' label-inline label-bold">' +
              status[statusNo].title +
              "</span>"
            );
          },
        },
        {
          field: "Actions",
          title: "Actions",
          sortable: false,
          width: 125,
          overflow: "visible",
          autoHide: false,
          template: function () {
            return '\
                    <div class="dropdown dropdown-inline">\
                    <a href="javascript:;" class="btn btn-sm btn-light btn-text-primary btn-icon mr-2" data-toggle="dropdown">\
                    <i class="flaticon-more-1"></i>\
                </a>\
                      <div class="dropdown-menu dropdown-menu-sm dropdown-menu-right">\
                        <ul class="nav nav-hoverable flex-column">\
                            <li class="nav-item"><a class="nav-link" href="#"><i class="nav-icon la la-edit"></i><span class="nav-text">Edit Details</span></a></li>\
                            <li class="nav-item"><a class="nav-link" href="#"><i class="nav-icon la la-refresh"></i><span class="nav-text">Change Members</span></a></li>\
                            <li class="nav-item"><a class="nav-link" href="#"><i class="nav-icon la la-cog"></i><span class="nav-text">Set Team Manager</span></a></li>\
                            <li class="nav-item"><a class="nav-link" href="#"><i class="nav-icon la la-eye"></i><span class="nav-text">View History</span></a></li>\
                        </ul>\
                      </div>\
                </div>\
                    ';
          },
        },
      ],
    });
  };

  return {
    // public functions
    init: function () {
      _demo();
    },
  };
})();

jQuery(document).ready(function () {
  KTAppsProjectsListDatatable.init();
});
