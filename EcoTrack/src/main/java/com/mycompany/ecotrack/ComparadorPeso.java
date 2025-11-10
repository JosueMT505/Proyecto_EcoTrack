
package Grupo_08.comparadores;

import Grupo_08.modelo.Residuo;
import java.util.Comparator;

/**
 *
 * @author Grupo 8 
 */
public class ComparadorPeso implements Comparator<Residuo> {
    @Override
    public int compare(Residuo r1, Residuo r2) {
        return Double.compare(r1.getPeso(), r2.getPeso());
    }
}
