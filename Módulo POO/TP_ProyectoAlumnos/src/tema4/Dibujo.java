/*

 */
package tema4;

public class Dibujo {
    
    private String titulo;
    private Figura [] vector;   // instancio vector de figuras
    private int guardadas;   //dl vector
    private int capacidadMaxima = 10;  // df vector

    public Dibujo(String nombre) {  // inicia el dibujo sin figuras 
        setTitulo(titulo);
        setGuardadas(0);  // diml inicializada en 0
        this.vector = new Figura[this.capacidadMaxima];
        for (int i=0; i<capacidadMaxima; i++){
            vector[i] = null;
        }
    }
    // agrega figura a vector
    public void agregar (Figura f) {
        if (this.getGuardadas() < this.getCapacidadMaxima()) {
            vector[getGuardadas()] = f;
            guardadas++;
            System.out.println("La figura" + f.toString() + "se guardó");
        } else {
            System.out.println("No se pudo agregar");
        }
    }
    
    //calcular area de dibujo (suma de todas las areas)
    public double calcularAreaTot() {
        double area= 0;
        for (int i=0; i<getGuardadas(); i++) {
            area += vector[i].calcularArea();
        }
        return area;
    }
    
    //imprime 
    
    public void mostrar () {
        String aux = " ";
        for (int i=0; i<getGuardadas(); i++) {
            aux += "Titulo de figura: "+ getTitulo() +
             " Representacion: " + vector[i].toString();
        }
        aux += " Area de dibujo: " + calcularAreaTot() + "/n";
    }
    
    // get y set

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getGuardadas() {
        return guardadas;
    }

    public void setGuardadas(int guardadas) {
        this.guardadas = guardadas;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    
    
}
