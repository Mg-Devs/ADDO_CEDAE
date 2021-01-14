/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import java.sql.Date;

/**
 *
 * @author mario
 */
public class Lote {
    private String nLote;
    private int unidades;
    private Date fcad;

    public Lote(String nLote, int unidades, String date) {
        this.nLote = nLote;
        this.unidades = unidades;
        this.fcad = Date.valueOf(date);
    }

    public String getnLote() {
        return nLote;
    }

    public void setnLote(String nLote) {
        this.nLote = nLote;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Date getFcad() {
        return fcad;
    }

    public void setFcad(Date fcad) {
        this.fcad = fcad;
    }
    
    
}
