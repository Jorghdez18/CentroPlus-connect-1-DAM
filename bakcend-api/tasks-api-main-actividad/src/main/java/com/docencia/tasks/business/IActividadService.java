package com.docencia.tasks.business;

import java.util.List;
import java.util.Optional;

import com.docencia.tasks.domain.model.Actividad;

public interface IActividadService {
  /**
   * Funcion que crea una actividad
   * @param task
   * @return
   */
  Actividad create(Actividad actividad);

  /**
   * Funcion que devuelve una lista con todas las actividades
   * @return lista de actividades
   */
  List<Actividad> getAll();

  /**
   * Funcion que devuelve una actividad por su id 
   * @param id de la actividad
   * @return
   */
  Optional<Actividad> getById(Integer id);

  /**
   * Funcion que actualiza una actividad
   * @param id de la actividad
   * @param patch
   * @return
   */
  Optional<Actividad> update(Integer id, Actividad patch);

  /**
   * Funcion que elimina una actividad por su id
   * @param id
   * @return
   */
  boolean delete(Integer id);
}
