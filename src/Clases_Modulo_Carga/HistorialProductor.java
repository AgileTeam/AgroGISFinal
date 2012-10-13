/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Cliente.Productor;
import javax.persistence.*;

@Entity
@Table(name="HistorialProductor")

public class HistorialProductor {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idHistorial;    
    
@ManyToOne(targetEntity = Productor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Productor productor;

    /**
     * @return the idHistorial
     */
    public long getIdHistorial() {
        return idHistorial;
    }

    /**
     * @param idHistorial the idHistorial to set
     */
    public void setIdHistorial(long idHistorial) {
        this.idHistorial = idHistorial;
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

}
