/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Carga.*;
import Clases_Modulo_Cliente.Establecimiento;
import Clases_Modulo_Cliente.Productor;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class gestorRegistrarSolicitud extends GestorHibernate {
    
    public DefaultComboBoxModel rellenaComboCereal(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoCereal.class).iterator();
       while(ite.hasNext()){
           TipoCereal tipoCereal =(TipoCereal) ite.next();
           modelo.addElement(tipoCereal);
       }
       return modelo;
   }
    
    public DefaultComboBoxModel rellenaComboSilo(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Silo.class).iterator();
       while(ite.hasNext()){
           Silo silo =(Silo) ite.next();
           modelo.addElement(silo);
       }
       return modelo;
   }
    
    public JTable rellenaTablaProductor(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Productor.class).iterator();
       while(ite.hasNext()){
           Productor productor =(Productor) ite.next();
           Object fila[]= {productor.getNombre(), productor.getNumeroDocumento()};
           modeloT.addRow(fila);
       }
       tabla.setModel(modeloT);
       return tabla;
   }
    
     public DefaultComboBoxModel rellenaComboDestino(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Establecimiento.class).iterator();
       Iterator ite2 = this.listarClase(Puerto.class).iterator();
       if(seleccion=="Puerto"){
       while(ite2.hasNext()){
           Puerto puerto=(Puerto) ite2.next();
           modelo.addElement(puerto);
       }
       }else{
       while(ite.hasNext()){
           Establecimiento establecimiento=(Establecimiento) ite.next();
           modelo.addElement(establecimiento);
       }
       }
       return modelo;
   }
    
     
    public DefaultComboBoxModel rellenaComboTipoOperacion(){
    DefaultComboBoxModel modelo=new DefaultComboBoxModel();
    Iterator ite=this.listarClase(TipoOperacion.class).iterator();
    while(ite.hasNext()){
        TipoOperacion tipoOperacion=(TipoOperacion) ite.next();
        modelo.addElement(tipoOperacion);
       }
     return modelo;
    } 
     
     public void ActualizarDatos(String seleccion, JPanel panelEstablecimiento, JPanel panelPlanta){
        if (seleccion == "Retiro en Establecimiento"){
        panelEstablecimiento.setVisible(true);
        panelPlanta.setVisible(false);
//        tblEstablecimiento.setVisible(false);
//        scpEstablecimiento.setVisible(false);
//        scpPuerto.setVisible(true);
        }if(seleccion== "Retiro en Planta"){
        panelPlanta.setVisible(true);
        panelEstablecimiento.setVisible(false);
       }
      
       }
}
