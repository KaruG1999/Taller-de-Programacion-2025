/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Karen
 */
public abstract class Urna {
    
    private int numUrna, contV;
    private Zona zona;

    public Urna(int numUrna, Zona zona ) {
        this.numUrna = numUrna;
        this.contV = 0; // contador de votos en 0
        this.zona = zona;
    }
    
    // método para contar votos en blanco (en ambos)
    public int votarEnBlanco () {
        return this.contV++;
    }
    
    // método abst 
    public abstract int calcularGanador() ;
    
    public abstract int calcularTotalVotos();
    
    public int getNumUrna() {
        return numUrna;
    }

    public void setNumUrna(int numUrna) {
        this.numUrna = numUrna;
    }

    public int getContV() {
        return contV;
    }

    public void setContV(int contV) {
        this.contV = contV;
    }

    @Override
    public String toString() {
        String aux = " Urna: " + getNumUrna() +
                ", Zona: " + this.zona.toString() + 
                ", Total de votos: " + this.calcularTotalVotos() +
                ", Ganador: " + this.calcularGanador();
        return aux; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
            
    
}
