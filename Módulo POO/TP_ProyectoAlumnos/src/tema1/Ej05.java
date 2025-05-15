/*
 5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.
 */
package tema1;

import PaqueteLectura.Lector;

public class Ej05 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,j;
        int [][] matriz = new int [5][4]; // 5 clientes y 4 aspectos 
        
        for (i=0; i<5; i++) {
            for (j=0; j<4; j++) {
                System.out.println("Ingresar puntaje de cliente: " + i + " aspecto: " + j + ": ");
                matriz [i][j] = Lector.leerInt();
                
            }
        }
        
        // imprime calificacion promedio por cada aspecto
        // suma calificaciones de aspecto y divide por 5 (cant de calif)
        String[] aspectos = {"Atención al cliente", "Calidad de la comida", "Precio", "Ambiente"};

        for (j = 0; j < 4; j++) { 
            int suma = 0;
            for (i = 0; i < 5; i++) {
                suma += matriz[i][j];
            }
            double promedio = (double) suma / 5;
            System.out.println("Promedio de " + aspectos[j] + ": " + promedio);
        }
        
    }
    
}
