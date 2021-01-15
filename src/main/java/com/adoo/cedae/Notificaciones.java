/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import java.sql.Date;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Notificaciones {
    private ArrayList<Notificacion> notificaciones;
    
    public Notificaciones(){}
    
    public ArrayList<Notificacion> notisFarmacia(ArrayList<Producto> productos){
        LocalDate today = LocalDate.now();
        ArrayList<Notificacion> notificacionesDB = new ArrayList<>();
        for (Producto producto : productos) {
            int unidades = producto.getUnidadesTotales();
            long expDate = DAYS.between(today, LocalDate.parse(producto.getCaducidadProxima().toString()));
            String loteTExp = producto.getLoteCaducidadProxima();
            String prioridad;
            
            if(unidades < 15){
                if(unidades < 5)
                    prioridad = "danger";
                else
                    prioridad = "warning";
                
                notificacionesDB.add( new Notificacion(LocalDate.now().toString(), prioridad, "Quedan "+unidades+" de: "+producto.getnombre()));
            }
            
            if(expDate<90){
                if(expDate < 30)
                    prioridad = "danger";
                else if (expDate < 60)
                    prioridad = "warning";
                else
                    prioridad = "success";
                
                notificacionesDB.add( new Notificacion(LocalDate.now().toString(), prioridad, producto.getnombre() + ". Con Lote: "+loteTExp+" caducara en: "+expDate+" dias."));
                
            }
        }
        return notificacionesDB;
    }
    
}
