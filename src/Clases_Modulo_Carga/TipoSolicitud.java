/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="TipoSolicitudRetiro")

public class TipoSolicitud {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoSolicitud;     

private String nombreTipoSolicitud;

    /**
     * @return the idTipoSolicitud
     */
    public long getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    /**
     * @param idTipoSolicitud the idTipoSolicitud to set
     */
    public void setIdTipoSolicitud(long idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    /**
     * @return the nombreTipoSolicitud
     */
    public String getNombreTipoSolicitud() {
        return nombreTipoSolicitud;
    }

    /**
     * @param nombreTipoSolicitud the nombreTipoSolicitud to set
     */
    public void setNombreTipoSolicitud(String nombreTipoSolicitud) {
        this.nombreTipoSolicitud = nombreTipoSolicitud;
    }
    
    public String toString(){
        return nombreTipoSolicitud;
    }
}
