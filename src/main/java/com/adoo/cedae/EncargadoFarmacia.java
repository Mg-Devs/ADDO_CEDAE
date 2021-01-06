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
public class EncargadoFarmacia extends Empleado{
    private int idEncargadoFarmacia;

    public EncargadoFarmacia(int idEncargadoFarmacia, String area, String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
        super(area, nombre, apellidos, curp, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
        this.idEncargadoFarmacia = idEncargadoFarmacia;
    }

    public EncargadoFarmacia(int idEncargadoFarmacia, String area) {
        super(area);
        this.idEncargadoFarmacia = idEncargadoFarmacia;
    }

    public int getIdEncargadoFarmacia() {
        return idEncargadoFarmacia;
    }

    public void setIdEncargadoFarmacia(int idEncargadoFarmacia) {
        this.idEncargadoFarmacia = idEncargadoFarmacia;
    }
    
    public void altaProducto(){
        
    }
    
    public void eliminarProducto(){
        
    }
    
    public void modificarProducto(){
        
    }
}
