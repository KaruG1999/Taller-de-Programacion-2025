/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoK_8_10_24;

public class Programador {
    
    private String nombre;
    private int dni;
    private double sueldo;
    private int cantL;
    private String lenguaje;

    public Programador(String nombre, int dni, double sueldo, int cantL, String lenguaje) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = sueldo;
        this.cantL = cantL;
        this.lenguaje = lenguaje;
    }
    
    // sueldo extra 
    public double sueldoAdic () {
        double adic = 0;
        if (this.getCantL() > 200) {
            adic += 50000;
        }
        return adic;
    }
    
    // aumento sueldo base 
    public void aumentoSueldo (double M) {
        double nuevoS = this.getSueldo() + M;
        setSueldo(nuevoS);  // actualiza sueldo 
    }
    
    // representacion

    @Override
    public String toString() {
        String aux = "Nombre: " + getNombre() +
                ", lenguaje de referencia: " + getLenguaje() +
                ", sueldo final: " + this.sueldo;  // imprime sueldo actualizado
        return aux; 
    }
    
    // get y set 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCantL() {
        return cantL;
    }

    public void setCantL(int cantL) {
        this.cantL = cantL;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    
}
