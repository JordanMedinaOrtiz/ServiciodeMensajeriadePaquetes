/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase Conexion.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Conexion {
    /**
     * Variable de la instancia.
     */
    private Connection con;
    
    /**
    * Establece una conexión con la base de datos.
    *
    * Este método intenta establecer una conexión con la base de datos utilizando el controlador JDBC proporcionado.
    * Si la conexión se establece con éxito, se imprime un mensaje de éxito en la consola. Si ocurre algún error durante el proceso,
    * se imprime un mensaje de error en la consola y se captura la excepción.
    *
    * @return La conexión establecida con la base de datos.
    */
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/serviciomensajeria", "root", "");
            System.out.println("OK :)");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error :(" + e);
        }
        
        return con;
    }
    
    /**
    * Crea un objeto Statement para ejecutar consultas SQL.
    *
    * Este método está actualmente sin implementar y lanza una excepción UnsupportedOperationException.
    * No se recomienda su uso hasta que se implemente adecuadamente.
    *
    * @throws UnsupportedOperationException Si se intenta utilizar este método sin implementar.
    */
    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
