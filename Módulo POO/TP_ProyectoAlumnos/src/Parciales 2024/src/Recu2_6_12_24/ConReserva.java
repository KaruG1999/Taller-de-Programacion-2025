
package Recu2_6_12_24;

public class ConReserva extends Obra{
    
    private Butaca [] butacas;
    // N butacas (Cap max N espect en sala)

    public ConReserva(String nombre, String nombDir, int cantAct, int capMax) {
        super(nombre, nombDir, cantAct, capMax);
        this.butacas = new Butaca[capMax];
        
        this.inicB();  // inicializar but sin ocupar 
    }
    
    public void inicB () {
        for (int i=0; i< super.getCapMax(); i++){
            butacas[i] = new Butaca();   // agrego butaca creada a vector de butacas con precio 
            butacas[i].setOcupada(false);
        }
    }
    
    
    // ocupar butaca i
    public boolean ocuparButaca (int i) {
        if (butacas[i].isOcupada() == false) {
            butacas[i].setOcupada(true);
            return true;
        }
        return false;
    }
    
    // desocupar todas las butacas
    public void vaciarObra () {
        for (int i=0; i< super.getCapMax(); i++) {
            if (butacas[i].isOcupada()== true) {
                butacas[i].setOcupada(false);
            }
        }
    }
    
    // total recaud
    public double recaudado() {
        double tot=0;
        for (int i=0; i< super.getCapMax(); i++) {
            if (butacas[i].isOcupada() == true) {
                tot += butacas[i].getPrecio();
            }
        }
        return tot;
    }
    
    
    
}
