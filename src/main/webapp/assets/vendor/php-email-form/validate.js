/**
 * PHP Email Form Validation - v2.0
 * URL: https://bootstrapmade.com/php-email-form/
 * Author: BootstrapMade.com
 */
$(document).ready(function () {
    let thisY = new Date().getFullYear();
    $("#date").flatpickr({
        enableTime: false,
        dateFormat: "Y/m/d",
        minDate: "today",
        maxDate: new Date().fp_incr(45), // 45 days from now
        "disable": [
            function (date) {
                return (date.getDay() === 0 || date.getDay() === 6);  // disable weekends
            },
            thisY + "/01/01", thisY + "/02/05", thisY + "/05/01", thisY + "/09/16", thisY + "/11/20", thisY + "/12/01", thisY + "/12/12", thisY + "/12/25"
        ],
        "locale": {
            "firstDayOfWeek": 1, // set start day of week to Monday
            weekdays: {
                shorthand: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
                longhand: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
            },
            months: {
                shorthand: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Оct', 'Nov', 'Dic'],
                longhand: ['Enero', 'Febreo', 'Мarzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            },
        }, onChange: function (selectedDates, dateStr, instance) {
            $.ajax({
                type: "POST",
                url: 'agendarCita',
                data: {action: 0, date: dateStr, sucursal: $("#sucursal").val()},
            }).done(function (data) {
                data.hrdisp.forEach(function(item,index){
                    $("#time").append("<option value=\""+item+"\">"+item+"</option>");
                });
                $("#time").prop( "disabled", false );
                
            }).fail(function (data) {
                console.log(data);
            });
        },
    });
});

!(function ($) {
    "use strict";

    $('form.php-email-form').submit(function (e) {
        e.preventDefault();

        var f = $(this).find('.form-group'),
                ferror = false,
                emailExp = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;

        f.children('input').each(function () { // run all inputs

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
                        if (!i.is(':checked')) {
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
        f.children('textarea').each(function () { // run all inputs

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
                }
                i.next('.validate').html((ierror ? (i.attr('data-msg') != undefined ? i.attr('data-msg') : 'wrong Input') : '')).show('blind');
            }
        });
        f.children('select').each(function () { // run all inputs

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
                        if (i.children('option:selected').val() === 'null') {
                            ferror = ierror = true;
                        }
                        break;

                    case 'minlen':
                        if (i.val().length < parseInt(exp)) {
                            ferror = ierror = true;
                        }
                        break;
                }
                i.next('.validate').html((ierror ? (i.attr('data-msg') != undefined ? i.attr('data-msg') : 'wrong Input') : '')).show('blind');
            }
        });
        if (ferror)
            return false;

        var this_form = $(this);
        var action = $(this).attr('action');

        if (!action) {
            this_form.find('.loading').slideUp();
            this_form.find('.error-message').slideDown().html('The form action property is not set!');
            return false;
        }

        this_form.find('.sent-message').slideUp();
        this_form.find('.error-message').slideUp();
        this_form.find('.loading').slideDown();

        agendarCita($("#name").val(),$("#lastname").val(),$("#email").val(),$("#tel").val(),$("#date").val(),$("#time").val(),$("#sucursal").val());

        return true;
    });

    function agendarCita(name,lastname,email,tel,date,time,sucursal) {
        $.ajax({
                type: "POST",
                url: 'agendarCita',
                data: {action: 1,name: name, lastname:lastname, email:email, tel:tel, date: date, time:time, sucursal: sucursal},
            }).done(function (data) {
                console.log(data);
                $('form.php-email-form').find('.loading').slideUp();
                if(data.message == "OK")
                    $('#confirmation').modal('show')
                else
                    $('form.php-email-form').find('.error-message').slideDown().html(data.message);
                    
            }).fail(function (data) {
                console.log(data);
            });
    }

})(jQuery);
