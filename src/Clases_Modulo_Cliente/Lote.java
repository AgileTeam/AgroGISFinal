/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Cliente;

import javax.persistence.*;

@Entity
@Table(name="Lote")

public class Lote {
   
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idLote;

    /**
     * @return the idLote
     */
    public long getIdLote() {
        return idLote;
    }

    /**
     * @param idLote the idLote to set
     */
    public void setIdLote(long idLote) {
        this.idLote = idLote;
    }
    
 
}
