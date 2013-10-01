/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.*;
import Hibernate.GestorHibernate;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author ale
 */
public class gestorRegistrarEnvioAlTaller extends GestorHibernate {
    
    
    public DefaultComboBoxModel rellenaComboOrdenServicio(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(OrdenServicio.class).iterator();
       while(ite.hasNext()){
           OrdenServicio orden =(OrdenServicio) ite.next();
               if((orden.getTipoServicio().getIdTipoServicio() == 1 )&& (orden.getEstado().equalsIgnoreCase("Pendiente"))){
               modelo.addElement(orden);
               }
           }

       return modelo;
   }
    
    public DefaultComboBoxModel rellenaComboTallerReparacion(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TallerReparacion.class).iterator();
       while(ite.hasNext()){
           TallerReparacion taller =(TallerReparacion) ite.next();
               modelo.addElement(taller);
               
           }

       return modelo;
   }
    
    public String rellenaTxtFecha(String seleccion){
       String fecha = null;
       Iterator ite = this.listarClase(OrdenServicio.class).iterator();
       while(ite.hasNext()){
           OrdenServicio orden =(OrdenServicio) ite.next();
           if (orden.getNumeroOrden() == Integer.parseInt(seleccion)) {
               fecha = orden.getFecha();
           }
       }
       
       return fecha;
   }
    public String rellenaTxtTaller(OrdenServicio seleccion){
       String taller = null;
       Iterator ite = this.listarClase(EnvioTaller.class).iterator();
       while(ite.hasNext()){
           EnvioTaller envio=(EnvioTaller) ite.next();
          if(envio.getOrdenServicio().equals(seleccion)){
                    taller=envio.getTaller().toString();
                }
            }
           
           
       return taller;
       }
    
       public String rellenaTxtEspecialidad(OrdenServicio seleccion){
       String especialidad = null;
       Iterator ite = this.listarClase(EnvioTaller.class).iterator();
       while(ite.hasNext()){
           EnvioTaller envio=(EnvioTaller) ite.next();
                if(envio.getOrdenServicio().equals(seleccion)){
                    especialidad=envio.getTaller().getEspecialidad().toString();
                }
            }
           
           
       return especialidad;
       }
       
       public DefaultComboBoxModel rellenaComboReparaciones(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(ArregloEfectuado.class).iterator();
       while(ite.hasNext()){
           ArregloEfectuado arreglo =(ArregloEfectuado) ite.next();
               modelo.addElement(arreglo);
               
           }

       return modelo;
   }
       
    public int campoObligatorio(JTextField texto1, JTextField texto2, JTextField texto3){
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
           
         if(campo == 1){
            JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios");
         }
         return campo;
     }    
      
}
