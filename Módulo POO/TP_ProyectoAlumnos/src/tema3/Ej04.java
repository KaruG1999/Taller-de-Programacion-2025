/*
4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
(ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/ 2000
y 8000.
(iii) Implemente en las clases que corresponda todos los métodos necesarios para:
- Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
en el rango 1..N) y que la habitación está libre.
- Aumentar el precio de todas las habitaciones en un monto recibido.
- Obtener la representación String del hotel, siguiendo el formato:
{Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
…
{Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe
delegar la responsabilidad de la operación.
 */
package tema3;

import PaqueteLectura.*;

public class Ej04 {

    public static void main(String[] args) {
        // instancio Hotel
        Hotel hotel = new Hotel (15);  // hotel de 15 habitaciones 
        int numHab = 1; // declaro numHab asign para no generar aleatoriamente 
                
        // cargo habitaciones 
        for (int i=0; i<10; i++) {
            Cliente cliente = new Cliente (GeneradorAleatorio.generarString(10), GeneradorAleatorio.generarInt(100), GeneradorAleatorio.generarInt(100));
            hotel.agregoCl(cliente, numHab);
            numHab += 1;
        }
        // imprimo info de hotel
        System.out.println(hotel.toString());
        //aumento precio de haiataciones
        hotel.aumentoPrecios(1000.50);
        System.out.println(hotel.toString());
    }
    
}
