/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public class Zona {
    
    private String localidad, partido, provincia;

    public Zona(String localidad, String partido, String provincia) {
        this.localidad = localidad;
        this.partido = partido;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Localidad: " + getLocalidad() + ", Partido: " + getPartido() + ", Provincia: " + getProvincia();
    }
    
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
    
}
