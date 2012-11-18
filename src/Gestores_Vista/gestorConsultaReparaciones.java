/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.EnvioTaller;
import Clases_Modulo_Transporte.OrdenServicio;
import Hibernate.GestorHibernate;
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
    
}
