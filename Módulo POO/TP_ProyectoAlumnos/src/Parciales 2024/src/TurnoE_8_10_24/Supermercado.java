/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoE_8_10_24;


public class Supermercado {
    
    private String direccion;
    private int ventaAct;
    private Caja [] cajas;
    private int df = 5;
    private int dl; // a lo sumo 5 cajas 

    public Supermercado(String direccion) {
        this.direccion = direccion;
        this.ventaAct =0;
        this.cajas = new Caja[this.df];  // inicialmente sin cajas 
    }
    
    // agrega caja a supermercado 
    public void agregarCaja (Caja caja) {
        if (this.getDl() < this.getDf()){  // si hay espacio agrego caja a vector
            cajas[this.dl] = caja;
            this.dl++;
        }
    }
    
    // dado num caja, cuitcl, cantprod, monto y forma de pago, generar ticket y agregarlo a dicha caja 
    public void generarTicket (int N, int cuit, int cantP, double monto, String formaP) {
        Ticket ticket = new Ticket (this.ventaAct, cuit, cantP, monto, formaP); // instancio ticket
        this.ventaAct++; // aumento numero ticket
        cajas[N].agregarTicket(ticket); // agrego ticket a numero de caja  
    }

    //numero de caja que emitio menos tickets con forma de pago credito
    public int cajaMin () {
        int cantMin = Integer.MAX_VALUE;
        int cajaMin = 6;  
        for (int i =0; i< this.getDl(); i++) {
            if (cajas[i] != null && cajas[i].cantTickets() < cantMin) {
                cantMin = cajas[i].cantTickets();
                cajaMin = i;
            }
        }
        return cajaMin;
    }
    
    // represenacion

    @Override
    public String toString() {
        String aux = "Supermercado: " + getDireccion() + "; Cantidad de cajas: " + getDl() + "\n";
        for (int i =0; i<this.getDl(); i++) {
            aux += "Caja " + i + ":" + cajas[i] + "\n";
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getVentaAct() {
        return ventaAct;
    }

    public int getDl() {
        return dl;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }
    
    
    
    
    
}
