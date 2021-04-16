package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.exceptiones.LibroClienteSoapException;
import es.ejemplos.jpexposito.soap.ws.client.Libro;
import es.ejemplos.jpexposito.soap.ws.client.LibroSoapService;

public class ClienteSoapTest {
    private static final String ISBN1 = "isbn1";
    private static final String ISBN3 = "isbn3";
    ClienteSoap clienteSoap;
    LibroSoapService libroSoapService;
    Libro libro;
    
    @BeforeEach
    public void setUp() {
        if (clienteSoap == null) {
            clienteSoap = new ClienteSoap();
            try {
                libroSoapService = clienteSoap.crearServicioLibro().getLibroSoapServicePort();
                libro = crearLibro();
                libroSoapService.add(libro);
            } catch (LibroClienteSoapException e) {
                fail("Se ha producido un error creando el cliente del servicio");
            }
        }
    } 

    @Test
    public void obtenerLibrosTest() {
        List<Libro> lista;
        try {
            lista = libroSoapService.list();
            assertEquals(3,lista.size(), "El tamanio de la lista no es el esperado");
        } catch (Exception e) {
            fail("Se ha producido un error no esperado obteniendo la lista de libros:" +e.getMessage());
        }
    }

    @Test
    public void obtenerLibroTest() {
        try {
            Libro libroEncontrado = libroSoapService.get(ISBN1);
            assertNotNull(libroEncontrado, "El libro obtenido es nullo");
        } catch (Exception e) {
            fail("Se ha producido un error no esperado eliminando un libro:" +e.getMessage());
        }
    }

    @Test
    public void actualizarLibroTest() {
        try {
            Libro libroActualizar = libroSoapService.get(ISBN1);
            libroActualizar.setTitulo("Titulo Actualizado");
            libroSoapService.update(libroActualizar);
            Libro libroActualizado = libroSoapService.get(ISBN1);
            assertEquals("Titulo Actualizado", libroActualizado.getTitulo(), "El libro no se ha actualizado correctamente");
        } catch (Exception e) {
            fail("Se ha producido un error no esperado eliminando un libro:" +e.getMessage());
        }
    }

    @Test
    public void eliminaribroTest() {
        try {
            libroSoapService.remove(ISBN3);
            Libro libroEncontrado = libroSoapService.get(ISBN3);;
            assertNull(libroEncontrado, "El libro obtenido debe ser nullo");
        } catch (Exception e) {
            fail("Se ha producido un error no esperado eliminando un libro:" +e.getMessage());
        }
    }

    /**
     * Crea un elemento de tipo libro
     * @return
     */
    private Libro crearLibro() {
        Libro libro = null;

        libro = new Libro();
        libro.setTitulo("Titulo del libro");
        libro.setEjemplares(3);
        libro.setIsbn(ISBN3);

        return libro;
    }
}
