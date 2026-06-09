package com.docencia.tasks.adapters.in.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.docencia.tasks.adapters.in.api.ActividadRequest;
import com.docencia.tasks.adapters.in.api.ActividadResponse;
import com.docencia.tasks.adapters.mapper.ActividadMapper;
import com.docencia.tasks.business.IActividadService;
import com.docencia.tasks.domain.model.Actividad;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actividades")
@Tag(name = "Actividades API")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class ActividadController {

    private final IActividadService service;
    private final ActividadMapper mapper;

    public ActividadController(IActividadService service, ActividadMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las actividades")
    public List<ActividadResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener actividad por id")
    public ResponseEntity<ActividadResponse> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear actividad")
    public ResponseEntity<ActividadResponse> create(@RequestBody ActividadRequest request) {

        Actividad created = service.create(mapper.toDomain(request));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(created));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar actividad")
    public ResponseEntity<ActividadResponse> update(
            @PathVariable Integer id,
            @RequestBody ActividadRequest request) {

        Actividad patch = mapper.toDomain(request);

        return service.update(id, patch)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar actividad")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        boolean deleted = service.delete(id);

        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}