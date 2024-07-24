package prueba_diseño;

import clases_conexion.BDConexion;
import static clases_validacion.ValidacionesGenerales.camposVaciosArray;
import static clases_validacion.ValidacionesGenerales.validarNumerosC;
import static clases_validacion.ValidacionesGenerales.validarTodos;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class NuevoProducto extends javax.swing.JFrame {

    LocalDateTime fecha = LocalDateTime.now();
    int annio = fecha.getYear();
    int mes = fecha.getMonthValue();
    int dia = fecha.getDayOfMonth();
    int segundo = fecha.getSecond();

    public NuevoProducto() {
        initComponents();
        setSize(750, 520);
        setLocationRelativeTo(null);

        Estilos boton = new Estilos();
        boton.btnSalir(btn_salir);

        Estilos icon = new Estilos();
        icon.iconoPrincipal(icon_principal, "src/iconos32px_azul/caja.png");

        try {
            Connection cn = BDConexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_producto FROM `productos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_proveedor.addItem(rs.getString("nombre_producto"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        txt_fecha.setText(dia + "/" + mes + "/" + annio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_natural = new javax.swing.JPanel();
        panel_cod = new prueba_diseño.PanelRound();
        txt_codigo = new javax.swing.JTextField();
        panelRound5 = new prueba_diseño.PanelRound();
        txt_precio = new javax.swing.JTextField();
        panelRound8 = new prueba_diseño.PanelRound();
        txt_nombre = new javax.swing.JTextField();
        panelRound9 = new prueba_diseño.PanelRound();
        txt_fecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_codigo = new prueba_diseño.PanelRound();
        btn_codigo = new javax.swing.JLabel();
        panelRound12 = new prueba_diseño.PanelRound();
        txt_cantidad = new javax.swing.JTextField();
        panelRound7 = new prueba_diseño.PanelRound();
        txt_descripcion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panel_registrar = new prueba_diseño.PanelRound();
        btn_registrar = new javax.swing.JLabel();
        cmb_almacen = new javax.swing.JComboBox<>();
        cmb_proveedor = new javax.swing.JComboBox<>();
        jPanel_cabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new prueba_diseño.PanelRound();
        icon_principal = new javax.swing.JLabel();
        panel_salir = new prueba_diseño.PanelRound();
        btn_salir = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_natural.setBackground(new java.awt.Color(16, 23, 39));
        jPanel_natural.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_cod.setBackground(new java.awt.Color(204, 204, 204));
        panel_cod.setRoundBottomLeft(25);
        panel_cod.setRoundBottomRight(25);
        panel_cod.setRoundTopLeft(25);
        panel_cod.setRoundTopRight(25);
        panel_cod.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_codigo.setEditable(false);
        txt_codigo.setBackground(new java.awt.Color(204, 204, 204));
        txt_codigo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_codigo.setForeground(new java.awt.Color(0, 0, 0));
        txt_codigo.setBorder(null);
        panel_cod.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 30));

        jPanel_natural.add(panel_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, 30));

        panelRound5.setBackground(new java.awt.Color(204, 204, 204));
        panelRound5.setRoundBottomLeft(25);
        panelRound5.setRoundBottomRight(25);
        panelRound5.setRoundTopLeft(25);
        panelRound5.setRoundTopRight(25);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_precio.setBackground(new java.awt.Color(204, 204, 204));
        txt_precio.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_precio.setForeground(new java.awt.Color(0, 0, 0));
        txt_precio.setBorder(null);
        panelRound5.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 30));

        jPanel_natural.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 30));

        panelRound8.setBackground(new java.awt.Color(204, 204, 204));
        panelRound8.setRoundBottomLeft(25);
        panelRound8.setRoundBottomRight(25);
        panelRound8.setRoundTopLeft(25);
        panelRound8.setRoundTopRight(25);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre.setBorder(null);
        panelRound8.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 30));

        jPanel_natural.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 150, 30));

        panelRound9.setBackground(new java.awt.Color(204, 204, 204));
        panelRound9.setRoundBottomLeft(25);
        panelRound9.setRoundBottomRight(25);
        panelRound9.setRoundTopLeft(25);
        panelRound9.setRoundTopRight(25);
        panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_fecha.setEditable(false);
        txt_fecha.setBackground(new java.awt.Color(204, 204, 204));
        txt_fecha.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(0, 0, 0));
        txt_fecha.setBorder(null);
        panelRound9.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 30));

        jPanel_natural.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 150, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo");
        jPanel_natural.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre");
        jPanel_natural.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio");
        jPanel_natural.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha Registro");
        jPanel_natural.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Proveedor");
        jPanel_natural.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, -1, -1));

        panel_codigo.setBackground(new java.awt.Color(81, 77, 167));
        panel_codigo.setRoundBottomLeft(25);
        panel_codigo.setRoundBottomRight(25);
        panel_codigo.setRoundTopLeft(25);
        panel_codigo.setRoundTopRight(25);
        panel_codigo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_codigo.setBackground(new java.awt.Color(16, 23, 39));
        btn_codigo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_codigo.setForeground(new java.awt.Color(255, 255, 255));
        btn_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_codigo.setText("Generar Codigo");
        btn_codigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_codigoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_codigoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_codigoMouseExited(evt);
            }
        });
        panel_codigo.add(btn_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel_natural.add(panel_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 335, 200, 50));

        panelRound12.setBackground(new java.awt.Color(204, 204, 204));
        panelRound12.setRoundBottomLeft(25);
        panelRound12.setRoundBottomRight(25);
        panelRound12.setRoundTopLeft(25);
        panelRound12.setRoundTopRight(25);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cantidad.setBackground(new java.awt.Color(204, 204, 204));
        txt_cantidad.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_cantidad.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidad.setBorder(null);
        panelRound12.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 30));

        jPanel_natural.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 150, 30));

        panelRound7.setBackground(new java.awt.Color(204, 204, 204));
        panelRound7.setRoundBottomLeft(25);
        panelRound7.setRoundBottomRight(25);
        panelRound7.setRoundTopLeft(25);
        panelRound7.setRoundTopRight(25);
        panelRound7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_descripcion.setBackground(new java.awt.Color(204, 204, 204));
        txt_descripcion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_descripcion.setForeground(new java.awt.Color(0, 0, 0));
        txt_descripcion.setBorder(null);
        panelRound7.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 30));

        jPanel_natural.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 150, 30));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Descripcion");
        jPanel_natural.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cantidad");
        jPanel_natural.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Almacen");
        jPanel_natural.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_natural.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 690, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_natural.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 690, 10));

        panel_registrar.setBackground(new java.awt.Color(81, 77, 167));
        panel_registrar.setRoundBottomLeft(25);
        panel_registrar.setRoundBottomRight(25);
        panel_registrar.setRoundTopLeft(25);
        panel_registrar.setRoundTopRight(25);
        panel_registrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_registrar.setBackground(new java.awt.Color(16, 23, 39));
        btn_registrar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_registrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_registrar.setText("Registrar Producto");
        btn_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_registrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_registrarMouseExited(evt);
            }
        });
        panel_registrar.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel_natural.add(panel_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 335, 200, 50));

        cmb_almacen.setBackground(new java.awt.Color(204, 204, 204));
        cmb_almacen.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmb_almacen.setForeground(new java.awt.Color(0, 0, 51));
        cmb_almacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1000", "1001", "1002", "1003" }));
        jPanel_natural.add(cmb_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 150, 30));

        cmb_proveedor.setBackground(new java.awt.Color(204, 204, 204));
        cmb_proveedor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmb_proveedor.setForeground(new java.awt.Color(0, 0, 51));
        jPanel_natural.add(cmb_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 150, 30));

        getContentPane().add(jPanel_natural, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 750, 420));

        jPanel_cabecera.setBackground(new java.awt.Color(16, 23, 39));
        jPanel_cabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Producto");
        jPanel_cabecera.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 250, 50));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_principal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound1.add(icon_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanel_cabecera.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 50));

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

        jPanel_cabecera.add(panel_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 50, 50));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_cabecera.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 230, -1));

        getContentPane().add(jPanel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btn_salirMouseClicked

    private void btn_codigoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_codigoMouseEntered
        panel_codigo.setBackground(new Color(80, 5, 5));
    }//GEN-LAST:event_btn_codigoMouseEntered

    private void btn_codigoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_codigoMouseExited
        panel_codigo.setBackground(new Color(81, 77, 167));
    }//GEN-LAST:event_btn_codigoMouseExited

    private void btn_registrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrarMouseEntered
        panel_registrar.setBackground(new Color(80, 5, 5));
    }//GEN-LAST:event_btn_registrarMouseEntered

    private void btn_registrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrarMouseExited
        panel_registrar.setBackground(new Color(81, 77, 167));
    }//GEN-LAST:event_btn_registrarMouseExited

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
        panel_salir.setBackground(new Color(14, 120, 220));
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseExited
        panel_salir.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_salirMouseExited

    private void btn_codigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_codigoMouseClicked

        String[] campos = {txt_fecha.getText(), txt_nombre.getText(), txt_descripcion.getText()};

        if (camposVaciosArray(campos)) {
            String l1 = String.valueOf(txt_fecha.getText().charAt(0));
            String l2 = String.valueOf(txt_fecha.getText().charAt(1));
            String l3 = String.valueOf(txt_nombre.getText().charAt(0));
            String l4 = String.valueOf(txt_nombre.getText().charAt(1));
            String l5 = String.valueOf(txt_descripcion.getText().charAt(0));
            String l6 = String.valueOf(txt_descripcion.getText().charAt(1));

            panel_cod.setBackground(Color.green);
            txt_codigo.setBackground(Color.green);
            txt_codigo.setText(l3 + l4 + l1 + l2 + l5 + l6 + segundo);
        } else {
            JOptionPane.showMessageDialog(null, "Hay Campos Vacios");
        }
    }//GEN-LAST:event_btn_codigoMouseClicked

    private void btn_registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrarMouseClicked
        String codigo = txt_codigo.getText().trim();
        String nombre = txt_nombre.getText().trim();
        String descripcion = txt_descripcion.getText().trim();
        String cantidad = txt_cantidad.getText().trim();
        String precio = txt_precio.getText().trim();
        String fecha = txt_fecha.getText().trim();
        String almacen = (String) cmb_almacen.getSelectedItem();
        String proveedor = (String) cmb_proveedor.getSelectedItem();

        String[] datosN = {precio, cantidad};
        String[] datosT = {descripcion, codigo, nombre};

        if (camposVaciosArray(datosT) && camposVaciosArray(datosN)) {

            if (validarNumerosC(datosN) && validarTodos(datosT)) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT codigo_productos FROM productos"
                            + " WHERE codigo_productos='" + codigo + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Producto Ya se encuentra registrado");

                    } else if (!rs.next()) {

                        try {
                            Connection cn3 = BDConexion.conectar();
                            PreparedStatement pst3 = cn3.prepareStatement(
                                    "insert into productos values (?,?,?,?,?,?,?,?,?)");

                            pst3.setInt(1, 0);
                            pst3.setString(2, codigo);
                            pst3.setString(3, nombre);
                            pst3.setString(4, descripcion);
                            pst3.setFloat(5, Float.parseFloat(precio));
                            pst3.setInt(6, Integer.parseInt(cantidad));
                            pst3.setString(7, proveedor);
                            pst3.setString(8, fecha);
                            pst3.setString(9, almacen);
                            pst3.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Producto Registrado");

                            cn3.close();
                            cn.close();

                            dispose();
                            MenuPrincipal menu = new MenuPrincipal();
                            menu.setVisible(true);

                        } catch (Exception e) {
                            System.err.println(e);
                            System.err.println("Error con la Tabla Producto");
                            JOptionPane.showMessageDialog(null, "Error al Registrar Producto");
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
    }//GEN-LAST:event_btn_registrarMouseClicked

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
            java.util.logging.Logger.getLogger(NuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_codigo;
    private javax.swing.JLabel btn_registrar;
    private javax.swing.JLabel btn_salir;
    private javax.swing.JComboBox<String> cmb_almacen;
    private javax.swing.JComboBox<String> cmb_proveedor;
    private javax.swing.JLabel icon_principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel_cabecera;
    private javax.swing.JPanel jPanel_natural;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound12;
    private prueba_diseño.PanelRound panelRound5;
    private prueba_diseño.PanelRound panelRound7;
    private prueba_diseño.PanelRound panelRound8;
    private prueba_diseño.PanelRound panelRound9;
    private prueba_diseño.PanelRound panel_cod;
    private prueba_diseño.PanelRound panel_codigo;
    private prueba_diseño.PanelRound panel_registrar;
    private prueba_diseño.PanelRound panel_salir;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
