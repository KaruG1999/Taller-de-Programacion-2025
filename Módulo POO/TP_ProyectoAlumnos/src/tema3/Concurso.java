/*
 El concurso está dividido en cinco géneros musicales y en cada género se pueden inscribir hasta N
alumnos como máximo.
Implemente constructores para iniciar el concurso sin alumnos
inscriptos, recibiendo N (el máximo de alumnos por género musical)

Devolver al alumno que haya obtenido el mayor puntaje en todo el concurso.
 */
package tema3;

public class Concurso {
    
    // 5 generos con N participantes por genero
    private int dfGen = 5;
    private int N;
    private Alumno [][] matrizGen; 
    private int [] vdimL = new int[dfGen];  // vector de dimensiones logicas de cada genero 

    public Concurso(int N) {
        this.N = N;
        matrizGen = new Alumno [dfGen][N];  //iniciar concurso sin alumnos
        for (int i=0 ; i< dfGen; i++) {
            vdimL [i] = 0; // inicializo vector contador
            for (int j=0; j<N ; j++) {
                matrizGen [i][j] = null; //inicializo posiciones de matriz en null
            }
        }
    }
    
    // incribir alumno en genero musical
    
    public boolean inscribirAlu (Alumno alumno, int genero) {
        if (vdimL[genero] < N) {  // si hay lugar 
            matrizGen[genero][vdimL[genero]] = alumno; // inscribe alumno en el genero
            vdimL [genero]++;                          // aumenta cantidad de inscriptos en genero
            return true;
        }
        return false; 
    }
    
    // Asignar puntaje a alumno de genero (todo pasado por parametro)
    
    public boolean asignaPunt(int genero, String nombre, double puntaje) {
        int i = 0;
        boolean asignado = false;
        while (i < vdimL[genero] && !asignado) {
            if (matrizGen[genero][i].getNombre() != null &&
                                matrizGen[genero][i].getNombre().equalsIgnoreCase(nombre)) {
                matrizGen[genero][i].setPuntaje(puntaje);
                asignado = true;
            }
            i++;
        }
        return asignado;
    }
    
    //Devolver al alumno que haya obtenido el mayor puntaje en todo el concurso
    
    public Alumno mayorPunt () {
        double puntMax = -1.0;
        Alumno aluMax = null; 
        for (int i=0; i<dfGen; i++) {
            for (int j=0; j < vdimL[i]; j++){
                if (matrizGen[i][j].getPuntaje() > puntMax) {
                    puntMax = matrizGen[i][j].getPuntaje();
                    aluMax = matrizGen[i][j];
                }  
            }
        }
        return aluMax;
    }
    
    // “Genero 1 – Total inscriptos: X – representación del alumno 1 - ... - representación del alumno X

    @Override
    public String toString() {
        String aux = " ";
        for (int i = 0; i<dfGen; i++){
            aux += "Genero "+i+ "- Total de incriptos: " + vdimL[i];  // chequear error
            for (int j=0; j<vdimL[i]; j++) {
               aux += "- Representacion del alumno "+ j + ":" + matrizGen[i][j].toString() + "/n";
            }
        }
        return aux; 
    }
    
    
}
