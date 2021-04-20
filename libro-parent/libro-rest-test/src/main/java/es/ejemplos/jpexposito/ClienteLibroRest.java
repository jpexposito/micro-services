package es.ejemplos.jpexposito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import es.ejemplos.jpexposito.api.Libro;
import es.ejemplos.jpexposito.exceptions.LibroException;

/**
 * Cliente del servicio Rest Libro
 */

public class ClienteLibroRest {

   Client client;
   String url;
   ObjectMapper objectMapper;
   
   public ClienteLibroRest() {
      client = ClientBuilder.newClient();
      client.register(new JacksonJsonProvider());
      objectMapper = new ObjectMapper();
      //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      //objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
      //objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);


     url = "http://localhost:8181/cxf/libroRest/";
   }

   /**
    * Funcion encargada de obtener un libro
    * @param isbn del libro a obtener
    * @return Objeto de tipo libro
    * @throws LibroException
    */
   public Libro obtener(String isbn) throws LibroException {
      Libro libro = null;
      
      String json = client
      .target(url+isbn)
      .request(MediaType.APPLICATION_JSON).get(String.class);
      try {
         libro = objectMapper.readValue(json, Libro.class);
      } catch (IOException exception) {
         throw new LibroException ("Se ha producido realizando la transformacion al objeto", exception);
      }
      return libro;
   }

   public List<Libro> obtener() throws LibroException {
      List<Libro> libros = null;

      String json = client
      .target(url)
      .request(MediaType.APPLICATION_JSON).get(String.class);

      try {
         libros = objectMapper.readValue(json, new TypeReference<List<Libro>>(){});
      } catch (IOException exception) {
         throw new LibroException ("Se ha producido realizando la transformacion al objeto", exception);
      }
      return libros;
   }

}
