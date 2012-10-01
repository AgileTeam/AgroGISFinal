/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Cliente;

import Clases_Modulo_Carga.*;
import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Transporte.Localidad;
import javax.persistence.*;

@Entity
@Table(name="Establecimiento")


public class Establecimiento {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEstablecimiento;     

@ManyToOne(targetEntity = Productor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Productor productor;

@ManyToOne(targetEntity = Localidad.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Localidad localidad;

private String nombreEstablecimiento;

    /**
     * @return the nombreEstablecimiento
     */
    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    /**
     * @param nombreEstablecimiento the nombreEstablecimiento to set
     */
    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    /**
     * @return the productor
     */
    public Productor getProductor() {
        return productor;
    }

    /**
     * @param productor the productor to set
     */
    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    /**
     * @return the idEstablecimiento
     */
    public long getIdEstablecimiento() {
        return idEstablecimiento;
    }

    /**
     * @param idEstablecimiento the idEstablecimiento to set
     */
    public void setIdEstablecimiento(long idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    /**
     * @return the localidad
     */
    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

}
