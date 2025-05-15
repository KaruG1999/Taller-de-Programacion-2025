/*
 De cada alumno registra su nombre, edad, el instrumento que toca y
puntaje obtenido.
Los alumnos deben instanciarse dando valor a todos sus atributos.

 */
package tema3;

public class Alumno {
    
    private String nombre, instrumento;
    private int edad;
    private double puntaje;

    public Alumno(String nombre, String instrumento, int edad) {
        this.nombre = nombre;
        this.instrumento = instrumento;
        this.edad = edad;
    }
    
    public Alumno () {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", instrumento=" + instrumento + ", edad=" + edad + ", puntaje=" + puntaje;
    }
    
    
    
}
