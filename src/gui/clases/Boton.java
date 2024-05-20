/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.clases;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * Clase Boton extendida de JButton.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Boton extends JButton {
    /**
     * Variable de instancia.
     */
    private boolean mousePress;

    /**
    * Crea un nuevo botón personalizado.
    * Este botón no tiene área de contenido rellenable y un borde vacío.
    */
    public Boton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(7,5,7,5));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton(me)) {
                    mousePress = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if(SwingUtilities.isLeftMouseButton(me)) {
                    mousePress = false;
                }
            }
            
        });
    }   

    /**
    * Pinta el componente del botón.
    * @param g El contexto gráfico en el que se pinta el componente.
    */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(mousePress) {
            g2.setColor(getBackground().darker());
        }else {
            g2.setColor(getBackground());
        }
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight()));
        g2.dispose();
        super.paintComponent(g);
    }
    
}