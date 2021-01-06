/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import java.sql.Date;
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

    public Medico(ArrayList<Cita> agenda, ArrayList<Paciente> pacientes, int idMedico, String cedula, boolean medicoTitular, String area, String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
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

    public ArrayList<Cita> getAgenda() {
        return agenda;
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
}
