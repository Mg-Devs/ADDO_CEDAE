window.onload = function () {
    $('#todo').text(location.search);
    
    $('#nExp').text(Math.floor(Math.random()*100000));
    $('#patient').text(get('name') + " " + get('lastname'));
    $('#edad').text((new Date().getFullYear() - new Date(get('birthdate')).getFullYear()) + " Años");
    $('#sexo').text(get('sexo') == '1'? "Masculino": get('sexo') == '2'?"Femenino":"Otro");
    $('#estcivil').text(get('estcivil') == '1'? "Casado": get('estcivil') == '2'?"Soltero":"Otro");
    $('#tel').text(get('tel'));
    $('#mail').text(get('email'));
    $('#occup').text(get('occup'));
    $('#secure').text(get('secure'));
    $('#dir').text(get('dir').replaceAll("+"," "));
    $('#colonia').text(get('colonia').replaceAll("+"," "));
    $('#entfed').text(get('entfed').replaceAll("+"," "));
    $('#alergias').text(get('alergias').replaceAll("+"," "));
    $('#anteHered').text(get('anteHered').replaceAll("+"," "));
    $('#antePato').text(get('antePato').replaceAll("+"," "));
    $('#padeciActual').text(get('padeciActual').replaceAll("+"," "));
    $('#topogr').text(get('topogr').replaceAll("+"," "));
    $('#morfo').text(get('morfo').replaceAll("+"," "));
    $('#panex').text(get('panex').replaceAll("+"," "));
    $('#tratAnt').text(get('tratAnt').replaceAll("+"," "));
    $('#diagn').text(get('diagn').replaceAll("+"," "));
    $('#desc').text(get('desc').replaceAll("+"," "));
    $('#obs').text(get('obs').replaceAll("+"," "));
    $('#planseg').text(get('planseg').replaceAll("+"," "));
    $('#pressArte').text(get('pressArte').replaceAll("%2F","/"));
    $('#cp').text(get('cp'));
    $('#peso').text(get('peso'));
    $('#estatura').text(get('estatura'));
    $('#frecCard').text(get('frecCard'));
    $('#frecResp').text(get('frecResp'));
    $('#cie').text(get('cie'));
    $('#temp').text(get('temp'));
    
};

function get(name) {
    if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
        return decodeURIComponent(name[1]);
}
//http://localhost:8080/CEDAE/verExpediente.html?name=Mario&lastname=Gonzalez&birthdate=1999-05-02&occup=Estudiante&tel=5519141402&secure=Ninguna&email=mariololi2%40hotmail.com&dir=Zacatecas+Lt.+14+Mza.+272&colonia=Luis+Echeverria&cp=54753&alergias=No&anteHered=No&antePato=No&peso=67&estatura=175&pressArte=120%2F80&frecCard=110&frecResp=16&temp=36.5&topogr=&panex=&tratAnt=&diagn=&cie=&padeciActual=Piel+rosita&morfo=&desc=&obs=&planseg=&sexo=1&estcivil=2&entfed=Estado+de+M%C3%A9xico