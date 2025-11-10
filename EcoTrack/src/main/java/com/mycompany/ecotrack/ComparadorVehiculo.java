/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.comparadores;

import Grupo_08.modelo.Sistema;
import Grupo_08.modelo.Vehiculo;
import Grupo_08.modelo.Zona;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class ComparadorVehiculo implements Comparator<Vehiculo> {
    private Sistema sistema;

    public ComparadorVehiculo(Sistema sistema) {
        this.sistema = sistema;
    }

    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        // 1. Obtener la utilidad de la zona asignada a cada vehículo
        Zona z1 = sistema.getMapaZonas().get(v1.getZonaAsignadaId());
        Zona z2 = sistema.getMapaZonas().get(v2.getZonaAsignadaId());

        // Manejar casos donde la zona no existe (debería ser null-safe)
        if (z1 == null && z2 == null) {
            return 0;
        } else if (z1 == null) {
            return 1; // v1 tiene menor prioridad (nula)
        } else if (z2 == null) {
            return -1; // v2 tiene menor prioridad (nula)
        }

        // 2. Comparar la utilidad:
        // Queremos que la utilidad más baja (más negativa) tenga MAYOR prioridad.
        // Por lo tanto, si la utilidad de z1 es menor que z2, z1 es más prioritario,
        // y debemos devolver un número negativo para colocarlo ANTES en la cola (Heap Máximo).
        
        // Si el comparador devuelve un valor NEGATIVO, el primer objeto (v1) es más alto en la prioridad.
        // Ejemplo: Si z1.utilidad = -4 y z2.utilidad = 5.0
        // Double.compare(-4.0, 5.0) -> devuelve -1 (z1 es menor)
        // Lo invertimos para que el Heap (que es un Max-Heap) maneje la baja utilidad como alta prioridad:
        return Double.compare(z2.getUtilidad(), z1.getUtilidad());
    }
}
