/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="TipoTemporada")

public class TipoTemporada {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoTemporada;   
    
private String nombreTipoTemporada;


    /**
     * @return the nombreTipoTemporada
     */
    public String getNombreTipoTemporada() {
        return nombreTipoTemporada;
    }

    /**
     * @param nombreTipoTemporada the nombreTipoTemporada to set
     */
    public void setNombreTipoTemporada(String nombreTipoTemporada) {
        this.nombreTipoTemporada = nombreTipoTemporada;
    }

    }
