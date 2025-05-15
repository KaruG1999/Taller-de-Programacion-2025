/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recu1_6_12_24;

public class Futbol extends Torneo {
    
    private Equipo [] equipos;
    private int df, dl; // maximo N equipos

    public Futbol(int df, String nombre, String fecha, double costoInsc, double montoP) {
        super(nombre, fecha, costoInsc, montoP);
        setDf(df);
        this.dl = 0;
        this.equipos = new Equipo[this.df];
    }

    
    // agregar equipo a torneo de futbol
    public void agregarEquipo (Equipo equipo) {
        if (this.dl < getDf()) {
            equipos[this.dl] = equipo;
            this.dl++;
        }
    }
    
    //calculo recadacion (se asumen 11 jugadores por equipo)
    public double recaudacion() {
        double tot = super.getCostoInsc() * (11 * this.dl);
        return tot; 
    }
    
    
    
    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }
    
    
    
    
    
}
