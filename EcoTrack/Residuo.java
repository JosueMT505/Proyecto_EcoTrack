/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.modelo;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Residuo implements Comparable<Residuo> {
    private final String id; 
    private String nombre;
    private String tipo; // orgánico, plástico, vidrio, electrónico, metal, etc.
    private double peso; // En kilogramos
    private LocalDate fechaRecoleccion;
    private String zona; // ID o nombre de la Zona
    private int nivelPrioridadAmbiental; // Escala, ej. 1 (Baja) a 5 (Alta)

    /**
     * Constructor
     * @param id
     * @param nombre
     * @param tipo
     * @param peso
     * @param zona
     * @param nivelPrioridadAmbiental
     */
    public Residuo(String id, String nombre, String tipo, double peso, String zona, int nivelPrioridadAmbiental) {
        this.id = id; // El ID es inmutable
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.zona = zona;
        this.nivelPrioridadAmbiental = nivelPrioridadAmbiental;
        this.fechaRecoleccion = LocalDate.now(); // Se establece la fecha al crear el objeto
    }

    // --- Getters ---
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
    
    // --- Setters (para permitir modificación de ciertos datos) ---
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
    
    // --- Métodos de Interfaz ---

    /**
     * Implementación del ordenamiento natural (por defecto) por ID.
     */
    @Override
    public int compareTo(Residuo otro) {
        return this.id.compareTo(otro.id);
    }
    
    /**
     * Representación resumida para el iterador (Requerimiento 5. Iteradores personalizados)[cite: 74].
     */
    @Override
    public String toString() {
        return String.format("ID: %s | Tipo: %s | Peso: %.2f kg | Prioridad: %d", id, tipo, peso, nivelPrioridadAmbiental);
    }

}
