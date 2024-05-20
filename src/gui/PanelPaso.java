/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

/**
 * Clase Panel Paso extendida de javax.swing.JPanel.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class PanelPaso extends javax.swing.JPanel {

    /**
    * Crea una nueva instancia del panel de paso.
    * @param paso El paso del paquete: 0 para "Paquete recibido en paquetería", 1 para "Paquete siendo entregado", 2 para "Paquete entregado".
    */
    public PanelPaso(int paso) {
        initComponents();
        if(paso == 0) {
            label.setText("Paquete recibido en paqueteria");
        }else if(paso == 1) {
            label.setText("Paquete siendo entregado" );
        }else if(paso == 2) {
            label.setText("Paquete entregado" );
        }
        
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

        label = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        label.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        label.setForeground(new java.awt.Color(125, 125, 125));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Recibido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}