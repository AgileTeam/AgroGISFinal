/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import Clases_Modulo_Seguridad.Bitacora;
import Clases_Modulo_Seguridad.Operacion;
import Clases_Modulo_Seguridad.TipoComprobante;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandra
 */
public class gestorBitacora extends GestorHibernate {
    
    public void cargarBitacora(String nroComprobante, String fecha, int operacion, String usuario, String TipoComprobante){
       Bitacora bitacora = new Bitacora();
       bitacora.setFecha(fecha);
       bitacora.setNroComprobante(nroComprobante);
       Iterator iteB = this.listarClase(Operacion.class).iterator();
       while(iteB.hasNext()){
           Operacion op = (Operacion) iteB.next();
           if(op.getIdOperacion()== operacion){
               bitacora.setOperacion(op);
           }
       }
       Iterator iteT = this.listarClase(TipoComprobante.class).iterator();
       while(iteT.hasNext()){
           TipoComprobante tipo = (TipoComprobante) iteT.next();
           if(tipo.getNombreTipoComprobante().equalsIgnoreCase(TipoComprobante)){
               bitacora.setTipoComp(tipo);
           }
       }
       bitacora.setUsuario(usuario);
       this.guardarObjeto(bitacora);
    
    }
    
     public int buscarObjeto(JTable tabla, Bitacora bit ){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       int bandera = 0;
       for(int i=0; i<modelo.getRowCount(); i++){
           if((bit.getNroComprobante() == tabla.getValueAt(i, 1))&&(bit.getOperacion()== tabla.getValueAt(i, 3))){
               bandera=1;
           }
       }
       return bandera;
   }
     
      public void cargarTabla(JTable tabla, Bitacora bit){
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       Object fila[]={bit.getFecha(), bit.getNroComprobante(), bit.getTipoComp(), bit.getOperacion(), bit.getUsuario()};
       modelo.addRow(fila);
       tabla.setModel(modelo);
      }
}
