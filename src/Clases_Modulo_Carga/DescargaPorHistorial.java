/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="DescargaPorHistorial")

public class DescargaPorHistorial {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDescargaPorHistorial;

@ManyToOne(targetEntity = HistorialProductor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private HistorialProductor historial;

@ManyToOne(targetEntity = Descarga.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Descarga descarga;

    /**
     * @return the idDescargaPorHistorial
     */
    public long getIdDescargaPorHistorial() {
        return idDescargaPorHistorial;
    }

    /**
     * @param idDescargaPorHistorial the idDescargaPorHistorial to set
     */
    public void setIdDescargaPorHistorial(long idDescargaPorHistorial) {
        this.idDescargaPorHistorial = idDescargaPorHistorial;
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
