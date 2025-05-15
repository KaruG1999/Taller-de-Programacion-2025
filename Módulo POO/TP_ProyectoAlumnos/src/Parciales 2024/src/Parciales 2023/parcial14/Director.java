package parcial14;

public class Director extends Empleado{
    
    private double viatico;

    public Director( String nombre,int dni, int anioIng, double sueldoBasic ,double viatico ) {
        super(nombre, dni, anioIng, sueldoBasic);
        this.viatico = viatico;
    }

    public double getViatico() {
        return viatico;
    }

    public void setViatico(double viatico) {
        this.viatico = viatico;
    }
   //calcular sueldo
    public double obtenerSueldo (){
        return super.obtenerSueldo() + this.viatico;
    }
    

    
}
