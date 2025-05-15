
package parcial8;

public abstract class Curso {
    
    private int anio;
    private Alumno [] vectorAlu;
    private int  cantAlu; 
    private int maxAlu; //N

    public Curso(int anio, int maxAlu) {
        this.anio = anio;
        this.maxAlu = maxAlu;
        this.cantAlu = 0;
        this.vectorAlu = new Alumno[maxAlu];
        for (int i =0; i< this.maxAlu; i++) {
            this.vectorAlu[i] = null;
        }
    }
    //metodo abtracto si puede rendir 
    public abstract boolean puedeRendir (Alumno alu);
    //getters y setters 

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Alumno[] getVectorAlu() {
        return vectorAlu;
    }

    public void setVectorAlu(Alumno[] vectorAlu) {
        this.vectorAlu = vectorAlu;
    }

    public int getCantAlu() {
        return cantAlu;
    }

    public void setCantAlu(int cantAlu) {
        this.cantAlu = cantAlu;
    }

    public int getMaxAlu() {
        return maxAlu;
    }

    public void setMaxAlu(int maxAlu) {
        this.maxAlu = maxAlu;
    }
    //agrega alumno 
    public boolean hayEspacio () {
        return this.cantAlu < this.maxAlu;
    }
    
    public boolean agregaAlu (Alumno alu) {
        if (this.hayEspacio()) {
            this.vectorAlu[this.cantAlu++] = alu;
            return true;
        }
        else 
            return false;
    }
    //incrementa asistencia dado un dni
    public boolean incAsist (int dni) {
        int asist=0;
        boolean aux = false;
        while ( (asist != this.cantAlu) && (dni != this.vectorAlu[asist].getDni())); {
            asist++;
        }
        if (asist != this.cantAlu) {
            this.vectorAlu[asist].incAsistDni();
            aux= true;
        }
        return aux;
    }
    //incrementa evaluaciones aprobadas con el ingreso de dni 
    public boolean aproboPrueb (int dni) {
        int aux=0;
        boolean vof = false;
        while ((aux < this.cantAlu) && (dni != this.vectorAlu[aux].getDni())) {
            aux++;
        }
        if (aux != this.cantAlu) {
            this.vectorAlu[aux].incAutoEv();
            vof= true;
        }
        return vof;
    }
    
    public int cantAluRend () {
        int aux =0;
        for (int i=0; i< this.cantAlu; i++) {
            if (this.puedeRendir(this.vectorAlu[i])) {
                aux++;
            }
        }
        return aux;
    }
    
    
    
}
