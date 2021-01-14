/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Paciente extends Persona {

    private int idPaciente;
    private Expediente expediente;
    private boolean puedeVerExp;
    private ArrayList<Cita> agenda;

    public Paciente(int idPaciente, Expediente expediente, boolean puedeVerExp, String string, String string1, String string2, int i, String string3, String string4, long l, LocalDate ld, LocalDate ld1, String string5, String string6, String string7, int i1) {
        super(string, string1, string2, i, string3, string4, l, ld, ld1, string5, string6, string7, i1);
        this.idPaciente = idPaciente;
        this.expediente = expediente;
        this.puedeVerExp = puedeVerExp;
    }

    public Paciente(int idPaciente, Expediente expediente, boolean puedeVerExp, ArrayList<Cita> agenda) {
        this.idPaciente = idPaciente;
        this.expediente = expediente;
        this.puedeVerExp = puedeVerExp;
        this.agenda = agenda;
    }

    public Paciente(String nombre, String apellidos, String email, long telefono) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEmail(email);
        setTelefono(telefono);
        setCurp("TMP" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }

    public Paciente(String nombre, String apellidos, String email, long telefono, String curp) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEmail(email);
        setTelefono(telefono);
        setCurp(curp);
    }

    public Paciente(String curp) {
        setCurp(curp);
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public boolean isPuedeVerExp() {
        return puedeVerExp;
    }

    public void setPuedeVerExp(boolean puedeVerExp) {
        this.puedeVerExp = puedeVerExp;
    }

    public ArrayList<Cita> getAgenda() {
        return agenda;
    }

    public void setAgenda(ArrayList<Cita> agenda) {
        this.agenda = agenda;
    }

    public void agendarCita() {

    }

    public void guardarPacienteTemp() {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            db.insertQuery("insert into persona (curp,correo,nombre,apellidos,telefono,tipo) values('" + getCurp() + "','" + getEmail() + "','" + getNombre() + "','" + getApellidos() + "','" + getTelefono() + "','paciente');");
            db.insertQuery("insert into paciente (curp,estado) values ('" + getCurp() + "',0);");
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error GPT: " + e.getMessage() + " CURP: " + getCurp() + " lenght: " + getCurp().length());
        }
    }

    public boolean getData() {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT * FROM persona where curp = '" + this.getCurp() + "';");
            if (!result.next()) {
                return false;
            }

            setEmail(result.getString("correo"));
            setNombre(result.getString("nombre"));
            setApellidos(result.getString("apellidos"));
            setTelefono(Long.parseLong(result.getString("telefono")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getAllData() {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("select * from persona inner join paciente on persona.curp = paciente.curp inner join expediente on paciente.idexpediente = expediente.idexpediente where persona.curp = '" + getCurp() + "';");
            if (!result.next()) {
                return false;
            }

            setEmail(result.getString("correo"));
            setNombre(result.getString("nombre"));
            setApellidos(result.getString("apellidos"));
            setTelefono(Long.parseLong(result.getString("telefono")));
            setPuedeVerExp(result.getInt("estado")==0?false:true);
            setEdad(result.getInt("edad"));
            setPassword(result.getString("contrasena"));
            setTelefono(Long.parseLong(result.getString("telefono")));
            setFechaNacimiento(LocalDate.parse(result.getString("fechaNacimiento")));
            setDireccion(result.getString("direccion"));
            setColonia(result.getString("colonia"));
            setEntFed(result.getString("entidadfederativa"));
            setCp(result.getInt("codigopostal"));
            
            Expediente expediente = new Expediente(result.getInt("idexpediente"), 0,result.getInt("genero"), "No relevante", result.getString("aseguradora"), result.getString("alergias"), result.getString("antecedentesheredofamiliares"), result.getString("antecedentespersonales"), result.getString("padecimientoactual"), result.getInt("peso"), 
                    result.getInt("estatura"), result.getString("presionarterial"), result.getString("frecuenciacardiaca"), result.getString("frecuenciarespiratoria"), result.getFloat("temperatura"),
                    result.getString("topografia"), result.getString("morfologia"), result.getString("pielyanexos"), result.getString("tratamientoanterior"), result.getString("diagnostico"), result.getString("cie"), result.getString("descripcion"), result.getString("observaciones"), result.getString("planseguimiento"));
            
            setExpediente(expediente);
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }

    public void guardaPac(String temp) {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            db.updateQuery("update persona  set curp = '" + getCurp() + "', correo = '" + getEmail() + "', contrasena = '" + getPassword() + "', nombre = '" + getNombre() + "', apellidos= '" + getApellidos() + "', edad=" + getEdad() + ", telefono='" + getTelefono() + "', fechaNacimiento='" + getFechaNacimiento() + "', fechaRegistro='" + getFechaRegistro() + "', direccion='" + getDireccion() + "', colonia='" + getColonia() + "', entidadfederativa='" + getEntFed() + "', codigopostal=" + getCp() + " where curp = '" + temp + "';");
            db.updateQuery("update paciente set aseguradora = '" + getExpediente().getSecure() + "', idexpediente = " + getExpediente().getNoExpediente() + " where curp = '" + getCurp() + "';");
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
