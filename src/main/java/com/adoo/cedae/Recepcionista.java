/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Recepcionista extends Empleado {

    private int idRecepcionista;
    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Cita> citas;

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
    
    

    public Recepcionista(int idRecepcionista, String area, String nombre, String apellidos, String curp, int edad, String email, String password, long telefono, LocalDate fechaNacimiento, LocalDate fechaRegistro) {
        super(area, nombre, apellidos, curp, edad, email, password, telefono, fechaNacimiento, fechaRegistro);
        this.idRecepcionista = idRecepcionista;
    }

    public Recepcionista(int idRecepcionista, String area) {
        super(area);
        this.idRecepcionista = idRecepcionista;
    }

    public Recepcionista() {
    }

    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public String generarCita(Paciente paciente, Medico medico, Medico medicoAux, String sucursal, String fecha, String hora, int duracion) {
        LocalTime duraC = LocalTime.of(0, 0);
        Cita nuevaCita = new Cita(paciente, medicoAux, medico, fecha, hora, sucursal,duraC.plusMinutes(duracion*15));
        return nuevaCita.crearCita();
    }

    public void cancelarCita(int idcita) throws SQLException{
        for (int i = 0; i<citas.size(); i++){
            if(idcita==citas.get(i).getIdCita()){
                citas.get(i).cancelarCita();
                citas.remove(i);
                break;
            }
        }
    }

    public void modificarCita(int idcita, String curpMedicoAux, String curpMedicoTit, LocalDate fecha, LocalTime hora) throws SQLException {
        for (int i = 0; i<citas.size(); i++){
            if(idcita==citas.get(i).getIdCita()){
                 for (int j = 0; j<medicos.size(); j++){
                     if(curpMedicoAux.equals(medicos.get(j).getCurp())){
                         citas.get(i).setMedicoAux(medicos.get(j));
                         citas.get(i).setSucursal(medicos.get(j).getSucursal());
                     }
                     if(curpMedicoTit.equals(medicos.get(j).getCurp())){
                         citas.get(i).setMedicoTit(medicos.get(j));
                     }
                 }
                 citas.get(i).setFecha(fecha);
                 citas.get(i).setHora(hora);
                 
                 citas.get(i).modifCita();
                break;
            }
        }
    }

     public ArrayList<Medico> GetMedicos() throws SQLException {
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        ResultSet result = db.executeQuery("SELECT * FROM medico;");
        while (result.next()) {
            medicos.add(new Medico(result.getString("curp"),result.getBoolean("tipomed")));
        }
        return medicos;
     }
     
     public ArrayList<Paciente> GetPacientes() throws SQLException {
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        ResultSet result = db.executeQuery("SELECT * FROM paciente;");
        while (result.next()) {
            pacientes.add(new Paciente(result.getString("curp")));
        }
        return pacientes;
     } 
    
    public ArrayList<Cita> GetCitas() throws SQLException {
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        ResultSet result = db.executeQuery("SELECT * FROM cita;");
        int indexMedicoTit = 0;
        int indexMedicoAux = 0;
        int indexPaciente = 0;
        while (result.next()) {
            for (int i=0; i<medicos.size();i++){
                if(result.getString("curpmedtit").equals(medicos.get(i).getCurp())){
                    indexMedicoTit=i;
                }
                if(result.getString("curpmedaux").equals(medicos.get(i).getCurp())){
                    indexMedicoAux=i;
                }
            }
            
            for (int i=0; i<pacientes.size();i++){
                if(result.getString("curppaciente").equals(pacientes.get(i).getCurp())){
                    indexPaciente=i;
                }
            }
            
            citas.add(new Cita(result.getInt("idcita"),pacientes.get(indexPaciente), medicos.get(indexMedicoAux),medicos.get(indexMedicoTit), LocalDate.parse(result.getString("fecha")), LocalTime.parse(result.getString("hora")), result.getInt("idcita"), result.getString("sucursal")));
        }
        db.closeConection();
        return citas;
    }

    private int getNumeroDeEmpleados(String sucursal, String tipoEmpleado) {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT count(*) as NE FROM empleado where puesto = '" + tipoEmpleado + "' and sucursal = '" + sucursal + "';");
            result.next();
            int ne = result.getInt("NE");
            db.closeConection();
            return ne;
        } catch (Exception e) {
            System.out.println("Error NDE: "+e.getMessage());
            return -1;
        }
    }

    public boolean[] getHorarioParaCita(String fecha, String sucursal, int duracion) {
        boolean schedule[] = new boolean[40];
        int auxiliar[] = new int[40];
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT hora,duracion FROM cita where fecha = '" + fecha + "' and sucursal = '" + sucursal + "' order by curpmedtit;");
            while (result.next()) {
                LocalTime hora = LocalTime.parse(result.getString("hora"));
                int index = ((hora.getHour() + (hora.getMinute()/15)) - 9)*4;
                for(int i = 0; i <= (hora.getMinute()/15); i++) 
                    auxiliar[index+i]++;
            }
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error GHC: "+e.getMessage());
            return null;
        }
        
        int limit = getNumeroDeEmpleados(sucursal,"doctor titular");
        for (int i = 0; i < 37; i++) {
            schedule[i] = true;
            for (int j = 0; j < duracion; j++) {
                if((auxiliar[i+j]+1)>limit){
                    schedule[i] = false;
                    break;
                }
                if(i>=3){
                    if((auxiliar[i-j]+1)>limit){
                    schedule[i] = false;
                    break;
                }
                }
            }
        }
        return schedule;
    }

    public String medicoTitDisponible(String date, String sucursal, String time, int duration) {
        try {
            String bussyTime = "";
            LocalTime hora = LocalTime.parse(time);
            for (int i = 0; i < duration; i++) {
                bussyTime += "'"+hora.plusMinutes(i*15)+"',";
            }
            bussyTime = bussyTime.substring(0, bussyTime.length()-1);
            
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("select curp from empleado where puesto = 'DOCTOR TITULAR' and sucursal = '"+sucursal
                    +"' and curp not in(select curpmedtit from cita where fecha = '"+date+"' and hora in("+bussyTime+")) order by rand();");
            result.next();
            bussyTime = result.getString("curp");
            db.closeConection();
            return bussyTime;
        } catch (Exception e) {
            System.out.println("Error MTD: "+e.getMessage());
            return null;
        }
    }
    
    public String medicoAuxDisponible(String date, String sucursal, String time, int duration) {
        try {
            String bussyTime = "";
            LocalTime hora = LocalTime.parse(time);
            for (int i = 0; i < duration; i++) {
                bussyTime += "'"+hora.plusMinutes(i*15)+"',";
            }
            bussyTime = bussyTime.substring(0, bussyTime.length()-1);
            
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("select curp from empleado where puesto = 'DOCTOR AUXILIAR' and sucursal = '"+sucursal
                    +"' and curp not in(select curpmedtit from cita where fecha = '"+date+"' and hora in("+bussyTime+")) order by rand();");
            result.next();
            bussyTime = result.getString("curp");
            db.closeConection();
            return bussyTime;
        } catch (Exception e) {
            System.out.println("Error MAD: "+e.getMessage());
            return null;
        }
    }

}
