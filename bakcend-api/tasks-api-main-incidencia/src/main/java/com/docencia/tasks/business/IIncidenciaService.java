package com.docencia.tasks.business;

import java.util.List;
import java.util.Optional;

import com.docencia.tasks.domain.model.Incidencia;

public interface IIncidenciaService {
  /**
   * Funcion que crea una incidencia
   * @param incidencia 
   * @return
   */
  Incidencia create(Incidencia incidencia);

  /**
   *Funcion que devuelve una lista de todas las incidencias
   * @return
  */
  List<Incidencia> getAll();

  /**
   * Funcion que devuelve una incidencia por su id
   * @param id de la incidencia
   * @return
   */
  Optional<Incidencia> getById(Integer id);

  /**
   * Funcion que actualiza una incidencia
   * @param id de la actividad
   * @param patch
   * @return
   */
  Optional<Incidencia> update(Integer id, Incidencia patch);

  /**
   * Funcion que elimina una incidencia
   * @param id de la incidencia
   * @return true / false depende de resultado
   */
  boolean delete(Integer id);
}
