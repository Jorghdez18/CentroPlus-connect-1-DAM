package es.ies.puerto.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActividadTest {

    @Test
    public void constructorTestOk() {

        Actividad a = new Actividad(1, "Yoga", "Salud", 30, 3.0, 2);

        Assertions.assertEquals(1, a.getId());
    }

    @Test
    public void plazasDisponiblesTestOk() {

        Actividad a = new Actividad(1, "Yoga", "Salud", 30, 3.0, 10);

        Assertions.assertEquals(10, a.getPlazasDisponibles());
    }

    @Test
    public void reservarPlazaTestOk() {

        Actividad a = new Actividad(1, "Yoga", "Salud", 30, 3.0, 2);

        a.reservarPlaza();

        Assertions.assertEquals(1, a.getPlazasOcupadas());
    }

    @Test
    public void cancelarPlazaTestOk() {

        Actividad a = new Actividad(1, "Yoga", "Salud", 30, 3.0, 2);

        a.reservarPlaza();
        a.cancelarPlaza();

        Assertions.assertEquals(0, a.getPlazasOcupadas());
    }

    @Test
    public void tienePlazasTestOk() {

        Actividad a = new Actividad(1, "Yoga", "Salud", 30, 3.0, 1);

        Assertions.assertTrue(a.tienePlazas());
    }

    @Test
    public void toStringTestOk() {

        Actividad a = new Actividad(1, "Yoga", "Salud", 30, 3.0, 2);

        Assertions.assertTrue(a.toString().contains("Yoga"));
    }
}