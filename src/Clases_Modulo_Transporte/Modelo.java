/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Modelo")

public class Modelo {
 
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idModelo;
    
@ManyToOne(targetEntity = Marca.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Marca marca;  

private String nombreModelo;

    /**
     * @return the nombreModelo
     */
    public String getNombreModelo() {
        return nombreModelo;
    }

    /**
     * @param nombreModelo the nombreModelo to set
     */
    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the idModelo
     */
    public long getIdModelo() {
        return idModelo;
    }

    /**
     * @param idModelo the idModelo to set
     */
    public void setIdModelo(long idModelo) {
        this.idModelo = idModelo;
    }
    
    public String toString(){
        return getNombreModelo();
    }
}
