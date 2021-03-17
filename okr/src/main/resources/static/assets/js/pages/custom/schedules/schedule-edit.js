const validate_quarterly_Day = function(){
	var StartDate= document.getElementById('quarterly_beginDay').value;
 	var EndDate= document.getElementById('quarterly_endDay').value;
 	//var eDate = new Date(EndDate);
 	//var sDate = new Date(StartDate);
 	var sDate = parseInt(StartDate);
 	var eDate = parseInt(EndDate);
	if(sDate > eDate){
    	 alert("The begin day must be ealier than the end day");
			return false;
	}
    return true;
}
const validate_monthly_Day = function(){
	var StartDate= document.getElementById('monthly_beginDay').value;
 	var EndDate= document.getElementById('monthly_endDay').value;
 	var sDate = parseInt(StartDate);
 	var eDate = parseInt(EndDate);
	if(StartDate!= '' && StartDate!= '' && sDate> eDate){
    	 alert("The begin day must be ealier than the end day");
			return false;
	}
    return true;
}



				
const remindBeforeList = function(){
		var data = [];
		for(var i=1; i<parseInt(document.getElementById('quarterly_closeAfterDays').value); i++){
				data += i+",";
				}
				dataArray = data.split(',');
				return dataArray;
				}

document.getElementById('quarterly_beginDay').addEventListener('change', validate_quarterly_Day, false);
document.getElementById('quarterly_endDay').addEventListener('change', validate_quarterly_Day, false);
document.getElementById('monthly_beginDay').addEventListener('change', validate_monthly_Day, false);
document.getElementById('monthly_endDay').addEventListener('change', validate_monthly_Day, false);
//document.getElementById('quarterly_closeAfterDays').addEventListener('change', remindBeforeList, false);


