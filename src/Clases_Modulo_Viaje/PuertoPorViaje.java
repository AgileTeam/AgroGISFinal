/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import Clases_Modulo_Carga.Puerto;
import javax.persistence.*;

@Entity
@Table(name="PuertoPorViaje")

public class PuertoPorViaje {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idPuertoPorViaje;

@ManyToOne(targetEntity = Puerto.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Puerto puerto;

@ManyToOne(targetEntity = Viaje.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Viaje viaje;

    /**
     * @return the idPuertoPorViaje
     */
    public long getIdPuertoPorViaje() {
        return idPuertoPorViaje;
    }

    /**
     * @param idPuertoPorViaje the idPuertoPorViaje to set
     */
    public void setIdPuertoPorViaje(long idPuertoPorViaje) {
        this.idPuertoPorViaje = idPuertoPorViaje;
    }

    /**
     * @return the puerto
     */
    public Puerto getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(Puerto puerto) {
        this.puerto = puerto;
    }

    /**
     * @return the viaje
     */
    public Viaje getViaje() {
        return viaje;
    }

    /**
     * @param viaje the viaje to set
     */
    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
