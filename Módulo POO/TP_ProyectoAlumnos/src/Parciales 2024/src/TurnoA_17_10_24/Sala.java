/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoA_17_10_24;

public class Sala {
    
    private int ID;
    private String URL;
    private Participante [] conectados;
    private int df, dl;
    private int cantRech;

    public Sala(int ID, String URL) {
        this.ID = ID;
        this.URL = URL;
        this.df = 300; // a lo sumo 300 participantes
        this.dl = 0;
        this.cantRech = 0;
        this.conectados = new Participante[this.df];
        // aca inicializo todo en null o doy por hecho que lo hace Java?
    }
    
    
    // agregar participante a sala 
    public boolean hayLugar () {
        return this.getDl() < this.getDf();
    }
    
    public void agregarPart (Participante part) {
        if (hayLugar()) {
            conectados[this.dl] = part;
            this.dl++;
        } else {
            this.cantRech++;
        }
    }

    // reinicia sala 
    
    public void reiniciarSala () {
        for (int i =0; i<getDl(); i++) {
            conectados[i] = null;  // vuelve a estar vacia
        }
        setCantRech(0);
        this.dl =0; 
    }
    
    //calcular tasa de admision
    public int total_solicitudes() {
        return getDl()+ getCantRech();
    }
    
     public int tasaAdmision() {
        int adm = -1; 
        if (this.total_solicitudes() != 0) {
            adm= 100 * (getDl() / this.total_solicitudes());
        }
        return adm;
        
        
    }
    
    
   
    
    // represnetacion

    @Override
    public String toString() {
        String aux = "ID: " + getID() + ", URL: " + getURL() + "\n";
        for (int i =0; i< getDl(); i++){
            aux += conectados[i].toString() + "\n";
        }
        aux += " Tasa de admision: " + this.tasaAdmision();
        return aux;
    }
    
    
    // get y set 
    
    public int getDl() {
        return dl;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }

    public int getCantRech() {
        return cantRech;
    }

    public void setCantRech(int cantRech) {
        this.cantRech = cantRech;
    }
    
    
    
    
    
}
