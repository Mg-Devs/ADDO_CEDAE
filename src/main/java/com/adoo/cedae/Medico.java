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
    
    public Medico(String nombre, String apellidos, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
        super(nombre, apellidos, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
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
