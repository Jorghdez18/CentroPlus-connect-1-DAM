package com.docencia.tasks.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import com.docencia.tasks.domain.model.Actividad;

public interface IActividadPersistenceAdapter {
  Actividad save(Actividad actividad);

  List<Actividad> findAll();

  Optional<Actividad> findById(Integer id);

  void deleteById(Integer id);

  boolean existsById(Integer id);
}
