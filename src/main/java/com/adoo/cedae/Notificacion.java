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
public class Notificacion {
    private Date fecha;
    private String priority;
    private String text;

    public Notificacion(String fecha, String priority, String text) {
        this.fecha = Date.valueOf(fecha);
        this.priority = priority;
        this.text = text;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
