package prueba_diseño;

import clases_conexion.BDConexion;
import clases_validacion.ValidacionesGenerales;
import clases_validacion.ValidacionesIndividual;
import java.awt.Color;
import java.awt.Image;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public static String user ="";
    int xMouse, yMouse;

    public Login() {
        initComponents();
        setTitle("Inicio - Sesion");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon logo = new ImageIcon("src/imagenes2/LogoEmpresa.jpg");
        Icon logo2 = new ImageIcon(logo.getImage().getScaledInstance(jLabel_logo.getWidth(), jLabel_logo.getHeight(),
                Image.SCALE_DEFAULT));
        jLabel_logo.setIcon(logo2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new prueba_diseño.PanelRound();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        txt_usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        panel_iniciar = new prueba_diseño.PanelRound();
        btn_iniciar = new javax.swing.JLabel();
        panel_gestionar = new prueba_diseño.PanelRound();
        btn_gestionar = new javax.swing.JLabel();
        btn_Salir = new javax.swing.JPanel();
        label_salir = new javax.swing.JLabel();
        jLabel_logo = new javax.swing.JLabel();
        mover_ventana = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(16, 23, 39));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(240, 240, 240));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 250, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 250, -1));

        txt_usuario.setBackground(new java.awt.Color(240, 240, 240));
        txt_usuario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(0, 0, 51));
        txt_usuario.setBorder(null);
        txt_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_usuarioMousePressed(evt);
            }
        });
        panelRound1.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 250, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Usuario");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(15, 71, 119));
        jLabel2.setText("Iniciar Sesion");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        txt_pass.setBackground(new java.awt.Color(240, 240, 240));
        txt_pass.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(0, 0, 51));
        txt_pass.setBorder(null);
        txt_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_passMousePressed(evt);
            }
        });
        panelRound1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 250, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Contraseña");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        panel_iniciar.setBackground(new java.awt.Color(10, 49, 81));
        panel_iniciar.setRoundBottomLeft(25);
        panel_iniciar.setRoundBottomRight(25);
        panel_iniciar.setRoundTopLeft(25);
        panel_iniciar.setRoundTopRight(25);
        panel_iniciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_iniciar.setForeground(new java.awt.Color(255, 255, 255));
        btn_iniciar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_iniciar.setText("Iniciar Sesion");
        btn_iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_iniciarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_iniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_iniciarMouseExited(evt);
            }
        });
        panel_iniciar.add(btn_iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        panelRound1.add(panel_iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 150, 30));

        panel_gestionar.setBackground(new java.awt.Color(10, 49, 81));
        panel_gestionar.setRoundBottomLeft(25);
        panel_gestionar.setRoundBottomRight(25);
        panel_gestionar.setRoundTopLeft(25);
        panel_gestionar.setRoundTopRight(25);
        panel_gestionar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_gestionar.setForeground(new java.awt.Color(255, 255, 255));
        btn_gestionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_gestionar.setText("Gestionar Usuarios");
        btn_gestionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_gestionarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gestionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gestionarMouseExited(evt);
            }
        });
        panel_gestionar.add(btn_gestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        panelRound1.add(panel_gestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 150, 30));

        jPanel2.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 350, 400));

        btn_Salir.setBackground(new java.awt.Color(16, 23, 39));

        label_salir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_salir.setForeground(new java.awt.Color(255, 255, 255));
        label_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_salir.setText("X");
        label_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_salirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_salirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_SalirLayout = new javax.swing.GroupLayout(btn_Salir);
        btn_Salir.setLayout(btn_SalirLayout);
        btn_SalirLayout.setHorizontalGroup(
            btn_SalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_salir, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        btn_SalirLayout.setVerticalGroup(
            btn_SalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_salir, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 50, 50));

        jLabel_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 420, 500));

        mover_ventana.setBackground(new java.awt.Color(16, 23, 39));
        mover_ventana.setForeground(new java.awt.Color(255, 255, 255));
        mover_ventana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mover_ventanaMouseDragged(evt);
            }
        });
        mover_ventana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mover_ventanaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout mover_ventanaLayout = new javax.swing.GroupLayout(mover_ventana);
        mover_ventana.setLayout(mover_ventanaLayout);
        mover_ventanaLayout.setHorizontalGroup(
            mover_ventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        mover_ventanaLayout.setVerticalGroup(
            mover_ventanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(mover_ventana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mover_ventanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mover_ventanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_mover_ventanaMouseDragged

    private void mover_ventanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mover_ventanaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_mover_ventanaMousePressed

    private void label_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_label_salirMouseClicked

    private void label_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salirMouseEntered
        btn_Salir.setBackground(new Color(140, 0, 0));
        label_salir.setForeground(Color.WHITE);
    }//GEN-LAST:event_label_salirMouseEntered

    private void label_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salirMouseExited
        btn_Salir.setBackground(new Color(16, 23, 39));
        label_salir.setForeground(Color.WHITE);
    }//GEN-LAST:event_label_salirMouseExited

    private void txt_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usuarioMousePressed

    }//GEN-LAST:event_txt_usuarioMousePressed

    private void txt_passMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passMousePressed

    }//GEN-LAST:event_txt_passMousePressed

    private void btn_iniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iniciarMouseEntered
        panel_iniciar.setBackground(new Color(14, 120, 220));
    }//GEN-LAST:event_btn_iniciarMouseEntered

    private void btn_iniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iniciarMouseExited
        panel_iniciar.setBackground(new Color(10, 49, 81));
    }//GEN-LAST:event_btn_iniciarMouseExited

    private void btn_gestionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionarMouseEntered
        panel_gestionar.setBackground(new Color(14, 120, 220));
    }//GEN-LAST:event_btn_gestionarMouseEntered

    private void btn_gestionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionarMouseExited
        panel_gestionar.setBackground(new Color(10, 49, 81));
    }//GEN-LAST:event_btn_gestionarMouseExited

    private void btn_gestionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionarMouseClicked
        dispose();
        new AccesoAdmin().setVisible(true);
    }//GEN-LAST:event_btn_gestionarMouseClicked

    private void btn_iniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iniciarMouseClicked
        
        ValidacionesIndividual validarI = new ValidacionesIndividual();
        ValidacionesGenerales validarG = new ValidacionesGenerales();
        String usuario = txt_usuario.getText().trim();
        String contraseña = txt_pass.getText().trim();
        String consulta = "select nombre_usuario, contraseña from CuentaUsuario where nombre_usuario = '" + usuario
                + "' and contraseña = '" + contraseña + "'";
        String[] campos = {usuario, contraseña};
        
        user = usuario;
        System.out.println(user);
        
        MenuPrincipal menu = new MenuPrincipal();
        

        if (validarG.camposVaciosArray(campos) == true) {

            try {
                Connection cn = BDConexion.conectar();
                PreparedStatement pst = cn.prepareStatement(consulta);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String usuarioBD = rs.getString("nombre_usuario");
                    String contraseñaBD = rs.getString("contraseña");

                    if (validarI.compararDatos(usuario, contraseña, usuarioBD, contraseñaBD) == true) {
                        dispose();
                        menu.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingreso un dato incorrecto");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");

                }
            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos de texto");
        }
    }//GEN-LAST:event_btn_iniciarMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_Salir;
    private javax.swing.JLabel btn_gestionar;
    private javax.swing.JLabel btn_iniciar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_salir;
    private javax.swing.JPanel mover_ventana;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panel_gestionar;
    private prueba_diseño.PanelRound panel_iniciar;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
