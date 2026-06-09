package es.ies.puerto.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IncidenciaServiceTest {

    @Test
    public void crearIncidenciaTestOk() {

        IncidenciaService service = new IncidenciaService();

        boolean result = service.crearIncidencia(
                1,
                1,
                "Wifi",
                "No funciona"
        );

        Assertions.assertTrue(result);
    }

    @Test
    public void crearIncidenciaTestAsuntoVacio() {

        IncidenciaService service = new IncidenciaService();

        boolean result = service.crearIncidencia(
                1,
                1,
                "",
                "No funciona"
        );

        Assertions.assertFalse(result);
    }

    @Test
    public void crearIncidenciaTestDescripcionVacia() {

        IncidenciaService service = new IncidenciaService();

        boolean result = service.crearIncidencia(
                1,
                1,
                "Wifi",
                ""
        );

        Assertions.assertFalse(result);
    }
}