/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Seguridad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rol")

public class Rol {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idRol;

private String nombreRol;

    /**
     * @return the idRol
     */
    public long getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the nombreRol
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * @param nombreRol the nombreRol to set
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
     public String toString(){
        return (nombreRol);
    }
}
