
package parcial11;
import PaqueteLectura.*;
public class Parcial11 {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    public static void main(String[] args) {
        // 
        GeneradorAleatorio.iniciar();
        Sala sala = new Sala (5);
        PC pc1 = new PC (GeneradorAleatorio.generarDouble(10));
        PC pc2 = new PC (GeneradorAleatorio.generarDouble(10));
        PC pc3 = new PC (GeneradorAleatorio.generarDouble(10));
        sala.agregoPc (pc1,2);
        sala.agregoPc (pc2,3);
        sala.agregoPc (pc3,4);
        
        sala.encenderPcs();
        
        System.out.println(sala.toString());
        
    }   
   
    
}
