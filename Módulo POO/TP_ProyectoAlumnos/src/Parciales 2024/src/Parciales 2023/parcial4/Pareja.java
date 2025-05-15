/*
 */
package parcial4;

public class Pareja {
    
    private Participante par1;
    private Participante par2;
    private String estilo;
//constructor pareja 
    public Pareja(Participante par1, Participante par2, String estilo) {
        this.par1 = par1;
        this.par2 = par2;
        this.estilo = estilo;
    }

    Pareja() {
        
    }
    //calcula la diferencia de edad de 2 participantes que son pareja 
    public int diferencia() {
        int dif =0;
        if (this.getPar2().getEdad() > this.getPar1().getEdad()){
            dif += this.getPar2().getEdad() - this.getPar1().getEdad();
        } else {
            dif += ( this.getPar1().getEdad() - this.getPar2().getEdad());
        }
        return dif;
    }
   //imprimir info de la pareja 
    @Override
    public String toString() {
        return "Participante 1=" + this.par1.toString() + ", Participar=" + this.par2.toString();
    }

    public Participante getPar1() {
        return par1;
    }

    public Participante getPar2() {
        return par2;
    }
    
    
}
