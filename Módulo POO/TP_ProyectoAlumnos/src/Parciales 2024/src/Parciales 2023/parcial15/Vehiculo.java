/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial15;

public class Vehiculo {
    
    private String patente;
    private int cantHoras;
    private String marca;
    private String modelo;

    public Vehiculo(String patente, int cantHoras, String marca, String modelo) {
        this.patente = patente;
        this.cantHoras = cantHoras;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;    
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    // to string 

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + this.patente + ", cantHoras=" + this.cantHoras + ", marca=" + this.marca + ", modelo=" + this.modelo + '}';
    }
    
    
    
}
