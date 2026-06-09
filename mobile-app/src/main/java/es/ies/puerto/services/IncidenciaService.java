package es.ies.puerto.services;

import es.ies.puerto.models.Incidencia;
import es.ies.puerto.repositories.IncidenciaRepository;

import java.util.List;

public class IncidenciaService {

    private IncidenciaRepository repository = new IncidenciaRepository();

    public List<Incidencia> findAll() {
        return repository.findAll();
    }

    public boolean crearIncidencia(int id, int idUsuario, String asunto, String descripcion) {

        if (asunto == null || asunto.isEmpty()) {
            return false;
        }

        if (descripcion == null || descripcion.isEmpty()) {
            return false;
        }

        Incidencia incidencia = new Incidencia(id, idUsuario, asunto, descripcion);
        return repository.save(incidencia);
    }
}