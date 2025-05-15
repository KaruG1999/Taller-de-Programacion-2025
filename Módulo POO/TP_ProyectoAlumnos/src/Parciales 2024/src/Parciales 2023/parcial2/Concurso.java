/*
Concurso es es una matriz donde I es la cantidad de generos musicales 
y J es la cantidad de alumnos (N) por cada genero
- Constructor : iniciar concurso sin alumnos 
- Getters y Setters 
- toString (imprime matriz)
- Metodos:
    
    .Inscribir alumno dado el alumno y genero 
    .Asignar puntaje dado el puntaje y nombre de alumno
    .Calcula el genero con más cantidad de Alumnos
 */
package parcial2;

public class Concurso {
    
    private Alumno [][] matriz;
    private int [] contAlumns; //vector contador de alumnos por genero 
    
    //int genero;
    //double puntaje;
    //int cantPorGenero;
    
    //crea un concurso con el parametro N( cant de alumnos por genero)
    public Concurso(int n) {
        matriz = new Alumno[5][n];
        contAlumns = new int [5]; //creo vector contador de 5 contadores 
        int i,j;
        //inicializo vector contador 
        for (i=0; i<5; i++) {
            this.contAlumns[i]=0;
        }
        //agrego alumnos a matriz
        for (i=0; i < 5; i++) {
            for (j=0; j < n; j++) {
                matriz[i][j] = new Alumno("Ninguno", 0, "Nada");
            }
        }
    }
    
   //Getters y Setters 
    public Alumno[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Alumno[][] matriz) { //esta seteado en el constructor?
        this.matriz = matriz;
    }

    public int[] getContAlumns() {
        return contAlumns;
    }

    public void setContAlumns(int[] contAlumns) { //esta seteado en constructor?
        this.contAlumns = contAlumns;
    }
    
    //Metodo inscribir alumno (variables : genero/ alumno)
    public void agregarAlu (Alumno alu, int gnro) {
        this.matriz[gnro][this.contAlumns[gnro]] = alu; //en pos i y j cant alu (vect cont en pos i)
        this.contAlumns[gnro]++; //sumo un alumno en vector contador 
    }
    // Metodo que asigna un puntaje ingresado junto con el nombre del alumno (PUEDE NO EXISTIR)
    public void asignoPunt (double punt, String nombAlu){
        int i=0;
        int j=0;
        boolean encontrado= false;
        //recorro matriz buscando nombre (uso whiles por el boolean encontrado)
        while (i <5 && (!encontrado)) {
            while ( j < this.contAlumns[i] && (!encontrado)){
                if (this.matriz[i][j].getNombAlu().equals(nombAlu) ) {
                    encontrado = true;
                    this.matriz[i][j].setPuntaje(punt); //seteo puntaje 
                }
                j++;
            }
            i++;
            j=0; //cada vez que avanza de genero j es 0 nuevamente 
        }
    }
    //recorro vector contador de alumnos por genero y guardo el maximo
    public int generoMax () {
        int i;
        int gMax=-1;
        int cantMax = -1;
        for (i=0; i < 5; i++ ) {
            if (this.contAlumns[i] > cantMax) {
                cantMax = this.contAlumns[i];
                gMax = i;
            }
        }
        return gMax;
    }
    //imprimir info de matriz 
    //buena practica generar un concatenador que recorra e imprima matriz 
    
    @Override
    public String toString() {
        return this.concatenador();
    }

    private String concatenador() {
        int i,j;
        String aux = " ";
        for (i=0; i<5; i++) {
            for (j=0; j< this.contAlumns[i]; j++){
                aux += "Genero: " + i + this.matriz[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
    
    
    
}
