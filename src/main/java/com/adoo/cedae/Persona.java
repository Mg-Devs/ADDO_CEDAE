/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    private String direccion;
    private String colonia;
    private String entFed;
    private int cp;

    public Persona(String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, LocalDate fechaNacimiento, LocalDate fechaRegistro) {
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

    public Persona(String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, LocalDate fechaNacimiento, LocalDate fechaRegistro, String direccion, String colonia, String entFed, int cp) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.direccion = direccion;
        this.colonia = colonia;
        this.entFed = entFed;
        this.cp = cp;
    }

    public Persona(String nombre, String apellidos, String curp, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
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
        try {
            db.conectarMySQL();
            ResultSet result = db.executeQuery("UPDATE persona SET contrasena = '" + npass + "' where curp = '" + curp + "';");
            db.closeConection();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRegistered(String email) {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT curp FROM persona where correo = '" + email + "';");

            if (!result.next()) {
                db.closeConection();
                return false;
            } else {
                db.closeConection();
                return true;
            }
        } catch (Exception e) {
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
            this.fechaNacimiento = LocalDate.parse(result.getString("fechaNacimiento"));
            this.fechaRegistro = LocalDate.parse(result.getString("fechaRegistro"));

            if (result.getString("tipo").equals("paciente")) {
                result = db.executeQuery("select estado from paciente where curp='"+this.curp+"';");
                result.next();
                if(result.getInt("estado")==1)
                    rs += ":paciente";
                else
                    rs = "No tienes permisos";
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getEntFed() {
        return entFed;
    }

    public void setEntFed(String entFed) {
        this.entFed = entFed;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
}
