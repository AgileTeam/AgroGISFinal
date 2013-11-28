/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Estado")


public class Estado {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEstado;    
    
    
    private String nombreEstado;
    private int numeroEstado;


    /**
     * @return the nombreEstado
     */
    public String getNombreEstado() {
        return nombreEstado;
    }

    /**
     * @param nombreEstado the nombreEstado to set
     */
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    /**
     * @return the idEstado
     */
    public long getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the numeroEstado
     */
    public int getNumeroEstado() {
        return numeroEstado;
    }

    /**
     * @param numeroEstado the numeroEstado to set
     */
    public void setNumeroEstado(int numeroEstado) {
        this.numeroEstado = numeroEstado;
    }


}
