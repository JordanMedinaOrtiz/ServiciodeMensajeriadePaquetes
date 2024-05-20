/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.drawer;

import gui.AgregarPaquete;
import gui.ConsultaEntrega;
import gui.ConsultarEmpleado;
import gui.EliminarEmpleado;
import gui.Login;
import gui.ModificarEmpleado;
import java.sql.Connection;
import raven.drawer.Drawer;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.swing.AvatarIcon;
import raven.tabbed.WindowsTabbed;

/**
 * Clase Registra extendida de SimpleDrawerBuilder.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Registra extends SimpleDrawerBuilder {
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
    public Registra(String email, String nombre, Connection con) {
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
            {"Modificar", "Dirección", "Teléfono", "Email", "Rol"},
            {"Consultar", "Número de Empleado", "Teléfono", "Email", "Rol"},
            {"Eliminar"},
            {"~ENTREGA~"},
            {"Agregar"},
            {"Consultar", "Número de Entrega", "Estado"},
            {"Cerrar Sesión"}
        };
        
        String icons[] = {
            "modificar.svg",
            "buscar.svg",
            "eliminar.svg",
            "agregar-paquete.svg",
            "buscar.svg",
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
                            case 1:
                                if(subIndex == 1) {
                                    String title = (index == 0) ? "Modificar Dirección del Empleado" : "Consultar por ID de Empleado del Empleado";
                                    WindowsTabbed.getInstance().addTab(title, (index == 0) ? new ModificarEmpleado(con, subIndex) : new ConsultarEmpleado(con, subIndex));
                                }else if(subIndex == 2) {
                                    String title = (index == 0) ? "Modificar Teléfono del Empleado" : "Consultar por Teléfono del Empleado";
                                    WindowsTabbed.getInstance().addTab(title, (index == 0) ? new ModificarEmpleado(con, subIndex) : new ConsultarEmpleado(con, subIndex));
                                }else if(subIndex == 3) {
                                    String title = (index == 0) ? "Modificar Email del Empleado" : "Consultar por Email del Empleado";
                                    WindowsTabbed.getInstance().addTab(title, (index == 0) ? new ModificarEmpleado(con, subIndex) : new ConsultarEmpleado(con, subIndex));
                                }else if(subIndex == 4) {
                                    String title = (index == 0) ? "Modificar Rol del Empleado" : "Consultar por Rol del Empleado";
                                    WindowsTabbed.getInstance().addTab(title, (index == 0) ? new ModificarEmpleado(con, subIndex) : new ConsultarEmpleado(con, subIndex));
                                }
                                if(subIndex > 0 && subIndex <= 5) {
                                    Drawer.getInstance().closeDrawer();
                                }
                                break;
                            case 2:
                                WindowsTabbed.getInstance().addTab("Eliminar Empleado", new EliminarEmpleado(con));
                                Drawer.getInstance().closeDrawer();
                                break;
                            case 3:
                                WindowsTabbed.getInstance().addTab("Agregar Paquete", new AgregarPaquete(con));
                                Drawer.getInstance().closeDrawer();
                                break;
                            case 4:
                                if(subIndex == 1) {
                                    WindowsTabbed.getInstance().addTab("Consultar Paquete por Número de Entrega", new ConsultaEntrega(con, subIndex));
                                }else if(subIndex == 2) {
                                    WindowsTabbed.getInstance().addTab("Consultar Paquete por Estado de Entrega", new ConsultaEntrega(con, subIndex));
                                }
                                if(subIndex > 0 && subIndex <= 3) {
                                    Drawer.getInstance().closeDrawer();
                                }
                                break;
                            case 5:
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