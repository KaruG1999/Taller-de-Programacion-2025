/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoK_8_10_24;

public class Empresa {
    
    private String nombre;
    private Lider lider;                  // programador lider 
    private Programador [] programadores; // lista de programadores  
    private int dl, df;

    public Empresa(String nombre, Lider lider, int df) {
        this.nombre = nombre;
        this.lider = lider;
        this.df = df;
        this.dl = 0;
        this.programadores = new Programador[this.df];  
      
    }

    // agrega programadores a la empresa 
    public void agregarProg (Programador prog) {
        if (this.getDl()<this.df) {
            programadores[this.dl] = prog;
            this.dl++;
        }
    }
    
    // monto total de sueldos a abonar por empresa 
    
    public double totalSueldos() {
        double tot = lider.sueldoAdic();
        for (int i=0; i < getDl(); i++) {
            tot += programadores[i].sueldoAdic();
        }
        return tot;
    }
    
    // dado un monto M aumentar sueldo basico de todos (incluido lider)
    public void aumentaSueldo (double M) {
        lider.aumentoSueldo(M);
        for (int i=0; i<getDl(); i++) {
            programadores[i].aumentoSueldo(M);
        }
    }
    
    // representacion 

    @Override
    public String toString() {
        String aux = "Empresa: " + getNombre() + "\n"
              + " Programador lider: " + this.lider.toString() + "\n";
        for (int i =0; i<getDl(); i++) {
            aux += "Programador " +i+ ":" + programadores[i].toString() + "\n";
        }      
        aux += "Monto total de sueldos a abonar: " + this.totalSueldos();
        return aux; 
    }
    
    
    
    // get y set 
    
    public int getDl() {
        return dl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lider getLider() {
        return lider;
    }

    public void setLider(Lider lider) {
        this.lider = lider;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }
    
    
                                                                                                                                                                                                                                                                                                                                                                                        
            
            
}
