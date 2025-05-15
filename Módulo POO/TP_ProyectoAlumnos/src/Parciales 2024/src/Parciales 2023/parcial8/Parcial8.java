/*
Curso: año cursada, alumnos(N max)
alumno: dni. nombre , asistencias, cant ev aprobadas 
Curso dos tipos: 
- virtual: curso+ link
- presencial: curso + num aula
.contructores 
 */
package parcial8;
import PaqueteLectura.*;
public class Parcial8 {

    public static void main(String[] args) {
        // inic aleat 
        GeneradorAleatorio.iniciar();
        //var 
        Presencial presencial = new Presencial( 2025, 20, 2 );
        Virtual virtual = new Virtual (2024, 30, "ADCE"); 
        Alumno alu;
       
        //creo alumnos y agrego a cada curso
        for (int i =0; i< 15; i++) {
            alu = new Alumno (i, GeneradorAleatorio.generarString(5));
            presencial.agregaAlu(alu);
            virtual.agregaAlu (alu);
        }
        //incrementa a cada alumno la asistencia y las autoevaluaciones 
        for (int j=0; j< 15; j++) {
            for (int k=0; k< 3; k++) {
                if (j != 3) {
                    presencial.aproboPrueb(j);
                    virtual.aproboPrueb(j);
                    presencial.incAsist(j);
                    virtual.incAsist(j);
                }
            } 
        }

        //imprirmir cantidad de alumnos en condiciones de rendir en cada curso 
        System.out.println("Cantidad de alumnos en condiciones de rendir a dist: " + presencial.cantAluRend());
        System.out.println("Cantidad de alumnos en condiciones de rendir a dist: " + virtual.cantAluRend());
        
        
    }
    
}
