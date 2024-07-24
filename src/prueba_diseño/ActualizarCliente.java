package prueba_diseño;

import clases_conexion.BDConexion;
import static clases_validacion.ValidacionesGenerales.camposVaciosArray;
import static clases_validacion.ValidacionesGenerales.validarLetras;
import static clases_validacion.ValidacionesGenerales.validarNumerosC;
import static clases_validacion.ValidacionesGenerales.validarTodos;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ActualizarCliente extends javax.swing.JFrame {

    public ActualizarCliente() {
        initComponents();
        setSize(500, 400);
        setLocationRelativeTo(null);

        Estilos boton = new Estilos();
        boton.btnSalir(btn_salir);

        Estilos icon = new Estilos();
        icon.iconoPrincipal(icon_principal, "src/iconos32px_azul/agregar-usuario.png");

        if (MenuPrincipal.tipoCliente == 0) {
            jPanel_juridico.setVisible(false);
            jPanel_cliente.setVisible(true);

        } else {
            jPanel_juridico.setVisible(true);
            jPanel_cliente.setVisible(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_cliente = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelRound4 = new prueba_diseño.PanelRound();
        txt_nombre_natural = new javax.swing.JTextField();
        panel_actualizar_natural = new prueba_diseño.PanelRound();
        btn_actualizar_natural = new javax.swing.JLabel();
        panelRound5 = new prueba_diseño.PanelRound();
        txt_telefono_natural = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelRound6 = new prueba_diseño.PanelRound();
        txt_direccion_natural = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelRound8 = new prueba_diseño.PanelRound();
        txt_correo_natural = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        panelRound12 = new prueba_diseño.PanelRound();
        txt_apellido_natural = new javax.swing.JTextField();
        jPanel_juridico = new javax.swing.JPanel();
        panelRound13 = new prueba_diseño.PanelRound();
        txt_nombre_juridco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelRound14 = new prueba_diseño.PanelRound();
        txt_telefono_juridico = new javax.swing.JTextField();
        panelRound15 = new prueba_diseño.PanelRound();
        txt_correo_juridico = new javax.swing.JTextField();
        panel_actualizar_juridico = new prueba_diseño.PanelRound();
        btn_actualizar_juridico = new javax.swing.JLabel();
        panelRound19 = new prueba_diseño.PanelRound();
        txt_direccion_juridico = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new prueba_diseño.PanelRound();
        icon_principal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_salir = new prueba_diseño.PanelRound();
        btn_salir = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_cliente.setBackground(new java.awt.Color(16, 23, 39));
        jPanel_cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Direccion");
        jPanel_cliente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        panelRound4.setBackground(new java.awt.Color(204, 204, 204));
        panelRound4.setRoundBottomLeft(25);
        panelRound4.setRoundBottomRight(25);
        panelRound4.setRoundTopLeft(25);
        panelRound4.setRoundTopRight(25);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre_natural.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre_natural.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_nombre_natural.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre_natural.setBorder(null);
        panelRound4.add(txt_nombre_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_cliente.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 30));

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_actualizar_naturalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizar_naturalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizar_naturalMouseExited(evt);
            }
        });
        panel_actualizar_natural.add(btn_actualizar_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel_cliente.add(panel_actualizar_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 150, 40));

        panelRound5.setBackground(new java.awt.Color(204, 204, 204));
        panelRound5.setRoundBottomLeft(25);
        panelRound5.setRoundBottomRight(25);
        panelRound5.setRoundTopLeft(25);
        panelRound5.setRoundTopRight(25);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_telefono_natural.setBackground(new java.awt.Color(204, 204, 204));
        txt_telefono_natural.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_telefono_natural.setForeground(new java.awt.Color(0, 0, 0));
        txt_telefono_natural.setBorder(null);
        panelRound5.add(txt_telefono_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_cliente.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 200, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");
        jPanel_cliente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        panelRound6.setBackground(new java.awt.Color(204, 204, 204));
        panelRound6.setRoundBottomLeft(25);
        panelRound6.setRoundBottomRight(25);
        panelRound6.setRoundTopLeft(25);
        panelRound6.setRoundTopRight(25);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_direccion_natural.setBackground(new java.awt.Color(204, 204, 204));
        txt_direccion_natural.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_direccion_natural.setForeground(new java.awt.Color(0, 0, 0));
        txt_direccion_natural.setBorder(null);
        panelRound6.add(txt_direccion_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_cliente.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono");
        jPanel_cliente.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo");
        jPanel_cliente.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        panelRound8.setBackground(new java.awt.Color(204, 204, 204));
        panelRound8.setRoundBottomLeft(25);
        panelRound8.setRoundBottomRight(25);
        panelRound8.setRoundTopLeft(25);
        panelRound8.setRoundTopRight(25);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_correo_natural.setBackground(new java.awt.Color(204, 204, 204));
        txt_correo_natural.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_correo_natural.setForeground(new java.awt.Color(0, 0, 0));
        txt_correo_natural.setBorder(null);
        panelRound8.add(txt_correo_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_cliente.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Apellido");
        jPanel_cliente.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        panelRound12.setBackground(new java.awt.Color(204, 204, 204));
        panelRound12.setRoundBottomLeft(25);
        panelRound12.setRoundBottomRight(25);
        panelRound12.setRoundTopLeft(25);
        panelRound12.setRoundTopRight(25);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_apellido_natural.setBackground(new java.awt.Color(204, 204, 204));
        txt_apellido_natural.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_apellido_natural.setForeground(new java.awt.Color(0, 0, 0));
        txt_apellido_natural.setBorder(null);
        panelRound12.add(txt_apellido_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_cliente.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 200, 30));

        getContentPane().add(jPanel_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 300));

        jPanel_juridico.setBackground(new java.awt.Color(16, 23, 39));
        jPanel_juridico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound13.setBackground(new java.awt.Color(204, 204, 204));
        panelRound13.setRoundBottomLeft(25);
        panelRound13.setRoundBottomRight(25);
        panelRound13.setRoundTopLeft(25);
        panelRound13.setRoundTopRight(25);
        panelRound13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre_juridco.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre_juridco.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_nombre_juridco.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre_juridco.setBorder(null);
        panelRound13.add(txt_nombre_juridco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_juridico.add(panelRound13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 30));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Direccion");
        jPanel_juridico.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre Empresa");
        jPanel_juridico.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Telefono");
        jPanel_juridico.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        panelRound14.setBackground(new java.awt.Color(204, 204, 204));
        panelRound14.setRoundBottomLeft(25);
        panelRound14.setRoundBottomRight(25);
        panelRound14.setRoundTopLeft(25);
        panelRound14.setRoundTopRight(25);
        panelRound14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_telefono_juridico.setBackground(new java.awt.Color(204, 204, 204));
        txt_telefono_juridico.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_telefono_juridico.setForeground(new java.awt.Color(0, 0, 0));
        txt_telefono_juridico.setBorder(null);
        panelRound14.add(txt_telefono_juridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_juridico.add(panelRound14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 30));

        panelRound15.setBackground(new java.awt.Color(204, 204, 204));
        panelRound15.setRoundBottomLeft(25);
        panelRound15.setRoundBottomRight(25);
        panelRound15.setRoundTopLeft(25);
        panelRound15.setRoundTopRight(25);
        panelRound15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_correo_juridico.setBackground(new java.awt.Color(204, 204, 204));
        txt_correo_juridico.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_correo_juridico.setForeground(new java.awt.Color(0, 0, 0));
        txt_correo_juridico.setBorder(null);
        panelRound15.add(txt_correo_juridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_juridico.add(panelRound15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 200, 30));

        panel_actualizar_juridico.setBackground(new java.awt.Color(81, 77, 167));
        panel_actualizar_juridico.setRoundBottomLeft(25);
        panel_actualizar_juridico.setRoundBottomRight(25);
        panel_actualizar_juridico.setRoundTopLeft(25);
        panel_actualizar_juridico.setRoundTopRight(25);
        panel_actualizar_juridico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_actualizar_juridico.setBackground(new java.awt.Color(16, 23, 39));
        btn_actualizar_juridico.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_actualizar_juridico.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar_juridico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_actualizar_juridico.setText("Actualizar");
        btn_actualizar_juridico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_actualizar_juridicoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizar_juridicoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizar_juridicoMouseExited(evt);
            }
        });
        panel_actualizar_juridico.add(btn_actualizar_juridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel_juridico.add(panel_actualizar_juridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 230, 150, 40));

        panelRound19.setBackground(new java.awt.Color(204, 204, 204));
        panelRound19.setRoundBottomLeft(25);
        panelRound19.setRoundBottomRight(25);
        panelRound19.setRoundTopLeft(25);
        panelRound19.setRoundTopRight(25);
        panelRound19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_direccion_juridico.setBackground(new java.awt.Color(204, 204, 204));
        txt_direccion_juridico.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_direccion_juridico.setForeground(new java.awt.Color(0, 0, 0));
        txt_direccion_juridico.setBorder(null);
        panelRound19.add(txt_direccion_juridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jPanel_juridico.add(panelRound19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 200, 30));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Correo");
        jPanel_juridico.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        getContentPane().add(jPanel_juridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 300));

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
        jLabel1.setText("Modificar Registro Cliente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 250, 50));

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

    private void btn_actualizar_juridicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_juridicoMouseClicked
        int validacion = 0;
        String nombre = txt_nombre_juridco.getText().trim();
        String direciion = txt_direccion_juridico.getText().trim();
        String telefono = txt_telefono_juridico.getText().trim();
        String correo = txt_correo_juridico.getText().trim();

//        if (validacion == 0) {
//
//            try {
//                Connection cn = BDConexion.conectar();
//                PreparedStatement pst = cn.prepareStatement(
//                        "update equipos set tipo_equipo=?, marca=?, modelo=?,"
//                        + " num_serie=?, observaciones=?, estatus=?, ultima_modificacion=? "
//                        + "where id_equipo = '" + IDequipo + "'");
//
//                pst.setString(1, tipo_equipo);
//                pst.setString(2, marca);
//                pst.setString(3, modelo);
//                pst.setString(4, num_serie);
//                pst.setString(5, observaciones);
//                pst.setString(6, estatus);
//                pst.setString(7, user);
//
//                pst.executeUpdate();
//                cn.close();
//
//                Limpiar();
//
//                txt_NombreCliente.setBackground(Color.green);
//                txt_fecha.setBackground(Color.green);
//                txt_modelo.setBackground(Color.green);
//                txt_num_serie.setBackground(Color.green);
//                txt_ultima_Modificacion.setText(user);
//
//                JOptionPane.showMessageDialog(null, "Actualización correcta.");
//                this.dispose();
//
//            } catch (SQLException e) {
//                System.err.println("Error en actualizar equipo." + e);
//                JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar equipo!!, contacte al administrador.");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
//        }
    }//GEN-LAST:event_btn_actualizar_juridicoMouseClicked

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btn_salirMouseClicked

    private void btn_actualizar_naturalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_naturalMouseClicked
