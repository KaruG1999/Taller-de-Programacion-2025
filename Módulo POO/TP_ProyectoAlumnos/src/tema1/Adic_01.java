/*
 1- a) Simular la entrada de autos al estacionamiento municipal en el centro de la ciudad.
El estacionamiento está dividido en 5 pisos y cada piso tiene 10 plazas.
Realice un programa que genere aleatoriamente números (patentes) hasta el 0. Por cada
patente generada, debe leer por teclado el número de piso y número de plaza donde
debe estacionar el auto, debiendo marcar ese lugar como ocupado en una estructura de
datos adecuada.
Nota: Al principio todas las plazas del estacionamiento deben marcarse desocupadas.
Además, durante la lectura, puede considerar que el lugar leído (número de piso,
número de plaza) está desocupado y que dichos números son válidos.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Adic_01 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // matriz de 5 pisos x 10 plazas 
        int dFil= 5, dCol = 10;  //dim fisica de matriz 
        int [][] estacionamiento = new int [dFil][dCol];
        int pat, piso, plaza;
        
        // marcar estacionamiento vacio
        int i,j;
        for (i=0; i<dFil; i++) {
            for (j=0; j<dCol; j++) {
                estacionamiento[i][j] = 0;
            }
        }
        
        // cargar estacionamiento 
        pat = GeneradorAleatorio.generarInt(999999);
        System.out.println("Patente generada: " + pat);
        while (pat != 0) {
            piso = Lector.leerInt();
            plaza = Lector.leerInt();
            System.out.println("Piso: " + piso + "plaza: " + plaza);
            
            if (estacionamiento[piso][plaza] == 0) {  //si esta vacio el lugar
                estacionamiento[piso][plaza] = pat;
            } else {
                System.out.println("Lugar Ocupado");
            }
            
            // leo siguiente auto
            pat = GeneradorAleatorio.generarInt(999999);
            System.out.println("Patente generada: " + pat);
        }
    }
    
}
