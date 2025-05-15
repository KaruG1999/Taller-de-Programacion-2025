/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recu1_6_12_24;

public abstract class Torneo {
    
    private String nombre, fecha;
    private double costoInsc, montoP;

    public Torneo(String nombre, String fecha, double costoInsc, double montoP) {
        setNombre(nombre);
        setFecha(fecha);
        setCostoInsc(costoInsc);
        setMontoP(montoP);
    }

    // obtener recaudacion abstracto
    public abstract double recaudacion ();
    
    // retornar si un torneo es viable 
    public boolean isViable() {
        if (this.recaudacion() > (2*getMontoP())){
            return true;
        }
        return false;
    }
    
    // representacion

    @Override
    public String toString() {
        String aux = "Nombre del torneo: " + getNombre() + ", Fecha: " + getFecha() + 
                ", Monto a otorgar a ganador: " + getMontoP() + ", Recaudacion del torneo: " + this.recaudacion();
        if (this.isViable()) {
            aux += ", Es viable";
        } else {
            aux += ", No es viable";
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    } 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCostoInsc() {
        return costoInsc;
    }

    public void setCostoInsc(double costoInsc) {
        this.costoInsc = costoInsc;
    }

    public double getMontoP() {
        return montoP;
    }

    public void setMontoP(double montoP) {
        this.montoP = montoP;
    }
    
    
    
    
    
    
    
}
