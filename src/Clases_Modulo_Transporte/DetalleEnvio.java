/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="DetalleEnvio")

public class DetalleEnvio {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDetalleEnvio;  
    
@ManyToOne(targetEntity = ArregloEfectuado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private ArregloEfectuado arregloEfectuado;

@ManyToOne(targetEntity = EnvioTaller.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private EnvioTaller envio;
    
   
private double precio;

  
    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the arregloEfectuado
     */
    public ArregloEfectuado getArregloEfectuado() {
        return arregloEfectuado;
    }

    /**
     * @param arregloEfectuado the arregloEfectuado to set
     */
    public void setArregloEfectuado(ArregloEfectuado arregloEfectuado) {
        this.arregloEfectuado = arregloEfectuado;
    }

    /**
     * @return the idDetalleEnvio
     */
    public long getIdDetalleEnvio() {
        return idDetalleEnvio;
    }

    /**
     * @param idDetalleEnvio the idDetalleEnvio to set
     */
    public void setIdDetalleEnvio(long idDetalleEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
    }

    /**
     * @return the envio
     */
    public EnvioTaller getEnvio() {
        return envio;
    }

    /**
     * @param envio the envio to set
     */
    public void setEnvio(EnvioTaller envio) {
        this.envio = envio;
    }
    
}
