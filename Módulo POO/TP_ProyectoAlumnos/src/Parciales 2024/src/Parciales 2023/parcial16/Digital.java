
package parcial16;

public class Digital extends Banco{

    private String direccionWeb;

    public Digital(String direccionWeb, String nombre, int cantEmp, int maxCuentas) {
        super(nombre, cantEmp, maxCuentas);
        this.direccionWeb = direccionWeb;
    }
    @Override
    public boolean puedeRecibirTarj(int cbu) {
        boolean aux= false;
        int pos= this.busqueda(cbu);
        if (this.getCantCuent() != pos) {
            if (this.getCuentas()[pos].getMoneda().equals("Pesos") && this.getCuentas()[pos].getMonto() < 10000){
                aux= true;
            }
        }
        return aux;
    }

    public String getDireccionWeb() {
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }

    
    
    
    
    
}
