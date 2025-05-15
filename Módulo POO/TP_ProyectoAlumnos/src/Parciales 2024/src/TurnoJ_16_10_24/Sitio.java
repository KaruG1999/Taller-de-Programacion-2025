/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoJ_16_10_24;

public abstract class Sitio {
    
    private String nombre, direccion;
    private int cantReg; 

    public Sitio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantReg =0;
    }

    // registra usuario
    public void registrarUsuario() {
    this.cantReg++;
    }
    
    // cotizar sitio (dif en ambas subclases)
    public abstract double cotizarSitio ();
    
    // representacion 

    @Override
    public String toString() {
        String aux = "Nombre: " + getNombre() + "; Localidad: " + getDireccion() +
        "; Cantidad de registrados: " + getCantReg() + "; Cotizacion comercial de sitio: " + this.cotizarSitio();
        return aux; 
    }
    
    // get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantReg() {
        return cantReg;
    }

    
    
    
    
    
    
    
    
}
