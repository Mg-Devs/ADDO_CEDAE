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
public class Paciente extends Persona{
    private int idPaciente;
    private Expediente expediente;
    private boolean puedeVerExp;
    private ArrayList<Cita> agenda;

    public Paciente(String nombre, String apellidos, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
        super(nombre, apellidos, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
    }

    public Paciente(int idPaciente, Expediente expediente, boolean puedeVerExp, ArrayList<Cita> agenda, String nombre, String apellidos, int edad, String email, String password, long telefono, Date fechaNacimiento, Date fechaRegistro) {
        super(nombre, apellidos, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
        this.idPaciente = idPaciente;
        this.expediente = expediente;
        this.puedeVerExp = puedeVerExp;
        this.agenda = agenda;
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
    
    public void agendarCita(){
        
    }
    
    
}
