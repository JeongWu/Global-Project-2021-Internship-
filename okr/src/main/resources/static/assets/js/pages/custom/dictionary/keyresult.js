"use strict";


var KTDatatableModal = (function () {

  var initSubDatatable = function () {

    var el = $("#kt_datatable_sub");
    var datatable = el.KTDatatable({
      data: {
        type: "remote",
        source: {
          read: {
            url: "/api/dictionary/keyResult/datatables",
          },
        },
        pageSize: 10,
      },

      // layout definition
      layout: {
        theme: "default",
        scroll: true,
        height: 350,
        footer: false,
      },

      sortable: true,
      search: {
        // search delay in milliseconds
        delay: 400,
      },
      // columns definition
      // layout definition
      layout: {
        scroll: false, // enable/disable datatable scroll both horizontal and vertical when needed.
        footer: false, // display/hide footer
      },

      // column sorting
      sortable: true,

      pagination: true,

      // columns definition
      columns: [
        {
          field: "dictionarySeq",
          title: "#",
          sortable: "asc",
          width: 20,

        },
        {
          field: "jobType",
          title: "JOB",
          textAlign:"center",
          width: 70,
      
        },

        {
          field: "sentence",
          title: "KEY RESULT",
          textAlign:"center",
          width: 120,
      
        },

        {
          field: "taskType",
          title: "",
          sortable: false,
          textAlign:"center",
          width: 70,
      
        },
        {
          field: "taskMetric",
          title: "PROPERTIES",
          sortable: false,
          textAlign:"center",
          width: 90,
     
        },
        {
          field: "taskIndicator",
          title: "",
          sortable: false,
          textAlign:"center",
          width: 70,
      
        },

        {
          field: "Actions",
          title: "Actions",
          sortable: false,
          textAlign:"center",
          width: 70,
       
          template: function (data) {
            return '\
                    <div class="dropdown dropdown-inline">\
                    <a href="javascript:;" class="btn btn-sm btn-light btn-text-primary btn-icon mr-2" data-toggle="dropdown">\
                    <i class="flaticon2-check-mark"></i>\
                </a>\
                      </div>\
                    ';
          },
        },
      ],
    });

    var modal = $('#kt_datatable_modal');

    $("#kt_datatable_search_sentence").on("change keyup paste", function () {
      datatable.search($(this).val().toLowerCase(), "sentence");
    });

    $("#kt_datatable_search_jobType").on("change", function () {
      datatable.search($(this).val().toLowerCase(), "jobType");
    });

    $(
      "#kt_datatable_search_sentence, #kt_datatable_search_jobType",
    ).selectpicker();

    $("#kt_search").on("click", function (e) {});

    $("#kt_reset").on("click", function (e) {
      e.preventDefault();

      datatable.setDataSourceParam("query", {});
      $(".datatable-input").each(function () {
        $(this).val("").change();
      });
    });

     // fix datatable layout after modal shown
     datatable.hide();
     var alreadyReloaded = false;
     modal.on('shown.bs.modal', function() {
         if (!alreadyReloaded) {
             var modalContent = $(this).find('.modal-content');
             datatable.spinnerCallback(true, modalContent);

             datatable.reload();

             datatable.on('datatable-on-layout-updated', function() {
                 datatable.show();
                 datatable.spinnerCallback(false, modalContent);
                 datatable.redraw();
             });

             alreadyReloaded = true;
         }
     });
  };

  return {
    init: function () {
    initSubDatatable();
    },
  };
})();

jQuery(document).ready(function () {
  KTDatatableModal.init();
});
