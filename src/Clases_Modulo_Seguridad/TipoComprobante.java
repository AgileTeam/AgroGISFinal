/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Seguridad;
import javax.persistence.*;

@Entity
@Table(name="TipoComprobante")

public class TipoComprobante {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idTipoComprobante;
    
    private String nombreTipoComprobante;

    /**
     * @return the idTipoComprobante
     */
    public long getIdTipoComprobante() {
        return idTipoComprobante;
    }

    /**
     * @param idTipoComprobante the idTipoComprobante to set
     */
    public void setIdTipoComprobante(long idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    /**
     * @return the nombreTipoComprobante
     */
    public String getNombreTipoComprobante() {
        return nombreTipoComprobante;
    }

    /**
     * @param nombreTipoComprobante the nombreTipoComprobante to set
     */
    public void setNombreTipoComprobante(String nombreTipoComprobante) {
        this.nombreTipoComprobante = nombreTipoComprobante;
    }
}
