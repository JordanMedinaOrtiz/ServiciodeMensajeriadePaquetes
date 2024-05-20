/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import java.sql.Connection;
import tabbed.TabbedForm;
import gui.Indicador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import raven.tabbed.WindowsTabbed;

/**
 * Clase Modificar Paquete extendida de TabbedForm.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class ModificarPaquete extends TabbedForm {
    /**
     * Variable de instancia.
     */
    private final Connection con;
    
    /**
    * Constructor.
    * Crea una nueva instancia de la ventana de Modificar Paquete.
    * 
    * @param con La conexión a la base de datos.
    */
    public ModificarPaquete(Connection con) {
        initComponents();
        this.con = con;
        modificarEntregaDatos();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaquete = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1150, 700));
        setMinimumSize(new java.awt.Dimension(1150, 700));

        tablaPaquete.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaPaquete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID de la Entrega", "Estado", "ID del Paquete", "ID del Empleado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPaquete.setFocusable(false);
        tablaPaquete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPaqueteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPaquete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Maneja el evento de clic del ratón en la tabla de paquetes para mostrar el indicador de estado del paquete seleccionado.
    * 
    * @param evt El evento de clic del ratón.
    */
    private void tablaPaqueteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPaqueteMouseClicked
        try {
            int fila = tablaPaquete.getSelectedRow();
            
            String idEntrega = (String)tablaPaquete.getValueAt(fila, 0);
            String estado = (String)tablaPaquete.getValueAt(fila, 1);
            String idPaquete = (String)tablaPaquete.getValueAt(fila, 2);
            String idEmpleado = (String)tablaPaquete.getValueAt(fila, 3);
            
            Statement sts = con.createStatement();
            sts.execute("SELECT direccion FROM paquete WHERE idPaquete = '" + idPaquete + "'");
            ResultSet rs = sts.getResultSet();
            while(rs.next()) {
                String direccion = rs.getString("direccion");
                WindowsTabbed.getInstance().addTab("Indicador de Estado del Paquete", new Indicador(con, estado, direccion, idPaquete, fila));
            }
            
        }catch(SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_tablaPaqueteMouseClicked

    /**
    * Obtiene los datos de entrega de la base de datos y los muestra en la tabla de paquetes.
    */
    private void modificarEntregaDatos() {
        String rol = null;
        try{
            DefaultTableModel model = (DefaultTableModel)tablaPaquete.getModel();
            Statement sts = con.createStatement();
            sts.execute("SELECT idEntrega, estado, idPaquete, idEmpleado FROM entrega");
            ResultSet rs = sts.getResultSet();
            while(rs.next()) {
                String idEntrega = rs.getString("idEntrega");
                String estado = rs.getString("estado");
                String idPaquete = rs.getString("idPaquete");
                String idEmpleado = rs.getString("idEmpleado");
                model.addRow(new Object[]{idEntrega, estado, idPaquete, idEmpleado});
            }
        }catch(SQLException err) {
            System.out.println(err);
        }
    }
    
    /**
    * Actualiza los datos de entrega en la tabla de paquetes con el nuevo valor proporcionado.
    * 
    * @param nuevoValor El nuevo valor a establecer.
    * @param fila La fila en la que se actualizará el valor.
    * @param columna La columna en la que se actualizará el valor.
    */
    public void actualizarEntregaDatos(String nuevoValor, int fila, int columna) {
        DefaultTableModel model = (DefaultTableModel)tablaPaquete.getModel();
        model.setValueAt(nuevoValor, fila, columna);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPaquete;
    // End of variables declaration//GEN-END:variables
}