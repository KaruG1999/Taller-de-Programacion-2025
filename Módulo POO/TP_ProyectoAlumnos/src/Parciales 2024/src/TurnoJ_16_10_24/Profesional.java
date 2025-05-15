/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoJ_16_10_24;

class Profesional extends Sitio{
    
    private Torneo [] sitiosP; 
    private int df, dl;

    public Profesional(int df, String nombre, String direccion) {
        super(nombre, direccion);
        this.dl =0;
        this.df = df;
        this.sitiosP = new Torneo[this.df];  // sitios 

    }

    // registrar torneo profesional
    public boolean registrarTProf (Torneo tProf) {
        if ( this.dl < this.df) {
            sitiosP[this.dl] = tProf;
            this.dl++;
            return true;
        }
        return false;
    }
    
    
    // cotizar sitio
    
    public double cotizarSitio () {
        double tot =0;
        tot += 10000 * this.dl; 
        for (int i=0; i<this.dl; i++) {
            tot += sitiosP[i].recaudado();
        }
        return tot;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }

    public int getDl() {
        return dl;
    }

    
    
    
    
    
    
    
    
    
    
}
