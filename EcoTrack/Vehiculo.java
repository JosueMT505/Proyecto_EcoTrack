/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.modelo;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Vehiculo implements Serializable {
    private String id;
    private double capacidadMaxima; // Capacidad de carga del vehículo
    private double volumenActual;
    private String zonaAsignadaId; // La zona que tiene asignada para recolección
    private boolean enRuta;
    
    // El nivel de llenado puede ser un factor de prioridad
    private double nivelLlenado; 

    public Vehiculo(String id, double capacidadMaxima, String zonaAsignadaId) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.zonaAsignadaId = zonaAsignadaId;
        this.volumenActual = 0.0;
        this.nivelLlenado = 0.0;
        this.enRuta = false;
    }

    // --- Lógica ---

    public double getNivelLlenado() {
        // Porcentaje de llenado (0.0 a 1.0)
        return volumenActual / capacidadMaxima; 
    }
    
    public void cargarResiduos(double volumen) {
        this.volumenActual += volumen;
        this.nivelLlenado = getNivelLlenado();
    }
    
    // --- Getters y Setters ---

    public String getId() { return id; }
    public double getCapacidadMaxima() { return capacidadMaxima; }
    public double getVolumenActual() { return volumenActual; }
    public String getZonaAsignadaId() { return zonaAsignadaId; }
    public boolean isEnRuta() { return enRuta; }
    public void setEnRuta(boolean enRuta) { this.enRuta = enRuta; }
}
