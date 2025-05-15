
package tema4;

public class Persona {
    private String nombre;   // atributos de la clase 
    private int DNI;
    private int edad; 
    
    public Persona(String unNombre, int unDNI, int unaEdad){   //constructor 
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad; 
    }
    
    public Persona(){   // constructor sin asignaciones (crea vacio)
     
    }

    // comportamientos ligados a la clase 
    
    public int getDNI() {   //retorna el valor almacenado en la variable 
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int unDNI) {   //modifica la variable y le da el valor pasado por parametro
        DNI = unDNI;
    }

    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    
    public String toString(){   //imprime info de "los campos" de la clase 
        String aux; 
        aux = "Mi nombre es " + nombre + ", mi DNI es " + DNI + " y tengo " + edad + " años.";
        return aux;
    }
    
    
}