//        String nombre = txt_nombre_natural.getText().trim();
//        String apellido = txt_apellido_natural.getText().trim();
//        String direccion = txt_direccion_natural.getText().trim();
//        String telefono = txt_telefono_natural.getText().trim();
//        String correo = txt_correo_natural.getText().trim();
//
//        String[] datosL = {nombre, apellido};
//        String[] datosN = {telefono};
//        String[] datosT = {direccion};
//
//        if (camposVaciosArray(datosL) && camposVaciosArray(datosN) && camposVaciosArray(datosT)) {
//
//            if (validarNumerosC(datosN) && validarLetras(datosL) && validarTodos(datosT)) {
//
//                try {
//                    Connection cn = BDConexion.conectar();
//                    PreparedStatement pst = cn.prepareStatement(
//                            "SELECT ci_cliente FROM clientenatural"
//                            + " WHERE ci_cliente='" + MenuPrincipal.documento + "'");
//                    ResultSet rs = pst.executeQuery();
//
//                    if (rs.next()) {
//                        try {
////                            Connection cn = BDConexion.conectar();
////                            PreparedStatement pst = cn.prepareStatement(
////                                    "update equipos set tipo_equipo=?, marca=?, modelo=?,"
////                                    + " num_serie=?, observaciones=?, estatus=?, ultima_modificacion=? "
////                                    + "where id_equipo = '" + IDequipo + "'");
////
////                            pst.setString(1, tipo_equipo);
////                            pst.setString(2, marca);
////                            pst.setString(3, modelo);
////                            pst.setString(4, num_serie);
////                            pst.setString(5, observaciones);
////                            pst.setString(6, estatus);
////                            pst.setString(7, user);
////
////                            pst.executeUpdate();
////                            cn.close();
////
////                            Limpiar();
////
////                            txt_NombreCliente.setBackground(Color.green);
////                            txt_fecha.setBackground(Color.green);
////                            txt_modelo.setBackground(Color.green);
////                            txt_num_serie.setBackground(Color.green);
////                            txt_ultima_Modificacion.setText(user);
//
//                            JOptionPane.showMessageDialog(null, "Actualización correcta.");
//                            this.dispose();
//
//                        } catch (SQLException e) {
//                            System.err.println("Error en actualizar equipo." + e);
//                            JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar equipo!!, contacte al administrador.");
//                        }
//
//                    } else if (!rs.next()) {
//
//                    }
//
//                } catch (Exception e) {
//                    System.err.println(e);
//                    JOptionPane.showMessageDialog(null, "Error al conectar a base de datos");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Ingreso datos Incorrectos verfique los campos");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Hay campos vacios");
//        }


    }//GEN-LAST:event_btn_actualizar_naturalMouseClicked

    private void btn_actualizar_juridicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_juridicoMouseEntered
        panel_actualizar_juridico.setBackground(new Color(80, 5, 5));
    }//GEN-LAST:event_btn_actualizar_juridicoMouseEntered

    private void btn_actualizar_juridicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_juridicoMouseExited
        panel_actualizar_juridico.setBackground(new Color(81, 77, 167));
    }//GEN-LAST:event_btn_actualizar_juridicoMouseExited

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
            java.util.logging.Logger.getLogger(ActualizarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_actualizar_juridico;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_cliente;
    private javax.swing.JPanel jPanel_juridico;
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
    private prueba_diseño.PanelRound panel_actualizar_juridico;
    private prueba_diseño.PanelRound panel_actualizar_natural;
    private prueba_diseño.PanelRound panel_salir;
    private javax.swing.JTextField txt_apellido_natural;
    private javax.swing.JTextField txt_correo_juridico;
    private javax.swing.JTextField txt_correo_natural;
    private javax.swing.JTextField txt_direccion_juridico;
    private javax.swing.JTextField txt_direccion_natural;
    private javax.swing.JTextField txt_nombre_juridco;
    private javax.swing.JTextField txt_nombre_natural;
    private javax.swing.JTextField txt_telefono_juridico;
    private javax.swing.JTextField txt_telefono_natural;
    // End of variables declaration//GEN-END:variables
}
