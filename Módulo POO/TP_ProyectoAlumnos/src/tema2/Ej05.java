/*
5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:
getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
- Calcular e informar la cantidad de partidos que ganó River.
- Calcular e informar el total de goles que realizó Boca jugando de local.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        GeneradorAleatorio.iniciar();
        
        int df=20;
        Partido [] vector = new Partido[df]; // aca solo lo declaro? 
        
        String nombL, nombV;
        int golesL, golesV;
        int dl=0;
        
        //cargo vector con partidos leidos por teclado
        System.out.println("Nombre equipo Local: ");
        nombL = Lector.leerString();
        System.out.println("Nombre equipo Visitante: ");
        nombV = Lector.leerString();
        
        while ((!nombV.equals("ZZZ")) && (dl<df))  {
            System.out.println("Goles equipo Local: ");
            golesL = Lector.leerInt();
            System.out.println("Goles equipo Visitante: ");
            golesV = Lector.leerInt();
            
            
            vector[dl] = new Partido (nombL, nombV, golesL, golesV);
            
            dl++; 
            System.out.println("Nombre equipo Local: ");
            nombL = Lector.leerString();
            System.out.println("Nombre equipo Visitante: ");
            nombV = Lector.leerString();
        }
        //recorro vector 
        int ganoR=0, totB=0;
        for (int i=0; i<dl; i++ ) {
            //sumo cant de partidos que gano River 
            if (vector[i].getGanador().equals("River")) { 
                ganoR++;
            }
            // cuenta goles de boca jugando de local
            if (vector[i].getLocal().equals("Boca")) {
                totB += vector[i].getGolesLocal();
            }
            
            //imprimo String
            System.out.println(vector[i].toString());
        }
        //imprimo lo demas al terminar el vector 
        System.out.println("Cantidad de partidos que gano River: "+ ganoR);
        System.out.println("Total de goles que realizo Boca: "+ totB);
    }
    
}
