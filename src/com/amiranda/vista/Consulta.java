/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amiranda.vista;

import com.amiranda.dao.FiltrosDao;
import com.amiranda.modelo.Persona;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    public JLabel lblNumAfiliado, lblNombre, lblApellido, lblEdad, lblProfesion, lblEstado;
    public JTextField numAFP, nombre, apellido, edad;
    public JComboBox profesion;
    public JRadioButton si;
    public JRadioButton no;
    public JTable resultados;
    ButtonGroup estados;
    
    public JPanel table;
    
    public JButton buscar, insertar, actualizar, eliminar, limpiar;
    
    public static final int ANCHOC = 130, ALTOC = 30;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Registro de Afiliados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTablas();
        Container container = getContentPane();
        container.add(this.lblNumAfiliado);
        container.add(this.lblNombre);
        container.add(this.lblApellido);
        container.add(this.lblEdad);
        container.add(this.lblProfesion);
        container.add(this.lblEstado);
        setSize(800,800);
        eventos();
        
    }
    
    public final void agregarLabels(){
        lblNumAfiliado = new JLabel("No. Afiliado");
        lblNombre = new JLabel("Nombre");
        lblApellido = new JLabel("Apellido");
        lblEdad = new JLabel("Edad");
        lblProfesion = new JLabel("Profesion");
        lblEstado = new JLabel("Estado");
        lblNumAfiliado.setBounds(10,10,ANCHOC, ALTOC);
        lblNombre.setBounds(10,60,ANCHOC, ALTOC);
        lblApellido.setBounds(10,100,ANCHOC, ALTOC);
        lblEdad.setBounds(10,140,ANCHOC, ALTOC);
        lblProfesion.setBounds(10,180,ANCHOC, ALTOC);
        lblEstado.setBounds(10,220,ANCHOC, ALTOC);
    }
    
    public final void formulario(){
        numAFP = new JTextField();
        nombre = new JTextField(); 
        apellido = new JTextField();
        edad = new JTextField();
        profesion = new JComboBox();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        limpiar = new JButton("Limpiar");
        actualizar = new JButton("Actualizar");
        
        table = new JPanel();
        
        profesion.addItem("Carpintero");
        profesion.addItem("Motorista");
        profesion.addItem("Repartidor");
        profesion.addItem("Abañil");
        profesion.addItem("Profesor");
        profesion.addItem("Estudiante");
        
        estados = new ButtonGroup();
        estados.add(si);
        estados.add(no);
        
        numAFP.setBounds(140,10,ANCHOC, ALTOC);
        nombre.setBounds(140,60,ANCHOC, ALTOC);
        apellido.setBounds(140,100,ANCHOC, ALTOC);
        edad.setBounds(140,140,ANCHOC, ALTOC);
        profesion.setBounds(140,180,ANCHOC, ALTOC);
        si.setBounds(140,220,ANCHOC, ALTOC);
        no.setBounds(201, 140, 50, ALTOC);
   
    }
    
    public void llenarTablas(){
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:
                        return String.class;
                        
                    case 1: 
                        return String.class;
                        
                    case 2:
                        return String.class;
                        
                    case 3:
                        return String.class;
                    case 4:
                        return int.class;
                        
                    default:
                        return boolean.class;
                        
                }
            }
        };
        
        tm.addColumn("No. Afiliado");
        tm.addColumn("Nombre");
        tm.addColumn("Apellido");
        tm.addColumn("Profesion");
        tm.addColumn("Estado");
    }
    
    public void eventos(){
        
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltrosDao fd =new FiltrosDao();
                Persona p;
                p = new Persona(numAFP.getText(), nombre.getText(),apellido.getText(), Integer.parseInt(edad.getText()), profesion.getSelectedItem().toString(), 1);
            
                if (fd.create(p)){
                    JOptionPane.showMessageDialog(null,"Pelicula registrado con exito");
                    //limpiarCampos();
                    llenarTablas();
                }else{
                    JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de modificar el filtro");
                }
            }
        });
    
    }
}
