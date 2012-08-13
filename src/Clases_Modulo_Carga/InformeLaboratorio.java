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
    
@ManyToOne(targetEntity = .class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Productor productor;

    private Laboratorio laboratorio;
    private TipoTemporada temporada;

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
     * @return the muestra
     */
    public MuestraTomada getMuestra() {
        return muestra;
    }

    /**
     * @param muestra the muestra to set
     */
    public void setMuestra(MuestraTomada muestra) {
        this.muestra = muestra;
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

 
}
