
package parcial.a;

class DeDoc extends Alumno{

    private String titulo;
    private String uniOrigen;

    public DeDoc(int dni, String nombre, int max, String titulo, String uniOrigen) {
        super(dni, nombre, max);
        this.titulo = titulo;
        this.uniOrigen = uniOrigen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniOrigen() {
        return uniOrigen;
    }

    public void setUniOrigen(String uniOrigen) {
        this.uniOrigen = uniOrigen;
    }

    @Override
    public String toString() {
        String aux= " ";
        aux += super.toString() + "Titulo: " + this.getTitulo() + "Universidad de origen: " + this.getUniOrigen();
        return aux;
    }
    
}
