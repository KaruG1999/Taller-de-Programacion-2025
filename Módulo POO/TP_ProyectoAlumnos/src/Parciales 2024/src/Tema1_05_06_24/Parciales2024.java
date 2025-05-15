/*

 */
package Tema1_05_06_24;

import PaqueteLectura.*;

public class Parciales2024 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // instancio curso
        Curso curso = new Curso("Inglés intermedio para jovenes y adultos");
        
        // agregar alumnos Presencial
        for (int i=0; i<6; i++) {
            Alumno alu = new Alumno(GeneradorAleatorio.generarInt(99999999), GeneradorAleatorio.generarString(5), "La Plata" );
            curso.agregarAlu(alu);
        }
        // agregar alumnos online 
        for (int i=0; i<6; i++) {
            Alumno alu = new Alumno(GeneradorAleatorio.generarInt(99999999), GeneradorAleatorio.generarString(5), "Neuquen" );
            curso.agregarAlu(alu);
        }
        
        // representacion 
        System.out.println(curso.toString());
        
        // imprimir si es rentable 
        if (curso.esRentable()) {
            System.out.println("El curso es rentable");
        } else {
            System.out.println("El curso no es rentable");
        }
        
        
    }
    
}
