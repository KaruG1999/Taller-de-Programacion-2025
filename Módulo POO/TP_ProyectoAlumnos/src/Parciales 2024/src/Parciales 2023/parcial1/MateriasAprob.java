
package parcial.a;

public class MateriasAprob {

    private String nombre;
    private int nota;
    private int fecha;
    
    
    
    public MateriasAprob(String nomb, int nota, int f) {
        this.nombre= nomb;
        this.nota= nota;
        this.fecha =f;
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Nombre=" + this.nombre + ", nota=" + this.nota + ", fecha=" + this.fecha + '}' + "\n";
    }
    
    
}
