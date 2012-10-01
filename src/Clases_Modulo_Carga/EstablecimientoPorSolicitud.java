/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Cliente.Establecimiento;
import javax.persistence.*;

@Entity
@Table(name="EstablecimientoPorSolicitud")

public class EstablecimientoPorSolicitud {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEstablecimientoPorSolicitud;     

@ManyToOne(targetEntity = Establecimiento.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Establecimiento establecimiento;

    /**
     * @return the idEstablecimientoPorSolicitud
     */
    public long getIdEstablecimientoPorSolicitud() {
        return idEstablecimientoPorSolicitud;
    }

    /**
     * @param idEstablecimientoPorSolicitud the idEstablecimientoPorSolicitud to set
     */
    public void setIdEstablecimientoPorSolicitud(long idEstablecimientoPorSolicitud) {
        this.idEstablecimientoPorSolicitud = idEstablecimientoPorSolicitud;
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
    
}
