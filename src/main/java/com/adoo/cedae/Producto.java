/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Producto {
    private String sku;
    private String Tamano;
    private String nombre;
    private Float precio;
    private String sucursal;
    private ArrayList<Lote> lotes;

    public Producto(String sku, String Tamano, Float precio, String nombre, String sucursal, ArrayList<Lote> lotes) {
        this.sku = sku;
        this.Tamano = Tamano;
        this.nombre = nombre;
        this.precio = precio;
        this.sucursal = sucursal;
        this.lotes = lotes;
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
    
    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getsucursal() {
        return sucursal;
    }

    public void setsucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }
    
    public void agregProd() throws SQLException{
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        String json = "'{\"lotes\":[";
        for (int i=0;i<this.lotes.size();i++){
            String lote = "{\"nlote\":\""+lotes.get(i).getnLote()
                    +"\",\"unidades\":"+String.valueOf(lotes.get(i).getUnidades())
                    +",\"fcad\":"+lotes.get(i).getFcad().toString()
                    +"\"}";
            if(i!=this.lotes.size()-1){
                lote = lote + ",";
            }
            json= json + lote;
        }
        
        String cons = "INSERT INTO medicamento values('"
                +this.sku+"','"+this.Tamano+"','"+String.valueOf(this.precio)+"','"+this.nombre+"','"+this.sucursal+"','"+json+"');";
        db.insertQuery(cons);
        db.closeConection();
    }
    
    public void modProd() throws SQLException{
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        String json = "'{\"lotes\":[";
        for (int i=0;i<this.lotes.size();i++){
            String lote = "{\"nlote\":\""+lotes.get(i).getnLote()
                    +"\",\"unidades\":"+String.valueOf(lotes.get(i).getUnidades())
                    +",\"fcad\":"+lotes.get(i).getFcad().toString()
                    +"\"}";
            if(i!=this.lotes.size()-1){
                lote = lote + ",";
            }
            json= json + lote;
        }
        
        String cons = "UPDATE medicamento SET "
                + "tamano='"+this.Tamano+"', "
                + "precio="+String.valueOf(this.precio)+","
                + "nombre='"+this.nombre+"',"
                + "sucursal='"+this.sucursal+"',"
                + "lote='"+json+"' where"
                + "sku='"+this.sku+"';";
        db.insertQuery(cons);
        db.closeConection();
    }
    
    public void elimProd() throws SQLException{
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        String cons = "DELETE FROM medicamento WHERE sku='"+this.sku+"';";
        
        db.deleteQuery(cons);
        db.closeConection();
    }
    
    public Producto verProd(){
        return this;
    }
    
    public void agregLote(String nLote, int unidades, String date){
        Lote nuevo = new Lote(nLote, unidades, date);
        this.lotes.add(nuevo);
    }
    
    public void modifLote(String nLote, int unidades, String date) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         for(int i = 0 ; i < this.lotes.size() ; i++){
             if(lotes.get(i).getnLote().equals(nLote)){
                 lotes.get(i).setnLote(nLote);
                 lotes.get(i).setUnidades(unidades);
                 java.util.Date utilDate = format.parse(date);
                 lotes.get(i).setFcad(new java.sql.Date(utilDate.getTime()));
                 break;
             }
         }
    }
    
    public void elimLote(String nLote){
         for(int i = 0 ; i < this.lotes.size() ; i++){
             if(lotes.get(i).getnLote().equals(nLote)){
                 lotes.remove(i);
                 break;
             }
         }
    }
}
