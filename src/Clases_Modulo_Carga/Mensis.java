/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="Mensis")

public class Mensis {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idMensis;

private int numeroMuestra;
private String cereal;
private String pesoH;
private String humedad;
private String materiasExt;


    /**
     * @return the idMensis
     */
    public long getIdMensis() {
        return idMensis;
    }

    /**
     * @param idMensis the idMensis to set
     */
    public void setIdMensis(long idMensis) {
        this.idMensis = idMensis;
    }

    /**
     * @return the numeroMuestra
     */
    public int getNumeroMuestra() {
        return numeroMuestra;
    }

    /**
     * @param numeroMuestra the numeroMuestra to set
     */
    public void setNumeroMuestra(int numeroMuestra) {
        this.numeroMuestra = numeroMuestra;
    }

    /**
     * @return the cereal
     */
    public String getCereal() {
        return cereal;
    }

    /**
     * @param cereal the cereal to set
     */
    public void setCereal(String cereal) {
        this.cereal = cereal;
    }

    /**
     * @return the pesoH
     */
    public String getPesoH() {
        return pesoH;
    }

    /**
     * @param pesoH the pesoH to set
     */
    public void setPesoH(String pesoH) {
        this.pesoH = pesoH;
    }

    /**
     * @return the humedad
     */
    public String getHumedad() {
        return humedad;
    }

    /**
     * @param humedad the humedad to set
     */
    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    /**
     * @return the materiasExt
     */
    public String getMateriasExt() {
        return materiasExt;
    }

    /**
     * @param materiasExt the materiasExt to set
     */
    public void setMateriasExt(String materiasExt) {
        this.materiasExt = materiasExt;
    }
   
    
}
