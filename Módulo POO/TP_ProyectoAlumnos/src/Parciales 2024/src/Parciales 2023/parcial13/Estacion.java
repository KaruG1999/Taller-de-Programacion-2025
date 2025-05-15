
package parcial13;

class Estacion {

    private int cantSurt =6;
    private Surtidor [] vectorS;
    private String direccion;
    private double preciom3;
    private int maxVentas;      //(N)
    private int cantVentas;     //(DL)

    public Estacion(String direccion, double preciom3, int maxVentas) {
        this.direccion = direccion;
        this.preciom3 = preciom3;
        this.vectorS = new Surtidor[cantSurt];
        for (int i=0; i< this.maxVentas; i++) {
            this.vectorS[i] = new Surtidor (maxVentas);
        }
    }
    //agrega venta 
    public void generaVent(int nroSurt, int dni, double cantm3, String pago) {
        Venta v= new Venta ( dni, cantm3, (cantm3 * this.preciom3),pago) ; 
        this.vectorS[nroSurt-1].agregaVent(v);
        
    }
   
    //ingresa valor m3 por parametro y el surtidor que tenga menos ventas lo elimina 
    public void eliminaSurtid( int x) {
        for (int j=0; j< this.cantSurt ; j++) {
            this.vectorS[j].actualiza(x);
        }
        
    }
    //Obtener venta de mayor monto abonado de TODA la estacion 
    public Venta mayorMonto() {
        double montoMax =-999;
        Venta aux = null;
        Venta ventMax =null;
        for (int i=0; i<this.cantSurt; i++) {
            aux = this.vectorS[i].mayorMonto(); //recorre vector buscando venta max 
            if (aux != null && aux.getAbonado() > montoMax) { //si 
                montoMax = aux.getAbonado();
                ventMax = aux;
                
            }
        }
     return aux;
    }
    //to string 
    public String concatenador () {
        String aux ="";
        for (int i=0; i< this.cantSurt; i++) {
            aux += "Surtidor " + (i+1) + this.vectorS[i].toString() + "\n";
        }
        return aux;
    }
    @Override
    public String toString() {
        return "Estacion de servicio: " + this.direccion + "; preciom3 =" + this.preciom3 + "\n" + this.concatenador();
    }
    //gett y set

    public Surtidor[] getVectorS() {
        return vectorS;
    }

    public void setVectorS(Surtidor[] vectorS) {
        this.vectorS = vectorS;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPreciom3() {
        return preciom3;
    }

    public void setPreciom3(double preciom3) {
        this.preciom3 = preciom3;
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }
    
    
    
}
