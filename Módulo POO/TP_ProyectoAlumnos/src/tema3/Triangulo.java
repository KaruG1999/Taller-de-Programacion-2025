/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

public class Triangulo {
    // estado (privado)
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorR;
    private String colorL;

    // contructor 
    public Triangulo(double lado1, double lado2, double lado3, String colorR, String colorL) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.colorR = colorR;
        this.colorL = colorL;
    }
    // error comun: lado1=lado1 sin this
    
    // metodos getter y setters 

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public String getColorR() {
        return colorR;
    }

    public void setColorR(String colorR) {
        this.colorR = colorR;
    }

    public String getColorL() {
        return colorL;
    }

    public void setColorL(String colorL) {
        this.colorL = colorL;
    }
    
    // metodo calcular perimetro 
    public double calcularPerimetro () {
        return (lado1 + lado2 + lado3);
    }
    // metodo calcular area
    public double calcularArea ()  {
        double s = this.calcularPerimetro() / 2;
        double area = Math.sqrt( s *(s-lado1)*(s-lado2)*(s-lado3));
        return area;
    }

    
}
