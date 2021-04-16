package es.ejemplos.jpexposito.exceptiones;

public class LibroClienteSoapException  extends Exception{
 
   /**
    * Constructor de la clase
    * @param mensaje descriptivo
    */
   public LibroClienteSoapException (String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor de la clase
    * @param mensaje descriptivo
    * @param exception heredada
    */
   public LibroClienteSoapException (String mensaje, Exception exception) {
      super(mensaje, exception);
   }

}
