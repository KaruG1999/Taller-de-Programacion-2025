/*

 */
package parcial3;

class Minorista extends Compra{
    
    private boolean esJubilado;
    
    //constructor con clase super + si es jubilado 

    public Minorista(int numCompra, int maxProd, boolean jub) {
        super(numCompra, maxProd);
        this.esJubilado = jub;
    }
    //getters and setters 

    public boolean isEsJubilado() {
        return esJubilado;
    }

    public void setEsJubilado(boolean esJubilado) {
        this.esJubilado = esJubilado;
    }
    private String verificaJub () {
        String aux=" ";
        if (isEsJubilado()) {
            aux += "Si";
        } else {
            aux+= "No";
        }
        return aux;
    }
    //imprime super clase + boolean jub

    @Override
    public String toString() {
        String aux ="";
        aux+= super.toString() + "Es jubilado: " + this.verificaJub();
        return aux;
    }
    
}
