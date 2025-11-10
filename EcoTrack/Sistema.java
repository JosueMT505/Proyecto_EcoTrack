/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.modelo;

import Grupo_08.comparadores.ComparadorPrioridad;
import Grupo_08.comparadores.ComparadorVehiculo;
import Grupo_08.estructuras.ColaPrioridad;
import Grupo_08.estructuras.ListaEnlazadaCircular;
import Grupo_08.estructuras.PilaReciclaje;
import Grupo_08.persistencia.Persistencia;
import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Sistema implements Serializable {
    private ListaEnlazadaCircular<Residuo> listaResiduos; 
    private ColaPrioridad<Vehiculo> colaVehiculosPendientes; 
    private PilaReciclaje<Residuo> residuosParaProcesar; 
    private Map<String, Zona> mapaZonas; // Uso obligatorio de Mapas [cite: 86]
    private Map<String, Object> estadisticasGlobales; 
    
    // --- CONTROL DE ORDENAMIENTO ---
    private Comparator<Residuo> comparadorActivo; 
    
    // El comparador de vehículos necesita una referencia a la instancia del sistema
    private transient ComparadorVehiculo comparadorVehiculo; 

    /**
     * Constructor del Sistema. Inicializa todas las colecciones.
     */
    public Sistema() {
        this.listaResiduos = new ListaEnlazadaCircular<>();
        this.mapaZonas = new HashMap<>(); 
        this.estadisticasGlobales = new HashMap<>();
        this.residuosParaProcesar = new PilaReciclaje<>();
        
        // Inicialización de comparadores y cola de prioridad
        this.comparadorActivo = new ComparadorPrioridad();
        // NOTA: El comparador de vehículos se inicializa aquí y se pasa a la cola
        this.comparadorVehiculo = new ComparadorVehiculo(this);
        this.colaVehiculosPendientes = new ColaPrioridad<>(this.comparadorVehiculo);
    }
    
    // --- MÉTODOS DE PERSISTENCIA (Requerimiento 6) ---

    public void guardarEstado(String archivo) throws IOException {
        // Llama a tu método estático de Persistencia
        Persistencia.guardar(this, archivo);
    }

    public static Sistema cargarEstado(String archivo) throws IOException, ClassNotFoundException {
        // Llama a tu método estático de Persistencia
        Sistema sistemaCargado = Persistencia.cargar(archivo);
        // Es crucial re-inicializar los campos 'transient' (como el ComparadorVehiculo)
        sistemaCargado.reestablecerTransientes(); 
        return sistemaCargado;
    }
    
    // Método para re-inicializar los atributos que no se serializan
    private void reestablecerTransientes() {
        this.comparadorVehiculo = new ComparadorVehiculo(this);
        // Como la colaVehiculosPendientes usa el comparador, puede ser necesario reasignarlo
        this.colaVehiculosPendientes = new ColaPrioridad<>(this.comparadorVehiculo);
        // NOTA: La lógica de reasignación puede variar si usaste el comparador directamente
        // en el constructor de ColaPrioridad; si se serializó correctamente, solo basta con
        // re-establecer el objeto transient.
    }

    // --- MÉTODOS DE GESTIÓN DE RESIDUOS Y ZONAS ---
    
    /**
     * Registra un nuevo residuo y actualiza la zona.
     * @param residuo
     */
    public void registrarResiduo(Residuo residuo) {
        listaResiduos.agregar(residuo);
        Zona zona = mapaZonas.get(residuo.getZona());
        if (zona == null) {
            // Si la zona no existe, crearla (o manejar error)
            zona = new Zona(residuo.getZona(), "Zona " + residuo.getZona(), 0, 0); 
            mapaZonas.put(zona.getId(), zona);
        }
        zona.agregarResiduoPendiente(residuo); // Aumenta P_pendiente y recalcula u_z
        actualizarEstadisticas(residuo); 
        // Lógica: revisar si la zona requiere un nuevo vehículo en la cola
        revisarPrioridadDespacho(zona); 
    }
    
    /**
     * Lógica para revisar si la utilidad baja requiere acción (Requerimiento 47, 52).
     */
    private void revisarPrioridadDespacho(Zona zona) {
        // Si la utilidad es crítica, puede que haya que encolar un vehículo si hay uno disponible
        if (zona.getUtilidad() < -50.0) { // Umbral crítico
             // Ejemplo: Buscar un vehículo libre y encolarlo
             // Vehiculo v = obtenerVehiculoLibre(zona.getId()); 
             // if (v != null) colaVehiculosPendientes.encolar(v);
        }
    }
    
    // --- GETTERS CRUCIALES PARA EL COMPARADOR Y LA INTERFAZ ---

    public Map<String, Zona> getMapaZonas() {
        return mapaZonas;
    }
    
    public ListaEnlazadaCircular<Residuo> getListaResiduos() {
        return listaResiduos;
    }

    public PilaReciclaje<Residuo> getResiduosParaProcesar() {
        return residuosParaProcesar;
    }
    
    // ... (El resto de los métodos de Sistema, como actualizarEstadisticas, procesarResiduo, etc., permanecen)
    
    // Mismo método auxiliar de la implementación anterior
    private void actualizarEstadisticas(Residuo residuo) {
        // ... Lógica para actualizar estadísticas en mapa 'estadisticasGlobales' [cite: 65]
    }
}
