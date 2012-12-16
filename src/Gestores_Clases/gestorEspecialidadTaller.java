/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import Clases_Modulo_Transporte.Especialidad;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandra
 */
public class gestorEspecialidadTaller extends GestorHibernate{
    
    public void actualizarEspecialidad(long idEspecialidad, JTextField txtEspecialidad){
     Iterator ite = this.listarClase(Especialidad.class).iterator();
     while(ite.hasNext()){
       Especialidad p = (Especialidad) ite.next();
       if(p.getIdEspecialidad() == idEspecialidad){
           p.setNombreEspecialidad(txtEspecialidad.getText());
           this.actualizarObjeto(p);
       }
   }
     
     }
    
    public void guardarEspecialidad(JTable tabla){
     DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();      
        Iterator iterator = this.listarClase(Especialidad.class).iterator();
        if(iterator.hasNext()==false){
            Especialidad pais = new Especialidad();
            pais.setNombreEspecialidad((String)modeloTabla.getValueAt(0,0));
            this.guardarObjeto(pais);
            }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int bandera=0;
                Especialidad pais = new Especialidad();
                Iterator ite = this.listarClase(Especialidad.class).iterator();
                while(ite.hasNext()){
                    Especialidad p = (Especialidad) ite.next();
                    if(p.getNombreEspecialidad()==((String)modeloTabla.getValueAt(i,0))){
                         bandera=1;               
                    }
                }
                if(bandera==0){
                pais.setNombreEspecialidad((String) modeloTabla.getValueAt(i, 0));
                this.guardarObjeto(pais);
                }
                }
     
     }
}
