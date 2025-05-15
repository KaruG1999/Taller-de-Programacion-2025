/*
Realizar un programa que instancie un triángulo, 
le cargue información leída desde teclado 
e informe en consola el perímetro y el área.
 */
package tema3;

import PaqueteLectura.Lector;

public class Ej01 {

    public static void main(String[] args) {
        
        //Ingresa los lados hasta obtener un triangulo valido:
        //cada lado debe ser menor a la suma de los otros dos
        double lado1,lado2,lado3;
        do {
          System.out.println("Ingrese un valor para cada lado");
          lado1 = Lector.leerDouble();
          lado2 = Lector.leerDouble();
          lado3 = Lector.leerDouble();
        } while ( ! ((lado1<lado2+lado3)&&(lado2<lado1+lado3)&&(lado3<lado1+lado2)) );
        
        System.out.println("Ingrese color relleno/color linea");       
        String colorR= Lector.leerString();
        String colorL= Lector.leerString();
        
        //Instancia el triangulo y muestra perimetro y area
        Triangulo t = new Triangulo(lado1,lado2,lado3,colorR,colorL);
        System.out.println("Perimetro " + t.calcularPerimetro());
        System.out.println("Area "      + t.calcularArea());
        
    }
    
}