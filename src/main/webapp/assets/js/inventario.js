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
    $("#sku").val(parent.children().eq(1).html());
    $("#tam").val(parent.children().eq(2).html());
    $("#uni").val(parent.children().eq(3).html());
    $("#exp").val(parent.children().eq(4).html().replaceAll('/', '-'));
    $("#price").val(parent.children().eq(5).html().replace('$', ''));
    $("#modalAction").attr('onclick', 'confirmEdit()');
    $("#modalAction").html("Modificar");
    $('#editItem').modal('show')
}

function confirmEdit() {
    let itte = $("#tempEId");
    itte.children().eq(0).html($("#name").val());
    itte.children().eq(1).html($("#sku").val());
    itte.children().eq(2).html($("#tam").val());
    itte.children().eq(3).html($("#uni").val());
    itte.children().eq(4).html($("#exp").val().replaceAll('-', '/'));
    itte.children().eq(5).html("$" + $("#price").val());
    itte.removeAttr("id");
    $('#editItem').modal('hide')
}

$("#agProd").click(function () {
    $("#addEddTitle").html("Agregar Producto");
    $("#name").val('');
    $("#sku").val('');
    $("#tam").val('');
    $("#uni").val('');
    $("#exp").val('');
    $("#price").val('');
    $("#modalAction").attr('onclick', 'addProd()');
    $("#modalAction").html("Agregar");
    $('#editItem').modal('show');
});

function addProd() {
    $("#productTable").append(
            "<tr>"+
                "<td>"+$("#name").val()+"</td>"+
                "<td>"+$("#sku").val()+"</td>"+
                "<td>"+$("#tam").val()+"</td>"+
                "<td>"+$("#uni").val()+"</td>"+
                "<td>"+$("#exp").val().replaceAll('-', '/')+"</td>"+
                "<td>$"+$("#price").val()+"</td>"+
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