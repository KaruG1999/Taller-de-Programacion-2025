/*
 
 */
package parcial2;

public class Alumno {
    
    private String nombAlu;
    private int edad;
    private String instrumento;
    private double puntaje;
    //constructor donde paso 3 parametros e inicio puntaje en -1
    public Alumno(String nomb, int edad, String inst) {
        this.edad = edad;
        this.nombAlu = nomb;
        this.instrumento = inst;
        this.puntaje = -1;
    }
    //Getters y setters 

    public String getNombAlu() {
        return nombAlu;
    }

    public void setNombAlu(String nombAlu) {
        this.nombAlu = nombAlu;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    //toString del alumno 
    @Override
    public String toString() {
        return "Alumno{" + "nombAlu=" + this.getNombAlu() + ", edad=" + this.getEdad() + ", instrumento=" + this.getInstrumento() + ", puntaje=" + this.getPuntaje() + '}';
    }
    
}
