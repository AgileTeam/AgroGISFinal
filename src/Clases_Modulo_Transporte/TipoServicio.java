/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="TipoServicio")

public class TipoServicio {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoServicio;

private String nombreTipoServicio;

    /**
     * @return the nombreTipoServicio
     */
    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }

    /**
     * @param nombreTipoServicio the nombreTipoServicio to set
     */
    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }

    /**
     * @return the idTipoServicio
     */
    public long getIdTipoServicio() {
        return idTipoServicio;
    }

    /**
     * @param idTipoServicio the idTipoServicio to set
     */
    public void setIdTipoServicio(long idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }
    
    public String toString(){
        return nombreTipoServicio;
    }



   

}
