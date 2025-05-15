/*
Sistema turnos: matriz 5 dias por 6 horas diarias 
Paciente: nombre, si tiene obra social(boolean), costo sesion

 */
package parcial5;
import PaqueteLectura.*;
public class Parcial5 {

    public static void main(String[] args) {
        //inic aleat 
        GeneradorAleatorio.iniciar();
        //variables 
        Sistema sist;
        Paciente pac;
        //creo sistema sin pacientes 
        sist = new Sistema(); //sistema de 5x6
        //creo pacientes y los agrego al sistema  
        for (int i=0; i < 10; i++ ){
           pac = new Paciente (GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarBoolean(),GeneradorAleatorio.generarDouble(1000));
           sist.registroPac (pac, GeneradorAleatorio.generarInt(5),GeneradorAleatorio.generarInt(6));
        }
        //libero turnos agentados de dia D
        sist.liberoDia (GeneradorAleatorio.generarInt(5)); //metodo libero dia, paso parametro dia 
        //imprime el dinero recaudado de la semana 
        System.out.println("Ganancia de la semana completa: " + sist.gananciaSem());
    
    }
    
}
