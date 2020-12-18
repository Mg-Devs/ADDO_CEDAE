var nProds = 0;

$("#agProd").click(function (){
    nProds++;
    $("#productos").append(""+
        "<div class=\"form-row\">"+
            "<div class=\"col-1\"><h4 class=\"mt-2 ml-2 pr-0\">"+nProds+"</h4></div>"+
            "<div class=\"col-4\">"+
                "<select class=\"custom-select mr-sm-2\" id=\"prod"+nProds+"\" name=\"prod"+nProds+"\">"+
                    "<option selected>Seleccionar...</option>"+
                    "<option value=\"1\">Pomada</option>"+
                    "<option value=\"2\">Pastillas</option>"+
                    "<option value=\"3\">Crema</option>"+
                    "<option value=\"4\">Tratamiento A</option>"+
                    "<option value=\"3\">Tratamiento B</option>"+
                "</select>"+
            "</div>"+
            "<div class=\"col-6\">"+
                "<input type=\"text\" id=\"instProd\" name=\"instProd\" class=\"form-control\" placeholder=\"Instrucciones\">"+
            "</div>"+
            "<div class=\"col-1\">"+
                "<button class=\"btn btn-danger btn-circle\" onclick=\"deleteProd("+nProds+")\">"+
                    "<i class=\"fas fa-trash\"></i>"+
                "</button>"+
            "</div>"+
        "</div>");
});

function deleteProd(number){
    var row = $("#prod"+number).parents("div.form-row");
    row.fadeOut(200);
    row.remove();
    nProds--;
}


