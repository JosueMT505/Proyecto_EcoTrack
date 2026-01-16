
package com.mycompany.ecotrack;

import java.io.Serializable;

/**
 *
 * @author Grupo 8
 */
public class VehiculoRecolector implements Serializable {
    private String id;
    private double capacidadMaxima; 
    private double volumenActual;
    private String zonaAsignadaId; 
    private boolean enRuta;
    private double nivelLlenado; 

    public VehiculoRecolector(String id, double capacidadMaxima, String zonaAsignadaId) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.zonaAsignadaId = zonaAsignadaId;
        this.volumenActual = 0.0;
        this.nivelLlenado = 0.0;
        this.enRuta = false;
    }


    
    public void cargarResiduos(double volumen) {
        if (this.volumenActual + volumen > this.capacidadMaxima) {
            System.out.println("Error: El vehículo " + id + " se ha llenado al máximo.");
            this.volumenActual = this.capacidadMaxima;
        } else {
            this.volumenActual += volumen;
        }
        this.nivelLlenado = getNivelLlenado();
    }
    public void vaciarVehiculo() {
        this.volumenActual = 0.0;
        this.nivelLlenado = 0.0;
        this.enRuta = false; 
    }
    
    public double getNivelLlenado() {return volumenActual / capacidadMaxima;}
    public String getId() { return id; }
    public double getCapacidadMaxima() { return capacidadMaxima; }
    public double getVolumenActual() { return volumenActual; }
    public String getZonaAsignadaId() { return zonaAsignadaId; }
    public boolean isEnRuta() { return enRuta; }
    public void setEnRuta(boolean enRuta) { this.enRuta = enRuta; }

    @Override
    public String toString() {
        return "Vehículo " + id + " [Zona: " + zonaAsignadaId + ", Llenado: " + String.format("%.2f", nivelLlenado * 100) + "%]";
    }
}
