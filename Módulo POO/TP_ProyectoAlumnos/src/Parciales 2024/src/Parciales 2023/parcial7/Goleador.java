
package parcial7;

import java.beans.beancontext.BeanContextMembershipEvent;

public class Goleador {
    
    private String nombre;
    private String nomEquipo;
    private int cantGoles;

    public Goleador(String nombre, String nomEquipo, int cantGoles) {
        this.nombre = nombre;
        this.nomEquipo = nomEquipo;
        this.cantGoles = cantGoles;
    }
    
    //setters y getters 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }
    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }

    @Override
    public String toString() {
        return this.nombre + ", nomEquipo=" + this.nomEquipo + ", cantGoles=" + this.cantGoles + '|';
    }
    

    

}
