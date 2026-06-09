package com.docencia.tasks.business;

import java.util.List;
import java.util.Optional;

import com.docencia.tasks.domain.model.Reserva;

public interface IReservaService {
  /**
   * Funcion que crea una actividad
   * @param actividad
   * @return
   */
  Reserva create(Reserva actividad);

  /**
   * Funcion que devuelve una lista con todas las reservas
   * @return lista con todas las reservas
   */
  List<Reserva> getAll();

  /**
   * Funcion que busca una reserva por su id
   * @param id de la reserva
   * @return
   */
  Optional<Reserva> getById(Integer id);
  /**
   * Funcion que actualiza una reserva
   * @param id de la reserva
   * @param patch
   * @return
   */
  Optional<Reserva> update(Integer id, Reserva patch);

  /**
   * Funcion que elimina una reserva
   * @param id de la reserva
   * @return true/false dependiendo del resultado
   */
  boolean delete(Integer id);
}