// Class definition
var KTTagifyDemos = function() {
    
	var quarterly_dataList = function(){
		var data = [];
		var dataArray = [];
			for(var i=1; i<parseInt(document.getElementById('quarterly_closeAfterDays').value); i++){
				data += i+",";
				}
				dataArray = data.split(',');
			return dataArray;
		};
	var monthly_dataList = function(){
		var data = [];
		var dataArray = [];
			for(var i=1; i<parseInt(document.getElementById('monthly_closeAfterDays').value); i++){
				data += i+",";
				}
				dataArray = data.split(',');
			return dataArray;
		};
	
	var demoQ = function() {
        var input = document.querySelector('input[id=remindBeforeDaysQuarterly]')
		var tagify = new Tagify(input,{
            enforceWhitelist: true,
			whitelist: quarterly_dataList(),
			maxTags: 3,
			dropdown: {
				position: "input",
  				maxItems: 14,           
  				enabled: 0,             
  				closeOnSelect: true    
				}
            });
		
			

        // "remove all tags" button event listener
        document.getElementById('kt_tagify_1_remove').addEventListener('click', tagify.removeAllTags.bind(tagify));
		
 //       document.getElementById('kt_tagify_1_add').addEventListener('click', tagify.addSelected.bind(tagify));
        
// Chainable event listeners
        tagify.on('add', onAddTag)
            .on('remove', onRemoveTag)
            .on('input', onInput)
            .on('edit', onTagEdit)
            .on('invalid', onInvalidTag)
            .on('click', onTagClick)
            .on('dropdown:show', onDropdownShow)
            .on('dropdown:hide', onDropdownHide)
			.on('dropdown:select', onSelectSuggestion)
	
		
        // tag added callback
        function onAddTag(e) {
            console.log("onAddTag: ", e.detail);
            //console.log("original input value: ", index.value)
            tagify.off('add', onAddTag) // exmaple of removing a custom Tagify event
        }

        // tag remvoed callback
        function onRemoveTag(e) {
            console.log(e.detail);
            console.log("tagify instance value:", tagify.value)
			
        }

        // on character(s) added/removed (user is typing/deleting)
        function onInput(e) {
			console.log(e.detail);
            console.log("onInput: ", e.detail);
			if(e<document.getElementById('quarterly_closeAfterDays').value){
				return e;
			}else{
				return false;
				}
        }

        function onTagEdit(e) {
            console.log("onTagEdit: ", e.detail);
        }

        // invalid tag added callback
        function onInvalidTag(e) {
            console.log("onInvalidTag: ", e.detail);
            tagify.off('add', onAddTag) // exmaple of removing a custom Tagify event

        }

        // invalid tag added callback
        function onTagClick(e) {
            console.log(e.detail);
            console.log("onTagClick: ", e.detail);
        }

        function onDropdownShow(e) {
			KTTagifyDemos.reload();
            console.log("onDropdownShow: ", e.detail)
        }

        function onDropdownHide(e) {
            console.log("onDropdownHide: ", e.detail)
        }

        function onSelectSuggestion(e) {
            console.log("onSelectSuggestion: ", e.detail)
        }
	} //end of demoQ

	
	var demoM = function() {
        var input = document.querySelector('input[id=remindBeforeDaysMonthly]')
            // init Tagify script on the above inputs
		var tagify = new Tagify(input,{
            enforceWhitelist: true,
			whitelist: monthly_dataList(),
			maxTags: 3,
			dropdown: {
				position: "input",
  				maxItems: 14,           
  				enabled: 0,             
  				closeOnSelect: true    
				}
            })
		
        // "remove all tags" button event listener
        document.getElementById('kt_tagify_2_remove').addEventListener('click', tagify.removeAllTags.bind(tagify));
		
        
// Chainable event listeners
        tagify.on('add', onAddTag)
            .on('remove', onRemoveTag)
            .on('input', onInput)
            .on('edit', onTagEdit)
            .on('invalid', onInvalidTag)
            .on('click', onTagClick)
            .on('dropdown:show', onDropdownShow)
            .on('dropdown:hide', onDropdownHide)
			.on('dropdown:select', onSelectSuggestion)
	
		
        // tag added callback
        function onAddTag(e) {
            console.log("onAddTag: ", e.detail);
            //console.log("original input value: ", index.value)
            tagify.off('add', onAddTag) // exmaple of removing a custom Tagify event
        }

        // tag remvoed callback
        function onRemoveTag(e) {
            console.log(e.detail);
            console.log("tagify instance value:", tagify.value)
        }

        // on character(s) added/removed (user is typing/deleting)
        function onInput(e) {
			console.log(e.detail);
            console.log("onInput: ", e.detail);
			if(e<document.getElementById('monthly_closeAfterDays').value){
				return e;
			}else{
				return false;
				}
        }

        function onTagEdit(e) {
            console.log("onTagEdit: ", e.detail);
        }

        // invalid tag added callback
        function onInvalidTag(e) {
            console.log("onInvalidTag: ", e.detail);
        }

        // invalid tag added callback
        function onTagClick(e) {
            console.log(e.detail);
            console.log("onTagClick: ", e.detail);
        }

        function onDropdownShow(e) {
            console.log("onDropdownShow: ", e.detail)
        }

        function onDropdownHide(e) {
            console.log("onDropdownHide: ", e.detail)
        }

        function onSelectSuggestion(e) {
            console.log("onSelectSuggestion: ", e.detail)
        }
    }

    var modalDemos = function() {
        $('#kt_select2_modal').on('shown.bs.modal', function () {
         
            // multi select
            $('#kt_select2_3_modal').select2({
                placeholder: "Select a state",
            });
    
        });
    }
    // Private functions
    var demoW = function() {
        var input = document.querySelector('input[id=remindBeforeDaysWeekly]')
            // init Tagify script on the above inputs
		var tagify = new Tagify(input,{
            enforceWhitelist: true,
			whitelist: ["1", "2", "3", "4", "5", "6"],
			maxTags: 3,
			dropdown: {
				position: "input",
  				maxItems: 14,           
  				enabled: 0,             
  				closeOnSelect: true    
				}
            })

		
        // "remove all tags" button event listener
        document.getElementById('kt_tagify_3_remove').addEventListener('click', tagify.removeAllTags.bind(tagify));
		
        
// Chainable event listeners
        tagify.on('add', onAddTag)
            .on('remove', onRemoveTag)
            .on('input', onInput)
            .on('edit', onTagEdit)
            .on('invalid', onInvalidTag)
            .on('click', onTagClick)
            .on('dropdown:show', onDropdownShow)
            .on('dropdown:hide', onDropdownHide)
			.on('dropdown:select', onSelectSuggestion)
	
		
        // tag added callback
        function onAddTag(e) {
            console.log("onAddTag: ", e.detail);
            //console.log("original input value: ", index.value)
            tagify.off('add', onAddTag) // exmaple of removing a custom Tagify event
        }

        // tag remvoed callback
        function onRemoveTag(e) {
            console.log(e.detail);
            console.log("tagify instance value:", tagify.value)
        }

        // on character(s) added/removed (user is typing/deleting)
        function onInput(e) {
            console.log(e.detail);
            console.log("onInput: ", e.detail);
        }

        function onTagEdit(e) {
            console.log("onTagEdit: ", e.detail);
        }

        // invalid tag added callback
        function onInvalidTag(e) {
            console.log("onInvalidTag: ", e.detail);
        }

        // invalid tag added callback
        function onTagClick(e) {
            console.log(e.detail);
            console.log("onTagClick: ", e.detail);
        }

        function onDropdownShow(e) {
            console.log("onDropdownShow: ", e.detail)
        }

        function onDropdownHide(e) {
            console.log("onDropdownHide: ", e.detail)
        }

        function onSelectSuggestion(e) {
            console.log("onSelectSuggestion: ", e.detail)
        }
    }

    return {
        // public functions
        init: function() {
			validate_quarterly_Day();
			validate_monthly_Day();
			quarterly_dataList();
			monthly_dataList();
			demoQ();
            demoM();
			demoW();
            modalDemos();
        },
		reload: function(){
			quarterly_dataList();
			monthly_dataList();
		}
    };
}();

jQuery(document).ready(function() {
    KTTagifyDemos.init();
});
$('#quarterly_closeAfterDays').on("change",function(){
	KTTagifyDemos.reload();
});	
$('#monthly_closeAfterDays').on("change",function(){
	KTTagifyDemos.reload();
});	

  // multi select
  $('#kt_select2_3, #kt_select2_3_validate').select2({
    placeholder: 'Select..',
});