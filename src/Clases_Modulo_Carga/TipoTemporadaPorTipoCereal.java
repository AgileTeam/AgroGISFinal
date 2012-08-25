/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name="TipoTemporadaPorTipoCereal")

public class TipoTemporadaPorTipoCereal {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoTemporadaPorTipoCereal;

@ManyToOne(targetEntity = TipoTemporada.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTemporada tipoTemporada;

@ManyToOne(targetEntity = TipoCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoCereal tipoCereal;

    /**
     * @return the idTipoTemporadaPorTipoCereal
     */
    public long getIdTipoTemporadaPorTipoCereal() {
        return idTipoTemporadaPorTipoCereal;
    }

    /**
     * @param idTipoTemporadaPorTipoCereal the idTipoTemporadaPorTipoCereal to set
     */
    public void setIdTipoTemporadaPorTipoCereal(long idTipoTemporadaPorTipoCereal) {
        this.idTipoTemporadaPorTipoCereal = idTipoTemporadaPorTipoCereal;
    }

    /**
     * @return the tipoTemporada
     */
    public TipoTemporada getTipoTemporada() {
        return tipoTemporada;
    }

    /**
     * @param tipoTemporada the tipoTemporada to set
     */
    public void setTipoTemporada(TipoTemporada tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
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
}
