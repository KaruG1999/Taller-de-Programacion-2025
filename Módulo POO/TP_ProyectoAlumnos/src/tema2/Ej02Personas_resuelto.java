/*
Utilizando la clase Persona. 
Realice un programa que almacene en un vector a lo sumo 15 personas. 
La información (nombre, DNI, edad) se debe generar aleatoriamente hasta obtener edad 0. 
Luego de almacenar la información:
- Informe la cantidad de personas mayores de 65 años. 
- Muestre la representación de la persona con menor DNI.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;

public class Ej02Personas_resuelto {

    public static void main(String[] args) {
        /*Declaración del vector*/
        final int DF = 15;
        Persona[] vector=new Persona[DF]; // reserva espacio para el vector 
        int diml=0;
        
        /*Carga del vector*/
        GeneradorAleatorio.iniciar();
        String nombre;
        int edad,dni;
        edad=GeneradorAleatorio.generarInt(100); //0..99
        while((edad!=0)&&(diml<DF)){
            nombre=GeneradorAleatorio.generarString(10);
            dni=GeneradorAleatorio.generarInt(150000);
            vector[diml]= new Persona(nombre,dni,edad); //instacio el objeto y agrego atrás
            diml++;
            edad=GeneradorAleatorio.generarInt(100); //0..99
        }
        // error comun: cargar una sola persona (antes while declaro 1 objeto y dentro no puedo setear multiples objetos)
        // otro error: vector[diml].setNombre (..) null pointer exception 
        /*Calculo sobre el vector*/
        int cantMayor65=0;
        Persona pmin=null; int dnimin  =999999;
        
        for(int i=0; i<diml; i++){
            System.out.println(vector[i].toString());   // Descomente para ver la info en el vector
            if(vector[i].getEdad()>65){      //Inciso a
                cantMayor65++;
            } 
            if(vector[i].getDNI()< dnimin){  //Inciso b
               dnimin= vector[i].getDNI();
               pmin  = vector[i];
            }
        }
        System.out.println("La cantidad de personas mayores a 65 son: "+cantMayor65);
        if (pmin != null) System.out.println(pmin.toString());
        else  System.out.println("El vector estaba vacio");
    }
}
