/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="CaracteristicasPorTipoDeCereal")

public class CaracteristicasPorTipoDeCereal {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idCaracteristicaPorTipoCereal;

@ManyToOne(targetEntity = CaracteristicasCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CaracteristicasCereal caracteristicas;
 
@ManyToOne(targetEntity = TipoCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoCereal tipoCereal;
    
private double valor;


    /**
     * @return the idCaracteristicaPorTipoCereal
     */
    public long getIdCaracteristicaPorTipoCereal() {
        return idCaracteristicaPorTipoCereal;
    }

    /**
     * @param idCaracteristicaPorTipoCereal the idCaracteristicaPorTipoCereal to set
     */
    public void setIdCaracteristicaPorTipoCereal(long idCaracteristicaPorTipoCereal) {
        this.idCaracteristicaPorTipoCereal = idCaracteristicaPorTipoCereal;
    }

    /**
     * @return the caracteristicas
     */
    public CaracteristicasCereal getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(CaracteristicasCereal caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**
     * @return the tipoCereal
     */
    public TipoCereal getTipoCereal() {
        return tipoCereal;
    }

    /**
     * @param tipoCereal the tipoCereal to set
     */
    public void setTipoCereal(TipoCereal tipoCereal) {
        this.tipoCereal = tipoCereal;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }


 
}
