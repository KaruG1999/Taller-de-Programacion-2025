/*
Demo que crea objetos Libro invocando a los constructores definidos. 
 */
package tema3;

public class Demo01ConstructoresLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autor primerAutor = new Autor ("Herbert Schildt","biografia","Alemania"); // creo autor antes de crear libro
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014,primerAutor   
                                 , "978-0071809252", 21.72);
        Autor segundoAutor = new Autor ("John Horton", "biografia2", "Rusia");
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               segundoAutor, "978-1512108347");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        //Libro libro3= new Libro(); 
        // imprimo autor de libro1. Es valido?
        System.out.println("Autor libro 1: " + libro1.getPrimerAutor().toString());
        
    }
    
}
