
package parcial6;

public class Sistema {

    private Paciente [][] sist;
    private int dias=5;
    private int turnos=6;
    //constructor que se crea sin pacientes cargados ( null)
    public Sistema() {
        this.sist = new Paciente[this.dias][this.turnos];
        for (int i=0; i< this.dias; i++) {
            for (int j=0; j<this.turnos; j++) {
                this.sist[i][j] = null;
            }
        }
    }
    //agendo Pac pasado por parametro junto con el dia D y Horario
    public void agendoPac(Paciente pac, int d, int h) {
        this.sist[d][h] = pac;
    }
// pasa por parametro el nombre del paciente y libera todos sus turnos 
    public void liberaTurn(String nomb) {
        for (int i=0; i < this.dias ; i++) {
            for (int j=0; j< this.turnos ; j++) {
                if (this.getSist()[i][j] != null && this.getSist()[i][j].getNombre().equals(nomb))
                    this.getSist()[i][j] = null; //no seria set sist??
             }
        
        }
    }
//recibe dia D y nombre de paciente y devuelva verdadero o falso si tiene cita ese dia 
    public boolean tieneTurno(int dia, String nomb) {
        boolean aux = false;
        for (int i =0; i<this.dias; i++) {
            if (this.getSist()[dia][i] !=null && this.getSist()[dia][i].getNombre().equals(nomb))
                aux= true;
            else i++;
        }
        return aux;
    }
     //getters y setters   

    public Paciente[][] getSist() {
        return sist;
    }

    public void setSist(Paciente[][] sist) {
        this.sist = sist;
    }

    public int getDias() {
        return dias;
    }
    //setDias y setTurnos no necesita seteo ya que le asigno manualmente 
    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }
    

    
}
