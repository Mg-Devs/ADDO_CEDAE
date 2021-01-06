/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import java.sql.Date;

/**
 *
 * @author mario
 */
public class Empleado extends Persona{
    private String area;

    public Empleado(String nombre, String apellidos, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
        super(nombre, apellidos, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}
