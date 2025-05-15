
package parcial16;

public abstract class Banco {
    
    private String nombre;
    private int cantEmp;
    private int maxCuentas; //N
    private int cantCuent;
    private Cuenta [] cuentas;

    public Banco(String nombre, int cantEmp, int maxCuentas) {
        this.nombre = nombre;
        this.cantEmp = cantEmp;
        this.maxCuentas = maxCuentas;
        this.cuentas = new Cuenta[maxCuentas];
        for (int i=0; i< this.maxCuentas; i++) {
            this.cuentas[i]=null;
        }
    }
    public boolean HayLugar (){
        return this.cantCuent < this.maxCuentas;
    }
    public boolean agregCuenta (Cuenta c){
        boolean aux=false; 
        if (this.HayLugar()) {
            this.cuentas[this.cantCuent+1]=c;
            aux= true;
        }
        return aux;
    }
    public int busqueda (int cbu){
        int aux=0;
        while (aux < this.cantCuent && this.cuentas[aux].getCbu() != cbu) {
            aux++;
        }
        return aux;
    }
    public void deposito (int cbu, double monto) {
        int aux= busqueda(cbu);
        if ( aux != this.cantCuent ) {
            this.cuentas[aux].incrementar(monto);
        }
    }
    public Cuenta obtenerCuenta (int cbu) {
        Cuenta aux=null;
        for (int i=0; i< this.cantCuent; i++) {
            if (this.cuentas[i].getCbu().equals(cbu)) {
                aux = this.cuentas[i];
            }
        }
        return aux;
    }
    public abstract boolean puedeRecibirTarj (int cbu);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantEmp() {
        return cantEmp;
    }

    public void setCantEmp(int cantEmp) {
        this.cantEmp = cantEmp;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    public int getCantCuent() {
        return cantCuent;
    }
    
    
    
}
