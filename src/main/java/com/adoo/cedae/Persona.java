/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mario
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private String curp;
    private int edad;
    private String email;
    private String password;
    private long telefono;
    private Date fechaNacimiento;
    private Date fechaRegistro;

    public Persona(String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public boolean cambiarContrasena(String curp, String npass) {
        ConexionMySQL db = new ConexionMySQL();
        try{
            db.conectarMySQL();
            ResultSet result = db.executeQuery("UPDATE persona SET contrasena = '"+npass+"' where curp = '" + curp + "';");
            db.closeConection();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public String logIn(String email, String password) {
        ConexionMySQL db = new ConexionMySQL();
        try {
            String rs = "OK";
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT * FROM persona where correo = '" + email + "';");

            if (!result.next()) {
                db.closeConection();
                return "Correo no registrado";
            } else if (!result.getString("contrasena").equals(password)) {
                db.closeConection();
                return "Contraseña Incorrecta";
            }

            this.nombre = result.getString("nombre");
            this.apellidos = result.getString("apellidos");
            this.curp = result.getString("curp");
            this.edad = result.getInt("edad");
            this.email = result.getString("correo");
            this.password = result.getString("contrasena");
            this.telefono = Long.parseLong(result.getString("telefono"));
            this.fechaNacimiento = result.getDate("fechaNacimiento");
            this.fechaRegistro = result.getDate("fechaRegistro");

            if (result.getString("tipo").equals("paciente")) {
                rs += ":paciente";
            } else {
                result = db.executeQuery("SELECT area FROM empleado where curp = '" + this.curp + "';");
                if (!result.next()) {
                    db.closeConection();
                    return "Empleado no registrado";
                }
                
                switch (result.getString("area")) {
                    case "FARMACIA":
                    case "farmacia":
                        rs += ":farmacia";
                        break;
                    case "MEDICA":
                    case "medica":
                        rs += ":medico";
                        break;
                    case "RECEPCION":
                    case "recepcion":
                        rs += ":recepcionista";
                        break;
                    case "ADMINISTRACION":
                    case "administracion":
                        rs += ":superadmin";
                        break;
                    default:
                        rs += ":index";
                }
            }
            db.closeConection();
            return rs;
        } catch (Exception ex) {
            return ex.getMessage() + " On Line: " + ex.getStackTrace()[0].getLineNumber();
        }
    }
}
