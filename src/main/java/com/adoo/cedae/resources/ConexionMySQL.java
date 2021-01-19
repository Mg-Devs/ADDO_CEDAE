package com.adoo.cedae.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySQL {
    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "cedae2";
    //public String database = "cedae2";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "123456789";
    //public String password = "123456";
    
    //Conector
    private Connection conn = null;
    //Statement
    private Statement statement;

    //Abre la conexion
    public void conectarMySQL() throws SQLException {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Cierra la conexion
    public void closeConection() throws SQLException{
        this.conn.close();
    }
    
    public ResultSet executeQuery(String query) throws SQLException{
        this.statement = (Statement) conn.createStatement();
        return this.statement.executeQuery(query);
    }
    
    public void updateQuery(String queary) throws SQLException {
        this.statement = (Statement) conn.createStatement();
        this.statement.executeUpdate(queary);
    }
    
    public void deleteQuery(String query) throws SQLException{
        this.statement = (Statement) conn.createStatement();
        this.statement.executeUpdate(query);
    }
    
    public void insertQuery(String queary) throws SQLException {
        this.statement = (Statement) conn.createStatement();
        this.statement.executeUpdate(queary);
    }
    
}
