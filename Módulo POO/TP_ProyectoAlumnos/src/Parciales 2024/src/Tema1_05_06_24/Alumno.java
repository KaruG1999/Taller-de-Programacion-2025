/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1_05_06_24;

class Alumno {
    
    private int dni;
    private String nombAlu, lugarR;

    public Alumno(int dni, String nombAlu, String lugarR) {
        setDni(dni);
        setNombAlu(nombAlu);
        setLugarR(lugarR);
    }

    public Alumno () {
        
    }

    @Override
    public String toString() {
        String aux = "DNI: " + getDni() + ", Nombre: " + getNombAlu() + ", Lugar: " + getLugarR();
        return aux;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombAlu() {
        return nombAlu;
    }

    public void setNombAlu(String nombAlu) {
        this.nombAlu = nombAlu;
    }

    public String getLugarR() {
        return lugarR;
    }

    public void setLugarR(String lugarR) {
        this.lugarR = lugarR;
    }
    
    
    
}
