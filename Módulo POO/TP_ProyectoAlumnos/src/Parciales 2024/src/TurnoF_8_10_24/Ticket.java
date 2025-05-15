/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoF_8_10_24;

class Ticket {
    
    private int numT;
    private int dniCl;
    private int cantL; // cant de libros comprados
    private double monto;
    private String medioP; // debito, credito o efectivo 

    public Ticket(int numT, int dniCl, int cantL, double monto, String medioP) {
        this.numT = numT;
        this.dniCl = dniCl;
        this.cantL = cantL;
        this.monto = monto;
        this.medioP = medioP;
    }

    @Override
    public String toString() {
        String aux = getNumT()+", "+getDniCl()+", "+getCantL()+
                ", " + getMonto() + ", " + getMedioP();
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getNumT() {
        return numT;
    }

    public void setNumT(int numT) {
        this.numT = numT;
    }

    public int getDniCl() {
        return dniCl;
    }

    public void setDniCl(int dniCl) {
        this.dniCl = dniCl;
    }

    public int getCantL() {
        return cantL;
    }

    public void setCantL(int cantL) {
        this.cantL = cantL;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMedioP() {
        return medioP;
    }

    public void setMedioP(String medioP) {
        this.medioP = medioP;
    }
    
    
    
    
}
