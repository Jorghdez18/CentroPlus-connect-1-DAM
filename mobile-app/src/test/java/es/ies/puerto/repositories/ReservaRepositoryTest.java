package es.ies.puerto.repositories;

import es.ies.puerto.models.Reserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ReservaRepositoryTest {

    @Test
    public void saveTestOk() {

        ReservaRepository repo = new ReservaRepository();

        Reserva r = new Reserva(1, 1, 1, LocalDate.now(), "ACTIVA");

        Assertions.assertTrue(repo.save(r));
    }

    @Test
    public void saveTestNull() {

        ReservaRepository repo = new ReservaRepository();

        Assertions.assertFalse(repo.save(null));
    }

    @Test
    public void findByIdTestNotFound() {

        ReservaRepository repo = new ReservaRepository();

        Assertions.assertNull(repo.findById(99));
    }

    @Test
    public void deleteTestOk() {

        ReservaRepository repo = new ReservaRepository();

        Reserva r = new Reserva(1, 1, 1, LocalDate.now(), "ACTIVA");

        repo.save(r);

        Assertions.assertTrue(repo.delete(1));
    }

    @Test
    public void deleteTestNotFound() {

        ReservaRepository repo = new ReservaRepository();

        Assertions.assertFalse(repo.delete(99));
    }
}