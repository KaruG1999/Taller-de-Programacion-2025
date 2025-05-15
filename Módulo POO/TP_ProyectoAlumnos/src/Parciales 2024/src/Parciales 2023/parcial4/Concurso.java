/*
 */
package parcial4;

class Concurso {

    private int maxPar; //N
    private int cantPar;
    private Pareja [] par; //

    public Concurso(int maxPar) {
        this.maxPar = maxPar;
        this.cantPar=0; //inicializo en 0 la cantidad de parejas 
        this.par = new Pareja[this.maxPar];
        for (int i=0; i< this.maxPar ; i++ ){
            this.getPar()[i] = null; //inicializo contenido de vector en null
        }
    }
    //getters y setters
    public int getMaxPar() {
        return maxPar;
    }

    public void setMaxPar(int maxPar) {
        this.maxPar = maxPar;
    }

    public int getCantPar() {
        return cantPar;
    }

    public void setCantPar(int cantPar) {
        this.cantPar = cantPar;
    }

    private Pareja[] getPar() { //metodo en private????
        return par;
    }

    public void setPar(Pareja[] par) {
        this.par = par;
    }
    // agregar a una pareja al concurso. Asumir que hay lugar
    public void agregoPareja(Pareja par) {
         this.getPar()[this.cantPar++] = par;
    }
    //Obtener/ calcular la diferencia de edad de las parejas 
    public Pareja maxDif () {
        Pareja parmax = new Pareja();
        int maxdif = -1;
        //recorre vector calucalando dif edad y guarda el res en un maximo y a sus participantes
        for (int i= 0; i< this.getCantPar(); i++) {
            if (this.getPar()[i].diferencia() > maxdif) {
                maxdif = this.getPar()[i].diferencia();
                parmax = this.getPar()[i];   
            }
        }
        return parmax;
    }
    //imprimo en concurso los nombres de la pareja del proceso anterior 

    @Override
    public String toString() {
        String aux =" ";
        aux += "Nombres de pareja que tiene más diferencia de edad: " + this.maxDif().toString();
        return aux;
    }
    
    
    
}
