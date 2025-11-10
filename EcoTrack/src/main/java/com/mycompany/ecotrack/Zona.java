
package com.mycompany.ecotrack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo 8
 */
public class Zona implements Serializable {
    private String id;
    private String nombre;
    private double latitud;
    private double longitud;
    private double utilidad;
    private double residuosPendientes; 
    private double residuosRecolectados; 
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

 
    public void calcularUtilidad() {
        this.utilidad = this.residuosRecolectados - this.residuosPendientes;
    }


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
    

    

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getResiduosPendientes() { return residuosPendientes; }
    public double getResiduosRecolectados() { return residuosRecolectados; }
    public double getUtilidad() { return utilidad; }

}
