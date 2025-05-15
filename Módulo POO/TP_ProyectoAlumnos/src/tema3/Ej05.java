/*
 5-A- Definir una clase para representar círculos. Los círculos se caracterizan por su radio
(double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un círculo, le cargue información leída de teclado e
informe en consola el perímetro y el área.
NOTA: la constante PI es Math.PI
 */
package tema3;

import PaqueteLectura.*;

public class Ej05 {

    public static void main(String[] args) {
        // instancio un circulo
        double radio;
        String colorR, colorL;
        Circulo circulo;
        
        System.out.println("Ingresar radio de circulo: ");
        radio = Lector.leerDouble();
        System.out.println("Ingresar color de relleno: ");
        colorR= Lector.leerString();
        System.out.println("Ingresar color de linea: ");
        colorL = Lector.leerString();
        
        // instancio circulo sin valores
        circulo = new Circulo ();
        // setteo datos
        circulo.setRadio(radio);
        circulo.setColorR(colorR);
        circulo.setColorL(colorL);
        
        // informo perimetro y area
        System.out.println("Perimetro circulo: " + circulo.calcularPerimetro());
        System.out.println("Area circulo: " + circulo.calcularArea());
        
    }
    
}
