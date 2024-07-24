package prueba_diseño;

import java.awt.Color;

public class ActualizarProveedor extends javax.swing.JFrame {

    
    public ActualizarProveedor() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        Estilos boton = new Estilos();
        boton.btnSalir(btn_salir);
        
        Estilos icon = new Estilos();
        icon.iconoPrincipal(icon_principal, "src/iconos32px_azul/mensajero.png");
        
        
        
        if (MenuPrincipal.tipoCliente == 0) {
            panel_natural.setVisible(true);
            panel_juridico.setVisible(false);
            
            
        } else {
            panel_juridico.setVisible(true);
            panel_natural.setVisible(false);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_natural = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelRound4 = new prueba_diseño.PanelRound();
        panel_actualizar_natural = new prueba_diseño.PanelRound();
        btn_actualizar_natural = new javax.swing.JLabel();
        panelRound5 = new prueba_diseño.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        panelRound6 = new prueba_diseño.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelRound8 = new prueba_diseño.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        panelRound12 = new prueba_diseño.PanelRound();
        panel_juridico = new javax.swing.JPanel();
        panelRound13 = new prueba_diseño.PanelRound();
        jTextField6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelRound14 = new prueba_diseño.PanelRound();
        jTextField12 = new javax.swing.JTextField();
        panelRound15 = new prueba_diseño.PanelRound();
        jTextField13 = new javax.swing.JTextField();
        panel_actualizar = new prueba_diseño.PanelRound();
        btn_actualizar = new javax.swing.JLabel();
        panelRound19 = new prueba_diseño.PanelRound();
        jTextField11 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new prueba_diseño.PanelRound();
        icon_principal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_salir = new prueba_diseño.PanelRound();
        btn_salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_natural.setBackground(new java.awt.Color(16, 23, 39));
        panel_natural.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Direccion");
        panel_natural.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        panelRound4.setBackground(new java.awt.Color(204, 204, 204));
        panelRound4.setRoundBottomLeft(25);
        panelRound4.setRoundBottomRight(25);
        panelRound4.setRoundTopLeft(25);
        panelRound4.setRoundTopRight(25);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_natural.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 30));

        panel_actualizar_natural.setBackground(new java.awt.Color(81, 77, 167));
        panel_actualizar_natural.setRoundBottomLeft(25);
        panel_actualizar_natural.setRoundBottomRight(25);
        panel_actualizar_natural.setRoundTopLeft(25);
        panel_actualizar_natural.setRoundTopRight(25);
        panel_actualizar_natural.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_actualizar_natural.setBackground(new java.awt.Color(16, 23, 39));
        btn_actualizar_natural.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_actualizar_natural.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar_natural.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_actualizar_natural.setText("Actualizar");
        btn_actualizar_natural.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizar_naturalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizar_naturalMouseExited(evt);
            }
        });
        panel_actualizar_natural.add(btn_actualizar_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        panel_natural.add(panel_actualizar_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 150, 40));

        panelRound5.setBackground(new java.awt.Color(204, 204, 204));
        panelRound5.setRoundBottomLeft(25);
        panelRound5.setRoundBottomRight(25);
        panelRound5.setRoundTopLeft(25);
        panelRound5.setRoundTopRight(25);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_natural.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 200, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");
        panel_natural.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        panelRound6.setBackground(new java.awt.Color(204, 204, 204));
        panelRound6.setRoundBottomLeft(25);
        panelRound6.setRoundBottomRight(25);
        panelRound6.setRoundTopLeft(25);
        panelRound6.setRoundTopRight(25);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_natural.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono");
        panel_natural.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo");
        panel_natural.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        panelRound8.setBackground(new java.awt.Color(204, 204, 204));
        panelRound8.setRoundBottomLeft(25);
        panelRound8.setRoundBottomRight(25);
        panelRound8.setRoundTopLeft(25);
        panelRound8.setRoundTopRight(25);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_natural.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Apellido");
        panel_natural.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        panelRound12.setBackground(new java.awt.Color(204, 204, 204));
        panelRound12.setRoundBottomLeft(25);
        panelRound12.setRoundBottomRight(25);
        panelRound12.setRoundTopLeft(25);
        panelRound12.setRoundTopRight(25);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_natural.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 200, 30));

        getContentPane().add(panel_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 300));

        panel_juridico.setBackground(new java.awt.Color(16, 23, 39));
        panel_juridico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound13.setBackground(new java.awt.Color(204, 204, 204));
        panelRound13.setRoundBottomLeft(25);
        panelRound13.setRoundBottomRight(25);
        panelRound13.setRoundTopLeft(25);
        panelRound13.setRoundTopRight(25);
        panelRound13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
        jTextField6.setBorder(null);
        panelRound13.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        panel_juridico.add(panelRound13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 30));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Direccion");
        panel_juridico.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre Empresa");
        panel_juridico.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Telefono");
        panel_juridico.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        panelRound14.setBackground(new java.awt.Color(204, 204, 204));
        panelRound14.setRoundBottomLeft(25);
        panelRound14.setRoundBottomRight(25);
        panelRound14.setRoundTopLeft(25);
        panelRound14.setRoundTopRight(25);
        panelRound14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField12.setBackground(new java.awt.Color(204, 204, 204));
        jTextField12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(0, 0, 0));
        jTextField12.setBorder(null);
        panelRound14.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        panel_juridico.add(panelRound14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 30));

        panelRound15.setBackground(new java.awt.Color(204, 204, 204));
        panelRound15.setRoundBottomLeft(25);
        panelRound15.setRoundBottomRight(25);
        panelRound15.setRoundTopLeft(25);
        panelRound15.setRoundTopRight(25);
        panelRound15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField13.setBackground(new java.awt.Color(204, 204, 204));
        jTextField13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(0, 0, 0));
        jTextField13.setBorder(null);
        panelRound15.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        panel_juridico.add(panelRound15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 200, 30));

        panel_actualizar.setBackground(new java.awt.Color(81, 77, 167));
        panel_actualizar.setRoundBottomLeft(25);
        panel_actualizar.setRoundBottomRight(25);
        panel_actualizar.setRoundTopLeft(25);
        panel_actualizar.setRoundTopRight(25);
        panel_actualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_actualizar.setBackground(new java.awt.Color(16, 23, 39));
        btn_actualizar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizarMouseExited(evt);
            }
        });
        panel_actualizar.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        panel_juridico.add(panel_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 230, 150, 40));

        panelRound19.setBackground(new java.awt.Color(204, 204, 204));
        panelRound19.setRoundBottomLeft(25);
        panelRound19.setRoundBottomRight(25);
        panelRound19.setRoundTopLeft(25);
        panelRound19.setRoundTopRight(25);
        panelRound19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField11.setBackground(new java.awt.Color(204, 204, 204));
        jTextField11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(0, 0, 0));
        jTextField11.setBorder(null);
        panelRound19.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        panel_juridico.add(panelRound19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 200, 30));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Correo");
        panel_juridico.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        getContentPane().add(panel_juridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 300));

        jPanel2.setBackground(new java.awt.Color(16, 23, 39));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_principal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound1.add(icon_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanel2.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 50));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar  Proveedor");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 250, 50));

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

        jPanel2.add(panel_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 50, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btn_salirMouseClicked

    private void btn_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseEntered
        panel_actualizar.setBackground(new Color(80, 5, 5));
    }//GEN-LAST:event_btn_actualizarMouseEntered

    private void btn_actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseExited
        panel_actualizar.setBackground(new Color(81, 77, 167));
    }//GEN-LAST:event_btn_actualizarMouseExited

    private void btn_actualizar_naturalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_naturalMouseEntered
        panel_actualizar_natural.setBackground(new Color(80, 5, 5));
    }//GEN-LAST:event_btn_actualizar_naturalMouseEntered

    private void btn_actualizar_naturalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_naturalMouseExited
        panel_actualizar_natural.setBackground(new Color(81, 77, 167));
    }//GEN-LAST:event_btn_actualizar_naturalMouseExited

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
        panel_salir.setBackground(new Color(14, 120, 220));
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseExited
        panel_salir.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_salirMouseExited

    
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
            java.util.logging.Logger.getLogger(ActualizarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_actualizar;
    private javax.swing.JLabel btn_actualizar_natural;
    private javax.swing.JLabel btn_salir;
    private javax.swing.JLabel icon_principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField6;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound12;
    private prueba_diseño.PanelRound panelRound13;
    private prueba_diseño.PanelRound panelRound14;
    private prueba_diseño.PanelRound panelRound15;
    private prueba_diseño.PanelRound panelRound19;
    private prueba_diseño.PanelRound panelRound4;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound6;
    private prueba_diseño.PanelRound panelRound8;
    private prueba_diseño.PanelRound panel_actualizar;
    private prueba_diseño.PanelRound panel_actualizar_natural;
    private javax.swing.JPanel panel_juridico;
    private javax.swing.JPanel panel_natural;
    private prueba_diseño.PanelRound panel_salir;
    // End of variables declaration//GEN-END:variables
}
