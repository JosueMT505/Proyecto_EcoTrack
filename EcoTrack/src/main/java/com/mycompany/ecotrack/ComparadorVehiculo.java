
package com.mycompany.ecotrack;

import java.util.Comparator;

/**
 *
 * @author Grupo 8
 */
public class ComparadorVehiculo implements Comparator<Vehiculo> {
    private Sistema sistema;

    public ComparadorVehiculo(Sistema sistema) {
        this.sistema = sistema;
    }

    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        Zona z1 = sistema.getMapaZonas().get(v1.getZonaAsignadaId());
        Zona z2 = sistema.getMapaZonas().get(v2.getZonaAsignadaId());

        if (z1 == null && z2 == null) {
            return 0;
        } else if (z1 == null) {
            return 1; 
        } else if (z2 == null) {
            return -1;
        }

        return Double.compare(z2.getUtilidad(), z1.getUtilidad());
    }
}
