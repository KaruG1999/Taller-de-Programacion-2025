
package tema4;


public class Trabajador extends Persona{
    
    private String tarea;

    public Trabajador(String unNombre, int unDNI, int unaEdad, String tarea) {
        super(unNombre, unDNI, unaEdad);
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return super.toString() + "soy: " + this.getTarea(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    
    
    
}
