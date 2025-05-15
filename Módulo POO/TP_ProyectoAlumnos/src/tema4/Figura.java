/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

// Figura es clase abstracta (No se puede instanciar un objeto de clase Figura)
public abstract class Figura {
    //caracteristicas comunes entre figuras
    private String colorRelleno;
    private String colorLinea;
   
    //constructor que settea datos por parametro
    public Figura(String unCR, String unCL){
        setColorRelleno(unCR);
        setColorLinea(unCL);
    }
    
    // retorna area de subclase figura y colores linea/ relleno
    public String toString(){
        String aux = "Area: " + this.calcularArea() +  // llamo a resultado de método de subclase
                    "Perimetro: " + this.calcularPerimetro() +
                     " CR: "  + getColorRelleno() + 
                      " CL: " + getColorLinea();             
             return aux;
       }

    
    public String getColorRelleno(){
        return colorRelleno;       
    }
    public void setColorRelleno(String unColor){
        colorRelleno = unColor;       
    }
    public String getColorLinea(){
        return colorLinea;       
    }
    public void setColorLinea(String unColor){
        colorLinea = unColor;       
    }
    // métodos abstractos (Se implementan en subclases de Figura)
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
    //metodo despintar 
    public void despintar (){  // va con o sin comda dentro de parentesis?
        setColorLinea("Negro");
        setColorRelleno("Blanco");
    }
     
}
