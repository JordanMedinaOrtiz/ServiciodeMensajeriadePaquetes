/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.clases;

import gui.clases.PanelSlider;

/**
 * Interfaz EventSliderAnimatorChanged
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public interface EventSliderAnimatorChanged {
    /**
     * Método invocado cuando cambia el animador del deslizador.
     * @param type Tipo de deslizador.
     * @param f Valor del animador.
     */
    public void animatorChange(PanelSlider.SliderType type, float f);
}