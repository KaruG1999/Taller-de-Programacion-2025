
package TurnoM_16_10_24;

class Alumno {
    
    private int dni, poliza;
    private String nombre, obraS;

    public Alumno(int dni, int poliza, String nombre, String obraS) {
        setDni(dni);
        setNombre(nombre);
        setObraS(obraS);
        setPoliza(poliza);
    }

    @Override
    public String toString() {
        String aux = "Dni alumno: " + getDni() + ", Apellido y nombre: " + getNombre() + 
                ", Póliza: " + getPoliza() + ", Obra social: " + getObraS();
        return aux;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getPoliza() {
        return poliza;
    }

    public void setPoliza(int poliza) {
        this.poliza = poliza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObraS() {
        return obraS;
    }

    public void setObraS(String obraS) {
        this.obraS = obraS;
    }
    
    
    
}
