package es.ejemplos.jpexposito;

import es.ejemplos.jpexposito.api.Libro;
import es.ejemplos.jpexposito.libro.service.impl.LibroServiceImpl;

import java.util.Collection;

/**
 * Implementacion del servico Libro en Soap
 */
import javax.jws.WebService;

@WebService(endpointInterface="es.ejemplos.jpexposito.LibroSoapService", serviceName="Libro")
public class LibroSoapServiceImp extends LibroServiceImpl implements LibroSoapService {
   public Collection<Libro> list() {
      return super.list();
  }

  @Override
  public Libro get(String isbn) {
      return super.get(isbn);
  }
  
  @Override
  public void add(Libro libro) {
      super.add(libro);
  }

  @Override
  public void update(Libro libro) {
      super.update(libro);
  }

  @Override
  public void remove(String isbn) {
      super.remove(isbn);
  }

}
