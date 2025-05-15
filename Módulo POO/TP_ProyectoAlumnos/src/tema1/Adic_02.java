/*
 2- Queremos organizar libros en una estantería. La estantería tiene 5 estantes, cada uno
tiene espacio para 10 libros. Los libros se organizarán en la estantería según su peso.
Desde el estante superior al inferior irán los libros con peso 1g..299g, 300g..599g, 600g
a 899g, 900g a 1199g, 1200g a 1500g (como se muestra en la figura).
Suponga que los libros pesan menos de 1500g.
a. Declare una estructura adecuada para representar la
estantería, sabiendo que de cada libro sólo se guardará el
título.
b. Lea la información de los libros (título, peso) hasta
ingresar uno con peso 0 y almacénelos en la estantería según
su peso. En caso de existir espacio en el estante adecuado,
ingresar al libro en el primer lugar libre (de manera directa).
Caso contrario informe que no hay lugar para dicho libro.
Nota: el número de estante de un libro se calcula haciendo
e = peso_del_libro / 300. Además, piense en usar una estructura
que para cada estante guarde la cantidad de libros que tiene,
así sabrá cuál es el primer lugar libre de cada estante.
c. Luego de la carga (inciso b), informar para cada estante los títulos de los libros que contiene.
 */
package tema1;

import PaqueteLectura.Lector;

public class Adic_02 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creo biblioteca 
        int dFil =5 , dCol =10;
        String [][] biblioteca = new String[dFil][dCol];  // almacena nomb de libro
        int pesoL;
        String titL;
        int estante;
        
        // matriz guarda dimL para cada estante 
        // int [][] cantL = new int [dFil];
        // vector que para cada estante guarda dimL 
        int [] dimL = new int [dFil];
        for (int i=0; i<dFil; i++) {  //inicializo las dimL en 0
            dimL[i]=0;
        }
        
        System.out.println("Ingresar peso libro (menor a 1500g): ");
        pesoL = Lector.leerInt();
        while (pesoL != 0) {
            // lee tit libro
            System.out.println("Ingresar titulo libro: ");
            titL = Lector.leerString();
            // calculo estante segun el peso
            estante = pesoL / 300;
            //agrego a estanteria
            if (dimL[estante] != 9) {  // si hay espacio en estante agrego de manera directa
                biblioteca [estante][dimL[estante]]= titL;
                dimL[estante]++;        // agrego libro y aumento diml de ese estante 
            } else {
                System.out.println("No hay espacio en el estante");
            }
            
            System.out.println("Ingresar peso libro (menor a 1500g): ");
            pesoL = Lector.leerInt();
             
        }
        
        // falta imprimir 
        
        
    }
    
}
