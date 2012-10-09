/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Cliente.Establecimiento;
import javax.persistence.*;

@Entity
@Table(name="EstablecimientoPorSolicitud")

public class EstablecimientoPorSolicitud {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEstablecimientoPorSolicitud;     

@ManyToOne(targetEntity = Establecimiento.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Establecimiento establecimiento;

@ManyToOne(targetEntity = SolicitudRetiro.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private SolicitudRetiro solicitud;

@ManyToOne(targetEntity = Silo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Silo silo;

@ManyToOne(targetEntity = TipoOperacion.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoOperacion tipoOperacion;

private double hectareasATrillar;
private double toneladasAExtraer;

    /**
     * @return the idEstablecimientoPorSolicitud
     */
    public long getIdEstablecimientoPorSolicitud() {
        return idEstablecimientoPorSolicitud;
    }

    /**
     * @param idEstablecimientoPorSolicitud the idEstablecimientoPorSolicitud to set
     */
    public void setIdEstablecimientoPorSolicitud(long idEstablecimientoPorSolicitud) {
        this.idEstablecimientoPorSolicitud = idEstablecimientoPorSolicitud;
    }

    /**
     * @return the establecimiento
     */
    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    /**
     * @param establecimiento the establecimiento to set
     */
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
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
     * @return the hectareasATrillar
     */
    public double getHectareasATrillar() {
        return hectareasATrillar;
    }

    /**
     * @param hectareasATrillar the hectareasATrillar to set
     */
    public void setHectareasATrillar(double hectareasATrillar) {
        this.hectareasATrillar = hectareasATrillar;
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
