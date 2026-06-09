package com.docencia.tasks.business;

import org.springframework.stereotype.Service;

import com.docencia.tasks.adapters.out.persistence.IActividadPersistenceAdapter;
import com.docencia.tasks.domain.model.Actividad;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService implements IActividadService {

    private final IActividadPersistenceAdapter repo;

    public ActividadService(IActividadPersistenceAdapter repo) {
        this.repo = repo;
    }

    @Override
    public Actividad create(Actividad actividad) {
        actividad.setId(null);
        return repo.save(actividad);
    }

    @Override
    public List<Actividad> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Actividad> getById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Actividad> update(Integer id, Actividad patch) {

        return repo.findById(id).map(existing -> {

            if (patch.getNombre() != null)
                existing.setNombre(patch.getNombre());

            if (patch.getTipoActividad() != null)
                existing.setTipoActividad(patch.getTipoActividad());

            if (patch.getDuracion() != null)
                existing.setDuracion(patch.getDuracion());

            if (patch.getPrecio() != null)
                existing.setPrecio(patch.getPrecio());

            if (patch.getPlazasMaximas() != null)
                existing.setPlazasMaximas(patch.getPlazasMaximas());

            if (patch.getPlazasOcupadas() != null)
                existing.setPlazasOcupadas(patch.getPlazasOcupadas());

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