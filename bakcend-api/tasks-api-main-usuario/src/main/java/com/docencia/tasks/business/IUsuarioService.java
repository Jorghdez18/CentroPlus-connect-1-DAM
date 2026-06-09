package com.docencia.tasks.business;

import java.util.List;
import java.util.Optional;

import com.docencia.tasks.domain.model.Usuario;

public interface IUsuarioService {

    /**
     * Metodo que crea un usuario
     * @param usuario
     * @return
     */
    Usuario create(Usuario usuario);

    /**
     * Metodo que lista todos los usuarios en una lista
     * @return
     */
    List<Usuario> getAll();

    /**
     * Metodo que devuelve un usuario por su id
     * @param id
     * @return
     */
    Optional<Usuario> getById(Integer id);

    /**
     * Metodo que actualiza un usuario
     * @param id del usuario
     * @param patch
     * @return
     */
    Optional<Usuario> update(Integer id, Usuario patch);

    /**
     * Metodo que elimina un usuario por su id
     * @param id
     * @return
     */
    boolean delete(Integer id);

    
}
