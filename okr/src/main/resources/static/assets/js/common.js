function buildPageSizeSelection(){
    let baseUrl = document.getElementById("base-url").value;
    let pageSize = document.getElementById("page-size-selection");
    pageSize.addEventListener("change", ()=>{
        window.location.href = baseUrl+"?size="+pageSize.value
    })
}