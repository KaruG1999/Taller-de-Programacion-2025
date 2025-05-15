
package parcial13;

class Surtidor {
    
    private boolean fueraServ;
    private Venta[] ventas;
    private int cantVent =0;
    private int cantMax ;

    public Surtidor(int cantMax) {
        this.fueraServ = true;
        this.cantMax= cantMax;
        this.ventas = new Venta[cantMax];
        for (int i=0; i< this.cantMax; i++) {
            this.ventas[i]=null;
        }
    }
    //si hay espacio agrega venta
    public void agregaVent (Venta v){
        if (this.cantVent > this.cantMax){
            this.ventas[this.cantVent++] = v;
        
        }
    }
//elimina el surtidor que tenga menor cant de x c3 vendida 
    public int calcCant (){
        int cant=0;
        for (int i=0; i< this.cantVent; i++){
            cant += this.ventas[i].getCantm3();
        }
        return cant;
    }
    public void actualiza (int x){
        if (this.calcCant() > x) {
            this.fueraServ = false;
        }
        
    }
    //calcular maximo monto de venta de todas las ventas 
    public Venta mayorMonto (){
        double max = -1;
        Venta aux = null;
        for (int i=0; i< this.cantVent; i++){ 
            if (this.ventas[i].getAbonado() > max){ //si el monto de venta es mayor
                max = this.ventas[i].getAbonado();
                aux = this.ventas[i];
            }
        }
        return aux;
    }
    
    //Verifica si el surtidor esta en servicio o no  para imprimir
    public String verificarServ (){
        if(this.fueraServ) {
            return "Esta en servicio";
        } else
            return "Esta fuera de servicio";
            
    }
    //imprimir 
    public String concatenador (){
        String aux="";
        for (int i=0; i< cantVent; i++ ){ //recorro las ventas dentro de un surtidor 
            aux += "|" + this.ventas[i].toString() + "|"; //imprimo venta
        }
        return aux;
    }
    @Override
    public String toString() {
        String aux = this.verificarServ() + "Ventas: " + this.concatenador(); //imprime si esta habil el surtidor 
        return aux;
    }
    
    //get y set

    public boolean isFueraServ() {
        return fueraServ;
    }

    public void setFueraServ(boolean fueraServ) {
        this.fueraServ = fueraServ;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public void setVentas(Venta[] ventas) {
        this.ventas = ventas;
    }

}    
     
