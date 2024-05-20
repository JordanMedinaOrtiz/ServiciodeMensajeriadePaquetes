/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import com.formdev.flatlaf.FlatClientProperties;
import gui.clases.TableGradientCell;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import tabbed.TabbedForm;

/**
 * Clase Eliminar Empleado extendida de TabbedForm.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class EliminarEmpleado extends TabbedForm {
    /**
     * Variable de instancia.
     */
    private final Connection con;
    
    /**
    * Constructor.
    * Crea una nueva instancia de la ventana para eliminar empleados.
    * 
    * @param con La conexión a la base de datos.
    */
    public EliminarEmpleado(Connection con) {
        initComponents();
        this.con = con;
        tablaEmpleado.setDefaultRenderer(Object.class, new TableGradientCell());
        tablaEmpleado.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        jScrollPane1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        jScrollPane1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
        consultarEmpladoDatos();
    }
    
    /**
    * Consulta los datos de los empleados y los muestra en la tabla.
    */
    private void consultarEmpladoDatos() {
        String rol = null;
        try{
            DefaultTableModel model = (DefaultTableModel)tablaEmpleado.getModel();
            model.setRowCount(0);
            Statement sts = con.createStatement();
            sts.execute("SELECT idEmpleado, nombre, direccion, telefono, email, rolRegistra, rolEntrega, admin FROM empleado");
            ResultSet rs = sts.getResultSet();
            while(rs.next()) {
                if(!(rs.getString("admin").equals("0"))){
                    rol = "Administrador";
                }else if(!(rs.getString("rolRegistra").equals("0"))){
                        rol = "Recepcionista";
                    }else if(!(rs.getString("rolEntrega").equals("0"))){
                        rol = "Repartidor";
                    }
                if(!(rs.getString("rolRegistra").equals("0")) && !(rs.getString("rolEntrega").equals("0"))) {
                    rol = "Logistica";
                }
                String idEmpleado = rs.getString("idEmpleado");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                model.addRow(new Object[]{idEmpleado, nombre, direccion, telefono, email, rol});
            }
        }catch(SQLException err) {
            System.out.println(err);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleado = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1150, 700));
        setMinimumSize(new java.awt.Dimension(1150, 700));

        tablaEmpleado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección", "Telefono", "Correo Electónico", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEmpleado.setFocusable(false);
        tablaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaEmpleadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleado);
        if (tablaEmpleado.getColumnModel().getColumnCount() > 0) {
            tablaEmpleado.getColumnModel().getColumn(0).setPreferredWidth(5);
            tablaEmpleado.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablaEmpleado.getColumnModel().getColumn(2).setPreferredWidth(200);
            tablaEmpleado.getColumnModel().getColumn(3).setPreferredWidth(50);
            tablaEmpleado.getColumnModel().getColumn(4).setPreferredWidth(100);
            tablaEmpleado.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Método llamado cuando se presiona el botón del ratón en la tabla de empleados.
    * 
    * @param evt El evento del mouse que activó el método.
    */
    private void tablaEmpleadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadoMousePressed
        int fila = tablaEmpleado.getSelectedRow();
        String id = (String)tablaEmpleado.getValueAt(fila, 0);
        int idEmpleado = Integer.parseInt(id);
        String nombre = (String)tablaEmpleado.getValueAt(fila, 1);
        MessageAlerts.getInstance().showMessage("¿Estás Seguro de Eliminar Este Usuario?", "Se eliminará permanentemente el usuario " + nombre +". Esta acción no se puede deshacer.", MessageAlerts.MessageType.ERROR, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
            @Override
            public void action(PopupController pc, int i) {
                if(i == MessageAlerts.YES_OPTION) {
                    try {
                        Statement sts = con.createStatement();
                        String eliminarUsuario = "DELETE FROM `empleado` WHERE `empleado`.`idEmpleado` = " + idEmpleado;
                        sts.executeUpdate(eliminarUsuario);
                        consultarEmpladoDatos();
                        MessageAlerts.getInstance().showMessage("Usuario Eliminado Exitosamente", "El usuario ha sido eliminado correctamente del sistema.", MessageAlerts.MessageType.SUCCESS);
                    }catch(SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_tablaEmpleadoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleado;
    // End of variables declaration//GEN-END:variables
}
