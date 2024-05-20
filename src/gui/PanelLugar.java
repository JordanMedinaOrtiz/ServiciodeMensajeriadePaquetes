/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import gui.clases.EventLocationSelected;

/**
 * Clase Panel Lugar extendida de javax.swing.JPanel
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class PanelLugar extends javax.swing.JPanel {

   /**
    * Contructor.
    * Crea una nueva instancia del panel de lugar.
    */
    public PanelLugar() {
        initComponents();
        mapaCustom1.setEvent(new EventLocationSelected() {
            @Override
            public void oneSelected(String location) {
                txtLocacion.setText(location);
            }
            
        });
        mapaCustom1.init();
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

        mapaCustom1 = new gui.mapa.MapaCustom();
        jLabel1 = new javax.swing.JLabel();
        txtLocacion = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(500, 300));

        javax.swing.GroupLayout mapaCustom1Layout = new javax.swing.GroupLayout(mapaCustom1);
        mapaCustom1.setLayout(mapaCustom1Layout);
        mapaCustom1Layout.setHorizontalGroup(
            mapaCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mapaCustom1Layout.setVerticalGroup(
            mapaCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Dirección:");

        txtLocacion.setEditable(false);
        txtLocacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtLocacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapaCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocacion, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapaCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private gui.mapa.MapaCustom mapaCustom1;
    private javax.swing.JTextField txtLocacion;
    // End of variables declaration//GEN-END:variables
}