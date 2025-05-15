package tema4;

// extends : subclase de Figura
public class Cuadrado extends Figura{
    
    private double lado;
    
    // constructor cuadrado 
    public Cuadrado(double unLado, String unColorR, String unColorL){
        super(unColorR,unColorL); //settea colores a clase superior
        setLado(unLado);

    } 
    
    public double getLado(){
        return lado;       
    }
  
    public void setLado(double unLado){
        lado=unLado;
    }

    // declaracion de metodos abstractos de la clase super en subclase 
    public double calcularArea(){
       return (getLado()* getLado());
    }
    
    public double calcularPerimetro(){
       return (getLado()*4);
    }
    
    public String toString(){
       String aux = super.toString() +   // trae resto de info de clase super 
                    " Lado: " + getLado();
       return aux;
    }

 
}
