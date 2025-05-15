/*
Se dispone de la clase Persona (en la carpeta tema2). 
Un objeto persona puede crearse sin valores iniciales o enviando en el mensaje de creación el nombre, DNI y edad (en ese orden).
Un objeto persona responde a los siguientes mensajes:
getNombre()  retorna el nombre (String) de la persona
getDNI()     retorna el dni (int) de la persona
getEdad()    retorna la edad (int) de la persona
setNombre(X) modifica el nombre de la persona al “String” pasado por parámetro (X)
setDNI(X)    modifica el DNI de la persona al “int” pasado por parámetro (X)
setEdad(X)   modifica la edad de la persona al “int” pasado por parámetro (X)
toString()   retorna un String que representa al objeto. Ej: “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años”

Realice un programa que cree un objeto persona con datos leídos desde teclado. 
Luego muestre en consola la representación de ese objeto en formato String.
 */
package tema2;

import PaqueteLectura.Lector;

public class Ej01Unapersona_resuelto {

    public static void main(String[] args) {
        
        System.out.println("Ingrese nombre, dni y edad");
        String nombre = Lector.leerString();
        int dni = Lector.leerInt();
        int edad= Lector.leerInt();
        
        //Opcion 1
        Persona p1 = new Persona(); //Instancio el objeto sin valores iniciales
        p1.setNombre(nombre);       //Luego, seteo los datos enviando mensajes set
        p1.setDNI(dni);
        p1.setEdad(edad);
        System.out.println(p1.toString());
        
        //Opcion 2
        Persona p2 = new Persona(nombre, dni, edad); //Instancio el objeto enviando valores iniciales
        System.out.println(p2.toString());
        
        //Opcion 3
        //Persona p2 = new Persona(Lector.leerString(), Lector.leerInt(), Lector.leerInt()); //Instancio el objeto enviando valores iniciales
        
    }
    
}
