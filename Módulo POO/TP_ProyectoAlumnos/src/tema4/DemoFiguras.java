/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;


public class DemoFiguras {

    public static void main(String[] args) {
        //instancia cuadrado 
        Cuadrado cuad = new Cuadrado(10,"Rojo", "Negro");
        //imprime color de linea area y toString de cuadrado
        System.out.println("Color linea: " + cuad.getColorLinea()); 
        System.out.println("Area: " + cuad.calcularArea()); 
        System.out.println("Representacion del cuadrado: " + cuad.toString()); 
        //instancia triang y circulo
        Triangulo triang = new Triangulo (10,15,10,"Azul","Verde");
        Circulo circ = new Circulo (5.5, "Rosa", "Violeta");
        //representacion
        System.out.println("Representacion del Triangulo: " + triang.toString());
        System.out.println("Representacion de Circulo: " + circ.toString());
        
        // despinto el Circulo
        circ.despintar();
        System.out.println("Color relleno Circulo: "+ circ.getColorRelleno()+ " color linea: "+ circ.getColorLinea());
    }
    
    
    
}
