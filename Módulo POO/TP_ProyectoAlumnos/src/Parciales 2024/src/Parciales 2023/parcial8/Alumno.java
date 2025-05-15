package parcial8;

public class Alumno {
    
    private int dni;
    private String nombre;
    private int asistencia;
    private int cantAutoev;

    public Alumno(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.asistencia = 0;
        this.cantAutoev = 0;
    }
    //incremento asistencia 
    public void incAsistDni () {
        this.asistencia++;
    }
    //incremento autoev
    public void incAutoEv (){
        this.cantAutoev++;
    }
   //set y get

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public int getCantAutoev() {
        return cantAutoev;
    }

    public void setCantAutoev(int cantAutoev) {
        this.cantAutoev = cantAutoev;
    }
    
}
