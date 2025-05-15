/*
 5A - 
i- se almacenan en un vector de figuras
ii - con un método agregar().
iii - si no uso polimorfismo y herencia tengo que agregar modificaciones a dibujo constantemente.

 */
package tema4;

public class MainDibujos {

    public static void main(String[] args) {
        
        Dibujo d = new Dibujo ("Un dibujo"); // instancia objeto dibujo
        // instancia figuras 
        Cuadrado c1 = new Cuadrado (10,"Violeta","Rosa");
        Rectangulo r = new Rectangulo (20,10, "Azul", "Celeste");
        Cuadrado c2 = new Cuadrado (30, "Rojo", "Naranja");
        // agrega figuras a objeto dibujo
        d.agregar (c1);
        d.agregar (r);
        d.agregar (c2);
        // informa
        d.mostrar();
        
        
    }
    
}
