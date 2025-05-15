/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoH_15_10_24;

import PaqueteLectura.*;

public class ParcialH {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        String []vNombres = {"fideo", "arroz", "enlatados", "condimento"};
        String []vMarcas = {"Arcor", "Luchetti", "molto"};
        // instanciar super
        Supermercado superM = new Supermercado("Carrefour", "12 y 58 ", 5, 4);
        //registra prod
        for (int i=0; i<20 ; i++) {
            Producto prod = new Producto(GeneradorAleatorio.generarInt(5000), vNombres[GeneradorAleatorio.generarInt(4)], 
                    vMarcas[GeneradorAleatorio.generarInt(3)], GeneradorAleatorio.generarInt(50), GeneradorAleatorio.generarDouble(5000));
            superM.registrarProd(prod);
        }
        
        //comprobar metodos 
        System.out.println("Lista de productos : " + superM.listarProd(vMarcas[GeneradorAleatorio.generarInt(3)], GeneradorAleatorio.generarInt(5)));
        
        System.out.println("Gondola con mayor cantidad de unidades exhibidas: " + superM.gondolaMax());
        
        System.out.println(superM.toString());
        
    }
    
}
