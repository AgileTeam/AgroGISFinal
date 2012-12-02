/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="EnvioTaller")

public class EnvioTaller {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEnvio;  


@ManyToOne(targetEntity = TallerReparacion.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TallerReparacion taller;

@ManyToOne(targetEntity = OrdenServicio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
 private OrdenServicio ordenServicio;

private String fecha;
private String hora;
private double importeTotal;
private String responsable;
private int numeroComprobante;

   

    /**
     * @return the taller
     */
    public TallerReparacion getTaller() {
        return taller;
    }

    /**
     * @param taller the taller to set
     */
    public void setTaller(TallerReparacion taller) {
        this.taller = taller;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the importeTotal
     */
    public double getImporteTotal() {
        return importeTotal;
    }

    /**
     * @param importeTotal the importeTotal to set
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    /**
     * @return the idEnvio
     */
    public long getIdEnvio() {
        return idEnvio;
    }

    /**
     * @param idEnvio the idEnvio to set
     */
    public void setIdEnvio(long idEnvio) {
        this.idEnvio = idEnvio;
    }

    /**
     * @return the numeroComprobante
     */
    public int getNumeroComprobante() {
        return numeroComprobante;
    }

    /**
     * @param numeroComprobante the numeroComprobante to set
     */
    public void setNumeroComprobante(int numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    /**
     * @return the ordenServicio
     */
    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    /**
     * @param ordenServicio the ordenServicio to set
     */
    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }
    

   
           
}
