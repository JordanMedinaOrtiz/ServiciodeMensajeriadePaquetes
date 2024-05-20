/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.clases;

/**
 * Interfaz EventLocationSelected.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public interface EventLocationSelected {
    /**
     * Método invocado cuando se selecciona una ubicación.
     * @param location La ubicación seleccionada.
     */
    void oneSelected(String location);
}