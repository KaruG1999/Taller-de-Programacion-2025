/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recu1_6_12_24;

class Equipo {
    
    private String nombreE, lugarOrig, nombreT; 

    public Equipo(String nombreE, String lugarOrig, String nombreT) {
        setNombreE(nombreE);
        setLugarOrig(lugarOrig);
        setNombreT(nombreT);
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getLugarOrig() {
        return lugarOrig;
    }

    public void setLugarOrig(String lugarOrig) {
        this.lugarOrig = lugarOrig;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }
    
    
    
    
    
}
