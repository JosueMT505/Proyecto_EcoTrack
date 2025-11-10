
package com.mycompany.ecotrack;


import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Grupo 8
 */
public class Sistema implements Serializable {
    private ListaEnlazadaCircular<Residuo> listaResiduos; 
    private ColaPrioridad<Vehiculo> colaVehiculosPendientes; 
    private PilaReciclaje<Residuo> residuosParaProcesar; 
    private Map<String, Zona> mapaZonas; 
    private Map<String, Object> estadisticasGlobales; 
    

    private Comparator<Residuo> comparadorActivo; 
    
    private transient ComparadorVehiculo comparadorVehiculo; 

    public Sistema() {
        this.listaResiduos = new ListaEnlazadaCircular<>();
        this.mapaZonas = new HashMap<>(); 
        this.estadisticasGlobales = new HashMap<>();
        this.residuosParaProcesar = new PilaReciclaje<>();
        
        this.comparadorActivo = new ComparadorPrioridad();
        // El comparador de vehículos se inicializa aquí y se pasa a la cola
        this.comparadorVehiculo = new ComparadorVehiculo(this);
        this.colaVehiculosPendientes = new ColaPrioridad<>(this.comparadorVehiculo);
    }


    public void guardarEstado(String archivo) throws IOException {
        Persistencia.guardar(this, archivo);
    }

    public static Sistema cargarEstado(String archivo) throws IOException, ClassNotFoundException {
        Sistema sistemaCargado = Persistencia.cargar(archivo);
        sistemaCargado.reestablecerTransientes(); 
        return sistemaCargado;
    }
    

    private void reestablecerTransientes() {
        this.comparadorVehiculo = new ComparadorVehiculo(this);
        this.colaVehiculosPendientes = new ColaPrioridad<>(this.comparadorVehiculo);
    }


    public void registrarResiduo(Residuo residuo) {
        listaResiduos.agregar(residuo);
        Zona zona = mapaZonas.get(residuo.getZona());
        if (zona == null) {
            zona = new Zona(residuo.getZona(), "Zona " + residuo.getZona(), 0, 0); 
            mapaZonas.put(zona.getId(), zona);
        }
        zona.agregarResiduoPendiente(residuo); 
        actualizarEstadisticas(residuo); 
        revisarPrioridadDespacho(zona); 
    }
    

    private void revisarPrioridadDespacho(Zona zona) {
        if (zona.getUtilidad() < -50.0) { 
        }
    }
    

    public Map<String, Zona> getMapaZonas() {
        return mapaZonas;
    }
    
    public ListaEnlazadaCircular<Residuo> getListaResiduos() {
        return listaResiduos;
    }

    public PilaReciclaje<Residuo> getResiduosParaProcesar() {
        return residuosParaProcesar;
    }
    
    private void actualizarEstadisticas(Residuo residuo) {
    }
}
