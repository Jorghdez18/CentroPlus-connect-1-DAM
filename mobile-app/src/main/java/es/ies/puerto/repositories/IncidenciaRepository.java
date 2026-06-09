package es.ies.puerto.repositories;

import es.ies.puerto.models.Incidencia;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaRepository {

    private List<Incidencia> lista = new ArrayList<>();

    public List<Incidencia> findAll() {
        return lista;
    }

    public Incidencia findById(int id) {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                return lista.get(i);
            }
        }
        return null;
    }

    public boolean save(Incidencia incidencia) {

        if (incidencia == null) {
            return false;
        }

        if (findById(incidencia.getId()) != null) {
            return false;
        }

        lista.add(incidencia);
        return true;
    }

    public boolean update(Incidencia incidencia) {

        if (incidencia == null) {
            return false;
        }

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == incidencia.getId()) {
                lista.set(i, incidencia);
                return true;
            }
        }

        return false;
    }

    public boolean delete(int id) {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                return true;
            }
        }

        return false;
    }
}