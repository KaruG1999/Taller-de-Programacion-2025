/*
 4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). Realice un programa que permita informar la cantidad de personas que
concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
de piso 9. Al finalizar la llegada de personas, informe lo pedido.

 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;

public class Ej04 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int piso, oficina;
        int [][] matriz = new int [8][4]; // matriz guarda cant de personas por piso/ofic
        
        int i,j;
        for (i=0; i<8; i++) {   // inicializo matriz con elementos en 0
            for (j=0; j<4; j++) {
                matriz [i][j] = 0;
            }
        }
        
        piso = GeneradorAleatorio.generarInt(10);
        System.out.println("Ingresar numero de piso: " + piso);
        oficina = GeneradorAleatorio.generarInt(4); 
        System.out.println("Ingresar numero de oficina: " + oficina);
        
        while (piso != 9) {   //condicion corte es piso 9
            
            matriz[piso][oficina]++;  //sumo 1 persona en el piso y oficina indicado 
            
            piso = GeneradorAleatorio.generarInt(10);   //lee siguiente persona 
            System.out.println("Ingresar numero de piso: " + piso);
            oficina = GeneradorAleatorio.generarInt(4); 
            System.out.println("Ingresar numero de oficina: " + oficina);
        }
        
        // informa la cantidad de personas que concrrieron a cada oficina de cada piso 
        for (i=0; i<8; i++) {
            for (j=0; j<4; j++) {
                System.out.println("La cantidad de personas que ingresaron al piso: "+ i + " oficina: "+ j + " es: "+ matriz[i][j]);
            }
        }
        
    }
    
}

/**
Version si tengo en cuenta piso (1..8) y oficina (1..4)
    
    * 
        GeneradorAleatorio.iniciar();
        int piso, oficina;
        int [][] matriz = new int [8][4]; // matriz guarda cant de personas por piso/ofic

        // Simulación de llegada de personas
        piso = GeneradorAleatorio.generarInt(9) + 1; // valores entre 1 y 9
        oficina = GeneradorAleatorio.generarInt(4) + 1; // valores entre 1 y 4

        while (piso != 9) { // condición de corte: piso 9
            // Restamos 1 para ajustar a índice de matriz
            matriz[piso - 1][oficina - 1]++;
            
            piso = GeneradorAleatorio.generarInt(9) + 1; 
            if (piso != 9)
                oficina = GeneradorAleatorio.generarInt(4) + 1;
        }

        // Informe final
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("La cantidad de personas que ingresaron al piso: " + (i + 1) +
                                   ", oficina: " + (j + 1) + " es: " + matriz[i][j]);
            }
        }
    
     */