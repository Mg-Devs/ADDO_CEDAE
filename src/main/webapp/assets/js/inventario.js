function deleteProdDB(element) {
    let temD = $("#tempDId");
    if (temD != null)
        temD.removeAttr("id");

    let parent = $(element).parents("tr");
    parent.attr('id', 'tempDId');
    $("#ittd").html(parent.children().html());
    $('#deleteItem').modal('show');
}

function deleteConfirmed() {
    let ittd = $("#tempDId");
    let sku = ittd.children().eq(1).text();
    
    $.ajax({
        type: "POST",
        url: "api/sections/farmacia",
        data: {"action":"delProd","sku":sku},
    }).done(function (data) {
        ittd.removeAttr("id");
        if(data.status == 1){
            $('#deleteItem').modal('hide');
            ittd.fadeOut(200);
        }
        else
            console.log(data);
    }).fail(function (data) {
        ittd.removeAttr("id");
        console.log(data);
    });
    
}

function editProd(element) {
    let temE = $("#tempEId");
    if (temE != null)
        temE.removeAttr("id");
    
    var lotes ="";

    let parent = $(element).parents("tr");
    parent.attr('id', 'tempEId');
    $("#addEddTitle").html("Modificar Elemento");
    $("#name").val(parent.children().html());
    $("#sku").val(parent.children().eq(1).html());
    $("#sku").prop( "disabled", true );;
    $("#tam").val(parent.children().eq(2).html());
    $("#price").val(parent.children().eq(5).html().replace('$', ''));
    $("#modalAction").attr('onclick', 'confirmEdit()');
    $("#modalAction").html("Modificar");
    
    $.ajax({
        type: "POST",
        url: "api/sections/farmacia",
        data: {"action":"getLote","helper":$("#sku").val()},
    }).done(function (data) {
        for (var i = 0; i < data.message.lotes.length; i++) {
            lotes += "<div id=\"formLote-"+i+"\" class=\"form-row\">"+
                        " <div class=\"col mt-2\">"+
                        " <label for=\"uni\">Lote</label>"+
                        " <input type=\"text\" id=\"lot"+i+"\" name=\"lot"+i+"\" class=\"form-control\" placeholder=\"Lote\" value=\""+data.message.lotes[i].nlote+"\" >"+
                        " </div>"+
                        " <div class=\"col mt-2\">"+
                        " <label for=\"uni\">Unidades</label>"+
                        " <input type=\"number\" id=\"uni"+i+"\" name=\"uni"+i+"\" class=\"form-control\" placeholder=\"Unidades\" value=\""+data.message.lotes[i].unidades+"\" >"+
                        " </div>"+
                        " <div class=\"col mt-2\">"+
                        " <label for=\"price\">Fecha de Caducidad</label>"+
                        " <input type=\"date\" id=\"exp"+i+"\" name=\"exp"+i+"\" class=\"form-control\" placeholder=\"Fecha\" value=\""+data.message.lotes[i].fcad+"\" >"+
                        " </div>"+
                        " <div class=\"col mt-2\">";
                if(i>0){
                    lotes +=" <label for=\"price\">Eliminar Lote</label><br><button class=\"btn btn-sm btn-danger btn-circle mt-2 ml-3\" onclick=\"deleteLote("+i+")\">"+
                        " <i class=\"fas fa-trash\"></i>"+
                        " </button>";
                } 
                lotes +=" </div>"+
                    " </div>";
        }
        
        $("#loteData").html(lotes);
        
    }).fail(function (data) {
        console.log(data);
    });
    
    $('#editItem').modal('show');
}

function confirmEdit() {
    let itte = $("#tempEId");
    var lotes = getLotesJSON();
    
    $.ajax({
        type: "POST",
        url: "api/sections/farmacia",
        data: {"action":"modProd","sku":$("#sku").val(),"name":$("#name").val(),"tam":$("#tam").val(),"price":$("#price").val(),"lotes":lotes},
    }).done(function (data) {
        itte.removeAttr("id");
        if(data.status == 1){
            $('#editItem').modal('hide');
            navigationHelper('api/sections/farmacia?section=inventario');
        }
    }).fail(function (data) {
        itte.removeAttr("id");
        console.log(data);
    });
}

