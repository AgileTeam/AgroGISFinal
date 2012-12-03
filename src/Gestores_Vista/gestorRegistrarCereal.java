/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Carga.*;
import Clases_Modulo_Transporte.Localidad;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class gestorRegistrarCereal extends GestorHibernate {

    public DefaultComboBoxModel rellenaComboMes(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Mes.class).iterator();
       while(ite.hasNext()){
           Mes mes =(Mes) ite.next();
           modelo.addElement(mes);
       }
       return modelo;
   }    
    
    public DefaultComboBoxModel rellenaComboCaracteristica(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(CaracteristicasCereal.class).iterator();
       while(ite.hasNext()){
           CaracteristicasCereal caracteristica =(CaracteristicasCereal) ite.next();
           modelo.addElement(caracteristica);
       }
       return modelo;
   }    
    
    public void guardarCaracteristicas(JTable tabla, JTextField tipoCereal, JLabel cosecha, JLabel siembra, JComboBox mesDesdeCosecha, JComboBox mesHastaCosecha, JComboBox mesDesdeSiembra, JComboBox mesHastaSiembra){
     DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();  
     TipoCereal tipo = new TipoCereal();
     tipo.setNombreCereal(tipoCereal.getText());
     this.guardarObjeto(tipo);
        Iterator iterator = this.listarClase(CaracteristicasPorTipoDeCereal.class).iterator();
        if(iterator.hasNext()==false){
            CaracteristicasPorTipoDeCereal caracteristicas = new CaracteristicasPorTipoDeCereal();
            caracteristicas.setCaracteristicas((CaracteristicasCereal)modeloTabla.getValueAt(0,0));
            caracteristicas.setValorDesde((Double.parseDouble(modeloTabla.getValueAt(0,1).toString())));
            caracteristicas.setValorHasta((Double.parseDouble(modeloTabla.getValueAt(0,2).toString())));
            caracteristicas.setTipoCereal(tipo);
            this.guardarObjeto(caracteristicas);
            Iterator ite1 = this.listarClase(TipoTemporada.class).iterator();
            while(ite1.hasNext()){
                TipoTemporada tipoTemporada = new TipoTemporada();
                if(tipoTemporada.getNombreTipoTemporada()== cosecha.getText()){
                    Temporada temporada = new Temporada();
                    temporada.setMesDesde((Mes)mesDesdeCosecha.getSelectedItem());
                    temporada.setMesHasta((Mes)mesHastaCosecha.getSelectedItem());
                    this.guardarObjeto(temporada);
                    TipoTemporadaPorTipoCereal t = new TipoTemporadaPorTipoCereal();
                    t.setTemporada(temporada);
                    t.setTipoCereal(tipo);
                    t.setTipoTemporada(tipoTemporada);
                    this.guardarObjeto(t);
                }
                if(tipoTemporada.getNombreTipoTemporada()== siembra.getText()){
                    Temporada temporada = new Temporada();
                    temporada.setMesDesde((Mes)mesDesdeSiembra.getSelectedItem());
                    temporada.setMesHasta((Mes)mesHastaSiembra.getSelectedItem());
                    this.guardarObjeto(temporada);
                    TipoTemporadaPorTipoCereal t = new TipoTemporadaPorTipoCereal();
                    t.setTemporada(temporada);
                    t.setTipoCereal(tipo);
                    t.setTipoTemporada(tipoTemporada);
                    this.guardarObjeto(t);
                }
            }
            }
//        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
//                int bandera=0;
//                CaracteristicasPorTipoDeCereal caracteristicas = new CaracteristicasPorTipoDeCereal();
//                Iterator ite = this.listarClase(CaracteristicasPorTipoDeCereal.class).iterator();
//                while(ite.hasNext()){
//                    CaracteristicasPorTipoDeCereal c = (CaracteristicasPorTipoDeCereal) ite.next();
//                    if((c.getCaracteristicas()==(modeloTabla.getValueAt(i,0)))){
//                         bandera=1;               
//                    }
//                }
//                if(bandera==0){
//                caracteristicas.setCaracteristicas((CaracteristicasCereal)modeloTabla.getValueAt(0,0));
//                caracteristicas.setValorDesde((Double.parseDouble(modeloTabla.getValueAt(0,1).toString())));
//                caracteristicas.setValorHasta((Double.parseDouble(modeloTabla.getValueAt(0,2).toString())));
//                tipo.setNombreCereal(tipoCereal.getText());
//                this.guardarObjeto(tipo);
//                caracteristicas.setTipoCereal(tipo);
//                this.guardarObjeto(caracteristicas);
//                 Iterator ite1 = this.listarClase(TipoTemporada.class).iterator();
//            while(ite1.hasNext()){
//                TipoTemporada tipoTemporada = new TipoTemporada();
//                if(tipoTemporada.getNombreTipoTemporada()== cosecha.getText()){
//                    Temporada temporada = new Temporada();
//                    temporada.setMesDesde((Mes)mesDesdeCosecha.getSelectedItem());
//                    temporada.setMesHasta((Mes)mesHastaCosecha.getSelectedItem());
//                    this.guardarObjeto(temporada);
//                    TipoTemporadaPorTipoCereal t = new TipoTemporadaPorTipoCereal();
//                    t.setTemporada(temporada);
//                    t.setTipoCereal(tipo);
//                    t.setTipoTemporada(tipoTemporada);
//                    this.guardarObjeto(t);
//                }
//                if(tipoTemporada.getNombreTipoTemporada()== siembra.getText()){
//                    Temporada temporada = new Temporada();
//                    temporada.setMesDesde((Mes)mesDesdeSiembra.getSelectedItem());
//                    temporada.setMesHasta((Mes)mesHastaSiembra.getSelectedItem());
//                    this.guardarObjeto(temporada);
//                    TipoTemporadaPorTipoCereal t = new TipoTemporadaPorTipoCereal();
//                    t.setTemporada(temporada);
//                    t.setTipoCereal(tipo);
//                    t.setTipoTemporada(tipoTemporada);
//                    this.guardarObjeto(t);
//                }
//            }
//                
//                }
//                }
     
     }
}
