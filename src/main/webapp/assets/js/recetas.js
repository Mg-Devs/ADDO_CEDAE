var nProds = 0;
var prods = null;

function aggProdcutoHTML(){
    nProds++;
    var prodOpts = "<div class=\"form-row mt-1\" data-type=\"registered\">"+
                        "<div class=\"col-5\">"+
                            "<select class=\"custom-select mr-sm-2\" id=\"prod"+nProds+"\" name=\"prod"+nProds+"\">"+
                                "<option selected>Seleccionar...</option>";
                                for (var i = 0; i<prods.length;i++){
                                    prodOpts += "<option value=\""+prods[i]["sku"]+"\">"+prods[i]["nombre"]+" "+prods[i]["tamano"]+"</option>";
                                }
    prodOpts +=             "</select>"+
                        "</div>"+
                        "<div class=\"col-6\">"+
                            "<input type=\"text\" id=\"instProd"+nProds+"\" name=\"instProd"+nProds+"\" class=\"form-control\" placeholder=\"Instrucciones\">"+
                        "</div>"+
                        "<div class=\"col-1\">"+
                            "<button class=\"btn btn-danger btn-circle\" onclick=\"deleteProd("+nProds+")\">"+
                                "<i class=\"fas fa-trash\"></i>"+
                            "</button>"+
                        "</div>"+
                    "</div>"
    
    $("#productos").append(prodOpts);
}

function aggProducto(){
    if(prods == null){
        $.ajax({
            type: "POST",
            url: "api/sections/medico",
            data: {action:"getProd"},
        }).done(function (data) {
            if (data.status == 1){
                prods = data.message;
                aggProdcutoHTML();
            }
        }).fail(function (data) {
            console.log(data);
        });
    }else
        aggProdcutoHTML();
}

function aggOtroPorducto(){
    nProds++;
    var prodOpts = "<div class=\"form-row mt-1\" data-type=\"other\">"+
                        "<div class=\"col-5\">"+
                            "<input type=\"text\" class=\"form-control mr-sm-2\" id=\"prod"+nProds+"\" name=\"prod"+nProds+"\" placeholder=\"Escribe Aquí\">"+
                        "</div>"+
                        "<div class=\"col-6\">"+
                            "<input type=\"text\" id=\"instProd\" name=\"instProd\" class=\"form-control\" placeholder=\"Instrucciones\">"+
                        "</div>"+
                        "<div class=\"col-1\">"+
                            "<button class=\"btn btn-danger btn-circle\" onclick=\"deleteProd("+nProds+")\">"+
                                "<i class=\"fas fa-trash\"></i>"+
                            "</button>"+
                        "</div>"+
                    "</div>";
    
    $("#productos").append(prodOpts);
}

function deleteProd(number){
    var row = $("#prod"+number).parents("div.form-row");
    row.fadeOut(200);
    row.remove();
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
        recopc+="<button class=\"btn btn-success btn-icon-split\" alt=\"Ver Receta\" onclick=\"verReceta('"+row.data("recipe")+"')\"><span class=\"icon text-white-50\"><i class=\"fas fa-fw fa-print\"></i></span><span class=\"text\">Imprimir Receta</span></button>";
    
    $("#recetaOpt").html(recopc);
    
    $("#verCita").modal('show');
}

function cReceta(idC){
    $('#verCita').modal('hide');
    navigationHelper("api/sections/medico?section=cReceta&receta=" + idC);
}


function generarReceta(){
    $("#confirmReceta").modal('show');
}

function confirmGenerate(){
    var data = {};
    data["action"] = "cReceta";
    data["idC"] = $("#idC").val();
    data["peso"] = $("#peso").val();
    data["estatura"] = $("#estatura").val();
    data["pressArte"] = $("#pressArte").val();
    data["frecCard"] = $("#frecCard").val();
    data["frecResp"] = $("#frecResp").val();
    data["temp"] = $("#temp").val();
    data["diagn"] = $("#diagn").val();
    data["cie"] = $("#cie").val();
    data["desc"] = $("#desc").val();
    data["obs"] = $("#obs").val();
    data["planseg"] = $("#planseg").val();
    
    var aux =[];
    var products = $("#productos").children(".form-row");
    products.each(function (){
        var row = $(this);
        var objHelper = {};
        objHelper["type"] = row.data("type");
        objHelper["name"] = row.children().eq(0).find("input, select").val();
        objHelper["instructions"] = row.children().eq(1).find("input").val();
        
        aux.push(objHelper);
    });
    
    
    data["productos"] = JSON.stringify(aux);
    
    console.log(data);
    $.ajax({
        type: "POST",
        url: "api/sections/medico",
        data: data,
    }).done(function (data) {
        $("#confirmReceta").modal('hide');
        console.log(data);
        if(data.status == 1){
            window.open('PDF/Receta?recipe='+data.message,'_blank');
            navigationHelper('api/sections/medico?section=agenda');
        }
    }).fail(function (data) {
        console.log(data);
    });
}

function verReceta(element){
    $("#verCita").modal('hide');
    window.open('PDF/Receta?recipe='+element,'_blank');
}

