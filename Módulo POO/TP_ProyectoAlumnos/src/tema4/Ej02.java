
package tema4;
public class Ej02 {

    public static void main(String[] args) {
        // instanciar jugador y entrenador
        Jugador jug = new Jugador (14,20,"Juan",2000,5);
        Entrenador entr = new Entrenador (20,"Pedro",3000,8);
        
        // representacion de ambos
        System.out.println(jug.toString());
        System.out.println(entr.toString());
    }
    
}
