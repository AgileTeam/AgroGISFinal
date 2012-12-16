/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Carga.*;
import Clases_Modulo_Cliente.Establecimiento;
import Clases_Modulo_Cliente.Productor;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class gestorRegistrarSolicitud extends GestorHibernate {
    
    public DefaultComboBoxModel rellenaComboCereal(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoCereal.class).iterator();
       while(ite.hasNext()){
           TipoCereal tipoCereal =(TipoCereal) ite.next();
           modelo.addElement(tipoCereal);
       }
       return modelo;
   }
    
      public DefaultComboBoxModel rellenaComboTipoSolicitudRetiro(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoSolicitud.class).iterator();
       while(ite.hasNext()){
           TipoSolicitud solicitud =(TipoSolicitud) ite.next();
           modelo.addElement(solicitud);
       }
       return modelo;
   }
      
       public DefaultComboBoxModel rellenaComboPuerto(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Puerto.class).iterator();
       while(ite.hasNext()){
           Puerto puerto =(Puerto) ite.next();
           modelo.addElement(puerto);
       }
       return modelo;
   }
    
    public DefaultComboBoxModel rellenaComboSilo(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Silo.class).iterator();
       while(ite.hasNext()){
           Silo silo =(Silo) ite.next();
           modelo.addElement(silo);
       }
       return modelo;
   }
    
    public JTable rellenaTablaProductor(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Productor.class).iterator();
       while(ite.hasNext()){
           Productor productor =(Productor) ite.next();
           Object fila[]= {productor.getNombre(), productor.getNumeroDocumento()};
           modeloT.addRow(fila);
       }
       tabla.setModel(modeloT);
       return tabla;
   }
    
     public DefaultComboBoxModel rellenaComboDestino(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Establecimiento.class).iterator();
       Iterator ite2 = this.listarClase(Puerto.class).iterator();
       if(seleccion.equalsIgnoreCase("Puerto")){
       while(ite2.hasNext()){
           Puerto puerto=(Puerto) ite2.next();
           modelo.addElement(puerto);
       }
       }else{
       while(ite.hasNext()){
           Establecimiento establecimiento=(Establecimiento) ite.next();
           modelo.addElement(establecimiento);
       }
       }
       return modelo;
   }
    
     
    public DefaultComboBoxModel rellenaComboTipoOperacion(){
    DefaultComboBoxModel modelo=new DefaultComboBoxModel();
    Iterator ite=this.listarClase(TipoOperacion.class).iterator();
    while(ite.hasNext()){
        TipoOperacion tipoOperacion=(TipoOperacion) ite.next();
        modelo.addElement(tipoOperacion);
       }
     return modelo;
    } 
     
     public void ActualizarDatos(TipoSolicitud seleccion, JPanel panelEstablecimiento, JPanel panelPlanta){
        if (seleccion.getNombreTipoSolicitud().equalsIgnoreCase("Retiro en Establecimiento")){
        panelEstablecimiento.setVisible(true);
        panelPlanta.setVisible(false);

        }if(seleccion.getNombreTipoSolicitud().equalsIgnoreCase("Retiro en Planta")){
        panelPlanta.setVisible(true);
        panelEstablecimiento.setVisible(false);
       }
      
       }
     
    public DefaultComboBoxModel rellenaComboEstablecimiento(String productor){
    DefaultComboBoxModel modelo=new DefaultComboBoxModel();
    Iterator ite=this.listarClase(Establecimiento.class).iterator();
    while(ite.hasNext()){
        Establecimiento establecimiento=(Establecimiento) ite.next();
        if(establecimiento.getProductor().getNombre().equals(productor))
            modelo.addElement(establecimiento);
       }
     return modelo;
    } 
    
    
    public void guardarSolicitud(TipoSolicitud tipoSolicitud, String fecha, Productor productor, TipoCereal tipoCereal, Establecimiento establecimiento,
                                double hectareas, TipoOperacion tipoOperacion, String destino, Silo silo, double toneladas, JTextField numeroSolicitud, JTextField toneladas2){
        
        SolicitudRetiro solicitud = new SolicitudRetiro();
            solicitud.setFechaSolicitud(fecha);
            solicitud.setProductor(productor);
            solicitud.setTipoSolicitud(tipoSolicitud);
            solicitud.setTipoCereal(tipoCereal);
            solicitud.setEstado("Pendiente");
            this.guardarObjeto(solicitud);
            
        if(tipoSolicitud.getIdTipoSolicitud()==1){
            EstablecimientoPorSolicitud estab = new EstablecimientoPorSolicitud();
            estab.setEstablecimiento(establecimiento);
            estab.setSolicitud(solicitud);
            estab.setHectareasATrillar(hectareas);
            this.guardarObjeto(estab);
        }
        if(tipoSolicitud.getIdTipoSolicitud()==2 && tipoOperacion.getNombreTipoOperacion().equalsIgnoreCase("Venta")){
            PuertoPorSolicitud puertosol = new PuertoPorSolicitud();
            Iterator iteP = this.listarClase(Puerto.class).iterator();
            while(iteP.hasNext()){
                Puerto p = (Puerto) iteP.next();
                if(p.getNombrePuerto().equalsIgnoreCase(destino)){
                    puertosol.setPuerto(p);
                    puertosol.setSilo(silo);
                    puertosol.setSolicitud(solicitud);
                    puertosol.setTipoOperacion(tipoOperacion);
                    Iterator ite2 = this.listarClase(ToneladasPorCereal.class).iterator();
                    while(ite2.hasNext()){
                    ToneladasPorCereal ton = (ToneladasPorCereal) ite2.next();
                    if(ton.getHistorial().getProductor().equals(productor) && ton.getTipoCereal().equals(tipoCereal)){
                           double suma_t=ton.getToneladas();
                           double resultado=suma_t - Double.parseDouble(toneladas2.getText());
                           if(resultado>=0){
                           ton.setToneladas(resultado);
                           System.out.println(resultado);
                           this.actualizarObjeto(ton);
                           puertosol.setToneladasAExtraer(toneladas);
                           this.guardarObjeto(puertosol);
                           } else{JOptionPane.showMessageDialog(null, "Las toneladas a extraer son mayores que las disponibles");
                           }
                        }
                    }
                
                }
            }
//            
            
            
        }
        if(tipoSolicitud.getNombreTipoSolicitud().equals("Retiro en Planta") && tipoOperacion.getNombreTipoOperacion().equals("Transferencia")){
            EstablecimientoPorSolicitud est = new EstablecimientoPorSolicitud();
            Iterator iteE = this.listarClase(Establecimiento.class).iterator();
            while(iteE.hasNext()){
                Establecimiento e = (Establecimiento) iteE.next();
                if(e.getNombreEstablecimiento().equalsIgnoreCase(destino)){
                    est.setEstablecimiento(e);
                    est.setSilo(silo);
                    est.setSolicitud(solicitud);
                    est.setTipoOperacion(tipoOperacion);
                    Iterator ite2 = this.listarClase(ToneladasPorCereal.class).iterator();
                    while(ite2.hasNext()){
                    ToneladasPorCereal ton = (ToneladasPorCereal) ite2.next();
                if(ton.getHistorial().getProductor().equals(productor) && ton.getTipoCereal().equals(tipoCereal)){
                           double suma_t=ton.getToneladas();
                           double resultado=suma_t - Double.parseDouble(toneladas2.getText());
                           if(resultado>=0){
                           ton.setToneladas(resultado);
                           System.out.println(resultado);
                           this.actualizarObjeto(ton);
                           est.setToneladasAExtraer(toneladas);
                           this.guardarObjeto(est);
                           } else{JOptionPane.showMessageDialog(null, "Las toneladas a extraer son mayores que las disponibles");
                           }
                        }
            }
                
                
                }
            }
//            est.setEstablecimiento((Establecimiento)destino);
            
        }
        JOptionPane.showMessageDialog(null,"Se genero correctamente la solicitud Nº:" + "" + solicitud.getNumeroSolicitud());
        numeroSolicitud.setText(String.valueOf(solicitud.getNumeroSolicitud()));
    }
    
       public DefaultComboBoxModel CargaSilos(String TipoCereal){
         DefaultComboBoxModel modelo = new DefaultComboBoxModel();
         Iterator ite = this.listarClase(Silo.class).iterator();
         while(ite.hasNext()){
             Silo silo = (Silo) ite.next();
             if(silo.getTipoCereal().getNombreCereal().equalsIgnoreCase(TipoCereal)){
                 modelo.addElement(silo);
             }
         }
         return modelo;     
     }
}
