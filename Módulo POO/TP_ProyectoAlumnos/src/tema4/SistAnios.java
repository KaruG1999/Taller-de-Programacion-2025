

package tema4;


public class SistAnios extends Sistema{
    
    // promedio historico por años 

    public SistAnios( Estacion estacion, int anioIni, int cantAnios) {
        super(anioIni, cantAnios, estacion);
        
    }
    
    public String retornaMedia() {  //promedio anual
        String aux = "";
        double total;
        for(int i=0;i<this.getCantAnios();i++){
            total = 0;
            for(int j=0;j<12;j++){
                total += getTemp(j+1, i+this.getAnioIni());
            }
            aux += "Anio "+(i+this.getAnioIni())+": "+Math.round((total/12)*100)/100.0+"°C \n";
        }
        return aux;
    }
    
    // representacion 

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
