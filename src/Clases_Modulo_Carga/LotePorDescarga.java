/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;


import Clases_Modulo_Cliente.Lote;
import javax.persistence.*;

@Entity
@Table(name="LotePorDescarga")

public class LotePorDescarga {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idLotePorDescarga;
    
    @ManyToOne(targetEntity = Descarga.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Descarga descarga;
    
    @ManyToOne(targetEntity = Lote.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Lote lote;

    /**
     * @return the idLotePorDescarga
     */
    public long getIdLotePorDescarga() {
        return idLotePorDescarga;
    }

    /**
     * @param idLotePorDescarga the idLotePorDescarga to set
     */
    public void setIdLotePorDescarga(long idLotePorDescarga) {
        this.idLotePorDescarga = idLotePorDescarga;
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

    /**
     * @return the lote
     */
    public Lote getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(Lote lote) {
        this.lote = lote;
    }
    
}
