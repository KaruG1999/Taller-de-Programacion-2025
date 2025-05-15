/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recu2_6_12_24;

import PaqueteLectura.*;

public class ParcialRecu2 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        // instancio obras
        ConReserva obraR = new ConReserva("Obra con reserva", "Jose", GeneradorAleatorio.generarInt(30), 20);
        SinReserva obraS = new SinReserva(GeneradorAleatorio.generarInt(50), 5000, "Obra sin reserva", "Juan", 
                GeneradorAleatorio.generarInt(30), 30);
        
        // ocupo butacas Con reserva
        for (int i=0; i<10; i++) {
            obraR.ocuparButaca(i);
        }
        
        //repres
        System.out.println(obraR.toString());
        System.out.println(obraS.toString());
        
    }
    
}
