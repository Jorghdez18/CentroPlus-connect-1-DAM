package es.ies.puerto.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    public void getNombreTestOk() {

        Usuario u = new Usuario(1, "Alumno", "12345678A", "Juan", "666", "a@a.com");

        Assertions.assertEquals("Juan", u.getNombre());
    }

    @Test
    public void setNombreTestOk() {

        Usuario u = new Usuario(1, "Alumno", "12345678A", "Juan", "666", "a@a.com");

        u.setNombre("Pedro");

        Assertions.assertEquals("Pedro", u.getNombre());
    }

    @Test
    public void equalsTestOk() {

        Usuario u1 = new Usuario(1, "Alumno", "123", "Juan", "666", "a@a.com");
        Usuario u2 = new Usuario(1, "Alumno", "123", "Juan", "666", "a@a.com");

        Assertions.assertTrue(u1.equals(u2));
    }
}