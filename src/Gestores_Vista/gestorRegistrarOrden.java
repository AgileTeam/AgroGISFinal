/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestores_Vista;

import Clases_Modulo_Transporte.*;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandra
 */
public class gestorRegistrarOrden extends GestorHibernate{

      public JTable rellenaTablaVehiculo(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo =(Vehiculo) ite.next();
           Transportista transportista = vehiculo.getTransportista();
           Object fila[]= {vehiculo.getDominio(), vehiculo.getTransportista()};
           modeloT.addRow(fila);
       }
       tabla.setModel(modeloT);
       return tabla;
   }

      public String rellenaTxtProveedor(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           ProveedorCombustible proveedor = estacion.getProveedor();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto = proveedor.getNombreProveedor();
           }
       }
       return texto;
   }

      public String rellenaTxtDomicilio(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           Domicilio domicilio = estacion.getDomicilio();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto= domicilio.getBarrio().toString();
           }
       }
       return texto;
   }
      public String rellenaTxtLocalidad(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           Domicilio domicilio = estacion.getDomicilio();
           Barrio barrio = domicilio.getBarrio();
           Localidad localidad = barrio.getLocalidad();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto = localidad.getNombreLocalidad();
           }
       }
       return texto;
   }

     public String rellenaTxtDepartamento(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           Domicilio domicilio = estacion.getDomicilio();
           Barrio barrio = domicilio.getBarrio();
           Localidad localidad = barrio.getLocalidad();
           Departamento departamento = localidad.getDepartamento();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto= departamento.getNombreDepartamento();
           }
       }
       return texto;
   }
     public String rellenaTxtProvincia(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           Domicilio domicilio = estacion.getDomicilio();
           Barrio barrio = domicilio.getBarrio();
           Localidad localidad = barrio.getLocalidad();
           Departamento departamento = localidad.getDepartamento();
           Provincia provincia = departamento.getProvincia();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto= provincia.getNombreProvincia();
           }
       }
       return texto;
   }
     
 public DefaultComboBoxModel rellenaComboTipoServicio(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    Iterator ite = this.listarClase(TipoServicio.class).iterator();
       while(ite.hasNext()){
           TipoServicio tipo =(TipoServicio) ite.next();  
           modelo.addElement(tipo);
           }
        return modelo;
   }
 
 public DefaultComboBoxModel rellenaComboVehiculo(Transportista transportista){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo =(Vehiculo) ite.next();  
           if(vehiculo.getTransportista()== transportista)
           modelo.addElement(vehiculo);
           }
        return modelo;
   }

    public String rellenaTxtDominio(Vehiculo seleccion){
       String dominio = null;
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo =(Vehiculo) ite.next();
           if (vehiculo == (Vehiculo)seleccion) {
               dominio = vehiculo.getDominio();
           }
       }
       
       return dominio;
   }

    public String rellenaTxtAnio(Vehiculo seleccion){
       String anio = null;
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo =(Vehiculo) ite.next();
           if (vehiculo == (Vehiculo)seleccion) {
               anio = vehiculo.getAnioCompra().toString();
           }
       }
       
       return anio;
   }
    
   public String rellenaTxtEstado(Vehiculo seleccion){
       String estado = null;
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo =(Vehiculo) ite.next();
           if (vehiculo == (Vehiculo)seleccion) {
               estado = vehiculo.getEstado().toString();
           }
       }
       
       return estado;
   } 
   
   public DefaultComboBoxModel rellenaComboTaller(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    Iterator ite = this.listarClase(TallerReparacion.class).iterator();
       while(ite.hasNext()){
           TallerReparacion taller =(TallerReparacion) ite.next();  
           modelo.addElement(taller);
           }
        return modelo;
   }
   
    public DefaultComboBoxModel rellenaComboMotivo(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    Iterator ite = this.listarClase(Motivo.class).iterator();
       while(ite.hasNext()){
           Motivo motivo =(Motivo) ite.next();  
           modelo.addElement(motivo);
           }
        return modelo;
   }
   
   public String rellenaTxtEspecialidad(TallerReparacion seleccion){
       String especialidad = null;
       Iterator ite = this.listarClase(TallerReparacion.class).iterator();
       while(ite.hasNext()){
           TallerReparacion taller =(TallerReparacion) ite.next();
           if (taller == (TallerReparacion)seleccion) {
               especialidad = taller.getEspecialidad().toString();
           }
       }
       
       return especialidad;
   } 
   
    public String rellenaTxtDomicilio(TallerReparacion seleccion){
       String domicilio = null;
       Iterator ite = this.listarClase(TallerReparacion.class).iterator();
       while(ite.hasNext()){
           TallerReparacion taller =(TallerReparacion) ite.next();
           if (taller == (TallerReparacion)seleccion) {
               domicilio = taller.getDomicilio().toString();
           }
       }
       
       return domicilio;
   } 
    
    public String rellenaTxtLocalidad(TallerReparacion seleccion){
       String localidad = null;
       Iterator ite = this.listarClase(TallerReparacion.class).iterator();
       while(ite.hasNext()){
           TallerReparacion taller =(TallerReparacion) ite.next();
           if (taller == (TallerReparacion)seleccion) {
               localidad = taller.getDomicilio().getBarrio().getLocalidad().toString();
           }
       }
       
       return localidad;
   } 
    
    public String rellenaTxtDepartamento(TallerReparacion seleccion){
       String depto = null;
       Iterator ite = this.listarClase(TallerReparacion.class).iterator();
       while(ite.hasNext()){
           TallerReparacion taller =(TallerReparacion) ite.next();
           if (taller == (TallerReparacion)seleccion) {
               depto = taller.getDomicilio().getBarrio().getLocalidad().getDepartamento().toString();
           }
       }
       
       return depto;
   } 
    public String rellenaTxtProvincia(TallerReparacion seleccion){
       String prov = null;
       Iterator ite = this.listarClase(TallerReparacion.class).iterator();
       while(ite.hasNext()){
           TallerReparacion taller =(TallerReparacion) ite.next();
           if (taller == (TallerReparacion)seleccion) {
               prov = taller.getDomicilio().getBarrio().getLocalidad().getDepartamento().getProvincia().toString();
           }
       }
       
       return prov;
   } 
    
 public DefaultComboBoxModel rellenaComboEstacion(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();  
           modelo.addElement(estacion);
           }
        return modelo;
   }
 
     public String rellenaTxtDomicilioEstacion(EstacionDeServicio seleccion){
       String domicilio = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           if (estacion == seleccion) {
               domicilio = estacion.getDomicilio().toString();
           }
       }
       
       return domicilio;
   } 
    
    public String rellenaTxtLocalidadEstacion(EstacionDeServicio seleccion){
       String localidad = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           if (estacion == seleccion) {
               localidad = estacion.getDomicilio().getBarrio().getLocalidad().toString();
           }
       }
       
       return localidad;
   } 
    
    public String rellenaTxtDepartamentoEstacion(EstacionDeServicio seleccion){
       String depto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           if (estacion == seleccion) {
               depto = estacion.getDomicilio().getBarrio().getLocalidad().getDepartamento().toString();
           }
       }
       
       return depto;
   } 
    public String rellenaTxtProvinciaEstacion(EstacionDeServicio seleccion){
       String prov = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           if (estacion == seleccion) {
               prov = estacion.getDomicilio().getBarrio().getLocalidad().getDepartamento().getProvincia().toString();
           }
       }
       
       return prov;
   } 
    
     public String rellenaTxtProveedorCombustible(EstacionDeServicio seleccion){
       String prov = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           if (estacion == seleccion) {
               prov = estacion.getProveedor().toString();
           }
       }
       
       return prov;
   } 
 
     
   public DefaultComboBoxModel rellenaComboTipoOperacion(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    Iterator ite = this.listarClase(TipoOperacionEstacionServicio.class).iterator();
       while(ite.hasNext()){
           TipoOperacionEstacionServicio tipo =(TipoOperacionEstacionServicio) ite.next();  
           modelo.addElement(tipo);
           }
        return modelo;
   }
}
