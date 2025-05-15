
package parcial16;

public class Tradicional extends Banco{
    
    private String direccion;
    private String localidad;
    private int cantCuentDol;
    private int maxCuentDol = 100;

    public Tradicional(String direccion, String localidad, int cantCuentDol, String nombre, int cantEmp, int maxCuentas) {
        super(nombre, cantEmp, maxCuentas);
        this.direccion = direccion;
        this.localidad = localidad;
        this.cantCuentDol = 0;
    }
    
    public boolean HayLugar (){
        boolean aux= false;
        if (this.cantCuentDol > this.maxCuentDol) {
            aux = true;
        }
        return aux;
    }
    public boolean puedeRecibirTarj (int cbu){
        boolean aux=false;
        int pos = this.busqueda(cbu);
        if (this.getCantCuent() != pos){
            if (this.getCuentas()[pos].getMoneda().equals("dolares") && (this.getCuentas()[pos].getMonto() > 500)){
                aux= true;
            } else {
                if (this.getCuentas()[pos].getMoneda().equals("efectivo") && (this.getCuentas()[pos].getMonto() > 70000)) {
                    aux= false;
                }
            }
            
        }
        return aux;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantCuentDol() {
        return cantCuentDol;
    }
    
    
}
