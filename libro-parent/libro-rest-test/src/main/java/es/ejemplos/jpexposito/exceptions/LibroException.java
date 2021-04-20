package es.ejemplos.jpexposito.exceptions;

public class LibroException extends Exception{

   /**
    * Constructor de la exception
    * @param mensaje descriptivo
    */
   public LibroException(String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor de la exception
    * @param mensaje descriptivo
    * @param exception heredada
    */
   public LibroException(String mensaje, Exception exception) {
      super(mensaje, exception);
   }
   
}
