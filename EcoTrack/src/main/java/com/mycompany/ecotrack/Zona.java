package com.mycompany.ecotrack;

import java.io.Serializable;

/**
 * Zona urbana.
 * No usa java.util.List/ArrayList: almacena residuos pendientes en una lista circular propia.
 */
public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private String nombre;
    private double latitud;
    private double longitud;

    private double residuosPendientes;   // peso pendiente
    private double residuosRecolectados; // peso recolectado
    private double utilidad;             // recolectado - pendiente

    private final ListaCircularResiduos residuosPendientesLista;

    public Zona(String id, String nombre, double latitud, double longitud) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;

        this.residuosPendientes = 0.0;
        this.residuosRecolectados = 0.0;
        this.utilidad = 0.0;

        this.residuosPendientesLista = new ListaCircularResiduos();
    }

    private void recalcularUtilidad() {
        this.utilidad = this.residuosRecolectados - this.residuosPendientes;
    }

    public void agregarResiduoPendiente(Residuo r) {
        if (r == null) return;

        boolean ok = residuosPendientesLista.agregarResiduo(r);
        if (ok) {
            this.residuosPendientes += r.getPeso();
            recalcularUtilidad();
        }
    }

    public boolean registrarRecoleccion(String idResiduo) {
        if (idResiduo == null) return false;

        Residuo r = residuosPendientesLista.buscarResiduo(idResiduo);
        if (r == null) return false;

        boolean eliminado = residuosPendientesLista.eliminarResiduo(idResiduo);
        if (!eliminado) return false;

        this.residuosPendientes -= r.getPeso();
        this.residuosRecolectados += r.getPeso();
        recalcularUtilidad();
        return true;
    }

    public ListaCircularResiduos getResiduosPendientesLista() {
        return residuosPendientesLista;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }

    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    public double getResiduosPendientes() { return residuosPendientes; }
    public double getResiduosRecolectados() { return residuosRecolectados; }
    public double getUtilidad() { return utilidad; }

    @Override
    public String toString() {
        return "Zona " + id + " (" + nombre + ") | Pendiente=" + residuosPendientes
                + " | Recolectado=" + residuosRecolectados + " | Utilidad=" + utilidad;
    }
}
