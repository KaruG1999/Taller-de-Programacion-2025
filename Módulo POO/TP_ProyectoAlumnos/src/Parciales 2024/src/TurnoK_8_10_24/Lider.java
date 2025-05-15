/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoK_8_10_24;


public class Lider extends Programador{
    
    private int antiguedad;
    private int cantProy;

    public Lider(int antiguedad, int cantProy, String nombre, int dni, double sueldo, int cantH, String lenguaje) {
        super(nombre, dni, sueldo, cantH, lenguaje);
        this.antiguedad = antiguedad;
        this.cantProy = cantProy;
    }
    
    // calcula extra
    public double sueldoAdic () {
        double adic = super.sueldoAdic() + 10000 * this.getAntiguedad() + 20000 * this.getCantProy();
        return adic; 
    }
    
    
    // get y set

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getCantProy() {
        return cantProy;
    }

    public void setCantProy(int cantProy) {
        this.cantProy = cantProy;
    }
    
    
}
