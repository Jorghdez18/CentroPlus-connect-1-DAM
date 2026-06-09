package com.docencia.tasks.adapters.in.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.docencia.tasks.adapters.in.api.IncidenciaRequest;
import com.docencia.tasks.adapters.in.api.IncidenciaResponse;
import com.docencia.tasks.adapters.mapper.IncidenciaMapper;
import com.docencia.tasks.business.IIncidenciaService;
import com.docencia.tasks.domain.model.Incidencia;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incidencias")
@Tag(name = "Incidencias API")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class IncidenciaController {

    private final IIncidenciaService service;
    private final IncidenciaMapper mapper;

    public IncidenciaController(IIncidenciaService service, IncidenciaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las incidencias")
    public List<IncidenciaResponse> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener incidencia por id")
    public ResponseEntity<IncidenciaResponse> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear incidencia")
    public ResponseEntity<IncidenciaResponse> create(@RequestBody IncidenciaRequest request) {

        Incidencia created = service.create(
                mapper.toDomain(request));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(created));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar incidencia")
    public ResponseEntity<IncidenciaResponse> update(
            @PathVariable Integer id,
            @RequestBody IncidenciaRequest request) {

        Incidencia patch = new Incidencia();

        patch.setIdUsuario(request.getIdUsuario());
        patch.setAsunto(request.getAsunto());
        patch.setDescripcion(request.getDescripcion());
        patch.setFecha(request.getFecha());
        patch.setEstado(request.getEstado());

        return service.update(id, patch)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar incidencia")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        boolean deleted = service.delete(id);

        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}