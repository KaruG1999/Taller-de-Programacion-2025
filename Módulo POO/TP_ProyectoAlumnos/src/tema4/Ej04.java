/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;
import PaqueteLectura.*;
public class Ej04 {

    public static void main(String[] args) {
       GeneradorAleatorio.iniciar();
        
       Estacion est1 = new Estacion("La Plata", -34.921, -57.955);
       Estacion est2 = new Estacion("Mar del Plata", -38.002, -57.556);
        
       SistAnios sistAnual = new SistAnios( est1, 2021, 3);
       SistMeses sistMensual = new SistMeses(est2,2020, 4);
        
       
       //settear temp en ambos sistemas 
       sistAnual.setTemp(1, 2021, 150);
       sistMensual.setTemp(5, 2022, 120);
       
       System.out.println(sistAnual);
       System.out.println(sistAnual.tempMax());
       
       System.out.println(sistMensual);
       System.out.println(sistMensual.tempMax());
    }
    
}
