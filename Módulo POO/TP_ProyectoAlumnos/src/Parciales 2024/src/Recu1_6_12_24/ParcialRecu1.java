/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recu1_6_12_24;

import PaqueteLectura.*;

public class ParcialRecu1 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        String [] vOrigen = {"San vicente", "Brandsen","Lanus", "Burzaco"};
        String [] vNombT = {"Juan","Pedro","Miguel","Pablo"};
        // instanciar torneo de futbol y torneo de tenis
        Tenis torneoT = new Tenis(GeneradorAleatorio.generarInt(10), "sintetico", "Torneo Tenis", "28/06", GeneradorAleatorio.generarDouble(5000),
                GeneradorAleatorio.generarDouble(100000));
        int df = GeneradorAleatorio.generarInt(20);
        Futbol torneoF = new Futbol(df, "Torneo Futbol", "11/11", GeneradorAleatorio.generarDouble(10000), 
                GeneradorAleatorio.generarDouble(150000));
                       
        // agrego equipos a torneo futbol
        for (int i=0; i<df; i++) {
            Equipo eq = new Equipo(GeneradorAleatorio.generarString(10), vOrigen[GeneradorAleatorio.generarInt(4)], 
                vNombT[GeneradorAleatorio.generarInt(4)]);
            torneoF.agregarEquipo(eq);
        }
        
        // representacion de cada uno
        System.out.println("Torneo tenis: " + torneoT.toString());
        System.out.println("Torneo futbol: " + torneoF.toString());
        
    }
    
}
