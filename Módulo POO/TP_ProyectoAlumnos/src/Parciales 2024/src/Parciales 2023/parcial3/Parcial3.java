
/*
Registrar compras(abstract) que pueden ser mayoristas o minoristas 
-Compras: nro compra / productos comprados (N)
Mayoristas: Compras + cuit comprador
Minoristas: Compras + boolean si es jubilado
-Producto: codigo/ precio / descripcion 
-Metodos: 
.Constructor: 
.Agregar producto pasado por parametro
.Obtener precio de la compra + 21% IVA
.toString
PP
-Instancia compra mayoristas
-Instancia compra minoristas
-Carga 3 compras mayoristas 
-Carga 3 compras minoristas
-Imprime ambas compras 
 */
package parcial3;
import PaqueteLectura.*; 
public class Parcial3 {

    public static void main(String[] args) {
        //inic aleateat
        GeneradorAleatorio.iniciar();
        //creo variables
        Mayorista comp1;
        Minorista comp2;
        Producto prod;
        //creo compra mayorista y minorista (nro compra, cant prod comprados + ..)
        comp1 =new Mayorista (GeneradorAleatorio.generarInt(999),GeneradorAleatorio.generarInt(20),GeneradorAleatorio.generarInt(200));
        comp2 =new Minorista(GeneradorAleatorio.generarInt(999), GeneradorAleatorio.generarInt(20), GeneradorAleatorio.generarBoolean());
        //creo 3 productos y agrego a compra mayorista
        for (int i=0; i<3; i++) {
            prod = new Producto (GeneradorAleatorio.generarInt(30),GeneradorAleatorio.generarDouble(1000), GeneradorAleatorio.generarString(5));
            comp1.agregaProd(prod);
        }
        //creo 3 productos y agrego compra minorista 
        for (int j=0; j<3; j++) {
            prod = new Producto (GeneradorAleatorio.generarInt(30), GeneradorAleatorio.generarDouble(1000),GeneradorAleatorio.generarString(5));
            comp2.agregaProd(prod);
        }
        //imprimir
        System.out.println(comp1.toString());
        System.out.println("---------------------------");
        System.out.println(comp2.toString());
    }
    
}
