/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoA_17_10_24;

public class Restringida extends Sala{
    
    private int contraseña;
    private int cantRechContr;

    public Restringida(int ID, String URL) {
        super(ID, URL);
        this.contraseña = 5; // contraseña de sala 
        this.cantRechContr = 0;
    }
    
    // contraeña correcta 
    public boolean verificaCont (int contraIngresada) {
        return this.contraseña == contraIngresada;
    }
    
    public void agregarPart(Participante part) {
        if (verificaCont(part.getContraIng())) {
            super.agregarPart(part);
        } else {
            this.cantRechContr++;
        }
    }
    
    // reinicia tambien los atributos restantes de subclase
    public void reiniciarSala () {
        super.reiniciarSala();   // esta bien llamar a super?
        setCantRech(0);
    }
    
    // para calcular tasa de admision
    public int total_solicitudes () {
        return super.total_solicitudes() + getCantRechContr();
    }
    
    
    // get y set
    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public int getCantRechContr() {
        return cantRechContr;
    }

    public void setCantRechContr(int cantRechContr) {
        this.cantRechContr = cantRechContr;
    }
    
    
    
    
    
}
