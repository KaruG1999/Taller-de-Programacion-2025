/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;

public class Ej01Tabla2 {

    /**
     * Carga un vector que representa la tabla del 2
     * @param args
     */
    public static void main(String[] args) {
        int DF=11;  
        int [] tabla2 = new int[DF]; // indices de 0 a 10
        int i;
        for (i=0;i<DF;i++) 
            tabla2[i]=2*i;
        System.out.println("2x" + "5" + "="+ tabla2[5]);
        int num;
        
        do {
            num = GeneradorAleatorio.generarInt(12); // genera numeros del 0 al 10
            System.out.println("Numero generado: " + num );
            
            if (num >= 0 && num <=10) {   // si esta dentro del rango vector
                System.out.println("Numero multiplicado por 2: " + tabla2[num]); //multiplica
            } else{
                System.out.println("Numero fuera de rango vector"); //fuera de rango
            }
        } while (num != 11);  // mientras sea distinto de 11 continua
    }
    
}
