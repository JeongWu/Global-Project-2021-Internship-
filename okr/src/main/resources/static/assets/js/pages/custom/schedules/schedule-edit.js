const validate_Day = function () {
  console.log($(this))
  var StartDate = $("#quarterly_beginDay").val();
  var EndDate = $("#quarterly_endDay").val();

  var sDate = parseInt(StartDate);
  var eDate = parseInt(EndDate);
  if (sDate > eDate) {
    alert("The begin day must be ealier than the end day");
    $(this).val("");
  }
};

const validate_monthly_Day = function () {
  var StartDate = $("#monthly_beginDay").val();
  var EndDate = $("#monthly_endDay").val();
  var sDate = parseInt(StartDate);
  var eDate = parseInt(EndDate);
  if (StartDate != "" && StartDate != "" && sDate > eDate) {
    alert("The begin day must be ealier than the end day");
    // return false;
  }
//   return true;
};



jQuery(document).ready(function () {

 
  $("#quarterly_select").val($("#quarterly_input").val().split(","));
  $("#monthly_select").val($("#monthly_input").val().split(","));
  $("#weekly_select").val($("#weekly_input").val().split(","));
  $("#quarterly_select,#monthly_select,#weekly_select").select2({
    placeholder: "Select..",
    maximumSelectionLength: 3
  });

  $("#quarterly_beginDay").on("change", validate_Day);
  $("#quarterly_endDay").on("change", validate_Day);
  $("#monthly_beginDay").on("change", validate_Day);
  $("#monthly_endDay").on("change", validate_Day);

  $("#quarterly_select,#monthly_select,#weekly_select").on("select2:unselecting", function(){
    //confirm 추가하기
    alert('Are you sure?');
  });


});

