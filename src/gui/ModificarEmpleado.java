/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import gui.clases.TableGradientCell;
import com.formdev.flatlaf.FlatClientProperties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import tabbed.TabbedForm;

/**
 * Clase Modificar Empleado extendida de TabbedForm
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class ModificarEmpleado extends TabbedForm {
    /**
     * Variable de instancia.
     */
    private final Connection con;
    /**
     * Variable de instancia.
     */
    private int opc;
    /**
     * Variable de instancia.
     */
    private Statement sts;

    /**
    * Constructor.
    * Crea una nueva instancia de la ventana de modificación de empleados.
    * 
    * @param con La conexión a la base de datos.
    * @param opc La opción de modificación.
    */
    public ModificarEmpleado(Connection con, int opc) {
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
        modificarEmpladoDatos();
        this.opc = opc;
    }
    
    /**
    * Obtiene y muestra los datos de los empleados para su modificación.
    */
    private void modificarEmpladoDatos() {
        String rol = null;
        try{
            DefaultTableModel model = (DefaultTableModel)tablaEmpleado.getModel();
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
    * Actualiza los datos de un empleado en la tabla.
    * 
    * @param nuevoValor El nuevo valor para actualizar.
    * @param fila La fila en la que se encuentra el dato a actualizar.
    * @param columna La columna en la que se encuentra el dato a actualizar.
    */
    public void actualizarEmpleadoDatos(String nuevoValor, int fila, int columna) {
        DefaultTableModel model = (DefaultTableModel)tablaEmpleado.getModel();
        model.setValueAt(nuevoValor, fila, columna);
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadoMouseClicked(evt);
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
    * Maneja el evento de clic del ratón en la tabla de empleados para realizar modificaciones en los datos del empleado seleccionado.
    * Dependiendo de la opción de modificación (`opc`), realiza diferentes acciones.
    *
    * @param evt El evento de clic del ratón.
    */
    private void tablaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadoMouseClicked
        int fila = tablaEmpleado.getSelectedRow();
        String idEmpleado = (String)tablaEmpleado.getValueAt(fila, 0);
        if(opc == 1) {
            String direccion = (String)tablaEmpleado.getValueAt(fila, 2);
            String nuevaDireccion = JOptionPane.showInputDialog(this, "Ingrese la nueva dirección del empleado:", direccion);     
            if(nuevaDireccion != null) {
                MessageAlerts.getInstance().showMessage("Confirmación de Modificación de Dirección de Usuario", "Por favor, confirma si deseas modificar la dirección del usuario. Esta acción actualizará la información del usuario en el sistema. ¿Estás seguro de proceder?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if(i == MessageAlerts.YES_OPTION) {
                            try {
                                sts = con.createStatement();
                                String actualizarUsuario = "UPDATE empleado " +
                                        "SET direccion = '"+ nuevaDireccion + "' " +
                                        "WHERE idEmpleado = '" + idEmpleado +"'";
                                sts.executeUpdate(actualizarUsuario);
                                MessageAlerts.getInstance().showMessage("Éxito al Modificar Usuario", "¡Usuario modificado correctamente! Los cambios se han guardado exitosamente.", MessageAlerts.MessageType.SUCCESS);
                                actualizarEmpleadoDatos(nuevaDireccion, fila, 2);
                            }catch(SQLException ex) {
                                System.out.println(ex);
                            }

                        }
                    }
                });
            }
        }
        if(opc == 2) {
            String telefono = (String)tablaEmpleado.getValueAt(fila, 3);
            String nuevoTelefono = JOptionPane.showInputDialog(this, "Ingrese el nuevo teléfono del empleado:", telefono);
            if(!nuevoTelefono.matches("\\d+")) {
                MessageAlerts.getInstance().showMessage("Error de Validación", "El teléfono solo puede contener números.", MessageAlerts.MessageType.ERROR);
                return;
            }
            if(nuevoTelefono != null) {
                MessageAlerts.getInstance().showMessage("Confirmación de Modificación de Teléfono de Usuario", "Por favor, confirma si deseas modificar el teléfono del usuario. Esta acción actualizará la información del usuario en el sistema. ¿Estás seguro de proceder?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if(i == MessageAlerts.YES_OPTION) {
                            try {
                                sts = con.createStatement();
                                String actualizarUsuario = "UPDATE empleado " +
                                        "SET telefono = '"+ nuevoTelefono + "' " +
                                        "WHERE idEmpleado = '" + idEmpleado +"'";
                                sts.executeUpdate(actualizarUsuario);
                                MessageAlerts.getInstance().showMessage("Éxito al Modificar Usuario", "¡Usuario modificado correctamente! Los cambios se han guardado exitosamente.", MessageAlerts.MessageType.SUCCESS);
                                actualizarEmpleadoDatos(nuevoTelefono, fila, 3);
                            }catch(SQLException ex) {
                                System.out.println(ex);
                            }

                        }
                    }
                });
            }
        }
        if(opc == 3) {
            String email = (String)tablaEmpleado.getValueAt(fila, 4);
            String nuevoEmail = JOptionPane.showInputDialog(this, "Ingrese el nuevo email del empleado:", email);
            if(nuevoEmail != null) {
                MessageAlerts.getInstance().showMessage("Confirmación de Modificación de Email de Usuario", "Por favor, confirma si deseas modificar el email del usuario. Esta acción actualizará la información del usuario en el sistema. ¿Estás seguro de proceder?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if(i == MessageAlerts.YES_OPTION) {
                            try {
                                sts = con.createStatement();
                                String actualizarUsuario = "UPDATE empleado " +
                                        "SET email = '"+ nuevoEmail + "' " +
                                        "WHERE idEmpleado = '" + idEmpleado +"'";
                                sts.executeUpdate(actualizarUsuario);
                                MessageAlerts.getInstance().showMessage("Éxito al Modificar Usuario", "¡Usuario modificado correctamente! Los cambios se han guardado exitosamente.", MessageAlerts.MessageType.SUCCESS);
                                actualizarEmpleadoDatos(nuevoEmail, fila, 4);
                            }catch(SQLException ex) {
                                System.out.println(ex);
                            }

                        }
                    }
                });
            }
        }
        if(opc == 4) {
            String rol = (String)tablaEmpleado.getValueAt(fila, 5);
            String nuevoRol = JOptionPane.showInputDialog(this, "Ingrese el nuevo rol del empleado (Recepcionista, Repartidor, Logistica):", rol);
            
            if(!nuevoRol.equals("Recepcionista") && !nuevoRol.equals("Repartidor") && !nuevoRol.equals("Logistica")) {
                MessageAlerts.getInstance().showMessage("Error de Validación", "El rol ingresado no es válido. Asegúrate de haberlo escrito correctamente.", MessageAlerts.MessageType.ERROR);
                return;
            }

            if(!nuevoRol.matches("[a-zA-Z]+")) {
                MessageAlerts.getInstance().showMessage("Error de Validación", "El rol solo puede contener letras. Asegúrate de haberlo escrito correctamente.", MessageAlerts.MessageType.ERROR);
                return;
            }
            
            if(nuevoRol != null) {
                MessageAlerts.getInstance().showMessage("Confirmación de Modificación de Email de Usuario", "Por favor, confirma si deseas modificar el email del usuario. Esta acción actualizará la información del usuario en el sistema. ¿Estás seguro de proceder?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                    @Override
                    public void action(PopupController pc, int i) {
                        if(i == MessageAlerts.YES_OPTION) {
                            int rolRegistra = 0, rolEntrega = 0;
                            try {
                                if(nuevoRol.equals("Logistica")) {
                                    rolRegistra = 1;
                                    rolEntrega = 1;
                                }else if(nuevoRol.equals("Recepcionista")) {
                                    rolRegistra = 1;
                                }else if(nuevoRol.equals("Repartidor")) {
                                    rolEntrega = 1;
                                }
                                sts = con.createStatement();
                                String actualizarUsuario = "UPDATE empleado " +
                                        "SET rolRegistra = '" + rolRegistra + "', " +
                                        "rolEntrega = '" + rolEntrega + "' " +
                                        "WHERE idEmpleado = '" + idEmpleado + "'";
                                sts.executeUpdate(actualizarUsuario);
                                MessageAlerts.getInstance().showMessage("Éxito al Modificar Usuario", "¡Usuario modificado correctamente! Los cambios se han guardado exitosamente.", MessageAlerts.MessageType.SUCCESS);
                                actualizarEmpleadoDatos(nuevoRol, fila, 5);
                            }catch(SQLException ex) {
                                System.out.println(ex);
                            }

                        }
                    }
                });
            }
        }
    }//GEN-LAST:event_tablaEmpleadoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleado;
    // End of variables declaration//GEN-END:variables
}
