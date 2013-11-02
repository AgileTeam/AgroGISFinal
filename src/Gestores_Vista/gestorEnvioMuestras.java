/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Carga.Descarga;
import Clases_Modulo_Carga.EspecialidadLaboratorio;
import Clases_Modulo_Carga.Laboratorio;
import Clases_Modulo_Carga.MuestraTomada;
import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Transporte.Especialidad;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ale
 */
public class gestorEnvioMuestras extends GestorHibernate{
    
     public DefaultComboBoxModel rellenaComboEspecialidad(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(EspecialidadLaboratorio.class).iterator();
       while(ite.hasNext()){
           EspecialidadLaboratorio especialidad =(EspecialidadLaboratorio) ite.next();
               modelo.addElement(especialidad);
           }
       return modelo;
   }
     
     public DefaultComboBoxModel rellenaComboLaboratorio(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Laboratorio.class).iterator();
       while(ite.hasNext()){
           Laboratorio laboratorio =(Laboratorio) ite.next();
               modelo.addElement(laboratorio);
           }
       return modelo;
   }
     
      public DefaultComboBoxModel rellenaComboProductor(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Productor.class).iterator();
       while(ite.hasNext()){
           Productor p =(Productor) ite.next();
               modelo.addElement(p);
           }
       return modelo;
   }
     
       public int buscarObjeto(JTable tabla, MuestraTomada d){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       int bandera = 0;
       for(int i=0; i<modelo.getRowCount(); i++){
           if(d.getNumeroMuestra() == tabla.getValueAt(i, 1)){
               bandera=1;
           }
       }
       if(d.getEstado()!= 0){
           bandera = 1;
       }
       return bandera;
   }
       
       public void cargarTabla(JTable tabla, MuestraTomada muestra, Descarga carga){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       Object fila[]={carga.getFecha(), muestra.getNumeroMuestra(), carga.getProductor()};
       modelo.addRow(fila);
       tabla.setModel(modelo);
   
   } 
     
}
