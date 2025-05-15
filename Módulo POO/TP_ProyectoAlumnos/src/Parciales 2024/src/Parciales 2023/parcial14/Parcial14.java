/**
 
 */
package parcial14;
import PaqueteLectura.*;
public class Parcial14 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        //creo director (nomb, dni,año ingr, sueldobas, monto viatic)
        Director dir;
        dir = new Director ("Karen", 420, 2023, 1000.0, 500.0);
        //instancio una empresa (nombre, direccion, director, N encargados)
        Empresa emp = new Empresa("IT", "saladillo", dir, 10);
        Encargado enc;
        //creo y cargo encargados en dist sucursales (nomb, dni, año ingr, sueldobas, cant empl)
        for (int i=0; i<6; i++) {
            enc= new Encargado (GeneradorAleatorio.generarString(5),GeneradorAleatorio.generarInt(555),
            GeneradorAleatorio.generarInt(2024), GeneradorAleatorio.generarDouble(2000),GeneradorAleatorio.generarInt(15));
            emp.cargaEmp(enc, GeneradorAleatorio.generarInt(8));//encargado y suc x
        }
        //imprimir repres
        System.out.println("Representacion de la empresa " + emp.toString());
    }
    
}
