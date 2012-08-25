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
    
private double valorDesde;
private double valorHasta;
}
