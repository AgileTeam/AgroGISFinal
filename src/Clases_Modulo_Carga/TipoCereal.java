/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;


import javax.persistence.*;

@Entity
@Table(name="TipoCereal")

public class TipoCereal {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoCereal;    
   
private String nombreCereal;

@ManyToOne(targetEntity = TipoTemporada.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTemporada tipoTemporada;

    /**
     * @return the idTipoCereal
     */
    public long getIdTipoCereal() {
        return idTipoCereal;
    }

    /**
     * @param idTipoCereal the idTipoCereal to set
     */
    public void setIdTipoCereal(long idTipoCereal) {
        this.idTipoCereal = idTipoCereal;
    }

    /**
     * @return the nombreCereal
     */
    public String getNombreCereal() {
        return nombreCereal;
    }

    /**
     * @param nombreCereal the nombreCereal to set
     */
    public void setNombreCereal(String nombreCereal) {
        this.nombreCereal = nombreCereal;
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




}
