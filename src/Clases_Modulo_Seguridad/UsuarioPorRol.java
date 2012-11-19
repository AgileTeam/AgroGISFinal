/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Seguridad;

import Clases_Modulo_Transporte.Domicilio;
import javax.persistence.*;

@Entity
@Table(name="UsuarioXRol")

public class UsuarioPorRol {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idUsuarioXRol;

@ManyToOne(targetEntity = Usuario.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Usuario usuario;

@ManyToOne(targetEntity = Rol.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Rol rol;

    /**
     * @return the idUsuarioXRol
     */
    public long getIdUsuarioXRol() {
        return idUsuarioXRol;
    }

    /**
     * @param idUsuarioXRol the idUsuarioXRol to set
     */
    public void setIdUsuarioXRol(long idUsuarioXRol) {
        this.idUsuarioXRol = idUsuarioXRol;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
