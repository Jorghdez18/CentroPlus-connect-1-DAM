package es.ies.puerto.repositories;

import es.ies.puerto.models.Actividad;
import java.util.ArrayList;
import java.util.List;

public class ActividadRepository {

    private List<Actividad> actividades = new ArrayList<>();

    public List<Actividad> findAll() {
        return actividades;
    }

    public Actividad findById(int id) {

        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getId() == id) {
                return actividades.get(i);
            }
        }
        return null;
    }

    public boolean save(Actividad actividad) {

        if (actividad == null) {
            return false;
        }

        if (findById(actividad.getId()) != null) {
            return false;
        }

        actividades.add(actividad);
        return true;
    }

    public boolean update(Actividad actividad) {

        if (actividad == null) {
            return false;
        }

        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getId() == actividad.getId()) {
                actividades.set(i, actividad);
                return true;
            }
        }

        return false;
    }

    public boolean delete(int id) {

        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getId() == id) {
                actividades.remove(i);
                return true;
            }
        }

        return false;
    }
}