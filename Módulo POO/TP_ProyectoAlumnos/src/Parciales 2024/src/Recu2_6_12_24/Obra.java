
package Recu2_6_12_24;

public abstract class Obra {  
    
    private String nombre, nombDir;
    private int cantAct, capMax;

    public Obra(String nombre, String nombDir, int cantAct, int capMax) {
        setNombre(nombre);
        setNombDir(nombDir);
        setCantAct(cantAct);
        setCapMax(capMax);
    }

    // metodo abst vaciar obra 
    public abstract void vaciarObra ();
    
    // total recaudado
    public abstract double recaudado ();
    
    //representacion

    @Override
    public String toString() {
        String aux = "Nombre de la obra: " + getNombre() + ", Director: " + getNombDir() + 
                ", cantidad de actores en escena: " + getCantAct() +
                ", Total recaudado: " + this.recaudado();
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombDir() {
        return nombDir;
    }

    public void setNombDir(String nombDir) {
        this.nombDir = nombDir;
    }

    public int getCantAct() {
        return cantAct;
    }

    public void setCantAct(int cantAct) {
        this.cantAct = cantAct;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }
    
    
    
    
    
    
    
}
