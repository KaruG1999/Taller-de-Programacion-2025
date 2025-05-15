
package TurnoC_18_10_24;

public class Plataforma {

    private String nombre;
    private int cantS;
    private int C;              // df de categorias
    private int cantMeses= 12;  // df de columnas 
    private Estreno [][] estrenos;     // // matriz de C (filas) categorias y 12 meses (columnas)
    
    // llevo un vector de dimensiones logicas de cada estreno
    private int [] dimL;  // recibe C (cantidad de estrenos)
    
   
    public Plataforma(String nombre, int cantS, int cantC) {
        this.nombre = nombre;
        this.cantS = cantS;
        this.C = cantC;
        
        this.estrenos = new Estreno[this.C][this.cantMeses]; 
        this.dimL = new int [this.C];
        this.iniciV();
        
    }
    
    // inicializo vector de dimensiones logicas 
    public void iniciV () {
        for (int i=0; i< this.C ; i++) {
            dimL[i]=0;
        }
    }
    
    // registrar estreno en el primer mes disponible 
    public void agregarEstreno (Estreno est, int catX) {
        int mes = dimL[catX];
        estrenos[catX][mes] = est; 
        dimL[catX]++;  // aumento dl al agregar 
    }
    
    //listar estrenos de cat X
    public String listarEst (int catX) {
        String aux = "Estrenos de categoria " + catX + ":" + "\n";
        for (int i=0; i<this.dimL[catX]; i++) {
            aux += estrenos[catX][i].toString();
        }
        return aux;
    }

    // calcular ganancia total 
    public double ganancia() {
        double tot=0;
        for (int i=0; i<this.C ; i++ ){
            for (int j=0; j<this.dimL[i]; j++) {
                tot += estrenos[i][j].ganancia();
            }
        }
        return tot;
    }
    
    // repres

    @Override
    public String toString() {
        String aux = " Plataforma: " + getNombre() + ", " + this.ganancia() + ", " + getCantS() + "\n";
        for (int i=0; i<this.C ; i++ ){
            aux += "Categoria " + i + ":" + "\n";
            for (int j=0; j<this.dimL[i]; j++) {
                aux += "Mes " + j + ": " + estrenos[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantS() {
        return cantS;
    }

    public void setCantS(int cantS) {
        this.cantS = cantS;
    }

    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }

    public int getCantMeses() {
        return cantMeses;
    }

    
    
    
    
    
    
    
    
}
