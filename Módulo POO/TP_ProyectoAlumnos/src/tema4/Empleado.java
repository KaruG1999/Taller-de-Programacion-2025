
package tema4;

public abstract class Empleado {
    
    private String nombre;
    private double sueldoB;
    private int antig;

    public Empleado(String nombre, double sueldoB, int antig) {
        this.nombre = nombre;
        this.sueldoB = sueldoB;
        this.antig = antig;
    }
    
    // metodos abtractos 
    public abstract double calcularEfectividad ();
    public abstract double calcularSueldo();
    
    // calcula el sueldo base 
    public double sueldoBase() {
        return this.getSueldoB() + ((this.getSueldoB()*0.10) * this.getAntig());
    }

    //to String
    @Override
    public String toString() {
        String aux = " Nombre: " + this.getNombre() +
                    " Sueldo a cobrar: " + this.calcularSueldo()+
                    " Efectividad: " + this.calcularEfectividad();
        return aux;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoB() {
        return sueldoB;
    }

    public void setSueldoB(double sueldoB) {
        this.sueldoB = sueldoB;
    }

    public int getAntig() {
        return antig;
    }

    public void setAntig(int antig) {
        this.antig = antig;
    }
    
    
    
}
