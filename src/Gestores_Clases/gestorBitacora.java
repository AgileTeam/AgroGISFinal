/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import Clases_Modulo_Seguridad.Bitacora;
import Clases_Modulo_Seguridad.Operacion;
import Hibernate.GestorHibernate;
import java.util.Iterator;

/**
 *
 * @author Alejandra
 */
public class gestorBitacora extends GestorHibernate {
    
    public void cargarBitacora(String nroComprobante, String fecha, int operacion, String usuario){
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
       bitacora.setUsuario(usuario);
       this.guardarObjeto(bitacora);
    
    }
    
}
