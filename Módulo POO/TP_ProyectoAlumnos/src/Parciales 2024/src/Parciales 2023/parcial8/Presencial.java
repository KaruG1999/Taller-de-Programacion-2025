
package parcial8;

public class Presencial extends Curso{
    
    private int numAula;

    public Presencial(int numAula, int anio, int maxAlu) {
        super(anio, maxAlu);
        this.numAula = numAula; //??? no seria con get
    }
    //sett y gett 

    public int getNumAula() {
        return numAula;
    }
    
    public void setNumAula(int numAula) {
        this.numAula = numAula;
    }
    //evalua si el alumno puede rendir 
    @Override
    public boolean puedeRendir (Alumno alu) {
        return (alu.getAsistencia() >=3 );
    }
    //
    
}
