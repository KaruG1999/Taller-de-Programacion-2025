/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoE_8_10_24;

class Ticket {
    
    private int num, cuitCl, cantP;
    private double monto;
    private String metodoP; // efectivo /credito /debito

    public Ticket(int num, int cuitCl, int cantP, double monto, String metodoP) {
        this.num = num;
        this.cuitCl = cuitCl;
        this.cantP = cantP;
        this.monto = monto;
        this.metodoP = metodoP;
    }

    @Override
    public String toString() {
        String aux = getNum() + ", " + getCuitCl() + ", " + getCantP() + ", " + getMonto() +
                ", " + getMetodoP() + "; ";
        return aux; 
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCuitCl() {
        return cuitCl;
    }

    public void setCuitCl(int cuitCl) {
        this.cuitCl = cuitCl;
    }

    public int getCantP() {
        return cantP;
    }

    public void setCantP(int cantP) {
        this.cantP = cantP;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoP() {
        return metodoP;
    }

    public void setMetodoP(String metodoP) {
        this.metodoP = metodoP;
    }
    
    
    
    
    
    
    
}
