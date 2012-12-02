/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.EnvioTaller;
import Clases_Modulo_Transporte.OrdenServicio;
import Clases_Modulo_Transporte.Transportista;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ale
 */
public class gestorConsultaReparaciones extends GestorHibernate{
    
     public int buscarObjeto(JTable tabla, OrdenServicio orden ){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       int bandera = 0;
       for(int i=0; i<modelo.getRowCount(); i++){
           if(orden.getNumeroOrden() == tabla.getValueAt(i, 1)){
               bandera=1;
           }
       }
       return bandera;
   }
    
    
   public void cargarTabla(JTable tabla, OrdenServicio orden, EnvioTaller envio){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       Object fila[]={orden.getFecha(), orden.getNumeroOrden(), orden.getVehiculo().getTransportista(),envio.getImporteTotal()};
       modelo.addRow(fila);
       tabla.setModel(modelo);
   
   } 
   
    
       public DefaultComboBoxModel rellenaComboTransportista(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Transportista.class).iterator();
       while(ite.hasNext()){
           Transportista transportista =(Transportista) ite.next();
               modelo.addElement(transportista);
               
           }

       return modelo;
   }
    
}
