/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import Clases_Modulo_Cliente.Establecimiento;
import javax.persistence.*;

@Entity
@Table(name="EstablecimientoPorViaje")

public class EstablecimientoPorViaje {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEstablecimientoPorViaje;

@ManyToOne(targetEntity = Establecimiento.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Establecimiento establecimiento;

@ManyToOne(targetEntity = Viaje.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Viaje viaje;

    /**
     * @return the idEstablecimientoPorViaje
     */
    public long getIdEstablecimientoPorViaje() {
        return idEstablecimientoPorViaje;
    }

    /**
     * @param idEstablecimientoPorViaje the idEstablecimientoPorViaje to set
     */
    public void setIdEstablecimientoPorViaje(long idEstablecimientoPorViaje) {
        this.idEstablecimientoPorViaje = idEstablecimientoPorViaje;
    }

    /**
     * @return the establecimiento
     */
    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    /**
     * @param establecimiento the establecimiento to set
     */
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
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
