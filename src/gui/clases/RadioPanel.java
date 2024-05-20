/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;


/**
 * Clase Radio Panel extendida de JPanel.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class RadioPanel extends JPanel {
    /**
     * Variable de instancia.
     */
    private Color backgroundColor;
    /**
     * Variable de instancia.
     */
    private int cornerRadius = 15;

    /**
     * Constructor para crear un panel redondeado con un radio de esquina y un color de fondo dados.
     *
     * @param radius El radio de esquina del panel.
     * @param bgColor El color de fondo del panel.
     */
    public RadioPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
        setOpaque(false);
    }

    /**
     * Método para dibujar el componente del panel con esquinas redondeadas y color de fondo.
     *
     * @param g El objeto Graphics utilizado para dibujar el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(backgroundColor != null){
            graphics.setColor(backgroundColor);
        }else{
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, cornerRadius, cornerRadius);
    }
}