/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Hibernate.GestorHibernate;
import Clases_Modulo_Carga.SolicitudRetiro;
import Clases_Modulo_Carga.TipoCereal;
import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Transporte.Transportista;
import Clases_Modulo_Transporte.Vehiculo;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class gestorRegistrarSilo extends GestorHibernate {
   
     public DefaultComboBoxModel rellenaComboTipoCereal(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoCereal.class).iterator();
       while(ite.hasNext()){
           TipoCereal tc =(TipoCereal) ite.next();
               modelo.addElement(tc);
               
           }
    
       return modelo;
     }
}
     
