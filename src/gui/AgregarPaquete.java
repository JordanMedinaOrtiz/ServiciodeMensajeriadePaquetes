/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import gui.clases.RadioPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import tabbed.TabbedForm;

/**
 * Clase Agregar Paquete extendida de TabbedForm.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class AgregarPaquete extends TabbedForm {
    /**
     * Variable de instancia.
     */
    private final Connection con;
    /**
     * Variable de instancia.
     */
    private Statement sts;
    /**
     * Variable de instancia.
     */
    private String nuevoRegistroEntrega;
    /**
     * Variable de instancia.
     */
    private String nuevoRegistroPaquete;
    /**
     * Variable de instancia.
     */
    private int opc = 1;
    
    
    /**
    * Constructor.
    * 
    * Interfaz gráfica para agregar un nuevo paquete y envío al sistema.
    * 
    * Esta clase proporciona una interfaz gráfica para que los usuarios puedan agregar un nuevo paquete y su envío asociado al sistema.
    * Los usuarios pueden ingresar información como la dirección de entrega, el nombre del destinatario, la palabra clave del paquete,
    * así como seleccionar el cliente y empleado asociados.
    * 
    * @param con La conexión a la base de datos.
    */
    public AgregarPaquete(Connection con) {
        initComponents();
        this.con = con;
        try {
            seleccionCliente();
            seleccionEmpleado();
            actualizaIDPaquete();
            actualizaIDEntrega();
        }catch(SQLException ex) {
            System.out.println(ex);
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

        jPanel1 = new javax.swing.JPanel();
        labelIDCliente = new javax.swing.JLabel();
        labelIDEmpleado = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        labelTitle = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtIDEntrega = new javax.swing.JTextField();
        labelNombreRecibe = new javax.swing.JLabel();
        txtNombreRecibe = new javax.swing.JTextField();
        labelPalabraClave = new javax.swing.JLabel();
        txtPalabraClave = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        txtIDPaquete = new javax.swing.JTextField();
        labelNombreEmpleado = new javax.swing.JLabel();
        comboIDEmpleado = new javax.swing.JComboBox<>();
        labelIDEntrega = new javax.swing.JLabel();
        labelIDPaquete = new javax.swing.JLabel();
        comboIDCliente = new javax.swing.JComboBox<>();
        labelNombreCliente = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1150, 700));
        setMinimumSize(new java.awt.Dimension(1150, 700));

        jPanel1 = new RadioPanel(30, new Color(244, 244, 244));

        labelIDCliente.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelIDCliente.setText("ID del Cliente");

        labelIDEmpleado.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelIDEmpleado.setText("ID del Empleado");

        txtDireccion.setBorder(new gui.clases.RoundedBorder(8));
        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(204, 204, 204));
        txtDireccion.setText("Ingrese la dirección completa de la entrega del paquete");
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDireccionMousePressed(evt);
            }
        });

        labelTitle.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        labelTitle.setText("Registro de Nueva Envio");

        txtNombreEmpleado.setBorder(new gui.clases.RoundedBorder(8));
        txtNombreEmpleado.setEditable(false);
        txtNombreEmpleado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreEmpleado.setText("Nombre del Empleado");

        labelDireccion.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelDireccion.setText("Dirección de la Entrega del Paquete");

        txtIDEntrega.setBorder(new gui.clases.RoundedBorder(8));
        txtIDEntrega.setEditable(false);
        txtIDEntrega.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDEntrega.setText("ID de la Entrega");

        labelNombreRecibe.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelNombreRecibe.setText("Nombre de la Persona que Recibira el Paquete");

        txtNombreRecibe.setBorder(new gui.clases.RoundedBorder(8));
        txtNombreRecibe.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreRecibe.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreRecibe.setText("Ingrese el nombre completo de la persona que recibira el paquete");
        txtNombreRecibe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreRecibeMousePressed(evt);
            }
        });

        labelPalabraClave.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelPalabraClave.setText("Palabra Clave del Paquete");

        txtPalabraClave.setBorder(new gui.clases.RoundedBorder(8));
        txtPalabraClave.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPalabraClave.setForeground(new java.awt.Color(204, 204, 204));
        txtPalabraClave.setText("Ingrese la palabra clave del paquete");
        txtPalabraClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPalabraClaveMousePressed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnAgregar.setText("Registrar Paquete");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 128)));
        btnAgregar.setPreferredSize(new java.awt.Dimension(64, 23));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtIDEntrega.setBorder(new gui.clases.RoundedBorder(8));
        txtIDPaquete.setEditable(false);
        txtIDPaquete.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDPaquete.setText("ID del Paquete");

        labelNombreEmpleado.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelNombreEmpleado.setText("Nombre del Empleado");

        labelIDEntrega.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelIDEntrega.setText("ID de la Entrega");

        labelIDPaquete.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelIDPaquete.setText("ID del Paquete");

        comboIDCliente.setPreferredSize(new java.awt.Dimension(93, 21));

        labelNombreCliente.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelNombreCliente.setText("Nombre del Cliente");

        txtNombreEmpleado.setBorder(new gui.clases.RoundedBorder(8));
        txtNombreCliente.setEditable(false);
        txtNombreCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreCliente.setText("Nombre del Empleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDireccion)
                        .addComponent(txtNombreRecibe)
                        .addComponent(txtPalabraClave)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(labelIDPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIDPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelNombreEmpleado)
                                .addComponent(labelIDEntrega)
                                .addComponent(txtIDEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelNombreCliente)))
                        .addComponent(labelNombreRecibe, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPalabraClave, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIDEmpleado)
                    .addComponent(labelNombreEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIDPaquete)
                    .addComponent(labelIDEntrega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIDCliente)
                    .addComponent(labelNombreCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(labelDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelNombreRecibe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreRecibe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPalabraClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPalabraClave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Dirección".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Dirección".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtDireccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMousePressed
        if(txtDireccion.getText().equals("Ingrese la dirección completa de la entrega del paquete")){
            txtDireccion.setText("");
            txtDireccion.setForeground(Color.BLACK);
        }
        if(txtNombreRecibe.getText().isEmpty()){
            txtNombreRecibe.setText("Ingrese el nombre completo de la persona que recibira el paquete");
            txtNombreRecibe.setForeground(new Color(204,204,204));
        }
        if(txtPalabraClave.getText().isEmpty()){
            txtPalabraClave.setText("Ingrese la palabra clave del paquete");
            txtPalabraClave.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtDireccionMousePressed

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Nombre Recibe".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Nombre Recibe".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtNombreRecibeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreRecibeMousePressed
        if(txtNombreRecibe.getText().equals("Ingrese el nombre completo de la persona que recibira el paquete")){
            txtNombreRecibe.setText("");
            txtNombreRecibe.setForeground(Color.black);
        }
        if(txtDireccion.getText().isEmpty()){
            txtDireccion.setText("Ingrese la dirección completa de la entrega del paquete");
            txtDireccion.setForeground(new Color(204,204,204));
        }
        if(txtPalabraClave.getText().isEmpty()){
            txtPalabraClave.setText("Ingrese la palabra clave del paquete");
            txtPalabraClave.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtNombreRecibeMousePressed

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Palabra Clave".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Palabra Clave".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtPalabraClaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPalabraClaveMousePressed
        if(txtPalabraClave.getText().equals("Ingrese la palabra clave del paquete")){
            txtPalabraClave.setText("");
            txtPalabraClave.setForeground(Color.black);
        }
        if(txtDireccion.getText().isEmpty()){
            txtDireccion.setText("Ingrese la dirección completa de la entrega del paquete");
            txtDireccion.setForeground(new Color(204,204,204));
        }
        if(txtNombreRecibe.getText().isEmpty()){
            txtNombreRecibe.setText("Ingrese el nombre completo de la persona que recibira el paquete");
            txtNombreRecibe.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtPalabraClaveMousePressed

    /**
    * Maneja la acción del botón "Agregar".
    * 
    * Este método se llama cuando se hace clic en el botón "Agregar" en la interfaz gráfica.
    * Obtiene los datos ingresados por el usuario, valida los campos y agrega un nuevo paquete y su envío asociado a la base de datos.
    * 
    * @param evt El evento de acción del botón.
    */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String estado = "Activo";
        String direccion = txtDireccion.getText();
        String nombreRecibe = txtNombreRecibe.getText();
        String palabraClave = txtPalabraClave.getText();
        
        if(!nombreRecibe.matches("[a-zA-Z]+") || !palabraClave.matches("[a-zA-Z]+")) {
            MessageAlerts.getInstance().showMessage("Error de Validación", "El nombre y la palabra clave solo pueden contener letras.", MessageAlerts.MessageType.ERROR);
            return;
        }
        
        try{
            sts = con.createStatement();
            nuevoRegistroEntrega = "INSERT INTO entrega "
                + "(idEntrega, estado, idPaquete, idEmpleado)"
                + " VALUES ('" + txtIDEntrega.getText() + "', '" + estado + "', '"
                + txtIDPaquete.getText() + "', '"
                + comboIDEmpleado.getSelectedItem() + "')";

            nuevoRegistroPaquete = "INSERT INTO paquete "
                + "(idPaquete, direccion, palabraClave, nombre, idCliente)"
                + " VALUES ('" + txtIDPaquete.getText() + "', '"
                + txtDireccion.getText() + "', '"
                + palabraClave + "', '"
                + nombreRecibe + "', '"
                + comboIDCliente.getSelectedItem() + "')";
            
            MessageAlerts.getInstance().showMessage("Confirmación de Registro de Nuevo Envío", "¿Estás seguro de registrar este nuevo envío y su respectivo paquete en el sistema? Esta acción creará un registro único para ambos elementos.", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                @Override
                public void action(PopupController pc, int i) {
                    if(i == MessageAlerts.YES_OPTION) {
                        try {
                            sts.executeUpdate(nuevoRegistroEntrega);
                            sts.executeUpdate(nuevoRegistroPaquete);
                            MessageAlerts.getInstance().showMessage("Éxito al Agregar Nuevo Envío y Paquete", "¡El nuevo envío y su respectivo paquete han sido agregados exitosamente al sistema!", MessageAlerts.MessageType.SUCCESS);
                            comboIDEmpleado.setSelectedIndex(1);
                            txtDireccion.setText("Ingrese la dirección completa de la entrega del paquete");
                            txtDireccion.setForeground(new Color(204,204,204));
                            txtNombreRecibe.setText("Ingrese el nombre completo de la persona que recibira el paquete");
                            txtNombreRecibe.setForeground(new Color(204,204,204));
                            txtPalabraClave.setText("Ingrese la palabra clave del paquete");
                            txtPalabraClave.setForeground(new Color(204,204,204));
                            actualizaIDPaquete();
                            actualizaIDEntrega();
                        }catch(SQLException ex) {
                            System.out.println("Error al ejecutar la consulta: " + ex);
                        }
                    }
                }
            });
        } catch(SQLException e){
            System.out.println("Error " + e);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
    * Actualiza el ID del paquete mostrado en el formulario.
    * 
    * Este método consulta la base de datos para obtener el ID más alto de los paquetes registrados
    * y luego incrementa este valor en uno para asignar el próximo ID disponible al nuevo paquete.
    * 
    * @throws SQLException Si ocurre un error al acceder a la base de datos.
    */
    public void actualizaIDPaquete() throws SQLException {
        Statement sts = con.createStatement();
        sts.execute("SELECT idPaquete FROM paquete");
        ResultSet rs = sts.getResultSet();
        int idPaquete = 0;
        while(rs.next()) {
            if(rs.isLast()) {
                idPaquete = Integer.parseInt(rs.getString("idPaquete")) + 1;
            }
        }
        txtIDPaquete.setText(String.valueOf(idPaquete));
    }
    
    /**
    * Actualiza el ID de entrega mostrado en el formulario.
    * 
    * Este método consulta la base de datos para obtener el ID más alto de las entregas registradas
    * y luego incrementa este valor en uno para asignar el próximo ID disponible a la nueva entrega.
    * 
    * @throws SQLException Si ocurre un error al acceder a la base de datos.
    */
    public void actualizaIDEntrega() throws SQLException {
        Statement sts = con.createStatement();
        sts.execute("SELECT idEntrega FROM entrega");
        ResultSet rs = sts.getResultSet();
        int idEntrega = 0;
        while(rs.next()) {
            if(rs.isLast()) {
                idEntrega = Integer.parseInt(rs.getString("idEntrega")) + 1;
            }
        }
        txtIDEntrega.setText(String.valueOf(idEntrega));
    }
    
    /**
    * Llena el combo box con los clientes disponibles.
    * 
    * Este método consulta la base de datos para obtener la lista de clientes disponibles y la muestra en el combo box correspondiente.
    * También maneja los eventos de selección de cliente para actualizar otros campos del formulario según la selección del usuario.
    * 
    * @throws SQLException Si ocurre un error al acceder a la base de datos.
    */
    public void seleccionCliente() throws SQLException {
        comboIDCliente.removeAllItems();
        Statement sts = con.createStatement();
        sts.execute("SELECT idCliente, nombre FROM cliente");
        ResultSet rs = sts.getResultSet();
        while(rs.next()) {
            String idCliente = rs.getString("idCliente");
            String nombreCliente = rs.getString("nombre");
            comboIDCliente.addItem(idCliente);
            comboIDCliente.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String seleccionID = (String) comboIDCliente.getSelectedItem();
                        sts.execute("SELECT nombre FROM cliente WHERE idCliente = '" + seleccionID + "'");
                        ResultSet rs = sts.getResultSet();
                        while(rs.next()) {
                            actualizaCampo("cliente", rs.getString("nombre"));
                        }
                    } catch(SQLException ex) {
                        System.out.println(ex);
                    }
                }
            });
        }
    }
    
    /**
    * Llena el combo box con los empleados disponibles.
    * 
    * Este método consulta la base de datos para obtener la lista de empleados disponibles y la muestra en el combo box correspondiente.
    * También maneja los eventos de selección de empleado para actualizar otros campos del formulario según la selección del usuario.
    * 
    * @throws SQLException Si ocurre un error al acceder a la base de datos.
    */
    public void seleccionEmpleado() throws SQLException {
        comboIDEmpleado.removeAllItems();
        Statement sts = con.createStatement();
        sts.execute("SELECT idEmpleado, nombre, rolEntrega FROM empleado");
        ResultSet rs = sts.getResultSet();
        while(rs.next()) {
            String idEmpleado = rs.getString("idEmpleado");
            String nombreEmpleado = rs.getString("nombre");
            String rolEntrega = rs.getString("rolEntrega");
            if(rolEntrega.equals("1")) {
                comboIDEmpleado.addItem(idEmpleado);
                comboIDEmpleado.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String seleccionID = (String) comboIDEmpleado.getSelectedItem();
                            sts.execute("SELECT nombre FROM empleado WHERE idEmpleado = '" + seleccionID + "'");
                            ResultSet rs = sts.getResultSet();
                            while(rs.next()) {
                                actualizaCampo("empleado", rs.getString("nombre"));
                            }
                        } catch(SQLException ex) {
                            System.out.println(ex);
                        }
                    }
                });
            }
        }
    }

    /**
    * Actualiza un campo de texto específico con un valor dado.
    * 
    * Este método actualiza un campo de texto específico en el formulario con el valor proporcionado.
    * 
    * @param campo El campo de texto a actualizar ("empleado" o "cliente").
    * @param valor El valor con el que actualizar el campo de texto.
    */
    public void actualizaCampo(String campo, String valor) {
        if(campo.equals("empleado")) {
            txtNombreEmpleado.setText(valor);
        }else if(campo.equals("cliente")) {
            txtNombreCliente.setText(valor);
        }
    }
    
    /**
    * Verifica si se pueden cerrar los formularios.
    * 
    * Este método se llama cuando se intenta cerrar el formulario. Verifica si hay datos sin guardar
    * y muestra un mensaje de advertencia si es así.
    * 
    * @return true si se pueden cerrar los formularios; false de lo contrario.
    */
    @Override
    public boolean formClose() {
        if((txtDireccion.getText().trim().isEmpty() || txtDireccion.getText().trim().equals("Ingrese la dirección completa de la entrega del paquete"))
            && (txtNombreCliente.getText().trim().isEmpty() || txtNombreCliente.getText().trim().equals("Ingrese el nombre completo de la persona que recibira el paquete"))
            && (txtPalabraClave.getText().trim().isEmpty() || txtPalabraClave.getText().trim().equals("Ingrese la palabra clave del paquete"))) {
            return true;
        }
        
        MessageAlerts.getInstance().showMessage("Datos Sin Guardar", "Hay datos sin guardar. ¿Realmente deseas cerrar?", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
            @Override
            public void action(PopupController pc, int i) {
                if(i == MessageAlerts.YES_OPTION) {
                    opc = 0;
                }
            }
        });
        
        if(opc == 0) {
            return true;
        }else {
            return false;
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> comboIDCliente;
    private javax.swing.JComboBox<String> comboIDEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelIDCliente;
    private javax.swing.JLabel labelIDEmpleado;
    private javax.swing.JLabel labelIDEntrega;
    private javax.swing.JLabel labelIDPaquete;
    private javax.swing.JLabel labelNombreCliente;
    private javax.swing.JLabel labelNombreEmpleado;
    private javax.swing.JLabel labelNombreRecibe;
    private javax.swing.JLabel labelPalabraClave;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIDEntrega;
    private javax.swing.JTextField txtIDPaquete;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtNombreRecibe;
    private javax.swing.JTextField txtPalabraClave;
    // End of variables declaration//GEN-END:variables
}