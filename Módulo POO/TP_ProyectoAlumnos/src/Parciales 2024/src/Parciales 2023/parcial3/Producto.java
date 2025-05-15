/*
 */
package parcial3;

class Producto {
    
    private int codigo;
    private double precio;
    private String descripcion;

    public Producto(int codigo, double precio, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    //getters y setters de producto

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //string de producto 

    @Override
    public String toString() {
        return "Codigo =" + this.codigo + "Precio: "  + this.precio + "Descripcion: " + this.descripcion ;
    }
    
    
    
    
    
}
