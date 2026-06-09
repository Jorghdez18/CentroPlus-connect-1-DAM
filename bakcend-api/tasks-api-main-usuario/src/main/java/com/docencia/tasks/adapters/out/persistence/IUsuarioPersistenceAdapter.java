package com.docencia.tasks.adapters.out.persistence;

import com.docencia.tasks.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioPersistenceAdapter {

    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);

    boolean existsById(Integer id);

    void deleteById(Integer id);
}