/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Medico extends Empleado{
    private ArrayList<Cita> agenda;
    private ArrayList<Paciente> pacientes;
    private int idMedico;
    private String cedula;
    private boolean medicoTitular;

    public Medico(ArrayList<Cita> agenda, ArrayList<Paciente> pacientes, int idMedico, String cedula, boolean medicoTitular, String area, String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, LocalDate fechaNacimiento, LocalDate fechaRegistro) {
        super(area, nombre, apellidos, curp, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
        this.agenda = agenda;
        this.pacientes = pacientes;
        this.idMedico = idMedico;
        this.cedula = cedula;
        this.medicoTitular = medicoTitular;
    }

    public Medico(ArrayList<Cita> agenda, ArrayList<Paciente> pacientes, int idMedico, String cedula, boolean medicoTitular, String area) {
        super(area);
        this.agenda = agenda;
        this.pacientes = pacientes;
        this.idMedico = idMedico;
        this.cedula = cedula;
        this.medicoTitular = medicoTitular;
    }
    
    public Medico(String curp, boolean titular){
        this.medicoTitular = titular;
        setCurp(curp);
    }

    public ArrayList<Cita> getAgenda() {
        agenda = new ArrayList<Cita>();
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT * FROM cita inner join persona on curp = curppaciente where curpmedtit = '"+this.getCurp()+"' and fecha >= CAST('"+LocalDate.now()+"' AS date);");
            while(result.next()){
                Cita aux = new Cita(result.getInt("idcita"), new Paciente(result.getString("nombre"), result.getString("apellidos"), result.getString("correo"), Long.parseLong(result.getString("telefono")), result.getString("curp")), new Medico(result.getString("curpmedaux"), false), this, LocalDate.parse(result.getString("fecha")), LocalTime.parse(result.getString("hora")),result.getInt("idreceta"),result.getString("sucursal"));
                agenda.add(aux);
            }
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
        return agenda;
    }
    
    public ArrayList<Persona> getExp(){
        ArrayList<Persona> exped = new ArrayList<Persona>();
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT persona.nombre as nombre, persona.apellidos as apellidos,pacientemedico.curp as curp, expediente.fechamodif FROM pacientemedico inner join persona on pacientemedico.curp = persona.curp inner join paciente on paciente.curp = pacientemedico.curp inner join expediente on paciente.idexpediente = expediente.idexpediente where pacientemedico.curpmedico = '"+this.getCurp()+"';");
            while(result.next()){
                Persona aux = new Persona(result.getString("nombre"), result.getString("apellidos"), result.getString("curp"), LocalDate.parse(result.getString("fechamodif")));
                exped.add(aux);
            }
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
        return exped;
    }

    public void setAgenda(ArrayList<Cita> agenda) {
        this.agenda = agenda;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public void agendarCita(){
        
    }
    
    public void generarExpediente(){
        
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isMedicoTitular() {
        return medicoTitular;
    }

    public void setMedicoTitular(boolean medicoTitular) {
        this.medicoTitular = medicoTitular;
    }
    
    public void addPaciente(Paciente paciente){
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            db.insertQuery("insert into pacientemedico (curpmedico,curp) values('"+this.getCurp()+"','"+paciente.getCurp()+"');");
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public boolean getAllData() {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("select * from persona inner join empleado on persona.curp = empleado.curp where persona.curp = '" + getCurp() + "';");
            if (!result.next()) {
                return false;
            }

            setEmail(result.getString("correo"));
            setNombre(result.getString("nombre"));
            setApellidos(result.getString("apellidos"));
            setTelefono(Long.parseLong(result.getString("telefono")));
            setEdad(result.getInt("edad"));
            setPassword(result.getString("contrasena"));
            setTelefono(Long.parseLong(result.getString("telefono")));
            setFechaNacimiento(LocalDate.parse(result.getString("fechaNacimiento")));
            setDireccion(result.getString("direccion"));
            setColonia(result.getString("colonia"));
            setEntFed(result.getString("entidadfederativa"));
            setCp(result.getInt("codigopostal"));
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
}
