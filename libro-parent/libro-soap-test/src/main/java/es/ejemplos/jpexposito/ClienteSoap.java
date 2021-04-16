package es.ejemplos.jpexposito;

import java.net.MalformedURLException;
import java.net.URL;

import es.ejemplos.jpexposito.exceptiones.LibroClienteSoapException;
import es.ejemplos.jpexposito.soap.ws.client.LibroSoapServiceService;

public class ClienteSoap {

   String url = "http://localhost:8181/cxf/libroSoap?wsdl";

   public LibroSoapServiceService crearServicioLibro() throws LibroClienteSoapException {
      LibroSoapServiceService libroSoapService = null;

      URL wsdlLocation;
      try {
         if (libroSoapService == null) {
            wsdlLocation = new URL(url);
            libroSoapService = new LibroSoapServiceService(wsdlLocation);
         }
      } catch (MalformedURLException exception) {
         throw new LibroClienteSoapException("Se ha producido un error creando la instancia del cliente", exception);
      }
      
      return libroSoapService;
      
   }

}
