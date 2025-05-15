/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoF_8_10_24;

import PaqueteLectura.*;

public class parcialF {
    public static void main(String[] args) {
        // Crear librería con capacidad para 5 tickets por caja
        Libreria lib = new Libreria("Librería Central", 5);

        // Agregar manualmente algunos tickets
        lib.generarTicket(0, 12345678, 2, 1500.0, "efectivo");
        lib.generarTicket(1, 87654321, 1, 2300.0, "crédito");
        lib.generarTicket(2, 11223344, 3, 3200.0, "débito");

        // Ejecutar métodos
        lib.marcar(2);  // marcar cajas con menos de 2 libros vendidos
        Ticket mayor = lib.mayorMonto();

        // Imprimir ticket de mayor monto
        if (mayor != null) {
            System.out.println("🔎 Ticket con mayor monto:\n" + mayor);
        } else {
            System.out.println("No hay tickets registrados.");
        }

        // Imprimir estado completo de la librería
        System.out.println("\n📚 Estado de la librería:\n" + lib);
    }
}

