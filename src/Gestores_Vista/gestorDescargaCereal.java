/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestores_Vista;

import Clases_Modulo_Carga.*;
import Clases_Modulo_Transporte.Transportista;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandra
 */
public class gestorDescargaCereal extends GestorHibernate {

    public JTable rellenaTablaProductor(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Establecimiento.class).iterator();
       while(ite.hasNext()){
           Establecimiento establecimiento = (Establecimiento) ite.next();
           Object fila[]= {establecimiento.getNombreEstablecimiento(), establecimiento.getProductor()};
           modeloT.addRow(fila);
       }
       tabla.setModel(modeloT);
       return tabla;
   }
    
     public DefaultComboBoxModel rellenaComboTipoCereal(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoCereal.class).iterator();
       while(ite.hasNext()){
           TipoCereal tipo =(TipoCereal) ite.next();
               modelo.addElement(tipo);
           }
       return modelo;
   }
     
       public DefaultComboBoxModel rellenaComboTemporada(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoTemporada.class).iterator();
       while(ite.hasNext()){
           TipoTemporada tipo =(TipoTemporada) ite.next();
               modelo.addElement(tipo);
           }
       return modelo;
   }
       
       public DefaultComboBoxModel rellenaComboSilo(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Silo.class).iterator();
       while(ite.hasNext()){
           Silo tipo =(Silo) ite.next();
               modelo.addElement(tipo.getNumeroSilo());
           }
       return modelo;
   }
       
       public DefaultComboBoxModel rellenaComboTransportista(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Transportista.class).iterator();
       while(ite.hasNext()){
           Transportista tipo =(Transportista) ite.next();
               modelo.addElement(tipo);
           }
       return modelo;
   }
}
