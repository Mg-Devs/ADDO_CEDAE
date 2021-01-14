/**
 * PHP Email Form Validation - v2.0
 * URL: https://bootstrapmade.com/php-email-form/
 * Author: BootstrapMade.com
 */

function createExpediente(e) {
    //e.preventDefault();

    var f = $("#content-panel").find('div.col'),
            ferror = false,
            emailExp = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i,
            curpExp = /^[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE|XX)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$/i;

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

                case 'curp':
                    if (!curpExp.test(i.val())) {
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
    console.log("OK");
    send_all_data(f, "api/sections/medico");
    return true;
}

function send_all_data(forms, action) {
    var form = document.createElement("form");
    form.method = "POST";
    form.action = action;
    var element1 = document.createElement("input");
    var element2 = document.createElement("input");
    var i = $("#pid"); // current input
    element2.value = "cExpediente";
    element2.name = 'action';
    form.appendChild(element2);
    element1.value = i.val();
    element1.name = i.attr('name');
    form.appendChild(element1);

    forms.find('input').each(function () { // run all inputs
        var element = document.createElement("input");
        var i = $(this); // current input
        element.value = i.val();
        element.name = i.attr('name');
        form.appendChild(element);
    });
    forms.find('textarea').each(function () { // run all inputs
        var element = document.createElement("textarea");
        var i = $(this); // current input
        element.value = i.val();
        element.name = i.attr('name');
        form.appendChild(element);
    });
    forms.find('select').each(function () { // run all inputs
        var element = document.createElement("input");
        var i = $(this); // current input
        element.value = i.children('option:selected').val();
        element.name = i.attr('name');
        form.appendChild(element);
    });

    var formData = new FormData(form);
    var sendData = {};
    formData.forEach((value, key) => sendData[key] = value);
    //var json = JSON.stringify(sendData);

    $.ajax({
        type: "POST",
        url: action,
        data: sendData,
    }).done(function (data) {
        console.log(data);
        if (data.status == 1)
            vExpediente(data.message);
    }).fail(function (data) {
        console.log(data);
    });
}

function vExpediente(curp) {
    $.ajax({
        type: "GET",
        url: "api/sections/medico",
        data: {
            "section": "vExpediente",
            "helper": curp
        }
    }).done(function (response) {
        $("#content-page").html(response);
    }).fail(function (error) {
        console.log(error);
    });
}



