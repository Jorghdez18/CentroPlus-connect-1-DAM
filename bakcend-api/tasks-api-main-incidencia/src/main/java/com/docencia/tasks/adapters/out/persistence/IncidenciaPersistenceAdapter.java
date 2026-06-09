package com.docencia.tasks.adapters.out.persistence;

import org.springframework.stereotype.Component;

import com.docencia.tasks.adapters.mapper.IncidenciaMapper;
import com.docencia.tasks.domain.model.Incidencia;

import java.util.List;
import java.util.Optional;

@Component
public class IncidenciaPersistenceAdapter implements IIncidenciaPersistenceAdapter {

  private final IncidenciaRepositoryRepository jpaRepo;
  private final IncidenciaMapper mapper;

  public IncidenciaPersistenceAdapter(IncidenciaRepositoryRepository jpaRepo, IncidenciaMapper mapper) {
    this.jpaRepo = jpaRepo;
    this.mapper = mapper;
  }

  @Override
  public Incidencia save(Incidencia task) {
    IncidenciaJpaEntity saved = jpaRepo.save(mapper.toJpa(task));
    return mapper.toDomain(saved);
  }

  @Override
  public List<Incidencia> findAll() {
    return jpaRepo.findAll().stream().map(mapper::toDomain).toList();
  }

  @Override
  public Optional<Incidencia> findById(Integer id) {
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
