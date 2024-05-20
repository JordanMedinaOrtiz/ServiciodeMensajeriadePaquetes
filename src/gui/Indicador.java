/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import tabbed.TabbedForm;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;

/**
 * Clase Indicador extendida de TabbedForm.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Indicador extends TabbedForm {
    /**
     * Variable de instancia.
     */
    private final Connection con;
    /**
     * Variable de instancia.
     */
    private String estado;
    /**
     * Variable de instancia.
     */
    private String direccion;
    /**
     * Variable de instancia.
     */
    private String idPaquete;
    /**
     * Variable de instancia.
     */
    private String nuevoEstado;
    /**
     * Variable de instancia.
     */
    private int fila;
    
    /**
    * Crea una nueva instancia del indicador de progreso.
    * 
    * @param con La conexión a la base de datos.
    * @param estado El estado del paquete.
    * @param direccion La dirección de entrega del paquete.
    * @param idPaquete El ID del paquete.
    * @param fila La fila en la que se muestra el indicador.
    */
    public Indicador(Connection con, String estado, String direccion, String idPaquete, int fila) {
        initComponents();
        this.con = con;
        this.estado = estado;
        this.direccion = direccion;
        this.idPaquete = idPaquete;
        this.fila = fila;
        setBackground(Color.WHITE);
        setOpaque(false);
        Component[] components = new Component[]{new PanelPaso(0), new PanelLugar(), new PanelPaso(2)};
        panelSlider.setSliderComponent(components);
        progressIndicator.initSlider(panelSlider);
        if(estado.equals("En proceso")) {
            progressIndicator.next();
        }else if(estado.equals("Entregado")) {
            progressIndicator.setProgress(1);
            progressIndicator.next();
            progressIndicator.setProgress(2);
            progressIndicator.next();
        }
    }

    /**
    * Método que pinta el componente.
    * 
    * @param g El contexto de gráficos.
    */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
        g2.dispose();
        super.paintComponent(g);
    }

    /**
    * Inicializa los componentes de la interfaz gráfica.
    * 
    * Este método se llama desde el constructor para inicializar los componentes de la interfaz gráfica.
    * Se genera automáticamente por el Editor de Formularios y se advierte contra su modificación manual.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressIndicator = new gui.clases.ProgressIndicator();
        panelSlider = new gui.clases.PanelSlider();
        botonNext = new gui.clases.Boton();

        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        progressIndicator.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Recibido", "En Entrega", "Entregado" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        progressIndicator.setOpaque(false);
        progressIndicator.setProgress(0.0F);
        progressIndicator.setProgressColorGradient(new java.awt.Color(255, 0, 51));
        progressIndicator.setProgressFill(true);
        progressIndicator.setProgressFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N

        panelSlider.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelSlider.setOpaque(false);

        botonNext.setText("Siguiente Paso");
        botonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressIndicator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Método que se ejecuta cuando se hace clic en el botón siguiente.
    * 
    * @param evt El evento de acción que desencadena el método.
    */
    private void botonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNextActionPerformed
        if(estado.equals("Activo")){
            nuevoEstado = "En proceso";
        }else if(estado.equals("En proceso")) {
            nuevoEstado = "Entregado";
        }
        
        MessageAlerts.getInstance().showMessage("Confirmación de Modificación de Estado de Paquete", "Por favor, confirma si deseas modificar el estado del paquete. Esta acción actualizará la información del usuario en el sistema. ¿Estás seguro de proceder?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
            @Override
            public void action(PopupController pc, int i) {
                if(i == MessageAlerts.YES_OPTION) {
                    try {
                        Statement sts = con.createStatement();
                        String actualizarUsuario = "UPDATE entrega " +
                                "SET estado = '"+ nuevoEstado + "' " +
                                "WHERE idPaquete = '" + idPaquete +"'";
                        sts.executeUpdate(actualizarUsuario);
                        MessageAlerts.getInstance().showMessage("Éxito al Modificar Estado", "¡Estado de paquete modificado correctamente! Los cambios se han guardado exitosamente.", MessageAlerts.MessageType.SUCCESS);
                        progressIndicator.next();
                    }catch(SQLException ex) {
                        System.out.println(ex);
                    }

                }
            }
        });
    }//GEN-LAST:event_botonNextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.clases.Boton botonNext;
    private gui.clases.PanelSlider panelSlider;
    private gui.clases.ProgressIndicator progressIndicator;
    // End of variables declaration//GEN-END:variables
}