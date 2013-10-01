/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.*;
import Hibernate.GestorHibernate;
import java.awt.Color;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ale
 */
public class gestorRegistrarTaller extends GestorHibernate {
    
     public DefaultComboBoxModel rellenaCombo(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Provincia.class).iterator();
       while(ite.hasNext()){
           Provincia provincia =(Provincia) ite.next();
           modelo.addElement(provincia);
       }

       return modelo;
   }

    public DefaultComboBoxModel rellenaComboDepartamento(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Departamento.class).iterator();
       while(ite.hasNext()){
           Departamento departamento =(Departamento) ite.next();
           Provincia provincia = departamento.getProvincia();
           if (provincia.getNombreProvincia().equals(seleccion)){
               modelo.addElement(departamento);
           }
       }

       return modelo;
   }

    public DefaultComboBoxModel rellenaComboLocalidad(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Localidad.class).iterator();
       while(ite.hasNext()){
           Localidad localidad =(Localidad) ite.next();
           Departamento departamento = localidad.getDepartamento();
           if (departamento.getNombreDepartamento().equals(seleccion)){
               modelo.addElement(localidad);
           }
       }

       return modelo;
   }

    public DefaultComboBoxModel rellenaComboBarrio(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Barrio.class).iterator();
       while(ite.hasNext()){
           Barrio barrio =(Barrio) ite.next();
           Localidad localidad = barrio.getLocalidad();
           if (localidad.getNombreLocalidad().equals(seleccion)){
               modelo.addElement(barrio);
           }
       }

       return modelo;
   }
    
      public DefaultComboBoxModel rellenaComboCondicionIva(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(CondicionIva.class).iterator();
       while(ite.hasNext()){
           CondicionIva condicion =(CondicionIva) ite.next();
           modelo.addElement(condicion);
           }
       
      return modelo;
   }
      
       public DefaultComboBoxModel rellenaComboTipoTel(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoTelefono.class).iterator();
       while(ite.hasNext()){
           TipoTelefono tipoTel =(TipoTelefono) ite.next();
           modelo.addElement(tipoTel);
           }
       
      return modelo;
   }
       
     public DefaultComboBoxModel rellenaComboEspecialidad(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Especialidad.class).iterator();
       while(ite.hasNext()){
           Especialidad esp =(Especialidad) ite.next();
           modelo.addElement(esp);
           }
       
      return modelo;
   }  
       
   public int campoObligatorio(JTextField texto1, JTextField texto2, JTextField texto3, JTextField texto4, JTextField texto5){
         int campo = 0;   
         if(texto1.getText().equalsIgnoreCase("")){
                texto1.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
          if(texto2.getText().equalsIgnoreCase("")){
                texto2.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
           if(texto3.getText().equalsIgnoreCase("")){
                texto3.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
            if(texto4.getText().equalsIgnoreCase("")){
                texto4.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
            if(texto5.getText().equalsIgnoreCase("")){
                texto5.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
         if(campo == 1){
            JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios");
         }
         return campo;
     }    
    
    
}
