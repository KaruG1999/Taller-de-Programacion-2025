
package parcial.a;

import PaqueteLectura.*;

public class ParcialA {

    public static void main(String[] args) {
        //inic aleat
        GeneradorAleatorio.iniciar();
        
        DeGrado alu1; //variable alu1 de alumno de grado
        DeDoc alu2; //variable de clase alumno de doctorado 
        MateriasAprob mate;  // crear variable de clase Materia 
        //crear alumnos 
         alu1 = new DeGrado(42029042, "Karen", 24, "APU"); //dni, nombre, mat aprob,carrera
         alu2 = new DeDoc(42029042, "Karen", 24, "APU" , "UNLP" );  //dni, nombre, mat aprob, tit univ, univers de origen 
        //cargar info de materias (vector)
        int i;
       //carga las materias aprobadas a alu1 alumno de grado
        for (i=0; i< alu1.getCantMax(); i++) {    
            //mate = new MateriasAprob("Karen", 8, 16/11);
            mate = new MateriasAprob(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarInt(30));
            if (i == 5) {
                mate.setNombre ("Tesis"); //si la ma
            }
            alu1.agregarMateria (mate); //agrega materia aprobada 
        }
        
        //carga de materias aprobadas de alu2 alumno de doctorado
        for (i=0; i < alu2.getCantMax(); i++) {
            //creo materia y le paso datos
            mate = new MateriasAprob (GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarInt(30));
            //agrego materia creada a alumno2
             alu2.agregarMateria(mate);
        } 
        
        //imprimir ambos alumnos 
        System.out.println("  " + alu1.toString());
        System.out.println("  " + alu2.toString());
       
    }
    
}
