package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.api.Libro;
import es.ejemplos.jpexposito.exceptions.LibroException;

/**
 * Unit test ClientLibroRest
 */
public class ClientLibroRestTest {

    private static final String ISBN1 = "isbn1";
    ClienteLibroRest clienteLibroRest;

    @BeforeEach
    public void setUp() {
        if (clienteLibroRest == null) {
            clienteLibroRest = new ClienteLibroRest();
        }
    }

    @Test
    public void obtenerLibroTest(){
        Libro libro = null;
        try {
            libro = clienteLibroRest.obtener(ISBN1);
        } catch (LibroException e) {
            fail("Se ha producido un error obteniendo el elemento");
        }
        assertNotNull(libro, "El libro obtenido es nulo");
        assertNotNull(libro.getTitulo(), "El titulo obtenido es nulo");

    }

    @Test
    public void obtenerTodosTest(){
        List<Libro> libros = null;
        try {
            libros = clienteLibroRest.obtener();
        } catch (LibroException e) {
            fail("Se ha producido un error obteniendo el elemento");
        }
        assertNotNull(libros, "El listado de libros es null");
        assertEquals(2,libros.size(), "El numero de elementos no es el esperado");

    }
}
