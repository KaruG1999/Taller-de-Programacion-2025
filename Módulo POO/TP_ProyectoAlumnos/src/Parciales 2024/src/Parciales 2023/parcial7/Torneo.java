
package parcial7;

class Torneo {

    private String nombTorneo;
    private Goleador [][] torneo;
    private int [] cantGoleadores; //vector que cuenta cantidad de goleadores por fecha 
    private int fechas; //N
    private int cantGolead; //M 

    public Torneo(String nombTorneo, int fecha, int cantGolead) {
        this.nombTorneo = nombTorneo;
        this.fechas = fecha;
        this.cantGolead = cantGolead;
        this.torneo = new Goleador[fechas][cantGolead];
        this.cantGoleadores  = new int[fecha];
        
        for (int i=0; i< this.fechas ; i++) {
            for (int j =0; j< this.cantGolead; j++){
                this.torneo[i][j] = new Goleador ("Nada", "Ninguno", 0);
            }
        }
    }
    //metodo que agrega goleador a la fecha X 
    public void agregarGolead(Goleador goleador, int fecha) { //fecha o fecha -1 ????
        this.torneo[fecha][this.cantGoleadores[fecha]] = goleador;
        this.cantGoleadores[fecha]++; //actualiza vector qque cuenta cant de goleadores 
    }
//retorna jugador con menos goles en la fecha ingresada 
    public Goleador minGol(int fecha) {
         Goleador golMin = new Goleador("nada", "nada",0);
         int cantMinGoles =999;
         for (int i=0; i < this.cantGoleadores[fecha]; i++) {
             if (this.getTorneo()[fecha][i].getCantGoles() < cantMinGoles ) {
                 cantMinGoles = this.getTorneo()[fecha][i].getCantGoles();
                 golMin = this.getTorneo()[fecha][i];
             }
         }
         return golMin;
    }

    public int totGol() {
        int aux =0;
        for (int i =0; i< this.cantGolead; i++) {
            aux += this.cantGoleadores[i];
        }
        return aux;
    }
    //getters y setters
    public String getNombTorneo() {
        return nombTorneo;
    }

    public void setNombTorneo(String nombTorneo) {
        this.nombTorneo = nombTorneo;
    }

    public Goleador[][] getTorneo() {
        return torneo;
    }

    public void setTorneo(Goleador[][] torneo) {
        this.torneo = torneo;
    }

    public int[] getCantGoleadores() {
        return cantGoleadores;
    }

    public void setCantGoleadores(int[] cantGoleadores) {
        this.cantGoleadores = cantGoleadores;
    }

    public int getFechas() {
        return fechas;
    }

    public void setFechas(int fechas) {
        this.fechas = fechas;
    }

    public int getCantGolead() {
        return cantGolead;
    }

    public void setCantGolead(int cantGolead) {
        this.cantGolead = cantGolead;
    }
    //imprime
    public String concatenador( ) {
        String aux= "";
        for (int i = 0; i< this.fechas ; i++ ) {
            aux += " " + "Fecha #" + (i+1) + "|" + this.cantGoleadores[i] + "Goleadores: ";
            for (int j=0; j< this.cantGolead ; j++) {
                aux += this.torneo[i][j].toString();
            }
        }
        return aux + "\n"; 
    }
    
    @Override
    public String toString() {
        String aux = "";
        aux += "Torneo 2022: " + this.nombTorneo + "\n"  + this.concatenador();
        return aux;
    }

    
    
}
