/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author ale
 */
public class gestorRegistrarViaje extends GestorHibernate {
    
     public void ActualizarDatos(String seleccion, JScrollPane scpPuerto, JScrollPane scpEstablecimiento, JButton btnAgregarProd,JButton btnAgregarPuerto, JComboBox cmbEstablecimientoT, JLabel labelEstablecimiento,
                                 JLabel labelPuerto, JTextField txtPuerto, JLabel labelDepto, JLabel labelProvincia, JTextField txtProvinciaT, JTextField txtDeptoT, JLabel labelToneladasD, JLabel labelToneladasE,
                                 JTextField txtToneladasD, JTextField txtToneladasE, JPanel panelPuerto, JPanel panelEstablecimiento){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       if (seleccion == "Traslado"){
        scpPuerto.setVisible(true); //1
        scpEstablecimiento.setVisible(false); //2
        btnAgregarProd.setVisible(false); //2
        btnAgregarPuerto.setVisible(true); //1
        labelEstablecimiento.setVisible(false); //2
        labelPuerto.setVisible(true); //1
        txtPuerto.setVisible(true); //1
        cmbEstablecimientoT.setVisible(false); //2
        labelDepto.setVisible(false); //2
        labelProvincia.setVisible(true); //1
        txtProvinciaT.setVisible(true); //1 
        txtDeptoT.setVisible(false); //2
        labelToneladasD.setVisible(false); //2
        labelToneladasE.setVisible(true); //1
        txtToneladasD.setVisible(false); //2
        txtToneladasE.setVisible(true); //1
        panelPuerto.setVisible(true);
        panelEstablecimiento.setVisible(false);
        }else{
        scpPuerto.setVisible(false); //1
        scpEstablecimiento.setVisible(true); //2
        btnAgregarProd.setVisible(true); //2
        btnAgregarPuerto.setVisible(false); //1
        labelEstablecimiento.setVisible(true); //2
        labelPuerto.setVisible(false); //1
        txtPuerto.setVisible(false); //1
        cmbEstablecimientoT.setVisible(true); //2
        labelDepto.setVisible(true); //2
        labelProvincia.setVisible(false); //1
        txtProvinciaT.setVisible(false); //1 
        txtDeptoT.setVisible(true); //2
        labelToneladasD.setVisible(true); //2
        labelToneladasE.setVisible(false); //1
        txtToneladasD.setVisible(true); //2
        txtToneladasE.setVisible(false); //1
        panelPuerto.setVisible(false);
        panelEstablecimiento.setVisible(true);
       }
       }
       
        }
    
