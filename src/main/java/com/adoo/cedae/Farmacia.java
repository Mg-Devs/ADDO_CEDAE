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
public class Farmacia {
    private String sucursal;
    private ArrayList<Producto> productos;

    public Farmacia(String sucursal) {
        this.sucursal = sucursal;
        this.productos = null;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    
    
    
}
