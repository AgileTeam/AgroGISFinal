/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="SolicitudPorHistorial")

public class SolicitudPorHistorial {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idSolicitudPorHistorial;        

@ManyToOne(targetEntity = HistorialProductor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private HistorialProductor historial;

@ManyToOne(targetEntity = SolicitudRetiro.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private SolicitudRetiro solicitud;

    /**
     * @return the idSolicitudPorHistorial
     */
    public long getIdSolicitudPorHistorial() {
        return idSolicitudPorHistorial;
    }

    /**
     * @param idSolicitudPorHistorial the idSolicitudPorHistorial to set
     */
    public void setIdSolicitudPorHistorial(long idSolicitudPorHistorial) {
        this.idSolicitudPorHistorial = idSolicitudPorHistorial;
    }

    /**
     * @return the historial
     */
    public HistorialProductor getHistorial() {
        return historial;
    }

    /**
     * @param historial the historial to set
     */
    public void setHistorial(HistorialProductor historial) {
        this.historial = historial;
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
