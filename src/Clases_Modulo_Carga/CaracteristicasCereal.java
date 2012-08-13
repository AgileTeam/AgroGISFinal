/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;


import javax.persistence.*;

@Entity
@Table(name="CaracteristicasCereal")

public class CaracteristicasCereal { 
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idCaracteristicasCereal;    
    
private String nombreCaracteristica;

    /**
     * @return the idCaracteristicasCereal
     */
    public long getIdCaracteristicasCereal() {
        return idCaracteristicasCereal;
    }

    /**
     * @param idCaracteristicasCereal the idCaracteristicasCereal to set
     */
    public void setIdCaracteristicasCereal(long idCaracteristicasCereal) {
        this.idCaracteristicasCereal = idCaracteristicasCereal;
    }

    /**
     * @return the nombreCaracteristica
     */
    public String getNombreCaracteristica() {
        return nombreCaracteristica;
    }

    /**
     * @param nombreCaracteristica the nombreCaracteristica to set
     */
    public void setNombreCaracteristica(String nombreCaracteristica) {
        this.nombreCaracteristica = nombreCaracteristica;
    }


}
