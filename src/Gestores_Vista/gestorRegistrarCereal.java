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
     for(int i=0; i<tabla.getRowCount(); i++){
     CaracteristicasPorTipoDeCereal caracteristicas = new CaracteristicasPorTipoDeCereal();
     caracteristicas.setCaracteristicas((CaracteristicasCereal)modeloTabla.getValueAt(i,0));
     caracteristicas.setTipoCereal(tipo);
     this.guardarObjeto(caracteristicas);
     }
     Iterator ite1 = this.listarClase(TipoTemporada.class).iterator();
     while(ite1.hasNext()){
                TipoTemporada tipoTemporada = (TipoTemporada)ite1.next();
                if(tipoTemporada.getNombreTipoTemporada().equalsIgnoreCase(cosecha.getText())){
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
                if(tipoTemporada.getNombreTipoTemporada().equalsIgnoreCase(siembra.getText())){
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
     
}
