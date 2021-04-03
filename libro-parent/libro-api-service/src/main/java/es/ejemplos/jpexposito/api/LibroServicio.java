package es.ejemplos.jpexposito.api;

import java.util.Collection;

public interface LibroServicio {
   Collection<Libro> list();

    Libro get(String isbn);

    void add(Libro libro);
    
    void update(Libro libro);
    
    void remove(String isbn);
}
