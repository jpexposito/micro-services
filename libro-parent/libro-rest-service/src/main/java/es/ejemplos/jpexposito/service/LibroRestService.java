package es.ejemplos.jpexposito.service;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import es.ejemplos.jpexposito.api.Libro;
import es.ejemplos.jpexposito.libro.service.impl.LibroServiceImpl;

/**
 * Implementacion del servicio Libro en Rest
 */
@Path("/")
public class LibroRestService extends LibroServiceImpl {

    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<Libro> list() {
        return super.list();
    }

    @Override
    @Path("/{isbn}")
    @Produces("application/json")
    @GET
    public Libro get(@PathParam("isbn") String isbn) {
        return super.get(isbn);
    }
    
    @Override
    @Path("/")
    @Consumes("application/json")
    @POST
    public void add(Libro libro) {
        super.add(libro);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @PUT
    public void update(Libro libro) {
        super.update(libro);
    }

    @Override
    @Path("/{isbn}")
    @DELETE
    public void remove(@PathParam("isbn") String isbn) {
        super.remove(isbn);
    }


}
