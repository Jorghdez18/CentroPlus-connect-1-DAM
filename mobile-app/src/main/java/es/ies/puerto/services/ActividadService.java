package es.ies.puerto.services;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.repositories.ActividadRepository;

import java.util.List;

public class ActividadService {

    private ActividadRepository repository = new ActividadRepository();

    public List<Actividad> findAll() {
        return repository.findAll();
    }

    public Actividad findById(int id) {
        return repository.findById(id);
    }

    public boolean save(Actividad actividad) {

        if (actividad == null) {
            return false;
        }

        return repository.save(actividad);
    }

    public boolean reservarPlaza(int id) {

        Actividad actividad = repository.findById(id);

        if (actividad != null && actividad.tienePlazas()) {
            actividad.reservarPlaza();
            return true;
        }

        return false;
    }

    public boolean cancelarPlaza(int id) {

        Actividad actividad = repository.findById(id);

        if (actividad != null) {
            actividad.cancelarPlaza();
            return true;
        }

        return false;
    }
}