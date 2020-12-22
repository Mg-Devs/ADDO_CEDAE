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
    ittd.fadeOut(200);
    ittd.removeAttr("id");
}

function editProd(element) {
    let temE = $("#tempEId");
    if (temE != null)
        temE.removeAttr("id");

    let parent = $(element).parents("tr");
    parent.attr('id', 'tempEId');
    $("#addEddTitle").html("Modificar Elemento");
    $("#name").val(parent.children().html());
    $("#hora").val(parent.children().eq(1).html());
    $("#fecha").val(parent.children().eq(2).html().replaceAll('/', '-'));
    $("#doctor").val(parent.children().eq(3).html());
    $("#modalAction").attr('onclick', 'confirmEdit()');
    $("#modalAction").html("Modificar");
    $('#editItem').modal('show')
}

function confirmEdit() {
    let itte = $("#tempEId");
    itte.children().eq(0).html($("#name").val());
    itte.children().eq(1).html($("#hora").val());
    itte.children().eq(2).html($("#fecha").val().replaceAll('-', '/'));
    itte.children().eq(3).html($("#doctor").val());
    itte.removeAttr("id");
    $('#editItem').modal('hide')
}

$("#agProd").click(function () {
    $("#addEddTitle").html("Agendar Cita");
    $("#name").val('');
    $("#hora").val('');
    $("#fecha").val('');
    $("#doctor").val('');
    $("#modalAction").attr('onclick', 'addProd()');
    $("#modalAction").html("Agregar");
    $('#editItem').modal('show');
});

function addProd() {
    $("#productTable").append(
            "<tr>"+
                "<td>"+$("#name").val()+"</td>"+
                "<td>$"+$("#hora").val()+"</td>"+
                "<td>"+$("#fecha").val().replaceAll('-', '/')+"</td>"+
                "<td>"+$("#doctor").val()+"</td>"+
                "<td>"+
                    '<button class="btn btn-sm btn-primary btn-circle" onclick="editProd(this)">'+
                        '<i class="fas fa-edit"></i>'+
                    '</button>'+
                    '<button class="btn btn-sm btn-danger btn-circle" onclick="deleteProd(this)">'+
                        '<i class="fas fa-trash"></i>'+
                    '</button>'+
                '</td>'+
            '</tr>'
            );
    
    $('#editItem').modal('hide');
}