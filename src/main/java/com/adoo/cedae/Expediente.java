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
public class Expediente {
    private int noExpediente;
    private String estadoCivil;
    private String direccion;
    private char genero;
    private String ocupacion;
    private String alergias;
    private ArrayList<Receta> recetas;

    public Expediente(int noExpediente, String estadoCivil, String direccion, char genero, String ocupacion, String alergias, ArrayList<Receta> recetas) {
        this.noExpediente = noExpediente;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getGenero() {
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
    
    public void crearExpediente(){
        
    }
}
