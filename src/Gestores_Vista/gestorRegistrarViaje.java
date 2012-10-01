/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Cliente.Establecimiento;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author ale
 */
public class gestorRegistrarViaje extends GestorHibernate {
    
     public void ActualizarDatos(String seleccion, JPanel panelPuerto, JPanel panelEstablecimiento, JLabel labelPuerto, JLabel labelEstablecimiento, JLabel labelProvincia, JLabel labelDepartamento,
                                   JTable tblEstablecimiento, JTable tblPuerto, JScrollPane scpEstablecimiento, JScrollPane scpPuerto ){
        if (seleccion == "Traslado a Puerto"){
        panelPuerto.setVisible(true);
        panelEstablecimiento.setVisible(false);
        labelDepartamento.setVisible(false);
        labelProvincia.setVisible(true);
        labelEstablecimiento.setVisible(false);
        labelPuerto.setVisible(true);
        tblPuerto.setVisible(true);
        tblEstablecimiento.setVisible(false);
        scpEstablecimiento.setVisible(false);
        scpPuerto.setVisible(true);
        
        }if(seleccion== "Retiro"){
        panelPuerto.setVisible(false);
        panelEstablecimiento.setVisible(true);
       }
        
        if(seleccion == "Traslado a Establecimiento"){
        panelPuerto.setVisible(true);
        panelEstablecimiento.setVisible(false);
        labelDepartamento.setVisible(true);
        labelProvincia.setVisible(false);
        labelEstablecimiento.setVisible(true);
        labelPuerto.setVisible(false);
        tblEstablecimiento.setVisible(true);
        tblPuerto.setVisible(false);
        scpEstablecimiento.setVisible(true);
        scpPuerto.setVisible(false);
        }
       }
       
     public DefaultComboBoxModel AgregarProductor(String productor){
         DefaultComboBoxModel modelo = new DefaultComboBoxModel();
         Iterator ite = this.listarClase(Establecimiento.class).iterator();
         while(ite.hasNext()){
             Establecimiento establecimiento = (Establecimiento) ite.next();
             if(establecimiento.getProductor().toString() == productor){
                 modelo.addElement(establecimiento);
             }
         }
         return modelo;
     }
     
     public void CargarDatosEstablecimiento(){
     
     
     }
     
        }
    
