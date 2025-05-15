/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoH_15_10_24;


public class Supermercado {
    
    private String nombre, direccion;
    private Producto [][] gondolas;
    private int dfG, dfE;
    private int actual;

    public Supermercado(String nombre, String direccion, int dfG, int dfE) {
        setNombre(nombre);
        setDireccion(direccion);
        setDfG(dfG);
        setDfE(dfE);
        this.actual =0;  // reemplaza dls (orden secuencial)
        this.gondolas = new Producto[this.getDfG()][this.getDfE()];
    }

    // registar productos (se completa por gondolas)
    public void registrarProd (Producto producto) {
        int gondola = this.actual / this.dfE;   // div para hallar fila
        int estante = this.actual % this.dfE;   // mod para encontrar columna
        if ( this.actual < (this.dfG*this.dfE)) {  // numero actual menor a cant total de espacios en filas y columnas
            gondolas[gondola][estante] = producto;
            this.actual++;
        }
    }
    
    
    // listar prod con marca M de gondola X
    public String listarProd (String M, int G){
        String aux = " ";
        for (int i=0; i<this.getDfE(); i++){
            if (this.gondolas[G][i].getMarca().equals(M)) {
                aux += this.gondolas[G][i].toString() + "\n";
            }
        }
        return aux;
    }
    
    // num de gondola con max unidades 
    
    public int totUniG (int G) {
        int tot=0;
        for (int i=0; i<getDfE(); i++) {
            if (gondolas[G][i] != null) {
              tot += gondolas[G][i].getCantU();  
            }
        }
        return tot;
    }
    
    public int gondolaMax (){
        int maxUni = Integer.MIN_VALUE;
        int gondMax = -1;
        for (int i=0; i< getDfG(); i++) {
            if (totUniG(i) > maxUni) {
                maxUni = totUniG(i);
                gondMax = i;
            }
        }
        return gondMax;
    }
    
    
    // repreentacion 
    @Override
    public String toString() {
        String aux = "Supermercado: " + getNombre() + "; " + getDireccion();
        for (int i=0; i<getDfG(); i++) {
            aux += " Gondola " + (i+1) + ":" + "\n";
            for (int j=0; j<getDfE(); j++) {
                if (gondolas[i][j] != null) {
                    aux += " Estante " + j + ":" + gondolas[i][j].toString();
                }
                
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDfG() {
        return dfG;
    }

    public void setDfG(int dfG) {
        this.dfG = dfG;
    }

    public int getDfE() {
        return dfE;
    }

    public void setDfE(int dfE) {
        this.dfE = dfE;
    }
    
    
    
    
    
    
    
    
}
