
package parcial11;

public class Sala {

    private PC [] salas;
    private int cantSalas;

    public Sala( int cantSalas) {
        this.salas = new PC[cantSalas];
        for (int i=0; i<this.cantSalas; i++){
            this.salas[i]= new PC(0);
        }
        this.cantSalas = cantSalas;
        
    }
    public boolean hayEspacio (int n){
        return !this.salas[n].isEstado() && this.salas[n].getConsumo() == 0;
    }
    public void agregoPc(PC pc, int nroSala) {
        if (hayEspacio(nroSala-1)) {
           this.salas[nroSala-1] = pc; 
        }
    }
    public void encenderPcs() {
        int minPc =0;
        double min= 999.0;
        for (int i=0; i< this.cantSalas; i++) {
            if (!(this.salas[i].isEstado()) && (this.salas[i].getConsumo() < min)){
                minPc =i;
                min= this.salas[i].getConsumo();
            }
        }
        this.salas[minPc].encender();
    }
    //string con los num de espacios que tienen las pcs prendidas 
    public String concatenador (){
        int i;
        String aux="";
        for (i=0; i< this.cantSalas; i++) {
            if (this.salas[i].isEstado()){
                aux += "Espacio: " + (i+1) + "\n";
            }
        }
        return aux;
    }
}
