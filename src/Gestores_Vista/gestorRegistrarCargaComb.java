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
public class gestorRegistrarCargaComb extends GestorHibernate{
    
     public DefaultComboBoxModel rellenaComboOrdenServicio(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(OrdenServicio.class).iterator();
       while(ite.hasNext()){
           OrdenServicio orden =(OrdenServicio) ite.next();
               if((orden.getTipoServicio().getIdTipoServicio() == 2 )&& (orden.getEstado().equalsIgnoreCase("Pendiente"))){
               modelo.addElement(orden);
               }
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
    public String rellenaTxtEstacion(OrdenServicio seleccion){
       String estacion = null;
       Iterator ite = this.listarClase(CargaCombustible.class).iterator();
       while(ite.hasNext()){
           CargaCombustible carga=(CargaCombustible) ite.next();
           Iterator ite1 = this.listarClase(DetalleConsumo.class).iterator();
            while(ite1.hasNext()){
                DetalleConsumo detalle = (DetalleConsumo) ite1.next();
                if((detalle.getCargaCombustible() == carga)&&(detalle.getOrdenServicio()== (OrdenServicio)seleccion)){
                    estacion= carga.getEstacionServicio().toString();
                }
            }
           
           }
       return estacion;
       }
    
       public String rellenaTxtOperacion(OrdenServicio seleccion){
       String operacion = null;
       Iterator ite = this.listarClase(CargaCombustible.class).iterator();
       while(ite.hasNext()){
           CargaCombustible carga=(CargaCombustible) ite.next();
           Iterator ite1 = this.listarClase(DetalleConsumo.class).iterator();
            while(ite1.hasNext()){
                DetalleConsumo detalle = (DetalleConsumo) ite1.next();
                if((detalle.getCargaCombustible()== carga)&&(detalle.getOrdenServicio()== (OrdenServicio)seleccion)){
                    operacion = carga.getTipo().toString();
                }
            }
           
           }
       return operacion;
       }
       
       public DefaultComboBoxModel rellenaComboProducto(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoCombustible.class).iterator();
       while(ite.hasNext()){
          TipoCombustible t = (TipoCombustible) ite.next();
          modelo.addElement(t);
        }

       return modelo;
   }
       
       
       
       
//    
}
