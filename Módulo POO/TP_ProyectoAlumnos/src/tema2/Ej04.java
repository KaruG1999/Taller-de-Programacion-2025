/*
 4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos de
casting.
Una vez finalizada la inscripción:
b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
persona a entrevistar en cada turno asignado.

 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;

public class Ej04 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // variables 
        GeneradorAleatorio.iniciar();
        String nomb;
        int dni;
        int edad;
        int dia;
        int cantIns = 0;
        // matriz de 5 dias por 8 personas 
        Persona [][] casting = new Persona [5][8];
        int i,j;
        // cargar matriz 
        nomb = GeneradorAleatorio.generarString(3);
        System.out.println("Nombre : "+  nomb);
        while ( !nomb.equals("ZZZ")  && cantIns != 40) {   // !nomb.equals("") mientras no sea ZZZ
            dni = GeneradorAleatorio.generarInt(999999);
            System.out.println("Nni generado: " + dni);
            edad = GeneradorAleatorio.generarInt(99);
            System.out.println("Edad generada: " + edad);
            dia = GeneradorAleatorio.generarInt(5);
            System.out.println("Dia elegido: "+ dia);  // agrego dia elegir 
            System.out.println("");
            // agrego persona a vector
            Persona persona = new Persona (nomb, dni, edad); //creo persona con constructor
            j=0;
            boolean inscripto = false;
            while (j<8 && !inscripto) {
                if (casting[dia][j] == null){  // si pongo "=" asigna, NO compara 
                    casting[dia][j] = persona;   // si hay espacio en el lugar agrego  
                    inscripto = true; 
                }
                j++;   
            }
            if (!inscripto) {
                System.out.println("No hay lugar el dia elegido");
            }
            //avanzo en matriz contando cant de inscriptos 
            cantIns++;
            // leo siguiente nombre 
            nomb = GeneradorAleatorio.generarString(3);
            System.out.println("Nombre : "+  nomb);
        }
        
        //imprimo 
        
        for (i=0; i<5; i++) {  // informo para cada dia el nombre de persona a entrevistar 
            cantIns=0;  // cada dia se pone en 0
            System.out.println("En el dia: " + i);
            for (j=0; j<8; j++) {
                if (casting[i][j] != null){   //  esta bien? tira error cuando intenta acceder a posicion sin persona 
                    System.out.println("En el turno: "+j+ "entrevistar a: "+ casting[i][j].getNombre());
                    cantIns++;  
                }  
            }
            System.out.println("Cantidad de inscriptos el dia "+ i + ":" + cantIns);
            
        } 
    }
    
}
