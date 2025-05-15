
package tema3;

public class Autor {
    // estado
    private String nombre, bio, origen;

    // contructor

    public Autor(String nombre, String bio, String origen) {
        this.nombre = nombre;
        this.bio = bio;
        this.origen = origen;
    }
    
    // metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    // to string
    @Override
    public String toString() {
        String aux;
        aux = "Nombre autor: " + nombre + ", biografia: " + bio + ", origen: " + origen;
        return aux;
    }
    
    
}
