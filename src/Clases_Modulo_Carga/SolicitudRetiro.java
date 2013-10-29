/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Transporte.Estado;

import javax.persistence.*;

@Entity
@Table(name="SolicitudRetiro")

public class SolicitudRetiro {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long numeroSolicitud;    

@ManyToOne(targetEntity = Productor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Productor productor;

@ManyToOne(targetEntity = TipoSolicitud.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoSolicitud tipoSolicitud;

@ManyToOne(targetEntity = TipoCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoCereal tipoCereal;

@ManyToOne(targetEntity = Silo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Silo silo;

    private String estado;
    private String fechaSolicitud;
    private String fechaEstimadaViaje;

    /**
     * @return the productor
     */
    public Productor getProductor() {
        return productor;
    }

    /**
     * @param productor the productor to set
     */
    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the numeroSolicitud
     */
    public long getNumeroSolicitud() {
        return numeroSolicitud;
    }

    /**
     * @param numeroSolicitud the numeroSolicitud to set
     */
    public void setNumeroSolicitud(long numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    /**
     * @return the fechaSolicitud
     */
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * @param fechaSolicitud the fechaSolicitud to set
     */
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * @return the tipoSolicitud
     */
    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    /**
     * @param tipoSolicitud the tipoSolicitud to set
     */
    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    /**
     * @return the tipoCereal
     */
    public TipoCereal getTipoCereal() {
        return tipoCereal;
    }

    /**
     * @param tipoCereal the tipoCereal to set
     */
    public void setTipoCereal(TipoCereal tipoCereal) {
        this.tipoCereal = tipoCereal;
    }
    
    public String toString(){
        return String.valueOf(numeroSolicitud);
    }

    /**
     * @return the fechaEstimadaViaje
     */
    public String getFechaEstimadaViaje() {
        return fechaEstimadaViaje;
    }

    /**
     * @param fechaEstimadaViaje the fechaEstimadaViaje to set
     */
    public void setFechaEstimadaViaje(String fechaEstimadaViaje) {
        this.fechaEstimadaViaje = fechaEstimadaViaje;
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
}
