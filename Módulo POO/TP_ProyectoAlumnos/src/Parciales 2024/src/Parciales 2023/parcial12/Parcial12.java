
package parcial12;
import PaqueteLectura.*;
public class Parcial12 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        //creo conc de 3 categorias y 5 canc por categoria 
        Concurso conc= new Concurso(3,5);
        //cancion (id,nombre, compositor)
        Cancion can1 = new Cancion (1, "nombre", "compositor");
        Cancion can2 = new Cancion (2, "nombre", "compositor");
        Cancion can3 = new Cancion (3, "nombre", "compositor");
        Cancion can4 = new Cancion (4, "nombre", "compositor");
        Cancion can5 = new Cancion (5, "nombre", "compositor");
        //agrego cancion con categoria
        conc.agregoCanc(can1, 1);
        conc.agregoCanc(can2, 1);
        conc.agregoCanc(can3, 2);
        conc.agregoCanc(can4, 0);
        conc.agregoCanc(can5, 2);
        //lee por teclado alumno, id y puntaje 
        int id = GeneradorAleatorio.generarInt(6)+1;
        int cant =0; //controla el while  
        while (id != 0 && cant !=20) { //para si id=0 y cant = 20?
            //creo alumno (nombre, apellido, dni)
            Alumno alu= new Alumno (GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarString(6),
            GeneradorAleatorio.generarInt(333));
            //genero puntaje 
            double puntaje = GeneradorAleatorio.generarDouble(10);
            //agrego alumno, id y puntaje a concierto
            conc.interpretaAlu(id, alu, puntaje);
            //leo prox id
            id = GeneradorAleatorio.generarInt(6)+1;
            cant++; //avanzo
        }
        //ingreso id de cancion y devuelve alumno ganador 
        System.out.println("Ingresa id" + id);
        Alumno ganador = conc.anunciaGan(id);
        //si el ganador no esta vacio imprimo alumno, sino imprimo nadie
        if ( ganador !=null) 
            System.out.println(ganador.toString());
        else
            System.out.println("Nadie");
        //recorre categorias e imprime la cancion con mas puntaje
        for (int i=0; i< 3; i++){
            System.out.println(conc.mejorCancXCatego(i).toString());
        }
        
        
        
    }
    
    
    
}
