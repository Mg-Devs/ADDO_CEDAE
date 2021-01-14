/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Expediente {
    private int noExpediente;
    private int estadoCivil;
    private int genero;
    private String ocupacion;
    private String secure;
    private String alergias;
    private String antecedentesheredofam;
    private String antecedentepersonales;
    private String pacedimentoactual;
    private int peso;
    private int estatura;
    private String presArt;
    private String frecCard;
    private String frecResp;
    private float temper;
    private String topografia;
    private String morfologia;
    private String pielyAnex;
    private String tratAnterior;
    private String diagnosti;
    private String cie;
    private String descr;
    private String observaciones;
    private String planseg;
    private ArrayList<Receta> recetas;

    public Expediente(int estadoCivil, int genero, String ocupacion, String secure ,String alergias, String antecedentesheredofam, String antecedentepersonales, String pacedimentoactual, int peso, int estatura, String presArt, String frecCard, String frecResp, float temper, String topografia, String morfologia, String pielyAnex, String tratAnterior, String diagnosti, String cie, String descr, String observaciones, String planseg) {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT max(idexpediente) as ID FROM expediente;");
            result.next();
            this.noExpediente = result.getInt("ID") + 1;
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error CC: "+e.getMessage()+" CurrentId: "+this.noExpediente);
        }
        
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.secure = secure;
        this.alergias = alergias;
        this.antecedentesheredofam = antecedentesheredofam;
        this.antecedentepersonales = antecedentepersonales;
        this.pacedimentoactual = pacedimentoactual;
        this.peso = peso;
        this.estatura = estatura;
        this.presArt = presArt;
        this.frecCard = frecCard;
        this.frecResp = frecResp;
        this.temper = temper;
        this.topografia = topografia;
        this.morfologia = morfologia;
        this.pielyAnex = pielyAnex;
        this.tratAnterior = tratAnterior;
        this.diagnosti = diagnosti;
        this.cie = cie;
        this.descr = descr;
        this.observaciones = observaciones;
        this.planseg = planseg;
    }

    public Expediente(int noExpediente, int estadoCivil, int genero, String ocupacion, String secure, String alergias, String antecedentesheredofam, String antecedentepersonales, String pacedimentoactual, int peso, int estatura, String presArt, String frecCard, String frecResp, float temper, String topografia, String morfologia, String pielyAnex, String tratAnterior, String diagnosti, String cie, String descr, String observaciones, String planseg) {
        this.noExpediente = noExpediente;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.secure = secure;
        this.alergias = alergias;
        this.antecedentesheredofam = antecedentesheredofam;
        this.antecedentepersonales = antecedentepersonales;
        this.pacedimentoactual = pacedimentoactual;
        this.peso = peso;
        this.estatura = estatura;
        this.presArt = presArt;
        this.frecCard = frecCard;
        this.frecResp = frecResp;
        this.temper = temper;
        this.topografia = topografia;
        this.morfologia = morfologia;
        this.pielyAnex = pielyAnex;
        this.tratAnterior = tratAnterior;
        this.diagnosti = diagnosti;
        this.cie = cie;
        this.descr = descr;
        this.observaciones = observaciones;
        this.planseg = planseg;
    }

    
    
    public Expediente(int noExpediente, int estadoCivil, int genero, String ocupacion, String alergias, ArrayList<Receta> recetas) {
        this.noExpediente = noExpediente;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.alergias = alergias;
        this.recetas = recetas;
    }

    public int getNoExpediente() {
        return noExpediente;
    }

    public void setNoExpediente(int noExpediente) {
        this.noExpediente = noExpediente;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(ArrayList<Receta> recetas) {
        this.recetas = recetas;
    }
    
    public void modificarExpediente(){
        
    }
    
    public void visualizarExpediente(){
        
    }
    
    public void crearExpediente(String curp){
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            db.insertQuery("insert into expediente (idexpediente, curp, fechacreacion, fechamodif, alergias, antecedentesheredofamiliares, antecedentespersonales, padecimientoactual, peso, estatura, presionarterial, frecuenciacardiaca, frecuenciarespiratoria, temperatura, topografia, morfologia, pielyanexos, tratamientoanterior, diagnostico, cie, descripcion, observaciones, planseguimiento, genero)"+
                    " values("+this.noExpediente+",'"+curp+"','"+LocalDate.now()+"','"+LocalDate.now()+"','"+getAlergias()+"','"+getAntecedentesheredofam()+"','"+getAntecedentepersonales()+"','"+getPacedimentoactual()+"',"+getPeso()+","+getEstatura()+",'"+getPresArt()+"',"+getFrecCard()+","+getFrecResp()+","+getTemper()+",'"+getTopografia()+"','"+getMorfologia()+"','"+getPielyAnex()+"','"+getTratAnterior()+"','"+getDiagnosti()+"','"+getCie()+"','"+getDescr()+"','"+getObservaciones()+"','"+getPlanseg()+"',"+getGenero()+");");
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public String getAntecedentesheredofam() {
        return antecedentesheredofam;
    }

    public void setAntecedentesheredofam(String antecedentesheredofam) {
        this.antecedentesheredofam = antecedentesheredofam;
    }

    public String getAntecedentepersonales() {
        return antecedentepersonales;
    }

    public void setAntecedentepersonales(String antecedentepersonales) {
        this.antecedentepersonales = antecedentepersonales;
    }

    public String getPacedimentoactual() {
        return pacedimentoactual;
    }

    public void setPacedimentoactual(String pacedimentoactual) {
        this.pacedimentoactual = pacedimentoactual;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public String getPresArt() {
        return presArt;
    }

    public void setPresArt(String presArt) {
        this.presArt = presArt;
    }

    public String getFrecCard() {
        return frecCard;
    }

    public void setFrecCard(String frecCard) {
        this.frecCard = frecCard;
    }

    public String getFrecResp() {
        return frecResp;
    }

    public void setFrecResp(String frecResp) {
        this.frecResp = frecResp;
    }

    public float getTemper() {
        return temper;
    }

    public void setTemper(float temper) {
        this.temper = temper;
    }

    public String getTopografia() {
        return topografia;
    }

    public void setTopografia(String topografia) {
        this.topografia = topografia;
    }

    public String getMorfologia() {
        return morfologia;
    }

    public void setMorfologia(String morfologia) {
        this.morfologia = morfologia;
    }

    public String getPielyAnex() {
        return pielyAnex;
    }

    public void setPielyAnex(String pielyAnex) {
        this.pielyAnex = pielyAnex;
    }

    public String getTratAnterior() {
        return tratAnterior;
    }

    public void setTratAnterior(String tratAnterior) {
        this.tratAnterior = tratAnterior;
    }

    public String getDiagnosti() {
        return diagnosti;
    }

    public void setDiagnosti(String diagnosti) {
        this.diagnosti = diagnosti;
    }

    public String getCie() {
        return cie;
    }

    public void setCie(String cie) {
        this.cie = cie;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPlanseg() {
        return planseg;
    }

    public void setPlanseg(String planseg) {
        this.planseg = planseg;
    }

    public String getSecure() {
        return secure;
    }

    public void setSecure(String secure) {
        this.secure = secure;
    }
}
