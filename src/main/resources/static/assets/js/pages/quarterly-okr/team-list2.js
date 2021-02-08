"use strict";
// Class definition

var KTAppsProjectsListDatatable = (function () {
  // Private functions

  // basic demo
  var makeTeamListTable = function () {
    var datatable = $("#kt_datatable").KTDatatable({
      // datasource definition
      data: {
        type: "remote",
        source: {
          read: {
            url: "/get-team-data",
            map: function (raw) {
              var dataSet = raw;

              if (typeof raw.data !== "undefined") {
                dataSet = raw.data;
              }
              console.log(dataSet);
              var data=dataSet.map(i=>i.divisionName);
              var list=new Set(data);
              list.forEach(function(d){
                $('.datatable-input[data-col-index="1"]').append('<option value="' + d + '">' + d + '</option>');
              }

              );
              $('#kt_subheader_total').append(dataSet.length+' Total');

   
              
              return dataSet;
            },
            // params: {
            //   name: "TEAM 1",
            // },
          },
        },
        // pageSize: 10, // display 20 records per page
        // serverPaging: false,
        // serverFiltering: false,
        // serverSorting: false,
      },

      // layout definition
      layout: {
        scroll: false, // enable/disable datatable scroll both horizontal and vertical when needed.
        footer: false, // display/hide footer
      },

      // column sorting
      sortable: true,
      filterable: true,
      pagination: true,

      // search: {
      //   input: $("#kt_datatable_search_name"),
      //   delay: 400,
      //   key: "generalSearch",
      // },

      // columns definition
      columns: [
        {
          field: "teamSeq",
          title: "#",
          sortable: "asc",
          width: 20,
          type: "number",
          selector: false,
          textAlign: "left",
          template: function (data) {
            console.log(data);
            return (
              '<span class="font-weight-bolder">' + data.teamSeq + "</span>"
            );
          },
        },
        {
          field: "name",
          title: "Team",
          width: 130,
          template: function (data) {
            var output = "";

            var teamImg = data.image;
            var teamName = data.name;

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

            if (teamImg === null) {
              output =
                '<div class="d-flex align-items-center">\
                        <div class="symbol symbol-40 symbol-' +
                state +
                ' flex-shrink-0">\
                            <div class="symbol-label">' +
                teamName.substring(0, 1) +
                '</div>\
                        </div>\
                        <div class="ml-2">\
                            <div class="text-dark-75 font-weight-bold line-height-sm">' +
                teamName +
                "</div>\
                        </div>\
                    </div>";

              return output;
            } else {
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
            <div class="symbol-label" style="' +
                "background-image:url(" +
                teamImg +
                ")" +
                '"></div>\
                      </div>\
                      <div class="ml-2">\
                          <div class="text-dark-75 font-weight-bold line-height-sm">' +
                teamName +
                "</div>\
                      </div>\
                  </div>";

              return output;
            }
          },
        },

        {
          field: "divisionName",
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
          field: "teamType",
          title: "Team Type",
          width: 60,
          autoHide: false,
          // callback function support for column rendering
          template: function (data) {
            var status = {
              1: {
                title: "TEAM",
                class: "label-light-primary",
              },
              2: {
                title: "SQUAD",
                class: " label-light-danger",
              },
              3: {
                title: "TFT",
                class: " label-light-success",
              },
            };

            var statusNo = 1;
            if (data.teamType === "SQUAD") statusNo = 2;
            else if (data.teamType === "TFT") statusNo = 3;

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
          field: "teamManager",
          title: "TEAM MANGER",
          width: 60,
          template: function (data) {
            var output = "";

            // console.log(data.leaderOrManager);

            var managerInfo = data.teamManager;

            if (managerInfo !== null) {
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
              // if (managerInfo.image === null) {
              output =
                '<div class="d-flex align-items-center">\
                  <div class="symbol symbol-40 symbol-circle symbol-light-' +
                state +
                ' flex-shrink-0">\
                          <span class="symbol-label font-size-h4">' +
                data.name.substring(0, 1) +
                "</span>\
                      </div>\
                                  </div>";
            } else {
              output +=
                '<div class="font-weight-bolder font-size-lg mb-0">' +
                data.name +
                "</div>";
            }

            return output;
          },
        },
        {
          field: "members",
          title: "MEMBERS",
          width: 130,
          template: function (data) {
            //add function no image for memeber
            //add href member list

            var output = "";

            // var user_img = "assets/media/users/100_2.jpg";

            output =
              '<div class="d-flex align-items-center">\
            <div class="symbol-group symbol-hover">';

            var memberList = data.teamMembers;
            console.log(memberList);
            // if (memberList.length === 0) {
            //   memberList = [
            //     { name: "Jane", image: "assets/media/users/100_2.jpg" },
            //     { name: "Bob", image: "assets/media/users/100_2.jpg" },
            //     { name: "Chris", image: "assets/media/users/100_2.jpg" },
            //     { name: "Tom", image: "assets/media/users/100_2.jpg" },
            //     { name: "Amy", image: "assets/media/users/100_2.jpg" },
            //     { name: "member1", image: "assets/media/users/100_2.jpg" },
            //   ];
            // }

            if (memberList.length > 4) {
              memberList.forEach((member, index) => {
                if (index < 4) {
                  output +=
                    '<div class="symbol symbol-30 symbol-circle" data-toggle="tooltip" title="' +
                    member.name +
                    '">\
                <img class="" src=    "assets/media/users/100_2.jpg" alt="photo">\
                </div>';
                }
              });
              output +=
                ' <div class="symbol symbol-30 symbol-circle symbol-light">\
              <span class="symbol-label font-weight-bold"> +' +
                (memberList.length - 4) +
                "</span>\
          </div>\
          </div>\
    </div>";
            } else {
              memberList.forEach((member) => {
                output +=
                  '<div class="symbol symbol-30 symbol-circle" data-toggle="tooltip" title="' +
                  member.name +
                  '">\
                <img class="" src=    "assets/media/users/100_2.jpg" alt="photo">\
                </div>';
              });

              output += "</div>\
              </div>";
            }

            // console.log(output);

            return output;
          },
        },
        {
          field: "useFlag",
          title: "Active",
          width: 70,
          // callback function support for column rendering
          template: function (data) {
            var status = {
              1: { title: "Active", state: "success" },
              2: {
                title: "inActive",
                state: "danger",
              },
            };
            var statusNo = data.useFlag === "Y" ? 1 : 2;
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
          field: "Actions",
          title: "Actions",
          sortable: false,
          width: 70,
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

    // $("#kt_datatable_search_name").on("propertychange change keyup paste input", function () {
    $("#kt_datatable_search_name").on("change keyup paste", function () {
      console.log("name search");
      datatable.search($(this).val().toLowerCase(), "name");
    });

    $("#kt_datatable_search_division").on("change", function () {
      console.log("division search");
      // console.log($(this).val().toLowerCase(), "division.name");
      datatable.search($(this).val().toLowerCase(), "divisionName");
    });

    $("#kt_datatable_search_type").on("change", function () {
      // datatable.search($(this).val().toLowerCase(), "Type");
      console.log("type search");
      // console.log($(this).val().toLowerCase());
      datatable.search($(this).val().toLowerCase(), "teamType");
    });
    $("#kt_datatable_search_active").on("change", function () {
      console.log("active search");
      datatable.search($(this).val().toLowerCase(), "useFlag");
    });

    $(
      "#kt_datatable_search_division, #kt_datatable_search_type",
      "#kt_datatable_search_active"
    ).selectpicker();

    //search button
    $("#kt_search").on("click", function (e) {
      $(".datatable-input").each(function () {
        datatable
          .column($(this).data("col-index"))
          .search($(this).val().toLowerCase(), $(this).attr("name"));
      });
    });

    //reset button
    $("#kt_reset").on("click", function (e) {
      e.preventDefault();

      datatable.setDataSourceParam("query", {});
      $(".datatable-input").each(function () {
        $(this).val("").change();
      });
      // datatable.reload();
    });

    //excel download button
    $("#excelBtn").click(function () {
      $("#kt_datatable").table2excel({
        name: "Excel table",
        filename: "team table",
        fileext: ".xls",
        preserveColors: true,
        exclude_img: true,
        exclude_links: true,
        exclude_inputs: true,
      });
    });
  };

  return {
    // public functions
    init: function () {
      makeTeamListTable();
    },
  };
})();

jQuery(document).ready(function () {
  KTAppsProjectsListDatatable.init();
});
