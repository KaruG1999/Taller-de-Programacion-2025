/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1_05_06_24;

public class Curso {
    
    private String descripcion;  // descripcion de curso
    private Turno turnoOnl;   // vector de turnos online
    private Turno turnoPres;  // vector de turnos presencial

    public Curso(String descripcion) {
        this.descripcion = descripcion;
        this.turnoOnl = new Turno (10);
        this.turnoPres = new Turno (10);  // ambos tienen cupo de 10 alumnos
    }

// agrega alumno a curso    
    public void agregarAlu(Alumno alu) {
        if (alu.getLugarR().equals("La Plata")) {
            this.turnoPres.agregarAlu(alu);
        } else {
            this.turnoOnl.agregarAlu(alu);
        }
        
    }
    
    // calcular ganancia de ambos turnos (alu inscriptos - sueldo docente)
    public double gananciaTot () {
        return this.turnoOnl.ganancia() + this.turnoPres.ganancia();
    }
    
    // representacion 

    @Override
    public String toString() {
        String aux = getDescripcion() + ", Ganancia mensual neta: " + this.gananciaTot() + "\n" 
                + "Turno Online: " + turnoOnl.toString() + "\n" + 
                "Turno Presencial: " + turnoPres.toString();
        return aux;
    }

    // determina si es rentable
    
    public boolean esRentable() {
        if (gananciaTot() > 800000) {
            return true;
        }
        return false;
    }
    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
    
    
}
