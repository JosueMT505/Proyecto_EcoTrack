
package com.mycompany.ecotrack;

import java.time.LocalDate;

/**
 *
 * @author Grupo 8
 */
public class Residuo implements Comparable<Residuo> {
    private final String id; 
    private String nombre;
    private String tipo; 
    private double peso; 
    private LocalDate fechaRecoleccion;
    private String zona; 
    private int nivelPrioridadAmbiental; 


    public Residuo(String id, String nombre, String tipo, double peso, String zona, int nivelPrioridadAmbiental) {
        this.id = id; 
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.zona = zona;
        this.nivelPrioridadAmbiental = nivelPrioridadAmbiental;
        this.fechaRecoleccion = LocalDate.now(); 
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public LocalDate getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    public String getZona() {
        return zona;
    }

    public int getNivelPrioridadAmbiental() {
        return nivelPrioridadAmbiental;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setNivelPrioridadAmbiental(int nivelPrioridadAmbiental) {
        this.nivelPrioridadAmbiental = nivelPrioridadAmbiental;
    }
    


    
    @Override
    public int compareTo(Residuo otro) {
        return this.id.compareTo(otro.id);
    }
    

    @Override
    public String toString() {
        return String.format("ID: %s | Tipo: %s | Peso: %.2f kg | Prioridad: %d", id, tipo, peso, nivelPrioridadAmbiental);
    }

}
