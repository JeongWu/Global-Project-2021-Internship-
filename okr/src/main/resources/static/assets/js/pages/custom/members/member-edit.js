
jQuery(document).ready(function() {

    $(document).on('change', "[name='useFlag']", function(){
        var memberSeq = $('#memberSeq').val();
        var checkListSeq = $(this).attr('name');
         if (!$(this).is(':checked')){
            let answer = confirm("오늘 날짜로 해당 직원이 속한 조직에서 제외됩니다. 진행하시겠습니까?");
            if (answer){
            $.ajax({
                    url: "/members/eidt-flag",
                    type: "POST",
                    cache: false,
                    dataType: "json",
                    data: {'memberSeq' : memberSeq},
                    success: function(data) {
                        console.log("success");
                    },
                    error: function(err) {
                        alert("error!");
                        console.log(err);
                    }                    
            });                  
             }
            }
        
    });
});