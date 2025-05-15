/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import PaqueteLectura.*;

public class Habitacion {
    
    private double costoNoche;
    private boolean ocupada;
    private Cliente cliente;
    
    public Habitacion() {
        this.costoNoche = GeneradorAleatorio.generarDouble(6001)+2000; // genera costo entre 2000 y 8000
        this.ocupada = false;
        cliente = null;
    }
    
    
    // inserto cliente en habitacion
    public void ocupoHab (Cliente c) {
        cliente = c;
        ocupada = true;
    }
    
    // aumento costo de habitacion pasado por par
    public void aumentoCosto (double aumento){
        costoNoche += aumento;
    }
    
    // devuelve si habitacion esta ocupada
    public boolean isOcupada (){
        return ocupada;
    }
    public void setOcupada (boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    // imprimir
    @Override
    public String toString() {
        String aux = "Costo: " + costoNoche + "Estado: " + ocupada;
        if (ocupada) {
            aux += cliente.toString();
        }
        return aux;
    }
    
    //set y get

    public double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
