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
public class Recepcionista extends Empleado{
    private int idRecepcionista;

    public Recepcionista(String nombre, String apellidos, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
        super(nombre, apellidos, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
    }

    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }
    
    public void generarCita(){
        
    }
    
    public void cancelarCita(){
        
    }
    
    public void modificarCita(){
        
    }
    
    public void verCita(){
        
    }
    
}
