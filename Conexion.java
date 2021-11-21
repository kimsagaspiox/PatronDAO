/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Zonia Roldan
 */
public class Conexion {
public Connection conectar = null;
    
    String usuario = "postgres";
    String contraseña = "Programacion2";
    String basededatos = "javadb";
    String ip = "localhost";
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + basededatos;
    
    public Connection EstablerConexion(){
        
        try {
            
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contraseña);
            System.out.println("Se ha realizado la conexion correctamente");
            
        }
        
        catch (Exception e){
            System.out.println("Erro al conectar con la base de datos: " + e.toString());
        }
        
        return conectar;
        
    }
    public void cerrar() throws SQLException{
        if (conectar.isClosed()){
            conectar.close();
        }
    }    
}
