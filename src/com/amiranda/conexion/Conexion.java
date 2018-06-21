/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amiranda.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LN710Q
 */
public class Conexion {
    private String user;
    private String pass;
    private String driver;
    private String url;
    
    private Connection cnx;
    public static Conexion instance;
    
   public synchronized static Conexion conectar(){
       if(instance == null)
       {
           return new Conexion();
       }
   return instance;
    }
    public Conexion() {
        cargarCredenciales();
        
        try {
            
            Class.forName(this.driver);
            cnx = (Connection) DriverManager.getConnection(this.url,this.user,this.pass);
            System.out.println("[INFO] Conexion incializada con exito");
        }
        
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("[ERROR] Error al inicializar conexion");
        }
    }
    
        private void cargarCredenciales(){
        user= "root";
        pass="";
        driver="com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost/amirandaFinal";
    }
    public Connection getCnx(){
        return cnx;
    }
    public void cerrarConexion(){
        instance= null;
    }    
}
