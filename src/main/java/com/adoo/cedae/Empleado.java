/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.ResultSet;
import java.time.LocalDate;



/**
 *
 * @author mario
 */
public class Empleado extends Persona{
    private String area;
    private String sucursal;

    public Empleado(String area, String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, LocalDate fechaNacimiento, LocalDate fechaRegistro) {
        super(nombre, apellidos, curp, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
        this.area = area;
    }
    
    public Empleado(String curp,int soloparadistingir){
        setCurp(curp);
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT sucursal FROM empleado where curp='"+getCurp()+"';");
            if(result.next())
                this.sucursal = result.getString("sucursal");
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public Empleado(String area) {
        this.area = area;
    }
    public Empleado() {}

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
}
