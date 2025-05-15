/*
Sistema es una matriz d 5 dias x 6 turnos  
Paciente: nombre, obra soci, costo sesion
.Constructores:
-Sist: sin pacientes 
-pac: a partir de info 
.Metodos 
-agenda paciente P en dia D y turno T 
-recibe nombre de paciente y libera todos sus turnos 
-dado un dia D y nombre P, confirma si el paciente tiene un turno durante ese dia 
.PP
- instancia un sistema 
- crea y carga varios pacientes 
- libera todos los turnos agendados
- imprime si el pac tiene un turno el dia D o no.
 */
package parcial6;
import PaqueteLectura.*;
public class Parcial6 {

    public static void main(String[] args) {
        //iniciaz random
        GeneradorAleatorio.iniciar();
        //variables 
        Paciente pac1;
        Paciente pac2;
        Sistema sist;
        
        //crea un sistema sin parametros 
        sist = new Sistema ();
        //crea varios pacientes  
        pac1 = new Paciente ("Karen", true , 150.5);
        pac2 = new Paciente ("Lucas", GeneradorAleatorio.generarBoolean(), 200.0);
        //agrega varios turnos de esos 2 pacientes en dia D y hora H
        sist.agendoPac (pac1, 0, 1);
        sist.agendoPac (pac2, 0, 2);
        sist.agendoPac (pac1, 1, 3);
        sist.agendoPac (pac2, 1, 4);
        //liberar turnos agendados pasando el dia 
        System.out.println("Consulta si existe turno" + sist.tieneTurno(0, "Lucas")); //consulta si hay turno (pasa nombre y devuelve boolean)
        sist.liberaTurn("Lucas");
        //imprimir si el paciente tiene turno ese dia (dia D, nombre de paciente);
        System.out.println(sist.tieneTurno(1, "Karen"));
        
    }
    
}
