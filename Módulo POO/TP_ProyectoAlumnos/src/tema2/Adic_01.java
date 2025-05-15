/*
 1- a) Cargue la clase Auto.java (dada por la cátedra) en su proyecto.
Un objeto auto se crea sin valores iniciales y responde a los siguientes mensajes:
    -getPatente() retorna la patente (int) del auto
    -getDueño() retorna el nombre del dueño (String) del auto
    -setPatente(X) modifica el número de patente al “int” pasado por parámetro (X)
    -setDueño(X) modifica el nombre del dueño al “String” pasado por parámetro (X)
    -toString() retorna un String que representa al objeto. Ej: “Patente 111222 Dueño Carla Perez”

b) Simular la entrada de autos al estacionamiento municipal en el centro de la ciudad. El
estacionamiento está dividido en N pisos y cada piso tiene N plazas, y debemos
almacenar en una estructura de datos adecuada los autos estacionados.
Realice un programa que lea la información de 5 autos que desean estacionar. Por cada
auto, también lea número de piso y número de plaza e ingréselo en la estructura en el
lugar adecuado.
Nota: N se ingresa por teclado. Al principio el estacionamiento debe estar vacío (sin autos).

c) A partir de la estructura de autos:
    i. Informar para cada número de piso y número de plaza ocupado, la
representación del auto que la ocupa.
    ii. Informar cuál es el piso más ocupado.
    iii. Informar el total de autos estacionados en la plaza 1 (tenga en cuenta
todos los pisos).
    iv. Informar el total de autos que ocupan lugares con igual número de piso y
número de plaza.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Adic_01 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // variables 
        int patente;
        String dueño;
         
        // creo matriz estacionamiento
        System.out.println("Ingresar N: ");
        int N = Lector.leerInt();
        Auto [][] estacionamiento = new Auto[N][N]; 
        
        //inicializo matriz
        int i,j;
        for (i=0; i<N; i++) {
            for (j=0; j<N; j++){
                estacionamiento[i][j] = null;
            }
        }
        
        // cargo matriz con setters 
        int piso, plaza;
        System.out.println("Cargando datos de estacionamiento");
        for (i=0; i<5; i++) {
            patente = GeneradorAleatorio.generarInt(9999999);
            dueño = " nombre dueño" ; //  + GeneradorAleatorio.generarString(zzzz); no funciona 
            piso = GeneradorAleatorio.generarInt(N);
            plaza = GeneradorAleatorio.generarInt(N);
            Auto auto = new Auto();
            auto.setPatente(patente);
            auto.setDueño(dueño);
            estacionamiento[piso][plaza] = auto;
        }
        
        // informar 
        int cantPiso;
        int maxPiso= -1;
        int maxCant =0;
        int cantPuno=0;
        int cantCoinc = 0;
        for (i=0; i<N ; i++) {
            cantPiso = 0;
            for (j=0; j<N ; j++) {
                // informo objeto auto en cada lugar del estacionamiento
                if (estacionamiento[i][j] != null)  { 
                    System.out.println("piso:" + i + " plaza:"+ j + " :" + estacionamiento[i][j].toString());
                    cantPiso++; 
                    // cantidad de autos en plaza 1 de todos los pisos
                    if (j == 0) {cantPuno++;}
                    //cant autos que tienen mismo numero de piso y plaza
                    if (i == j) {cantCoinc++;}
                }
            }
            if (cantPiso > maxCant) {  //calcula piso mas ocupado
                maxCant = cantPiso;
                maxPiso = i;
            }
        }
        System.out.println("Cant autos en plazas numero 1 (0): " + cantPuno );
        System.out.println("Cant de autos que coinciden en numero de piso y plaza: "+ cantCoinc);
        System.out.println("Piso con mas cantidad de autos: "+ maxPiso);
    }
    
}
