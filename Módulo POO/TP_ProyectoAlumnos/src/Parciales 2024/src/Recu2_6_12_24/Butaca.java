
package Recu2_6_12_24;
import PaqueteLectura.*;

class Butaca {
    
    private double precio;
    private boolean ocupada;

    public Butaca () {
        GeneradorAleatorio.iniciar();
        setPrecio(GeneradorAleatorio.generarDouble(5000));  // precio de cada butaca aleatorio
    }
    
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    
    
    
    
    
    
}
