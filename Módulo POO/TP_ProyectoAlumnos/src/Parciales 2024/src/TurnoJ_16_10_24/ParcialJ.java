/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoJ_16_10_24;

import PaqueteLectura.*;

public class ParcialJ {

    
    public static void main(String[] args) {
        
    // instancia sitio torneo amateur y profesional
    Amateur sitioAmat = new Amateur("Amateur", "calle 123");
    Profesional sitioProf = new Profesional(20, " Profesional ", "calle 456");
    
    // agrego a sitio amateur
    sitioAmat.registrarUsuario();
    sitioAmat.registrarUsuario();
    sitioAmat.registarTAmateur(15);
    sitioAmat.registarTAmateur(45);
    sitioAmat.registarTAmateur(25);
    
    // agrego a sitio prof
    sitioProf.registrarUsuario();
    sitioProf.registrarUsuario();
    Torneo t = new Torneo("torneo1", "11/10", 8000, 6000);
    sitioProf.registrarTProf(t);
    t = new Torneo("torneo2", "11/11", 10000, 6000);
    sitioProf.registrarTProf(t);
    t = new Torneo("torneo3", "11/12", 15000, 6000);
    sitioProf.registrarTProf(t);
    // comprobar metodos 
    
    System.out.println("Sitio amateur: " + sitioAmat.toString());
    
    System.out.println("Sitio Profesional: " + sitioProf.toString());
        
    }
    
}
