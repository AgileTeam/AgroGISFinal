/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="EspecialidadLaboratorio")

public class EspecialidadLaboratorio {
   
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEspecialidadLaboratorio;    
    
    private String nombreEspecialidad;
    private String codigoEspecialidad;

    /**
     * @return the nombreEspecialidad
     */
    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    /**
     * @param nombreEspecialidad the nombreEspecialidad to set
     */
    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    /**
     * @return the idEspecialidadLaboratorio
     */
    public long getIdEspecialidadLaboratorio() {
        return idEspecialidadLaboratorio;
    }

    /**
     * @param idEspecialidadLaboratorio the idEspecialidadLaboratorio to set
     */
    public void setIdEspecialidadLaboratorio(long idEspecialidadLaboratorio) {
        this.idEspecialidadLaboratorio = idEspecialidadLaboratorio;
    }

    /**
     * @return the codigoEspecialidad
     */
    public String getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    /**
     * @param codigoEspecialidad the codigoEspecialidad to set
     */
    public void setCodigoEspecialidad(String codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }
    
}
