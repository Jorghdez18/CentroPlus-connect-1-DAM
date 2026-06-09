package com.docencia.tasks.business;

import org.springframework.stereotype.Service;

import com.docencia.tasks.adapters.out.persistence.IUsuarioPersistenceAdapter;
import com.docencia.tasks.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioPersistenceAdapter repo;

    public UsuarioService(IUsuarioPersistenceAdapter repo) {
        this.repo = repo;
    }

    @Override
    public Usuario create(Usuario usuario) {
        usuario.setId(null);
        return repo.save(usuario);
    }

    @Override
    public List<Usuario> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Usuario> getById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Usuario> update(Integer id, Usuario patch) {

        return repo.findById(id).map(existing -> {

            if (patch.getNombre() != null)
                existing.setNombre(patch.getNombre());

            if (patch.getEmail() != null)
                existing.setEmail(patch.getEmail());

            if (patch.getTelefono() != null)
                existing.setTelefono(patch.getTelefono());

            if (patch.getDni() != null)
                existing.setDni(patch.getDni());

            if (patch.getTipoUsuario() != null)
                existing.setTipoUsuario(patch.getTipoUsuario());

            return repo.save(existing);
        });
    }

    @Override
    public boolean delete(Integer id) {

        if (!repo.existsById(id))
            return false;

        repo.deleteById(id);

        return true;
    }
}