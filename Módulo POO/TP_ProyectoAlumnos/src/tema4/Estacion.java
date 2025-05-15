
package tema4;


public class Estacion {
    
    private String nombre;
    private double latitud, longitud;

    public Estacion(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // representacion

    @Override
    public String toString() {
        String aux;
        aux = getNombre() + "(" + getLatitud() + "S - " + getLongitud() + "O";
        return aux; 
    }
    
    
    // get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    
    
}
