/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="InformeLaboratorio")

public class InformeLaboratorio {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idInforme;     
    
@ManyToOne(targetEntity = Laboratorio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Laboratorio laboratorio;

@ManyToOne(targetEntity = CaracteristicasPorTipoDeCerealPorMuestra.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CaracteristicasPorTipoDeCerealPorMuestra caracteristicas;

@ManyToOne(targetEntity = TipoTemporada.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTemporada temporada;

private String fecha;

    /**
     * @return the idInforme
     */
    public long getIdInforme() {
        return idInforme;
    }

    /**
     * @param idInforme the idInforme to set
     */
    public void setIdInforme(long idInforme) {
        this.idInforme = idInforme;
    }

    /**
     * @return the laboratorio
     */
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    /**
     * @param laboratorio the laboratorio to set
     */
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    /**
     * @return the caracteristicas
     */
    public CaracteristicasPorTipoDeCerealPorMuestra getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(CaracteristicasPorTipoDeCerealPorMuestra caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**
     * @return the temporada
     */
    public TipoTemporada getTemporada() {
        return temporada;
    }

    /**
     * @param temporada the temporada to set
     */
    public void setTemporada(TipoTemporada temporada) {
        this.temporada = temporada;
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



}
