
package parcial.a;

public class Alumno {
    
    private int dni;
    private String nombre;
    private int cantAprob;
    private MateriasAprob [] vector;
    private int cantMax;

    public Alumno(int dni, String nombre, int max) {
        this.dni = dni;
        this.nombre = nombre;
        this.cantAprob = 0;  //inicializo mat aprobadas 
        this.cantMax = max;   //dl es 
        this.vector = new MateriasAprob[max]; //creo vecto de materias aprobadas 

    }

    public boolean HayEspacio () {
        return this.cantMax != this.cantAprob; //hay espacio si la cant max es distinto de la cantidad de aprobados 
    }
    
    public void agregarMateria (MateriasAprob mate) {
        if (this.HayEspacio()) {
            this.vector[this.cantAprob++] = mate; //agrego al lugar siguiente la materia ingresada 
        }
        
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "Dni Alumno : " + this.getDni() + "Nombre: " + this.getNombre() + "Materias aprobadas: \n" + this.Concatenador() + "|" + "Es Graduado: " +
                this.esGraduado() + "\n";
        return aux;
    }
    
    
    
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

    public int getCantAprob() {
        return cantAprob;
    }

    public void setCantAprob(int cantAprob) {
        this.cantAprob = cantAprob;
    }

    public MateriasAprob[] getVector() {
        return vector;
    }

    public void setVector(MateriasAprob[] vector) {
        this.vector = vector;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    private boolean esGraduado() {
        int aux=0; 
        String auxS= "Tesis";
        if (this.cantAprob == this.cantMax) { //si las cant de mat alcanza dl
            while (!this.vector[aux].getNombre().equals(auxS) && aux < this.cantAprob){ //mientras el nombre no sea tesis  no llegue al final suma 1
                aux++;
            }
        }
        return !(aux == this.cantAprob); //niega el resultado cuando cant aux es igual a la cant de materias aprob
    }
//imprime vector de materias aprobadas 
    private String Concatenador() {
        int i;
        String aux ="";
        for (i=0; i< this.getCantAprob(); i++){
            aux += " " + this.vector[i].toString();
        }
        return aux;
    }
      
}
