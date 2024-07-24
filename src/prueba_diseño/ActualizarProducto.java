/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prueba_diseño;

import java.awt.Color;

/**
 *
 * @author usuario
 */
public class ActualizarProducto extends javax.swing.JFrame {

    /**
     * Creates new form ActualizarProducto
     */
    public ActualizarProducto() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);

        Estilos boton = new Estilos();
        boton.btnSalir(btn_salir);

        Estilos icon = new Estilos();
        icon.iconoPrincipal(icon_principal, "src/iconos32px_azul/caja.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new prueba_diseño.PanelRound();
        icon_principal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_salir = new prueba_diseño.PanelRound();
        btn_salir = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelRound4 = new prueba_diseño.PanelRound();
        jTextField6 = new javax.swing.JTextField();
        panel_actualizar = new prueba_diseño.PanelRound();
        btn_actualizar = new javax.swing.JLabel();
        panelRound5 = new prueba_diseño.PanelRound();
        jTextField9 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelRound6 = new prueba_diseño.PanelRound();
        jTextField8 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panelRound12 = new prueba_diseño.PanelRound();
        jTextField7 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel1.setText("Modificar Producto");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 250, 50));

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

        jPanel3.setBackground(new java.awt.Color(16, 23, 39));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        panelRound4.setBackground(new java.awt.Color(204, 204, 204));
        panelRound4.setRoundBottomLeft(25);
        panelRound4.setRoundBottomRight(25);
        panelRound4.setRoundTopLeft(25);
        panelRound4.setRoundTopRight(25);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
        jTextField6.setBorder(null);
        panelRound4.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel3.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 30));

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

        jPanel3.add(panel_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 150, 40));

        panelRound5.setBackground(new java.awt.Color(204, 204, 204));
        panelRound5.setRoundBottomLeft(25);
        panelRound5.setRoundBottomRight(25);
        panelRound5.setRoundTopLeft(25);
        panelRound5.setRoundTopRight(25);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField9.setBackground(new java.awt.Color(204, 204, 204));
        jTextField9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(0, 0, 0));
        jTextField9.setBorder(null);
        panelRound5.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel3.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 200, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        panelRound6.setBackground(new java.awt.Color(204, 204, 204));
        panelRound6.setRoundBottomLeft(25);
        panelRound6.setRoundBottomRight(25);
        panelRound6.setRoundTopLeft(25);
        panelRound6.setRoundTopRight(25);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField8.setBackground(new java.awt.Color(204, 204, 204));
        jTextField8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(0, 0, 0));
        jTextField8.setBorder(null);
        panelRound6.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel3.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Stock");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Almacen");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Descripcion");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        panelRound12.setBackground(new java.awt.Color(204, 204, 204));
        panelRound12.setRoundBottomLeft(25);
        panelRound12.setRoundBottomRight(25);
        panelRound12.setRoundTopLeft(25);
        panelRound12.setRoundTopRight(25);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));
        jTextField7.setBorder(null);
        panelRound12.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel3.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 200, 30));

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almacen1000", "Almacen1001", "Almacen1002", "Almacen1003" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 300));

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

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
        panel_salir.setBackground(new Color(14, 120, 220));
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseExited
        panel_salir.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_salirMouseExited

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
            java.util.logging.Logger.getLogger(ActualizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_actualizar;
    private javax.swing.JLabel btn_salir;
    private javax.swing.JLabel icon_principal;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound12;
    private prueba_diseño.PanelRound panelRound4;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound6;
    private prueba_diseño.PanelRound panel_actualizar;
    private prueba_diseño.PanelRound panel_salir;
    // End of variables declaration//GEN-END:variables
}
