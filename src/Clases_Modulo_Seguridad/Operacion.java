/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Seguridad;

/**
 *
 * @author Alejandra
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Operacion")

public class Operacion {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idOperacion;

private String nombreOperacion;

    /**
     * @return the idOperacion
     */
    public long getIdOperacion() {
        return idOperacion;
    }

    /**
     * @param idOperacion the idOperacion to set
     */
    public void setIdOperacion(long idOperacion) {
        this.idOperacion = idOperacion;
    }

    /**
     * @return the nombreOperacion
     */
    public String getNombreOperacion() {
        return nombreOperacion;
    }

    /**
     * @param nombreOperacion the nombreOperacion to set
     */
    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    
}
