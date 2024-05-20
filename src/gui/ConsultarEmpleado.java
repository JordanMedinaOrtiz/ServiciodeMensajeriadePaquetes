/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import gui.clases.TableGradientCell;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tabbed.TabbedForm;

/**
 * Clase Consultar Empleado extendida de TabbedForm.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class ConsultarEmpleado extends TabbedForm {
    /**
     * Variable de instancias.
     */
    private final Connection con;
    /**
     * Variable de instancias.
     */
    private int opc;

    /**
    * Constructor.
    * Crea una nueva instancia de la ventana para consultar empleados.
    * 
    * @param con La conexión a la base de datos.
    * @param opc La opción de consulta seleccionada.
    */
    public ConsultarEmpleado(Connection con, int opc) {
        initComponents();
        this.con = con;
        this.opc = opc;
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
        seleccionEmpleado();
    }
    
    /**
    * Consulta los datos de los empleados y los muestra en la tabla.
    */
    private void consultarEmpladoDatos() {
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
    * Actualiza la tabla de empleados según el campo y dato especificados.
    * 
    * @param campo El campo por el que se filtrarán los datos.
    * @param dato El valor a filtrar.
    */
    public void actualizaTabla(String campo, String dato) {
        String rol = null;
        int nuevoDato = 0;
        if(campo.equals("idEmpleado")) {
            nuevoDato = Integer.valueOf(dato);
        }
        try{
            DefaultTableModel model = (DefaultTableModel)tablaEmpleado.getModel();
            model.setRowCount(0);
            Statement sts = con.createStatement();
            if(campo.equals("idEmpleado")) {
                sts.execute("SELECT idEmpleado, nombre, direccion, telefono, email, rolRegistra, rolEntrega, admin FROM empleado WHERE " + campo + " = "  + "'" + nuevoDato + "'");
            }else if(campo.equals("rol")) {
                if(dato.equals("Logistica")) {
                    sts.execute("SELECT idEmpleado, nombre, direccion, telefono, email, rolRegistra, rolEntrega, admin FROM empleado WHERE rolRegistra = 1 AND rolEntrega = 1");
                }else if(dato.equals("Recepcionista")) {
                    sts.execute("SELECT idEmpleado, nombre, direccion, telefono, email, rolRegistra, rolEntrega, admin FROM empleado WHERE rolRegistra = 1 AND rolEntrega = 0");
                }else if(dato.equals("Repartidor")) {
                    sts.execute("SELECT idEmpleado, nombre, direccion, telefono, email, rolRegistra, rolEntrega, admin FROM empleado WHERE rolRegistra = 0 AND rolEntrega = 1");
                }else if(dato.equals("Administrador")) {
                    sts.execute("SELECT idEmpleado, nombre, direccion, telefono, email, rolRegistra, rolEntrega, admin FROM empleado WHERE admin = 1");
                }
            }else sts.execute("SELECT idEmpleado, nombre, direccion, telefono, email, rolRegistra, rolEntrega, admin FROM empleado WHERE " + campo + " = "  + "'" + dato + "'");
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
    * Configura las opciones de selección de empleados según la opción especificada.
    */
    public void seleccionEmpleado() {
        if(opc == 1){
            String campo = "idEmpleado";
            comboSeleccion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String dato = (String) comboSeleccion.getSelectedItem();
                    actualizaTabla(campo, dato);
                    }
            });
            labelSeleccion.setText("Seleccione el ID del empleado: ");
            try {
                comboSeleccion.removeAllItems();
                Statement sts = con.createStatement();
                sts.execute("SELECT idEmpleado FROM empleado");
                ResultSet rs = sts.getResultSet();
                while(rs.next()) {
                    comboSeleccion.addItem(rs.getString("idEmpleado"));
                }
            }catch(SQLException ex) {
                System.out.println(ex);
            }
        }
        if(opc == 2) {
            String campo = "telefono";
            comboSeleccion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String dato = (String)comboSeleccion.getSelectedItem();
                    actualizaTabla(campo, dato);
                    }
            });
            labelSeleccion.setText("Seleccione el teléfono del empleado: ");
            try {
                comboSeleccion.removeAllItems();
                Statement sts = con.createStatement();
                sts.execute("SELECT telefono FROM empleado");
                ResultSet rs = sts.getResultSet();
                while(rs.next()) {
                    comboSeleccion.addItem(rs.getString("telefono"));
                }
            }catch(SQLException ex) {
                System.out.println(ex);
            }
        }
        if(opc == 3) {
            String campo = "email";
            comboSeleccion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String dato = (String)comboSeleccion.getSelectedItem();
                    actualizaTabla(campo, dato);
                    }
            });
            labelSeleccion.setText("Seleccione el email del empleado: ");
            try {
                comboSeleccion.removeAllItems();
                Statement sts = con.createStatement();
                sts.execute("SELECT email FROM empleado");
                ResultSet rs = sts.getResultSet();
                while(rs.next()) {
                    comboSeleccion.addItem(rs.getString("email"));
                }
            }catch(SQLException ex) {
                System.out.println(ex);
            }
        }
        if(opc == 4) {
            String campo = "rol";
            comboSeleccion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String dato = (String)comboSeleccion.getSelectedItem();
                    actualizaTabla(campo, dato);
                    }
            });
            labelSeleccion.setText("Seleccione el rol del empleado: ");
            comboSeleccion.removeAllItems();
            comboSeleccion.addItem("Recepcionista");
            comboSeleccion.addItem("Repartidor");
            comboSeleccion.addItem("Logistica");
            comboSeleccion.addItem("Administrador");
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
        labelSeleccion = new javax.swing.JLabel();
        comboSeleccion = new javax.swing.JComboBox<>();

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

        labelSeleccion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelSeleccion.setText("Seleccione el ID del Empleado: ");

        comboSeleccion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSeleccion)
                        .addGap(18, 18, 18)
                        .addComponent(comboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSeleccion)
                    .addComponent(comboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Método llamado cuando se hace clic en la tabla de empleados.
    * 
    * @param evt El evento del mouse que activó el método.
    */
    private void tablaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadoMouseClicked
        int fila = tablaEmpleado.getSelectedRow();
        
        String idEmpleado = (String)tablaEmpleado.getValueAt(fila, 0);
        String nombre = (String)tablaEmpleado.getValueAt(fila, 1);
        String direccion = (String)tablaEmpleado.getValueAt(fila, 2);
        String telefono = (String)tablaEmpleado.getValueAt(fila, 3);
        String email = (String)tablaEmpleado.getValueAt(fila, 4);
        String rol = (String)tablaEmpleado.getValueAt(fila, 5);
        JOptionPane.showMessageDialog(this, "ID Empleado: " + idEmpleado + "\nNombre: " + nombre
                + "\nDirección: " + direccion + "\nTelefono: " + telefono + "\nEmail: " + email + "\nRol: " + rol);
    }//GEN-LAST:event_tablaEmpleadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSeleccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelSeleccion;
    private javax.swing.JTable tablaEmpleado;
    // End of variables declaration//GEN-END:variables
}
