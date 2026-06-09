package es.ies.puerto.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservaServiceTest {

    @Test
    public void crearReservaTestOk() {

        ReservaService service = new ReservaService();

        boolean result = service.crearReserva(1, 1, 1);

        Assertions.assertTrue(result);
    }

    @Test
    public void crearReservaTestDuplicada() {

        ReservaService service = new ReservaService();

        service.crearReserva(1, 1, 1);

        boolean result = service.crearReserva(2, 1, 1);

        Assertions.assertFalse(result);
    }

    @Test
    public void cancelarReservaTestOk() {

        ReservaService service = new ReservaService();

        service.crearReserva(1, 1, 1);

        boolean result = service.cancelarReserva(1);

        Assertions.assertTrue(result);
    }

    @Test
    public void cancelarReservaTestNotFound() {

        ReservaService service = new ReservaService();

        boolean result = service.cancelarReserva(999);

        Assertions.assertFalse(result);
    }
}