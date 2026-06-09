package es.ies.puerto.repositories;

import es.ies.puerto.models.Actividad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActividadRepositoryTest {

    @Test
    public void saveTestOk() {

        ActividadRepository repo = new ActividadRepository();

        Actividad a = new Actividad(1, "Yoga", "Deporte", 60, 10.0, 10);

        Assertions.assertTrue(repo.save(a));
    }

    @Test
    public void saveTestNull() {

        ActividadRepository repo = new ActividadRepository();

        Assertions.assertFalse(repo.save(null));
    }

    @Test
    public void findByIdTestOk() {

        ActividadRepository repo = new ActividadRepository();
        repo.save(new Actividad(1, "Yoga", "Deporte", 60, 10.0, 10));

        Assertions.assertNotNull(repo.findById(1));
    }

    @Test
    public void findByIdTestNotFound() {

        ActividadRepository repo = new ActividadRepository();

        Assertions.assertNull(repo.findById(99));
    }

    @Test
    public void updateTestOk() {

        ActividadRepository repo = new ActividadRepository();

        repo.save(new Actividad(1, "Yoga", "Deporte", 60, 10.0, 10));

        Actividad updated = new Actividad(1, "Pilates", "Deporte", 60, 10.0, 10);

        Assertions.assertTrue(repo.update(updated));
    }

    @Test
    public void updateTestNotFound() {

        ActividadRepository repo = new ActividadRepository();

        Actividad a = new Actividad(99, "X", "X", 10, 1, 1);

        Assertions.assertFalse(repo.update(a));
    }

    @Test
    public void deleteTestOk() {

        ActividadRepository repo = new ActividadRepository();

        repo.save(new Actividad(1, "Yoga", "Deporte", 60, 10.0, 10));

        Assertions.assertTrue(repo.delete(1));
    }

    @Test
    public void deleteTestNotFound() {

        ActividadRepository repo = new ActividadRepository();

        Assertions.assertFalse(repo.delete(99));
    }
}