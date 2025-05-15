/*
 3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
Strings use el método equals.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;

public class EJ03 {

    public static void main(String[] args) {
        // variables 
        GeneradorAleatorio.iniciar();
        String nomb;
        int dni;
        int edad;
        
        // matriz de 5 dias por 8 personas 
        Persona [][] casting = new Persona [5][8];
        int i=0, j=0;
        
        // cargar matriz 
        nomb = GeneradorAleatorio.generarString(3);
        System.out.println("Nombre : "+  nomb);
        while ( !nomb.equals("ZZZ")  && i<5 && j<8) {   // !nomb.equals("") mientras no sea ZZZ
            dni = GeneradorAleatorio.generarInt(999999);
            System.out.println("Nni generado: " + dni);
            edad = GeneradorAleatorio.generarInt(99);
            System.out.println("Edad generada: " + edad);
            System.out.println("");
            // agrego persona a vector
            Persona persona = new Persona (nomb, dni, edad); //creo persona con constructor
            casting[i][j] = persona; 
            
            //avanzo en matriz
            i++;
            j++;
            // leo nombre 
            nomb = GeneradorAleatorio.generarString(3);
            System.out.println("Nombre : "+  nomb);
        }
        
        for (i=0; i<5; i++) {  // informo para cada dia el nombre de persona a entrevistar 
            for (j=0; j<8; j++) {
                if (casting[i][j] != null){   //  esta bien? tira error cuando intenta acceder a posicion sin persona 
                    System.out.println("El dia: "+i+"en el turno: "+j+ "entrevistar a: "+ casting[i][j].getNombre());
                }
            }
            
        }
        
        
    }
    
}
