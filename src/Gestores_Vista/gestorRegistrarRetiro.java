/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Carga.SolicitudRetiro;
import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Transporte.Transportista;
import Clases_Modulo_Transporte.Vehiculo;
import Clases_Modulo_Viaje.Viaje;
import Hibernate.GestorHibernate;

import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charito
 */
public class gestorRegistrarRetiro extends GestorHibernate {
    
       public JTable rellenaTablaProductor(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo = (Vehiculo) ite.next();
           if(vehiculo.getEstado().equals("Pendiente")){
           Object fila[]= {vehiculo.getDominio(), vehiculo.getCarga(), vehiculo.getTransportista()};
           modeloT.addRow(fila);
           }
          
       }
       tabla.setModel(modeloT);
       return tabla;
   }
       
       public int buscarObjeto(JTable tabla, SolicitudRetiro sol ){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       int bandera = 0;
       for(int i=0; i<modelo.getRowCount(); i++){
           if(sol.getNumeroSolicitud() == tabla.getValueAt(i, 0)){
               bandera=1;
           }
       }
       Iterator ite = this.listarClase(Viaje.class).iterator();
       while(ite.hasNext()){
           Viaje v = (Viaje) ite.next();
           if((v.getEstado().equalsIgnoreCase("Con vehiculo asignado")) && (v.getSolicitud().getNumeroSolicitud() != sol.getNumeroSolicitud())){
               bandera=1;
           }else{
               bandera=0;
           }
       }
       return bandera;
    }
       
       public void cargarTabla(JTable tabla, SolicitudRetiro solicitud){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       Object fila[]={solicitud.getNumeroSolicitud(), solicitud.getProductor(), solicitud.getFechaSolicitud(), solicitud.getEstado()};
       modelo.addRow(fila);
       tabla.setModel(modelo);
   
   } 
        
      public DefaultComboBoxModel rellenaComboProductor(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Productor.class).iterator();
       while(ite.hasNext()){
           Productor productor =(Productor) ite.next();
               modelo.addElement(productor);
               
           }

       return modelo;
   }  
}
