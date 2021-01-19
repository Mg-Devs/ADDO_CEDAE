/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae;

import com.adoo.cedae.resources.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    
    private String sucursal;
    
    private String prodJson;
    
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
    
    public Receta(int idReceta, String diagnostico, String cie, String descripcion, String observ, String planseg, float peso, float estatura, String presArterial, String frecCardiaca, String frecResp, String temp, String prodJson) {
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
        this.prodJson = prodJson;
    }

    public Receta(String diagnostico, String cie, String descripcion, String observ, String planseg, float peso, float estatura, String presArterial, String frecCardiaca, String frecResp, String temp, String prodJson) {
        try {
            ConexionMySQL db = new ConexionMySQL();
            db.conectarMySQL();
            ResultSet result = db.executeQuery("SELECT MAX(idreceta) as ID from receta;");
            result.next();
            this.idReceta = result.getInt("ID") + 1;
            db.closeConection();
        } catch (Exception e) {
            System.out.println("Error CR: "+e.getMessage()+" CurrentId: "+this.idReceta);
        }
        
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
        this.prodJson = prodJson;
    }
    
    

    public Receta(int idReceta) {
        this.idReceta = idReceta;
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

    public void saveReceta(int idCita) throws SQLException {
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        ResultSet result = db.executeQuery("SELECT * FROM cita where idcita = "+idCita+";");
        if(!result.next()){
            db.closeConection();
            throw new SQLException("Cita no encotrada");
        }
        String curp = result.getString("curppaciente");
        String direccion = "";
        if(result.getString("sucursal").equals("Satelite"))
            direccion = "Circuito Cirujanos #11 int 201, Cd. Satélite, 53100 Naucalpan de Juárez, Méx.";
        else if(result.getString("sucursal").equals("La Roma"))
            direccion = "Tuxpan 2 interior 902, colonia Roma Sur, Cuauhtémoc, Ciudad de México";
        
        db.insertQuery("insert into receta values("+getIdReceta()+",'"+direccion+"','"+getDiagnostico()+"','"+getCie()+"','"+getDescripcion()+"','"+getObserv()+"','"+getPlanseg()+"','"+getProdJson()+"',"+getPeso()+","+getEstatura()+",'"+getPresArterial()+"',"+getFrecCardiaca()+","+getFrecResp()+","+getTemp()+");");
        db.updateQuery("update cita set idreceta = "+getIdReceta()+" where idcita = "+idCita+";");
        db.updateQuery("update expediente set padecimientoactual='"+getDescripcion()+"', peso="+getPeso()+",  estatura="+getEstatura()+", presionarterial='"+getPresArterial()+"', frecuenciacardiaca="+getFrecCardiaca()+", frecuenciarespiratoria="+getFrecResp()+", temperatura="+getTemp()+", diagnostico='"+getDiagnostico()+"',cie='"+getCie()+"',descripcion='"+getDescripcion()+"', observaciones='"+getObserv()+"', planseguimiento='"+getPlanseg()+"', fechamodif='"+LocalDate.now()+"' where curp = '"+curp+"';");
        db.closeConection();
    }

    public String getProdJson() {
        return prodJson;
    }

    public void setProdJson(String prodJson) {
        this.prodJson = prodJson;
    }

    public void getAllData() throws SQLException {
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        ResultSet result = db.executeQuery("select * from receta where idreceta="+getIdReceta()+";");
        result.next();
        setSucursal(result.getString("direccionsucursal"));
        setSucursal(result.getString("diagnostico"));
        setCie(result.getString("cie"));
        setDescripcion(result.getString("descripcion"));
        setObserv(result.getString("observaciones"));
        setPlanseg(result.getString("planseguimiento"));
        setProdJson(result.getString("productos"));
        setPeso(Float.parseFloat(result.getString("peso")));
        setEstatura(Float.parseFloat(result.getString("estatura")));
        setPresArterial(result.getString("presionarterial"));
        setFrecCardiaca(result.getString("frecuenciacardiaca"));
        setFrecResp(result.getString("frecuenciarespiratoria"));
        setTemp(result.getString("temperatura"));
        db.closeConection();
    }
    
    public int getIdCitaReceta() throws SQLException{
        ConexionMySQL db = new ConexionMySQL();
        db.conectarMySQL();
        ResultSet result = db.executeQuery("select idcita from cita where idreceta="+getIdReceta()+";");
        result.next();
        int idRes = Integer.parseInt(result.getString("idcita"));
        db.closeConection();
        return idRes;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    public ArrayList<Producto> JSONtoProduct(){
        try {
            ArrayList<Producto> productos = new ArrayList<>();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(this.prodJson);
            JSONArray array = (JSONArray) obj;
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = (JSONObject) array.get(i);
            
                String type = (String) jsonObject.get("type");
                String name = (String) jsonObject.get("name");
                String instr = (String) jsonObject.get("instructions");

                productos.add(new Producto(name, instr,type));
            }
            
            return productos;
        } catch (ParseException ex) {
            Logger.getLogger(Receta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
