/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1_05_06_24;

public class Turno {
    
    private String nombre;
    private double sueldo, costoCuo; 
    private Alumno [] alumnos ; 
    private int df, dl;

    public Turno(int df) {
        this.nombre = "Jose Luis";
        this.sueldo = 300000;
        this.costoCuo = 80000;
        this.dl =0;
        this.df = df;
        this.alumnos = new Alumno [this.df];
        this.iniciV();
    }
    
    public void iniciV () {         // java lo inicia automaticamente 
        for (int i=0; i<this.df; i++) {
            alumnos[i] = null;
        }
    }
    
    public Turno (){
        
    }
    
    // agregar Alumno
    public void agregarAlu (Alumno alu) {
        if (this.dl < this.df) {
            alumnos[this.dl] = alu;
            this.dl++;
        }
    }
    
    //calcular ganancia 
    public double ganancia() {
        return getCostoCuo()* getDf() - getSueldo();
    }

    // representación

    @Override
    public String toString() {
        String aux = " ";
        for (int i=0; i<getDl() ; i++) {
            aux += " Alumno " + i + ":" + alumnos[i].toString();
        }
        return aux;
    }

    public int getDl() {
        return dl;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getCostoCuo() {
        return costoCuo;
    }

    public void setCostoCuo(double costoCuo) {
        this.costoCuo = costoCuo;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }
    
    
    
    
    
    
}
