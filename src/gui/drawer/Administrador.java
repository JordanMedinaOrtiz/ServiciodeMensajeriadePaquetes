/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.drawer;

import archivos.Archivos;
import archivos.ArchivosSicronizado;
import archivos.Pdfs;
import gui.AgregarEmpleado;
import gui.Login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import raven.alerts.MessageAlerts;
import raven.drawer.Drawer;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import raven.swing.AvatarIcon;
import raven.tabbed.WindowsTabbed;

/**
 * Clase Administrador extendida de SimpleDrawerBuilder.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Administrador extends SimpleDrawerBuilder {
    /**
     * Variable de instancia.
     */
    private String email = "", nombre = "";
    /**
     * Variable de instancia.
     */
    private Connection con;

    /**
     * Constructor.
     * @param email
     * @param nombre
     * @param con 
     */
    public Administrador(String email, String nombre, Connection con) {
        this.nombre = nombre;
        this.email = email;
        this.con = con;
    }

    /**
    * Proporciona datos simples para la cabecera de la interfaz.
    */
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/img/logoTransparente.png"), 60, 60, 999))
                .setTitle("ENVÍOMEX")
                .setDescription("Tu mensajería de confianza.");
    }
    
    /**
     * Proporciona opciones de menú simples para la interfaz.
     */
    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~EMPLEADO~"},
            {"Agregar"},
            {"~ARCHIVOS~"},
            {"Actualizar Archivos"},
            {"Abrir Archivos"},
            {"Cerrar Sesión"}
        };
        
        String icons[] = {
            "agregar-usuario.svg",
            "recargar.svg",
            "abrir.svg",
            "cerrar-sesion.svg"
        };
        
        return new SimpleMenuOption().setMenus(menus).setIcons(icons)
                .setBaseIconPath("img/")
                .setIconScale(0.0225f)
                .addMenuEvent(new MenuEvent(){
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        switch(index) {
                            case 0:
                                try {
                                    WindowsTabbed.getInstance().addTab("Agregar Empleado", new AgregarEmpleado(con));
                                }catch(SQLException ex) {
                                    System.out.println(ex);
                                }
                                Drawer.getInstance().closeDrawer();
                                break;
                            case 1:
                                MessageAlerts.getInstance().showMessage("Confirmación de Actualización de Archivos", "¿Estás seguro de que deseas actualizar todos los archivos? Esta acción sobrescribirá los archivos existentes con los datos más recientes.", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                                    @Override
                                    public void action(PopupController pc, int i) {
                                        if(i == MessageAlerts.YES_OPTION) {
                                            Pdfs pdfs = new Pdfs(con);
                                            Archivos archivos = new Archivos(con);
                                            try {
                                                archivos.crearArchivo();
                                                pdfs.pdfEmpleado("Registros de Empleados");
                                                pdfs.pdfGrafica("Grafica de Roles de Empleados");
                                            }catch(SQLException | IOException ex) {
                                                System.out.println(ex);
                                            }
                                            MessageAlerts.getInstance().showMessage("Actualización Exitosa de Archivos", "Los archivos se han actualizado correctamente en el sistema. ¡Operación completada con éxito!", MessageAlerts.MessageType.SUCCESS);
                                        }
                                    }
                                });
                                break;
                            case 2:
                                MessageAlerts.getInstance().showMessage("Confirmación de Apertura de Archivos", "¿Estás seguro de que deseas abrir todos los archivos? Por favor, confirma tu elección.", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                                    @Override
                                    public void action(PopupController pc, int i) {
                                        if(i == MessageAlerts.YES_OPTION) {
                                            Thread hilo1 = new Thread(new ArchivosSicronizado("Aprobado.pdf"), "Aprobado PDF");
                                            Thread hilo2 = new Thread(new ArchivosSicronizado("Aprobado.xls"), "Aprobado XLS");
                                            Thread hilo3 = new Thread(new ArchivosSicronizado("ContraseñaIncorrecta.pdf"), "Contraseña Incorrecta PDF");
                                            Thread hilo4 = new Thread(new ArchivosSicronizado("ContraseñaIncorrecta.xls"), "Contraseña Incorrecta XLS");
                                            Thread hilo5 = new Thread(new ArchivosSicronizado("CorreoNoEncontrado.pdf"), "Correo No Encontrado PDF");
                                            Thread hilo6 = new Thread(new ArchivosSicronizado("CorreoNoEncontrado.xls"), "Correo No Encontrado XLS");
                                            Thread hilo7 = new Thread(new ArchivosSicronizado("Registros de Empleados.pdf"), "Empleado PDF");
                                            Thread hilo8 = new Thread(new ArchivosSicronizado("Empleados.xls"), "Empleado XLS");
                                            Thread hilo9 = new Thread(new ArchivosSicronizado("Grafica de Roles de Empleados.pdf"), "Empleado Grafica PDF");

                                            hilo1.setPriority(Thread.MAX_PRIORITY);
                                            hilo2.setPriority(Thread.MAX_PRIORITY);
                                            hilo3.setPriority(Thread.MAX_PRIORITY);
                                            hilo4.setPriority(Thread.MAX_PRIORITY);
                                            hilo5.setPriority(Thread.MAX_PRIORITY);
                                            hilo6.setPriority(Thread.MAX_PRIORITY);
                                            hilo7.setPriority(Thread.MAX_PRIORITY);
                                            hilo8.setPriority(Thread.MAX_PRIORITY);
                                            hilo9.setPriority(Thread.MAX_PRIORITY);

                                            hilo1.start();
                                            hilo2.start();
                                            hilo3.start();
                                            hilo4.start();
                                            hilo5.start();
                                            hilo6.start();
                                            hilo7.start();
                                            hilo8.start();
                                            hilo9.start();
                                            MessageAlerts.getInstance().showMessage("Apertura Exitosa de Archivos", "Los archivos se han abierto correctamente en el sistema. ¡Operación completada con éxito!", MessageAlerts.MessageType.SUCCESS);
                                        }
                                    }
                                });
                                break;
                            case 3:
                                new Login().setVisible(true);
                                break;
                }
                    }
                })
                .setMenuValidation(new MenuValidation(){
                    @Override
                    public boolean menuValidation(int index, int subIndex) {
                        return true;
                    }
                });   
    }

    /**
    * Proporciona datos simples para el pie de página de la interfaz.
    */
    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("Jordan Medina Ortíz - 179913")
                .setDescription("Proyecto Servicio de Mensajería");
    }
}