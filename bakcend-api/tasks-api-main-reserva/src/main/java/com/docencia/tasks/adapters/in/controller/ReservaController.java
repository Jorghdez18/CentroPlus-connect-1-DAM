package com.docencia.tasks.adapters.in.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.docencia.tasks.adapters.in.api.ReservaRequest;
import com.docencia.tasks.adapters.in.api.ReservaResponse;
import com.docencia.tasks.adapters.mapper.ReservaMapper;
import com.docencia.tasks.business.IReservaService;
import com.docencia.tasks.domain.model.Reserva;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
@Tag(name = "Reservas API")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class ReservaController {

    private final IReservaService service;
    private final ReservaMapper mapper;

    public ReservaController(IReservaService service, ReservaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las reservas")
    public List<ReservaResponse> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener reserva por id")
    public ResponseEntity<ReservaResponse> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear reserva")
    public ResponseEntity<ReservaResponse> create(@RequestBody ReservaRequest request) {

        Reserva created = service.create(
                mapper.toDomain(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponse(created));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar reserva")
    public ResponseEntity<ReservaResponse> update(
            @PathVariable Integer id,
            @RequestBody ReservaRequest request) {

        Reserva patch = new Reserva();

        patch.setIdUsuario(request.getIdUsuario());
        patch.setIdActividad(request.getIdActividad());
        patch.setFecha(request.getFecha());
        patch.setEstado(request.getEstado());

        return service.update(id, patch)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar reserva")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        boolean deleted = service.delete(id);

        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}