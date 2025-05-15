/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoM_16_10_24;

import PaqueteLectura.*;

public class Parcial {
    
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // instanciar minibuses 
        Minibus mini1 = new Minibus (GeneradorAleatorio.generarInt(20));
        mini1.setPatente("AB123CD");
        Minibus mini2 = new Minibus (GeneradorAleatorio.generarInt(28));
        mini2.setPatente("AB456CD");
        // instanciar viaje 
        Viaje viaje = new Viaje (mini1, mini2, "Yapeyu", "La Plata", "25/10/2024");
        // crea alumnos y los agrega al viaje
        for (int i=0; i<10; i++) {
            Alumno alu = new Alumno (GeneradorAleatorio.generarInt(9999999), GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarString(10), GeneradorAleatorio.generarString(5));
            mini1.agregarAlu(alu);
        }
        for (int i=0; i<10; i++) {
            Alumno alu = new Alumno (GeneradorAleatorio.generarInt(9999999), GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarString(10), GeneradorAleatorio.generarString(5));
            mini2.agregarAlu(alu);
        }
        
        
        //modifica poliza
        System.out.println("Ingresa un dni al cual modificar poliza y poliza: ");
        int dni = Lector.leerInt();
        int nPol = Lector.leerInt();
        viaje.asignaPoliza(dni, nPol);
        
        // imprimir representacion
        System.out.println(viaje.toString());
        
        
        
        
        
    }
    
}
