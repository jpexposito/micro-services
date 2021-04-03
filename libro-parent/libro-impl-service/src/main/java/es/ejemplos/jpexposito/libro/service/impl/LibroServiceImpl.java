package es.ejemplos.jpexposito.libro.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import es.ejemplos.jpexposito.api.Libro;
import es.ejemplos.jpexposito.api.LibroServicio;

/**
 * Implementacion del servicio Libro
 */
public class LibroServiceImpl implements LibroServicio {

    private Map<String, Libro> libros = new HashMap<>();

    /**
     * Constructor por defecto
     */
    public LibroServiceImpl() {
        libros = new HashMap<>();
        Libro libro1 = new Libro("titulo1", "isbn1", 1);
        Libro libro2 = new Libro("titulo2", "isbn2", 2);
        libros.put("isbn1", libro1);
        libros.put("isbn2", libro2);
    }

    @Override
    public void add(Libro libro) {
        libros.put(libro.getIsbn(), libro);
    }

    @Override
    public Libro get(String isbn) {
        return libros.get(isbn);
    }

    @Override
    public Collection<Libro> list() {
        return libros.values();
    }

    @Override
    public void remove(String isbn) {
        libros.remove(isbn);
    }

    @Override
    public void update(Libro libro) {
        libros.remove(libro.getIsbn());
        libros.put(libro.getIsbn(), libro);
    }
    
}
