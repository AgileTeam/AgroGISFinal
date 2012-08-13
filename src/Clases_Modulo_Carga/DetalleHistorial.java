/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="DetalleHistorial")

public class DetalleHistorial {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDetalle; 

@ManyToOne(targetEntity = HistorialProductor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private HistorialProductor historial;

@ManyToOne(targetEntity = Retiro.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Retiro retiro;

@ManyToOne(targetEntity = Descarga.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Descarga descarga;

    /**
     * @return the idDetalle
     */
    public long getIdDetalle() {
        return idDetalle;
    }

    /**
     * @param idDetalle the idDetalle to set
     */
    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
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
     * @return the retiro
     */
    public Retiro getRetiro() {
        return retiro;
    }

    /**
     * @param retiro the retiro to set
     */
    public void setRetiro(Retiro retiro) {
        this.retiro = retiro;
    }

    /**
     * @return the descarga
     */
    public Descarga getDescarga() {
        return descarga;
    }

    /**
     * @param descarga the descarga to set
     */
    public void setDescarga(Descarga descarga) {
        this.descarga = descarga;
    }

}
