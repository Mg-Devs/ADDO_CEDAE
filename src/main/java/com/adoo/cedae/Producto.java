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
public class Producto {
    private int idProd;
    private String sku;
    private String Tamano;
    private float precio;
    private ArrayList<Lote> lotes;

    public Producto(int idProd, String sku, String Tamano, float precio, ArrayList<Lote> lotes) {
        this.idProd = idProd;
        this.sku = sku;
        this.Tamano = Tamano;
        this.precio = precio;
        this.lotes = lotes;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String Tamano) {
        this.Tamano = Tamano;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }
    
    public void agregProd(){
        
    }
    
    public void modProd(){
        
    }
    
    public void elimProd(){
        
    }
    
    public Producto verProd(){
        return this;
    }
}
