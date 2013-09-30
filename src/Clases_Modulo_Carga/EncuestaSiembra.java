/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Viaje.Anio;
import javax.persistence.*;

@Entity
@Table(name="EncuestaSiembra")

public class EncuestaSiembra {
    
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
   private long enc_id;
   
   @ManyToOne(targetEntity = TipoCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
   private TipoCereal gra_id;
    
   @ManyToOne(targetEntity = Anio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
   private Anio anio_id;
   
   @ManyToOne(targetEntity = Productor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
   private Productor pro_id;
   
   private double has_siembra;
   private double his_rindeestimado;
   private int estado;
   private double his_costodolar;

    /**
     * @return the enc_id
     */
    public long getEnc_id() {
        return enc_id;
    }

    /**
     * @param enc_id the enc_id to set
     */
    public void setEnc_id(long enc_id) {
        this.enc_id = enc_id;
    }

    /**
     * @return the gra_id
     */
    public TipoCereal getGra_id() {
        return gra_id;
    }

    /**
     * @param gra_id the gra_id to set
     */
    public void setGra_id(TipoCereal gra_id) {
        this.gra_id = gra_id;
    }

    /**
     * @return the anio_id
     */
    public Anio getAnio_id() {
        return anio_id;
    }

    /**
     * @param anio_id the anio_id to set
     */
    public void setAnio_id(Anio anio_id) {
        this.anio_id = anio_id;
    }

    /**
     * @return the pro_id
     */
    public Productor getPro_id() {
        return pro_id;
    }

    /**
     * @param pro_id the pro_id to set
     */
    public void setPro_id(Productor pro_id) {
        this.pro_id = pro_id;
    }

    /**
     * @return the has_siembra
     */
    public double getHas_siembra() {
        return has_siembra;
    }

    /**
     * @param has_siembra the has_siembra to set
     */
    public void setHas_siembra(double has_siembra) {
        this.has_siembra = has_siembra;
    }

    /**
     * @return the his_rindeestimado
     */
    public double getHis_rindeestimado() {
        return his_rindeestimado;
    }

    /**
     * @param his_rindeestimado the his_rindeestimado to set
     */
    public void setHis_rindeestimado(double his_rindeestimado) {
        this.his_rindeestimado = his_rindeestimado;
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
     * @return the his_costodolar
     */
    public double getHis_costodolar() {
        return his_costodolar;
    }

    /**
     * @param his_costodolar the his_costodolar to set
     */
    public void setHis_costodolar(double his_costodolar) {
        this.his_costodolar = his_costodolar;
    }
   
   
}
