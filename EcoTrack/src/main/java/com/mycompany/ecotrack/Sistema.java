package com.mycompany.ecotrack;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase principal de modelo (sin UI).
 *
 * - Se elimina ListaEnlazadaCircular inexistente y se usa ListaCircularResiduos.
 * - Se elimina Map<String,Object> para estadisticas (evita casting de primitives).
 */
public class Sistema implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ListaCircularResiduos listaResiduos;
    private final PilaReciclaje<Residuo> residuosParaProcesar;
    private final Map<String, Zona> mapaZonas;
    private final Estadisticas estadisticas;

    // Ordenamiento de residuos (criterio actual)
    private transient Comparator<Residuo> comparadorActivo;

    // Rutas/vehiculos (cola de prioridad)
    private transient ComparadorVehiculo comparadorVehiculo;
    private final ColaPrioridad<VehiculoRecolector> colaVehiculosPendientes;

    public Sistema() {
        this.listaResiduos = new ListaCircularResiduos();
        this.residuosParaProcesar = new PilaReciclaje<>();
        this.mapaZonas = new HashMap<>();
        this.estadisticas = new Estadisticas();

        this.comparadorActivo = new ComparadorPrioridad();
        this.comparadorVehiculo = new ComparadorVehiculo(this);

        this.colaVehiculosPendientes = new ColaPrioridad<>(this.comparadorVehiculo);
    }

    /* ===== Persistencia ===== */

    public void guardarEstado(String archivo) throws IOException {
        Persistencia.guardar(this, archivo);
    }

    public static Sistema cargarEstado(String archivo) throws IOException, ClassNotFoundException {
        Sistema sistemaCargado = Persistencia.cargar(archivo);
        sistemaCargado.reestablecerTransientes();
        return sistemaCargado;
    }

    private void reestablecerTransientes() {
        this.comparadorActivo = new ComparadorPrioridad();
        this.comparadorVehiculo = new ComparadorVehiculo(this);
        this.colaVehiculosPendientes.setComparador(this.comparadorVehiculo);
    }

    /* ===== Gestion de residuos ===== */

    public boolean registrarResiduo(Residuo residuo) {
        if (residuo == null) return false;

        boolean agregado = listaResiduos.agregarResiduo(residuo);
        if (!agregado) return false;

        Zona zona = mapaZonas.get(residuo.getZona());
        if (zona == null) {
            zona = new Zona(residuo.getZona(), "Zona " + residuo.getZona(), 0.0, 0.0);
            mapaZonas.put(zona.getId(), zona);
        }

        zona.agregarResiduoPendiente(residuo);
        estadisticas.registrarResiduo(residuo);
        return true;
    }

    /**
     * Simula recoleccion: mueve un residuo de una zona al centro de reciclaje (pila).
     */
    public boolean recolectarResiduo(String idResiduo) {
        if (idResiduo == null) return false;

        Residuo r = listaResiduos.buscarResiduo(idResiduo);
        if (r == null) return false;

        Zona z = mapaZonas.get(r.getZona());
        if (z != null) {
            z.registrarRecoleccion(idResiduo);
        }

        residuosParaProcesar.apilarResiduo(r);
        return true;
    }

    public ListaCircularResiduos getListaResiduos() { return listaResiduos; }
    public PilaReciclaje<Residuo> getResiduosParaProcesar() { return residuosParaProcesar; }
    public Map<String, Zona> getMapaZonas() { return mapaZonas; }
    public Estadisticas getEstadisticas() { return estadisticas; }

    /* ===== Gestion de vehiculos ===== */

    public void registrarVehiculo(VehiculoRecolector v) {
        if (v == null) return;

        if (!mapaZonas.containsKey(v.getZonaAsignadaId())) {
            mapaZonas.put(
                v.getZonaAsignadaId(),
                new Zona(v.getZonaAsignadaId(), "Zona " + v.getZonaAsignadaId(), 0.0, 0.0)
            );
        }
        colaVehiculosPendientes.agregarVehiculo(v);
    }

    public VehiculoRecolector despacharVehiculo() {
        return colaVehiculosPendientes.despacharVehiculo();
    }

    public VehiculoRecolector verSiguienteVehiculo() {
        return colaVehiculosPendientes.verSiguienteVehiculo();
    }

    public int cantidadVehiculosPendientes() {
        return colaVehiculosPendientes.size();
    }

    /* ===== Comparador activo (para UI despues) ===== */

    public void setComparadorActivo(Comparator<Residuo> comparador) {
        this.comparadorActivo = comparador;
    }

    public Comparator<Residuo> getComparadorActivo() {
        return comparadorActivo;
    }
}
