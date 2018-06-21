/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amiranda.modelo;

/**
 *
 * @author LN710Q
 */
public class Persona {
    private int id;
    private String numAfiliacion;
    private String nombre;
    private String apellido;
    private int edad;
    private String profesion;
    private int estado;

    public Persona() {
    }

    public Persona(int id, String numAfiliacion, String nombre, String apellido, int edad, String profesion, int estado) {
        this.id = id;
        this.numAfiliacion = numAfiliacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.profesion = profesion;
        this.estado = estado;
    }

    public Persona(String numAfiliacion, String nombre, String apellido, int edad, String profesion, int estado) {
        this.numAfiliacion = numAfiliacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.profesion = profesion;
        this.estado = estado;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumAfiliacion() {
        return numAfiliacion;
    }

    public void setNumAfiliacion(String numAfiliacion) {
        this.numAfiliacion = numAfiliacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
    
}
