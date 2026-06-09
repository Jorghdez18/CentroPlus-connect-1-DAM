package com.docencia.tasks.adapters.mapper;

import org.mapstruct.*;

import com.docencia.tasks.adapters.in.api.ActividadRequest;
import com.docencia.tasks.adapters.in.api.ActividadResponse;
import com.docencia.tasks.adapters.out.persistence.ActividadJpaEntity;
import com.docencia.tasks.domain.model.Actividad;

@Mapper(componentModel = "spring")
public interface ActividadMapper {

  // API <-> Domain
  Actividad toDomain(ActividadRequest request);

  ActividadResponse toResponse(Actividad actividad);

  // Domain <-> JPA
  ActividadJpaEntity toJpa(Actividad actividad);

  Actividad toDomain(ActividadJpaEntity entity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateDomainFromRequest(ActividadRequest request, @MappingTarget Actividad actividad);
}
