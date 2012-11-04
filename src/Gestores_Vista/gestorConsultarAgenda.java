/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Viaje.Viaje;
import Hibernate.GestorHibernate;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserCellEditor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ale
 */
public class gestorConsultarAgenda extends GestorHibernate{
    
    public void cargarAgenda(JTable tabla, Date fecha, String rutaPendiente, String rutaAsignado, String rutaEnProceso, String rutaFinalizado, String productor, Viaje viaje){
        int dia = 0;
        //Cargo la tabla con una fila nueva vacia
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object fila[]={null,null ,null ,null ,null ,null ,null};
        modelo.addRow(fila);
        //Obtengo el dia de la semana al cual pertenece la fecha seleccionada
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        dia = cal.get(Calendar.DAY_OF_WEEK);
        //Busco los viajes
        if(viaje.getEstado()== "Pendiente"){
            for(int i=0; i< modelo.getRowCount(); i++){
                if(modelo.getValueAt(i, dia-1)== null){
                     JLabel label = new JLabel();
                     label.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaPendiente)));
                     label.setText(productor);
                     Object fila1[]={label};
                     modelo.setValueAt(fila1, i, dia-1);
                     tabla.setModel(modelo);                   
                    }
                }
            
            }
            if(viaje.getEstado()== "Con vehiculo asignado"){
                    for(int i=0; i< modelo.getRowCount(); i++){
                        if(modelo.getValueAt(i, dia-1)== null){
                            JLabel label = new JLabel();
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaAsignado)));
                            label.setText(productor);
                            Object fila1[]={label};
                            modelo.setValueAt(fila1, i, dia-1);
                            tabla.setModel(modelo);                   
                    }
                }
            
            }
            
            if(viaje.getEstado()== "En Proceso"){
                    for(int i=0; i< modelo.getRowCount(); i++){
                        if(modelo.getValueAt(i, dia-1)== null){
                            JLabel label = new JLabel();
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaAsignado)));
                            label.setText(productor);
                            Object fila1[]={label};
                            modelo.setValueAt(fila1, i, dia-1);
                            tabla.setModel(modelo);                   
                    }
                }
            
            }
        
            if(viaje.getEstado()== "Finalizado"){
                    for(int i=0; i< modelo.getRowCount(); i++){
                        if(modelo.getValueAt(i, dia-1)== null){
                            JLabel label = new JLabel();
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaAsignado)));
                            label.setText(productor);
                            Object fila1[]={label};
                            modelo.setValueAt(fila1, i, dia-1);
                            tabla.setModel(modelo);                   
                    }
                }
            
            }
    }
    
}
