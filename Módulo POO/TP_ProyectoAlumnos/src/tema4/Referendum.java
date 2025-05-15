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
public class Referendum extends Urna{
    
    private int aFavor, enContra; 

    public Referendum(int numUrna, Zona zona) {
        super(numUrna, zona);
        setaFavor(0);
        setEnContra(0);
        // inic contadores en 0
    }

    // votar a favor
    public void votarAFavor () {
        this.aFavor++;
    }
    // idem en contra
    public void votarEnContra () {
        this.enContra++;
    }
    
    
    public int getaFavor() {
        return aFavor;
    }

    public void setaFavor(int aFavor) {
        this.aFavor = aFavor;
    }

    public int getEnContra() {
        return enContra;
    }

    public void setEnContra(int enContra) {
        this.enContra = enContra;
    }

    @Override
    public int calcularGanador() {
        if (getaFavor() == getEnContra()) {
            return 0;
        } else {
            if (getEnContra() > getaFavor()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    @Override
    public int calcularTotalVotos() {
        int suma =0;
        suma += super.getContV() + this.getaFavor() + this.enContra;
        return suma;
    }

    @Override
    public String toString() {
        String aux = " Votos a favor: " + getaFavor() + ", Votos en contra: " + getEnContra();
        return super.toString() + aux;
    }

    
    
    
    
    
    
    
}
