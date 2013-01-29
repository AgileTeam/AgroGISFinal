/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Seguridad.Rol;
import Hibernate.GestorHibernate;
import java.awt.Color;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author ale
 */
public class gestorRegistrarUsuario extends GestorHibernate{
    
    public DefaultComboBoxModel cargarRoles(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator ite = this.listarClase(Rol.class).iterator();
        while(ite.hasNext()){
            Rol rol = (Rol)ite.next();
            modelo.addElement(rol);        
        }
        return modelo;
    
    }
    
    public int CampoObligatorio(JTextField texto){
        int bandera =0;
        if(texto.getText().equalsIgnoreCase("")){
            texto.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bandera=1;
        }
        return bandera;
    }
    
}
