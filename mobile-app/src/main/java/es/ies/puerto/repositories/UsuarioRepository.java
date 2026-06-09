package es.ies.puerto.repositories;

import es.ies.puerto.models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> findAll() {
        return usuarios;
    }

    public Usuario findById(int id) {

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                return usuarios.get(i);
            }
        }

        return null;
    }

    public boolean save(Usuario u) {

        if (u == null) {
            return false;
        }

        if (findById(u.getId()) != null) {
            return false;
        }

        usuarios.add(u);
        return true;
    }

    public boolean delete(int id) {

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.remove(i);
                return true;
            }
        }

        return false;
    }
}