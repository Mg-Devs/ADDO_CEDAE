/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(".nav-link, .collapse-item").click(function(e) {
    e.preventDefault();
    var link = $(this).attr("href");
    if(link=='#')
        return;
    
    $.ajax({
        type: "GET",
        url: link.substr(0,link.indexOf('?')),
        data: {
            "section": link.substr(link.indexOf('=')+1,link.length)
        }
    }).done(function(response){
        $("#content-page").html(response);
    }).fail(function(error){
        console.log(error);
    });
});

function navigationHelper(link){
    $.ajax({
        type: "GET",
        url: link.substr(0,link.indexOf('?')),
        data: {
            "section": link.substr(link.indexOf('=')+1,link.length)
        }
    }).done(function(response){
        $("#content-page").html(response);
    }).fail(function(error){
        console.log(error);
    });
}

