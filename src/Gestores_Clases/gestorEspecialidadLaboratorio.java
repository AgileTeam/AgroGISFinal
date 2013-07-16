/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import Clases_Modulo_Carga.EspecialidadLaboratorio;
import Clases_Modulo_Transporte.Pais;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Hibernate.GestorHibernate;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
        

/**
 *
 * @author ale
 */
public class gestorEspecialidadLaboratorio extends GestorHibernate {
   
    public void guardarEspecialidadLaboratorio(JTable tabla){
     DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();      
        Iterator iterator = this.listarClase(EspecialidadLaboratorio.class).iterator();
        if(iterator.hasNext()==false){
            EspecialidadLaboratorio e = new EspecialidadLaboratorio();
            e.setCodigoEspecialidad((String)modeloTabla.getValueAt(0,0));
            e.setNombreEspecialidad((String) modeloTabla.getValueAt(0,1));
            this.guardarObjeto(e);
            }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int bandera=0;
                EspecialidadLaboratorio e = new EspecialidadLaboratorio();
                Iterator ite = this.listarClase(EspecialidadLaboratorio.class).iterator();
                while(ite.hasNext()){
                    EspecialidadLaboratorio esp = (EspecialidadLaboratorio) ite.next();
                    if(esp.getCodigoEspecialidad()==((String)modeloTabla.getValueAt(i,0))){
                         bandera=1;               
                    }
                }
                if(bandera==0){
                e.setCodigoEspecialidad((String) modeloTabla.getValueAt(i, 0));
                e.setNombreEspecialidad((String)modeloTabla.getValueAt(i,1));
                this.guardarObjeto(e);
                }
                }
     
     }
    
    public void actualizarEspecialidad(long idEsp, JTextField txtNombreEsp, JTextField txtCodEsp){
     Iterator ite = this.listarClase(EspecialidadLaboratorio.class).iterator();
     while(ite.hasNext()){
       EspecialidadLaboratorio esp = (EspecialidadLaboratorio) ite.next();
       if(esp.getIdEspecialidadLaboratorio() == idEsp){
           esp.setCodigoEspecialidad(txtCodEsp.getText());
           esp.setNombreEspecialidad(txtNombreEsp.getText());
           this.actualizarObjeto(esp);
       }
   }
     
     }
    
    public int campoObligatorio(JTextField texto1, JTextField texto2 ){
         int campo = 0;   
         if(texto1.getText().equalsIgnoreCase("")){
                texto1.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
         if(texto2.getText().equalsIgnoreCase("")){
                texto2.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
         if(campo ==1){
             JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios");
         }
         return campo;
     }
}
