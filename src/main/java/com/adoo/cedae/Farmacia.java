/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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

    public ArrayList<Producto> Cargar_Productos() throws SQLException, ParseException {
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        ArrayList<Producto> productos = new ArrayList<>();
        ResultSet result = db.executeQuery("SELECT * FROM medicamento order by sku;");
        while (result.next()) {
            String lote = result.getString("lote");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(lote);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("lotes");
            ArrayList<Lote> lotes = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);

                String nlote = (String) jsonObject1.get("nlote");
                long unidades = (long) jsonObject1.get("unidades");
                String fcad = (String) jsonObject1.get("fcad");

                lotes.add(new Lote(nlote, (int)unidades, fcad));
            }
            productos.add(new Producto(result.getString("sku"), result.getString("tamano"), (float) result.getDouble("precio"), result.getString("nombre"), result.getString("sucursal"), lotes));
        }
        db.closeConection();
        return productos;
    }

    public ArrayList<Producto> Cargar_Productos_Sucursal(){
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            
            ResultSet result = db.executeQuery("SELECT * FROM medicamento where sucursal='" + getSucursal() + "' order by sku;");
            while (result.next()) {
                String lote = result.getString("lote");
                //System.out.println(lote);
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(lote);
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray array = (JSONArray) jsonObject.get("lotes");
                ArrayList<Lote> lotes = new ArrayList<Lote>();
                for (int i = 0; i < array.size(); i++) {
                    JSONObject jsonObject1 = (JSONObject) array.get(i);

                    String nlote = (String) jsonObject1.get("nlote");
                    int unidades = Integer.parseInt(String.valueOf(jsonObject1.get("unidades")));
                    String fcad = (String) jsonObject1.get("fcad");

                    lotes.add(new Lote(nlote, unidades, fcad));
                }
                productos.add(new Producto(result.getString("sku"), result.getString("tamano"), (float) result.getDouble("precio"), result.getString("nombre"), result.getString("sucursal"), lotes));
            }
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return productos;
        }
        return productos;
    }
    
    public void actualizar_stock_venta(String json) throws ParseException, java.text.ParseException, SQLException{
        System.out.println(json);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        System.out.println(obj);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray array = (JSONArray) jsonObject.get("productos");
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) array.get(i);
            String fcad = (String) jsonObject1.get("fcad");
            String sku = (String) jsonObject1.get("sku");
            System.out.println(fcad);
            System.out.println(sku);
            for(int j = 0 ; j < this.productos.size() ; j++){
                if(this.productos.get(j).getSku().equals(sku)){
                    Lote aux = this.productos.get(j).buscarLote(fcad);
                    System.out.println(aux);
                    this.productos.get(j).modifLote(aux.getnLote(), aux.getUnidades()-1, fcad);
                    this.productos.get(j).modProd();
                }
            }
        }

        
    }

}
