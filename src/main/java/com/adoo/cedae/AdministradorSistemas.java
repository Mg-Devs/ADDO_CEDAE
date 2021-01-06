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
public class AdministradorSistemas extends Empleado{
    private int idAdmin;

    public AdministradorSistemas(int idAdmin, String area, String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
        super(area, nombre, apellidos, curp, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
        this.idAdmin = idAdmin;
    }

    public AdministradorSistemas(int idAdmin, String area) {
        super(area);
        this.idAdmin = idAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public void altaUsuario(){
        
    }
    
    public void bajaUsuario(){
        
    }
    
    public void modificarUsuario(){
        
    }
    
}
