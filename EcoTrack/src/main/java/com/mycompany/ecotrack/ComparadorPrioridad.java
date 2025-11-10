
package com.mycompany.ecotrack;

import java.util.Comparator;

/**
 *
 * @author Grupo 8
 */
public class ComparadorPrioridad implements Comparator<Residuo> {
    @Override
    public int compare(Residuo r1, Residuo r2) {
        return Integer.compare(r2.getNivelPrioridadAmbiental(), r1.getNivelPrioridadAmbiental());
    }
}
