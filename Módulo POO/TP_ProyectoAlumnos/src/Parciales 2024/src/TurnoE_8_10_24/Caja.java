/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoE_8_10_24;

class Caja {
    
    private String nombCajero;
    private Ticket [] tickets;
    private int df, dl;  // maximo de T tickets 

    public Caja(String nombCajero, int df) {
        this.nombCajero = nombCajero;
        this.df = df;
        this.dl = 0;
        this.tickets = new Ticket[this.df];
    }

    // agrego ticket a caja
    public void agregarTicket(Ticket ticket) {
        if (this.getDl() < this.df) {  // si hay lugar agrego ticket al vector 
            tickets[this.dl] = ticket;
            this.dl++;
        }
    }
    
    // contar cant tickets con formade pago credito
    public int cantTickets () {
        int tot=0;
        for (int i=0; i< this.getDl(); i++) {
            if (tickets[i].getMetodoP().equals("credito")) {
                tot++; // si cumple sumo al total
            }
        }
        return tot;
    }
    
    // repres

    @Override
    public String toString() {
        String aux = getNombCajero() + "; "+ this.getDl() + ": ";
        for (int i=0; i<this.getDl(); i++) {
            aux += "[" + tickets[i].toString() + "]";
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    // get y set 
    
    public int getDl() {
        return dl;
    }
    
    public String getNombCajero() {
        return nombCajero;
    }

    public void setNombCajero(String nombCajero) {
        this.nombCajero = nombCajero;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }

    
    
    
    
    
    
    
    
}
