/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

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
            if(viaje.getEstado()== "Pendiente"){
                 Object fila[]= {viaje.getIdViaje(),viaje.getFecha(), viaje.getProductor()};
                 modelo.addRow(fila);
            }
        }
        tabla.setModel(modelo);
    }
    
}
