package es.ies.puerto.repositories;

import es.ies.puerto.models.Incidencia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IncidenciaRepositoryTest {

    @Test
    public void saveTestOk() {

        IncidenciaRepository repo = new IncidenciaRepository();

        Incidencia i = new Incidencia(1, 1, "Error", "Fallo");

        Assertions.assertTrue(repo.save(i));
    }

    @Test
    public void saveTestNull() {

        IncidenciaRepository repo = new IncidenciaRepository();

        Assertions.assertFalse(repo.save(null));
    }

    @Test
    public void findByIdTestOk() {

        IncidenciaRepository repo = new IncidenciaRepository();
        repo.save(new Incidencia(1, 1, "Error", "Fallo"));

        Assertions.assertNotNull(repo.findById(1));
    }

    @Test
    public void updateTestOk() {

        IncidenciaRepository repo = new IncidenciaRepository();

        repo.save(new Incidencia(1, 1, "Error", "Fallo"));

        Incidencia updated = new Incidencia(1, 1, "Bug", "Cambio");

        Assertions.assertTrue(repo.update(updated));
    }

    @Test
    public void deleteTestOk() {

        IncidenciaRepository repo = new IncidenciaRepository();

        repo.save(new Incidencia(1, 1, "Error", "Fallo"));

        Assertions.assertTrue(repo.delete(1));
    }
}