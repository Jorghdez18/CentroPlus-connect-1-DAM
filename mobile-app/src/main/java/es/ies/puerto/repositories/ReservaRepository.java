package es.ies.puerto.repositories;

import es.ies.puerto.models.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {

    private List<Reserva> reservas = new ArrayList<>();

    public List<Reserva> findAll() {
        return reservas;
    }

    public Reserva findById(int id) {

        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == id) {
                return reservas.get(i);
            }
        }
        return null;
    }

    public boolean save(Reserva r) {

        if (r == null) {
            return false;
        }

        if (findById(r.getId()) != null) {
            return false;
        }

        reservas.add(r);
        return true;
    }

    public boolean update(Reserva r) {

        if (r == null) {
            return false;
        }

        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == r.getId()) {
                reservas.set(i, r);
                return true;
            }
        }

        return false;
    }

    public boolean delete(int id) {

        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == id) {
                reservas.remove(i);
                return true;
            }
        }

        return false;
    }
}