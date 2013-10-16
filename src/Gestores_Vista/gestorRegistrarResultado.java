/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Carga.MuestraTomada;
import Hibernate.GestorHibernate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandra
 */
public class gestorRegistrarResultado extends GestorHibernate {
    
       public DefaultComboBoxModel rellenaComboProductor(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Productor.class).iterator();
       while(ite.hasNext()){
           Productor p =(Productor) ite.next();
               modelo.addElement(p);
           }
       return modelo;
   }
       
       public int buscarObjeto(JTable tabla, MuestraTomada d){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       int bandera = 0;
       for(int i=0; i<modelo.getRowCount(); i++){
           if(d.getNumeroMuestra() == tabla.getValueAt(i, 1)){
               bandera=1;
           }
       }
       return bandera;
   }
    
}
