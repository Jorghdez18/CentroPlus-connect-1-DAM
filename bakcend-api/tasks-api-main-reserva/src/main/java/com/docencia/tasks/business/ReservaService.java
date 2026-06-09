package com.docencia.tasks.business;

import org.springframework.stereotype.Service;

import com.docencia.tasks.adapters.out.persistence.IReservaPersistenceAdapter;
import com.docencia.tasks.domain.model.Reserva;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService {

    private final IReservaPersistenceAdapter repo;

    public ReservaService(IReservaPersistenceAdapter repo) {
        this.repo = repo;
    }

    @Override
    public Reserva create(Reserva reserva) {
        reserva.setId(null);
        return repo.save(reserva);
    }

    @Override
    public List<Reserva> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Reserva> getById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Reserva> update(Integer id, Reserva patch) {

        return repo.findById(id).map(existing -> {

            if (patch.getIdUsuario() != null)
                existing.setIdUsuario(patch.getIdUsuario());

            if (patch.getIdActividad() != null)
                existing.setIdActividad(patch.getIdActividad());

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