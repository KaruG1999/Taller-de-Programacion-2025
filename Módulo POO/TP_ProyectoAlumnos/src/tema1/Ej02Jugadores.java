
package tema1;
//Paso 1: Importar la funcionalidad para lectura de datos
import PaqueteLectura.GeneradorAleatorio;

public class Ej02Jugadores {
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        int df = 15;    // dimf de vector 
        //Paso 3: Crear el vector para 15 double (entre 0 y 14)
        int [] vector = new int [df];  
        //Paso 4: Declarar indice y variables auxiliares a usar
        int i;
        int suma = 0;
        int cantM = 0;
        GeneradorAleatorio.iniciar();   // inicia el generador aleatorio
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for (i=0; i<df; i++) {
            vector[i] = 140 + GeneradorAleatorio.generarInt(70); // altura 1.40mts y 2.10mts
            suma += vector[i];                //suma total de alturas 
        }   
        
        System.out.println("Alturas generadas:");
        for (i = 0; i < df; i++) {
            System.out.println(vector[i]);
        }

        //Paso 7: Calcular el promedio de alturas, informarlo
        double promedio = suma/ df;
        System.out.println("Promedio de alturas: " + promedio);
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        for (i=0; i<df; i++) {
            if (vector[i] > promedio)
                cantM++;   // si la altura es mayor al promedio suma 1
        }
        //Paso 9: Informar la cantidad.
        System.out.println("Cantidad de alturas por encima del promedio: " + cantM);
    }
    
}
