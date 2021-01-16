var nProds = 0;
var total = 0;
var json = "{\"productos\":[";
var list = [];

function addProd(element){
    let parent = $(element).parents("tr");
    nProds++;
    total += parseInt(parent.children().eq(5).html().replace('$', ''));
    
    $("#productos").append(""+
        "<div id=\"prod"+nProds+"\" data-price='"+parent.children().eq(5).html().replace('$', '')+"' class=\"row\ data-nitems=\"1\" data-idProd=\""+nProds+"\">"+
            "<div class=\"col-1\"><h4 class=\"mt-2 ml-2 pr-0\">"+nProds+"</h4></div>"+
            "<div class=\"col-4\">"+ parent.children().eq(0).html() +"</div>"+
            "<div class=\"col-2\"><input type=\"number\" id=\"nProds"+nProds+"\"  name=\"nProds"+nProds+"\" class=\"form-control\" placeholder=\"#\" value=\"1\" onchange=\"cambiarTotal("+nProds+")\" min=\"1\" max=\""+parent.children().eq(3).text() +"\"></div>"+
            "<div class=\"col-1\">"+
                "<button class=\"btn btn-danger btn-circle\" onclick=\"deleteProd("+nProds+")\">"+
                    "<i class=\"fas fa-trash\"></i>"+
                "</button>"+
            "</div>"+
            "<div class=\"col-3 text-right\">"+parent.children().eq(5).html()+"</div>"+
        "</div><hr>");
    $("#total").html("$"+total);
    
    list.push('{"numero":"'+nProds
                    +'","sku":"'+parent.children().eq(1).html()
                    +'","precio":"'+parent.children().eq(5).html().replace('$', '')
                    +'","fcad":"'+parent.children().eq(4).html()
                    +'"}');
    
}

function deleteProd(number){
    var row = $("#prod"+number);
    nProds--;
    total-= parseInt(row.data('price'))*parseInt(row.data('nitems'));
    $("#total").html("$"+total);
    row.fadeOut(200);
    row.remove();
    for (var i = 0; i < list.length; i++) {
        if(list[i].indexOf('"numero":"'+number) !== -1) {
            list.splice(i,1);
            break;
        }
    }
   
}

function sell(){
    for (var i = 0; i < list.length; i++) {
        json = json + list[i];
        if(i!==(list.length-1)){
            json = json + ",";
        }
        
    }
    json = json + "]}";
    var obj = JSON.parse(json);
    
    var elementos = $("#productos").children('.row');
    elementos.each(function (index){
        var row = $(this);
        obj["productos"][index]["unidades"]=parseInt(row.children().eq(2).children('input').val());
    });

    $.ajax({ 
    type: 'post',
    url: "api/sections/farmacia", 
    dataType: 'JSON', 
    data: {  
     test: JSON.stringify(obj),
     action:"venta"
    }, 
    success: function(data) { 
        console.log(data);
        if(data.status == 1){
            navigationHelper('api/sections/farmacia?section=inventario');
        }
    }, 
    error: function(data) { 
     console.log(data);
    } 
}); 

nProds = 0;
total = 0;
json = "'{productos:[";
list = [];
 
}

function cambiarTotal(number){
    var row2 = $("#prod"+number);
    row2.data('nitems',row2.children().eq(2).children('input').val());
    var tot = 0;
    var elementos = $("#productos").children('.row');
    elementos.each(function (){
        var row = $(this);
        tot+= parseInt(row.children().eq(2).children('input').val())*parseInt(row.children().eq(4).text().replaceAll('$',''));
    });
    total = tot;
    $("#total").html("$"+tot);
}



