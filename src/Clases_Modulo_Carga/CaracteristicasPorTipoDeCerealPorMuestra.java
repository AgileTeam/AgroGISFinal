/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;


import javax.persistence.*;

@Entity
@Table(name="CarPorTipoPorMuestra")
public class CaracteristicasPorTipoDeCerealPorMuestra {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idCarPorTipoPorMuestra;    
        
@ManyToOne(targetEntity = CaracteristicasCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CaracteristicasCereal caracteristicas;

@ManyToOne(targetEntity = MuestraTomada.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private MuestraTomada muestra;

@ManyToOne(targetEntity = TipoCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoCereal tipoCereal;

private Double valor;

/**
     * @return the idCarPorTipoPorMuestra
     */
    public long getIdCarPorTipoPorMuestra() {
        return idCarPorTipoPorMuestra;
    }

    /**
     * @param idCarPorTipoPorMuestra the idCarPorTipoPorMuestra to set
     */
    public void setIdCarPorTipoPorMuestra(long idCarPorTipoPorMuestra) {
        this.idCarPorTipoPorMuestra = idCarPorTipoPorMuestra;
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
     * @return the muestra
     */
    public MuestraTomada getMuestra() {
        return muestra;
    }

    /**
     * @param muestra the muestra to set
     */
    public void setMuestra(MuestraTomada muestra) {
        this.muestra = muestra;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
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

    
    
}
