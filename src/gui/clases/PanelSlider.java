/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.clases;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * Clase Panel Slider extendida de JPanel.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mxs
 */
public class PanelSlider extends JPanel {
    /**
     * Variable de instancia.
     */
    private Component[] sliderComponent;
    /**
     * Variable de instancia.
     */
    private final Component[] components = new Component[2];
    /**
     * Variable de instancia.
     */
    private final List<EventSliderAnimatorChanged> events = new ArrayList<>();
    /**
     * Variable de instancia.
     */
    private Animator animator;
    /**
     * Variable de instancia.
     */
    private float animate;
    /**
     * Variable de instancia.
     */
    private SliderType type;
    /**
     * Variable de instancia.
     */
    private MigLayout layout;

    /**
     * Crea un nuevo PanelSlider e inicializa su diseño.
     */
    public PanelSlider() {
        init();
    }

    /**
     * Inicializa el diseño del PanelSlider.
     */
    private void init() {
        layout = new MigLayout();
        setLayout(layout);
        layout.addLayoutCallback(new LayoutCallback() {
            @Override
            public void correctBounds(ComponentWrapper cw) {
                change(cw);
            }
        });
        animator = new Animator(500, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                revalidate();
                runEvent(fraction);
            }
        });
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
    }

    /**
     * Cambia la posición de los componentes según el tipo de deslizador.
     * @param cw El componente a cambiar.
     */
    public void change(ComponentWrapper cw) {
        int width = getWidth();
        int height = getHeight();
        int x = 0;
        int y = 0;
        int x2 = 0;
        int y2 = 0;
        switch (type) {
            case LEFT_TO_RIGHT:
                x = (int) -(width * (1f - animate));
                x2 = (int) (width * animate);
                break;
            case RIGHT_TO_LEFT:
                x = (int) (width - (width * animate));
                x2 = (int) -(width * animate);
                break;
            case TOP_TO_BOTTOM:
                y = (int) -(height * (1f - animate));
                y2 = (int) (height * animate);
                break;
            case BOTTOM_TO_TOP:
                y = (int) (height - (height * animate));
                y2 = (int) -(height * animate);
                break;
            default:
                x2 = width;
                y2 = 0;
        }
        if (cw.getComponent() == components[0]) {
            cw.setBounds(x, y, width, height);
        }
        if (cw.getComponent() == components[1]) {
            cw.setBounds(x2, y2, width, height);
        }
    }

    /**
     * Verifica si el deslizador se puede mover.
     * @return true si el deslizador se puede mover, de lo contrario false.
     */
    public boolean isSlidAble() {
        return !animator.isRunning();
    }

    /**
     * Muestra el componente en el deslizador con el tipo especificado.
     * @param component El componente a mostrar.
     * @param type El tipo de deslizador.
     */
    public synchronized void showSlid(Component component, SliderType type) {
        if (!animator.isRunning()) {
            this.type = type;
            if (components[1] != null) {
                remove(components[1]);
            }
            components[1] = components[0];
            components[0] = component;
            add(component, "pos 0 0");
            if (type == SliderType.NONE) {
                animate = 1;
                revalidate();
            } else {
                animator.start();
            }
        }
    }

    /**
     * Agrega un EventSliderAnimatorChanged al PanelSlider.
     * @param event El evento a agregar.
     */
    public void addEventSliderAnimatorChanged(EventSliderAnimatorChanged event) {
        events.add(event);
    }

    /**
     * Ejecuta el evento con el valor especificado.
     * @param f El valor del evento.
     */
    private void runEvent(float f) {
        for (EventSliderAnimatorChanged event : events) {
            event.animatorChange(type, f);
        }
    }

    /**
     * Obtiene los componentes del deslizador.
     * @return Los componentes del deslizador.
     */
    public static enum SliderType {
        LEFT_TO_RIGHT, RIGHT_TO_LEFT, TOP_TO_BOTTOM, BOTTOM_TO_TOP, NONE
    }

    /**
     * Establece los componentes del deslizador.
     * @param sliderComponent Los componentes del deslizador.
     */
    public Component[] getSliderComponent() {
        return sliderComponent;
    }

    /**
     * Enumeración que representa los tipos de deslizadores.
     */
    public void setSliderComponent(Component[] sliderComponent) {
        this.sliderComponent = sliderComponent;
    }
}