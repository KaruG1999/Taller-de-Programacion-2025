/*

La temperatura promedio mensual de N años consecutivos a partir de un año A dado

*/


package tema4;


public abstract class Sistema {
    
    private Estacion estacion;  // objeto estación
    private int anioIni;
    private int cantAnios;
    private double [][] sist;  //  sistema con temp dentro

    public Sistema( int anioIni, int cantAnios, Estacion estacion) {
        this.estacion = estacion;
        this.anioIni = anioIni;
        this.cantAnios = cantAnios;
        for (int i=0; i<this.cantAnios; i++) {
            for (int j=0; j<12 ; j++){
                this.sist[i][j] = 100; //inicializo en temperatura alta
            }
        }
    }
    
    // registrar temperaturas 
    public void setTemp (int mes, int anio, double temp){
        sist[anio- getAnioIni()][mes-1] = temp;
    }

    public double getTemp (int mes, int anio ) {
        return sist[anio- getAnioIni()][mes-1];
    }
    
    // get y set

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public int getAnioIni() {
        return anioIni;
    }

    public void setAnioIni(int anioIni) {
        this.anioIni = anioIni;
    }

    public int getCantAnios() {
        return cantAnios;
    }

    public void setCantAnios(int cantAnios) {
        this.cantAnios = cantAnios;
    }
    
    // mayor temp matriz
    public String tempMax () {
        int mesMax = -1, anioM=0;
        double maxT = 1;
        for (int i= anioIni; i<getCantAnios(); i++) {
            for (int j=0; j<12; j++) {
                if (sist[i][j] > maxT) {
                    maxT = sist[i][j];
                    anioM = i;
                    mesMax = j;   
                }
            }
        }
        return "Temperatura max en mes: " + mesMax + " año: " + anioM;   
    }
 
    
    public abstract String retornaMedia ();
    
    // representar 

    @Override
    public String toString() {
        return estacion + "/n" + retornaMedia(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
