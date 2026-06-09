package com.docencia.tasks.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.docencia.tasks.adapters.mapper.UsuarioMapper;
import com.docencia.tasks.domain.model.Usuario;

@Component
public class UsuarioPersistenceAdapter implements IUsuarioPersistenceAdapter {

    private final UsuarioRepositoryRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioPersistenceAdapter(
            UsuarioRepositoryRepository repository,
            UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return mapper.toDomain(
                repository.save(mapper.toJpa(usuario))
        );
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}