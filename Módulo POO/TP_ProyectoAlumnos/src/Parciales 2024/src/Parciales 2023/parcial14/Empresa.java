/*

 */
package parcial14;

class Empresa {

    private String nombre;
    private String direccion;
    private Director director;
    private int cantSuc;
    private Encargado [] encargados;

    public Empresa(String nombre, String direccion, Director director, int cantSuc) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.director = director;
        this.cantSuc = cantSuc;
        this.encargados = new Encargado[this.cantSuc];
        for (int i =0; i< this.cantSuc; i++) {
            this.encargados[i] =null;
        }
    }
    //agrega encargado en suc x
    public void cargaEmp (Encargado enc, int x) {
        this.encargados[x] = enc;
    }
    //imprimir 
    public String concatenador () {
        String aux= "";
        for (int i=0; i<this.cantSuc; i++){
            if(this.encargados[i] == null) {
                aux += (i+1) +"No hay encargado asignado en: " + "\n";
            } else {
                aux += (i+1) + this.encargados[i].toString() + "\n";
            }  
        }
        return aux; 
    }
    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + this.nombre + ", direccion=" + 
                this.direccion + ", director=" + this.director.toString()+ "Lista de encargados: " +this.concatenador() ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Encargado[] getEncargados() {
        return encargados;
    }

    public void setEncargados(Encargado[] encargados) {
        this.encargados = encargados;
    }
    
    
}
