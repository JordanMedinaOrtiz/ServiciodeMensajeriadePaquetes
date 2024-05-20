/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import com.formdev.flatlaf.FlatClientProperties;
import gui.clases.TableGradientCell;
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
 * Clase Consulta Entrega extendida de TabbedForm.
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class ConsultaEntrega extends TabbedForm {
    /**
     * Variables de instancia.
     */
    private final Connection con;
    /**
     * Variables de instancia.
     */
    private int opc;
    
    /**
    * Constructor. 
    * Interfaz gráfica para consultar entregas de paquetes.
    * 
    * Esta clase proporciona una interfaz gráfica para que los usuarios puedan consultar las entregas de paquetes en el sistema.
    * Los usuarios pueden filtrar las entregas por ID o estado y ver los detalles en una tabla.
    * 
    * @param con La conexión a la base de datos.
    * @param opc La opción de consulta (1 para ID de entrega, 2 para estado de entrega).
    */
    public ConsultaEntrega(Connection con, int opc) {
        initComponents();
        this.con = con;
        this.opc = opc;
        tablaPaquete.setDefaultRenderer(Object.class, new TableGradientCell());
        tablaPaquete.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        jScrollPane1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        jScrollPane1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
        consultarPaqueteDatos();
        seleccionEntrega();
    }
    
    /**
    * Consulta los datos de los paquetes en la base de datos y llena la tabla correspondiente.
    */
    private void consultarPaqueteDatos() {
        try{
            DefaultTableModel model = (DefaultTableModel)tablaPaquete.getModel();
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM entrega");
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
    * Actualiza la tabla de paquetes con datos filtrados según un campo y un valor dados.
    * 
    * @param campo El campo por el que filtrar los datos (ID de entrega o estado).
    * @param dato El valor por el que filtrar los datos.
    */
    public void actualizaTabla(String campo, String dato) {
        int nuevoDato = 0;
        if(campo.equals("idEntrega")) {
            nuevoDato = Integer.valueOf(dato);
        }
        try{
            DefaultTableModel model = (DefaultTableModel)tablaPaquete.getModel();
            model.setRowCount(0);
            Statement sts = con.createStatement();
            ResultSet rs;
            if(campo.equals("idEntrega")) {
                sts.execute("SELECT * FROM entrega WHERE " + campo + " = " + nuevoDato);
                rs = sts.getResultSet();
            }else {
                sts.execute("SELECT * FROM entrega WHERE " + campo + " = '" + dato + "'");
                rs = sts.getResultSet();

            }
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
    * Llena el combo box con las opciones disponibles para la selección de entrega (ID de entrega o estado).
    */
    public void seleccionEntrega() {
        if(opc == 1){
            String campo = "idEntrega";
            comboSeleccion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        String dato = (String) comboSeleccion.getSelectedItem();
                        actualizaTabla(campo, dato);
                    }
            });
            labelSeleccion.setText("Seleccione el ID de la entrega: ");
            try {
                comboSeleccion.removeAllItems();
                Statement sts = con.createStatement();
                sts.execute("SELECT idEntrega FROM entrega");
                ResultSet rs = sts.getResultSet();
                while(rs.next()) {
                    comboSeleccion.addItem(rs.getString("idEntrega"));
                }
            }catch(SQLException ex) {
                System.out.println(ex);
            }
        }
        if(opc == 2) {
            String campo = "estado";
            comboSeleccion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        String dato = (String)comboSeleccion.getSelectedItem();
                        actualizaTabla(campo, dato);
                    }
            });
            labelSeleccion.setText("Seleccione el estado de la entrega: ");
            try {
                comboSeleccion.removeAllItems();
                Statement sts = con.createStatement();
                sts.execute("SELECT estado FROM entrega");
                ResultSet rs = sts.getResultSet();
                while(rs.next()) {
                    comboSeleccion.addItem(rs.getString("estado"));
                }
            }catch(SQLException ex) {
                System.out.println(ex);
            }
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
        tablaPaquete = new javax.swing.JTable();
        labelSeleccion = new javax.swing.JLabel();
        comboSeleccion = new javax.swing.JComboBox<>();

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

        labelSeleccion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelSeleccion.setText("Seleccione el ID del Empleado: ");
        labelSeleccion.setMaximumSize(new java.awt.Dimension(199, 19));
        labelSeleccion.setMinimumSize(new java.awt.Dimension(199, 19));
        labelSeleccion.setPreferredSize(new java.awt.Dimension(186, 17));

        comboSeleccion.setPreferredSize(new java.awt.Dimension(72, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(labelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(768, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(651, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Maneja el evento de clic en la tabla de paquetes.
    * 
    * Este método se llama cuando se hace clic en una fila de la tabla de paquetes.
    * Obtiene los datos de la fila seleccionada y muestra un cuadro de diálogo con la información correspondiente.
    * 
    * @param evt El evento de clic del mouse.
    */
    private void tablaPaqueteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPaqueteMouseClicked
        int fila = tablaPaquete.getSelectedRow();

        String idEntrega = (String)tablaPaquete.getValueAt(fila, 0);
        String estado = (String)tablaPaquete.getValueAt(fila, 1);
        String idPaquete = (String)tablaPaquete.getValueAt(fila, 2);
        String idEmpleado = (String)tablaPaquete.getValueAt(fila, 3);
        JOptionPane.showMessageDialog(this, "ID Entrega: " + idEntrega + "\nEstado del Paquete: " + estado
            + "\nID Paquete: " + idPaquete + "\nID Empleado: " + idEmpleado);
    }//GEN-LAST:event_tablaPaqueteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSeleccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelSeleccion;
    private javax.swing.JTable tablaPaquete;
    // End of variables declaration//GEN-END:variables
}
