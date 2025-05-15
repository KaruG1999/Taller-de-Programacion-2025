/*
Compra es una clase abstracta de la cual desprenden las compras mayoristas y minoristas 
 */
package parcial3;

public abstract class Compra {
    
    private int numCompra;
    private int cantProd;
    private int maxProd;  //N
    private Producto [] vector;
//Contructor se crea con el numero de compra y la cantidad maxima (N)
    public Compra(int numCompra, int maxProd) {
        this.numCompra = numCompra;
        this.cantProd = 0; //inicializo cant de productos en 0
        this.maxProd = maxProd;
        this.vector = new Producto[this.maxProd];
        for (int i=0; i < this.maxProd ; i++) {
            this.getVector()[i] = null; //con get pongo en null los productos en el vector 
        }
    }
//Getters y Setters 

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }

    public int getMaxProd() {
        return maxProd;
    }

    public void setMaxProd(int maxProd) {
        this.maxProd = maxProd;
    }

    public Producto[] getVector() {
        return vector;
    }

    public void setVector(Producto[] vector) {
        this.vector = vector;
    }
    //abstract tiene que tener al menos un metodo abtracto ??
    
    //Agrego producto a la compra 
    public boolean HayEspacio (){
        return this.getCantProd() < this.getMaxProd();
    }
    public void agregaProd (Producto prod){
        if (this.HayEspacio()){
            this.getVector()[this.cantProd++] =prod; //si hay espacio agrego en la siguiente posic el prod ingresado
        }
    }
    //Obtener precio de la compra y sumar un 21% IVA  del total
    public double precioTot (){
        double aux =0;
        for (int i=0; i< this.getCantProd(); i++) {
            aux += this.getVector()[i].getPrecio();
        }
        return aux + (aux*0.21); //al precio total le sumo el total del precio x 0.21(IVA)
    }
    //IMPRIMIR DATOS DE COMPRA 
    public String concatenador (){ //solo imprime datos del vector compras 
        int i;
        String aux=" ";
        for (i=0; i< this.getCantProd(); i++) {
            aux += this.vector[i].toString();
        }
    return aux;
    }
    @Override //imprime codigo de compra, vector de compras, monto total de la compra 
    public String toString() {
        String aux=" ";
        aux += "Codigo de compra: " + this.getNumCompra() + "Lista de productos: " + this.concatenador() + "Precio a pagar: " + this.precioTot();
        return aux;
    }
}
