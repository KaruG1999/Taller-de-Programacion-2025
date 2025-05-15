
package parcial12;

public class Concurso {

    private Cancion [][] matriz;
    private int cantCatego;
    private int cantMaxCatego;
    private int [] vecDl;

    public Concurso(int cantCatego, int cantMaxCatego) {
        this.cantCatego = cantCatego;
        this.cantMaxCatego = cantMaxCatego;
        this.matriz = new Cancion[cantMaxCatego][cantMaxCatego];
        this.vecDl = new int [this.cantCatego]; //guarda diml l de cada categoria (cant de canc por catego)
        for (int i=0; i< this.cantCatego; i++) {
            this.vecDl[i] = 0;
        }
        for (int j=0; j< this.cantCatego; j++) { //matriz de categorias y canciones x categoria
            for (int k=0; k< this.cantMaxCatego; k++) {
                this.matriz[j][k] =null;
            }
        }
    }
    //agrego cancion en matriz pos categoria, y siguiente en el vector dim l
    public void agregoCanc(Cancion can, int cat) {
        this.matriz[cat][vecDl[cat]++] = can;
    }
    // alumno interpreta una cancion y lo agrego en el id de la cancion junto con el puntaje 
    public void interpretaAlu(int id, Alumno alu, double puntaje) {
        int i =0;
        boolean encontre =false;
        while (i < this.cantCatego && !encontre) { //mientras la cat sea menor que 3 y no se encontro cancion
            int pos=0;                              //posicion avanza buscando cancion
            while (pos < this.vecDl[i] && (matriz[i][pos].getId() != id)) {  //mientras no se encuentre id
                pos++;                                              //sigue avanzando
            }
            if(pos < vecDl[i]) {                //si se encuentra el id
                encontre=true;                  //marco boolean como verdadero
                if (matriz[i][pos].getPuntaje() < puntaje) { //si tiene un puntaje mayor al ingresado
                    matriz[i][pos].setGanador(alu);   //agrego ganador 
                    matriz[i][pos].setPuntaje(puntaje); //agrego puntaje de ese ganador 
                }
            }
        } i++;
    }
    //devuelve el estudiante ganador con mayor puntaje de cancion ingresada por id
    public Alumno anunciaGan(int id) {
        Alumno estud = null; //contendra al ganador 
        boolean encontre = false;
        int i=0;
        while (i< this.cantCatego && !encontre) { //mientras no llegue al fin y no encontre el ganador 
            int pos=0;
            while (pos < this.vecDl[i] && matriz[i][pos].getId () != id) { //mientras no se llegue al fin
                pos++;                                              //y id cancion sea dif al ingresado 
            }
            if (pos < this.vecDl[i]) {     //si encontre el id
                encontre = true;            //encontre el ganador 
                estud = this.matriz[i][pos].getGanador(); //
            }
            i++;
        }
        return estud;
    }
    
    public Cancion mejorCancXCatego(int catego) {
        Cancion canc = null;
        int pos=0;
        double maxPuntos =-1;
        while (pos < this.vecDl[catego]) {
            if (matriz[catego][pos].getPuntaje() > maxPuntos){
                maxPuntos = matriz[catego][pos].getPuntaje();
                canc = matriz[catego][pos];
            }
            pos++;
        }
        return canc; 
    }

    @Override
    public String toString() {
        return "Concurso{" + "matriz=" + matriz + ", cantCatego=" + cantCatego + ", cantMaxCatego=" + cantMaxCatego + ", vecDl=" + vecDl + '}';
    }
    
   
    
}
