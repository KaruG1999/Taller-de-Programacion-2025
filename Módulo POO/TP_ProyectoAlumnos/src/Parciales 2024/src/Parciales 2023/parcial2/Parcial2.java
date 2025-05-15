/*
Concurso vector de 5 posiciones (5 generos) 
Cada genero posee maximo N alumnos (20 alumnos) CRER UNA MATRIZ DE 5 X N ( GENERO X ALUMNOS )
Cada alumno registra NOMBRE, EDAD, INSTRUMENTO, PUNTAJE
Constructores : 
- iniciar el concurso sin alumnos (n alumnos).
- iniciar alumnos dando valor a toods sus atributos y puntaje -1.
Metodos: 
- Recibe alumno y genero y devuelve el alumno inscrip en dicho genero 
- Recibe puntaje y nombre de alumno y devuelve el alumno con el puntaje asignado 
- Recibe vector generos y devuelve el que tiene mas inscriptos ( GENERO MAX ) 
PP
-Instancio un concurso con maximo 20 (N) alumnos por genero 
-Instancio 5 alumnos y los agrego a cada genero asignandole puntaje a cada uno 
-Imprimir el resultado
 */
package parcial2;

import PaqueteLectura.*;

public class Parcial2 {

    public static void main(String[] args) {
        //inic aleat
        GeneradorAleatorio.iniciar();
        //VARIABLES ( MAXIMO DE ALUMNOS (N) / 
        //int nGenero = 5;
        //int maxAlu = 20;
        
        // CREO UNA MATRIZ DE 5 GENEROS X N ALUMNOS 
        //Alumno [][] concurso = new Alumno [nGenero][maxAlu]; //tipo dato [][] + nomb matriz = new tipo dato [filas][columnas]
        Concurso concurso = new Concurso (20);
        //CREO 5 ALUMNOS 
        Alumno alu1 = new Alumno("Karen", 25, "Flauta");
        Alumno alu2 = new Alumno("Daniela", 18, "Bateria");
        Alumno alu3 = new Alumno("Sofia", 30, "Guitarra");
        Alumno alu4 = new Alumno("Alma", 28, "Bajo");
        Alumno alu5 = new Alumno("Ludmila", 35, "Trompeta");
        //AGREGO A MATRIZ PASANDO ALUMNO Y GENERO 
        concurso.agregarAlu(alu1, GeneradorAleatorio.generarInt(5));
        concurso.agregarAlu(alu2, GeneradorAleatorio.generarInt(5));
        concurso.agregarAlu(alu3, GeneradorAleatorio.generarInt(5));
        concurso.agregarAlu(alu4, GeneradorAleatorio.generarInt(5));
        concurso.agregarAlu(alu5, GeneradorAleatorio.generarInt(5));
        //ASIGNO PUNTAJES PASANDO PUNTAJE Y NOMBRE DE ALUMNO
        concurso.asignoPunt(GeneradorAleatorio.generarDouble(10), "Karen");
        concurso.asignoPunt(GeneradorAleatorio.generarDouble(10), "Daniela");
        concurso.asignoPunt(GeneradorAleatorio.generarDouble(10), "Sofia");
        concurso.asignoPunt(GeneradorAleatorio.generarDouble(10), "Alma");
        concurso.asignoPunt(GeneradorAleatorio.generarDouble(10), "Ludmila");
        //IMPRIMO RESULTADO 
        System.out.println("Concurso creado: " + concurso.toString()); 
    }
    
}
