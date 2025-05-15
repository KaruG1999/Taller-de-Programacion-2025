
package TurnoM_16_10_24;

public class Viaje {
    
    private String nombreC, fecha, destino;
    private Minibus miniB1;
    private Minibus miniB2;

    public Viaje(Minibus miniB1, Minibus miniB2, String nombC, String dest, String fecha) {  // acá recibe por parametro el resto de info
        this.miniB1 = miniB1;
        this.miniB2 = miniB2;
        setNombreC(nombC);
        setDestino(dest);
        setFecha(fecha);
    }
    
    
    // agrega alumno al viaje 
    public String agregoAlu (Alumno alu){
        String aux = " ";
        if (miniB1.getDl() > miniB2.getDl()) {
            aux += miniB2.agregarAlu(alu);
        } else {
            aux += miniB1.agregarAlu(alu);
        }
        return aux;
    }
     
    //tot de alumnos entre 2 buses 
    public int totObraS (String x){
        int tot=0;
        tot += miniB1.cantAlumObra(x) + miniB2.cantAlumObra(x);
        return tot;
    }
    
    public int cantAluTot(){
        return miniB1.getDl() + miniB2.getDl();
    }
    
    @Override
    public String toString() {
        String aux = " VIAJE ESCOLAR : Fecha: " + getFecha() + 
                ", Cantidad de alumnos total: " + cantAluTot() + "\n" + 
                " Minibus 1: " + miniB1.toString() + "\n" +
                " Minibus 2: " + miniB2.toString();
        return aux;
    }
    
    // recibo dni y asigno poliza a ese alumno entre dos buses de la misma subclase
    public void asignaPoliza(int dni, int numP) {
        if (!miniB1.asignaPoliza(dni, numP)) {
            miniB2.asignaPoliza(dni,numP);
        }
    }

    
    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
    
    
}
