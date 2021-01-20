function deleteProd(element) {
    let temD = $("#tempDId");
    if (temD != null)
        temD.removeAttr("id");

    let parent = $(element).parents("tr");
    parent.attr('id', 'tempDId');
    $("#ittd").html(parent.children().html());
    $('#deleteItem').modal('show')
}

function deleteConfirmed() {
    let ittd = $("#tempDId");
    $.ajax({
        type: "POST",
        url: 'api/sections/recepcionista',
        data: {action: "delCita", idCita: ittd.data("idcita")},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            $('#deleteItem').modal('hide');
            ittd.fadeOut(200);
            ittd.removeAttr("id");
        }
    }).fail(function (data) {
        console.log(data);
        ittd.removeAttr("id");
    });
}

function editProd(element) {
    let temE = $("#tempEId");
    if (temE != null)
        temE.removeAttr("id");

    let parent = $(element).parents("tr");
    parent.attr('id', 'tempEId');
    
    $("#pacInput").html(" <label for=\"name\">Nombre paciente</label>"+" <input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" placeholder=\"Nombre paciente\">"); 
    $("#medInput").html(" <label for=\"doctor\">Doctor</label>"+" <input type=\"text\" id=\"doctor\" name=\"doctor\" class=\"form-control\" placeholder=\"Nombre doctor\">");
    
    $("#addEddTitle").html("Modificar Elemento");
    $("#curpmed").val(parent.children().eq(3).data("cmedico"));
    $("#curppac").val(parent.children().data("cpaciente"));
    $("#idcita").val(parent.data("idcita"));
    $("#name").val(parent.children().html());
    $("#name").prop("disabled",true);
    $("#hora").val(parent.children().eq(1).html());
    $("#fecha").val(parent.children().eq(2).html().replaceAll('/', '-'));
    $("#doctor").val(parent.children().eq(3).html());
    $("#doctor").prop("disabled",true);
    $("#modalAction").attr('onclick', 'confirmEdit()');
    $("#modalAction").html("Modificar");
    $('#editItem').modal('show')
}

function confirmEdit() {
    let itte = $("#tempEId");
    itte.children().eq(0).html($("#name").val());
    itte.children().eq(1).html($("#hora").val());
    itte.children().eq(2).html($("#fecha").val());
    itte.children().eq(3).html($("#medico").val());
    itte.removeAttr("id");
    
    $.ajax({
        type: "POST",
        url: 'api/sections/recepcionista',
        data: {action: "modCita", date: $("#fecha").val(), durac: $("#durac").val(), hora: $("#hora").val(), idCita: $("#idcita").val()},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            $('#editItem').modal('hide');
            navigationHelper('api/sections/recepcionista?section=vcitas');
        }
    }).fail(function (data) {
        console.log(data);
    });
}

function pacSelected(element){
    $("#curppac").val($(element).val());
}

function medSelected(element){
    $("#curpmed").val($(element).val());
}

function agProd() {
    $("#pacInput").html(" <label for=\"name\">Nombre paciente</label>"+" <select id=\"name\" name=\"name\" class=\"form-control\" onchange=\"pacSelected(this)\"></select>"); 
    $("#medInput").html(" <label for=\"doctor\">Doctor</label>"+" <select id=\"doctor\" name=\"doctor\" class=\"form-control\" onchange=\"medSelected(this)\"></select>");
    $.ajax({
        type: "POST",
        url: 'api/sections/recepcionista',
        data: {action: "getMedPac"},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            data.pacientes.forEach(function(item,index){
                $("#name").append("<option value=\""+item.curp+"\">"+item.nombre+" "+item.curp+"</option>");
            });
            
            data.medicos.forEach(function(item,index){
                $("#doctor").append("<option value=\""+item.curp+"\">"+item.nombre+"</option>");
            });
            
            $("#addEddTitle").html("Agendar Cita");
            $("#name").val('');
            $("#name").prop("disabled",false);
            $("#hora").val('');
            $("#fecha").val('');
            $("#doctor").val('');
            $("#doctor").prop("disabled",false);
            $("#modalAction").attr('onclick', 'addProd()');
            $("#modalAction").html("Agregar");
            $('#editItem').modal('show');
        }
    }).fail(function (data) {
        console.log(data);
    });
}

function addProd() {
    $.ajax({
        type: "POST",
        url: 'api/sections/recepcionista',
        data: {action: "createCita", date: $("#fecha").val(), durac: $("#durac").val(), hora: $("#hora").val(), cPac: $("#curppac").val(),cMed: $("#curpmed").val()},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            $('#editItem').modal('hide');
            navigationHelper('api/sections/recepcionista?section=vcitas');
        }
    }).fail(function (data) {
        console.log(data);
    });
}

function primeraCita(){
    $('#primerCita').modal('show');
}

function agendPrimerCita(){
    $.ajax({
        type: "POST",
        url: 'api/sections/recepcionista',
        data: {action: "pCitaCrear", date: $("#datepc").val(), name: $("#namepc").val(),lastname: $("#lastnamepc").val(), email: $("#emailpc").val(), tel: $("#telpc").val(), time: $("#horapc").val()},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            $('#primerCita').modal('hide');
            navigationHelper('api/sections/recepcionista?section=vcitas');
        }

    }).fail(function (data) {
        console.log(data);
    });
}

var prodstopay = 0;

function aggProdToPay(){
    $("#payService").append(
        " <div class=\"form-row\" id=\"prod2pay"+prodstopay+"\">"+
        " <div class=\"col mt-2\">"+
        " <label for=\"fecha\">Concepto</label>"+
        " <input class=\"form-control\" type=\"text\" name=\"citapricename"+prodstopay+"\" id=\"citapricename"+prodstopay+"\" placeholder=\"Servicio\" />"+
        " </div>"+
        " <div class=\"col mt-2\">"+
        " <label for=\"hora\">Precio</label>"+
        " <input class=\"form-control\" type=\"numeric\" min=\"0\" name=\"citaprice"+prodstopay+"\" id=\"citaprice"+prodstopay+"\"/>"+
        " </div>"+
        " <div class=\"col mt-2\">"+
        " <label for=\"hora\">Eliminar</label><br>"+
        "<button class=\"btn btn-sm btn-danger btn-circle mt-2 ml-3\" onclick=\"delProdToPay("+prodstopay+")\">"+
                " <i class=\"fas fa-trash\"></i>"+
        " </button>"+
        " </div>"+
        " </div>"  
    );
    prodstopay++;
}

function delProdToPay(number){
    var row = $("#prod2pay"+number);
    row.fadeOut(200);
    row.remove();
}

function pagarCita(){
    $.ajax({
        type: "POST",
        url: 'api/sections/recepcionista',
        data: {action: "pagarCita", idCita: $("#idcita2p").val()},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            $('#pagarCita').modal('hide');
            navigationHelper('api/sections/recepcionista?section=vcitaspp');
        }

    }).fail(function (data) {
        console.log(data);
    });
}


function payProd(element) {
    let temE = $("#tempEId");
    if (temE != null)
        temE.removeAttr("id");

    let parent = $(element).parents("tr");
    parent.attr('id', 'tempEId');
    
    $("#idcita2p").val(parent.data("idcita"));
    $("#namepay").val(parent.children().html());
    $("#horapay").val(parent.children().eq(1).html());
    $("#fechapay").val(parent.children().eq(2).html().replaceAll('/', '-'));
    $("#doctorpay").val(parent.children().eq(3).html());
    $("#doctorpay").prop("disabled",true);
    $('#pagarCita').modal('show')
}
