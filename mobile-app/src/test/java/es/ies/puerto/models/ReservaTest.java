package es.ies.puerto.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ReservaTest {

    @Test
    public void constructorTestOk() {

        Reserva r = new Reserva(1, 1, 1, LocalDate.now(), "ACTIVA");

        Assertions.assertEquals(1, r.getId());
    }

    @Test
    public void getEstadoTestOk() {

        Reserva r = new Reserva(1, 1, 1, LocalDate.now(), "ACTIVA");

        Assertions.assertEquals("ACTIVA", r.getEstado());
    }

    @Test
    public void setEstadoTestOk() {

        Reserva r = new Reserva(1, 1, 1, LocalDate.now(), "ACTIVA");

        r.setEstado("CANCELADA");

        Assertions.assertEquals("CANCELADA", r.getEstado());
    }

    @Test
    public void toStringTestOk() {

        Reserva r = new Reserva(1, 1, 1, LocalDate.now(), "ACTIVA");

        Assertions.assertTrue(r.toString().contains("Reserva"));
    }
}