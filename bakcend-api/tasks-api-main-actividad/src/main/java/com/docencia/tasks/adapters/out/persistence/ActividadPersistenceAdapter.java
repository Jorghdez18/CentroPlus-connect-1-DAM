package com.docencia.tasks.adapters.out.persistence;

import org.springframework.stereotype.Component;

import com.docencia.tasks.adapters.mapper.ActividadMapper;
import com.docencia.tasks.domain.model.Actividad;

import java.util.List;
import java.util.Optional;

@Component
public class ActividadPersistenceAdapter implements IActividadPersistenceAdapter {

  private final ActividadRepositoryRepository jpaRepo;
  private final ActividadMapper mapper;

  public ActividadPersistenceAdapter(ActividadRepositoryRepository jpaRepo, ActividadMapper mapper) {
    this.jpaRepo = jpaRepo;
    this.mapper = mapper;
  }

  @Override
  public Actividad save(Actividad task) {
    ActividadJpaEntity saved = jpaRepo.save(mapper.toJpa(task));
    return mapper.toDomain(saved);
  }

  @Override
  public List<Actividad> findAll() {
    return jpaRepo.findAll().stream().map(mapper::toDomain).toList();
  }

  @Override
  public Optional<Actividad> findById(Integer id) {
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
