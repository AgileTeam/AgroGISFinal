/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Viaje.Viaje;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ale
 */
public class gestorEmitirOrden extends GestorHibernate{
    
    public DefaultComboBoxModel rellenaComboProductor(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Productor.class).iterator();
       while(ite.hasNext()){
           Productor prod =(Productor) ite.next();
               modelo.addElement(prod);
           }
       return modelo;
   }
    
    public int buscarObjeto(JTable tabla, Viaje viaje ){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       int bandera = 0;
       for(int i=0; i<modelo.getRowCount(); i++){
           if(viaje.getIdViaje() == tabla.getValueAt(i, 0)){
               bandera=1;
           }
       }
       return bandera;
   }
    
    public void cargarTabla(JTable tabla, Viaje viaje){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       Object fila[]={viaje.getIdViaje(), viaje.getFecha(), viaje.getProductor(), viaje.getEstado()};
       modelo.addRow(fila);
       tabla.setModel(modelo);
    }
}
