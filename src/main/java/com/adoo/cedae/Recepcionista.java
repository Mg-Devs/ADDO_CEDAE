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

/**
 *
 * @author mario
 */
public class Recepcionista extends Empleado {

    private int idRecepcionista;

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

    public void cancelarCita() {

    }

    public void modificarCita() {

    }

    public void verCita() {

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
