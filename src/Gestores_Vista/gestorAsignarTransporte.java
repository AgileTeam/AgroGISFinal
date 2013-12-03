/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.Vehiculo;
import Clases_Modulo_Viaje.Viaje;
import Hibernate.GestorHibernate;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ale
 */
public class gestorAsignarTransporte extends GestorHibernate{
    
    public void RellenarTablaViajes(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Iterator ite = this.listarClase(Viaje.class).iterator();
        while(ite.hasNext()){
            Viaje viaje = (Viaje) ite.next();
            if(viaje.getEstado().equalsIgnoreCase("Pendiente")){
                 Object fila[]= {viaje.getIdViaje(),viaje.getFecha(), viaje.getProductor()};
                 modelo.addRow(fila);
            }
        }
        tabla.setModel(modelo);
    }
    
     public void RellenarTablaVehiculo(JTable tabla, Viaje viaje1){
        ArrayList dominios = new ArrayList();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int bandera = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        
        Iterator ite1 = this.listarClase(Vehiculo.class).iterator();
        while(ite1.hasNext()){
          Vehiculo vehiculo = (Vehiculo) ite1.next();
          if(vehiculo.getEstado().equalsIgnoreCase("Disponible")){
              Object fila[]={vehiculo.getDominio(), vehiculo.getCarga(), vehiculo.getTransportista()};
              modelo.addRow(fila);
            }
            }
        
        Iterator ite = this.listarClase(Viaje.class).iterator();
        while(ite.hasNext()){
              Viaje viaje = (Viaje) ite.next();
              if(viaje.getEstado().equalsIgnoreCase("Con vehiculo asignado")){
              bandera=1;
                 Date fecha1 = sdf.parse(viaje1.getFecha(), new ParsePosition(0));
                 Date fecha3 = sdf.parse(viaje.getFecha(), new ParsePosition(0));                
                 if(fecha1.after(fecha3) || fecha1.before(fecha3)){
                     int bandera1 = 0;
                     for(int i = 0; i< modelo.getRowCount(); i++){
                     if(viaje.getVehiculo().getDominio().equalsIgnoreCase(modelo.getValueAt(i, 0).toString())){
                          bandera1 = 1;
                     }
                     }
                     if(bandera1 == 0){
                          Object fila[]={viaje.getVehiculo().getDominio(), viaje.getVehiculo().getCarga(), viaje.getVehiculo().getTransportista()};
                          modelo.addRow(fila);
                          
                     }
                     }
                     }
                 
                 }
            Iterator ite2 = this.listarClase(Viaje.class).iterator();
            while(ite2.hasNext()){
                Viaje v = (Viaje) ite2.next();
                Date fecha1 = sdf.parse(viaje1.getFecha(), new ParsePosition(0));
                Date fecha3 = sdf.parse(v.getFecha(), new ParsePosition(0)); 
                if(v.getEstado().equalsIgnoreCase("Con vehiculo asignado")){
                   if(fecha1.equals(fecha3)){
                   int bandera2 = 0;
                   for(int i = 0; i< modelo.getRowCount(); i++){
                      if(v.getVehiculo().getDominio().equalsIgnoreCase(modelo.getValueAt(i, 0).toString())){
                          bandera2 = 1;
                              }
                          }
                          String hora = v.getHora().substring(0, 2);
                          String hora1 = viaje1.getHora().substring(0, 2);
                          if((Integer.parseInt(hora) != Integer.parseInt(hora1))){
                          if(bandera2 == 0){
                          Object fila[]={v.getVehiculo().getDominio(), v.getVehiculo().getCarga(), v.getVehiculo().getTransportista()};
                          modelo.addRow(fila);
                          }                           
                          }else{
                           for(int i = 0; i< modelo.getRowCount(); i++){
                           if(v.getVehiculo().getDominio().equalsIgnoreCase(modelo.getValueAt(i, 0).toString())){
                               modelo.removeRow(i);
                              }
                          }
                              
                          }
                          }
                 }
                
            }
         
        tabla.setModel(modelo);
    }
}
