/*

 */
package parcial15;
import PaqueteLectura.*;
public class Parcial15 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // instancia un estacionamiento 
        Estacionamiento estac = new Estacionamiento ("saladillo", 100.0, 4,4);
        //crea vehiculos y los agrega a estac en dist lugares (registra vehic)
        for (int i=0; i<6 ; i++) {
            Vehiculo v = new Vehiculo (GeneradorAleatorio.generarString(3),
            GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarString(5), 
            GeneradorAleatorio.generarString(5));
            estac.agregaVehic(v, GeneradorAleatorio.generarInt(4), GeneradorAleatorio.generarInt(4));
        }
        //ingresa marca vehiculo M y sector X y borra los mismos (imprime auto eliminado)
        estac.eliminaMarca("marca", 2);
        //devuelve num sector con max recaudacion dinero
        System.out.println("Sector con mas recaudacion: " + estac.maxSector() );
        //string estac
        System.out.println(estac.toString());
        
        
    }
    
}
