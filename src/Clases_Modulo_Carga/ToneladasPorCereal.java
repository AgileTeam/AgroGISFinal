/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="ToneladasPorCereal")

public class ToneladasPorCereal {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idToneladasPorCereal; 

@ManyToOne(targetEntity = HistorialProductor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private HistorialProductor historial;

@ManyToOne(targetEntity = TipoCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoCereal tipoCereal;

private double toneladas;

    /**
     * @return the idToneladasPorCereal
     */
    public long getIdToneladasPorCereal() {
        return idToneladasPorCereal;
    }

    /**
     * @param idToneladasPorCereal the idToneladasPorCereal to set
     */
    public void setIdToneladasPorCereal(long idToneladasPorCereal) {
        this.idToneladasPorCereal = idToneladasPorCereal;
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

    /**
     * @return the toneladas
     */
    public double getToneladas() {
        return toneladas;
    }

    /**
     * @param toneladas the toneladas to set
     */
    public void setToneladas(double toneladas) {
        this.toneladas = toneladas;
    }

}
