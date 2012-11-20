/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Seguridad.Usuario;
import Clases_Modulo_Seguridad.UsuarioPorRol;
import Hibernate.GestorHibernate;
import Ventanas_Transporte.frmPrincipal;
import java.util.Iterator;
import javax.swing.JMenu;

/**
 *
 * @author ale
 */
public class gestorFrmPrincipal extends GestorHibernate{
    
    public void HabilitarMenu(JMenu menuInicio, JMenu menuCarga, JMenu menuTransporte, JMenu menuViaje, JMenu menuCliente, JMenu menuListados){
        Iterator ite = this.listarClase(Usuario.class).iterator();
        while(ite.hasNext()){
            Usuario u = (Usuario) ite.next();
            if(u.isEstado()==true){
                 Iterator ite2 = this.listarClase(UsuarioPorRol.class).iterator();
                 while(ite2.hasNext()){
                     UsuarioPorRol usu = (UsuarioPorRol) ite2.next();
                     if(usu.getUsuario().equals(u)){
                         if(usu.getRol().getIdRol()==1){
                             menuCarga.setEnabled(true);
                             menuCliente.setEnabled(true);
                         }
                         if(usu.getRol().getIdRol()==2){
                             menuViaje.setEnabled(true);
                         }
                         if(usu.getRol().getIdRol()==3){
                             menuTransporte.setEnabled(true);
                         }
                         if(usu.getRol().getIdRol()==4){
                             menuCarga.setEnabled(true);
                             menuCliente.setEnabled(true);
                             menuInicio.setEnabled(true);
                             menuListados.setEnabled(true);
                             menuTransporte.setEnabled(true);
                             menuViaje.setEnabled(true);
                         }
                     
                     }
                 }
                 menuInicio.setEnabled(true);
            }
        }
       
        
        }  
    
}
