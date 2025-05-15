/*
 */
package parcial6;

public class Paciente {
    
    private String nombre;
    private boolean obraSoc;
    private double costo;
    
    public Paciente(String nomb, boolean oS, double c) {
        this.nombre = nomb;
        this.obraSoc= oS;
        this.costo = costo;
    }
    //setters y getters 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isObraSoc() {
        return obraSoc;
    }

    public void setObraSoc(boolean obraSoc) {
        this.obraSoc = obraSoc;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
