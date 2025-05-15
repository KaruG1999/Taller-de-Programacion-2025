/*
 Representar concurso: N parejas (cada pareja son 2 participantes) y un estilo de baile
Participante: dni, nombre,edad.
Contructor: 
-concurso: maximo N parejas, sin parejas cargadas(null)
-parejas:
-participantes:
Metodos:
-Agrega pareja
-Obtiene diferencia de edad de parejas
-Obtiene dif de edad Maxima (vector contador de dif de edades)
PP
-instancia concurso 
-carga 2 parejas 
-imprime nombres de la pareja con mas diferencia de edad 
 */
package parcial4;
import PaqueteLectura.*;
public class Parcial4 {

    public static void main(String[] args) {
        // inic aleat
        GeneradorAleatorio.iniciar();
        //variables 
        Concurso concurso;
        
        //crea concurso (N parejas / Estilo de baile)
        concurso = new Concurso (10); //N=10
        //creo 4 participantes (dni, nombre, edad)
        Participante part1 = new Participante (420, "Karen", 25);
        Participante part2= new Participante (425, "Lucas", 29);
        Participante part3= new Participante (380, "Rocio", 19);
        Participante part4= new Participante (390, "Mara", 23);
        //creo parejas (participante 1 y 2 , estilo de baile 
        Pareja par1 = new Pareja (part1,part2, "Salsa");
        Pareja par2 = new Pareja (part3, part4, "Bachata");
        //agrego parejas a concurso
        concurso.agregoPareja(par1);
        concurso.agregoPareja(par2);
        //imprimir nombres de 2 participantes que tienen mayor dif de edad antre ellos 
        System.out.println(concurso.toString());
    }
    
}
