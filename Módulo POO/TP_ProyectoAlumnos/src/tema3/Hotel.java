/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

public class Hotel {
    
    private int N; // número de habitaciones
    private Habitacion [] habitaciones;  // hotel es un vector de habitaciones 

    public Hotel(int nHab) {
        this.N = nHab;
        habitaciones = new Habitacion [nHab];  // creo vector con N habitaciones
        for (int i=0; i<nHab ; i++) {
            habitaciones[i] = new Habitacion(); // inicializo cada habitacion (se crea precio, ocupacion y cliente en null)
        }
    }
    
    // constructor que inicializa hotel sin habitaciones 
    public Hotel() {
        habitaciones = new Habitacion[N];
    }
    
    // agrego cliente a la habitacion solicitada
    public void agregoCl (Cliente cliente, int nHab) {
        habitaciones[nHab-1].ocupoHab(cliente);  //nHab - 1 porque vector empieza en 0
    }
    
    // aumento precio habitaciones
    public void aumentoPrecios (double aumento) {
        for (int i=0; i<N; i++) {
            habitaciones[i].aumentoCosto(aumento);
        }
    }
    
    // imprime info hotel
    @Override
    public String toString() {
        String aux = "";
        for (int i=0; i<N; i++){
            aux += "Habitacion: "+ i+1 + ":" + habitaciones[i].toString() + "\n";
        }
        return aux;
    }
    
}
