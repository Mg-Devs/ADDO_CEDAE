/**
* PHP Email Form Validation - v2.0
* URL: https://bootstrapmade.com/php-email-form/
* Author: BootstrapMade.com
*/
!(function($) {
  "use strict";

  $('form.user').submit(function(e) {
    e.preventDefault();
    
    var f = $(this).find('.form-group'),
      ferror = false,
      emailExp = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;

    f.children('input').each(function() { // run all inputs
     
      var i = $(this); // current input
      var rule = i.attr('data-rule');

      if (rule !== undefined) {
        var ierror = false; // error flag for current input
        var pos = rule.indexOf(':', 0);
        if (pos >= 0) {
          var exp = rule.substr(pos + 1, rule.length);
          rule = rule.substr(0, pos);
        } else {
          rule = rule.substr(pos + 1, rule.length);
        }

        switch (rule) {
          case 'required':
            if (i.val() === '') {
              ferror = ierror = true;
            }
            break;

          case 'minlen':
            if (i.val().length < parseInt(exp)) {
              ferror = ierror = true;
            }
            break;

          case 'email':
            if (!emailExp.test(i.val())) {
              ferror = ierror = true;
            }
            break;

          case 'checked':
            if (! i.is(':checked')) {
              ferror = ierror = true;
            }
            break;

          case 'regexp':
            exp = new RegExp(exp);
            if (!exp.test(i.val())) {
              ferror = ierror = true;
            }
            break;
        }
        i.next('.validate').html((ierror ? (i.attr('data-msg') !== undefined ? i.attr('data-msg') : 'wrong Input') : '')).show('blind');
      }
    });
    if (ferror) return false;
    
    tryLogin($('#email').val(),$('#password').val());

    /*if ($('#password').val() != "123456789"){
        $('#loginInfo').html('Contraseña Incorrecta').show("blind");
        return false;
    }
    else if($('#email').val() != "medico@cedae.com" & $('#email').val() != "farmacia@cedae.com" & $('#email').val() != "recepcionista@cedae.com"){
        $('#loginInfo').html('Correo no registrado').show("blind");
        return false;
    }
    else if($('#email').val() == "medico@cedae.com"){
        window.location.replace('http://localhost:8080/CEDAE/medico');
    }
    else if($('#email').val() == "farmacia@cedae.com"){
        window.location.replace('http://localhost:8080/CEDAE/farmacia');
    }
    else if($('#email').val() == "recepcionista@cedae.com"){
        window.location.replace('http://localhost:8080/CEDAE/recepcionista');
    }*/
    
    return true;
  });

  function tryLogin(email, password) {
    $.ajax({
      type: "POST",
      url: 'login',
      data: {email:email,password:password},
    }).done( function(data){
        console.log(data)
        if(data.status == 0)
            $('#loginInfo').html(data.message).show("blind");
        else
            window.location.replace(data.message.substr(3,data.message.length));
    }).fail( function(data){
      console.log(data);
    });
  }

})(jQuery);
