/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Cliente.Productor;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ale
 */
public class gestorEmitirOrden extends GestorHibernate{
    
    public DefaultComboBoxModel rellenaComboProductor(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Productor.class).iterator();
       while(ite.hasNext()){
           Productor prod =(Productor) ite.next();
               modelo.addElement(prod);
           }
       return modelo;
   }
}
