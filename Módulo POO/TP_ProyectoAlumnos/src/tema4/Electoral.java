/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Karen
 */
public class Electoral extends Urna{
    
    private int cantL;  // df de vector
    private int [] Contador; // contador de votos de todas las listas
    private int dl;

    public Electoral(int L, int U, Zona Z) {
        super(U, Z);
        setCantL(L);
        this.dl = 0;  // dl no es necesario
        this.Contador = new int[getCantL()];
        this.inicialV();  // inicializo cont en 0
        
    }

    public void inicialV () {
        for (int i=0; i< getCantL(); i++){
            Contador[i] =0;
        }
    }
    
    // recibe numero y devuelve si es nro de lista válido
    public boolean validarNumeroDeLista (int N) {
        Boolean valido =false;
        if (N > 0 && N < getCantL()) {  // si el numero N esta entre la cantidad de listas 
            valido = true;
        }
        return valido;
    }
    
    
    //recibe num lista valido e incrementa num votos 
    public void votarPorLista (int I) {
        if (this.validarNumeroDeLista(I)) {
            Contador[I]++;
        }
    }
    
    // devuelve cantidad de votos de lista I(supongo que es valido)
    public int devolverVotosPorLista (int I) {
        return Contador[I];
    }
    
    public int getCantL() {
        return cantL;
    }

    public void setCantL(int cantL) {
        this.cantL = cantL;
    }

    public int getDl() {
        return dl;
    }

    
    // metodo asbtracto de super clase 
    @Override
    public int calcularGanador() {
        int ganador = -1;
        int maxVotos = -1;
        for (int i=0; i<getCantL(); i++) {
            // si hay empate elige alguna indistinto
            if (Contador[i] > maxVotos) {
                maxVotos = Contador[i];
                ganador = i;
            }
        }
        return ganador;
    }

    @Override
    public int calcularTotalVotos() {
        int tot =0;
        tot += super.getContV();
        for (int i=0; i<this.getCantL(); i++) {
            tot += Contador[i];
        }
        return tot;
    }

    

    
    
}
