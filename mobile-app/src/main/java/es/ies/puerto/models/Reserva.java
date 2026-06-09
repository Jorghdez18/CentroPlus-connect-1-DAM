package es.ies.puerto.models;

import java.time.LocalDate;

public class Reserva {

    private int id;
    private int idUsuario;
    private int idActividad;
    private LocalDate fecha;
    private String estado;

    public Reserva(int id, int idUsuario, int idActividad, LocalDate fecha, String estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdActividad() {
        return idActividad;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Reserva " + id + " - Usuario " + idUsuario + " - Act " + idActividad;
    }
}