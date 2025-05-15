
package parcial14;

class Encargado extends Empleado{
    
    private int cantACarg;

    public Encargado( String nombre, int dni, int anioIng, double sueldoBasic, int cantACarg) {
        super(nombre, dni, anioIng, sueldoBasic);
        this.cantACarg = cantACarg;
    }
    //calc sueldo de encargado
    @Override
    public double obtenerSueldo(){
        return super.obtenerSueldo() + (cantACarg *1000);
    }

    public int getCantACarg() {
        return cantACarg;
    }

    public void setCantACarg(int cantACarg) {
        this.cantACarg = cantACarg;
    }
    

    
    
}
