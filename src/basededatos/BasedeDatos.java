/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package basededatos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Clase Base de Datos
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class BasedeDatos {
    /**
    * Punto de entrada principal de la aplicación.
    *
    * Este método es el punto de entrada principal de la aplicación. Crea una instancia de la clase Conexion para establecer
    * una conexión con la base de datos y obtiene una referencia a la conexión creada. No se realizan operaciones adicionales
    * en este método.
    *
    * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
    * @throws SQLException Si ocurre un error al conectar con la base de datos.
    * @throws FileNotFoundException Si no se encuentra el archivo especificado.
    * @throws IOException Si ocurre un error de entrada/salida.
    */
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
    }
}