package com.docencia.tasks.domain.model;

public class Incidencia {
  private Integer id;
  private Integer idUsuario;
  private String asunto;
  private String descripcion;
  private String fecha;
  private String estado;

  public Incidencia() {}

  public Incidencia(Integer id, Integer idUsuario, String asunto, String descripcion,  String fecha, String estado ) {
    this.id = id;
    this.idUsuario = idUsuario;
    this.asunto = asunto;
    this.descripcion = descripcion;
    this.fecha = fecha;
    this.estado = estado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getAsunto() {
    return asunto;
  }

  public void setAsunto(String asunto) {
    this.asunto = asunto;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
  
}
