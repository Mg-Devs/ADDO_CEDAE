/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    let thisY = new Date().getFullYear();
    $("#fecha").flatpickr({
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
                url: 'api/sections/recepcionista',
                data: {action: "cFecha", date: dateStr, durac: $("#durac").val(), curpmed: $("#curpmed").val()},
            }).done(function (data) {
                console.log(data);
                data.hrdisp.forEach(function(item,index){
                    $("#hora").append("<option value=\""+item+"\">"+item+"</option>");
                });
                $("#hora").prop( "disabled", false );
                
            }).fail(function (data) {
                console.log(data);
            });
        },
    });
    
    $("#datepc").flatpickr({
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
                url: 'api/sections/recepcionista',
                data: {action: "pCita", date: dateStr},
            }).done(function (data) {
                console.log(data);
                data.hrdisp.forEach(function(item,index){
                    $("#horapc").append("<option value=\""+item+"\">"+item+"</option>");
                });
                $("#horapc").prop( "disabled", false );
                
            }).fail(function (data) {
                console.log(data);
            });
        },
    });
});


