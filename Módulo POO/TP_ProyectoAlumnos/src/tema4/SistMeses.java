
package tema4;


public class SistMeses extends Sistema{
    
    private String[] meses = new String[]{"Enero", "Febrero", "Marzo",
        "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre"};
    
    // promedio historico por meses 
    public SistMeses(Estacion estacion, int anioIni, int cantAnios) {
        super( anioIni, cantAnios,estacion);
    }
    
    public String retornaMedia() {  // promedio meses 
        String aux = "";
        double total;
        for (int j=0;j<12;j++){
            total = 0;
            for(int i=0;i<this.getCantAnios();i++){
                total += getTemp(j+1, i+this.getAnioIni());         
            }
            aux += meses[j]+": "+Math.round((total/this.getCantAnios())*100)/100.0+"°C \n";
        }
        return aux;
    }
    
    //informar

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
