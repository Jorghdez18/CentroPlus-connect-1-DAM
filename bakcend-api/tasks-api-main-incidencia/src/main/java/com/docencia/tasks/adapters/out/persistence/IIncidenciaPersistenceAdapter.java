package com.docencia.tasks.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import com.docencia.tasks.domain.model.Incidencia;

public interface IIncidenciaPersistenceAdapter {
  /**
   * Funcion que guarda una incidencia
   * @param incidencia 
   * @return
   */
  Incidencia save(Incidencia incidencia);

  /**
   * Funcion que devuelve una lista que devuelve todas las incidencias
   * @return
   */
  List<Incidencia> findAll();

  /**
   * Funcion que busca una incidencia por su id
   * @param id de la incidencia
   * @return
   */
  Optional<Incidencia> findById(Integer id);

  /**
   * Funcion que elimina una incidencia por su id
   * @param id de la incidencia
   */
  void deleteById(Integer id);

  /**
   * Funcion que 
   * @param id
   * @return
   */
  boolean existsById(Integer id);
}
