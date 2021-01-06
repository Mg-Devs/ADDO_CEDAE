/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Receta {
    private int idReceta;
    
    private String diagnostico;
    private String cie;
    private String descripcion;
    private String observ;
    private String planseg;
    
    private float peso;
    private float estatura;
    private String presArterial;
    private String frecCardiaca;
    private String frecResp;
    private String temp;
    
    private ArrayList<Producto> productos;
    private ArrayList<String> indicaciones;

    public Receta(int idReceta, String diagnostico, String cie, String descripcion, String observ, String planseg, float peso, float estatura, String presArterial, String frecCardiaca, String frecResp, String temp, ArrayList<Producto> productos, ArrayList<String> indicaciones) {
        this.idReceta = idReceta;
        this.diagnostico = diagnostico;
        this.cie = cie;
        this.descripcion = descripcion;
        this.observ = observ;
        this.planseg = planseg;
        this.peso = peso;
        this.estatura = estatura;
        this.presArterial = presArterial;
        this.frecCardiaca = frecCardiaca;
        this.frecResp = frecResp;
        this.temp = temp;
        this.productos = productos;
        this.indicaciones = indicaciones;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getCie() {
        return cie;
    }

    public void setCie(String cie) {
        this.cie = cie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public String getPlanseg() {
        return planseg;
    }

    public void setPlanseg(String planseg) {
        this.planseg = planseg;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public String getPresArterial() {
        return presArterial;
    }

    public void setPresArterial(String presArterial) {
        this.presArterial = presArterial;
    }

    public String getFrecCardiaca() {
        return frecCardiaca;
    }

    public void setFrecCardiaca(String frecCardiaca) {
        this.frecCardiaca = frecCardiaca;
    }

    public String getFrecResp() {
        return frecResp;
    }

    public void setFrecResp(String frecResp) {
        this.frecResp = frecResp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<String> getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(ArrayList<String> indicaciones) {
        this.indicaciones = indicaciones;
    }
    
    
}
