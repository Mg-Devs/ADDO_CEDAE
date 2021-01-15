var nProds = 0;

function aggProducto(){
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
}

function deleteProd(number){
    var row = $("#prod"+number).parents("div.form-row");
    row.fadeOut(200);
    row.remove();
    nProds--;
}

function verCita(element){
    var row = $(element).parents("tr");
    $("#name").val(row.children().eq(0).text());
    $("#sucur").val(row.data("place"));
    $("#date").val(row.children().eq(2).text().replaceAll('/','-'));
    $("#time").val(row.children().eq(1).text());
    $("#time").val(row.children().eq(1).text());
    
    var recopc = "<label for=\"rOpt\">Receta</label><br>";
    if(row.data("recipe") == null)
       recopc+="<button class=\"btn btn-info btn-icon-split\" alt=\"Crear Receta\" onclick=\"cReceta(" +row.data("id")+")\"><span class=\"icon text-white-50\"><i class=\"fas fa-fw fa-notes-medical\"></i></span><span class=\"text\">Crear Receta</span></button>";
    else
        recopc+="<button class=\"btn btn-success btn-icon-split\" alt=\"Ver Receta\" onclick=\"verReceta("+row.data("recipe")+")\"><span class=\"icon text-white-50\"><i class=\"fas fa-fw fa-print\"></i></span><span class=\"text\">Imprimir Receta</span></button>";
    
    $("#recetaOpt").html(recopc);
    
    $("#verCita").modal('show');
}

function cReceta(idC){
    $('#verCita').modal('hide');
    navigationHelper("api/sections/medico?section=cReceta&receta=" + idC);
}


