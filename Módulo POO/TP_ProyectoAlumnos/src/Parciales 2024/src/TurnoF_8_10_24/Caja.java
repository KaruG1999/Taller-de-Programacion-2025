/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoF_8_10_24;

public class Caja {
 
    private boolean disponible;
    private Ticket [] tickets ;
    private int df, dl; // maximo T tickets 

    public Caja(int df) {
        this.disponible = true; // inicalmente disponible
        this.df = df;  
        this.dl=0;
        this.tickets = new Ticket [df]; // inicialmente sin tickets 
    }

    // agregar ticket a caja
    public void agregar (Ticket ticket) {
        if (this.dl < this.df) {
            tickets[this.dl] = ticket;
            this.dl++;
        }
    }
    
    //calcula ticket con mayor monto
    public Ticket mayorMonto () {
        double maxM =-1;
        Ticket maxT = null;
        for (int i=0; i<this.dl; i++) {
            if (tickets[i].getMonto() > maxM) {
                maxM = tickets[i].getMonto();
                maxT = tickets[i];
            }
        }
        return maxT;
    }
    
    //

    @Override
    public String toString() {
        String aux = " ";
        if (this.disponible == true) {
            aux += "Esta disponible; ";
        } else {
            aux += "No esta disponible; ";
        }
        aux += " Tickets emitidos: ";
        for (int i=0; i< this.dl ; i++) {
            aux += "{" + tickets[i].toString() + "}" + "\n";
        }
        
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }

    // total de libros ventidos en caja
    public int totV() {
        int tot=0;
        for (int i=0; i<this.dl; i++) {
            tot += tickets[i].getCantL();
        }
        return tot;
    }
    
    
    
    
    
    
}
