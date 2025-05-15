
package parcial11;

class PC {
    
    private boolean estado;
    private double consumo;

    public PC( double consumo) {
        this.estado = false;
        this.consumo = consumo;
    }

    public boolean isEstado() {
        return estado;
    }

    public double getConsumo() {
        return consumo;
    }

    public void encender() {
        this.estado = true;
    }

    
    
}
