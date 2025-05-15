/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoK_8_10_24;

import PaqueteLectura.*;

public class parcialk {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // intancia empresa
        Lider lider = new Lider (GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarString(5), 
                GeneradorAleatorio.generarInt(9999999), GeneradorAleatorio.generarDouble(200), GeneradorAleatorio.generarInt(8), 
                GeneradorAleatorio.generarString(10));
        Empresa empresa = new Empresa ("nombreE",lider,10);
        // agregar programadores a empresa 
        for (int i =0; i<6; i++) {
            Programador prog = new Programador (GeneradorAleatorio.generarString(10), GeneradorAleatorio.generarInt(999999), 
                    GeneradorAleatorio.generarDouble(20000), GeneradorAleatorio.generarInt(400), GeneradorAleatorio.generarString(10));
            empresa.agregarProg(prog);
            
        }
        // aumentar sueldo de progr
        empresa.aumentaSueldo(100);
        // mostrar representación
        System.out.println(empresa.toString());
       
        
    }
    
}
