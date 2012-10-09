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

@ManyToOne(targetEntity = Silo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Silo silo;

@ManyToOne(targetEntity = TipoOperacion.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoOperacion tipoOperacion;

private double toneladasAExtraer;
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

    /**
     * @return the silo
     */
    public Silo getSilo() {
        return silo;
    }

    /**
     * @param silo the silo to set
     */
    public void setSilo(Silo silo) {
        this.silo = silo;
    }

    /**
     * @return the tipoOperacion
     */
    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * @param tipoOperacion the tipoOperacion to set
     */
    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * @return the toneladasAExtraer
     */
    public double getToneladasAExtraer() {
        return toneladasAExtraer;
    }

    /**
     * @param toneladasAExtraer the toneladasAExtraer to set
     */
    public void setToneladasAExtraer(double toneladasAExtraer) {
        this.toneladasAExtraer = toneladasAExtraer;
    }
}
