package com.docencia.tasks.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import com.docencia.tasks.domain.model.Reserva;

public interface IReservaPersistenceAdapter {
  Reserva save(Reserva reserva);

  List<Reserva> findAll();

  Optional<Reserva> findById(Integer id);

  void deleteById(Integer id);

  boolean existsById(Integer id);
}
