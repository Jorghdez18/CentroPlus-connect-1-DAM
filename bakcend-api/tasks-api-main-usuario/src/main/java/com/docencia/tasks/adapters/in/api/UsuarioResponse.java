package com.docencia.tasks.adapters.in.api;

public class UsuarioResponse {
  private Integer id;
  private String nombre;
  private String email;
  private String telefono;
  private String dni;
  private String tipoUsuario;

  public UsuarioResponse() {
  }

  public UsuarioResponse(Integer id, String nombre, String email, String telefono, String dni, String tipoUsuario ) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.telefono = telefono;
    this.dni = dni;
    this.tipoUsuario = tipoUsuario;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getTipoUsuario() {
    return tipoUsuario;
  }

  public void setTipoUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }

}
