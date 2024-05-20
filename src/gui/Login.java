/*
Universidad Politécnica de San Luis Potosí
Programación 3 Java
Jordan Medina Ortíz
 */
package gui;

import basededatos.ActualizacionDeDatos;
import basededatos.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import gui.MainScreen;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import raven.alerts.MessageAlerts;
import raven.popup.GlassPanePopup;
import serviciodemensajeria.ExcepcionPropia;

/**
 * Clase Login extendida de javax.swing.JFrame
 * @author Jordan Medina Ortíz 179913@upslp.edu.mx
 */
public class Login extends javax.swing.JFrame {    
    /**
     * Variable de instancia.
     */
    Conexion conexion = new Conexion();
    /**
     * Variable de instancia.
     */
    Connection con = conexion.conectar();
    /**
     * Variable de instancia.
     */
    private Clip clip;
    /**
     * Variable de instancia.
     */
    int xMouse, yMouse;
    
    /**
    * Constructor.
    * Crea una nueva instancia de la ventana de inicio de sesión.
    */
    public Login() {
        GlassPanePopup.install(this);
        initComponents();
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
        bgLogin = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        btnExitText = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        passText = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JPanel();
        btnTextLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1150, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1150, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoLogin.png"))); // NOI18N
        jPanel1.add(bgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 450, 700));

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoTransparente.png"))); // NOI18N
        favicon.setText("ENVÍOMEX");
        jPanel1.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 190, 50));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));

        btnExitText.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        btnExitText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExitText.setText("X");
        btnExitText.setToolTipText("");
        btnExitText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExitText.setPreferredSize(new java.awt.Dimension(40, 40));
        btnExitText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitTextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitTextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExitText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExitText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1110, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 40));

        title.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        title.setText("INICIAR SESIÓN");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        userLabel.setText("CORREO ELECTRÓNICO");
        jPanel1.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        userText.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userText.setForeground(new java.awt.Color(204, 204, 204));
        userText.setText("Ingrese su correo electrónico");
        userText.setBorder(null);
        userText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTextMousePressed(evt);
            }
        });
        jPanel1.add(userText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 520, 40));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 520, 10));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        jPanel1.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 520, 10));

        passText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passText.setForeground(new java.awt.Color(204, 204, 204));
        passText.setText("********");
        passText.setBorder(null);
        passText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTextMousePressed(evt);
            }
        });
        jPanel1.add(passText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 520, 40));

        btnLogin.setBackground(new java.awt.Color(255, 69, 42));

        btnTextLogin.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnTextLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnTextLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTextLogin.setText("INICIAR SESIÓN");
        btnTextLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTextLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTextLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTextLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTextLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTextLoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTextLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTextLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 160, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Método que se ejecuta cuando se presiona el mouse en el encabezado de la ventana.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    /**
    * Método que se ejecuta cuando se arrastra el mouse en el encabezado de la ventana.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    /**
    * Método que se ejecuta cuando se hace clic en el botón de salida.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void btnExitTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTextMouseClicked
        try {
            File archivoSonido = new File("src/musica/close_windows.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setFramePosition(0);
            
            clip.addLineListener(new LineListener() {
            @Override
                public void update(LineEvent event) {
                    if(event.getType() == LineEvent.Type.STOP) {
                        System.exit(0);
                    }
                }
            });
            
            clip.start();
        }catch(Exception e) {
            System.out.println(e);
        }        
    }//GEN-LAST:event_btnExitTextMouseClicked

    /**
    * Método que se ejecuta cuando el mouse entra en el área del botón de salida.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void btnExitTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTextMouseEntered
        btnExit.setBackground(Color.red);
        btnExitText.setForeground(Color.white);
    }//GEN-LAST:event_btnExitTextMouseEntered

    /**
    * Método que se ejecuta cuando el mouse sale del área del botón de salida.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void btnExitTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitTextMouseExited
        btnExit.setBackground(Color.white);
        btnExitText.setForeground(Color.black);
    }//GEN-LAST:event_btnExitTextMouseExited

    /**
    * Método que se ejecuta cuando el mouse entra en el área del botón de inicio de sesión.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void btnTextLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTextLoginMouseEntered
        btnLogin.setBackground(new Color(255, 94, 75));
    }//GEN-LAST:event_btnTextLoginMouseEntered

    /**
    * Método que se ejecuta cuando el mouse sale del área del botón de inicio de sesión.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void btnTextLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTextLoginMouseExited
        btnLogin.setBackground(new Color(255,69,42));
    }//GEN-LAST:event_btnTextLoginMouseExited

    /**
    * Método que se ejecuta cuando se presiona el mouse en el campo de texto de usuario.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void userTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTextMousePressed
        if(userText.getText().equals("Ingrese su correo electrónico")){
            userText.setText("");
            userText.setForeground(Color.black);
        }
        if(String.valueOf(passText.getPassword()).isEmpty()){
            passText.setText("********");
            passText.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_userTextMousePressed

    /**
    * Método que se ejecuta cuando se presiona el mouse en el campo de texto de contraseña.
    * 
    * @param evt El evento de mouse que desencadena el método.
    */
    private void passTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTextMousePressed
        if(String.valueOf(passText.getPassword()).equals("********")){
            passText.setText("");
            passText.setForeground(Color.black);
        }
        if(userText.getText().isEmpty()){
            userText.setText("Ingrese su correo electrónico");
            userText.setForeground(new Color(204,204,204));   
        }
    }//GEN-LAST:event_passTextMousePressed

    /**
     * Método que se ejecuta cuando se hace clic en el botón de inicio de sesión.
     * 
     * @param evt El evento de mouse que desencadena el método.
     */
    private void btnTextLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTextLoginMouseClicked
        ActualizacionDeDatos actualizacion =  new ActualizacionDeDatos(con);
        Thread loginThread = new Thread(() -> {
            try {
                Statement sts = con.createStatement();
                sts.execute("SELECT * FROM empleado");
                ResultSet rs = sts.getResultSet();
                boolean encontrado = false;
                String nombre = null;
                String contraseña = null;
                int rol = 0;
                while(rs.next()) {
                    if(rs.getString("rolRegistra").equals("1") && rs.getString("rolEntrega").equals("1")) {
                        rol = 3;
                    }else if(rs.getString("rolRegistra").equals("1")) {
                        rol = 1;
                    }else if(rs.getString("rolEntrega").equals("1")) {
                        rol = 2;
                    }else if(rs.getString("admin").equals("1")) {
                        rol = 4;
                    }

                    if(rs.getString("email").equals(userText.getText())) {
                        encontrado = true;
                        nombre = rs.getString("nombre");
                        contraseña = rs.getString("contraseña");
                        if(String.valueOf(passText.getPassword()).equals(contraseña)) {
                            String email = rs.getString("email");
                            new MainScreen(email, nombre, con, rol).setVisible(true);
                            this.setVisible(false);
                            excepcion(nombre, contraseña, "Aprobado");
                            actualizacion.iniciarVerificacion();
                            break;
                        }else {
                            MessageAlerts.getInstance().showMessage("Inicio de Sesión Sin Exito", "Contraseña Incorrecta. Vuelvelo a Intentar", MessageAlerts.MessageType.ERROR);
                            nombre = userText.getText();
                            contraseña = String.valueOf(passText.getPassword());
                            excepcion(nombre, contraseña, "ContraseñaIncorrecta");
                        }
                    }
                }

                if(!encontrado) {
                    MessageAlerts.getInstance().showMessage("Inicio de Sesión Sin Exito", "Coreeo Electónico Incorrecta. Vuelvelo a Intentar", MessageAlerts.MessageType.ERROR);
                    nombre = userText.getText();
                    contraseña = String.valueOf(passText.getPassword());
                    excepcion(nombre, contraseña, "CorreoNoEncontrado");
                }
            }catch(FileNotFoundException | ExcepcionPropia | SQLException ex) {
                System.out.println("--->" + ex);
                System.out.println(ex.toString());
            }
        });
        loginThread.start();
        actualizacion.iniciarVerificacion();
    }//GEN-LAST:event_btnTextLoginMouseClicked

    /**
    * Método para lanzar una excepción personalizada.
    * 
    * @param user El nombre de usuario.
    * @param contraseña La contraseña.
    * @param filename El nombre del archivo.
    * @throws ExcepcionPropia La excepción personalizada.
    * @throws FileNotFoundException La excepción de archivo no encontrado.
    * @throws SQLException La excepción de SQL.
    */
    public void excepcion(String user, String contraseña, String filename) throws ExcepcionPropia, FileNotFoundException, SQLException {
        throw new ExcepcionPropia(user, contraseña, filename);
    }
    
    /**
    * Método principal para ejecutar la aplicación.
    * 
    * @param args Los argumentos de la línea de comandos.
    */
    public static void main(String args[]) {
        /* Establece el aspecto y la sensación Nimbus */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Crea y muestra la ventana */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLogin;
    private javax.swing.JPanel btnExit;
    private javax.swing.JLabel btnExitText;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JLabel btnTextLogin;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel header;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passText;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables
}