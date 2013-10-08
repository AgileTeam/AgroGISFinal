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
import Clases_Modulo_Viaje.*;
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
       Iterator ite = this.listarClase(Viaje.class).iterator();
       while(ite.hasNext()){
           Viaje viaje = (Viaje) ite.next();
           if(viaje.getEstado().equalsIgnoreCase("En Proceso") && viaje.getTipoViaje().getNombreTipoViaje().equalsIgnoreCase("Retiro de Establecimiento")){
               Iterator ite1 = this.listarClase(EstablecimientoPorSolicitud.class).iterator();
               while(ite1.hasNext()){
                   EstablecimientoPorSolicitud est = (EstablecimientoPorSolicitud) ite1.next();
                   if(est.getSolicitud()==viaje.getSolicitud()){
                       Object fila[]= {est.getEstablecimiento(), est.getEstablecimiento().getProductor(), viaje.getIdViaje()};
                       modeloT.addRow(fila);
                   }
               }
           }
           
       }
       tabla.setModel(modeloT);
       return tabla;
   }
    
        
       public DefaultComboBoxModel rellenaComboSilo(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Silo.class).iterator();
       while(ite.hasNext()){
           Silo tipo =(Silo) ite.next();
               modelo.addElement(tipo);
           }
       return modelo;
   }
       
       
     public void guardarDescarga(JTable tablaCaracteristica, JTextField establecimiento, JTextField fecha, JTextField hora, JTextField viaje, TipoCereal tipoCereal, JTextField toneladas, Transportista transportista, Silo silo){
     DefaultTableModel modeloTabla = (DefaultTableModel) tablaCaracteristica.getModel(); 
     
     
//     Descarga descarga = new Descarga();
//     descarga.setCereal(tipoCereal);
//     descarga.setTransportista(transportista);
//     this.guardarObjeto(descarga);
//     MuestraTomada muestra = new MuestraTomada();
//     muestra.setDescarga(descarga);
//     this.guardarObjeto(muestra);
   
        Iterator iterator = this.listarClase(Descarga.class).iterator();
        if(iterator.hasNext()==false){
            Descarga descarga = new Descarga();
            descarga.setCereal((TipoCereal)tipoCereal);
            descarga.setFecha(fecha.getText());
            descarga.setHora(hora.getText());
            descarga.setNumeroViaje(Integer.parseInt(viaje.getText()));
            
            descarga.setToneladas(Double.parseDouble(toneladas.getText()));
            descarga.setTransportista((Transportista)transportista);
            descarga.setSilo(silo);
            this.guardarObjeto(descarga);
            Iterator ite2= this.listarClase(HistorialProductor.class).iterator();
            while(ite2.hasNext()){
                HistorialProductor h = (HistorialProductor) ite2.next();
                Iterator ite3= this.listarClase(Establecimiento.class).iterator();
                while(ite3.hasNext()){
                Establecimiento est = (Establecimiento) ite3.next();
                if(est.getNombreEstablecimiento().equalsIgnoreCase(establecimiento.getText()) && (est.getProductor().equals(h.getProductor()))){
                    descarga.setEstablecimiento(est);
                    descarga.setProductor(est.getProductor());
                    this.actualizarObjeto(descarga);
                    DescargaPorHistorial desc = new DescargaPorHistorial();
                    desc.setHistorial(h);
                    desc.setDescarga(descarga);
                    this.guardarObjeto(desc);
                    Iterator ite4 = this.listarClase(ToneladasPorCereal.class).iterator();
                    while(ite4.hasNext()) {
                        ToneladasPorCereal t = (ToneladasPorCereal) ite4.next();
                        if(t.getHistorial().equals(h) && t.getTipoCereal().equals(tipoCereal)){
                           double suma_t=t.getToneladas();
                           double resultado=Double.parseDouble(toneladas.getText())+suma_t;
                            t.setToneladas(resultado);
                            System.out.println(resultado);
                            this.actualizarObjeto(t);
                        
                        }
                    
                    }
                }
                
                }
                
            
            }
            MuestraTomada muestra = new MuestraTomada();
            muestra.setDescarga(descarga);
            muestra.setEstado(0);
           
            this.guardarObjeto(muestra);
            for (int i=0; i< modeloTabla.getRowCount(); i++){
                CaracteristicasPorTipoDeCerealPorMuestra c = new CaracteristicasPorTipoDeCerealPorMuestra();
                c.setMuestra(muestra);
                c.setTipoCereal((TipoCereal)tipoCereal);
                Iterator iteCa = this.listarClase(CaracteristicasCereal.class).iterator();
                        while(iteCa.hasNext()){
                            CaracteristicasCereal ca = (CaracteristicasCereal) iteCa.next();
                            if(ca.getNombreCaracteristica().equalsIgnoreCase(modeloTabla.getValueAt(i,0).toString())){
                                c.setCaracteristicas(ca);
                            }
                        }
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
                    descarga.setCereal((TipoCereal)tipoCereal);
                    descarga.setFecha(fecha.getText());
                    descarga.setNumeroViaje(Integer.parseInt(viaje.getText()));
                    descarga.setToneladas(Double.parseDouble(toneladas.getText()));
                    descarga.setTransportista((Transportista)transportista);
                    descarga.setSilo(silo);
                    this.guardarObjeto(descarga);
                    MuestraTomada muestra = new MuestraTomada();
                    muestra.setDescarga(descarga);
                    muestra.setEstado(0);
                    this.guardarObjeto(muestra);
                    for (int j=0; j< modeloTabla.getRowCount(); j++){
                        CaracteristicasPorTipoDeCerealPorMuestra c = new CaracteristicasPorTipoDeCerealPorMuestra();
                        c.setMuestra(muestra);
                        c.setTipoCereal((TipoCereal)tipoCereal);
                        Iterator iteC = this.listarClase(CaracteristicasCereal.class).iterator();
                        while(iteC.hasNext()){
                            CaracteristicasCereal ca = (CaracteristicasCereal) iteC.next();
                            if(ca.getNombreCaracteristica().equalsIgnoreCase(modeloTabla.getValueAt(j,0).toString())){
                                c.setCaracteristicas(ca);
                            }
                        }
                        
                        c.setValor(Double.parseDouble(modeloTabla.getValueAt(j, 1).toString()));
                        this.guardarObjeto(c);
                    }
                     Iterator ite2= this.listarClase(HistorialProductor.class).iterator();
                while(ite2.hasNext()){
                HistorialProductor h = (HistorialProductor) ite2.next();
                Iterator ite3= this.listarClase(Establecimiento.class).iterator();
                while(ite3.hasNext()){
                Establecimiento est = (Establecimiento) ite3.next();
                if(est.getNombreEstablecimiento().equalsIgnoreCase(establecimiento.getText()) && (est.getProductor().equals(h.getProductor()))){
                    descarga.setEstablecimiento(est);
                    descarga.setProductor(est.getProductor());
                    this.actualizarObjeto(descarga);
                    DescargaPorHistorial desc = new DescargaPorHistorial();
                    desc.setHistorial(h);
                    desc.setDescarga(descarga);
                    this.guardarObjeto(desc);
                    Iterator ite4 = this.listarClase(ToneladasPorCereal.class).iterator();
                    while(ite4.hasNext()) {
                        ToneladasPorCereal t = (ToneladasPorCereal) ite4.next();
                        if(t.getHistorial().equals(h) && t.getTipoCereal().equals(tipoCereal)){
                            double suma_t=t.getToneladas();
                           double resultado=Double.parseDouble(toneladas.getText())+suma_t;
                            t.setToneladas(resultado);
                            System.out.println(resultado);
                            this.actualizarObjeto(t);
                        
                        }
                    
                    }
                }
                
                }
                
            
            }
                 }
                }
     
     }
     
        public DefaultComboBoxModel rellenaComboCaracteristica(){
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            Iterator ite = this.listarClase(CaracteristicasCereal.class).iterator();
            while(ite.hasNext()){
                CaracteristicasCereal cc =(CaracteristicasCereal) ite.next();
                modelo.addElement(cc.getNombreCaracteristica());
           }
                return modelo;
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
