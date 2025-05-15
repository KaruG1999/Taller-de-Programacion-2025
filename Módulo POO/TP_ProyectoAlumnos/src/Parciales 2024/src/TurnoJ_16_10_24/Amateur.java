/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoJ_16_10_24;

public class Amateur extends Sitio{
    
    private int cantTorneos, cantClicks;
    

    public Amateur(String nombre, String direccion) {
        super(nombre, direccion);
        setCantClicks(0);
        setCantTorneos(0);

    }
    
    // registar torneo amateur
    public void registarTAmateur (int cantC) {
        this.cantClicks += cantC;  // suma cantidad de clicks y un torneo
        this.cantTorneos++;
    }
    
    
    // cotizar sitio amateur
    public double cotizarSitio () {
        return (10* getCantClicks()) + (50* super.getCantReg());
    }
    
    
    public int getCantTorneos() {
        return cantTorneos;
    }

    public void setCantTorneos(int cantTorneos) {
        this.cantTorneos = cantTorneos;
    }

    public int getCantClicks() {
        return cantClicks;
    }

    public void setCantClicks(int cantClicks) {
        this.cantClicks = cantClicks;
    }
 
    
}
