/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;

/**
 * Clase Rounded Border implemetando metodos de Border.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class RoundedBorder implements Border {
    /**
     * Variable de instancia.
     */
    private int radio;

    /**
     * Constructor.
     *
     * @param radio El radio de esquina del borde.
     */
    public RoundedBorder(int radio) {
        this.radio = radio;
    }
    
    /**
     * Método para pintar el borde redondeado.
     *
     * @param c      El componente al que se aplica el borde.
     * @param g      El objeto Graphics utilizado para dibujar el borde.
     * @param x      La coordenada x del borde.
     * @param y      La coordenada y del borde.
     * @param width  El ancho del borde.
     * @param height La altura del borde.
     */
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GRAY);
        g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, radio, radio));
        g2d.dispose();
    }

    /**
     * Método para obtener los márgenes del borde redondeado.
     *
     * @param c El componente al que se aplica el borde.
     * @return Los márgenes del borde.
     */
     @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radio + 1, this.radio + 1, this.radio + 2, this.radio);
    }

    /**
     * Método que indica si el borde es opaco o no.
     *
     * @return true si el borde es opaco, false en caso contrario.
     */
     @Override
    public boolean isBorderOpaque() {
        return false;
    }
}