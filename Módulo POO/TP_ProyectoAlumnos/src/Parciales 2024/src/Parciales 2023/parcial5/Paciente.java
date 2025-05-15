
package parcial5;

public class Paciente {

    private String nombre;
    private boolean obraSocial;
    private double costoSes;
    
    public Paciente(String nomb, boolean vof, double costo) {
        this.nombre = nomb;
        this.obraSocial = vof;
        this.costoSes = costo;
    }
    //getters y setters 
    public boolean isObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public double getCostoSes() {
        return costoSes;
    }

    public void setCostoSes(double costoSes) {
        this.costoSes = costoSes;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
