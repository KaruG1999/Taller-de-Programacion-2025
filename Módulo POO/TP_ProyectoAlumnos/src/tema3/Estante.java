/*
Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
 */
package tema3;

public class Estante {
    
    private int cantMax = 20;
    private Libro [] estante; // estante vector
    private int cantLibros;

    // inicia el estante sin libros
    public Estante() {
        estante = new Libro[cantMax];
        cantLibros =0;
    }
    // si el estanteria tiene N lugares
    public Estante(int N) {
        cantLibros =0;  // inicializo dimension logica 
        cantMax = N;      // settea un vector de dimension fisica pasada como parametro
        estante = new Libro[cantMax]; 
    }
    
    // IMPORTANTE : NO generar get y set para vectores, matrices. NO generar set para dim log. 
    
    // metodo que devuelve la cant de libros almacenados (dim log)
    public int getCantLibros () {
        return cantLibros;
    }
    
    // devolver si el estante esta lleno
    public boolean estaLleno() {
        return (cantLibros == cantMax);
    }
    // agrega un libro al estante (reemplaza el set)
    public boolean agregarLibro (Libro libro) {
        if (cantLibros < cantMax) {
            estante[cantLibros] = libro;
            cantLibros++;                // agrego libro al vector y aumento dim log 
            return true;
        }
        return false;
    }   
    //devuelve libro de titulo ingresado
    public Libro buscaTitulo(String titulo) {
        for (int i=0; i<cantLibros; i++) {
            if (estante[i].getTitulo().equals("titulo")){
                return estante[i];  // retorna libro en sector i del estante
            }
        } // o estante[i].getTitulo().equalsIgnoreCase(titulo)?
        return null; //no se encontró libro 
    }
}
