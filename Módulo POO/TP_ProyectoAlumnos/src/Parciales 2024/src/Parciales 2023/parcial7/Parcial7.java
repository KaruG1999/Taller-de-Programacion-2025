/*
turnoB tema1 17/10/2022
Torneo: nombre y (vector) tabla para cada fecha de goleadores 
fecha: maxi goleador M
Goleador: nombre, nomb de equipo, cant de goles de esa fecha
.Constructores:
- goleador a partir de info necesaria
- torneo con nomb y cant N de fechas y cant M de goleadores : inic tiene 0 golead registrados
.Metodos:
- agrega goleador a fecha X y actualiza cant d goleadores 
- goleador con menos cantidad de goles  en fecha X
- cant tot de goleadores en torneo 
- Imprime 
TORNEO 2022: nombre 
Fecha #1 | cant de golead | Goleador : {nombre, equipo, cant goles} 
PP
-Instancia torneo 
-agrega goleadores a dist fechas 
-imprime goleador con menos cant de goles 
-imprime total de goleadors del torneo 
 */
package parcial7;
import PaqueteLectura.*;
public class Parcial7 {

    public static void main(String[] args) {
        // inic
        GeneradorAleatorio.iniciar();
        //variables 
        Torneo torneo;
        Goleador goleador;
        //crear torneo
        torneo = new Torneo("Torneo", 10, 11);
        //crear goleadores y los agrego a torneo
        for (int i=0; i<15; i++){
             goleador = new Goleador (GeneradorAleatorio.generarString(5),GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(10));
        }    torneo.agregarGolead (goleador, GeneradorAleatorio.generarInt(10));
        //ingresar fecha y devuelve el goleador min
        System.out.println( torneo.minGol(1)); //retorna el string (nombre) de jugador ue jugo en la fecha 1
        // total de goleadores (devueñve un entero)
        System.out.println("Cantidad total de goleadores: " + torneo.totGol());
        //imprime toString de torneo 
        System.out.println( torneo.toString());
  
    }
    
    
}
