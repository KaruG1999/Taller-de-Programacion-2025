
package tema3;


public class Circulo {
    
    private double radio;
    private String colorR, colorL;

    public Circulo(double radio, String colorR, String colorL) {
        this.radio = radio;
        this.colorR = colorR;
        this.colorL = colorL;
    }
    
    public Circulo () {
        
    }
    
    // calculo perimetro y area 
    public double calcularPerimetro () {
        return (2 * Math.PI * radio);        // Perimetro = 2* pi * radio
    }
    public double calcularArea () {
        return (Math.PI * (radio * radio));  // Area = pi * (r)^2
    }
    
    // metodos get y set

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
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
    
}
