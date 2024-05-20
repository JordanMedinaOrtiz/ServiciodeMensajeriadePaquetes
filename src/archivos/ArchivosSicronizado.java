/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package archivos;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *  Clase Archivos Sincronizado extendido de Thread
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class ArchivosSicronizado extends Thread {
    /**
     * Variable de instancia.
     */
    private final String nombre;

    /**
     * Constructor.
     * @param nombre 
     */
    public ArchivosSicronizado(String nombre) {
        this.nombre = nombre;
    }
    
    /**
    * Abre el archivo especificado, utilizando el programa predeterminado asociado con ese tipo de archivo.
    *
    * Este método intenta abrir el archivo especificado utilizando el programa predeterminado.
    * Se sincroniza para garantizar la seguridad de subprocesos al acceder al sistema de archivos.
    */
    public synchronized void run() {
        File path = new File("src/archivos/", nombre);
        try {
            Desktop.getDesktop().open(path);
        }catch(IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
