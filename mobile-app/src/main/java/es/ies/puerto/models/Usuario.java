package es.ies.puerto.models;

import java.util.Objects;

public class Usuario extends Persona {

    private Integer id;
    private String tipoUsuario;


    public Usuario(Integer id, String tipoUsuario, String dni, String nombre, String telefono, String email) {
        super(dni, nombre, telefono, email);
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", tipoUsuario=" + tipoUsuario + "]";
    }

}
