package es.ies.puerto.models;

public class Actividad {

    private int id;
    private String nombre;
    private String tipoActividad;
    private int duracionMinutos;
    private double precio;
    private int plazasMaximas;
    private int plazasOcupadas;

    public Actividad(int id, String nombre, String tipoActividad,
            int duracionMinutos, double precio, int plazasMaximas) {
        this.id = id;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.duracionMinutos = duracionMinutos;
        this.precio = precio;
        this.plazasMaximas = plazasMaximas;
        this.plazasOcupadas = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPlazasMaximas() {
        return plazasMaximas;
    }

    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public int getPlazasDisponibles() {
        return plazasMaximas - plazasOcupadas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPlazasMaximas(int plazasMaximas) {
        this.plazasMaximas = plazasMaximas;
    }

    public void setPlazasOcupadas(int plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public boolean tienePlazas() {
        return plazasOcupadas < plazasMaximas;
    }

    public void reservarPlaza() {
        if (tienePlazas()) {
            plazasOcupadas++;
        }
    }

    public void cancelarPlaza() {
        if (plazasOcupadas > 0) {
            plazasOcupadas--;
        }
    }

    @Override
    public String toString() {
        return "Actividad [id=" + id + ", nombre=" + nombre + ", tipoActividad=" + tipoActividad + ", duracionMinutos="
                + duracionMinutos + ", precio=" + precio + ", plazasMaximas=" + plazasMaximas + ", plazasOcupadas="
                + plazasOcupadas + "]";
    }

    
}