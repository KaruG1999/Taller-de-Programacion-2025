/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurnoA_17_10_24;

class Participante {
    
    private String nombre, email;
    private int contraIng;

    public Participante(String nombre, String email){
        setNombre(nombre);
        setEmail(email);
    }
    
    public Participante(String nombre, String email, int contraIng) {
        setNombre(nombre);
        setEmail(email);
        setContraIng(contraIng);
    }

    @Override
    public String toString() {
        String aux = " Nombre: " + getNombre() + ", Email: " + getEmail();
        return aux;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContraIng() {
        return contraIng;
    }

    public void setContraIng(int contraIng) {
        this.contraIng = contraIng;
    }
 
    
}
