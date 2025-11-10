/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Zona implements Serializable {
    private String id;
    private String nombre;
    private double latitud;
    private double longitud;
    private double utilidad; // u_z = P_recolectado - P_pendiente [cite: 35]

    // Cantidades para el cálculo de utilidad [cite: 37]
    private double residuosPendientes; // P_pendiente: residuos que aún permanecen sin recoger.
    private double residuosRecolectados; // P_recolectado: residuos ya procesados o transportados.

    // Lista auxiliar para almacenar residuos en la zona (opcional, para gestión local)
    private List<Residuo> listaResiduos; 

    public Zona(String id, String nombre, double latitud, double longitud) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.residuosPendientes = 0.0;
        this.residuosRecolectados = 0.0;
        this.utilidad = 0.0;
        this.listaResiduos = new ArrayList<>();
    }

    // --- Lógica de Utilidad ---

    /**
     * Recalcula la utilidad de la zona basada en las cantidades actuales.
     * Una utilidad BAJA/NEGATIVA indica alta prioridad de atención. [cite: 38, 52]
     */
    public void calcularUtilidad() {
        this.utilidad = this.residuosRecolectados - this.residuosPendientes;
    }

    // --- Métodos de Gestión de Residuos ---

    public void agregarResiduoPendiente(Residuo r) {
        this.listaResiduos.add(r);
        this.residuosPendientes += r.getPeso();
        calcularUtilidad();
    }

    public void registrarRecoleccion(Residuo r) {
        this.listaResiduos.remove(r);
        this.residuosPendientes -= r.getPeso();
        this.residuosRecolectados += r.getPeso();
        calcularUtilidad();
    }
    
    // --- Getters y Setters ---

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getResiduosPendientes() { return residuosPendientes; }
    public double getResiduosRecolectados() { return residuosRecolectados; }
    public double getUtilidad() { return utilidad; }

}
