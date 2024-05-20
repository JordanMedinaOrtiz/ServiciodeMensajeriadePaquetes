/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.drawer;

import gui.AgregarPaquete;
import gui.ConsultaEntrega;
import gui.Login;
import gui.ModificarPaquete;
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
 * Clase Entrega extendida de SimpleDrawerBuilder.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Entrega extends SimpleDrawerBuilder {
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
    public Entrega(String email, String nombre, Connection con) {
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
            {"~ENTREGA~"},
            {"Agregar"},
            {"Consultar", "Número de Entrega", "Estado"},
            {"Modificar Estado"},
            {"Cerrar Sesión"}
        };
        
        String icons[] = {
            "agregar-paquete.svg",
            "buscar.svg",
            "modificar.svg",
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
                                WindowsTabbed.getInstance().addTab("Agregar Paquete", new AgregarPaquete(con));
                                Drawer.getInstance().closeDrawer();
                                break;
                            case 1:
                                if(subIndex == 1) {
                                    WindowsTabbed.getInstance().addTab("Consultar Paquete por Número de Entrega", new ConsultaEntrega(con, subIndex));
                                }else if(subIndex == 2) {
                                    WindowsTabbed.getInstance().addTab("Consultar Paquete por Estado de Entrega", new ConsultaEntrega(con, subIndex));
                                }
                                if(subIndex > 0 && subIndex <= 3) {
                                    Drawer.getInstance().closeDrawer();
                                }
                                break;
                            case 2:
                                WindowsTabbed.getInstance().addTab("Modificar Estado", new ModificarPaquete(con));
                                Drawer.getInstance().closeDrawer();
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