/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        url: 'api/sections/paciente',
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
    
    $("#pacInput").html(" <label for=\"name\">Sucursal</label>"+" <input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" placeholder=\"Nombre paciente\">"); 
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
        url: 'api/sections/paciente',
        data: {action: "modCita", date: $("#fecha").val(), durac: 2, sucursal: $("#name").val(),hora: $("#hora").val(), idCita: $("#idcita").val()},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            $('#editItem').modal('hide');
            navigationHelper('api/sections/paciente?section=vcitas');
        }
    }).fail(function (data) {
        console.log(data);
    });
}

function pacSelected(element){
    $("#curppac").val($(element).val());
    $.ajax({
        type: "POST",
        url: 'api/sections/paciente',
        data: {action: "getMedSuc", sucursal: $("#name").val()},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            $("#medInput").html(" <label for=\"doctor\">Doctor</label>"+" <select id=\"doctor\" name=\"doctor\" class=\"form-control\" onchange=\"medSelected(this)\"></select>");
            data.medicos.forEach(function(item,index){
                $("#doctor").append("<option value=\""+item.curp+"\">"+item.nombre+"</option>");
            });
        }
    }).fail(function (data) {
        console.log(data);
    });
}

function medSelected(element){
    $("#curpmed").val($(element).val());
}

function agProd() {
    $("#pacInput").html(" <label for=\"name\">Sucursal</label>"+" <select id=\"name\" name=\"name\" class=\"form-control\" onchange=\"pacSelected(this)\"><option value=\"La Roma\" selected>La Roma</option><option value=\"Satelite\">Satelite</option></select>"); 
    $("#medInput").html(" <label for=\"doctor\">Doctor</label>"+" <select id=\"doctor\" name=\"doctor\" class=\"form-control\" onchange=\"medSelected(this)\"></select>");
    
    /*$("#name").append("");
    $("#name").append("");*/
    
    $.ajax({
        type: "POST",
        url: 'api/sections/paciente',
        data: {action: "getMedSuc", sucursal: $("#name").val()},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            
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
            $("#modalAction").html("Agendar Cita");
            $('#editItem').modal('show');
        }
    }).fail(function (data) {
        console.log(data);
    });
}

function addProd() {
    $.ajax({
        type: "POST",
        url: 'api/sections/paciente',
        data: {action: "createCita", date: $("#fecha").val(), durac: 2, hora: $("#hora").val(), sucursal: $("#curppac").val(),cMed: $("#doctor").val()},
    }).done(function (data) {
        console.log(data);
        if(data.status == 1){
            $('#editItem').modal('hide');
            navigationHelper('api/sections/paciente?section=vcitas');
        }
    }).fail(function (data) {
        console.log(data);
    });
}

function verReceta(idrecipe){
    window.open('PDF/Receta?recipe='+idrecipe,'_blank');
}



