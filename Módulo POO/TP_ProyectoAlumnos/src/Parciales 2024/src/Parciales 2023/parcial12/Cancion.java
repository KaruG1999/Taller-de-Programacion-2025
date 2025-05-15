
package parcial12;

public class Cancion {
    
    private String nombre;
    private String compositor;
    private int id;
    private Alumno ganador;
    private double puntaje;

    public Cancion(int id, String nombre, String compositor) {
        this.nombre = nombre;
        this.compositor = compositor;
        this.id = id;
        this.ganador = null;
        this.puntaje = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getGanador() {
        return ganador;
    }

    public void setGanador(Alumno ganador) {
        this.ganador = ganador;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Cancion{" + "nombre=" + this.nombre + ", compositor=" + this.compositor + ", puntaje=" + this.puntaje + '}';
    }
    
    
    

    

    
    
}
