/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.Vehiculo;
import Clases_Modulo_Viaje.Viaje;
import Hibernate.GestorHibernate;
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
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Iterator ite1 = this.listarClase(Vehiculo.class).iterator();
            while(ite1.hasNext()){
                Vehiculo vehiculo = (Vehiculo) ite1.next();
                int bandera =0;
                Iterator ite = this.listarClase(Viaje.class).iterator();
                while(ite.hasNext()){
                    Viaje viaje = (Viaje) ite.next();
                    if(vehiculo.getEstado().equalsIgnoreCase("Asignado")){
                    if(viaje.getFecha()== viaje1.getFecha() && viaje.getVehiculo()==vehiculo){
                        bandera=1;
                    }
                    }
                }
                 if(bandera == 0 && vehiculo.getEstado().equalsIgnoreCase("Disponible")){
                    Object fila[]={vehiculo.getDominio(), vehiculo.getCarga(), vehiculo.getTransportista()};
                    modelo.addRow(fila);
                    }
            }
        tabla.setModel(modelo);
    }
}
