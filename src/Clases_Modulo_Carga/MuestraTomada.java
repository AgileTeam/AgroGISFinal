/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Transporte.Domicilio;
import Clases_Modulo_Transporte.TipoTelefono;
import javax.persistence.*;

@Entity
@Table(name="MuestraTomada")

public class MuestraTomada {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long numeroMuestra;  
    
    @ManyToOne(targetEntity = Laboratorio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Laboratorio laboratorio;
    
    @ManyToOne(targetEntity = Viaje.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Viaje viaje;
   
    private String fechaEnvio;

    /**
     * @return the numeroMuestra
     */
    public long getNumeroMuestra() {
        return numeroMuestra;
    }

    /**
     * @param numeroMuestra the numeroMuestra to set
     */
    public void setNumeroMuestra(long numeroMuestra) {
        this.numeroMuestra = numeroMuestra;
    }

    /**
     * @return the laboratorio
     */
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    /**
     * @param laboratorio the laboratorio to set
     */
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    /**
     * @return the viaje
     */
    public Viaje getViaje() {
        return viaje;
    }

    /**
     * @param viaje the viaje to set
     */
    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    /**
     * @return the fechaEnvio
     */
    public String getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     * @param fechaEnvio the fechaEnvio to set
     */
    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
   

    
}
