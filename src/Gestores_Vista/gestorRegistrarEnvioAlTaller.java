/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.*;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

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
               if(orden.getTipoServicio().getIdTipoServicio() == 1){
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
           Iterator ite1 = this.listarClase(DetalleReparacion.class).iterator();
            while(ite1.hasNext()){
                DetalleReparacion detalle = (DetalleReparacion) ite.next();
                if((detalle.getEnvioTaller()== envio)&&(detalle.getOrden()== (OrdenServicio)seleccion)){
                    taller=envio.getTaller().toString();
                }
            }
           
           }
       return taller;
       }
    
       public String rellenaTxtEspecialidad(OrdenServicio seleccion){
       String especialidad = null;
       Iterator ite = this.listarClase(EnvioTaller.class).iterator();
       while(ite.hasNext()){
           EnvioTaller envio=(EnvioTaller) ite.next();
           Iterator ite1 = this.listarClase(DetalleReparacion.class).iterator();
            while(ite1.hasNext()){
                DetalleReparacion detalle = (DetalleReparacion) ite.next();
                if((detalle.getEnvioTaller()== envio)&&(detalle.getOrden()== (OrdenServicio)seleccion)){
                    especialidad=envio.getTaller().getEspecialidad().toString();
                }
            }
           
           }
       return especialidad;
       }
      
}
