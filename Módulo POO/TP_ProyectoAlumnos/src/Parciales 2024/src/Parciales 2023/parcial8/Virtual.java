
package parcial8;

public class Virtual extends Curso{

    private String link;

    public Virtual( int anio, int maxAlu, String link) {
        super(anio, maxAlu);
        this.link = link;
    }
    //get y set
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    // decide si alumno puede rendir 
    public boolean puedeRendir (Alumno alu) {
        return (alu.getAsistencia() >= 3) ;
    }
    
    
    
    
}
