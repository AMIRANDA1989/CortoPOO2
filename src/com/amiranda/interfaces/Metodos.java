/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amiranda.interfaces;

import com.amiranda.modelo.Persona;
import java.util.ArrayList;

/**
 *
 * @author LN710Q
 */
public interface Metodos{
    public boolean create (Persona a);
    public boolean delete(String id);
    public boolean update (Persona a);
    
    public Persona read(String id);
    public ArrayList<Persona> readAll();
}
