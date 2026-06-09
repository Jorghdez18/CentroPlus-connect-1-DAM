package es.ies.puerto.models;

import java.time.LocalDate;

public class Incidencia {

    private int id;
    private int idUsuario;
    private String asunto;
    private String descripcion;
    private LocalDate fecha;
    private String estado;

    public Incidencia(int id, int idUsuario, String asunto, String descripcion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
        this.estado = "ABIERTA";
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public void cerrar() {
        this.estado = "CERRADA";
    }

    @Override
    public String toString() {
        return asunto + " - " + estado;
    }
}