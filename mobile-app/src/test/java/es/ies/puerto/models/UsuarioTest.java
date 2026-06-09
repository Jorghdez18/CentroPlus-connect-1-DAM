package es.ies.puerto.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void constructorTestOk() {

        Usuario u = new Usuario(1, "Alumno", "12345678A", "Juan", "666", "a@a.com");

        Assertions.assertEquals(1, u.getId());
    }

    @Test
    public void getTipoUsuarioTestOk() {

        Usuario u = new Usuario(1, "Profesor", "123", "Ana", "666", "a@a.com");

        Assertions.assertEquals("Profesor", u.getTipoUsuario());
    }

    @Test
    public void setTipoUsuarioTestOk() {

        Usuario u = new Usuario(1, "Alumno", "123", "Ana", "666", "a@a.com");

        u.setTipoUsuario("Profesor");

        Assertions.assertEquals("Profesor", u.getTipoUsuario());
    }

    @Test
    public void hashCodeTestOk() {

        Usuario u = new Usuario(1, "Alumno", "123", "Ana", "666", "a@a.com");

        Assertions.assertNotNull(u.hashCode());
    }
}