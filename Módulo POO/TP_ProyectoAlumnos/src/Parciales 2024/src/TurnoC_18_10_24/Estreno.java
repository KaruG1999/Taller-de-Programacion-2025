/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoC_18_10_24;

public class Estreno {
    
    private String titulo;
    private String tipoCont;        // serie o pelicula
    private double recaud;          
    private int cantVis;

    public Estreno(String titulo, String tipoCont, double recaud, int cantVis) {
        setTitulo(titulo);
        setTipoCont(tipoCont);
        setRecaud(recaud);
        setCantVis(cantVis);
    }
   
    // para calcular c, recaudacion div 2 aca y en plataforma sumo todas las recaudaciones de la matriz 
    public double ganancia () {
        return (this.recaud / 2);
    }
    
    @Override
    public String toString() {
        String aux = getTitulo() + ", " + getTipoCont() + ", " + getRecaud() + ", " + getCantVis();
        return aux;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoCont() {
        return tipoCont;
    }

    public void setTipoCont(String tipoCont) {
        this.tipoCont = tipoCont;
    }

    public double getRecaud() {
        return recaud;
    }

    public void setRecaud(double recaud) {
        this.recaud = recaud;
    }

    public int getCantVis() {
        return cantVis;
    }

    public void setCantVis(int cantVis) {
        this.cantVis = cantVis;
    }
    
    
}
