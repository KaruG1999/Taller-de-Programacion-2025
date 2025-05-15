package parcial13;

public class Venta {

    private  int dni;
    private double cantm3;
    private double abonado;
    private String formPago;
    private int cantVentas=0;

    public Venta(int dni, double cantm3, double abonado, String formPago) {
        this.dni = dni;
        this.cantm3 = cantm3;
        this.abonado = abonado;
        this.formPago = formPago;
    }

    @Override
    public String toString() {
        return "Dni=" + this.dni + ", cantm3=" + this.cantm3 + ", abonado=" + this.abonado + ", formPago=" + this.formPago;
    }
    //sett y get

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getCantm3() {
        return cantm3;
    }

    public void setCantm3(double cantm3) {
        this.cantm3 = cantm3;
    }

    public double getAbonado() {
        return abonado;
    }

    public void setAbonado(double abonado) {
        this.abonado = abonado;
    }

    public String getFormPago() {
        return formPago;
    }

    public void setFormPago(String formPago) {
        this.formPago = formPago;
    }
    
    
}
