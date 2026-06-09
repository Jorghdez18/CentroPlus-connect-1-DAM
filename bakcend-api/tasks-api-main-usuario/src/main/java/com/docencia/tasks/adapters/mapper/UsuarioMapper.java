package com.docencia.tasks.adapters.mapper;

import org.mapstruct.*;

import com.docencia.tasks.adapters.in.api.UsuarioRequest;
import com.docencia.tasks.adapters.in.api.UsuarioResponse;
import com.docencia.tasks.adapters.out.persistence.UsuarioJpaEntity;
import com.docencia.tasks.domain.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    // API <-> Domain
    Usuario toDomain(UsuarioRequest request);

    UsuarioResponse toResponse(Usuario usuario);

    // Domain <-> JPA
    UsuarioJpaEntity toJpa(Usuario usuario);

    Usuario toDomain(UsuarioJpaEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDomainFromRequest(UsuarioRequest request, @MappingTarget Usuario usuario);
}
