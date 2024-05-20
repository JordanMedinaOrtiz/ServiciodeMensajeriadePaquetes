/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui.clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase Table Gradient Cell extendida de DefaultTableCellRenderer.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class TableGradientCell extends DefaultTableCellRenderer {

    /**
     * Crea una nueva celda de tabla con un fondo de degradado predeterminado.
     */
    public TableGradientCell() {
        this(Color.decode("#ff0f7b"), Color.decode("#f89b29"));
    }

     /**
     * Constructor
     * Crea una nueva celda de tabla con un fondo de degradado personalizado.
     *
     * @param color1 Primer color del degradado.
     * @param color2 Segundo color del degradado.
     */
    public TableGradientCell(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(false);
    }
    
    /**
     * Variable de instancia.
     */
    private Color color1;
    /**
     * Variable de instancia.
     */
    private Color color2;
    /**
     * Variable de instancia.
     */
    private int x;
    /**
     * Variable de instancia.
     */
    private int width;
    /**
     * Variable de instancia.
     */
    private boolean isSelected;
    /**
     * Variable de instancia.
     */
    private int row;
    
    /**
     * Obtiene el componente de celda de tabla para renderizar.
     *
     * @param table       La tabla.
     * @param value       El valor a mostrar en la celda.
     * @param isSelected  Indica si la celda está seleccionada.
     * @param hasFocus    Indica si la celda tiene el foco.
     * @param row         El índice de la fila de la celda.
     * @param column      El índice de la columna de la celda.
     * @return El componente de celda de tabla para renderizar.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Rectangle cellRec = table.getCellRect(row, column, true);
        x =- cellRec.x;
        width = table.getWidth()-cellRec.x;
        this.isSelected = isSelected;
        this.row = row;
        return com;
    }
    
    /**
     * Pinta el fondo de la celda de tabla.
     *
     * @param g El contexto de gráficos en el que se va a pintar el fondo de la celda.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        if(isSelected) {
           g2.setPaint(new GradientPaint(x, 0, color1, width, 0, color2));
           g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));   
        }else if(row%2 == 0){
            g2.setPaint(new GradientPaint(x, 0, Color.decode("#BDBDBD"), width, 0, Color.decode("#E0E0E0")));
            g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        }
        g2.dispose();
        super.paintComponent(g);
    }
}