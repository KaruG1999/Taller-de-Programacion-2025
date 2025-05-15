
package Recu2_6_12_24;

public class SinReserva extends Obra{
    
    private int cantEnt;
    private double precioE;

    public SinReserva(int cantEnt, double precioE, String nombre, String nombDir, int cantAct, int capMax) {
        super(nombre, nombDir, cantAct, capMax);
        setCantEnt(cantEnt);
        setPrecioE(precioE);
    }

    // vaciar obra
    public void vaciarObra () {
        setCantEnt(0);
    }
    
    // recaudacion total
    public double recaudado() {
        return this.getCantAct() * this.getPrecioE();
    }
    
    
    public int getCantEnt() {
        return cantEnt;
    }

    public void setCantEnt(int cantEnt) {
        this.cantEnt = cantEnt;
    }

    public double getPrecioE() {
        return precioE;
    }

    public void setPrecioE(double precioE) {
        this.precioE = precioE;
    }
    
    
    
}
