/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package basededatos;

import gui.MainScreen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Clase Actualizacion de Datos implementando metodos de la clase Runnable.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class ActualizacionDeDatos implements Runnable {
    /**
     * Variable de instancia.
     */
    private Connection con;
    /**
     * Variable de instancia.
     */
    private boolean ejecutar;
    /**
     * Instancia un objeto de la clase MainScreen.
     */
    MainScreen notificacion = new MainScreen();

    /**
     * Constructor.
     * @param con 
     */
    public ActualizacionDeDatos(Connection con) {
        this.con = con;
        this.ejecutar = true;
    }

    /**
    * Inicia la verificación en un hilo separado.
    *
    * Este método crea un nuevo hilo y lo inicia para ejecutar la verificación periódica de modificaciones en la base de datos.
    * La verificación se realiza utilizando el método run() de esta clase.
    */
    public void iniciarVerificacion() {
        Thread hiloVerificacion = new Thread(this);
        hiloVerificacion.start();
    }

    /**
    * Detiene la verificación periódica.
    *
    * Este método detiene la verificación periódica estableciendo la bandera ejecutar en false.
    * La verificación se detendrá en el próximo ciclo de ejecución del hilo.
    */
    public void detenerVerificacion() {
        this.ejecutar = false;
    }

    /**
    * Ejecuta la verificación periódica de modificaciones en la base de datos.
    *
    * Este método implementa la interfaz Runnable y realiza la verificación periódica de modificaciones en la base de datos.
    * Envía notificaciones a la pantalla principal (notificacion) si se han producido modificaciones recientes en los registros de empleados, entregas, paquetes o clientes.
    * La verificación se realiza cada 60 segundos (intervalo).
    */
    @Override
    public void run() {
        long intervalo = 60000;

        while(ejecutar) {
            try {
                Statement stsEmpleado = con.createStatement();
                stsEmpleado.execute("SELECT MAX(fecha_modificacion) FROM empleado");
                ResultSet rsEmpleado = stsEmpleado.getResultSet();
                if(rsEmpleado.next()) {
                    LocalDateTime ultimaModificacion = rsEmpleado.getObject(1, LocalDateTime.class);
                    LocalDateTime ahora = LocalDateTime.now();
                    Duration duracion = Duration.between(ultimaModificacion, ahora);
                    long minutosPasados = duracion.toMinutes();
                    if(minutosPasados < 1) {
                        notificacion.mostrarNotificacion("Empleados");
                    }
                }
                
                Statement stsEntrega = con.createStatement();
                stsEntrega.execute("SELECT MAX(fecha_modificacion) FROM entrega");
                ResultSet rsEntrega = stsEntrega.getResultSet();
                if(rsEntrega.next()) {
                    LocalDateTime ultimaModificacion = rsEntrega.getObject(1, LocalDateTime.class);
                    LocalDateTime ahora = LocalDateTime.now();
                    Duration duracion = Duration.between(ultimaModificacion, ahora);
                    long minutosPasados = duracion.toMinutes();
                    if(minutosPasados < 1) {
                        notificacion.mostrarNotificacion("Entregas");
                    }
                }
                
                Statement stsPaquetes = con.createStatement();
                stsPaquetes.execute("SELECT MAX(fecha_modificacion) FROM paquete");
                ResultSet rsPaquetes = stsPaquetes.getResultSet();
                if(rsPaquetes.next()) {
                    LocalDateTime ultimaModificacion = rsPaquetes.getObject(1, LocalDateTime.class);
                    LocalDateTime ahora = LocalDateTime.now();
                    Duration duracion = Duration.between(ultimaModificacion, ahora);
                    long minutosPasados = duracion.toMinutes();
                    if(minutosPasados < 1) {
                        notificacion.mostrarNotificacion("Paquetes");
                    }
                }
                
                Statement stsClientes = con.createStatement();
                stsClientes.execute("SELECT MAX(fecha_modificacion) FROM cliente");
                ResultSet rsClientes = stsClientes.getResultSet();
                if(rsClientes.next()) {
                    LocalDateTime ultimaModificacion = rsClientes.getObject(1, LocalDateTime.class);
                    LocalDateTime ahora = LocalDateTime.now();
                    Duration duracion = Duration.between(ultimaModificacion, ahora);
                    long minutosPasados = duracion.toMinutes();
                    if(minutosPasados < 1) {
                        notificacion.mostrarNotificacion("Clientes");
                    }
                }
            }catch(SQLException ex) {
                System.out.println(ex);
            }
            try {
                Thread.sleep(intervalo);
            }catch(InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}