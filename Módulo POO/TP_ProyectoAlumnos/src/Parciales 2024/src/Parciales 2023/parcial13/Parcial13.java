/*
Estacion: direccion, precio xm3 y la info de sus 6 surtidores.
Surtidos: boolean fuera de servicio, info de ventas (max N).
Venta: dni, cant de m3, monto y medio de pago. 
.Constructor:
Estacion: est para 6 surtidores, a partir de direccion, precio m3 y maximo (V) de ventas por surtidor
Surtidor: en serv, capac d ventas(inic sin ventas) 
Venta:a partir de info nec.
.Metodos: 
-Recibe num de surtidor, dni de cl, cant de m3 y forma de pago, devuelve venta y lo agrega a surtidor corresp
-Dado X marca como fuera de servicio los surtidores que hayan vendido menos que X cantidad 
-Retornar venta con mayor monto abonado 
-String: Estacion de servicio: direccion; precio por m3.
Surtidor 1; si esta fuera de sevicio o no; ventas: [dni cl, cant m3, monto abonado]
.PP
-Instancia una estacion
-Realiza ventas (crea y agrega a estacion)
-Devolver metodos:
.devuelve venta de X numero de servidor 
.pide ingresar X e 
.venta mayor
 */
package parcial13;
import PaqueteLectura.*;
public class Parcial13 {

    public static void main(String[] args) {
        // inic aleat
        GeneradorAleatorio.iniciar();
        //var
        Estacion estacion;
        //Venta vent;
        //crear estacion
        estacion = new Estacion ("Saladillo", 500.0, 50);
        //crea ventas y las agrega a cada surtidor
        estacion.generaVent (1,1,2,"credito");
        estacion.generaVent (1,2,4,"efectivo");
        estacion.generaVent (1,3,6,"debito");
        estacion.generaVent (1,4,8,"credito");
        estacion.generaVent (1,5,10,"efectivo");
        //ingresa X (cant m3) y elimina surtidores que hayan vendido menos que cant ingres 
        estacion.eliminaSurtid (50);
        //retorna venta con mayor monto abonado
        System.out.println(estacion.mayorMonto().toString());
        //imprime toda la info de la estacion 
        System.out.println(estacion.toString());
    }
    
}
