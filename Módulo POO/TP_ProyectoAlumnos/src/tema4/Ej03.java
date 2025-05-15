/*
3-A- Implemente las clases para el siguiente problema. Una garita de seguridad quiere
identificar los distintos tipos de personas que entran a un barrio cerrado. Al barrio pueden
entrar: personas, que se caracterizan por nombre, DNI y edad; y trabajadores, estos son
personas que se caracterizan además por la tarea realizada en el predio.
Implemente constructores, getters y setters para las clases. Además tanto las personas
como los trabajadores deben responder al mensaje toString siguiendo el formato:
▪ Personas “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años”
▪ Trabajadores “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años. Soy
jardinero.”
B- Realice un programa que instancie una persona y un trabajador y muestre la
representación de cada uno en consola.
NOTA: Reutilice la clase Persona (carpeta tema2).
 */
package tema4;

public class Ej03 {

    public static void main(String[] args) {
        // instanciar persona 
        Persona persona = new Persona("Mauro", 11203737, 70);
        Trabajador trabajador = new Trabajador ("Micaela", 11553735, 40, "jardinera");
        
        // imprimir representación
        System.out.println(persona.toString());
        System.out.println(trabajador.toString());
    }
    
}
