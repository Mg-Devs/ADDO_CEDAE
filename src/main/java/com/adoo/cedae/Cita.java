/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author mario
 */
public class Cita {
    
    private int idCita;
    private Paciente paciente;
    private Medico medicoAux;
    private Medico medicoTit;
    private Date fecha;
    private Time hora;
    private Receta receta;
    private int sucursal;

    public Cita(int idCita, Paciente paciente, Medico medicoAux, Medico medicoTit, Date fecha, Time hora, Receta receta, int sucursal) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medicoAux = medicoAux;
        this.medicoTit = medicoTit;
        this.fecha = fecha;
        this.hora = hora;
        this.receta = receta;
        this.sucursal = sucursal;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedicoAux() {
        return medicoAux;
    }

    public void setMedicoAux(Medico medicoAux) {
        this.medicoAux = medicoAux;
    }

    public Medico getMedicoTit() {
        return medicoTit;
    }

    public void setMedicoTit(Medico medicoTit) {
        this.medicoTit = medicoTit;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    
    public void crearCita(){
        
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }
}
