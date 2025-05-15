/*
Esta bien planteado el agregarParticipante en ambas clases?
 */
package TurnoA_17_10_24;

import PaqueteLectura.*;

public class Tema1 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // instanciar ambas salas 
        Sala sala = new Sala (25698321, "zoom.com");
        Restringida salaRest = new Restringida (87951235, "zoom.com");
        
        // aprobar algunos participantes 
        for (int i=0; i<50; i++) {
            Participante part = new Participante (GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarString(10));
            sala.agregarPart(part);
            part.setContraIng(GeneradorAleatorio.generarInt(6));  // agrega al part la contraseña para ser añadido a sala restringida 
            salaRest.agregarPart(part);
        }
         
        // representacion
        System.out.println("Sala sin contraseña: " + sala.toString());
        System.out.println("Sala con contraseña: " + salaRest.toString());
        //reiniciar salas 
        sala.reiniciarSala();
        salaRest.reiniciarSala();
        
        // para verficar vuelvo a imprimir 
        System.out.println("Sala sin contraseña: " + sala.toString());
        System.out.println("Sala con contraseña: " + salaRest.toString());
        
        
    }
    
}
