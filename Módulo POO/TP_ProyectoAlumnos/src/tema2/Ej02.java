/*
 2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
- Informe la cantidad de personas mayores de 65 años.
- Muestre la representación de la persona con menor DNI.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;

public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // inicial generador aleatorio
        GeneradorAleatorio.iniciar();
        // 
        int df = 15;
        int dl = 0;
        Persona [] vector = new Persona[df]; // vector de a lo sumo 15 personas 
        
        String nomb;  // mejor aca o directamente cuando lo creo?
        int dni;
        int edad;
        
        // cargar vector 
        
        nomb = GeneradorAleatorio.generarString(10);
        System.out.println("Nombre genenerado: "+ nomb);
        dni = GeneradorAleatorio.generarInt(99999999);
        System.out.println("Dni generado: "+ dni);
        edad = GeneradorAleatorio.generarInt(90);
        System.out.println("Edad generada: "+ edad);
        while (dl<df && edad !=0 ){
            // crear persona 
            Persona persona = new Persona (nomb, dni, edad);
            // agrego persona a vector 
            vector[dl] = persona;
            // leo proxima persona 
            nomb = GeneradorAleatorio.generarString(10);
            System.out.println("Nombre genenerado: "+ nomb);
            dni = GeneradorAleatorio.generarInt(99999999);
            System.out.println("Dni generado: "+ dni);
            edad = GeneradorAleatorio.generarInt(90);
            System.out.println("Edad generada: "+ edad);
            // aumento dl
            dl++;
        }
        
        // esta bien primero cargar y despues recorrer ? 
        
        int may65 =0; // contador personas mayor de 65 años
        Persona dniMin = null; // persona dni minimo (esta bien inicializar en null?)
        // int min = 99999999; // dni minimo 
        int min = Integer.MAX_VALUE; // inicializo min en valor maximo
        for (int i=0; i<dl; i++) {
            if ( vector[i].getEdad() > 65 ) {  
                may65++;
            }
            if ( vector[i].getDNI()< min) {
                min = vector[i].getDNI();
                dniMin = vector[i];  // guardo persona almacenada en el "campo" del vector
            }
        }
        
        // imprimo resultados 
        System.out.println("Cantidad de personas mayores a 65: " + may65);
        if (dniMin != null) {
            System.out.println("Persona con menor dni en vector: " + dniMin.toString());
        }
        // error: no poner if si es distinto de null 
        
    }
    
}
