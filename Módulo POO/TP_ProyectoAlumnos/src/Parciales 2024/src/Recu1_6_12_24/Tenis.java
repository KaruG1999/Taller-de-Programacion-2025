/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recu1_6_12_24;

public class Tenis extends Torneo{
    
    private int cantJ;
    private String tipoS;

    public Tenis(int cantJ, String tipoS, String nombre, String fecha, double costoInsc, double montoP) {
        super(nombre, fecha, costoInsc, montoP);
        setCantJ(cantJ);
        setTipoS(tipoS);

    }

    
    // calculo recaudacion
    public double recaudacion () {
        return super.getCostoInsc() * this.getCantJ();
    }
    
    
    
    
    
    
    public int getCantJ() {
        return cantJ;
    }

    public void setCantJ(int cantJ) {
        this.cantJ = cantJ;
    }

    public String getTipoS() {
        return tipoS;
    }

    public void setTipoS(String tipoS) {
        this.tipoS = tipoS;
    }
    
    
    
    
    
    
    
    
    
    
}
