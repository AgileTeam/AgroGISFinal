/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Viaje.Viaje;
import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Viaje.IconCellRenderer;
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
    
    public void cargarAgenda(JTable tabla, Date fecha, String rutaPendiente, String rutaAsignado, String rutaEnProceso, String rutaFinalizado, Productor productor, Viaje viaje){
        tabla.setDefaultRenderer(Object.class, new IconCellRenderer());
        int dia = 0;
        //Cargo la tabla con una fila nueva vacia
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        if(modelo.getRowCount()==0){
        Object fila[]={"","" ,"" ,"" ,"" ,"" ,""};
        modelo.addRow(fila);}
        //Obtengo el dia de la semana al cual pertenece la fecha seleccionada
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        dia = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dia);
        //Busco los viajes
        if(viaje.getEstado().equalsIgnoreCase("Pendiente")){
            for(int i=0; i< modelo.getRowCount(); i++){
                if(modelo.getValueAt(i, dia)== ""){
                     JLabel label = new JLabel();
                     label.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaPendiente)));
                     label.setText(productor.getNombre());
                     modelo.setValueAt(label, i, dia);
                     tabla.setModel(modelo);         
                     i=modelo.getRowCount();
                    }
                else{ 
                    if(i <= (modelo.getRowCount()-1)){
                     Object fila[]={"","" ,"" ,"" ,"" ,"" ,""};
                     modelo.addRow(fila);
                }
                }
                }
                    
            
            }
            if(viaje.getEstado().equalsIgnoreCase("Con vehiculo asignado")){
                    for(int i=0; i< modelo.getRowCount(); i++){
                        if(modelo.getValueAt(i, dia)== ""){
                            JLabel label = new JLabel();
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaAsignado)));
                            label.setText(productor.getNombre());
                            modelo.setValueAt(label, i, dia);
                            tabla.setModel(modelo);                   
                    }
                     else{ if(i == (modelo.getRowCount()-1)){
                     Object fila[]={"","" ,"" ,"" ,"" ,"" ,""};
                     modelo.addRow(fila);
                }
                }
                }
            
            }
            
            if(viaje.getEstado().equalsIgnoreCase("En Proceso")){
                    for(int i=0; i< modelo.getRowCount(); i++){
                        if(modelo.getValueAt(i, dia) == ""){
                            JLabel label = new JLabel();
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaEnProceso)));
                            label.setText(productor.getNombre());
                            modelo.setValueAt(label, i, dia);
                            tabla.setModel(modelo);                   
                    }
                    else{ if(i == (modelo.getRowCount()-1)){
                     Object fila[]={"","" ,"" ,"" ,"" ,"" ,""};
                     modelo.addRow(fila);
                }
                }
                }
            
            }
        
            if(viaje.getEstado().equalsIgnoreCase("Finalizado")){
                    for(int i=0; i< modelo.getRowCount(); i++){
                        if(modelo.getValueAt(i, dia)== ""){
                            JLabel label = new JLabel();
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaFinalizado)));
                            label.setText(productor.getNombre());
                            modelo.setValueAt(label, i, dia);
                            tabla.setModel(modelo);                   
                    }
                    else{ if(i == (modelo.getRowCount()-1)){
                     Object fila[]={"","" ,"" ,"" ,"" ,"" ,""};
                     modelo.addRow(fila);
                }
                }
                }
            
            }
    }
    
}
