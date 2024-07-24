package prueba_diseño;

import java.awt.Color;
import javax.swing.JOptionPane;

public class AccesoAdmin extends javax.swing.JFrame {

    public AccesoAdmin() {
        initComponents();
        setTitle("Acceso Admin");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        Estilos boton = new Estilos();
        boton.btnSalir(btn_salir);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new prueba_diseño.PanelRound();
        txt_codigo = new javax.swing.JTextField();
        panel_acceder = new prueba_diseño.PanelRound();
        btn_acceder = new javax.swing.JLabel();
        panel_salir = new prueba_diseño.PanelRound();
        btn_salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(16, 23, 39));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Acceso Administrador");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 220, -1));

        panelRound1.setBackground(new java.awt.Color(204, 204, 204));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_codigo.setBackground(new java.awt.Color(204, 204, 204));
        txt_codigo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_codigo.setForeground(new java.awt.Color(0, 0, 0));
        txt_codigo.setBorder(null);
        panelRound1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 200, 30));

        panel_acceder.setBackground(new java.awt.Color(81, 77, 167));
        panel_acceder.setRoundBottomLeft(25);
        panel_acceder.setRoundBottomRight(25);
        panel_acceder.setRoundTopLeft(25);
        panel_acceder.setRoundTopRight(25);
        panel_acceder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_acceder.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_acceder.setForeground(new java.awt.Color(255, 255, 255));
        btn_acceder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_acceder.setText("Acceder");
        btn_acceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_accederMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_accederMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_accederMouseExited(evt);
            }
        });
        panel_acceder.add(btn_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 40));

        jPanel1.add(panel_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 300, 40));

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

        jPanel1.add(panel_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_accederMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accederMouseEntered
        panel_acceder.setBackground(new Color(80, 5, 5));
    }//GEN-LAST:event_btn_accederMouseEntered

    private void btn_accederMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accederMouseExited
        panel_acceder.setBackground(new Color(81, 77, 167));
    }//GEN-LAST:event_btn_accederMouseExited

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
        panel_salir.setBackground(new Color(14, 120, 220));
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseExited
        panel_salir.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_salirMouseExited

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btn_salirMouseClicked

    private void btn_accederMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accederMouseClicked
        String codigo = txt_codigo.getText().trim();

        if (!codigo.equals("")) {
            if (codigo.equals("G21T02L00")) {
                dispose();
                new MenuAdmin().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Clave de Acceso Incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo Vacio");
        }

    }//GEN-LAST:event_btn_accederMouseClicked

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
            java.util.logging.Logger.getLogger(AccesoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccesoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccesoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccesoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccesoAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_acceder;
    private javax.swing.JLabel btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panel_acceder;
    private prueba_diseño.PanelRound panel_salir;
    private javax.swing.JTextField txt_codigo;
    // End of variables declaration//GEN-END:variables
}
