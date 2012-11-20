/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Seguridad.Rol;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

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
    
}
