package prueba_diseño;

import clases_conexion.BDConexion;
import static clases_validacion.ValidacionesGenerales.camposVaciosArray;
import static clases_validacion.ValidacionesGenerales.validarNumerosC;
import static clases_validacion.ValidacionesGenerales.validarTodos;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class CrearUsuario extends javax.swing.JFrame {

    
    public CrearUsuario() {
        initComponents();
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        Estilos boton = new Estilos();
        boton.btnSalir(btn_salir);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new prueba_diseño.PanelRound();
        txt_pass = new javax.swing.JPasswordField();
        panel_crear = new prueba_diseño.PanelRound();
        btn_crear = new javax.swing.JLabel();
        panel_salir = new prueba_diseño.PanelRound();
        btn_salir = new javax.swing.JLabel();
        panelRound4 = new prueba_diseño.PanelRound();
        txt_nombre = new javax.swing.JTextField();
        panelRound5 = new prueba_diseño.PanelRound();
        txt_passConfir = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 39));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Nuevo Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 200, -1));

        panelRound1.setBackground(new java.awt.Color(204, 204, 204));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_pass.setBackground(new java.awt.Color(204, 204, 204));
        txt_pass.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(16, 23, 39));
        txt_pass.setBorder(null);
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        panelRound1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 20));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 200, 30));

        panel_crear.setBackground(new java.awt.Color(81, 77, 167));
        panel_crear.setRoundBottomLeft(25);
        panel_crear.setRoundBottomRight(25);
        panel_crear.setRoundTopLeft(25);
        panel_crear.setRoundTopRight(25);
        panel_crear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_crear.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_crear.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_crear.setText("Crear Usuario");
        btn_crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_crearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_crearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_crearMouseExited(evt);
            }
        });
        panel_crear.add(btn_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel1.add(panel_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 150, 40));

        panel_salir.setBackground(new java.awt.Color(255, 255, 255));
        panel_salir.setRoundBottomLeft(25);
        panel_salir.setRoundBottomRight(25);
        panel_salir.setRoundTopLeft(25);
        panel_salir.setRoundTopRight(25);
        panel_salir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_salirMouseExited(evt);
            }
        });
        panel_salir.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanel1.add(panel_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 50, 50));

        panelRound4.setBackground(new java.awt.Color(204, 204, 204));
        panelRound4.setRoundBottomLeft(25);
        panelRound4.setRoundBottomRight(25);
        panelRound4.setRoundTopLeft(25);
        panelRound4.setRoundTopRight(25);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(16, 23, 39));
        txt_nombre.setBorder(null);
        panelRound4.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 200, 30));

        panelRound5.setBackground(new java.awt.Color(204, 204, 204));
        panelRound5.setRoundBottomLeft(25);
        panelRound5.setRoundBottomRight(25);
        panelRound5.setRoundTopLeft(25);
        panelRound5.setRoundTopRight(25);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_passConfir.setBackground(new java.awt.Color(204, 204, 204));
        txt_passConfir.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        txt_passConfir.setForeground(new java.awt.Color(16, 23, 39));
        txt_passConfir.setBorder(null);
        panelRound5.add(txt_passConfir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 20));

        jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 200, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre Usuario");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirmar Contraseña");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearMouseEntered
        panel_crear.setBackground(new Color(80,5,5));
    }//GEN-LAST:event_btn_crearMouseEntered

    private void btn_crearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearMouseExited
        panel_crear.setBackground(new Color(81,77,167));
    }//GEN-LAST:event_btn_crearMouseExited

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
        panel_salir.setBackground(new Color(14,120,220));
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseExited
        panel_salir.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btn_salirMouseExited

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        dispose();
        new MenuAdmin().setVisible(true);
    }//GEN-LAST:event_btn_salirMouseClicked

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void btn_crearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearMouseClicked
        String usuario = txt_nombre.getText().trim();
        String contraseña = txt_pass.getText().trim();
        String confirmarC = txt_passConfir.getText().trim();

        String[] datosT = {usuario, contraseña, confirmarC};
        
        if (contraseña.equals(confirmarC)) {
            
            if (camposVaciosArray(datosT)) {

            if (validarTodos(datosT)) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT nombre_usuario, contraseña FROM cuentausuario"
                            + " WHERE nombre_usuario='" + confirmarC + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Usuario Ya se encuentra registrado");

                    } else if (!rs.next()) {

                        try {
                            Connection cn3 = BDConexion.conectar();
                            PreparedStatement pst3 = cn3.prepareStatement(
                                    "insert into cuentausuario values (?,?,?)");

                            pst3.setString(1, null);
                            pst3.setString(2, usuario);
                            pst3.setString(3, contraseña);
                            pst3.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Usuario Registrado");

                            cn3.close();
                            cn.close();

                            dispose();
                            new MenuAdmin().setVisible(true);

                        } catch (Exception e) {
                            System.err.println(e);
                            System.err.println("Error con la Tabla Usuarios");
                            JOptionPane.showMessageDialog(null, "Error al Registrar Usuario");
                        }
                    }

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Error al conectar a base de datos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingreso datos Incorrectos verfique los campos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        }
            
        } else {
            JOptionPane.showMessageDialog(null, "Contrsena no Coinciden");
        }

        
    }//GEN-LAST:event_btn_crearMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_crear;
    private javax.swing.JLabel btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound4;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panel_crear;
    private prueba_diseño.PanelRound panel_salir;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JPasswordField txt_passConfir;
    // End of variables declaration//GEN-END:variables
}