$("#agProd").click(function () {
    
    var lotes = " <div id=\"formLote-0\" class=\"form-row\">"+
                    " <div class=\"col mt-2\">"+
                    " <label for=\"uni\">Lote</label>"+
                    " <input type=\"text\" id=\"lot"+0+"\" name=\"lot"+0+"\" class=\"form-control\" placeholder=\"Lote\">"+
                    " </div>"+
                    " <div class=\"col mt-2\">"+
                    " <label for=\"uni\">Unidades</label>"+
                    " <input type=\"number\" id=\"uni"+0+"\" name=\"uni"+0+"\" class=\"form-control\" placeholder=\"Unidades\">"+
                    " </div>"+
                    " <div class=\"col mt-2\">"+
                    " <label for=\"price\">Fecha de Caducidad</label>"+
                    " <input type=\"date\" id=\"exp0\" name=\"exp0\" class=\"form-control\" placeholder=\"Fecha\">"+
                    " </div>"+
                    " <div class=\"col mt-2\">"+
                    " </div>"+
                " </div>";
            
    $("#addEddTitle").html("Agregar Producto");
    $("#name").val('');
    $("#sku").val('');
    $("#sku").prop( "disabled", false );
    $("#tam").val('');
    $("#price").val('');
    $("#loteData").html(lotes);
    $("#modalAction").attr('onclick', 'addProdDB()');
    $("#modalAction").html("Agregar");
    $('#editItem').modal('show');
});

function addProdDB() {
    let itte = $("#tempEId");
    var lotes = getLotesJSON();
    
    $.ajax({
        type: "POST",
        url: "api/sections/farmacia",
        data: {"action":"nProd","sku":$("#sku").val(),"name":$("#name").val(),"tam":$("#tam").val(),"price":$("#price").val(),"lotes":lotes},
    }).done(function (data) {
        itte.removeAttr("id");
        if(data.status == 1){
            $('#editItem').modal('hide');
            navigationHelper('api/sections/farmacia?section=inventario');
        }
        
        
        
    }).fail(function (data) {
        itte.removeAttr("id");
        console.log(data);
    });
}

function aggLote(){
    var lotesF = $('#loteData');
    var rowN = lotesF.children('.form-row').length;
    var lotes = " <div id=\"formLote-"+rowN+"\" class=\"form-row\">"+
                    " <div class=\"col mt-2\">"+
                    " <label for=\"uni\">Lote</label>"+
                    " <input type=\"text\" id=\"lot"+rowN+"\" name=\"lot"+rowN+"\" class=\"form-control\" placeholder=\"Lote\">"+
                    " </div>"+
                    " <div class=\"col mt-2\">"+
                    " <label for=\"uni\">Unidades</label>"+
                    " <input type=\"number\" id=\"uni"+rowN+"\" name=\"uni"+rowN+"\" class=\"form-control\" placeholder=\"Unidades\">"+
                    " </div>"+
                    " <div class=\"col mt-2\">"+
                    " <label for=\"price\">Fecha de Caducidad</label>"+
                    " <input type=\"date\" id=\"exp"+rowN+"\" name=\"exp"+rowN+"\" class=\"form-control\" placeholder=\"Fecha\">"+
                    " </div>"+
                    " <div class=\"col mt-2\">"+
                    " <label for=\"price\">Eliminar Lote</label><br><button class=\"btn btn-sm btn-danger btn-circle mt-2 ml-3\" onclick=\"deleteLote("+rowN+")\">"+
                    " <i class=\"fas fa-trash\"></i>"+
                    " </button>"+
                    " </div>"+
                " </div>";
    
    lotesF.append(lotes);
}

function deleteLote(number){
    var row = $("#formLote-"+number).remove();
}

function getLotesJSON(){
    var jsonObj = {};
    jsonObj["lotes"] = [];
    var lotesF = $('#loteData');
    lotesF.children('.form-row').each(function (){
        var  jsonObj2 = {};
        var formRow = $(this).children('.col');
        
        jsonObj2["nlote"] = formRow.eq(0).children('input').val();
        jsonObj2["unidades"] = parseInt(formRow.eq(1).children('input').val());
        jsonObj2["fcad"] = formRow.eq(2).children('input').val();
        jsonObj["lotes"].push(jsonObj2);
    });
    return JSON.stringify(jsonObj);
}