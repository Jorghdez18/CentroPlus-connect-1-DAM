package com.docencia.tasks.adapters.in.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.docencia.tasks.adapters.in.api.UsuarioRequest;
import com.docencia.tasks.adapters.in.api.UsuarioResponse;
import com.docencia.tasks.adapters.mapper.UsuarioMapper;
import com.docencia.tasks.business.IUsuarioService;
import com.docencia.tasks.business.IUsuarioService;
import com.docencia.tasks.domain.model.Usuario;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "Tasks API")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class UsuarioController {

  private final IUsuarioService service;
  private final UsuarioMapper mapper;

  public UsuarioController(IUsuarioService service, UsuarioMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  @Operation(summary = "Get all tasks")
  public List<UsuarioResponse> getAll() {
    return service.getAll().stream().map(mapper::toResponse).toList();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get task by id")
  public ResponseEntity<UsuarioResponse> getById(@PathVariable Integer id) {
    return service.getById(id)
        .map(mapper::toResponse)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  @Operation(summary = "Create task")
  public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioRequest request) {
    Usuario created = service.create(mapper.toDomain(request));
    return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(created));
  }

  @PatchMapping("/{id}")
  @Operation(summary = "Update task (partial)")
  public ResponseEntity<UsuarioResponse> update(@PathVariable Integer id, @RequestBody UsuarioRequest request) {
    // convert request -> domain patch: completed may be null; title/desc may be null
    Usuario patch = new Usuario();
    patch.setId(request.getId());
    patch.setNombre(request.getNombre());
    patch.setEmail(request.getEmail());
    patch.setTelefono(request.getTelefono());
    patch.setDni(request.getDni());
    patch.setTipoUsuario(request.getTipoUsuario());
    

    return service.update(id, patch)
        .map(mapper::toResponse)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete task")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    boolean deleted = service.delete(id);
    return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
  }
}
