/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
    private String helper;

    public Producto(String sku, String Tamano, Float precio, String nombre, String sucursal, ArrayList<Lote> lotes) {
        this.sku = sku;
        this.Tamano = Tamano;
        this.nombre = nombre;
        this.precio = precio;
        this.sucursal = sucursal;
        this.lotes = lotes;
    }
    
    public Producto(String sku, String Tamano, Float precio, String nombre, String sucursal, String helper) {
        this.sku = sku;
        this.Tamano = Tamano;
        this.nombre = nombre;
        this.precio = precio;
        this.sucursal = sucursal;
        this.helper = helper;
    }

    public Producto(String sku) {
        this.sku = sku;
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
    
    public ArrayList<Lote> getLotesDB() {
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
    
    public int getUnidadesTotales(){
        long tot = 0;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(this.helper);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("lotes");
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                tot += (long) jsonObject1.get("unidades");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
                
        return (int)tot;
    }
    
    public Date getCaducidadProxima(){
        Date fecha = null;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(this.helper);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("lotes");
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                if(fecha==null)
                    fecha = Date.valueOf((String) jsonObject1.get("fcad"));
                else if(fecha.after(Date.valueOf((String) jsonObject1.get("fcad")))){
                    fecha = Date.valueOf((String) jsonObject1.get("fcad"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        
        return fecha;
    }

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }
}
