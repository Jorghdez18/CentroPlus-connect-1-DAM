package es.ies.puerto.services;

import es.ies.puerto.models.Actividad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActividadServiceTest {

    @Test
    public void saveTestOk() {

        ActividadService service = new ActividadService();

        Actividad a = new Actividad(1, "Yoga", "Salud", 30, 3.0, 10);

        boolean result = service.save(a);

        Assertions.assertTrue(result);
    }

    @Test
    public void saveTestNull() {

        ActividadService service = new ActividadService();

        boolean result = service.save(null);

        Assertions.assertFalse(result);
    }

    @Test
    public void reservarPlazaTestOk() {

        ActividadService service = new ActividadService();

        service.save(new Actividad(1, "Yoga", "Salud", 30, 3.0, 10));

        boolean result = service.reservarPlaza(1);

        Assertions.assertTrue(result);
    }

    @Test
    public void reservarPlazaTestNotFound() {

        ActividadService service = new ActividadService();

        boolean result = service.reservarPlaza(999);

        Assertions.assertFalse(result);
    }

    @Test
    public void cancelarPlazaTestOk() {

        ActividadService service = new ActividadService();

        service.save(new Actividad(1, "Yoga", "Salud", 30, 3.0, 10));

        service.reservarPlaza(1);

        boolean result = service.cancelarPlaza(1);

        Assertions.assertTrue(result);
    }
}