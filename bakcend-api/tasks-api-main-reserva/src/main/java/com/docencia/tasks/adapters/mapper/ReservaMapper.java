package com.docencia.tasks.adapters.mapper;

import org.mapstruct.*;

import com.docencia.tasks.adapters.in.api.ReservaRequest;
import com.docencia.tasks.adapters.in.api.ReservaResponse;
import com.docencia.tasks.adapters.out.persistence.ReservaJpaEntity;
import com.docencia.tasks.domain.model.Reserva;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    // API <-> Domain
    Reserva toDomain(ReservaRequest request);

    ReservaResponse toResponse(Reserva reserva);

    // Domain <-> JPA
    ReservaJpaEntity toJpa(Reserva reserva);

    Reserva toDomain(ReservaJpaEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDomainFromRequest(ReservaRequest request, @MappingTarget Reserva reserva);
}
