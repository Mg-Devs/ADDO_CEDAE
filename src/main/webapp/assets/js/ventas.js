var nProds = 0;
var total = 0;

function addProd(element){
    let parent = $(element).parents("tr");
    nProds++;
    total += parseInt(parent.children().eq(5).html().replace('$', ''));
    
    $("#productos").append(""+
        "<div id=\"prod"+nProds+"\" data-price='"+parent.children().eq(5).html().replace('$', '')+"' class=\"row\">"+
            "<div class=\"col-1\"><h4 class=\"mt-2 ml-2 pr-0\">"+nProds+"</h4></div>"+
            "<div class=\"col-6\">"+ parent.children().eq(0).html() +"</div>"+
            "<div class=\"col-1\">"+
                "<button class=\"btn btn-danger btn-circle\" onclick=\"deleteProd("+nProds+")\">"+
                    "<i class=\"fas fa-trash\"></i>"+
                "</button>"+
            "</div>"+
            "<div class=\"col-3 text-right\">"+parent.children().eq(5).html()+"</div>"+
        "</div><hr>");
    $("#total").html("$"+total);
}

function deleteProd(number){
    var row = $("#prod"+number);
    nProds--;
    total-= parseInt(row.data('price'));
    $("#total").html("$"+total);
    row.fadeOut(200);
    row.remove();
}




