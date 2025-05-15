
package tema4;

public class Entrenador extends Empleado{
    
    private int cantCampGanados;

    // constructor
    public Entrenador(int cantCampGanados, String nombre, double sueldoB, int antig) {
        super(nombre, sueldoB, antig);
        this.cantCampGanados = cantCampGanados;
    }
    
    // metodos abtractos superclase 
    public double calcularEfectividad() {
        double prom = this.getCantCampGanados() / this.getAntig();
        return prom;
    }
    public double calcularSueldo() {
        double aux= this.getSueldoB();
        if (getCantCampGanados() >= 1 && getCantCampGanados() <=4) {
            aux += 5000.0;
        } else {
            if (getCantCampGanados() >= 5 && getCantCampGanados() <=10){
                aux += 30.000;
            } else {
                if (getCantCampGanados() > 10) {
                    aux += 50.000;
                }
            }
        }
        return aux;
    }
 
    // representación

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    // get y set
    public int getCantCampGanados() {
        return cantCampGanados;
    }

    public void setCantCampGanados(int cantCampGanados) {
        this.cantCampGanados = cantCampGanados;
    }
    
    
}
