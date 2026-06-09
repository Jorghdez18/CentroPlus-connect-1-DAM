package com.docencia.tasks.adapters.out.persistence;

import org.springframework.stereotype.Component;

import com.docencia.tasks.adapters.mapper.ReservaMapper;
import com.docencia.tasks.domain.model.Reserva;

import java.util.List;
import java.util.Optional;

@Component
public class ReservaPersistenceAdapter implements IReservaPersistenceAdapter {

  private final ReservaRepositoryRepository jpaRepo;
  private final ReservaMapper mapper;

  public ReservaPersistenceAdapter(ReservaRepositoryRepository jpaRepo, ReservaMapper mapper) {
    this.jpaRepo = jpaRepo;
    this.mapper = mapper;
  }

  @Override
  public Reserva save(Reserva reserva) {
    ReservaJpaEntity saved = jpaRepo.save(mapper.toJpa(reserva));
    return mapper.toDomain(saved);
  }

  @Override
  public List<Reserva> findAll() {
    return jpaRepo.findAll().stream().map(mapper::toDomain).toList();
  }

  @Override
  public Optional<Reserva> findById(Integer id) {
    return jpaRepo.findById(id).map(mapper::toDomain);
  }

  @Override
  public void deleteById(Integer id) {
    jpaRepo.deleteById(id);
  }

  @Override
  public boolean existsById(Integer id) {
    return jpaRepo.existsById(id);
  }
}
