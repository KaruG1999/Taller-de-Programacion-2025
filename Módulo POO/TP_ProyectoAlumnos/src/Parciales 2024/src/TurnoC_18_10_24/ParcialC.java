
package TurnoC_18_10_24;

import PaqueteLectura.*;

public class ParcialC {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        String [] tipoCont = {"pelicula","serie"};
        // intancio plataforma 
        Plataforma plat = new Plataforma("Netflix", GeneradorAleatorio.generarInt(100), 20);
        
        // registro estrenos
        for (int i=0; i<30; i++) {
            Estreno est = new Estreno("titulo x", tipoCont[GeneradorAleatorio.generarInt(2)], GeneradorAleatorio.generarDouble(50000), 
            GeneradorAleatorio.generarInt(500));
            plat.agregarEstreno(est, GeneradorAleatorio.generarInt(20));
        }
        
        // implementar metodos  
        System.out.println(plat.listarEst(GeneradorAleatorio.generarInt(20)));
        
        System.out.println(plat.toString());
        
        
    }
    
}
