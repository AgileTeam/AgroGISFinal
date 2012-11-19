/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Hibernate.GestorHibernate;
import javax.swing.JMenu;

/**
 *
 * @author ale
 */
public class gestorFrmPrincipal extends GestorHibernate{
    
    public void HabilitarMenu(JMenu menuInicio){
        menuInicio.setEnabled(true);
    
    }
    
    
}
