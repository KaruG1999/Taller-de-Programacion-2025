/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoE_8_10_24;

import PaqueteLectura.*;

public class ParcialE {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        String [] vMp = {"efectivo","debito","credito"};  // vector formas de pago
        // instancio supermercado
        Supermercado superM = new Supermercado("4 n1323"); // asigno direccion
        // instancio cajas 
        Caja caja1 = new Caja("Juan", 50);
        Caja caja2 = new Caja("Luisa",40);
        Caja caja3 = new Caja("Maria",30);  // asigno nombre Cajero/a y capacidad max de tickets
        //agrego cajas 
        superM.agregarCaja(caja1);
        superM.agregarCaja(caja2);
        superM.agregarCaja(caja3);
        //generar tickets para distintas cajas 
        for (int i=0; i<3; i++) {  // agrego 3 a cada caja 
            superM.generarTicket(i, GeneradorAleatorio.generarInt(333), GeneradorAleatorio.generarInt(10), 
                    GeneradorAleatorio.generarDouble(30000), vMp[GeneradorAleatorio.generarInt(3)] );
            superM.generarTicket(i, GeneradorAleatorio.generarInt(333), GeneradorAleatorio.generarInt(10), 
                    GeneradorAleatorio.generarDouble(30000), vMp[GeneradorAleatorio.generarInt(3)] );
            superM.generarTicket(i, GeneradorAleatorio.generarInt(333), GeneradorAleatorio.generarInt(10), 
                    GeneradorAleatorio.generarDouble(30000), vMp[GeneradorAleatorio.generarInt(3)] );
        }
        
        //comprobar metodos 
        
        System.out.println("Caja con menor cantidad de tickets: " + superM.cajaMin());
        
        System.out.println(superM.toString());
    }
    
}
