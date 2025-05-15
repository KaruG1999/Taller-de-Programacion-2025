/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoJ_16_10_24;

class Torneo {
    
    private String nombreS, fecha;
    private double montoR, montoP;

    public Torneo(String nombreS, String fecha, double montoR, double montoP) {
        setNombreS(nombreS);
        setFecha(fecha);
        setMontoR(montoR);
        setMontoP(montoP);
    }

    // calculo recaudacion torneo
    public double recaudado() {
        return (this.montoR - this.montoP);
    }
    
    
    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMontoR() {
        return montoR;
    }

    public void setMontoR(double montoR) {
        this.montoR = montoR;
    }

    public double getMontoP() {
        return montoP;
    }

    public void setMontoP(double montoP) {
        this.montoP = montoP;
    }
    
    
    
}
