package es.ejemplos.jpexposito.api;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
/**
 * Entidad basica de la api
 */
@XmlRootElement
public class Libro implements Serializable {

   private static final long serialVersionUID =1L;

   String titulo;
   String isbn;
   int ejemplares;

   public Libro() {
      
   }

/**
 * Constructor de la clase libro
 * @param titulo del libro
 * @param isbn del libro
 * @param ejemplares del libro
 */
   public Libro(String titulo, String isbn, int ejemplares) {
      this.titulo = titulo;
      this.isbn = isbn;
      this.ejemplares = ejemplares;
   }

/**
 *    GETTERS AND SETTERS 
 */
   public String getTitulo() {
      return this.titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getIsbn() {
      return this.isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public int getEjemplares() {
      return this.ejemplares;
   }

   public void setEjemplares(int ejemplares) {
      this.ejemplares = ejemplares;
   }

   @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo) && Objects.equals(isbn, libro.isbn) && ejemplares == libro.ejemplares;
   }


   
}
