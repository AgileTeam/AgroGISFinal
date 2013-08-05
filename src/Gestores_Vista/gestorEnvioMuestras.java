/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Carga.EspecialidadLaboratorio;
import Clases_Modulo_Carga.Laboratorio;
import Clases_Modulo_Transporte.Especialidad;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

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
     
}
