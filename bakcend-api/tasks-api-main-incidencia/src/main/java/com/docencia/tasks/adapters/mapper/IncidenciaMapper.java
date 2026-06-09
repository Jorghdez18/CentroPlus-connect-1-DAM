package com.docencia.tasks.adapters.mapper;

import org.mapstruct.*;

import com.docencia.tasks.adapters.in.api.IncidenciaRequest;
import com.docencia.tasks.adapters.in.api.IncidenciaResponse;
import com.docencia.tasks.adapters.out.persistence.IncidenciaJpaEntity;
import com.docencia.tasks.domain.model.Incidencia;

@Mapper(componentModel = "spring")
public interface IncidenciaMapper {

    // API <-> Domain
    Incidencia toDomain(IncidenciaRequest request);

    IncidenciaResponse toResponse(Incidencia incidencia);

    // Domain <-> JPA
    IncidenciaJpaEntity toJpa(Incidencia incidencia);

    Incidencia toDomain(IncidenciaJpaEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDomainFromRequest(IncidenciaRequest request, @MappingTarget Incidencia incidencia);
}
