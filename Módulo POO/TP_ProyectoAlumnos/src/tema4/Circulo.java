/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import javax.swing.plaf.basic.BasicBorders;

public class Circulo extends Figura{
    
    private double radio;

    public Circulo(double radio, String unCR, String unCL) {
        super(unCR, unCL);
        this.radio = radio;
    }
    
    //calcular perimetro y area 
    public double calcularPerimetro(){
        return 2* Math.PI * getRadio();
    }
 
    public double calcularArea() {
        return Math.PI * Math.pow(getRadio(), 2);
    }
    
    //

    @Override
    public String toString() {
        return super.toString() + " Radio: " + getRadio(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //get y set

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
}
