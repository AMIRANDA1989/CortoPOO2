/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amiranda.dao;

import com.amiranda.conexion.Conexion;
import com.amiranda.interfaces.Metodos;
import com.amiranda.modelo.Persona;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LN710Q
 */
public class FiltrosDao implements Metodos {

    private static final String SQL_INSERT = "INSERT INTO PERSONA(NUMAFILIACION,NOMBRES,APELLIDOS, EDAD, PROFESION, ESTADO) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE PERSONA SET NUMAFILIACION = ?, NOMBRES = ?, APELLIDOS = ?, EDAD = ?, PROFESION = ?, ESTADO = ? WHERE NUMAFILIACION = ?";
    private static final String SQL_DELETE = "DELETE FROM PERSONA WHERE NUMAFILIACION = ?";
    private static final String SQL_READ = "SELECT * FROM PERSONA WHERE NUMAFILIACION = ?";
    private static final String SQL_READALL = "SELECT * FROM PERSONA";

    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(Persona a) {
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, a.getNumAfiliacion());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setInt(4, a.getEdad());
            ps.setString(5, a.getProfesion());
            ps.setInt(6, a.getEstado());
            if (ps.executeUpdate() > 0) {
                System.out.println("[INFO] Registro agregado exitosamente");
                return true;
            }
        } catch (Exception ex) {
            System.out.println("[ERROR] Error al ingresar registro : " + ex.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("[INFO] Registro eliminado exitosamente");
                return true;
            }
        } catch (Exception ex) {
            System.out.println("[ERROR] Error al eliminar registro : " + ex.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Persona a) {
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.getCnx().prepareStatement(SQL_UPDATE);
            ps = (PreparedStatement) con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, a.getNumAfiliacion());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setInt(4, a.getEdad());
            ps.setString(5, a.getProfesion());
            ps.setInt(6, a.getEstado());
            ps.setString(7, a.getNumAfiliacion());
            if (ps.executeUpdate() > 0) {
                System.out.println("[INFO] Registro actualizado exitosamente");
                return true;
            }
        } catch (Exception ex) {
            System.out.println("[ERROR] Error al actualizar registro : " + ex.getMessage());
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Persona read(String id) {
        Persona f = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = (PreparedStatement) con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                f = new Persona(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
                System.out.println("[INFO] Lectura realizada con exito");
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("[ERROR] No se pudo realizar la lectura " + ex.getMessage());
            
        } finally {
            con.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<Persona> readAll() {
        Persona f= null;
        ArrayList<Persona> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try{
            s= con.getCnx().prepareStatement(SQL_READALL);
            rs= s.executeQuery(SQL_READALL);
            while(rs.next()){
                f= new Persona(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
            } 
            rs.close();
            
            System.out.println("[INFO] Lectura realizada con exito");
        }
        catch(SQLException ex){
            System.out.println("[ERROR] No se pudo realizar la lectura " + ex.getMessage());
        }
       return all;
    }

}
