package es.ies.puerto.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IncidenciaTest {

    @Test
    public void constructorTestOk() {

        Incidencia i = new Incidencia(1, 1, "Wifi", "No funciona");

        Assertions.assertEquals(1, i.getId());
    }

    @Test
    public void getAsuntoTestOk() {

        Incidencia i = new Incidencia(1, 1, "Pantalla", "Rota");

        Assertions.assertEquals("Pantalla", i.getAsunto());
    }

    @Test
    public void cerrarTestOk() {

        Incidencia i = new Incidencia(1, 1, "Wifi", "No funciona");

        i.cerrar();

        Assertions.assertEquals("CERRADA", i.getEstado());
    }

    @Test
    public void setDescripcionTestOk() {

        Incidencia i = new Incidencia(1, 1, "Wifi", "Error");

        i.setDescripcion("Arreglado");

        Assertions.assertEquals("Arreglado", i.getDescripcion());
    }

    @Test
    public void toStringTestOk() {

        Incidencia i = new Incidencia(1, 1, "Wifi", "Error");

        Assertions.assertTrue(i.toString().contains("Wifi"));
    }
}