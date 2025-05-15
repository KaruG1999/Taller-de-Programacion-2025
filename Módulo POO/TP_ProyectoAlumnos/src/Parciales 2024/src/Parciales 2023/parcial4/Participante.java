/*

 */
package parcial4;

public class Participante {
    
    private int dni;
    private String nombre;
    private int edad;

    public Participante(int dni, String nomb, int edad) {
        this.dni= dni;
        this.nombre = nomb;
        this.edad = edad;
    }
    //getters y setters

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //imprimir info de participante 

    @Override
    public String toString() {
        return "Participante{" + "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + '}';
    }
    
    
}
