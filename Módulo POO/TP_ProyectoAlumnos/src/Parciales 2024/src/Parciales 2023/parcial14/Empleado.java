
package parcial14;

public abstract class Empleado {
    
    private String nombre;
    private int dni;
    private int anioIng;
    private double sueldoBasic;

    public Empleado(String nombre, int dni, int anioIng, double sueldoBasic) {
        this.nombre = nombre;
        this.dni = dni;
        this.anioIng = anioIng;
        this.sueldoBasic = sueldoBasic;
    }
    //obtiene sueldo de Encargado y de director y le suma 10 % de sueldo si tienen mas de 20 años 
    public double obtenerSueldo (){
        double aux=0.0;
        if ((2023 - anioIng) > 20) {
            aux += this.sueldoBasic * 0.10;
        }
        return aux + this.sueldoBasic;
    }
    //to string 
    @Override
    public String toString() {
        return "Nombre=" + this.nombre + ", dni=" + dni + ", sueldo =" + this.obtenerSueldo();
    }
    //get y set 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getAnioIng() {
        return anioIng;
    }

    public void setAnioIng(int anioIng) {
        this.anioIng = anioIng;
    }

    public double getSueldoBasic() {
        return sueldoBasic;
    }

    public void setSueldoBasic(double sueldoBasic) {
        this.sueldoBasic = sueldoBasic;
    }
    
    
    
    
}
