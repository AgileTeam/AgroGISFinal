/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="PuertoPorSolicitud")

public class PuertoPorSolicitud {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idPuertoPorSolicitud;     

@ManyToOne(targetEntity = Puerto.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Puerto puerto;
    
@ManyToOne(targetEntity = SolicitudRetiro.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private SolicitudRetiro solicitud;

    /**
     * @return the idPuertoPorSolicitud
     */
    public long getIdPuertoPorSolicitud() {
        return idPuertoPorSolicitud;
    }

    /**
     * @param idPuertoPorSolicitud the idPuertoPorSolicitud to set
     */
    public void setIdPuertoPorSolicitud(long idPuertoPorSolicitud) {
        this.idPuertoPorSolicitud = idPuertoPorSolicitud;
    }

    /**
     * @return the puerto
     */
    public Puerto getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(Puerto puerto) {
        this.puerto = puerto;
    }

    /**
     * @return the solicitud
     */
    public SolicitudRetiro getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(SolicitudRetiro solicitud) {
        this.solicitud = solicitud;
    }
}
