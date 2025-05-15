/*
 
 */
package parcial3;

class Mayorista extends Compra{
    
    private int cuit;

    //constructor con datos de super clase y cuit

    public Mayorista(int numCompra, int maxProd, int cuit) {
        super(numCompra, maxProd);
        this.cuit = cuit; //set?
    }
    //getters y setters de cuit 

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    //toString de super clase + cuit 
    @Override
    public String toString() {
        String aux="";
        aux += super.toString() + "CUIT DE MAYORISTA: " + this.getCuit();
        return aux;
    }
    
    
}
