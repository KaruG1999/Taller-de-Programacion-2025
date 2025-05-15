
package parcial15;

class Estacionamiento {
    
    //matriz de Sector x Vehiculo
    private Vehiculo [][] matrizEst;
    private int sectores; //(S)
    private int vehic; //(V)
    private String direccion;
    private double costoXhora;

    public Estacionamiento(String direccion, double costoXhora, int sectores, int vehic) {
        this.sectores = sectores;
        this.vehic = vehic;
        this.direccion = direccion;
        this.costoXhora = costoXhora;
        this.matrizEst = new Vehiculo[this.sectores][this.vehic];
        for (int i=0; i < this.sectores; i++) {
            for (int j=0; j< this.vehic ; j++) {
                this.matrizEst[i][j] = null;
            }
        }
    }
    // agrego vehiculo a en sector s y lugar v

    public void agregaVehic(Vehiculo vehiculo, int s, int v) {
        this.matrizEst[s-1][v-1] = vehiculo; 
    }
    // ingresa una marca de auto y un sector X, elimina todos los vehiculos de esa marca 
    public String eliminaMarca(String marca, int x) {
        String aux ="";
        for (int i=0; i< this.vehic; i++) {
            if ( this.matrizEst[x-1][i] != null && this.matrizEst[x-1][i].getMarca().equals(marca)) {
                aux += this.matrizEst[x-1][i].toString();
                this.matrizEst[x-1][i] = null;
            }
        }
    return aux;//??
    }
//suma montos de todos los vehic registrados guarda max y guarda i 
    public int maxSector() {
        double maxMontoxSec =0.0;
        int secMax = 0;
        double aux;
        for (int i=0; i< this.sectores; i++) {
            aux = 0.0;
            for (int j=0; j< this.vehic; j++) {
                aux += this.matrizEst[i][j].getCantHoras() * this.costoXhora;
            }
            if (aux > maxMontoxSec){
                maxMontoxSec=aux;
                secMax = i+1;
            }
        }
        return secMax;
    }
//to string
    public String verificaOcupado (int i, int j) {
        String aux="";
        if (this.matrizEst[i][j] == null) {
            aux += "Desocupado";
        } else {
            aux += this.matrizEst[i][j].toString();
        }
        return aux;
    }
    
    public String concatenador () {
        String aux="";
        for (int i=0; i< this.sectores; i++){
            aux+= "Sector: " + (i+1); 
            for (int j=0; j< this.vehic; j++) {
                aux += "Lugar: " + (j +1) + verificaOcupado(i,j);
            }
        }
        return aux;
    }
    @Override
    public String toString() {
        return "Estacionamiento{" + "direccion=" + direccion + ", costoXhora=" + costoXhora + "\n" + this.concatenador();
    }
    
    public Vehiculo[][] getMatrizEst() {
        return matrizEst;
    }

    public void setMatrizEst(Vehiculo[][] matrizEst) {
        this.matrizEst = matrizEst;
    }

    public int getSectores() {
        return sectores;
    }

    public void setSectores(int sectores) {
        this.sectores = sectores;
    }

    public int getVehic() {
        return vehic;
    }

    public void setVehic(int vehic) {
        this.vehic = vehic;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getCostoXhora() {
        return costoXhora;
    }

    public void setCostoXhora(double costoXhora) {
        this.costoXhora = costoXhora;
    }
    
    
}
