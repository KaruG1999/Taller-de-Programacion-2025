/*
 3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”.
C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
almacenen como máximo N libros? ¿Cómo instanciaría el estante?
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;

public class Ej03 {
    
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // creo clase estante
        Estante estante = new Estante(); 
        
        // cargo 6 libros ej
        for (int i=0; i<6; i++) {
            Autor autor = new Autor (GeneradorAleatorio.generarString(10), GeneradorAleatorio.generarString(10),
                    GeneradorAleatorio.generarString(10));
            Libro libro = new Libro (GeneradorAleatorio.generarString(10), GeneradorAleatorio.generarString(10),
            autor, GeneradorAleatorio.generarString(5));
            // puedo settear titulo mujercitas para que devuelva true (No funciona)
            if (i == 3) {
                libro.setTitulo("mujercitas");
            }
            // agrego libro a estanteria
            estante.agregarLibro(libro);
            
        }
        
        // busco y devuelvo autor del titulo "mujercitas"
        if (estante.buscaTitulo("mujercitas") != null) {
            System.out.println(estante.buscaTitulo("mujercitas").getPrimerAutor().getNombre());
        } else{
            System.out.println("No se encontro libro");
        }
        
    }
    
}
