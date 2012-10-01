/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestores_Vista;

import Clases_Modulo_Carga.*;
import Clases_Modulo_Cliente.Establecimiento;
import Clases_Modulo_Cliente.Lote;
import Clases_Modulo_Transporte.Transportista;
import Clases_Modulo_Transporte.Vehiculo;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandra
 */
public class gestorDescargaCereal extends GestorHibernate {

    public JTable rellenaTablaProductor(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Establecimiento.class).iterator();
       while(ite.hasNext()){
           Establecimiento establecimiento = (Establecimiento) ite.next();
           Object fila[]= {establecimiento.getNombreEstablecimiento(), establecimiento.getProductor()};
           modeloT.addRow(fila);
       }
       tabla.setModel(modeloT);
       return tabla;
   }
    
     public DefaultComboBoxModel rellenaComboTipoCereal(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoCereal.class).iterator();
       while(ite.hasNext()){
           TipoCereal tipo =(TipoCereal) ite.next();
               modelo.addElement(tipo);
           }
       return modelo;
   }
     
        
       public DefaultComboBoxModel rellenaComboSilo(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Silo.class).iterator();
       while(ite.hasNext()){
           Silo tipo =(Silo) ite.next();
               modelo.addElement(tipo.getNumeroSilo());
           }
       return modelo;
   }
       
       public DefaultComboBoxModel rellenaComboTransportista(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Transportista.class).iterator();
       while(ite.hasNext()){
           Transportista tipo =(Transportista) ite.next();
               modelo.addElement(tipo);
           }
       return modelo;
   }
       public DefaultComboBoxModel rellenaComboVehiculo(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo =(Vehiculo) ite.next();
           Transportista transportista = vehiculo.getTransportista();
           if (transportista.getNombre().equals(seleccion)){
               modelo.addElement(vehiculo);
           }
       }
       
       return modelo;
   }
       public DefaultComboBoxModel rellenaComboPatente(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo =(Vehiculo) ite.next();
           if (vehiculo.getModelo().equals(seleccion)){
               modelo.addElement(vehiculo.getDominio());
           }
       }
       
       return modelo;
   }
       
       
     public void guardarDescarga(JTable tablaCaracteristica, JTable tablaLote, JTextField establecimiento, JTextField fecha, JTextField viaje, JComboBox tipoCereal, JTextField toneladas, JComboBox transportista, JComboBox silo){
     DefaultTableModel modeloTabla = (DefaultTableModel) tablaCaracteristica.getModel();  
     DefaultTableModel modeloLote = (DefaultTableModel) tablaLote.getModel();
        Iterator iterator = this.listarClase(Descarga.class).iterator();
        if(iterator.hasNext()==false){
            Descarga descarga = new Descarga();
            descarga.setCereal((TipoCereal)tipoCereal.getSelectedItem());
            descarga.setFecha(fecha.getText());
            descarga.setNumeroViaje(Integer.parseInt(viaje.getText()));
            descarga.setToneladas(Double.parseDouble(toneladas.getText()));
            descarga.setTransportista((Transportista)transportista.getSelectedItem());
            descarga.setSilo((Silo)silo.getSelectedItem());
            this.guardarObjeto(descarga);
            MuestraTomada muestra = new MuestraTomada();
            muestra.setDescarga(descarga);
            muestra.setEstado(0);
            this.guardarObjeto(muestra);
            for (int i=0; i<modeloLote.getRowCount();i++){
                LotePorDescarga lotes = new LotePorDescarga();
                lotes.setDescarga(descarga);
                lotes.setLote((Lote)modeloLote.getValueAt(i, 0));
                this.guardarObjeto(lotes);
            }
            for (int i=0; i< modeloTabla.getRowCount(); i++){
                CaracteristicasPorTipoDeCerealPorMuestra c = new CaracteristicasPorTipoDeCerealPorMuestra();
                c.setMuestra(muestra);
                c.setTipoCereal((TipoCereal)tipoCereal.getSelectedItem());
                c.setCaracteristicas((CaracteristicasCereal)modeloTabla.getValueAt(i, 0));
                c.setValor(Double.parseDouble(modeloTabla.getValueAt(i, 1).toString()));
                this.guardarObjeto(c);
            }
            
        }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int bandera=0;
                CaracteristicasPorTipoDeCerealPorMuestra caracteristicas = new CaracteristicasPorTipoDeCerealPorMuestra();
                Iterator ite = this.listarClase(CaracteristicasPorTipoDeCerealPorMuestra.class).iterator();
                while(ite.hasNext()){
                    CaracteristicasPorTipoDeCerealPorMuestra c = (CaracteristicasPorTipoDeCerealPorMuestra) ite.next();
                    if((c.getCaracteristicas()==(modeloTabla.getValueAt(i,0)))){
                         bandera=1;               
                    }
                }
                if(bandera==0){
                    Descarga descarga = new Descarga();
                    descarga.setCereal((TipoCereal)tipoCereal.getSelectedItem());
                    descarga.setFecha(fecha.getText());
                    descarga.setNumeroViaje(Integer.parseInt(viaje.getText()));
                    descarga.setToneladas(Double.parseDouble(toneladas.getText()));
                    descarga.setTransportista((Transportista)transportista.getSelectedItem());
                    descarga.setSilo((Silo)silo.getSelectedItem());
                    this.guardarObjeto(descarga);
                    MuestraTomada muestra = new MuestraTomada();
                    muestra.setDescarga(descarga);
                    muestra.setEstado(0);
                    this.guardarObjeto(muestra);
                    for (int j=0; j<modeloLote.getRowCount();j++){
                        LotePorDescarga lotes = new LotePorDescarga();
                        lotes.setDescarga(descarga);
                        lotes.setLote((Lote)modeloLote.getValueAt(j, 0));
                        this.guardarObjeto(lotes);
                    }
                    for (int j=0; j< modeloTabla.getRowCount(); j++){
                        CaracteristicasPorTipoDeCerealPorMuestra c = new CaracteristicasPorTipoDeCerealPorMuestra();
                        c.setMuestra(muestra);
                        c.setTipoCereal((TipoCereal)tipoCereal.getSelectedItem());
                        c.setCaracteristicas((CaracteristicasCereal)modeloTabla.getValueAt(j, 0));
                        c.setValor(Double.parseDouble(modeloTabla.getValueAt(j, 1).toString()));
                        this.guardarObjeto(c);
                    }
                 }
                }
     
     }
     
     public long obtenerNumeroMuestra(){
         Iterator ite = listarClase(MuestraTomada.class).iterator();
         long numero=0;
         while(ite.hasNext()){
            MuestraTomada muestra = (MuestraTomada) ite.next();
            numero= muestra.getNumeroMuestra();
         }
         return numero;
     }
}
