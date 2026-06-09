package com.docencia.tasks.adapters.in.api;

public class ReservaResponse {
  private Integer id;
  private Integer idUsuario;
  private Integer idActividad;
  private String fecha;
  private String estado;

  public ReservaResponse() {}

  public ReservaResponse(Integer id, Integer idUsuario, Integer idActividad, String fecha, String estado ) {
    this.id = id;
    this.idUsuario = idUsuario;
    this.idActividad = idActividad;
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

  public Integer getIdActividad() {
    return idActividad;
  }

  public void setIdActividad(Integer idActividad) {
    this.idActividad = idActividad;
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
