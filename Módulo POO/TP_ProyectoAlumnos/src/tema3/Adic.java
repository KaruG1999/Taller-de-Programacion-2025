/*
Una escuela de música necesita un sistema para realizar un concurso entre sus alumnos. El
concurso está dividido en cinco géneros musicales y en cada género se pueden inscribir hasta N
alumnos como máximo. De cada alumno registra su nombre, edad, el instrumento que toca y
puntaje obtenido.
1- Genere las clases necesarias. Implemente constructores para iniciar el concurso sin alumnos
inscriptos, recibiendo N (el máximo de alumnos por género musical). Los alumnos deben
instanciarse dando valor a todos sus atributos.
2- Implemente métodos en las clases que corresponda para permitir:
a. Dado un alumno y un género musical válido, inscriba al alumno en dicho género. Asuma que
hay lugar.
b. Dado un género musical válido G, un nombre de alumno N y un puntaje P, asignarle el puntaje
P al alumno N del género G. Considere que el alumno puede no existir.
c. Devolver al alumno que haya obtenido el mayor puntaje en todo el concurso.
d. Devolver un String que contenga la representación del concurso, siguiendo el formato:
“Genero 1 – Total inscriptos: X – representación del alumno 1 - ... - representación del alumno X
...
Genero 5 – Total inscriptos: Y – representación del alumno 1 - ... representación del alumno Y
Alumno de mayor puntaje es: representación del alumno de mayor puntaje”
3- Realice un programa que instancie un concurso con un máximo de 20 alumnos por género.
Instancie 5 alumnos e inscriba a cada uno en algún género musical. Asigne puntajes. Imprima la
representación del concurso.
 */
package tema3;

import PaqueteLectura.*;

public class Adic {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        String nombre, instrumento;
        int edad;
        // instanciar concurso 20 alu por genero
        Concurso concurso = new Concurso(20);
        
        // instanciar 5 alumnos asignando genero musical
        int G=0;
        for (int i=0; i<5; i++ ) {
            // lee datos
            System.out.println("Ingresar nombre, instrumento y edad: ");
            nombre = Lector.leerString();   
            instrumento = Lector.leerString();
            edad = Lector.leerInt();
            
            // instancio alumno sin parametros
            Alumno alu = new Alumno ();
            // seteo datos
            alu.setNombre(nombre);
            alu.setInstrumento(instrumento);
            alu.setEdad(edad);
            // agrego alumno a concurso
            concurso.inscribirAlu(alu, G);
            G++;
        }
        
        //asignar puntajes (set)
        concurso.asignaPunt(0, "Lucas", 5.50);
        concurso.asignaPunt(1, "Karen", 6.50);
        concurso.asignaPunt(2, "Daniela", 8.50);
        concurso.asignaPunt(3, "Luciana", 7.50);
        concurso.asignaPunt(4, "Camila", 4.50);
        
        //imprimir concurso
        System.out.println("Alumno con mayor puntaje: "+ concurso.mayorPunt().getNombre());
        System.out.println(concurso.toString());
    }   
    // Solucionar imprime puntajes en 0 
    
}
