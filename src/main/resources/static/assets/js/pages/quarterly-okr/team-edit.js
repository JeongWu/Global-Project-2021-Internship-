"use strict";

// Class definition
var KTUserEdit = (function () {
  // Base elements
  var avatar;

  var initUserForm = function () {
    avatar = new KTImageInput("kt_user_edit_avatar");
  };

//   $.ajax({
// 	url: '/get-team-data'+id,
// 	type: "GET",
// 	dataType: "json",
// 	data: data,
// 	success: function(data) {
// 		console.log(data);
// 	}, error: function(request,status,error) {
// 		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
// 	}
// 	});
$("#submitBtn").click(function (e) {
    e.preventDefault();
    console.log("submit event!!")
    $("#kt_form").submit();
});


//   $("#submitBtn").click(function (e) {
//     e.preventDefault();
//     var id = $("#teamSeq").val();
//     // var edit_id = $(this).data('id');
//     console.log($("#teamSeq").val());
//     console.log($("#image").val());
//     console.log($("#introduction").val());

//     var params = {
//   image: $("#image").val(),
//       introduction: $("#introduction").val(),
//     };

//     $.ajax({
//       url: "/api/team/edit/" + id,
//       type: "POST",
//       dataType: "json",
//       contentType: "application/json; charset=utf-8",
//       data: JSON.stringify(params),
//       success: function (data) {
//         console.log("Submission was successful.");
//         console.log(data);
//       },
//       error: function (data) {
//         console.log("An error occurred.");
//         console.log(data);
//       },
//     });
//   });

  return {
    // public functions
    init: function () {
      initUserForm();
    },
  };
})();

jQuery(document).ready(function () {
  KTUserEdit.init();
});
