const validate_quarterly_Day = function (e) {
//   var StartDate = document.getElementById("quarterly_beginDay").value;
  var StartDate = $("#quarterly_beginDay").val();
  var EndDate = $("#quarterly_endDay").val();
  console.log(e);
//   var EndDate = document.getElementById("quarterly_endDay").value;
  //var eDate = new Date(EndDate);
  //var sDate = new Date(StartDate);
  var sDate = parseInt(StartDate);
  var eDate = parseInt(EndDate);
  if (sDate > eDate) {
    alert("The begin day must be ealier than the end day");
    // return false;
  }
//   return true;
};
const validate_monthly_Day = function () {
  var StartDate = document.getElementById("monthly_beginDay").value;
  var EndDate = document.getElementById("monthly_endDay").value;
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
  });
 

  $("#quarterly_beginDay").on("change", validate_quarterly_Day);
  $("#quarterly_endDay").on("change", validate_quarterly_Day);
  $("#monthly_beginDay").on("change", validate_quarterly_Day);
  $("#monthly_endDay").on("change", validate_quarterly_Day);


});

