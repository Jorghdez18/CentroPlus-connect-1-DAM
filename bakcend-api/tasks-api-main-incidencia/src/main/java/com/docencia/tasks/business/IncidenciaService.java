package com.docencia.tasks.business;

import org.springframework.stereotype.Service;

import com.docencia.tasks.adapters.out.persistence.IIncidenciaPersistenceAdapter;
import com.docencia.tasks.domain.model.Incidencia;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService implements IIncidenciaService {

    private final IIncidenciaPersistenceAdapter repo;

    public IncidenciaService(IIncidenciaPersistenceAdapter repo) {
        this.repo = repo;
    }

    @Override
    public Incidencia create(Incidencia incidencia) {
        incidencia.setId(null);
        return repo.save(incidencia);
    }

    @Override
    public List<Incidencia> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Incidencia> getById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Incidencia> update(Integer id, Incidencia patch) {

        return repo.findById(id).map(existing -> {

            if (patch.getIdUsuario() != null)
                existing.setIdUsuario(patch.getIdUsuario());

            if (patch.getAsunto() != null)
                existing.setAsunto(patch.getAsunto());

            if (patch.getDescripcion() != null)
                existing.setDescripcion(patch.getDescripcion());

            if (patch.getFecha() != null)
                existing.setFecha(patch.getFecha());

            if (patch.getEstado() != null)
                existing.setEstado(patch.getEstado());

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