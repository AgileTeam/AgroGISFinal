/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Transporte.Barrio;
import Clases_Modulo_Transporte.CondicionIva;
import Clases_Modulo_Transporte.Domicilio;
import Clases_Modulo_Transporte.TipoTelefono;
import Hibernate.GestorHibernate;
import java.awt.Color;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alejandra
 */
public class gestorRegistrarProductor extends GestorHibernate {
    
    public Domicilio guardarDomicilio(String barrio, String calle, String departamento, String numero, String piso){
        Domicilio domicilio = new Domicilio();
        Iterator ite = this.listarClase(Barrio.class).iterator();
        while(ite.hasNext()){
            Barrio b = (Barrio) ite.next();
            if(b.getNombreBarrio().equalsIgnoreCase(barrio)){
                domicilio.setBarrio(b);
            }
        }
        domicilio.setCalle(calle);
        domicilio.setNumero(Integer.parseInt((numero)));
        domicilio.setDepartamento(departamento);
        domicilio.setPiso(Integer.parseInt(piso));
        this.guardarObjeto(domicilio);
        return domicilio;     
      }
    
    public void guardarCondicionIva(String condicion, Productor p){
        Iterator ite = this.listarClase(CondicionIva.class).iterator();
        while(ite.hasNext()){
            CondicionIva c = (CondicionIva) ite.next();
            if(c.getNombreCondicion().equalsIgnoreCase(condicion)){
                p.setCondicion(c);
            }
        }
    
    }
    public DefaultComboBoxModel rellenaComboTipoTel(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoTelefono.class).iterator();
       while(ite.hasNext()){
           TipoTelefono tipoTel =(TipoTelefono) ite.next();
               modelo.addElement(tipoTel);
           }

       return modelo;
   } 
    
    public DefaultComboBoxModel rellenaComboCondicionIva(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(CondicionIva.class).iterator();
       while(ite.hasNext()){
           CondicionIva tipoTel =(CondicionIva) ite.next();
               modelo.addElement(tipoTel);
           }

       return modelo;
   } 
    
    public int campoObligatorio(JTextField texto1, JTextField texto2, JTextField texto3){
         int campo = 0;   
         if(texto1.getText().equalsIgnoreCase("")){
                texto1.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
          if(texto2.getText().equalsIgnoreCase("")){
                texto2.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
           if(texto3.getText().equalsIgnoreCase("")){
                texto3.setBorder(BorderFactory.createLineBorder(Color.RED,1));
                campo=1;
            }
            
         if(campo == 1){
            JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios");
         }
         return campo;
     }
}
