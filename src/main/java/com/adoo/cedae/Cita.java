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
import java.time.LocalTime;

/**
 *
 * @author mario
 */
public class Cita {
    
    private int idCita;
    private Paciente paciente;
    private Medico medicoAux;
    private Medico medicoTit;
    private LocalDate fecha;
    private LocalTime hora;
    private LocalTime duracion;
    private Receta receta;
    private String sucursal;

    public Cita(int idCita) {
        this.idCita = idCita;
    }
    
    public Cita(int idCita, Paciente paciente, Medico medicoAux, Medico medicoTit, LocalDate fecha, LocalTime hora, Receta receta, String sucursal) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medicoAux = medicoAux;
        this.medicoTit = medicoTit;
        this.fecha = fecha;
        this.hora = hora;
        this.receta = receta;
        this.sucursal = sucursal;
    }
    
    public Cita(int idCita, Paciente paciente, Medico medicoAux, Medico medicoTit, LocalDate fecha, LocalTime hora) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medicoAux = medicoAux;
        this.medicoTit = medicoTit;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public Cita(int idCita, Paciente paciente, Medico medicoAux, Medico medicoTit, LocalDate fecha, LocalTime hora, int idreceta,String sucursal) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medicoAux = medicoAux;
        this.medicoTit = medicoTit;
        this.fecha = fecha;
        this.hora = hora;
        this.receta = (idreceta!=0)?(new Receta(idreceta)):null;
        this.sucursal = sucursal;
    }

    public Cita(Paciente paciente, Medico medicoAux, Medico medico, String fecha, String hora, String sucursal,LocalTime duracion) {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT MAX(idcita) as ID from cita;");
            result.next();
            this.idCita = result.getInt("ID") + 1;
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error CC: "+e.getMessage()+" CurrentId: "+this.idCita);
        }
        this.paciente = paciente;
        this.medicoTit = medico;
        this.medicoAux = medicoAux;
        this.fecha = LocalDate.parse(fecha);
        this.hora = LocalTime.parse(hora);
        this.sucursal = sucursal;
        this.duracion = duracion;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    
    public String crearCita(){
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            db.insertQuery("insert into cita (idcita,curppaciente,curpmedaux,curpmedtit,fecha,hora,sucursal,duracion) values("+this.idCita+",'"+this.paciente.getCurp()+"','"+this.medicoAux.getCurp()+"','"+this.medicoTit.getCurp()+"','"+this.fecha+"','"+this.hora+"','"+this.sucursal+"','"+this.duracion+"');");
            ResultSet result = db.executeQuery("select count(*) as rel from pacientemedico where curp='"+this.paciente.getCurp()+"' and curpmedico='"+this.medicoTit.getCurp()+"';");
            result.next();
            if(result.getInt("rel")==0)
                db.insertQuery("insert into pacientemedico values('"+this.paciente.getCurp()+"','"+this.medicoTit.getCurp()+"');");
            db.closeConection();
            return "OK";
        } catch (Exception e) {
            return "Error CRC: " + e.getMessage();
        }
    }
    
    public void modifCita() throws SQLException{
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        String cons = "UPDATE cita SET "
                + "curpmedaux='"+this.medicoAux.getCurp()+"', "
                + "curpmedtit='"+this.medicoTit.getCurp()+"', "
                + "fecha='"+this.fecha+"',"
                + "hora='"+this.hora+"',"
                + "sucursal='"+this.sucursal+"',"
                + "duracion='"+this.duracion+"' where "
                + "idcita="+this.idCita+";";
        db.updateQuery(cons);
        db.closeConection();
    }
    
    public void cancelarCita() throws SQLException{
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        String cons = "DELETE FROM cita WHERE idcita="+this.idCita+";";
        
        db.deleteQuery(cons);
        db.closeConection();
    }
    
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    public void getAllData() throws SQLException{
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        ResultSet result = db.executeQuery("select * from cita where idcita="+getIdCita()+";");
        result.next();
        setSucursal(result.getString("sucursal"));
        setFecha(LocalDate.parse(result.getString("fecha")));
        setHora(LocalTime.parse(result.getString("hora")));
        setPaciente(new Paciente(result.getString("curppaciente")));
        setMedicoTit(new Medico(result.getString("curpmedtit"), true));
        setMedicoAux(new Medico(result.getString("curpmedaux"), false));
        db.closeConection();
    }
}
