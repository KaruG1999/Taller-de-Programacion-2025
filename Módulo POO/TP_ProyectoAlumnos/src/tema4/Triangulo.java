/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public class Triangulo extends Figura{
    
    private double lado1, lado2, lado3;

    public Triangulo(double lado1, double lado2, double lado3, String unCR, String unCL) {
        super(unCR, unCL);  // seteo en super clase los colores lines/ relleno
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    
    // implementación metodos abtractos de superClase 
    public double calcularPerimetro(){
        return getLado1()+getLado2()+getLado3();
    }
    public double calcularArea() {
        double s =(this.calcularPerimetro()/ 2);
        //formula 
        return (Math.sqrt(s*(s-getLado1())*(s*getLado2())*(s*getLado3())));
    }
            
    // representación toString

    @Override
    public String toString() {
        return super.toString() + " Lado1: "+getLado3()+" Lado2: "+getLado2()+" Lado3: "+ getLado3(); //To change body of generated methods, choose Tools | Templates.
    }
  
   // métodos getters y setters 

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
   
}

