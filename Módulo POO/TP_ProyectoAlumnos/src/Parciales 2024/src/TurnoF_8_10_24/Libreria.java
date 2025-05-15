/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoF_8_10_24;

public class Libreria {
    
    private String nombre;
    private int ventaAct;
    private Caja [] cajas;
    private int df = 4;
    

    public Libreria(String nombre, int T) {
        this.nombre = nombre;
        this.ventaAct = 0;
        this.cajas = new Caja[this.df]; // 4 cajas
        for (int i=0; i<this.df; i++) {
            cajas[i] = new Caja (T); // a cada caja le paso el max de tickets
        }
    }
    
    // dado num caja, dnicl, cant libros comprada, un monto y forma pago 
    public void generarTicket (int N, int dni, int cantL, double monto, String formaP) {
        Ticket ticket = new Ticket (this.ventaAct, dni, cantL, monto, formaP);  // instancio ticket
        if (N>=0 && N<3) {
            cajas[N].agregar(ticket);  // agrego a numero de caja 
            this.ventaAct++;   // aumento venta act (num tickets)
        }
        
    }
    
    
    // dado num X, marcar no dispo aquellas cajas que vendieron menos libros que X en total
    public void marcar (int x) {
        for (int i=0; i<this.df; i++){
            if (cajas[i].totV() < x) {
                cajas[i].setDisponible(false);
            }
        }
    }
    
    
    
    // ticket con mayor monto
    public Ticket mayorMonto () {
        double maxM =-1;
        Ticket maxT = null;
        for (int i=0; i< getDf(); i++) {
            Ticket t= cajas[i].mayorMonto();
            if ( t != null && t.getMonto() > maxM) {
                maxM = cajas[i].mayorMonto().getMonto();
                maxT = cajas[i].mayorMonto();
            }   
        }
        return maxT;
    }

    // repres

    @Override
    public String toString() {
        String aux = "Libreria :" + getNombre() + "\n";
        for (int i=0; i<getDf(); i++) {
            aux += "Caja "+i+" : " + cajas[i] + "\n";
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVentaAct() {
        return ventaAct;
    }

    public void setVentaAct(int ventaAct) {
        this.ventaAct = ventaAct;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }
    
    
    
    
    
}
