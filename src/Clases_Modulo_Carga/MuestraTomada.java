/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;


import Clases_Modulo_Transporte.Domicilio;
import Clases_Modulo_Transporte.Estado;
import Clases_Modulo_Transporte.TipoTelefono;
import javax.persistence.*;
import Clases_Modulo_Viaje.Viaje;

@Entity
@Table(name="MuestraTomada")

public class MuestraTomada {
   
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long numeroMuestra;  
    
    @ManyToOne(targetEntity = Laboratorio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Laboratorio laboratorio;
    
    @ManyToOne(targetEntity = Viaje.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Viaje viaje;
    
    @ManyToOne(targetEntity = Descarga.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Descarga descarga;
    
    @ManyToOne(targetEntity = Estado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Estado estadoMuestra;
   
    private String fechaEnvio;
    private int estado;
    private String responsableEnvio;
    private String resultado;

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
//
//    /**
//     * @param viaje the viaje to set
//     */
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

    /**
     * @return the descarga
     */
    public Descarga getDescarga() {
        return descarga;
    }

    /**
     * @param descarga the descarga to set
     */
    public void setDescarga(Descarga descarga) {
        this.descarga = descarga;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the responsableEnvio
     */
    public String getResponsableEnvio() {
        return responsableEnvio;
    }

    /**
     * @param responsableEnvio the responsableEnvio to set
     */
    public void setResponsableEnvio(String responsableEnvio) {
        this.responsableEnvio = responsableEnvio;
    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the estadoMuestra
     */
    public Estado getEstadoMuestra() {
        return estadoMuestra;
    }

    /**
     * @param estadoMuestra the estadoMuestra to set
     */
    public void setEstadoMuestra(Estado estadoMuestra) {
        this.estadoMuestra = estadoMuestra;
    }
   

    
}
