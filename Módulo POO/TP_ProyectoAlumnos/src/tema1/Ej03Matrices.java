/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej03Matrices {

    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio     
	GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int [][] matriz = new int [5][5];
        int i,j;
        for (i=0; i<5; i++) {
            for (j=0; j<5; j++) {
                matriz [i][j] = GeneradorAleatorio.generarInt(31); //inicial matriz con nums entre 0 y 30
            }
        }
        //Paso 4. mostrar el contenido de la matriz en consola
        for (i=0;i<5; i++){
            for (j=0; j<5; j++){
                System.out.print("|" + matriz[i][j]);
            }
            System.out.println("");
        }
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        int suma = 0;
        for (j=0; j<5; j++) {
            suma += matriz [0][j];  // la fila 1 seria la 0
        }
        System.out.println("suma  elementos fila uno: " + suma);
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        int [] vector = new int [5]; //genero vector 5 posiciones 
        //no hace falta declarar de nuevo suma 
        for (j=0; j<5; j++ ){  //recorro columna
            suma=0;
            for (i=0; i<5; i++){  //sumano el total de las filas en esa columna
                suma += matriz [i][j];
            }
            vector [j] = suma;
        }
        // imprimo vector generado 
        System.out.println("Suma de columnas:");
        for (j = 0; j < 5; j++) {
            System.out.println("Columna " + j + ": " + vector[j]);
        }

        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        int fila=-1, columna=-1;
        System.out.println("Ingrese numero entre 0 y 30: ");
        int num = Lector.leerInt();
        for (i=0; i<5; i++) {
            for (j=0; j<5; j++) {
                if (matriz[i][j] == num) {
                    fila = i;
                    columna = j;
                }
            }
        }
        if (fila != -1) {
            System.out.println("Elemento encontrado en fila: " + fila+ "columna: " + columna);
        } else{
            System.out.println("No se encontro elemento");
        }
    }
}
