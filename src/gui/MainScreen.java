/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import gui.drawer.Administrador;
import gui.drawer.Entrega;
import gui.drawer.Logistica;
import gui.drawer.Registra;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.UIManager;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;
import raven.tabbed.WindowsTabbed;
import raven.toast.Notifications;

/**
 * Clase Main Screen extendida de javax.swing.JFrame
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class MainScreen extends javax.swing.JFrame {
    /**
     * Variable de instancia.
     */
    private String email, nombre;
    /**
     * Variable de instancia.
     */
    private Connection con;
    
    /**
    * Constructor sobre cargado.
    * Crea una nueva instancia de la pantalla principal.
    * 
    * @param email El correo electrónico del usuario.
    * @param nombre El nombre del usuario.
    * @param con La conexión a la base de datos.
    * @param rol El rol del usuario.
    */
    public MainScreen(String email, String nombre, Connection con, int rol) {
        this.email = email;
        this.nombre = nombre;
        this.con = con;
         GlassPanePopup.install(this);
        iniciarMenu(rol);
        initComponents();
        WindowsTabbed.getInstance().install(this, jPanel1);
        Notifications.getInstance().setJFrame(this);
    }
    
    /**
     * Constructor.
     */
    public MainScreen() {}
    
    /**
    * Inicia el menú según el rol del usuario.
    * 
    * @param rol El rol del usuario.
    */
    public void iniciarMenu(int rol) {
        if(rol == 1) {
            Registra registra = new Registra(email, nombre, con);
            Drawer.getInstance().setDrawerBuilder(registra);
        }else if(rol == 2) {
            Entrega entrega = new Entrega(email, nombre, con);
            Drawer.getInstance().setDrawerBuilder(entrega);
        }else if(rol == 3) {
            Logistica logistica = new Logistica(this.email, this.nombre, this.con);
            Drawer.getInstance().setDrawerBuilder(logistica);
        }else if(rol == 4) {
            Administrador admin = new Administrador(email, nombre, con);
            Drawer.getInstance().setDrawerBuilder(admin);
        }
        
    }
    
    /**
    * Muestra una notificación en función de la tabla especificada.
    * 
    * @param tabla El nombre de la tabla.
    */
    public void mostrarNotificacion(String tabla) {
        if(tabla.equals("Empleados")) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, "Se han realizado cambios en la tabla de empleados.");
        }else if(tabla.equals("Entregas")) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, "Se han realizado cambios en la tabla de entregas.");
        }else if(tabla.equals("Paquetes")) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, "Se han realizado cambios en la tabla de paquetes.");
        }else if(tabla.equals("Clientes")) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, "Se han realizado cambios en la tabla de clientes.");
        }
        
    }

    /**
    * Inicializa los componentes de la interfaz gráfica.
    * 
    * Este método se llama desde el constructor para inicializar los componentes de la interfaz gráfica.
    * Se genera automáticamente por el Editor de Formularios y se advierte contra su modificación manual.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1150, 700));
        setMinimumSize(new java.awt.Dimension(1150, 700));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Método principal para ejecutar la aplicación.
    * 
    * @param args Los argumentos de la línea de comandos.
    */
    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("rave.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}