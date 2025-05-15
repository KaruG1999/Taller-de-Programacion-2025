
package parcial5;

class Sistema {
    
    private Paciente [][] sist;
    private int cantDias = 5;
    private int cantTurnos = 6;

    public Sistema() {
        this.sist = new Paciente[cantDias][cantTurnos]; //creo matriz 
        for (int i=0; i< this.cantDias ; i++) {
            for (int j=0; j<this.cantTurnos; j++){
                this.sist[i][j] = null;
            }
        }
    }
    //registro/ ingreso de paciente con su dia y horario 
    public void registroPac (Paciente pac,int d, int h) { 
        this.getSist()[d][h] = pac; 
    }
    //libero pacientes del dia ingresado D (recorro matriz buscando el dia indicado y pongo en null
    public String liberoDia (int d) {
        String aux = " ";
        int j;
        for (j=0; j< this.cantTurnos; j++) {
            if ( this.getSist()[d][j] != null) {
                aux += this.getSist()[d][j].getNombre() + " " ; //duardo el nombre de ese campo 
                this.getSist()[d][j]= null; //pongo en null ese dia (borro turnos )
            }
        }
        return aux + "perderan su turno";
    }
    //metodo que devuelta double con tot de ganancias de toda las semana 
    public double gananciaSem () {
        double tot=0.0;
        for (int i =0; i< this.cantDias ; i++){
            for (int j =0; j< this.cantTurnos; j++) {
                if (this.getSist()[i][j] != null) { //si el horario no esta libre sumo ganancia 
                    tot += this.getSist()[i][j].getCostoSes();
                }
            }
        }
        return tot;
    }
    //imprimir?
    
    //getters y setters 

    public Paciente[][] getSist() {
        return sist;
    }

    public void setSist(Paciente[][] sist) {
        this.sist = sist;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getCantTurnos() {
        return cantTurnos;
    }

    public void setCantTurnos(int cantTurnos) {
        this.cantTurnos = cantTurnos;
    }

    
    
    
    
    
    
}
