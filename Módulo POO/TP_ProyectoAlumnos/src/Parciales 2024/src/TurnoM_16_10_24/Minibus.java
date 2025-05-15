
package TurnoM_16_10_24;

class Minibus {
    
    private String patente;
    private int capacidad;
    private Alumno [] asignados;
    private int dl;

    public Minibus(int df) {
        setCapacidad(df);
        this.asignados= new Alumno[getCapacidad()];
        this.inicV();
    }
    
    // inicialm sin alumnos 
    public void inicV () {
        for (int i=0; i<getCapacidad(); i++){
            asignados[i] = null;
        }
    }
    
    // agregar alu a minibus 
    public String agregarAlu (Alumno alumno) {
        String patente;
        if (this.dl < this.capacidad) {
            asignados[getDl()] = alumno;
            this.dl++;
            patente = getPatente();
            return patente;
        }
        return "No fue agregado";
    }
    
    // recibo dni y asigno poliza a ese alumno 
    public boolean asignaPoliza(int dni, int nPol) {
        boolean encontre = false;
        int i=0;
        while (i < this.dl && !encontre){   // si no llegue al final y no encontre el dni sigo 
            if (asignados[i].getDni() == dni) {
                asignados[i].setPoliza(nPol);  // seteo un numero de poliza random?
                encontre = true;
            }
            i++;
        }
        return encontre; //
    }
            
    // cant de alumnos con X obra social
    public int cantAlumObra (String x) {
        int cantA =0;
        for (int i=0; i<getDl(); i++) {
            if (asignados[i].getObraS().equals(x)){
                cantA++;
            }
        }
        return cantA;
    }
     
    // representacion 

    @Override
    public String toString() {
        String aux = " Patente:  "+ getPatente() + ", Capacidad: " + getCapacidad();
        for (int i=0; i< getDl(); i++) {
            aux += asignados[i].toString() + "\n";
        }
        return aux;
    }
    

    public int getDl() {
        return dl;
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    
    
    
    
    
    
    
}
