/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="DetalleCarga")

public class DetalleCarga {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDetalleCarga;    
    
@ManyToOne(targetEntity = TipoCombustible.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoCombustible tipoCombustible;

@ManyToOne(targetEntity = CargaCombustible.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CargaCombustible cargaCombustible;

    
    private double importeTotal;


  
    /**
     * @return the tipoCombustible
     */
    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    /**
     * @param tipoCombustible the tipoCombustible to set
     */
    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    /**
     * @return the cargaCombustible
     */
    public CargaCombustible getCargaCombustible() {
        return cargaCombustible;
    }

    /**
     * @param cargaCombustible the cargaCombustible to set
     */
    public void setCargaCombustible(CargaCombustible cargaCombustible) {
        this.cargaCombustible = cargaCombustible;
    }

    /**
     * @return the idDetalleCarga
     */
    public long getIdDetalleCarga() {
        return idDetalleCarga;
    }

    /**
     * @param idDetalleCarga the idDetalleCarga to set
     */
    public void setIdDetalleCarga(long idDetalleCarga) {
        this.idDetalleCarga = idDetalleCarga;
    }

    /**
     * @return the importeTotal
     */
    public double getImporteTotal() {
        return importeTotal;
    }

    /**
     * @param importeTotal the importeTotal to set
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
    
}
