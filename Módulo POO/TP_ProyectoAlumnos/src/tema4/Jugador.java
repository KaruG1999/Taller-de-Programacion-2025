
package tema4;

public class Jugador extends Empleado{
    
    private int numPart, numGoles;

    public Jugador(int numPart, int numGoles, String nombre, double sueldoB, int antig) {
        super(nombre, sueldoB, antig);
        this.setNumPart(numPart);
        this.setNumGoles(numGoles);
    }
    
    // calcular efectividad 
    public double calcularEfectividad () {
        return (double)(this.getNumGoles()/ this.getNumPart());
    }
    
    
    // si prom de goles es superior a 0,5 se suma otro sueldo basico en metodo Super
    public double calcularSueldo (){
        double aux = this.getSueldoB();
        if (calcularEfectividad() > 0.5) {
            aux += this.getSueldoB();
        }
        return aux;
    }
    
    // representacion 
    //ES NECESARIO REPETIR TOSTRING EN SUBCLASE?

    @Override
    public String toString() {
        return super.toString(); 
        
    }
    
    public int getNumPart() {
        return numPart;
    }

    public void setNumPart(int numPart) {
        this.numPart = numPart;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }
    
    
    
}
