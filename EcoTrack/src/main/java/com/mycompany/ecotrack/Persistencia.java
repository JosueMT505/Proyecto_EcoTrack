
package com.mycompany.ecotrack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Grupo 8
 */
public class Persistencia {
    public static void guardar(Sistema sistema, String archivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(sistema);
        }
    }

    public static Sistema cargar(String archivo) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
        Sistema sistema = (Sistema) in.readObject();
        in.close();
        return sistema;
    }

}
