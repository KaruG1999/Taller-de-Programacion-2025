
package parcial.a;

class DeGrado extends Alumno{
    
    private String carrera;

    public DeGrado(int dni, String nombre, int max, String carrera) {
        super(dni, nombre, max);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        String aux =" ";
        aux += super.toString() + " Carrera: " + this.getCarrera() + "|" ;
        return aux;
    }

    
    
}
