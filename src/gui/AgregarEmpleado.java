/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import java.sql.Connection;
import gui.clases.RadioPanel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import tabbed.TabbedForm;

/**
 * Clase Agregar Empleado extendido de TabbedForm.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class AgregarEmpleado extends TabbedForm {
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
    private String nuevoRegistro;
    /**
     * Variable de instancia.
     */
    private int opc = 1;
    
    /**
    *Constructor.
    * 
    * Interfaz gráfica para agregar un nuevo empleado al sistema.
    * 
    * Esta clase proporciona una interfaz gráfica para que los usuarios puedan agregar un nuevo empleado al sistema.
    * Los usuarios pueden ingresar información como nombre, apellidos, dirección, teléfono, correo electrónico y contraseña
    * del nuevo empleado, así como seleccionar su rol (administrador, recepcionista, repartidor).
    * 
    * @param con La conexión a la base de datos.
    * @throws SQLException Si ocurre un error al acceder a la base de datos.
    */
    public AgregarEmpleado(Connection con) throws SQLException {
        initComponents();
        this.con = con;
        actualizaID();
    }
    
    /**
    * Actualiza el ID del empleado mostrado en el formulario.
    * 
    * Este método consulta la base de datos para obtener el ID más alto de los empleados registrados
    * y luego incrementa este valor en uno para asignar el próximo ID disponible al nuevo empleado.
    * 
    * @throws SQLException Si ocurre un error al acceder a la base de datos.
    */
    public void actualizaID() throws SQLException {
        Statement sts = con.createStatement();
        sts.execute("SELECT idEmpleado FROM empleado");
        ResultSet rs = sts.getResultSet();
        int idEmpleado = 0;
        while(rs.next()) {
            if(rs.isLast()) {
                idEmpleado = Integer.parseInt(rs.getString("idEmpleado")) + 1;
            }
        }
        txtID.setText(String.valueOf(idEmpleado));
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

        btnGrupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        labelTitle = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        labelEmail3 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        btnAgregar = new javax.swing.JButton();
        labelSeleccion = new javax.swing.JLabel();
        radioRecepcionista = new javax.swing.JRadioButton();
        radioAdministrador = new javax.swing.JRadioButton();
        radioRepartidor = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1150, 700));
        setMinimumSize(new java.awt.Dimension(1150, 700));
        setPreferredSize(new java.awt.Dimension(1150, 700));

        jPanel1 = new RadioPanel(30, new Color(244, 244, 244));

        labelNombre.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelNombre.setText("Nombre Completo");

        labelID.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelID.setText("ID del Empleado");

        txtID.setBorder(new gui.clases.RoundedBorder(8));
        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtDireccion.setBorder(new gui.clases.RoundedBorder(8));
        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(204, 204, 204));
        txtDireccion.setText("Ingrese la dirección completa del empleado");
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDireccionMousePressed(evt);
            }
        });

        labelTitle.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        labelTitle.setText("Registro de Nuevo Usuario");

        txtApellidos.setBorder(new gui.clases.RoundedBorder(8));
        txtApellidos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(204, 204, 204));
        txtApellidos.setText("Apellidos");
        txtApellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidosMousePressed(evt);
            }
        });

        labelDireccion.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelDireccion.setText("Dirección");

        txtNombre.setBorder(new gui.clases.RoundedBorder(8));
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(204, 204, 204));
        txtNombre.setText("Nombre");
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });

        labelTelefono.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelTelefono.setText("Teléfono");

        txtTelefono.setBorder(new gui.clases.RoundedBorder(8));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(204, 204, 204));
        txtTelefono.setText("Ingrese el teléfono del empleado");
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });

        labelEmail.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelEmail.setText("Email");

        txtEmail.setBorder(new gui.clases.RoundedBorder(8));
        txtEmail.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.setText("Ingrese el correo electrónico del empleado");
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });

        labelEmail3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelEmail3.setText("Contraseña");

        txtContraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setText("**********");
        txtContraseña.setBorder(new gui.clases.RoundedBorder(8));
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseñaMousePressed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnAgregar.setText("Registrar Usuario");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 128)));
        btnAgregar.setPreferredSize(new java.awt.Dimension(64, 23));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        labelSeleccion.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelSeleccion.setText("Seleccione El tipo");

        radioRecepcionista.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        radioRecepcionista.setText("Recepcionista");

        radioAdministrador.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        radioAdministrador.setText("Administrador");
        radioAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAdministradorActionPerformed(evt);
            }
        });

        radioRepartidor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        radioRepartidor.setText("Repartidor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTitle)
                        .addComponent(labelDireccion)
                        .addComponent(labelTelefono)
                        .addComponent(labelEmail)
                        .addComponent(labelEmail3)
                        .addComponent(txtID)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                        .addComponent(txtTelefono)
                        .addComponent(txtEmail)
                        .addComponent(txtContraseña)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(radioRecepcionista)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioRepartidor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioAdministrador))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelTitle)
                .addGap(18, 18, 18)
                .addComponent(labelID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioRepartidor)
                    .addComponent(radioAdministrador)
                    .addComponent(radioRecepcionista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmail3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Maneja la acción del botón "Agregar".
    * 
    * Este método se llama cuando se hace clic en el botón "Agregar" en la interfaz gráfica.
    * Obtiene los datos ingresados por el usuario, valida los campos y agrega un nuevo empleado a la base de datos.
    * 
    * @param evt El evento de acción del botón.
    */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int rolRegistra = 0, rolEntrega = 0, admin = 0;
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String contraseña = String.valueOf(txtContraseña.getPassword());

        if(!nombre.matches("[a-zA-Z]+") || !apellidos.matches("[a-zA-Z]+")) {
            MessageAlerts.getInstance().showMessage("Error de Validación", "El nombre y apellidos solo pueden contener letras.", MessageAlerts.MessageType.ERROR);
            return;
        }
        
        if(!telefono.matches("\\d+")) {
            MessageAlerts.getInstance().showMessage("Error de Validación", "El teléfono solo puede contener números.", MessageAlerts.MessageType.ERROR);
            return;
        }
        
        if(radioRepartidor.isSelected()) {
            rolEntrega = 1;
        }
        if(radioRecepcionista.isSelected()) {
            rolRegistra = 1;
        }
        if(radioAdministrador.isSelected()) {
            admin = 1;
        }
        try{
            sts = con.createStatement();
            nuevoRegistro = "INSERT INTO empleado "
                    + "(nombre, direccion, telefono, email, "
                    + "contraseña, rolRegistra, rolEntrega, "
                    + "admin)"
                    + " VALUES ('" + nombre + " " + apellidos + "', '"
                    + direccion + "','"
                    + telefono + "','"
                    + email + "','"
                    + contraseña + "','"
                    + rolRegistra + "','"
                    + rolEntrega + "','"
                    + admin + "')";
            MessageAlerts.getInstance().showMessage("Confirmación de Agregar Nuevo Usuario", "¿Estás seguro de agregar a este nuevo usuario? Esta acción creará un nuevo registro en el sistema", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                @Override
                public void action(PopupController pc, int i) {
                    if(i == MessageAlerts.YES_OPTION) {
                        try {
                            sts.executeUpdate(nuevoRegistro);
                            MessageAlerts.getInstance().showMessage("Éxito al Agregar Usuario", "¡Usuario agregado correctamente! El nuevo usuario ha sido añadido exitosamente al sistema.", MessageAlerts.MessageType.SUCCESS);
                            txtNombre.setText("Nombre");
                            txtNombre.setForeground(new Color(204,204,204));
                            txtApellidos.setText("Apellidos");
                            txtApellidos.setForeground(new Color(204,204,204));
                            txtDireccion.setText("Ingrese la dirección completa del empleado");
                            txtDireccion.setForeground(new Color(204,204,204));
                            txtTelefono.setText("Ingrese el teléfono del empleado");
                            txtTelefono.setForeground(new Color(204,204,204));
                            txtEmail.setText("Ingrese el correo electrónico del empleado");
                            txtEmail.setForeground(new Color(204,204,204));
                            txtContraseña.setText("********");
                            txtContraseña.setForeground(new Color(204,204,204));
                            radioRecepcionista.setSelected(false);
                            radioRepartidor.setSelected(false);
                            radioAdministrador.setSelected(false);
                            actualizaID();
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
    * Maneja la acción del radio botón "Administrador".
    * 
    * Este método se llama cuando se selecciona o deselecciona el radio botón "Administrador".
    * Habilita o deshabilita los otros radio botones según la selección del usuario.
    * 
    * @param evt El evento de acción del radio botón.
    */
    private void radioAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAdministradorActionPerformed
        if(radioAdministrador.isSelected()) {
            radioRecepcionista.setEnabled(false);
            radioRepartidor.setEnabled(false);
            radioRepartidor.setSelected(false);
            radioRecepcionista.setSelected(false);
        }else {
            radioRecepcionista.setEnabled(true);
            radioRepartidor.setEnabled(true);
        }
    }//GEN-LAST:event_radioAdministradorActionPerformed

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Nombre".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Nombre".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        if(txtNombre.getText().equals("Nombre")){
            txtNombre.setText("");
            txtNombre.setForeground(Color.black);
        }
        if(txtApellidos.getText().isEmpty()){
            txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(new Color(204,204,204));
        }
        if(txtDireccion.getText().isEmpty()){
            txtDireccion.setText("Ingrese la dirección completa del empleado");
            txtDireccion.setForeground(new Color(204,204,204));
        }
        if(txtTelefono.getText().isEmpty()){
            txtTelefono.setText("Ingrese el teléfono del empleado");
            txtTelefono.setForeground(new Color(204,204,204));
        }
        if(txtEmail.getText().isEmpty()){
            txtEmail.setText("Ingrese el correo electrónico del empleado");
            txtEmail.setForeground(new Color(204,204,204));
        }
        if(String.valueOf(txtContraseña.getPassword()).isEmpty()){
            txtContraseña.setText("********");
            txtContraseña.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtNombreMousePressed

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Apellido".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Apellido".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtApellidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosMousePressed
        if(txtApellidos.getText().equals("Apellidos")){
            txtApellidos.setText("");
            txtApellidos.setForeground(Color.black);
        }
        if(txtNombre.getText().isEmpty()){
            txtNombre.setText("Nombre");
            txtNombre.setForeground(new Color(204,204,204));
        }
        if(txtDireccion.getText().isEmpty()){
            txtDireccion.setText("Ingrese la dirección completa del empleado");
            txtDireccion.setForeground(new Color(204,204,204));
        }
        if(txtTelefono.getText().isEmpty()){
            txtTelefono.setText("Ingrese el teléfono del empleado");
            txtTelefono.setForeground(new Color(204,204,204));
        }
        if(txtEmail.getText().isEmpty()){
            txtEmail.setText("Ingrese el correo electrónico del empleado");
            txtEmail.setForeground(new Color(204,204,204));
        }
        if(String.valueOf(txtContraseña.getPassword()).isEmpty()){
            txtContraseña.setText("********");
            txtContraseña.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtApellidosMousePressed

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Dirección".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Dirección".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtDireccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMousePressed
        if(txtDireccion.getText().equals("Ingrese la dirección completa del empleado")){
            txtDireccion.setText("");
            txtDireccion.setForeground(Color.black);
        }
        if(txtNombre.getText().isEmpty()){
            txtNombre.setText("Nombre");
            txtNombre.setForeground(new Color(204,204,204));
        }
        if(txtApellidos.getText().isEmpty()){
            txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(new Color(204,204,204));
        }
        if(txtTelefono.getText().isEmpty()){
            txtTelefono.setText("Ingrese el teléfono del empleado");
            txtTelefono.setForeground(new Color(204,204,204));
        }
        if(txtEmail.getText().isEmpty()){
            txtEmail.setText("Ingrese el correo electrónico del empleado");
            txtEmail.setForeground(new Color(204,204,204));
        }
        if(String.valueOf(txtContraseña.getPassword()).isEmpty()){
            txtContraseña.setText("********");
            txtContraseña.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtDireccionMousePressed

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Teléfono".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Teléfono".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed
        if(txtTelefono.getText().equals("Ingrese el teléfono del empleado")){
            txtTelefono.setText("");
            txtTelefono.setForeground(Color.black);
        }
        if(txtNombre.getText().isEmpty()){
            txtNombre.setText("Nombre");
            txtNombre.setForeground(new Color(204,204,204));
        }
        if(txtApellidos.getText().isEmpty()){
            txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(new Color(204,204,204));
        }
        if(txtDireccion.getText().isEmpty()){
            txtDireccion.setText("Ingrese la dirección completa del empleado");
            txtDireccion.setForeground(new Color(204,204,204));
        }
        if(txtEmail.getText().isEmpty()){
            txtEmail.setText("Ingrese el correo electrónico del empleado");
            txtEmail.setForeground(new Color(204,204,204));
        }
        if(String.valueOf(txtContraseña.getPassword()).isEmpty()){
            txtContraseña.setText("********");
            txtContraseña.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtTelefonoMousePressed

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Email".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Email".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        if(txtEmail.getText().equals("Ingrese el correo electrónico del empleado")){
            txtEmail.setText("");
            txtEmail.setForeground(Color.black);
        }
        if(txtNombre.getText().isEmpty()){
            txtNombre.setText("Nombre");
            txtNombre.setForeground(new Color(204,204,204));
        }
        if(txtApellidos.getText().isEmpty()){
            txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(new Color(204,204,204));
        }
        if(txtDireccion.getText().isEmpty()){
            txtDireccion.setText("Ingrese la dirección completa del empleado");
            txtDireccion.setForeground(new Color(204,204,204));
        }
        if(txtTelefono.getText().isEmpty()){
            txtTelefono.setText("Ingrese el teléfono del empleado");
            txtTelefono.setForeground(new Color(204,204,204));
        }
        if(String.valueOf(txtContraseña.getPassword()).isEmpty()){
            txtContraseña.setText("********");
            txtContraseña.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtEmailMousePressed

    /**
    * Maneja el evento de presionar el mouse en el campo de texto "Contraseña".
    * 
    * Este método se llama cuando el usuario presiona el mouse en el campo de texto "Contraseña".
    * Limpia el campo si su valor es el valor predeterminado.
    * 
    * @param evt El evento de presionar el mouse.
    */
    private void txtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMousePressed
        if(String.valueOf(txtContraseña.getPassword()).equals("**********")){
            txtContraseña.setText("");
            txtContraseña.setForeground(Color.black);
        }
        if(txtNombre.getText().isEmpty()){
            txtNombre.setText("Nombre");
            txtNombre.setForeground(new Color(204,204,204));
        }
        if(txtApellidos.getText().isEmpty()){
            txtApellidos.setText("Apellidos");
            txtApellidos.setForeground(new Color(204,204,204));
        }
        if(txtDireccion.getText().isEmpty()){
            txtDireccion.setText("Ingrese la dirección completa del empleado");
            txtDireccion.setForeground(new Color(204,204,204));
        }
        if(txtTelefono.getText().isEmpty()){
            txtTelefono.setText("Ingrese el teléfono del empleado");
            txtTelefono.setForeground(new Color(204,204,204));
        }
        if(txtEmail.getText().isEmpty()){
            txtEmail.setText("Ingrese el correo electrónico del empleado");
            txtEmail.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtContraseñaMousePressed

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
        if((txtNombre.getText().trim().isEmpty() || txtNombre.getText().trim().equals("Nombre"))
            && (txtApellidos.getText().trim().isEmpty() || txtApellidos.getText().trim().equals("Apellidos"))
            && (txtDireccion.getText().trim().isEmpty() || txtDireccion.getText().trim().equals("Ingrese la dirección completa del empleado"))
            && (txtTelefono.getText().trim().isEmpty() || txtTelefono.getText().trim().equals("Ingrese el teléfono del empleado"))
            && (txtEmail.getText().trim().isEmpty() || txtEmail.getText().trim().equals("Ingrese el correo electrónico del empleado"))
            && (String.valueOf(txtContraseña.getPassword()).isEmpty() || String.valueOf(txtContraseña.getPassword()).equals("**********"))) {
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
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEmail3;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSeleccion;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JRadioButton radioAdministrador;
    private javax.swing.JRadioButton radioRecepcionista;
    private javax.swing.JRadioButton radioRepartidor;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}