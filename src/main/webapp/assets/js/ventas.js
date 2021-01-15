var nProds = 0;
var total = 0;
var json = "{\"productos\":[";
var list = [];

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
    
    list.push('{"numero":"'+nProds
                    +'","sku":"'+parent.children().eq(1).html()
                    +'","precio":"'+parent.children().eq(5).html().replace('$', '')
                    +'","fcad":"'+parent.children().eq(4).html()
                    +'"}');
    
}

function deleteProd(number){
    var row = $("#prod"+number);
    nProds--;
    total-= parseInt(row.data('price'));
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
    $.ajax({ 
    type: 'post',
    url: "api/sections/farmacia", 
    dataType: 'JSON', 
    data: {  
     test: JSON.stringify(json)
    }, 
    success: function(data) { 

    }, 
    error: function(data) { 
     alert('fail'); 
    } 
}); 

nProds = 0;
total = 0;
json = "'{productos:[";
list = [];
 
}




