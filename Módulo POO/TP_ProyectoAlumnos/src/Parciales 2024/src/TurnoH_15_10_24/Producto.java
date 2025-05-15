/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoH_15_10_24;

public class Producto {
    
    private int codigo;
    private String nombre, marca;
    private int cantU;
    private double precioU;

    public Producto(int codigo, String nombre, String marca, int cantU, double precioU) {
        setCodigo(codigo);
        setNombre(nombre);
        setMarca(marca);
        setCantU(cantU);
        setPrecioU(precioU);
    }

    @Override
    public String toString() {
        String aux = "Producto { " + getCodigo() + "- " + getNombre() + " - " + getMarca() + " - " + getCantU() + 
                " - " + getPrecioU() + "}";
        return aux; 
    }

    
    
    
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantU() {
        return cantU;
    }

    public void setCantU(int cantU) {
        this.cantU = cantU;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }
    
    
    
    
    
    
    
    
    
}
