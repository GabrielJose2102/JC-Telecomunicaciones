package prueba_diseño;

import clases_conexion.BDConexion;
import static clases_validacion.ValidacionesGenerales.camposVaciosArray;
import static clases_validacion.ValidacionesGenerales.validarLetras;
import static clases_validacion.ValidacionesGenerales.validarNumerosC;
import static clases_validacion.ValidacionesGenerales.validarTodos;
import java.awt.Color;
import java.awt.Image;
import java.sql.*;
import java.time.LocalDateTime;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuPrincipal extends javax.swing.JFrame {

    /*Varible para pasar numero de documento a otra interfaz*/
    public static String documento = "";
    public static int tipoCliente = 0;
    public static String codigo = "";
    

    /*Fecha y Hora*/
    LocalDateTime fecha = LocalDateTime.now();

    int annio = fecha.getYear();
    int mes = fecha.getMonthValue();
    int dia = fecha.getDayOfMonth();
    int hora = fecha.getHour();
    int minutos = fecha.getMinute();
    int segundo = fecha.getSecond();

//    txt_fecha.setText (annio 
//    + "/" + mes + "/" + dia + " Hora: " + hora + ":" + minutos + ":" + segundo);
    /*Estilos de los botones*/
    int boton_presionado = 1;
    Estilos botones = new Estilos();

    /*Crear modelo de Tablas para datos*/
    DefaultTableModel modelNatural = new DefaultTableModel();
    DefaultTableModel modelJudico = new DefaultTableModel();
    DefaultTableModel proveedorNatural = new DefaultTableModel();
    DefaultTableModel proveedorJuridico = new DefaultTableModel();
    DefaultTableModel producto = new DefaultTableModel();
    DefaultTableModel empleado = new DefaultTableModel();
    DefaultTableModel historial = new DefaultTableModel();
    DefaultTableModel factura = new DefaultTableModel();

    /*Variables Contadores*/
    int num_clientesNatural = 0;
    int num_clientesJuridico = 0;
    int num_proveedoresNatural = 0;
    int num_proveedoresJuridico = 0;
    int num_empleados = 0;
    int num_prodcto = 0;
    int num_ventas = 0;

    public MenuPrincipal() {   
        initComponents();
        setTitle("Menu Inicio");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        
     
        txt_usuario.setText(Login.user);
        
        jPanel_inicio.setVisible(true);
        jPanel_cliente.setVisible(false);
        jPanel_proveedor.setVisible(false);
        jPanel_inventario.setVisible(false);
        jPanel_factura.setVisible(false);
        jPanel_historial.setVisible(false);
        jPanel_empleado.setVisible(false);

        /*Menu Principal*/
        ImageIcon logo_menu = new ImageIcon("src/imagenes2/LogoEmpresa 150px.jpg");
        Icon logoIcon_menu = new ImageIcon(logo_menu.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        jLabel_logo.setIcon(logoIcon_menu);

        ImageIcon usuario_menu = new ImageIcon("src/imagenes2/usuario.png");
        Icon usuarioIcon_menu = new ImageIcon(usuario_menu.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
        icon_user.setIcon(usuarioIcon_menu);

        ImageIcon inicio_menu = new ImageIcon("src/imagenes2/casa.png");
        Icon inicioIcon_menu = new ImageIcon(inicio_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_inicio.setIcon(inicioIcon_menu);

        ImageIcon cliente_menu = new ImageIcon("src/imagenes2/atencion-al-cliente.png");
        Icon clienteIcon_menu = new ImageIcon(cliente_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_cliente.setIcon(clienteIcon_menu);

        ImageIcon proveedor_menu = new ImageIcon("src/imagenes2/proveedor.png");
        Icon proveedorIcon_menu = new ImageIcon(proveedor_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_proveedor.setIcon(proveedorIcon_menu);

        ImageIcon inventario_menu = new ImageIcon("src/imagenes2/inventario.png");
        Icon inventarioIcon_menu = new ImageIcon(inventario_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_inventario.setIcon(inventarioIcon_menu);

        ImageIcon facturacion_menu = new ImageIcon("src/imagenes2/factura.png");
        Icon facturacionIcon_menu = new ImageIcon(facturacion_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_facturacion.setIcon(facturacionIcon_menu);

        ImageIcon historial_menu = new ImageIcon("src/imagenes2/factura (1).png");
        Icon historialIcon_menu = new ImageIcon(historial_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_historial.setIcon(historialIcon_menu);

        ImageIcon empleado_menu = new ImageIcon("src/imagenes2/empleado-de-oficina.png");
        Icon empleadoIcon_menu = new ImageIcon(empleado_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_empleado.setIcon(empleadoIcon_menu);

        ImageIcon ayuda_menu = new ImageIcon("src/imagenes2/llamada-de-ayuda.png");
        Icon ayudaIcon_menu = new ImageIcon(ayuda_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_ayuda.setIcon(ayudaIcon_menu);

        ImageIcon salir_menu = new ImageIcon("src/imagenes2/cerrar-sesion.png");
        Icon salirIcon_menu = new ImageIcon(salir_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        icon_salir.setIcon(salirIcon_menu);
        /*Menu Principal*/

 /*Inicio*/
        ImageIcon inicio_cliente = new ImageIcon("src/iconos32px/customer.png");
        Icon inicioIcon_cliente = new ImageIcon(inicio_cliente.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        cliente_icon.setIcon(inicioIcon_cliente);

        ImageIcon inicio_proveedor = new ImageIcon("src/iconos32px/repartidor.png");
        Icon inicioIcon_proveedor = new ImageIcon(inicio_proveedor.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        proveedor_icon.setIcon(inicioIcon_proveedor);

        ImageIcon inicio_empleado = new ImageIcon("src/iconos32px/empleados.png");
        Icon inicioIcon_empleado = new ImageIcon(inicio_empleado.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        empleado_icon.setIcon(inicioIcon_empleado);

        ImageIcon inicio_producto = new ImageIcon("src/iconos32px/producto.png");
        Icon inicioIcon_producto = new ImageIcon(inicio_producto.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        producto_icon.setIcon(inicioIcon_producto);

        ImageIcon inicio_Ventas = new ImageIcon("src/iconos32px/ventas.png");
        Icon inicioIcon_Ventas = new ImageIcon(inicio_Ventas.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        Ventas_icon.setIcon(inicioIcon_Ventas);

        /*Clientes*/
        ImageIcon cliente_cliente = new ImageIcon("src/iconos32px/customer.png");
        Icon clienteIcon_cliente = new ImageIcon(cliente_cliente.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        cliente_cliente_icon.setIcon(clienteIcon_cliente);

        ImageIcon cliente_buscar = new ImageIcon("src/iconos16px/lupa.png");
        Icon clienteIcon_buscar = new ImageIcon(cliente_buscar.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
        cliente_buscar_icon.setIcon(clienteIcon_buscar);

        /*Proveedores*/
        ImageIcon proveedor_proveedor = new ImageIcon("src/iconos32px/repartidor.png");
        Icon proveedorIcon_proveedor = new ImageIcon(proveedor_proveedor.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        proveedor_proveedor_icon.setIcon(proveedorIcon_proveedor);

        ImageIcon proveedor_buscar = new ImageIcon("src/iconos16px/lupa.png");
        Icon proveedorIcon_buscar = new ImageIcon(proveedor_buscar.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
        proveedor_buscar_icon.setIcon(proveedorIcon_buscar);

        /*Inventario*/
        ImageIcon inventario = new ImageIcon("src/iconos32px/producto.png");
        Icon incentarioIcon_inventario = new ImageIcon(inventario.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        inventario_inventario_icon.setIcon(incentarioIcon_inventario);

        ImageIcon inventario_buscar = new ImageIcon("src/iconos16px/lupa.png");
        Icon inventarioIcon_buscar = new ImageIcon(inventario_buscar.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
        inventario_buscar_icon.setIcon(inventarioIcon_buscar);

        /*Facturacion*/
        ImageIcon facturacion_facturacion = new ImageIcon("src/iconos32px/casa.png");
        Icon facturacionIcon_facturacion = new ImageIcon(facturacion_facturacion.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        facturacion_venta_icon.setIcon(facturacionIcon_facturacion);

        ImageIcon facturacion_cliente = new ImageIcon("src/iconos24px_azul/usuario-especialista.png");
        Icon facturacionIcon_cliente = new ImageIcon(facturacion_cliente.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
        facturacion_cliente_icon.setIcon(facturacionIcon_cliente);

        ImageIcon facturacion_producto = new ImageIcon("src/iconos24px_azul/danado.png");
        Icon facturacionIcon_producto = new ImageIcon(facturacion_producto.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
        facturacion_producto_icon.setIcon(facturacionIcon_producto);

        /*Historial*/
        ImageIcon historial_historial = new ImageIcon("src/iconos32px/ventas.png");
        Icon historialIcon_historial = new ImageIcon(historial_historial.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        historial_historial_icon.setIcon(historialIcon_historial);

        /*Empleados*/
        ImageIcon empleado_empleado = new ImageIcon("src/iconos32px/empleados.png");
        Icon empleadoIcon_empleado = new ImageIcon(empleado_empleado.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        empleado_empleado_icon.setIcon(empleadoIcon_empleado);

        ImageIcon empleado_buscar = new ImageIcon("src/iconos16px/lupa.png");
        Icon empleadoIcon_buscar = new ImageIcon(empleado_buscar.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
        empleado_buscar_icon.setIcon(empleadoIcon_buscar);

        /*Llenado de Tabla ClienteNatural*/
        try {
            Connection cn = BDConexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT cn.ci_cliente, cn.nombres_cliente, cn.apellidos_cliente,\n"
                    + "c.direccion, c.telefono, c.correo, cn.tipo_cliente_id \n"
                    + "from clientes c, clientenatural cn\n"
                    + "WHERE c.documento_cliente = cn.ci_cliente\n"
                    + "AND c.tipo_Cliente_id = cn.tipo_cliente_id;");
            ResultSet rs = pst.executeQuery();

            jTable_registroClientesNatural = new JTable(modelNatural);
            jScrollPane_registroClientesNatural.setViewportView(jTable_registroClientesNatural);

            modelNatural.addColumn("Cedula");
            modelNatural.addColumn("Nombre");
            modelNatural.addColumn("Apellido");
            modelNatural.addColumn("Direccion");
            modelNatural.addColumn("Telefono");
            modelNatural.addColumn("Correo");

            while (rs.next()) {
                Object[] filas = new Object[6];

                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                num_clientesNatural++;
                modelNatural.addRow(filas);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Llenado de Tabla ClienteJuridico*/
        try {
            Connection cn = BDConexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT cj.rif_empresa, cj.nombre_empresa, c.direccion, c.telefono,\n"
                    + "c.correo, c.tipo_Cliente_id\n"
                    + "from clientes c, clientejuridico cj\n"
                    + "WHERE c.documento_cliente = cj.rif_empresa\n"
                    + "AND c.tipo_Cliente_id = cj.tipo_cliente_id;");
            ResultSet rs = pst.executeQuery();

            jTable_registroClientesJuridico = new JTable(modelJudico);
            jScrollPane_registroClientesJuridico.setViewportView(jTable_registroClientesJuridico);

            modelJudico.addColumn("Rif");
            modelJudico.addColumn("Nombre");
            modelJudico.addColumn("Direccion");
            modelJudico.addColumn("Telefono");
            modelJudico.addColumn("Correo");

            while (rs.next()) {
                Object[] filas = new Object[5];

                for (int i = 0; i < 5; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                num_clientesJuridico++;
                modelJudico.addRow(filas);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Llenado de Tabla ProveedorNatural*/
        try {
            Connection cn2 = BDConexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT pn.ci_proveedor, pn.nombre_proveedor, pn.apellidos_proveedor,\n"
                    + "p.direccion, p.telefono, p.correo, pn.TipoProveedor_id_tipo_proveedor\n"
                    + "from proveedores p, proveedornatural pn\n"
                    + "WHERE p.documento_proveedor = pn.ci_proveedor\n"
                    + "AND p.TipoProveedor_id_tipo_proveedor = pn.TipoProveedor_id_tipo_proveedor;");
            ResultSet rs2 = pst2.executeQuery();

            jTable_registroProveedoresNatural = new JTable(proveedorNatural);
            jScrollPane_registroProveedoresNatural.setViewportView(jTable_registroProveedoresNatural);

            proveedorNatural.addColumn("Cedula");
            proveedorNatural.addColumn("Nombre");
            proveedorNatural.addColumn("Apellido");
            proveedorNatural.addColumn("Direccion");
            proveedorNatural.addColumn("Telefono");
            proveedorNatural.addColumn("Correo");

            while (rs2.next()) {
                Object[] filas = new Object[6];

                for (int i = 0; i < 6; i++) {
                    filas[i] = rs2.getObject(i + 1);
                }
                num_proveedoresNatural++;
                proveedorNatural.addRow(filas);
            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Llenado de Tabla ProveedorJuridico*/
        try {
            Connection cn2 = BDConexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT pj.rif_proveedor, pj.nombre_empresa, p.direccion,\n"
                    + "p.telefono, p.correo, pj.TipoProveedor_id_tipo_proveedor\n"
                    + "FROM proveedores p, proveedorjuridico pj\n"
                    + "WHERE p.documento_proveedor = pj.rif_proveedor\n"
                    + "AND p.TipoProveedor_id_tipo_proveedor = pj.TipoProveedor_id_tipo_proveedor;");
            ResultSet rs2 = pst2.executeQuery();

            jTable_registroProveedoresJuridico = new JTable(proveedorJuridico);
            jScrollPane_registroProveedoresJuridico.setViewportView(jTable_registroProveedoresJuridico);

            proveedorJuridico.addColumn("Rif");
            proveedorJuridico.addColumn("Nombre Empresa");
            proveedorJuridico.addColumn("Direccion");
            proveedorJuridico.addColumn("Telefono");
            proveedorJuridico.addColumn("Correo");

            while (rs2.next()) {
                Object[] filas = new Object[6];

                for (int i = 0; i < 6; i++) {
                    filas[i] = rs2.getObject(i + 1);
                }
                num_proveedoresJuridico++;
                proveedorJuridico.addRow(filas);
            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Llenado de Tabla Inventario*/
        try {
            Connection cn2 = BDConexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT codigo_productos, nombre_producto, precio, stock,\n"
                    + "Proveedor, fecha_registro, almacen\n"
                    + "from productos");
            ResultSet rs2 = pst2.executeQuery();

            jTable_registroInventario = new JTable(producto);
            jScrollPane_registroInventario.setViewportView(jTable_registroInventario);

            producto.addColumn("Codigo");
            producto.addColumn("Nombre");
            producto.addColumn("Precio");
            producto.addColumn("Stock");
            producto.addColumn("Proveedor");
            producto.addColumn("Fecha Ingreso");
            producto.addColumn("Almacen");

            while (rs2.next()) {
                Object[] filas = new Object[7];

                for (int i = 0; i < 7; i++) {
                    filas[i] = rs2.getObject(i + 1);
                }
                num_prodcto++;
                producto.addRow(filas);
            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Llenado de Tabla Historial*/
        try {
            Connection cn2 = BDConexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT * from ventas");
            ResultSet rs2 = pst2.executeQuery();

            jTable_registroHistorial = new JTable(historial);
            jScrollPane_registroHistorial.setViewportView(jTable_registroHistorial);

            historial.addColumn("ID");
            historial.addColumn("codigo");
            historial.addColumn("Fecha");
            historial.addColumn("Hora");
            historial.addColumn("Producto");
            historial.addColumn("Cliente");
            historial.addColumn("");
            historial.addColumn("Comprobante");
            historial.addColumn("Monto");

            while (rs2.next()) {
                Object[] filas = new Object[9];

                for (int i = 0; i < 9; i++) {
                    filas[i] = rs2.getObject(i + 1);
                }
                num_ventas++;
                historial.addRow(filas);
            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Llenado de Tabla Empleado*/
        try {
            Connection cn2 = BDConexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT `ci_empleado`, `nombres_empleado`, `apellidos_empleado`, `genero`,"
                    + " `direccion`, `telefono`, `correo` FROM `empleados`");
            ResultSet rs2 = pst2.executeQuery();

            jTable_registroEmpleado = new JTable(empleado);
            jScrollPane_registroEmpleado.setViewportView(jTable_registroEmpleado);

            empleado.addColumn("Cedula");
            empleado.addColumn("Nombres");
            empleado.addColumn("Apellidos");
            empleado.addColumn("Genero");
            empleado.addColumn("Direccion");
            empleado.addColumn("Telefono");

            while (rs2.next()) {
                Object[] filas = new Object[6];

                for (int i = 0; i < 6; i++) {
                    filas[i] = rs2.getObject(i + 1);
                }
                num_empleados++;
                empleado.addRow(filas);
            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Resumen de Registro - Inicio*/
        int totalClientes = num_clientesNatural + num_clientesJuridico;
        String numC = toString().valueOf(totalClientes);
        int totalProveedores = num_proveedoresNatural + num_proveedoresJuridico;
        String numP = toString().valueOf(totalProveedores);
        String numPD = toString().valueOf(num_prodcto);
        String numV = toString().valueOf(num_ventas);
        String numE = toString().valueOf(num_empleados);

        txt_cantidad_clientes.setText(numC);
        txt_cantidad_proveedores.setText(numP);
        txt_cantidad_productos.setText(numPD);
        txt_cantidad_ventas.setText(numV);
        txt_cantidad_empleados.setText(numE);

        /*Fecha y Hora*/
        txt_fecha.setText(dia + " / " + mes + " / " + annio);
        txt_fechaVentas.setText(dia + " / " + mes + " / " + annio);
        jLabel1_inicioSesion.setText("Hora de Inicio: " + hora + ":" + minutos + ":" + segundo);

        

        /*Insertar Lissta al combo box de facturacion*/
        try {
            Connection cn = BDConexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT documento_cliente FROM `clientes`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_proveedor.addItem(rs.getString("documento_cliente"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        try {
            Connection cn = BDConexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT codigo_productos FROM `productos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_proveedor.addItem(rs.getString("codigo_productos"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        /*Facturacion Tabla*/
        tabla_factura = new JTable(factura);
        jScroll_factura.setViewportView(tabla_factura);

        factura.addColumn("Cliente");
        factura.addColumn("Producto");
        factura.addColumn("Cantidad");
        factura.addColumn("Precio $");
        factura.addColumn("Monto $");
        factura.addColumn("Fecha");

        /*Ingreso de datos Combobox*/
        try {
            Connection cn = BDConexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_producto FROM `productos`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_productos_ventas.addItem(rs.getString("nombre_producto"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }

        try {
            Connection cn = BDConexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT documento_cliente FROM `clientes`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cmb_clientes_ventas.addItem(rs.getString("documento_cliente"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_historial = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        panelRound55 = new prueba_diseño.PanelRound();
        jScrollPane_registroHistorial = new javax.swing.JScrollPane();
        jTable_registroHistorial = new javax.swing.JTable();
        jLabel86 = new javax.swing.JLabel();
        panel_imprimir_historial = new prueba_diseño.PanelRound();
        panel_buscar_historial = new prueba_diseño.PanelRound();
        panel_generar_reporte = new prueba_diseño.PanelRound();
        btn_generar_reporte = new javax.swing.JLabel();
        panelRound60 = new prueba_diseño.PanelRound();
        historial_historial_icon = new javax.swing.JLabel();
        jPanel_cliente = new javax.swing.JPanel();
        panelRound1 = new prueba_diseño.PanelRound();
        panelRound9 = new prueba_diseño.PanelRound();
        txt_direccion_clientes = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        panelRound15 = new prueba_diseño.PanelRound();
        txt_documento_clientes = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        panelRound16 = new prueba_diseño.PanelRound();
        txt_nombre_clientes = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        panelRound17 = new prueba_diseño.PanelRound();
        txt_tipo_clientes = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        panelRound18 = new prueba_diseño.PanelRound();
        txt_telefono_clientes = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        panelRound2 = new prueba_diseño.PanelRound();
        jLabel45 = new javax.swing.JLabel();
        cmb_tipo_cliente = new javax.swing.JComboBox<>();
        jScrollPane_registroClientesNatural = new javax.swing.JScrollPane();
        jTable_registroClientesNatural = new javax.swing.JTable();
        jScrollPane_registroClientesJuridico = new javax.swing.JScrollPane();
        jTable_registroClientesJuridico = new javax.swing.JTable();
        panelRound14 = new prueba_diseño.PanelRound();
        txt_buscar_cliente = new javax.swing.JTextField();
        panel_buscar_clientes = new prueba_diseño.PanelRound();
        cliente_buscar_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        panel_nuevo = new prueba_diseño.PanelRound();
        btn_nuevo_clientes = new javax.swing.JLabel();
        panel_eliminar_clientes = new prueba_diseño.PanelRound();
        btn_eliminar_clientes = new javax.swing.JLabel();
        panelRound57 = new prueba_diseño.PanelRound();
        cliente_cliente_icon = new javax.swing.JLabel();
        jPanel_factura = new javax.swing.JPanel();
        jLabel_alerta3 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        panelRound30 = new prueba_diseño.PanelRound();
        facturacion_cliente_icon = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        panel_cliente_facturacion = new prueba_diseño.PanelRound();
        btn_cliente_facturacion = new javax.swing.JLabel();
        panelRound39 = new prueba_diseño.PanelRound();
        txt_documentoVentas = new javax.swing.JTextField();
        panelRound40 = new prueba_diseño.PanelRound();
        txt_telefonoVentas = new javax.swing.JTextField();
        panel_producto_facturacion = new prueba_diseño.PanelRound();
        btn_producto_facturacion = new javax.swing.JLabel();
        panelRound42 = new prueba_diseño.PanelRound();
        txt_direccionVentas = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        cmb_clientes_ventas = new javax.swing.JComboBox<>();
        cmb_productos_ventas = new javax.swing.JComboBox<>();
        panelRound31 = new prueba_diseño.PanelRound();
        facturacion_producto_icon = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        panelRound45 = new prueba_diseño.PanelRound();
        txt_descuento_factura = new javax.swing.JTextField();
        panelRound46 = new prueba_diseño.PanelRound();
        txt_nombreProductoVentas = new javax.swing.JTextField();
        panelRound47 = new prueba_diseño.PanelRound();
        txt_precioProductoVentas = new javax.swing.JTextField();
        panelRound49 = new prueba_diseño.PanelRound();
        txt_cantidadProductoVentas = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        panelRound50 = new prueba_diseño.PanelRound();
        txt_codigoProductoVentas = new javax.swing.JTextField();
        panel_cancelar_facturacion = new prueba_diseño.PanelRound();
        btn_cancelar_facturacion = new javax.swing.JLabel();
        panel_Devolucion_facturacion = new prueba_diseño.PanelRound();
        btn_Devolucion_facturacion = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txt_fechaVentas = new javax.swing.JFormattedTextField();
        jLabel81 = new javax.swing.JLabel();
        panelRound32 = new prueba_diseño.PanelRound();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        panel_comprobante_facturacion = new prueba_diseño.PanelRound();
        btn_comprobante_facturacion = new javax.swing.JLabel();
        panelRound34 = new prueba_diseño.PanelRound();
        jTextField1 = new javax.swing.JTextField();
        panelRound35 = new prueba_diseño.PanelRound();
        jTextField3 = new javax.swing.JTextField();
        panelRound36 = new prueba_diseño.PanelRound();
        jTextField2 = new javax.swing.JTextField();
        panelRound37 = new prueba_diseño.PanelRound();
        jTextField4 = new javax.swing.JTextField();
        jScroll_factura = new javax.swing.JScrollPane();
        tabla_factura = new javax.swing.JTable();
        panelRound61 = new prueba_diseño.PanelRound();
        facturacion_venta_icon = new javax.swing.JLabel();
        jPanel_inventario = new javax.swing.JPanel();
        panelRound12 = new prueba_diseño.PanelRound();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane_registroInventario = new javax.swing.JScrollPane();
        jTable_registroInventario = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jLabel_alerta2 = new javax.swing.JLabel();
        panel_buscar_producto = new prueba_diseño.PanelRound();
        txt_buscar_inventario = new javax.swing.JTextField();
        panel_nuevo_inventario = new prueba_diseño.PanelRound();
        btn_nuevo_inventario = new javax.swing.JLabel();
        panel_eliminar_inventario = new prueba_diseño.PanelRound();
        btn_eliminar_inventario = new javax.swing.JLabel();
        panelRound59 = new prueba_diseño.PanelRound();
        inventario_inventario_icon = new javax.swing.JLabel();
        panel_buscar_inventario = new prueba_diseño.PanelRound();
        inventario_buscar_icon = new javax.swing.JLabel();
        panel_actualizar_inventario = new prueba_diseño.PanelRound();
        btn_actualizar_inventario = new javax.swing.JLabel();
        jPanel_empleado = new javax.swing.JPanel();
        panel_actualizar_empleados = new prueba_diseño.PanelRound();
        btn_actualizar_empleados = new javax.swing.JLabel();
        panel_nuevo_empleado = new prueba_diseño.PanelRound();
        btn_nuevo_empleado = new javax.swing.JLabel();
        panel_eliminar_empleados = new prueba_diseño.PanelRound();
        btn_eliminar_empleados = new javax.swing.JLabel();
        panelRound62 = new prueba_diseño.PanelRound();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane_registroEmpleado = new javax.swing.JScrollPane();
        jTable_registroEmpleado = new javax.swing.JTable();
        panelRound63 = new prueba_diseño.PanelRound();
        panelRound64 = new prueba_diseño.PanelRound();
        txt_documento_empleado = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        panelRound65 = new prueba_diseño.PanelRound();
        txt_nombre_empleado = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        panelRound66 = new prueba_diseño.PanelRound();
        txt_apellido_empleado = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        panelRound67 = new prueba_diseño.PanelRound();
        txt_telefono_empleado = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        panelRound68 = new prueba_diseño.PanelRound();
        txt_buscar_empleado = new javax.swing.JTextField();
        jLabel_alerta4 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        panelRound69 = new prueba_diseño.PanelRound();
        empleado_empleado_icon = new javax.swing.JLabel();
        panel_buscar_empleados = new prueba_diseño.PanelRound();
        empleado_buscar_icon = new javax.swing.JLabel();
        jPanel_proveedor = new javax.swing.JPanel();
        panel_nuevo_proveedores = new prueba_diseño.PanelRound();
        btn_nuevo_proveedores = new javax.swing.JLabel();
        panel_eliminar_proveedores = new prueba_diseño.PanelRound();
        btn_eliminar_proveedores = new javax.swing.JLabel();
        panelRound10 = new prueba_diseño.PanelRound();
        jLabel46 = new javax.swing.JLabel();
        cmb_proveedor = new javax.swing.JComboBox<>();
        jScrollPane_registroProveedoresNatural = new javax.swing.JScrollPane();
        jTable_registroProveedoresNatural = new javax.swing.JTable();
        jScrollPane_registroProveedoresJuridico = new javax.swing.JScrollPane();
        jTable_registroProveedoresJuridico = new javax.swing.JTable();
        panelRound23 = new prueba_diseño.PanelRound();
        txt_buscar_proveedor = new javax.swing.JTextField();
        panel_buscar_proveedores = new prueba_diseño.PanelRound();
        proveedor_buscar_icon = new javax.swing.JLabel();
        panelRound11 = new prueba_diseño.PanelRound();
        panelRound19 = new prueba_diseño.PanelRound();
        txt_documento_proveedor = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        panelRound20 = new prueba_diseño.PanelRound();
        txt_nombre_proveedor = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        panelRound21 = new prueba_diseño.PanelRound();
        txt_tipo_proveedor = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        panelRound22 = new prueba_diseño.PanelRound();
        txt_telefono_proveedor = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        panelRound56 = new prueba_diseño.PanelRound();
        txt_direccion_proveedor = new javax.swing.JTextField();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        jLabel_alerta1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        panelRound58 = new prueba_diseño.PanelRound();
        proveedor_proveedor_icon = new javax.swing.JLabel();
        jPanel_inicio = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1_inicioSesion = new javax.swing.JLabel();
        panelRound4 = new prueba_diseño.PanelRound();
        panelRound13 = new prueba_diseño.PanelRound();
        empleado_icon = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_cantidad_empleados = new javax.swing.JTextField();
        panelRound24 = new prueba_diseño.PanelRound();
        proveedor_icon = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_cantidad_proveedores = new javax.swing.JTextField();
        panelRound25 = new prueba_diseño.PanelRound();
        cliente_icon = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txt_cantidad_clientes = new javax.swing.JTextField();
        panelRound26 = new prueba_diseño.PanelRound();
        Ventas_icon = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txt_cantidad_ventas = new javax.swing.JTextField();
        panelRound27 = new prueba_diseño.PanelRound();
        producto_icon = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txt_cantidad_productos = new javax.swing.JTextField();
        jPanel_menu = new javax.swing.JPanel();
        panel_inventario = new prueba_diseño.PanelRound();
        jLabel_inventario = new javax.swing.JLabel();
        icon_inventario = new javax.swing.JLabel();
        panel_inicio = new prueba_diseño.PanelRound();
        jLabel_inicio = new javax.swing.JLabel();
        icon_inicio = new javax.swing.JLabel();
        panel_cliente = new prueba_diseño.PanelRound();
        jLabel_cliente = new javax.swing.JLabel();
        icon_cliente = new javax.swing.JLabel();
        panel_historial = new prueba_diseño.PanelRound();
        jLabel_historial = new javax.swing.JLabel();
        icon_historial = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panel_proveedor = new prueba_diseño.PanelRound();
        jLabel_proveedores = new javax.swing.JLabel();
        icon_proveedor = new javax.swing.JLabel();
        panel_factura = new prueba_diseño.PanelRound();
        jLabel_factura = new javax.swing.JLabel();
        icon_facturacion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panel_salir = new prueba_diseño.PanelRound();
        jLabel_salir = new javax.swing.JLabel();
        icon_salir = new javax.swing.JLabel();
        panel_ayuda = new prueba_diseño.PanelRound();
        jLabel_ayuda = new javax.swing.JLabel();
        icon_ayuda = new javax.swing.JLabel();
        panel_empleado = new prueba_diseño.PanelRound();
        jLabel_empleado = new javax.swing.JLabel();
        icon_empleado = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel_logo = new javax.swing.JLabel();
        panelRound3 = new prueba_diseño.PanelRound();
        icon_user = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_historial.setBackground(new java.awt.Color(230, 230, 230));
        jPanel_historial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("¡Historial de Ventas!");
        jPanel_historial.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        panelRound55.setBackground(new java.awt.Color(255, 255, 255));
        panelRound55.setRoundBottomLeft(50);
        panelRound55.setRoundBottomRight(50);
        panelRound55.setRoundTopLeft(50);
        panelRound55.setRoundTopRight(50);
        panelRound55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_registroHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", " ", "", "", "300$"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Fecha", "Empleado", "Cliente", "Tipo Cliente", "Cantidad", "Monto"
            }
        ));
        jScrollPane_registroHistorial.setViewportView(jTable_registroHistorial);

        panelRound55.add(jScrollPane_registroHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 75, 700, 350));

        jLabel86.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(16, 23, 39));
        jLabel86.setText("Resumen de Ventas");
        panelRound55.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, -1));

        panel_imprimir_historial.setBackground(new java.awt.Color(16, 23, 39));
        panel_imprimir_historial.setRoundBottomLeft(25);
        panel_imprimir_historial.setRoundBottomRight(25);
        panel_imprimir_historial.setRoundTopLeft(25);
        panel_imprimir_historial.setRoundTopRight(25);
        panel_imprimir_historial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound55.add(panel_imprimir_historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 140, -1));

        panel_buscar_historial.setBackground(new java.awt.Color(16, 23, 39));
        panel_buscar_historial.setRoundBottomLeft(25);
        panel_buscar_historial.setRoundBottomRight(25);
        panel_buscar_historial.setRoundTopLeft(25);
        panel_buscar_historial.setRoundTopRight(25);
        panel_buscar_historial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound55.add(panel_buscar_historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, -1));

        panel_generar_reporte.setBackground(new java.awt.Color(16, 23, 39));
        panel_generar_reporte.setRoundBottomLeft(25);
        panel_generar_reporte.setRoundBottomRight(25);
        panel_generar_reporte.setRoundTopLeft(25);
        panel_generar_reporte.setRoundTopRight(25);
        panel_generar_reporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_generar_reporte.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_generar_reporte.setForeground(new java.awt.Color(255, 255, 255));
        btn_generar_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_generar_reporte.setText("Generar Reporte");
        btn_generar_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_generar_reporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_generar_reporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_generar_reporteMouseExited(evt);
            }
        });
        panel_generar_reporte.add(btn_generar_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        panelRound55.add(panel_generar_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 180, -1));

        jPanel_historial.add(panelRound55, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, 750, 450));

        panelRound60.setBackground(new java.awt.Color(19, 19, 66));
        panelRound60.setRoundBottomLeft(25);
        panelRound60.setRoundBottomRight(25);
        panelRound60.setRoundTopLeft(25);
        panelRound60.setRoundTopRight(25);
        panelRound60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        historial_historial_icon.setForeground(new java.awt.Color(0, 0, 0));
        historial_historial_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound60.add(historial_historial_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 64));

        jPanel_historial.add(panelRound60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 64, 64));

        getContentPane().add(jPanel_historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 700));

        jPanel_cliente.setBackground(new java.awt.Color(230, 230, 230));
        jPanel_cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound9.setBackground(new java.awt.Color(204, 204, 204));
        panelRound9.setRoundBottomLeft(25);
        panelRound9.setRoundBottomRight(25);
        panelRound9.setRoundTopLeft(25);
        panelRound9.setRoundTopRight(25);
        panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_direccion_clientes.setEditable(false);
        txt_direccion_clientes.setBackground(new java.awt.Color(204, 204, 204));
        txt_direccion_clientes.setForeground(new java.awt.Color(0, 0, 0));
        txt_direccion_clientes.setBorder(null);
        panelRound9.add(txt_direccion_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        panelRound9.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound1.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 325, 200, 30));

        panelRound15.setBackground(new java.awt.Color(204, 204, 204));
        panelRound15.setRoundBottomLeft(25);
        panelRound15.setRoundBottomRight(25);
        panelRound15.setRoundTopLeft(25);
        panelRound15.setRoundTopRight(25);
        panelRound15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_documento_clientes.setEditable(false);
        txt_documento_clientes.setBackground(new java.awt.Color(204, 204, 204));
        txt_documento_clientes.setForeground(new java.awt.Color(0, 0, 0));
        txt_documento_clientes.setBorder(null);
        txt_documento_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_documento_clientesActionPerformed(evt);
            }
        });
        panelRound15.add(txt_documento_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        panelRound15.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound1.add(panelRound15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 200, 30));

        panelRound16.setBackground(new java.awt.Color(204, 204, 204));
        panelRound16.setRoundBottomLeft(25);
        panelRound16.setRoundBottomRight(25);
        panelRound16.setRoundTopLeft(25);
        panelRound16.setRoundTopRight(25);
        panelRound16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre_clientes.setEditable(false);
        txt_nombre_clientes.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre_clientes.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre_clientes.setBorder(null);
        panelRound16.add(txt_nombre_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        panelRound16.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound1.add(panelRound16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 200, 30));

        panelRound17.setBackground(new java.awt.Color(204, 204, 204));
        panelRound17.setRoundBottomLeft(25);
        panelRound17.setRoundBottomRight(25);
        panelRound17.setRoundTopLeft(25);
        panelRound17.setRoundTopRight(25);
        panelRound17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_tipo_clientes.setEditable(false);
        txt_tipo_clientes.setBackground(new java.awt.Color(204, 204, 204));
        txt_tipo_clientes.setForeground(new java.awt.Color(0, 0, 0));
        txt_tipo_clientes.setBorder(null);
        panelRound17.add(txt_tipo_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        panelRound17.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound1.add(panelRound17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 185, 200, 30));

        panelRound18.setBackground(new java.awt.Color(204, 204, 204));
        panelRound18.setRoundBottomLeft(25);
        panelRound18.setRoundBottomRight(25);
        panelRound18.setRoundTopLeft(25);
        panelRound18.setRoundTopRight(25);
        panelRound18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_telefono_clientes.setEditable(false);
        txt_telefono_clientes.setBackground(new java.awt.Color(204, 204, 204));
        txt_telefono_clientes.setForeground(new java.awt.Color(0, 0, 0));
        txt_telefono_clientes.setBorder(null);
        panelRound18.add(txt_telefono_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        panelRound18.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound1.add(panelRound18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 255, 200, 30));

        jLabel29.setForeground(new java.awt.Color(19, 19, 66));
        jLabel29.setText("Cedula");
        panelRound1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, -1, 15));

        jLabel41.setForeground(new java.awt.Color(19, 19, 66));
        jLabel41.setText("Nombre");
        panelRound1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, -1, -1));

        jLabel42.setForeground(new java.awt.Color(19, 19, 66));
        jLabel42.setText("Tipo Cliente");
        panelRound1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 165, -1, -1));

        jLabel43.setForeground(new java.awt.Color(19, 19, 66));
        jLabel43.setText("Telefono");
        panelRound1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 235, -1, -1));

        jLabel44.setForeground(new java.awt.Color(19, 19, 66));
        jLabel44.setText("Direccion");
        panelRound1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 305, -1, -1));

        jPanel_cliente.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 225, 400));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(25);
        panelRound2.setRoundBottomRight(25);
        panelRound2.setRoundTopLeft(25);
        panelRound2.setRoundTopRight(25);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setBackground(new java.awt.Color(51, 51, 51));
        jLabel45.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("Tipo Cliente");
        panelRound2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cmb_tipo_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "natural", "juridico" }));
        cmb_tipo_cliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_tipo_clienteItemStateChanged(evt);
            }
        });
        cmb_tipo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipo_clienteActionPerformed(evt);
            }
        });
        panelRound2.add(cmb_tipo_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jScrollPane_registroClientesNatural.setBorder(null);
        jScrollPane_registroClientesNatural.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane_registroClientesNaturalMouseClicked(evt);
            }
        });

        jTable_registroClientesNatural.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Documento", "Nombre", "Apellido", "Telefono", "Direccion", "Tipo"
            }
        ));
        jTable_registroClientesNatural.setColumnSelectionAllowed(true);
        jTable_registroClientesNatural.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_registroClientesNaturalMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable_registroClientesNaturalMousePressed(evt);
            }
        });
        jScrollPane_registroClientesNatural.setViewportView(jTable_registroClientesNatural);
        jTable_registroClientesNatural.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelRound2.add(jScrollPane_registroClientesNatural, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 500, 280));

        jScrollPane_registroClientesJuridico.setBorder(null);

        jTable_registroClientesJuridico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Documento", "Nombre", "Apellido", "Telefono", "Direccion", "Tipo"
            }
        ));
        jScrollPane_registroClientesJuridico.setViewportView(jTable_registroClientesJuridico);

        panelRound2.add(jScrollPane_registroClientesJuridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 500, 280));

        panelRound14.setBackground(new java.awt.Color(204, 204, 204));
        panelRound14.setRoundBottomLeft(25);
        panelRound14.setRoundBottomRight(25);
        panelRound14.setRoundTopLeft(25);
        panelRound14.setRoundTopRight(25);
        panelRound14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_buscar_cliente.setBackground(new java.awt.Color(204, 204, 204));
        txt_buscar_cliente.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_buscar_cliente.setForeground(new java.awt.Color(0, 0, 0));
        txt_buscar_cliente.setBorder(null);
        panelRound14.add(txt_buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        panelRound2.add(panelRound14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 35, 200, 30));

        panel_buscar_clientes.setBackground(new java.awt.Color(16, 23, 39));
        panel_buscar_clientes.setRoundBottomLeft(75);
        panel_buscar_clientes.setRoundBottomRight(75);
        panel_buscar_clientes.setRoundTopLeft(75);
        panel_buscar_clientes.setRoundTopRight(75);
        panel_buscar_clientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cliente_buscar_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cliente_buscar_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cliente_buscar_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cliente_buscar_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cliente_buscar_iconMouseExited(evt);
            }
        });
        panel_buscar_clientes.add(cliente_buscar_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        panelRound2.add(panel_buscar_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 40, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(16, 23, 39));
        jLabel1.setText("Ingrese Cedula o Rif");
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 15, -1, -1));

        jPanel_cliente.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 520, 400));

        jLabel32.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(88, 88, 88));
        jLabel32.setText("¡Gestion de Clientes!");
        jPanel_cliente.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        panel_nuevo.setBackground(new java.awt.Color(16, 23, 39));
        panel_nuevo.setRoundBottomLeft(25);
        panel_nuevo.setRoundBottomRight(25);
        panel_nuevo.setRoundTopLeft(25);
        panel_nuevo.setRoundTopRight(25);
        panel_nuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevo_clientes.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_nuevo_clientes.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevo_clientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_nuevo_clientes.setText("Nuevo");
        btn_nuevo_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevo_clientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nuevo_clientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nuevo_clientesMouseExited(evt);
            }
        });
        panel_nuevo.add(btn_nuevo_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_cliente.add(panel_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, 125, 40));

        panel_eliminar_clientes.setBackground(new java.awt.Color(16, 23, 39));
        panel_eliminar_clientes.setRoundBottomLeft(25);
        panel_eliminar_clientes.setRoundBottomRight(25);
        panel_eliminar_clientes.setRoundTopLeft(25);
        panel_eliminar_clientes.setRoundTopRight(25);
        panel_eliminar_clientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_eliminar_clientes.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_eliminar_clientes.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_clientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_eliminar_clientes.setText("Eliminar");
        btn_eliminar_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminar_clientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_eliminar_clientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_eliminar_clientesMouseExited(evt);
            }
        });
        panel_eliminar_clientes.add(btn_eliminar_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_cliente.add(panel_eliminar_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, 125, 40));

        panelRound57.setBackground(new java.awt.Color(81, 77, 167));
        panelRound57.setRoundBottomLeft(25);
        panelRound57.setRoundBottomRight(25);
        panelRound57.setRoundTopLeft(25);
        panelRound57.setRoundTopRight(25);
        panelRound57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cliente_cliente_icon.setForeground(new java.awt.Color(0, 0, 0));
        cliente_cliente_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound57.add(cliente_cliente_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 64));

        jPanel_cliente.add(panelRound57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 64, 64));

        getContentPane().add(jPanel_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 700));

        jPanel_factura.setBackground(new java.awt.Color(230, 230, 230));
        jPanel_factura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_alerta3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel_alerta3.setForeground(new java.awt.Color(0, 106, 183));
        jLabel_alerta3.setText("Mensaje de Alerta para el Usuario de error");
        jPanel_factura.add(jLabel_alerta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 300, -1));

        jLabel55.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(88, 88, 88));
        jLabel55.setText("¡Facturacion de Ventas!");
        jPanel_factura.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        panelRound30.setBackground(new java.awt.Color(255, 255, 255));
        panelRound30.setRoundBottomLeft(25);
        panelRound30.setRoundBottomRight(25);
        panelRound30.setRoundTopLeft(25);
        panelRound30.setRoundTopRight(25);
        panelRound30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        facturacion_cliente_icon.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        facturacion_cliente_icon.setForeground(new java.awt.Color(0, 0, 0));
        facturacion_cliente_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound30.add(facturacion_cliente_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 32, 32));

        jLabel64.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Datos del Cliente");
        panelRound30.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 25, -1, -1));

        panel_cliente_facturacion.setBackground(new java.awt.Color(81, 77, 167));
        panel_cliente_facturacion.setRoundBottomLeft(15);
        panel_cliente_facturacion.setRoundBottomRight(15);
        panel_cliente_facturacion.setRoundTopLeft(15);
        panel_cliente_facturacion.setRoundTopRight(15);
        panel_cliente_facturacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cliente_facturacion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_cliente_facturacion.setForeground(new java.awt.Color(255, 255, 255));
        btn_cliente_facturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_cliente_facturacion.setText("Cliente");
        panel_cliente_facturacion.add(btn_cliente_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panelRound30.add(panel_cliente_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 70, 30));

        panelRound39.setBackground(new java.awt.Color(204, 204, 204));
        panelRound39.setRoundBottomLeft(25);
        panelRound39.setRoundBottomRight(25);
        panelRound39.setRoundTopLeft(25);
        panelRound39.setRoundTopRight(25);
        panelRound39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_documentoVentas.setBackground(new java.awt.Color(204, 204, 204));
        txt_documentoVentas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_documentoVentas.setForeground(new java.awt.Color(0, 0, 0));
        txt_documentoVentas.setBorder(null);
        panelRound39.add(txt_documentoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, -1));

        panelRound30.add(panelRound39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, 30));

        panelRound40.setBackground(new java.awt.Color(204, 204, 204));
        panelRound40.setRoundBottomLeft(25);
        panelRound40.setRoundBottomRight(25);
        panelRound40.setRoundTopLeft(25);
        panelRound40.setRoundTopRight(25);
        panelRound40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_telefonoVentas.setBackground(new java.awt.Color(204, 204, 204));
        txt_telefonoVentas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_telefonoVentas.setForeground(new java.awt.Color(0, 0, 0));
        txt_telefonoVentas.setBorder(null);
        panelRound40.add(txt_telefonoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, -1));

        panelRound30.add(panelRound40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 30));

        panel_producto_facturacion.setBackground(new java.awt.Color(137, 28, 53));
        panel_producto_facturacion.setRoundBottomLeft(15);
        panel_producto_facturacion.setRoundBottomRight(15);
        panel_producto_facturacion.setRoundTopLeft(15);
        panel_producto_facturacion.setRoundTopRight(15);
        panel_producto_facturacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_producto_facturacion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_producto_facturacion.setForeground(new java.awt.Color(255, 255, 255));
        btn_producto_facturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_producto_facturacion.setText("Producto");
        panel_producto_facturacion.add(btn_producto_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panelRound30.add(panel_producto_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 70, 30));

        panelRound42.setBackground(new java.awt.Color(204, 204, 204));
        panelRound42.setRoundBottomLeft(25);
        panelRound42.setRoundBottomRight(25);
        panelRound42.setRoundTopLeft(25);
        panelRound42.setRoundTopRight(25);
        panelRound42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_direccionVentas.setBackground(new java.awt.Color(204, 204, 204));
        txt_direccionVentas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_direccionVentas.setForeground(new java.awt.Color(0, 0, 0));
        txt_direccionVentas.setBorder(null);
        panelRound42.add(txt_direccionVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 310, -1));

        panelRound30.add(panelRound42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 340, 30));

        jLabel76.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        jLabel76.setText("Documento");
        panelRound30.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, -1, -1));

        jLabel79.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setText("Telefono");
        panelRound30.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel80.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setText("Direccion");
        panelRound30.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        cmb_clientes_ventas.setBackground(new java.awt.Color(81, 77, 167));
        cmb_clientes_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_clientes_ventasActionPerformed(evt);
            }
        });
        panelRound30.add(cmb_clientes_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 75, -1));

        cmb_productos_ventas.setBackground(new java.awt.Color(137, 28, 53));
        cmb_productos_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_productos_ventasActionPerformed(evt);
            }
        });
        panelRound30.add(cmb_productos_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 75, -1));

        jPanel_factura.add(panelRound30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 385, 290));

        panelRound31.setBackground(new java.awt.Color(255, 255, 255));
        panelRound31.setRoundBottomLeft(25);
        panelRound31.setRoundBottomRight(25);
        panelRound31.setRoundTopLeft(25);
        panelRound31.setRoundTopRight(25);
        panelRound31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        facturacion_producto_icon.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        facturacion_producto_icon.setForeground(new java.awt.Color(0, 0, 0));
        facturacion_producto_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound31.add(facturacion_producto_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 32, 32));

        jLabel66.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Datos del Producto");
        panelRound31.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, -1, -1));

        panelRound45.setBackground(new java.awt.Color(204, 204, 204));
        panelRound45.setRoundBottomLeft(50);
        panelRound45.setRoundBottomRight(50);
        panelRound45.setRoundTopLeft(50);
        panelRound45.setRoundTopRight(50);
        panelRound45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_descuento_factura.setBackground(new java.awt.Color(204, 204, 204));
        txt_descuento_factura.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_descuento_factura.setForeground(new java.awt.Color(0, 0, 0));
        txt_descuento_factura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_descuento_factura.setText("0");
        txt_descuento_factura.setBorder(null);
        panelRound45.add(txt_descuento_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 5, 30, 20));

        panelRound31.add(panelRound45, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 20, 80, 30));

        panelRound46.setBackground(new java.awt.Color(204, 204, 204));
        panelRound46.setRoundBottomLeft(25);
        panelRound46.setRoundBottomRight(25);
        panelRound46.setRoundTopLeft(25);
        panelRound46.setRoundTopRight(25);
        panelRound46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombreProductoVentas.setEditable(false);
        txt_nombreProductoVentas.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombreProductoVentas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nombreProductoVentas.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombreProductoVentas.setBorder(null);
        panelRound46.add(txt_nombreProductoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, -1));

        panelRound31.add(panelRound46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 30));

        panelRound47.setBackground(new java.awt.Color(204, 204, 204));
        panelRound47.setRoundBottomLeft(25);
        panelRound47.setRoundBottomRight(25);
        panelRound47.setRoundTopLeft(25);
        panelRound47.setRoundTopRight(25);
        panelRound47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_precioProductoVentas.setBackground(new java.awt.Color(204, 204, 204));
        txt_precioProductoVentas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_precioProductoVentas.setForeground(new java.awt.Color(0, 0, 0));
        txt_precioProductoVentas.setBorder(null);
        panelRound47.add(txt_precioProductoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, -1));

        panelRound31.add(panelRound47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 150, 30));

        panelRound49.setBackground(new java.awt.Color(204, 204, 204));
        panelRound49.setRoundBottomLeft(25);
        panelRound49.setRoundBottomRight(25);
        panelRound49.setRoundTopLeft(25);
        panelRound49.setRoundTopRight(25);
        panelRound49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cantidadProductoVentas.setBackground(new java.awt.Color(204, 204, 204));
        txt_cantidadProductoVentas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_cantidadProductoVentas.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidadProductoVentas.setBorder(null);
        panelRound49.add(txt_cantidadProductoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, -1));

        panelRound31.add(panelRound49, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 150, 30));

        jLabel67.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(137, 28, 53));
        jLabel67.setText("Descuento");
        panelRound31.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 25, -1, -1));

        jLabel68.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(137, 28, 53));
        jLabel68.setText("%");
        panelRound31.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        panelRound50.setBackground(new java.awt.Color(204, 204, 204));
        panelRound50.setRoundBottomLeft(25);
        panelRound50.setRoundBottomRight(25);
        panelRound50.setRoundTopLeft(25);
        panelRound50.setRoundTopRight(25);
        panelRound50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_codigoProductoVentas.setEditable(false);
        txt_codigoProductoVentas.setBackground(new java.awt.Color(204, 204, 204));
        txt_codigoProductoVentas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_codigoProductoVentas.setForeground(new java.awt.Color(0, 0, 0));
        txt_codigoProductoVentas.setBorder(null);
        panelRound50.add(txt_codigoProductoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 130, -1));

        panelRound31.add(panelRound50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 30));

        panel_cancelar_facturacion.setBackground(new java.awt.Color(16, 23, 39));
        panel_cancelar_facturacion.setForeground(new java.awt.Color(255, 255, 255));
        panel_cancelar_facturacion.setRoundBottomLeft(15);
        panel_cancelar_facturacion.setRoundBottomRight(15);
        panel_cancelar_facturacion.setRoundTopLeft(15);
        panel_cancelar_facturacion.setRoundTopRight(15);
        panel_cancelar_facturacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cancelar_facturacion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_cancelar_facturacion.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar_facturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_cancelar_facturacion.setText("Cancelar");
        btn_cancelar_facturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelar_facturacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelar_facturacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelar_facturacionMouseExited(evt);
            }
        });
        panel_cancelar_facturacion.add(btn_cancelar_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panelRound31.add(panel_cancelar_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 70, 30));

        panel_Devolucion_facturacion.setBackground(new java.awt.Color(16, 23, 39));
        panel_Devolucion_facturacion.setForeground(new java.awt.Color(255, 255, 255));
        panel_Devolucion_facturacion.setRoundBottomLeft(15);
        panel_Devolucion_facturacion.setRoundBottomRight(15);
        panel_Devolucion_facturacion.setRoundTopLeft(15);
        panel_Devolucion_facturacion.setRoundTopRight(15);
        panel_Devolucion_facturacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Devolucion_facturacion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_Devolucion_facturacion.setForeground(new java.awt.Color(255, 255, 255));
        btn_Devolucion_facturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Devolucion_facturacion.setText("Devolucion");
        btn_Devolucion_facturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Devolucion_facturacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_Devolucion_facturacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_Devolucion_facturacionMouseExited(evt);
            }
        });
        panel_Devolucion_facturacion.add(btn_Devolucion_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        panelRound31.add(panel_Devolucion_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 70, 30));

        jLabel71.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        jLabel71.setText("Codigo");
        panelRound31.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel72.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jLabel72.setText("Nombre");
        panelRound31.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel73.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 0, 0));
        jLabel73.setText("Precio $");
        panelRound31.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel75.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setText("Cantidad");
        panelRound31.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 140, -1, -1));

        txt_fechaVentas.setBackground(new java.awt.Color(204, 204, 204));
        txt_fechaVentas.setForeground(new java.awt.Color(0, 0, 0));
        panelRound31.add(txt_fechaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 150, 30));

        jLabel81.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 0, 0));
        jLabel81.setText("Fecha");
        panelRound31.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jPanel_factura.add(panelRound31, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 100, 385, 290));

        panelRound32.setBackground(new java.awt.Color(255, 255, 255));
        panelRound32.setRoundBottomLeft(25);
        panelRound32.setRoundBottomRight(25);
        panelRound32.setRoundTopLeft(25);
        panelRound32.setRoundTopRight(25);
        panelRound32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Sub Total:");
        panelRound32.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("IVA 16%:");
        panelRound32.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Descuento:");
        panelRound32.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel57.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Total a Pagar:");
        panelRound32.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        panel_comprobante_facturacion.setBackground(new java.awt.Color(16, 23, 39));
        panel_comprobante_facturacion.setForeground(new java.awt.Color(255, 255, 255));
        panel_comprobante_facturacion.setRoundBottomLeft(25);
        panel_comprobante_facturacion.setRoundBottomRight(25);
        panel_comprobante_facturacion.setRoundTopLeft(25);
        panel_comprobante_facturacion.setRoundTopRight(25);
        panel_comprobante_facturacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_comprobante_facturacion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_comprobante_facturacion.setForeground(new java.awt.Color(255, 255, 255));
        btn_comprobante_facturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_comprobante_facturacion.setText("Confirmar");
        btn_comprobante_facturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_comprobante_facturacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_comprobante_facturacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_comprobante_facturacionMouseExited(evt);
            }
        });
        panel_comprobante_facturacion.add(btn_comprobante_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 35));

        panelRound32.add(panel_comprobante_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 200, 120, 35));

        panelRound34.setBackground(new java.awt.Color(204, 204, 204));
        panelRound34.setRoundBottomLeft(25);
        panelRound34.setRoundBottomRight(25);
        panelRound34.setRoundTopLeft(25);
        panelRound34.setRoundTopRight(25);
        panelRound34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0.00");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        panelRound34.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 25));

        panelRound32.add(panelRound34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 25, 100, 25));

        panelRound35.setBackground(new java.awt.Color(204, 204, 204));
        panelRound35.setRoundBottomLeft(25);
        panelRound35.setRoundBottomRight(25);
        panelRound35.setRoundTopLeft(25);
        panelRound35.setRoundTopRight(25);
        panelRound35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0.00");
        jTextField3.setBorder(null);
        panelRound35.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 25));

        panelRound32.add(panelRound35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 105, 100, 25));

        panelRound36.setBackground(new java.awt.Color(204, 204, 204));
        panelRound36.setRoundBottomLeft(25);
        panelRound36.setRoundBottomRight(25);
        panelRound36.setRoundTopLeft(25);
        panelRound36.setRoundTopRight(25);
        panelRound36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0.00");
        jTextField2.setBorder(null);
        panelRound36.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 25));

        panelRound32.add(panelRound36, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 65, 100, 25));

        panelRound37.setBackground(new java.awt.Color(204, 204, 204));
        panelRound37.setRoundBottomLeft(25);
        panelRound37.setRoundBottomRight(25);
        panelRound37.setRoundTopLeft(25);
        panelRound37.setRoundTopRight(25);
        panelRound37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField4.setBackground(new java.awt.Color(204, 204, 204));
        jTextField4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("0.00");
        jTextField4.setBorder(null);
        panelRound37.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 25));

        panelRound32.add(panelRound37, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 145, 100, 25));

        jPanel_factura.add(panelRound32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 210, 250));

        tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScroll_factura.setViewportView(tabla_factura);

        jPanel_factura.add(jScroll_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 560, 250));

        panelRound61.setBackground(new java.awt.Color(29, 42, 71));
        panelRound61.setRoundBottomLeft(25);
        panelRound61.setRoundBottomRight(25);
        panelRound61.setRoundTopLeft(25);
        panelRound61.setRoundTopRight(25);
        panelRound61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        facturacion_venta_icon.setForeground(new java.awt.Color(0, 0, 0));
        facturacion_venta_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound61.add(facturacion_venta_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 64));

        jPanel_factura.add(panelRound61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 64, 64));

        getContentPane().add(jPanel_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 700));

        jPanel_inventario.setBackground(new java.awt.Color(230, 230, 230));
        jPanel_inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound12.setBackground(new java.awt.Color(255, 255, 255));
        panelRound12.setRoundBottomLeft(25);
        panelRound12.setRoundBottomRight(25);
        panelRound12.setRoundTopLeft(25);
        panelRound12.setRoundTopRight(25);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(51, 51, 51));
        jLabel50.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(16, 23, 39));
        jLabel50.setText("Almacen");
        panelRound12.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, -1));

        jScrollPane_registroInventario.setBorder(null);

        jTable_registroInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", null, "", "", "", ""},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Codigo", "Nombre", "Descripcion", "Stock", "Fecha Registro", "Almacen", "Proveedor"
            }
        ));
        jScrollPane_registroInventario.setViewportView(jTable_registroInventario);

        panelRound12.add(jScrollPane_registroInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 700, 280));

        jPanel_inventario.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 740, 400));

        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(88, 88, 88));
        jLabel39.setText("¡Registre Producto!");
        jPanel_inventario.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel_alerta2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel_alerta2.setForeground(new java.awt.Color(0, 106, 183));
        jLabel_alerta2.setText("Mensaje de Alerta para el Usuario de error");
        jPanel_inventario.add(jLabel_alerta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 95, 300, -1));

        panel_buscar_producto.setBackground(new java.awt.Color(204, 204, 204));
        panel_buscar_producto.setRoundBottomLeft(25);
        panel_buscar_producto.setRoundBottomRight(25);
        panel_buscar_producto.setRoundTopLeft(25);
        panel_buscar_producto.setRoundTopRight(25);
        panel_buscar_producto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_buscar_inventario.setBackground(new java.awt.Color(204, 204, 204));
        txt_buscar_inventario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_buscar_inventario.setForeground(new java.awt.Color(19, 19, 66));
        txt_buscar_inventario.setBorder(null);
        txt_buscar_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_buscar_inventarioMouseClicked(evt);
            }
        });
        panel_buscar_producto.add(txt_buscar_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jPanel_inventario.add(panel_buscar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 200, 30));

        panel_nuevo_inventario.setBackground(new java.awt.Color(16, 23, 39));
        panel_nuevo_inventario.setRoundBottomLeft(25);
        panel_nuevo_inventario.setRoundBottomRight(25);
        panel_nuevo_inventario.setRoundTopLeft(25);
        panel_nuevo_inventario.setRoundTopRight(25);
        panel_nuevo_inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevo_inventario.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_nuevo_inventario.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevo_inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_nuevo_inventario.setText("Nuevo");
        btn_nuevo_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevo_inventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nuevo_inventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nuevo_inventarioMouseExited(evt);
            }
        });
        panel_nuevo_inventario.add(btn_nuevo_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_inventario.add(panel_nuevo_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 125, 40));

        panel_eliminar_inventario.setBackground(new java.awt.Color(16, 23, 39));
        panel_eliminar_inventario.setRoundBottomLeft(25);
        panel_eliminar_inventario.setRoundBottomRight(25);
        panel_eliminar_inventario.setRoundTopLeft(25);
        panel_eliminar_inventario.setRoundTopRight(25);
        panel_eliminar_inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_eliminar_inventario.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_eliminar_inventario.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_eliminar_inventario.setText("Eliminar");
        btn_eliminar_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminar_inventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_eliminar_inventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_eliminar_inventarioMouseExited(evt);
            }
        });
        panel_eliminar_inventario.add(btn_eliminar_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_inventario.add(panel_eliminar_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 125, 40));

        panelRound59.setBackground(new java.awt.Color(24, 105, 62));
        panelRound59.setRoundBottomLeft(25);
        panelRound59.setRoundBottomRight(25);
        panelRound59.setRoundTopLeft(25);
        panelRound59.setRoundTopRight(25);
        panelRound59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inventario_inventario_icon.setForeground(new java.awt.Color(0, 0, 0));
        inventario_inventario_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound59.add(inventario_inventario_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 64));

        jPanel_inventario.add(panelRound59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 64, 64));

        panel_buscar_inventario.setBackground(new java.awt.Color(16, 23, 39));
        panel_buscar_inventario.setRoundBottomLeft(75);
        panel_buscar_inventario.setRoundBottomRight(75);
        panel_buscar_inventario.setRoundTopLeft(75);
        panel_buscar_inventario.setRoundTopRight(75);
        panel_buscar_inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inventario_buscar_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventario_buscar_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventario_buscar_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventario_buscar_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventario_buscar_iconMouseExited(evt);
            }
        });
        panel_buscar_inventario.add(inventario_buscar_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 32, 32));

        jPanel_inventario.add(panel_buscar_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 95, 40, 40));

        panel_actualizar_inventario.setBackground(new java.awt.Color(16, 23, 39));
        panel_actualizar_inventario.setRoundBottomLeft(25);
        panel_actualizar_inventario.setRoundBottomRight(25);
        panel_actualizar_inventario.setRoundTopLeft(25);
        panel_actualizar_inventario.setRoundTopRight(25);
        panel_actualizar_inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_actualizar_inventario.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_actualizar_inventario.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar_inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_actualizar_inventario.setText("Actualizar");
        btn_actualizar_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_actualizar_inventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizar_inventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizar_inventarioMouseExited(evt);
            }
        });
        panel_actualizar_inventario.add(btn_actualizar_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 130, 40));

        jPanel_inventario.add(panel_actualizar_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 580, 125, 40));

        getContentPane().add(jPanel_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 700));

        jPanel_empleado.setBackground(new java.awt.Color(230, 230, 230));
        jPanel_empleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_actualizar_empleados.setBackground(new java.awt.Color(16, 23, 39));
        panel_actualizar_empleados.setRoundBottomLeft(25);
        panel_actualizar_empleados.setRoundBottomRight(25);
        panel_actualizar_empleados.setRoundTopLeft(25);
        panel_actualizar_empleados.setRoundTopRight(25);
        panel_actualizar_empleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_actualizar_empleados.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_actualizar_empleados.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar_empleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_actualizar_empleados.setText("Actualizar");
        btn_actualizar_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_actualizar_empleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizar_empleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizar_empleadosMouseExited(evt);
            }
        });
        panel_actualizar_empleados.add(btn_actualizar_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_empleado.add(panel_actualizar_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 580, 125, 40));

        panel_nuevo_empleado.setBackground(new java.awt.Color(16, 23, 39));
        panel_nuevo_empleado.setRoundBottomLeft(25);
        panel_nuevo_empleado.setRoundBottomRight(25);
        panel_nuevo_empleado.setRoundTopLeft(25);
        panel_nuevo_empleado.setRoundTopRight(25);
        panel_nuevo_empleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevo_empleado.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_nuevo_empleado.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevo_empleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_nuevo_empleado.setText("Nuevo");
        btn_nuevo_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevo_empleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nuevo_empleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nuevo_empleadoMouseExited(evt);
            }
        });
        panel_nuevo_empleado.add(btn_nuevo_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_empleado.add(panel_nuevo_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 580, 125, 40));

        panel_eliminar_empleados.setBackground(new java.awt.Color(16, 23, 39));
        panel_eliminar_empleados.setRoundBottomLeft(25);
        panel_eliminar_empleados.setRoundBottomRight(25);
        panel_eliminar_empleados.setRoundTopLeft(25);
        panel_eliminar_empleados.setRoundTopRight(25);
        panel_eliminar_empleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_eliminar_empleados.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_eliminar_empleados.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_empleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_eliminar_empleados.setText("Eliminar");
        btn_eliminar_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminar_empleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_eliminar_empleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_eliminar_empleadosMouseExited(evt);
            }
        });
        panel_eliminar_empleados.add(btn_eliminar_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_empleado.add(panel_eliminar_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 580, 125, 40));

        panelRound62.setBackground(new java.awt.Color(255, 255, 255));
        panelRound62.setRoundBottomLeft(25);
        panelRound62.setRoundBottomRight(25);
        panelRound62.setRoundTopLeft(25);
        panelRound62.setRoundTopRight(25);
        panelRound62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setBackground(new java.awt.Color(16, 23, 39));
        jLabel56.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(16, 23, 39));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Registro Empleados");
        panelRound62.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 200, -1));

        jScrollPane_registroEmpleado.setBorder(null);

        jTable_registroEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", "", " "},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Documento", "Nombre", "Apellido", "Telefono", "Direccion"
            }
        ));
        jScrollPane_registroEmpleado.setViewportView(jTable_registroEmpleado);

        panelRound62.add(jScrollPane_registroEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 500, 280));

        jPanel_empleado.add(panelRound62, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 520, 400));

        panelRound63.setBackground(new java.awt.Color(255, 255, 255));
        panelRound63.setRoundBottomLeft(25);
        panelRound63.setRoundBottomRight(25);
        panelRound63.setRoundTopLeft(25);
        panelRound63.setRoundTopRight(25);
        panelRound63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound64.setBackground(new java.awt.Color(204, 204, 204));
        panelRound64.setRoundBottomLeft(25);
        panelRound64.setRoundBottomRight(25);
        panelRound64.setRoundTopLeft(25);
        panelRound64.setRoundTopRight(25);
        panelRound64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_documento_empleado.setEditable(false);
        txt_documento_empleado.setBackground(new java.awt.Color(204, 204, 204));
        txt_documento_empleado.setForeground(new java.awt.Color(0, 0, 0));
        txt_documento_empleado.setBorder(null);
        txt_documento_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_documento_empleadoActionPerformed(evt);
            }
        });
        panelRound64.add(txt_documento_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator18.setForeground(new java.awt.Color(0, 0, 0));
        panelRound64.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound63.add(panelRound64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 200, 30));

        panelRound65.setBackground(new java.awt.Color(204, 204, 204));
        panelRound65.setRoundBottomLeft(25);
        panelRound65.setRoundBottomRight(25);
        panelRound65.setRoundTopLeft(25);
        panelRound65.setRoundTopRight(25);
        panelRound65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre_empleado.setEditable(false);
        txt_nombre_empleado.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre_empleado.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre_empleado.setBorder(null);
        panelRound65.add(txt_nombre_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator19.setForeground(new java.awt.Color(0, 0, 0));
        panelRound65.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound63.add(panelRound65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 200, 30));

        panelRound66.setBackground(new java.awt.Color(204, 204, 204));
        panelRound66.setRoundBottomLeft(25);
        panelRound66.setRoundBottomRight(25);
        panelRound66.setRoundTopLeft(25);
        panelRound66.setRoundTopRight(25);
        panelRound66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_apellido_empleado.setEditable(false);
        txt_apellido_empleado.setBackground(new java.awt.Color(204, 204, 204));
        txt_apellido_empleado.setForeground(new java.awt.Color(0, 0, 0));
        txt_apellido_empleado.setBorder(null);
        panelRound66.add(txt_apellido_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator20.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator20.setForeground(new java.awt.Color(0, 0, 0));
        panelRound66.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound63.add(panelRound66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 224, 200, 30));

        panelRound67.setBackground(new java.awt.Color(204, 204, 204));
        panelRound67.setRoundBottomLeft(25);
        panelRound67.setRoundBottomRight(25);
        panelRound67.setRoundTopLeft(25);
        panelRound67.setRoundTopRight(25);
        panelRound67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_telefono_empleado.setEditable(false);
        txt_telefono_empleado.setBackground(new java.awt.Color(204, 204, 204));
        txt_telefono_empleado.setForeground(new java.awt.Color(0, 0, 0));
        txt_telefono_empleado.setBorder(null);
        panelRound67.add(txt_telefono_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator21.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator21.setForeground(new java.awt.Color(0, 0, 0));
        panelRound67.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound63.add(panelRound67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 292, 200, 30));

        jLabel40.setForeground(new java.awt.Color(19, 19, 66));
        jLabel40.setText("Documento");
        panelRound63.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 68, -1, 15));

        jLabel58.setForeground(new java.awt.Color(19, 19, 66));
        jLabel58.setText("Nombre");
        panelRound63.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 136, -1, 15));

        jLabel88.setForeground(new java.awt.Color(19, 19, 66));
        jLabel88.setText("Apellido");
        panelRound63.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 204, -1, 15));

        jLabel89.setForeground(new java.awt.Color(19, 19, 66));
        jLabel89.setText("Telefono");
        panelRound63.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 272, -1, 15));

        jLabel52.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(19, 19, 66));
        jLabel52.setText("Resumen Empleado");
        panelRound63.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel_empleado.add(panelRound63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 225, 400));

        panelRound68.setBackground(new java.awt.Color(204, 204, 204));
        panelRound68.setRoundBottomLeft(25);
        panelRound68.setRoundBottomRight(25);
        panelRound68.setRoundTopLeft(25);
        panelRound68.setRoundTopRight(25);
        panelRound68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_buscar_empleado.setBackground(new java.awt.Color(204, 204, 204));
        txt_buscar_empleado.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_buscar_empleado.setForeground(new java.awt.Color(19, 19, 66));
        txt_buscar_empleado.setBorder(null);
        panelRound68.add(txt_buscar_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jPanel_empleado.add(panelRound68, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 200, 30));

        jLabel_alerta4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel_alerta4.setForeground(new java.awt.Color(0, 106, 183));
        jLabel_alerta4.setText("Mensaje de Alerta para el Usuario de error");
        jPanel_empleado.add(jLabel_alerta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 300, -1));

        jLabel36.setBackground(new java.awt.Color(88, 88, 88));
        jLabel36.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(88, 88, 88));
        jLabel36.setText("¡Registro Empleados!");
        jPanel_empleado.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        panelRound69.setBackground(new java.awt.Color(19, 19, 66));
        panelRound69.setRoundBottomLeft(25);
        panelRound69.setRoundBottomRight(25);
        panelRound69.setRoundTopLeft(25);
        panelRound69.setRoundTopRight(25);
        panelRound69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empleado_empleado_icon.setForeground(new java.awt.Color(0, 0, 0));
        empleado_empleado_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound69.add(empleado_empleado_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 64));

        jPanel_empleado.add(panelRound69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 64, 64));

        panel_buscar_empleados.setBackground(new java.awt.Color(16, 23, 39));
        panel_buscar_empleados.setRoundBottomLeft(75);
        panel_buscar_empleados.setRoundBottomRight(75);
        panel_buscar_empleados.setRoundTopLeft(75);
        panel_buscar_empleados.setRoundTopRight(75);
        panel_buscar_empleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empleado_buscar_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empleado_buscar_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empleado_buscar_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                empleado_buscar_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                empleado_buscar_iconMouseExited(evt);
            }
        });
        panel_buscar_empleados.add(empleado_buscar_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 32, 32));

        jPanel_empleado.add(panel_buscar_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 95, 40, 40));

        getContentPane().add(jPanel_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 700));

        jPanel_proveedor.setBackground(new java.awt.Color(230, 230, 230));
        jPanel_proveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_nuevo_proveedores.setBackground(new java.awt.Color(16, 23, 39));
        panel_nuevo_proveedores.setRoundBottomLeft(25);
        panel_nuevo_proveedores.setRoundBottomRight(25);
        panel_nuevo_proveedores.setRoundTopLeft(25);
        panel_nuevo_proveedores.setRoundTopRight(25);
        panel_nuevo_proveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevo_proveedores.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_nuevo_proveedores.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevo_proveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_nuevo_proveedores.setText("Nuevo");
        btn_nuevo_proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevo_proveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nuevo_proveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nuevo_proveedoresMouseExited(evt);
            }
        });
        panel_nuevo_proveedores.add(btn_nuevo_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_proveedor.add(panel_nuevo_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, 125, 40));

        panel_eliminar_proveedores.setBackground(new java.awt.Color(16, 23, 39));
        panel_eliminar_proveedores.setRoundBottomLeft(25);
        panel_eliminar_proveedores.setRoundBottomRight(25);
        panel_eliminar_proveedores.setRoundTopLeft(25);
        panel_eliminar_proveedores.setRoundTopRight(25);
        panel_eliminar_proveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_eliminar_proveedores.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_eliminar_proveedores.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_proveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_eliminar_proveedores.setText("Eliminar");
        btn_eliminar_proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminar_proveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_eliminar_proveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_eliminar_proveedoresMouseExited(evt);
            }
        });
        panel_eliminar_proveedores.add(btn_eliminar_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 40));

        jPanel_proveedor.add(panel_eliminar_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, 125, 40));

        panelRound10.setBackground(new java.awt.Color(255, 255, 255));
        panelRound10.setRoundBottomLeft(25);
        panelRound10.setRoundBottomRight(25);
        panelRound10.setRoundTopLeft(25);
        panelRound10.setRoundTopRight(25);
        panelRound10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setBackground(new java.awt.Color(51, 51, 51));
        jLabel46.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setText("Tipo Proveedor");
        panelRound10.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cmb_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Natural", "Juridico" }));
        cmb_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_proveedorActionPerformed(evt);
            }
        });
        panelRound10.add(cmb_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jScrollPane_registroProveedoresNatural.setBorder(null);

        jTable_registroProveedoresNatural.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", null, "", "", ""},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Cedula", "Nombre", "Apellido", "Direccion", "Telefono", "Correo", "Tipo"
            }
        ));
        jScrollPane_registroProveedoresNatural.setViewportView(jTable_registroProveedoresNatural);

        panelRound10.add(jScrollPane_registroProveedoresNatural, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 500, 280));

        jScrollPane_registroProveedoresJuridico.setBorder(null);

        jTable_registroProveedoresJuridico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "26554123", "Carlos", "Paez", "0412563214", "Calle 23 con 24", "Activo"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Rif", "Nombre Empresa", "Direccion", "Telefono", "Correo", "Tipo"
            }
        ));
        jScrollPane_registroProveedoresJuridico.setViewportView(jTable_registroProveedoresJuridico);

        panelRound10.add(jScrollPane_registroProveedoresJuridico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 500, 280));

        panelRound23.setBackground(new java.awt.Color(204, 204, 204));
        panelRound23.setRoundBottomLeft(25);
        panelRound23.setRoundBottomRight(25);
        panelRound23.setRoundTopLeft(25);
        panelRound23.setRoundTopRight(25);
        panelRound23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_buscar_proveedor.setBackground(new java.awt.Color(204, 204, 204));
        txt_buscar_proveedor.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_buscar_proveedor.setForeground(new java.awt.Color(19, 19, 66));
        txt_buscar_proveedor.setBorder(null);
        txt_buscar_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscar_proveedorActionPerformed(evt);
            }
        });
        panelRound23.add(txt_buscar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        panelRound10.add(panelRound23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 35, 200, 30));

        panel_buscar_proveedores.setBackground(new java.awt.Color(16, 23, 39));
        panel_buscar_proveedores.setRoundBottomLeft(75);
        panel_buscar_proveedores.setRoundBottomRight(75);
        panel_buscar_proveedores.setRoundTopLeft(75);
        panel_buscar_proveedores.setRoundTopRight(75);
        panel_buscar_proveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        proveedor_buscar_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proveedor_buscar_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proveedor_buscar_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                proveedor_buscar_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                proveedor_buscar_iconMouseExited(evt);
            }
        });
        panel_buscar_proveedores.add(proveedor_buscar_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        panelRound10.add(panel_buscar_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 40, 40));

        jPanel_proveedor.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 520, 400));

        panelRound11.setBackground(new java.awt.Color(255, 255, 255));
        panelRound11.setRoundBottomLeft(25);
        panelRound11.setRoundBottomRight(25);
        panelRound11.setRoundTopLeft(25);
        panelRound11.setRoundTopRight(25);
        panelRound11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound19.setBackground(new java.awt.Color(204, 204, 204));
        panelRound19.setRoundBottomLeft(25);
        panelRound19.setRoundBottomRight(25);
        panelRound19.setRoundTopLeft(25);
        panelRound19.setRoundTopRight(25);
        panelRound19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_documento_proveedor.setEditable(false);
        txt_documento_proveedor.setBackground(new java.awt.Color(204, 204, 204));
        txt_documento_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        txt_documento_proveedor.setBorder(null);
        panelRound19.add(txt_documento_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        panelRound19.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound11.add(panelRound19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 200, 30));

        panelRound20.setBackground(new java.awt.Color(204, 204, 204));
        panelRound20.setRoundBottomLeft(25);
        panelRound20.setRoundBottomRight(25);
        panelRound20.setRoundTopLeft(25);
        panelRound20.setRoundTopRight(25);
        panelRound20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre_proveedor.setEditable(false);
        txt_nombre_proveedor.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre_proveedor.setBorder(null);
        panelRound20.add(txt_nombre_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        panelRound20.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound11.add(panelRound20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 200, 30));

        panelRound21.setBackground(new java.awt.Color(204, 204, 204));
        panelRound21.setRoundBottomLeft(25);
        panelRound21.setRoundBottomRight(25);
        panelRound21.setRoundTopLeft(25);
        panelRound21.setRoundTopRight(25);
        panelRound21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_tipo_proveedor.setEditable(false);
        txt_tipo_proveedor.setBackground(new java.awt.Color(204, 204, 204));
        txt_tipo_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        txt_tipo_proveedor.setBorder(null);
        panelRound21.add(txt_tipo_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        panelRound21.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound11.add(panelRound21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 224, 200, 30));

        panelRound22.setBackground(new java.awt.Color(204, 204, 204));
        panelRound22.setRoundBottomLeft(25);
        panelRound22.setRoundBottomRight(25);
        panelRound22.setRoundTopLeft(25);
        panelRound22.setRoundTopRight(25);
        panelRound22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_telefono_proveedor.setEditable(false);
        txt_telefono_proveedor.setBackground(new java.awt.Color(204, 204, 204));
        txt_telefono_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        txt_telefono_proveedor.setBorder(null);
        panelRound22.add(txt_telefono_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        panelRound22.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound11.add(panelRound22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 292, 200, 30));

        jLabel37.setForeground(new java.awt.Color(19, 19, 66));
        jLabel37.setText("Documento");
        panelRound11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 68, -1, 15));

        jLabel47.setForeground(new java.awt.Color(19, 19, 66));
        jLabel47.setText("Nombre");
        panelRound11.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 136, -1, 15));

        jLabel48.setForeground(new java.awt.Color(19, 19, 66));
        jLabel48.setText("Tipo Proveedor");
        panelRound11.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 204, -1, 15));

        jLabel49.setForeground(new java.awt.Color(19, 19, 66));
        jLabel49.setText("Telefono");
        panelRound11.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 272, -1, 15));

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(19, 19, 66));
        jLabel28.setText("Resumen Proveedor");
        panelRound11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        panelRound56.setBackground(new java.awt.Color(204, 204, 204));
        panelRound56.setRoundBottomLeft(25);
        panelRound56.setRoundBottomRight(25);
        panelRound56.setRoundTopLeft(25);
        panelRound56.setRoundTopRight(25);
        panelRound56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_direccion_proveedor.setEditable(false);
        txt_direccion_proveedor.setBackground(new java.awt.Color(204, 204, 204));
        txt_direccion_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        txt_direccion_proveedor.setBorder(null);
        txt_direccion_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccion_proveedorActionPerformed(evt);
            }
        });
        panelRound56.add(txt_direccion_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 170, 20));

        jSeparator22.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator22.setForeground(new java.awt.Color(0, 0, 0));
        panelRound56.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 28, 170, -1));

        panelRound11.add(panelRound56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 200, 30));

        jLabel60.setForeground(new java.awt.Color(19, 19, 66));
        jLabel60.setText("Direccion");
        panelRound11.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 15));

        jPanel_proveedor.add(panelRound11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 225, 400));

        jLabel_alerta1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel_alerta1.setForeground(new java.awt.Color(0, 106, 183));
        jLabel_alerta1.setText("Mensaje de Alerta para el Usuario de error");
        jPanel_proveedor.add(jLabel_alerta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 300, -1));

        jLabel34.setBackground(new java.awt.Color(88, 88, 88));
        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(88, 88, 88));
        jLabel34.setText("¡Registre los Proveedores!");
        jPanel_proveedor.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        panelRound58.setBackground(new java.awt.Color(137, 28, 53));
        panelRound58.setRoundBottomLeft(25);
        panelRound58.setRoundBottomRight(25);
        panelRound58.setRoundTopLeft(25);
        panelRound58.setRoundTopRight(25);
        panelRound58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        proveedor_proveedor_icon.setForeground(new java.awt.Color(0, 0, 0));
        proveedor_proveedor_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound58.add(proveedor_proveedor_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 64));

        jPanel_proveedor.add(panelRound58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 64, 64));

        getContentPane().add(jPanel_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 700));

        jPanel_inicio.setBackground(new java.awt.Color(230, 230, 230));
        jPanel_inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(81, 77, 167));
        jLabel15.setText("Inicio - Contador de Registros");
        jPanel_inicio.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel1_inicioSesion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1_inicioSesion.setForeground(new java.awt.Color(16, 23, 39));
        jPanel_inicio.add(jLabel1_inicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 75, 220, -1));

        panelRound4.setBackground(new java.awt.Color(250, 250, 250));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound13.setBackground(new java.awt.Color(16, 23, 39));
        panelRound13.setRoundBottomLeft(50);
        panelRound13.setRoundBottomRight(50);
        panelRound13.setRoundTopLeft(50);
        panelRound13.setRoundTopRight(50);
        panelRound13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empleado_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound13.add(empleado_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 40, 40));

        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(81, 77, 167));
        jLabel30.setText("Empleados");
        panelRound13.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(81, 77, 167));
        jLabel31.setText("Total Registrados");
        panelRound13.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        txt_cantidad_empleados.setEditable(false);
        txt_cantidad_empleados.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad_empleados.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txt_cantidad_empleados.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidad_empleados.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidad_empleadosActionPerformed(evt);
            }
        });
        panelRound13.add(txt_cantidad_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, 100));

        panelRound4.add(panelRound13, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 30, 230, 250));

        panelRound24.setBackground(new java.awt.Color(16, 23, 39));
        panelRound24.setRoundBottomLeft(50);
        panelRound24.setRoundBottomRight(50);
        panelRound24.setRoundTopLeft(50);
        panelRound24.setRoundTopRight(50);
        panelRound24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        proveedor_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound24.add(proveedor_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 40, 40));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(81, 77, 167));
        jLabel19.setText("Proveedores");
        panelRound24.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(81, 77, 167));
        jLabel33.setText("Total Registrados");
        panelRound24.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        txt_cantidad_proveedores.setEditable(false);
        txt_cantidad_proveedores.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad_proveedores.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txt_cantidad_proveedores.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidad_proveedores.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad_proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidad_proveedoresActionPerformed(evt);
            }
        });
        panelRound24.add(txt_cantidad_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, 100));

        panelRound4.add(panelRound24, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 30, 230, 250));

        panelRound25.setBackground(new java.awt.Color(16, 23, 39));
        panelRound25.setRoundBottomLeft(50);
        panelRound25.setRoundBottomRight(50);
        panelRound25.setRoundTopLeft(50);
        panelRound25.setRoundTopRight(50);
        panelRound25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cliente_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound25.add(cliente_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 40, 40));

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(81, 77, 167));
        jLabel35.setText("Clientes");
        panelRound25.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel53.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(81, 77, 167));
        jLabel53.setText("Total Registrados");
        panelRound25.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        txt_cantidad_clientes.setEditable(false);
        txt_cantidad_clientes.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad_clientes.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txt_cantidad_clientes.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidad_clientes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidad_clientesActionPerformed(evt);
            }
        });
        panelRound25.add(txt_cantidad_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, 100));

        panelRound4.add(panelRound25, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 30, 230, 250));

        panelRound26.setBackground(new java.awt.Color(16, 23, 39));
        panelRound26.setRoundBottomLeft(50);
        panelRound26.setRoundBottomRight(50);
        panelRound26.setRoundTopLeft(50);
        panelRound26.setRoundTopRight(50);
        panelRound26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ventas_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound26.add(Ventas_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 40, 40));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(81, 77, 167));
        jLabel20.setText("Ventas");
        panelRound26.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel54.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(81, 77, 167));
        jLabel54.setText("Total Registrados");
        panelRound26.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        txt_cantidad_ventas.setEditable(false);
        txt_cantidad_ventas.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad_ventas.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txt_cantidad_ventas.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidad_ventas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidad_ventasActionPerformed(evt);
            }
        });
        panelRound26.add(txt_cantidad_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, 100));

        panelRound4.add(panelRound26, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 300, 230, 250));

        panelRound27.setBackground(new java.awt.Color(16, 23, 39));
        panelRound27.setRoundBottomLeft(50);
        panelRound27.setRoundBottomRight(50);
        panelRound27.setRoundTopLeft(50);
        panelRound27.setRoundTopRight(50);
        panelRound27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        producto_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound27.add(producto_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 40, 40));

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(81, 77, 167));
        jLabel23.setText("Productos");
        panelRound27.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel61.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(81, 77, 167));
        jLabel61.setText("Total Registrados");
        panelRound27.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        txt_cantidad_productos.setEditable(false);
        txt_cantidad_productos.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad_productos.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txt_cantidad_productos.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidad_productos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cantidad_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidad_productosActionPerformed(evt);
            }
        });
        panelRound27.add(txt_cantidad_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, 100));

        panelRound4.add(panelRound27, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 300, 230, 250));

        jPanel_inicio.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 780, 575));

        getContentPane().add(jPanel_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 700));

        jPanel_menu.setBackground(new java.awt.Color(16, 23, 39));
        jPanel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_inventario.setBackground(new java.awt.Color(16, 23, 39));
        panel_inventario.setRoundBottomLeft(20);
        panel_inventario.setRoundBottomRight(20);
        panel_inventario.setRoundTopLeft(20);
        panel_inventario.setRoundTopRight(20);
        panel_inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_inventario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_inventario.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_inventario.setText("         Inventario");
        jLabel_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_inventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_inventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_inventarioMouseExited(evt);
            }
        });
        panel_inventario.add(jLabel_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_inventario.add(icon_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 180, 35));

        panel_inicio.setBackground(new java.awt.Color(16, 23, 39));
        panel_inicio.setRoundBottomLeft(20);
        panel_inicio.setRoundBottomRight(20);
        panel_inicio.setRoundTopLeft(20);
        panel_inicio.setRoundTopRight(20);
        panel_inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_inicio.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_inicio.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_inicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_inicio.setText("Inicio");
        jLabel_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_inicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_inicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_inicioMouseExited(evt);
            }
        });
        panel_inicio.add(jLabel_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_inicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_inicio.add(icon_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, 35));

        panel_cliente.setBackground(new java.awt.Color(16, 23, 39));
        panel_cliente.setRoundBottomLeft(20);
        panel_cliente.setRoundBottomRight(20);
        panel_cliente.setRoundTopLeft(20);
        panel_cliente.setRoundTopRight(20);
        panel_cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_cliente.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_cliente.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_cliente.setText("Cliente");
        jLabel_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_clienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_clienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_clienteMouseExited(evt);
            }
        });
        panel_cliente.add(jLabel_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_cliente.add(icon_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 180, 35));

        panel_historial.setBackground(new java.awt.Color(16, 23, 39));
        panel_historial.setRoundBottomLeft(20);
        panel_historial.setRoundBottomRight(20);
        panel_historial.setRoundTopLeft(20);
        panel_historial.setRoundTopRight(20);
        panel_historial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_historial.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_historial.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_historial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_historial.setText("                Historial Venta");
        jLabel_historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_historialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_historialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_historialMouseExited(evt);
            }
        });
        panel_historial.add(jLabel_historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_historial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_historial.add(icon_historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 180, 35));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel_menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 180, -1));

        panel_proveedor.setBackground(new java.awt.Color(16, 23, 39));
        panel_proveedor.setRoundBottomLeft(20);
        panel_proveedor.setRoundBottomRight(20);
        panel_proveedor.setRoundTopLeft(20);
        panel_proveedor.setRoundTopRight(20);
        panel_proveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_proveedores.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_proveedores.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_proveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_proveedores.setText("         Proveerdor");
        jLabel_proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_proveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_proveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_proveedoresMouseExited(evt);
            }
        });
        panel_proveedor.add(jLabel_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_proveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_proveedor.add(icon_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 180, 35));

        panel_factura.setBackground(new java.awt.Color(16, 23, 39));
        panel_factura.setRoundBottomLeft(20);
        panel_factura.setRoundBottomRight(20);
        panel_factura.setRoundTopLeft(20);
        panel_factura.setRoundTopRight(20);
        panel_factura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_factura.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_factura.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_factura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_factura.setText("              Realizar Venta");
        jLabel_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_facturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_facturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_facturaMouseExited(evt);
            }
        });
        panel_factura.add(jLabel_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_facturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_factura.add(icon_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 180, 35));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel_menu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 180, -1));

        panel_salir.setBackground(new java.awt.Color(16, 23, 39));
        panel_salir.setRoundBottomLeft(20);
        panel_salir.setRoundBottomRight(20);
        panel_salir.setRoundTopLeft(20);
        panel_salir.setRoundTopRight(20);
        panel_salir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_salir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_salir.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_salir.setText("Salir");
        jLabel_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_salirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_salirMouseExited(evt);
            }
        });
        panel_salir.add(jLabel_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_salir.add(icon_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 180, 35));

        panel_ayuda.setBackground(new java.awt.Color(16, 23, 39));
        panel_ayuda.setRoundBottomLeft(20);
        panel_ayuda.setRoundBottomRight(20);
        panel_ayuda.setRoundTopLeft(20);
        panel_ayuda.setRoundTopRight(20);
        panel_ayuda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ayuda.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_ayuda.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ayuda.setText("Ayuda");
        jLabel_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_ayudaMouseExited(evt);
            }
        });
        panel_ayuda.add(jLabel_ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_ayuda.add(icon_ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 180, 35));

        panel_empleado.setBackground(new java.awt.Color(16, 23, 39));
        panel_empleado.setRoundBottomLeft(20);
        panel_empleado.setRoundBottomRight(20);
        panel_empleado.setRoundTopLeft(20);
        panel_empleado.setRoundTopRight(20);
        panel_empleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_empleado.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel_empleado.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_empleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_empleado.setText("         Empleados");
        jLabel_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_empleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_empleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_empleadoMouseExited(evt);
            }
        });
        panel_empleado.add(jLabel_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 35));

        icon_empleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_empleado.add(icon_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 35));

        jPanel_menu.add(panel_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 180, 35));

        jLabel51.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Telecomunicaciones");
        jPanel_menu.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, 180, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("JAVIER CORTEZ");
        jPanel_menu.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 65, -1, -1));

        jLabel_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_menu.add(jLabel_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 100));

        panelRound3.setBackground(new java.awt.Color(26, 26, 88));
        panelRound3.setRoundBottomLeft(25);
        panelRound3.setRoundBottomRight(25);
        panelRound3.setRoundTopLeft(25);
        panelRound3.setRoundTopRight(25);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound3.add(icon_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 45, 45));

        txt_usuario.setEditable(false);
        txt_usuario.setBackground(new java.awt.Color(153, 153, 153));
        txt_usuario.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(52, 52, 177));
        txt_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuario.setBorder(null);
        panelRound3.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 120, 20));

        txt_fecha.setEditable(false);
        txt_fecha.setBackground(new java.awt.Color(153, 153, 153));
        txt_fecha.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(52, 52, 177));
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setBorder(null);
        panelRound3.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 120, 20));

        jPanel_menu.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 180, 60));

        getContentPane().add(jPanel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_inicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_inicioMouseEntered
        botones.colorBotonesEntrada(panel_inicio, jLabel_inicio);
    }//GEN-LAST:event_jLabel_inicioMouseEntered

    private void jLabel_inicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_inicioMouseExited
        botones.colorBotonesSalida(panel_inicio, jLabel_inicio);
    }//GEN-LAST:event_jLabel_inicioMouseExited

    private void jLabel_clienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_clienteMouseEntered
        botones.colorBotonesEntrada(panel_cliente, jLabel_cliente);
    }//GEN-LAST:event_jLabel_clienteMouseEntered

    private void jLabel_clienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_clienteMouseExited
        botones.colorBotonesSalida(panel_cliente, jLabel_cliente);
    }//GEN-LAST:event_jLabel_clienteMouseExited

    private void jLabel_proveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_proveedoresMouseEntered
        botones.colorBotonesEntrada(panel_proveedor, jLabel_proveedores);
    }//GEN-LAST:event_jLabel_proveedoresMouseEntered

    private void jLabel_proveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_proveedoresMouseExited
        botones.colorBotonesSalida(panel_proveedor, jLabel_proveedores);
    }//GEN-LAST:event_jLabel_proveedoresMouseExited

    private void jLabel_inventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_inventarioMouseEntered
        botones.colorBotonesEntrada(panel_inventario, jLabel_inventario);
    }//GEN-LAST:event_jLabel_inventarioMouseEntered

    private void jLabel_inventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_inventarioMouseExited
        botones.colorBotonesSalida(panel_inventario, jLabel_inventario);
    }//GEN-LAST:event_jLabel_inventarioMouseExited

    private void jLabel_facturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_facturaMouseEntered
        botones.colorBotonesEntrada(panel_factura, jLabel_factura);
    }//GEN-LAST:event_jLabel_facturaMouseEntered

    private void jLabel_facturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_facturaMouseExited
        botones.colorBotonesSalida(panel_factura, jLabel_factura);
    }//GEN-LAST:event_jLabel_facturaMouseExited

    private void jLabel_historialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_historialMouseEntered
        botones.colorBotonesEntrada(panel_historial, jLabel_historial);
    }//GEN-LAST:event_jLabel_historialMouseEntered

    private void jLabel_historialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_historialMouseExited
        botones.colorBotonesSalida(panel_historial, jLabel_historial);
    }//GEN-LAST:event_jLabel_historialMouseExited

    private void jLabel_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ayudaMouseEntered
        panel_ayuda.setBackground(new Color(24, 105, 62));
        jLabel_ayuda.setForeground(new Color(16, 23, 39));
    }//GEN-LAST:event_jLabel_ayudaMouseEntered

    private void jLabel_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ayudaMouseExited
        panel_ayuda.setBackground(new Color(16, 23, 39));
        jLabel_ayuda.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_jLabel_ayudaMouseExited

    private void jLabel_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_salirMouseEntered
        panel_salir.setBackground(new Color(137, 28, 53));
        jLabel_salir.setForeground(new Color(16, 23, 39));
    }//GEN-LAST:event_jLabel_salirMouseEntered

    private void jLabel_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_salirMouseExited
        panel_salir.setBackground(new Color(16, 23, 39));
        jLabel_salir.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_jLabel_salirMouseExited

    private void jLabel_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_salirMouseClicked
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jLabel_salirMouseClicked

    private void jLabel_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_inicioMouseClicked
        jPanel_inicio.setVisible(true);
        jPanel_cliente.setVisible(false);
        jPanel_proveedor.setVisible(false);
        jPanel_inventario.setVisible(false);
        jPanel_factura.setVisible(false);
        jPanel_historial.setVisible(false);
        jPanel_empleado.setVisible(false);
    }//GEN-LAST:event_jLabel_inicioMouseClicked

    private void jLabel_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_clienteMouseClicked
        cmb_tipo_cliente.setSelectedIndex(0);

        jScrollPane_registroClientesJuridico.setVisible(false);
        jScrollPane_registroClientesNatural.setVisible(true);

        jPanel_inicio.setVisible(false);
        jPanel_cliente.setVisible(true);
        jPanel_proveedor.setVisible(false);
        jPanel_inventario.setVisible(false);
        jPanel_factura.setVisible(false);
        jPanel_historial.setVisible(false);
        jPanel_empleado.setVisible(false);

        txt_documento_clientes.setText("");
        txt_nombre_clientes.setText("");
        txt_tipo_clientes.setText("");
        txt_telefono_clientes.setText("");
        txt_direccion_clientes.setText("");
        txt_buscar_cliente.setText("");

    }//GEN-LAST:event_jLabel_clienteMouseClicked

    private void jLabel_proveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_proveedoresMouseClicked

        cmb_proveedor.setSelectedIndex(0);

        jScrollPane_registroProveedoresNatural.setVisible(true);
        jScrollPane_registroProveedoresJuridico.setVisible(false);

        jPanel_inicio.setVisible(false);
        jPanel_cliente.setVisible(false);
        jPanel_proveedor.setVisible(true);
        jPanel_inventario.setVisible(false);
        jPanel_factura.setVisible(false);
        jPanel_historial.setVisible(false);
        jPanel_empleado.setVisible(false);

        txt_documento_proveedor.setText("");
        txt_nombre_proveedor.setText("");
        txt_tipo_proveedor.setText("");
        txt_telefono_proveedor.setText("");
        txt_direccion_proveedor.setText("");
        txt_buscar_proveedor.setText("");
    }//GEN-LAST:event_jLabel_proveedoresMouseClicked

    private void jLabel_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_inventarioMouseClicked
        jPanel_inicio.setVisible(false);
        jPanel_cliente.setVisible(false);
        jPanel_proveedor.setVisible(false);
        jPanel_inventario.setVisible(true);
        jPanel_factura.setVisible(false);
        jPanel_historial.setVisible(false);
        jPanel_empleado.setVisible(false);
    }//GEN-LAST:event_jLabel_inventarioMouseClicked

    private void jLabel_facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_facturaMouseClicked
        jPanel_inicio.setVisible(false);
        jPanel_cliente.setVisible(false);
        jPanel_proveedor.setVisible(false);
        jPanel_inventario.setVisible(false);
        jPanel_factura.setVisible(true);
        jPanel_historial.setVisible(false);
        jPanel_empleado.setVisible(false);
    }//GEN-LAST:event_jLabel_facturaMouseClicked

    private void jLabel_historialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_historialMouseClicked
        jPanel_inicio.setVisible(false);
        jPanel_cliente.setVisible(false);
        jPanel_proveedor.setVisible(false);
        jPanel_inventario.setVisible(false);
        jPanel_factura.setVisible(false);
        jPanel_historial.setVisible(true);
        jPanel_empleado.setVisible(false);
    }//GEN-LAST:event_jLabel_historialMouseClicked

    private void cmb_tipo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipo_clienteActionPerformed

        if (cmb_tipo_cliente.getSelectedIndex() == 0) {

            jScrollPane_registroClientesNatural.setVisible(true);
            jScrollPane_registroClientesJuridico.setVisible(false);

        } else if (cmb_tipo_cliente.getSelectedIndex() == 1) {

            jScrollPane_registroClientesNatural.setVisible(false);
            jScrollPane_registroClientesJuridico.setVisible(true);

        } else {

        }

    }//GEN-LAST:event_cmb_tipo_clienteActionPerformed

    private void btn_nuevo_clientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_clientesMouseEntered
        botones.colorBotonesEntrada(panel_nuevo, btn_nuevo_clientes);
    }//GEN-LAST:event_btn_nuevo_clientesMouseEntered

    private void btn_nuevo_clientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_clientesMouseExited
        botones.colorBotonesSalida(panel_nuevo, btn_nuevo_clientes);
    }//GEN-LAST:event_btn_nuevo_clientesMouseExited

    private void btn_eliminar_clientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_clientesMouseEntered
        botones.colorBotonesEntrada(panel_eliminar_clientes, btn_eliminar_clientes);
    }//GEN-LAST:event_btn_eliminar_clientesMouseEntered

    private void btn_eliminar_clientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_clientesMouseExited
        botones.colorBotonesSalida(panel_eliminar_clientes, btn_eliminar_clientes);
    }//GEN-LAST:event_btn_eliminar_clientesMouseExited

    private void btn_nuevo_proveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_proveedoresMouseEntered
        botones.colorBotonesEntrada(panel_nuevo_proveedores, btn_nuevo_proveedores);
    }//GEN-LAST:event_btn_nuevo_proveedoresMouseEntered

    private void btn_nuevo_proveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_proveedoresMouseExited
        botones.colorBotonesSalida(panel_nuevo_proveedores, btn_nuevo_proveedores);
    }//GEN-LAST:event_btn_nuevo_proveedoresMouseExited

    private void btn_eliminar_proveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_proveedoresMouseEntered
        botones.colorBotonesEntrada(panel_eliminar_proveedores, btn_eliminar_proveedores);
    }//GEN-LAST:event_btn_eliminar_proveedoresMouseEntered

    private void btn_eliminar_proveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_proveedoresMouseExited
        botones.colorBotonesSalida(panel_eliminar_proveedores, btn_eliminar_proveedores);
    }//GEN-LAST:event_btn_eliminar_proveedoresMouseExited

    private void cmb_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_proveedorActionPerformed

        if (cmb_proveedor.getSelectedIndex() == 0) {

            jScrollPane_registroProveedoresNatural.setVisible(true);
            jScrollPane_registroProveedoresJuridico.setVisible(false);

        } else if (cmb_proveedor.getSelectedIndex() == 1) {

            jScrollPane_registroProveedoresNatural.setVisible(false);
            jScrollPane_registroProveedoresJuridico.setVisible(true);

        } else {

        }


    }//GEN-LAST:event_cmb_proveedorActionPerformed

    private void btn_nuevo_inventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_inventarioMouseEntered
        botones.colorBotonesEntrada(panel_nuevo_inventario, btn_nuevo_inventario);
    }//GEN-LAST:event_btn_nuevo_inventarioMouseEntered

    private void btn_nuevo_inventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_inventarioMouseExited
        botones.colorBotonesSalida(panel_nuevo_inventario, btn_nuevo_inventario);
    }//GEN-LAST:event_btn_nuevo_inventarioMouseExited

    private void btn_eliminar_inventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_inventarioMouseEntered
        botones.colorBotonesEntrada(panel_eliminar_inventario, btn_eliminar_inventario);
    }//GEN-LAST:event_btn_eliminar_inventarioMouseEntered

    private void btn_eliminar_inventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_inventarioMouseExited
        botones.colorBotonesSalida(panel_eliminar_inventario, btn_eliminar_inventario);
    }//GEN-LAST:event_btn_eliminar_inventarioMouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_empleadoMouseClicked
        jPanel_inicio.setVisible(false);
        jPanel_cliente.setVisible(false);
        jPanel_proveedor.setVisible(false);
        jPanel_inventario.setVisible(false);
        jPanel_factura.setVisible(false);
        jPanel_historial.setVisible(false);
        jPanel_empleado.setVisible(true);

        txt_documento_empleado.setText("");
        txt_nombre_empleado.setText("");
        txt_telefono_empleado.setText("");
        txt_apellido_empleado.setText("");
        txt_buscar_empleado.setText("");
    }//GEN-LAST:event_jLabel_empleadoMouseClicked

    private void jLabel_empleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_empleadoMouseEntered
        panel_empleado.setBackground(new Color(123, 169, 255));
        jLabel_empleado.setForeground(new Color(16, 23, 39));
    }//GEN-LAST:event_jLabel_empleadoMouseEntered

    private void jLabel_empleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_empleadoMouseExited
        panel_empleado.setBackground(new Color(16, 23, 39));
        jLabel_empleado.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_empleadoMouseExited

    private void btn_actualizar_empleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_empleadosMouseEntered
        botones.colorBotonesEntrada(panel_actualizar_empleados, btn_actualizar_empleados);
    }//GEN-LAST:event_btn_actualizar_empleadosMouseEntered

    private void btn_actualizar_empleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_empleadosMouseExited
        botones.colorBotonesSalida(panel_actualizar_empleados, btn_actualizar_empleados);
    }//GEN-LAST:event_btn_actualizar_empleadosMouseExited

    private void btn_nuevo_empleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_empleadoMouseEntered
        botones.colorBotonesEntrada(panel_nuevo_empleado, btn_nuevo_empleado);
    }//GEN-LAST:event_btn_nuevo_empleadoMouseEntered

    private void btn_nuevo_empleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_empleadoMouseExited
        botones.colorBotonesSalida(panel_nuevo_empleado, btn_nuevo_empleado);
    }//GEN-LAST:event_btn_nuevo_empleadoMouseExited

    private void btn_eliminar_empleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_empleadosMouseEntered
        botones.colorBotonesEntrada(panel_eliminar_empleados, btn_eliminar_empleados);
    }//GEN-LAST:event_btn_eliminar_empleadosMouseEntered

    private void btn_eliminar_empleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_empleadosMouseExited
        botones.colorBotonesSalida(panel_eliminar_empleados, btn_eliminar_empleados);
    }//GEN-LAST:event_btn_eliminar_empleadosMouseExited

    private void txt_buscar_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscar_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscar_proveedorActionPerformed

    private void txt_direccion_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccion_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccion_proveedorActionPerformed

    private void btn_nuevo_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_clientesMouseClicked
        dispose();
        new NuevoCliente().setVisible(true);
    }//GEN-LAST:event_btn_nuevo_clientesMouseClicked

    private void btn_nuevo_proveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_proveedoresMouseClicked
        dispose();
        new NuevoProveedor().setVisible(true);
    }//GEN-LAST:event_btn_nuevo_proveedoresMouseClicked

    private void btn_nuevo_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_inventarioMouseClicked
        dispose();
        new NuevoProducto().setVisible(true);
    }//GEN-LAST:event_btn_nuevo_inventarioMouseClicked

    private void btn_nuevo_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_empleadoMouseClicked
        dispose();
        new NuevoEmpleado().setVisible(true);
    }//GEN-LAST:event_btn_nuevo_empleadoMouseClicked

    private void btn_actualizar_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_empleadosMouseClicked

        documento = txt_documento_empleado.getText();

        if (!documento.equals("")) {
            if (documento.matches("[0-9vV]*")) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT ci_empleado FROM empleados"
                            + " WHERE ci_empleado='" + documento + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        int salidaConfirm = JOptionPane.showConfirmDialog(null,
                                "Deseas Modificar datos del empleado: " + documento, "Confirmar", JOptionPane.YES_NO_OPTION);

                        if (salidaConfirm == 0) {
                            dispose();
                            new NuevoEmpleado().setVisible(true);
                        } else {
                        }

                    } else if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Codigo de empleado No existe");

                    }

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Error al conectar a base de datos");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Se ingresaron Datos Invalidos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El Campo de documento esta vacio");
        }


    }//GEN-LAST:event_btn_actualizar_empleadosMouseClicked

    private void cliente_buscar_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cliente_buscar_iconMouseEntered
        botones.colorBotonesEntrada(panel_buscar_clientes, cliente_buscar_icon);
    }//GEN-LAST:event_cliente_buscar_iconMouseEntered

    private void cliente_buscar_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cliente_buscar_iconMouseExited
        botones.colorBotonesSalida(panel_buscar_clientes, cliente_buscar_icon);
    }//GEN-LAST:event_cliente_buscar_iconMouseExited

    private void proveedor_buscar_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proveedor_buscar_iconMouseEntered
        botones.colorBotonesEntrada(panel_buscar_proveedores, proveedor_buscar_icon);
    }//GEN-LAST:event_proveedor_buscar_iconMouseEntered

    private void proveedor_buscar_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proveedor_buscar_iconMouseExited
        botones.colorBotonesSalida(panel_buscar_proveedores, proveedor_buscar_icon);
    }//GEN-LAST:event_proveedor_buscar_iconMouseExited

    private void inventario_buscar_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventario_buscar_iconMouseEntered
        botones.colorBotonesEntrada(panel_buscar_inventario, inventario_buscar_icon);
    }//GEN-LAST:event_inventario_buscar_iconMouseEntered

    private void inventario_buscar_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventario_buscar_iconMouseExited
        botones.colorBotonesSalida(panel_buscar_inventario, inventario_buscar_icon);
    }//GEN-LAST:event_inventario_buscar_iconMouseExited

    private void btn_cancelar_facturacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar_facturacionMouseEntered
        botones.colorBotonesEntrada(panel_cancelar_facturacion, btn_cancelar_facturacion);
    }//GEN-LAST:event_btn_cancelar_facturacionMouseEntered

    private void btn_cancelar_facturacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar_facturacionMouseExited
        botones.colorBotonesSalida(panel_cancelar_facturacion, btn_cancelar_facturacion);
    }//GEN-LAST:event_btn_cancelar_facturacionMouseExited

    private void btn_Devolucion_facturacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Devolucion_facturacionMouseEntered
        botones.colorBotonesEntrada(panel_Devolucion_facturacion, btn_Devolucion_facturacion);
    }//GEN-LAST:event_btn_Devolucion_facturacionMouseEntered

    private void btn_Devolucion_facturacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Devolucion_facturacionMouseExited
        botones.colorBotonesSalida(panel_Devolucion_facturacion, btn_Devolucion_facturacion);
    }//GEN-LAST:event_btn_Devolucion_facturacionMouseExited

    private void btn_comprobante_facturacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comprobante_facturacionMouseEntered
        botones.colorBotonesEntrada(panel_comprobante_facturacion, btn_comprobante_facturacion);
    }//GEN-LAST:event_btn_comprobante_facturacionMouseEntered

    private void btn_comprobante_facturacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comprobante_facturacionMouseExited
        botones.colorBotonesSalida(panel_comprobante_facturacion, btn_comprobante_facturacion);
    }//GEN-LAST:event_btn_comprobante_facturacionMouseExited

    private void empleado_buscar_iconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleado_buscar_iconMouseEntered
        botones.colorBotonesEntrada(panel_buscar_empleados, empleado_buscar_icon);
    }//GEN-LAST:event_empleado_buscar_iconMouseEntered

    private void empleado_buscar_iconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleado_buscar_iconMouseExited
        botones.colorBotonesSalida(panel_buscar_empleados, empleado_buscar_icon);
    }//GEN-LAST:event_empleado_buscar_iconMouseExited

    private void cmb_tipo_clienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_tipo_clienteItemStateChanged
    }//GEN-LAST:event_cmb_tipo_clienteItemStateChanged

    private void txt_cantidad_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidad_empleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_empleadosActionPerformed

    private void txt_cantidad_proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidad_proveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_proveedoresActionPerformed

    private void txt_cantidad_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidad_clientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_clientesActionPerformed

    private void txt_cantidad_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidad_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_ventasActionPerformed

    private void txt_cantidad_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidad_productosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidad_productosActionPerformed

    private void cliente_buscar_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cliente_buscar_iconMouseClicked
        String codigo = txt_buscar_cliente.getText().trim();
        int tipoC = cmb_tipo_cliente.getSelectedIndex();

        if (!codigo.equals("")) {

            if (tipoC == 0) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT cn.ci_cliente, cn.nombres_cliente, \n"
                            + "c.direccion, c.telefono, cn.tipo_cliente_id \n"
                            + "from clientes c, clientenatural cn\n"
                            + "WHERE c.documento_cliente = cn.ci_cliente\n"
                            + "AND c.tipo_Cliente_id = cn.tipo_cliente_id "
                            + "AND cn.ci_cliente ='" + codigo + "';");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        String cod = rs.getString("ci_cliente");
                        String nom = rs.getString("nombres_cliente");
                        String dir = rs.getString("direccion");
                        String tel = rs.getString("telefono");
                        String tipo_c = rs.getString("tipo_cliente_id");

                        txt_documento_clientes.setText(cod);
                        txt_nombre_clientes.setText(nom);
                        txt_tipo_clientes.setText("Cliente Natural");
                        txt_telefono_clientes.setText(tel);
                        txt_direccion_clientes.setText(dir);

                        cn.close();

                        txt_buscar_cliente.setText("");

                    } else {
                        JOptionPane.showMessageDialog(null, "El Cliente no se encuentra registrado");
                    }

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar el clientes en la base de datos verifica "
                            + " el numero de documento");
                }

            } else if (tipoC == 1) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT cj.rif_empresa, cj.nombre_empresa, c.direccion, c.telefono,\n"
                            + "c.tipo_Cliente_id\n"
                            + "from clientes c, clientejuridico cj\n"
                            + "WHERE c.documento_cliente = cj.rif_empresa\n"
                            + "AND c.tipo_Cliente_id = cj.tipo_cliente_id "
                            + "AND cj.rif_empresa ='" + codigo + "';");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        String cod = rs.getString("rif_empresa");
                        String nom = rs.getString("nombre_empresa");
                        String dir = rs.getString("direccion");
                        String tel = rs.getString("telefono");
                        String tipo_c = rs.getString("tipo_cliente_id");

                        txt_documento_clientes.setText(cod);
                        txt_nombre_clientes.setText(nom);
                        txt_tipo_clientes.setText("Cliente Juridico");
                        txt_telefono_clientes.setText(tel);
                        txt_direccion_clientes.setText(dir);

                        cn.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "El Cliente no se encuentra registrado");
                    }

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar el clientes en la base de datos verifica "
                            + " el numero de documento");
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes colocar la Cedula o Rif del cliente");
        }
    }//GEN-LAST:event_cliente_buscar_iconMouseClicked

    private void jTable_registroClientesNaturalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_registroClientesNaturalMouseClicked
    }//GEN-LAST:event_jTable_registroClientesNaturalMouseClicked

    private void jScrollPane_registroClientesNaturalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane_registroClientesNaturalMouseClicked
    }//GEN-LAST:event_jScrollPane_registroClientesNaturalMouseClicked

    private void jTable_registroClientesNaturalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_registroClientesNaturalMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_registroClientesNaturalMousePressed

    private void txt_documento_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_documento_clientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_documento_clientesActionPerformed

    private void proveedor_buscar_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proveedor_buscar_iconMouseClicked
        String codigo = txt_buscar_proveedor.getText().trim();
        int tipoP = cmb_proveedor.getSelectedIndex();

        if (!codigo.equals("")) {

            if (tipoP == 0) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT pn.ci_proveedor, pn.nombre_proveedor, p.direccion, p.telefono,\n"
                            + "pn.TipoProveedor_id_tipo_proveedor\n"
                            + "from proveedores p, proveedornatural pn\n"
                            + "WHERE p.documento_proveedor = pn.ci_proveedor\n"
                            + "AND p.TipoProveedor_id_tipo_proveedor = pn.TipoProveedor_id_tipo_proveedor "
                            + "AND pn.ci_proveedor ='" + codigo + "';");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        String cod = rs.getString("ci_proveedor");
                        String nom = rs.getString("nombre_proveedor");
                        String dir = rs.getString("direccion");
                        String tel = rs.getString("telefono");
                        String tipo_p = rs.getString("TipoProveedor_id_tipo_proveedor");

                        txt_documento_proveedor.setText(cod);
                        txt_nombre_proveedor.setText(nom);
                        txt_tipo_proveedor.setText("Proveedor Natural");
                        txt_telefono_proveedor.setText(tel);
                        txt_direccion_proveedor.setText(dir);

                        cn.close();
                        txt_buscar_proveedor.setText("");

                    } else {
                        JOptionPane.showMessageDialog(null, "El Proveedor no se encuentra registrado");
                    }

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar el Proveedor en la base de datos verifica "
                            + " el numero de documento");
                }

            } else if (tipoP == 1) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT pj.rif_proveedor, pj.nombre_empresa, p.direccion, p.telefono,\n"
                            + "pj.TipoProveedor_id_tipo_proveedor\n"
                            + "from proveedores p, proveedorjuridico pj\n"
                            + "WHERE p.documento_proveedor = pj.rif_proveedor\n"
                            + "AND p.TipoProveedor_id_tipo_proveedor = pj.TipoProveedor_id_tipo_proveedor "
                            + "AND pj.rif_proveedor ='" + codigo + "';");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        String cod = rs.getString("rif_proveedor");
                        String nom = rs.getString("nombre_empresa");
                        String dir = rs.getString("direccion");
                        String tel = rs.getString("telefono");
                        String tipo_p = rs.getString("TipoProveedor_id_tipo_proveedor");

                        txt_documento_proveedor.setText(cod);
                        txt_nombre_proveedor.setText(nom);
                        txt_tipo_proveedor.setText("Proveedor Juridico");
                        txt_telefono_proveedor.setText(tel);
                        txt_direccion_proveedor.setText(dir);

                        cn.close();
                        txt_buscar_proveedor.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "El Proveedor no se encuentra registrado");
                    }

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar el Proveedor en la base de datos verifica "
                            + " el numero de documento");
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes colocar la Cedula o Rif del Proveedor");
        }
    }//GEN-LAST:event_proveedor_buscar_iconMouseClicked

    private void empleado_buscar_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleado_buscar_iconMouseClicked
        String codigo = txt_buscar_empleado.getText().trim();

        if (!codigo.equals("")) {

            try {
                Connection cn = BDConexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT `ci_empleado`, `nombres_empleado`, `apellidos_empleado`, "
                        + " `telefono` FROM `empleados`"
                        + "WHERE ci_empleado='" + codigo + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String cod = rs.getString("ci_empleado");
                    String nom = rs.getString("nombres_empleado");
                    String ape = rs.getString("apellidos_empleado");
                    String tel = rs.getString("telefono");

                    txt_documento_empleado.setText(cod);
                    txt_nombre_empleado.setText(nom);
                    txt_telefono_empleado.setText(tel);
                    txt_apellido_empleado.setText(ape);

                    cn.close();
                    txt_buscar_empleado.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El Proveedor no se encuentra registrado");
                }

            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "No se ha podido encontrar el Proveedor en la base de datos verifica "
                        + " el numero de documento");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes colocar la Cedula o Rif del Proveedor");
        }
    }//GEN-LAST:event_empleado_buscar_iconMouseClicked

    private void btn_eliminar_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_clientesMouseClicked
        int salidaConfirm = JOptionPane.showConfirmDialog(null,
                "Seguro de Eliminar el Cliente", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (salidaConfirm == 0) {
            String cedula = txt_documento_clientes.getText().trim();

            if (!cedula.equals("")) {
                try {
                    Connection cn = BDConexion.conectar();

                    if (cmb_tipo_cliente.getSelectedIndex() == 0) {

                        PreparedStatement pst = cn.prepareStatement(
                                "delete from clientenatural where ci_cliente=?");
                        pst.setString(1, cedula);
                        pst.executeUpdate();
                    } else if (cmb_tipo_cliente.getSelectedIndex() == 1) {

                        PreparedStatement pst = cn.prepareStatement(
                                "delete from clientejuridico where rif_empresa=?");
                        pst.setString(1, cedula);
                        pst.executeUpdate();
                    }

                    PreparedStatement pst2 = cn.prepareStatement(
                            "delete from clientes where documento_cliente=?");
                    pst2.setString(1, cedula);
                    pst2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Se Elimino el Registro del Cliente");

                    cn.close();

                    dispose();
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se encontro Cliente..");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifica el Codigo");
            }
        } else {
        }
    }//GEN-LAST:event_btn_eliminar_clientesMouseClicked

    private void btn_eliminar_proveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_proveedoresMouseClicked
        int salidaConfirm = JOptionPane.showConfirmDialog(null,
                "Seguro de Eliminar el Proveedor", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (salidaConfirm == 0) {
            String cedula = txt_documento_proveedor.getText().trim();

            if (!cedula.equals("")) {
                try {
                    Connection cn = BDConexion.conectar();

                    if (cmb_proveedor.getSelectedIndex() == 0) {

                        PreparedStatement pst = cn.prepareStatement(
                                "delete from proveedornatural where ci_proveedor=?");
                        pst.setString(1, cedula);
                        pst.executeUpdate();
                    } else if (cmb_proveedor.getSelectedIndex() == 1) {

                        PreparedStatement pst = cn.prepareStatement(
                                "delete from proveedorjuridico where rif_proveedor=?");
                        pst.setString(1, cedula);
                        pst.executeUpdate();
                    }

                    PreparedStatement pst2 = cn.prepareStatement(
                            "delete from proveedores where documento_proveedor=?");
                    pst2.setString(1, cedula);
                    pst2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Se Elimino el Registro del Proveedor");

                    cn.close();

                    dispose();
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se encontro Proveedor..");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifica el Codigo");
            }
        } else {
        }
    }//GEN-LAST:event_btn_eliminar_proveedoresMouseClicked

    private void txt_documento_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_documento_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_documento_empleadoActionPerformed

    private void btn_eliminar_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_empleadosMouseClicked
        int salidaConfirm = JOptionPane.showConfirmDialog(null,
                "Seguro de Eliminar el Empleado", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (salidaConfirm == 0) {
            String cedula = txt_documento_empleado.getText().trim();

            if (!cedula.equals("")) {
                try {
                    Connection cn = BDConexion.conectar();

                    PreparedStatement pst = cn.prepareStatement(
                            "delete from empleados where ci_empleado=?");
                    pst.setString(1, cedula);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Se Elimino el Registro del Empleado");

                    txt_documento_empleado.setText("");

                    cn.close();

                    dispose();
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se encontro Empleado..");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifica el Codigo");
            }
        } else {
        }
    }//GEN-LAST:event_btn_eliminar_empleadosMouseClicked

    private void btn_eliminar_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminar_inventarioMouseClicked
        int salidaConfirm = JOptionPane.showConfirmDialog(null,
                "Seguro de Eliminar el Producto", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (salidaConfirm == 0) {
            String codigo = txt_buscar_inventario.getText().trim();

            if (!codigo.equals("")) {
                try {
                    Connection cn = BDConexion.conectar();

                    PreparedStatement pst = cn.prepareStatement(
                            "delete from productos where codigo_productos=?");
                    pst.setString(1, codigo);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Se Elimino el Registro del Producto");

                    txt_documento_empleado.setText("");

                    cn.close();

                    dispose();
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se encontro Producto..");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifica el Codigo");
            }
        } else {
        }
    }//GEN-LAST:event_btn_eliminar_inventarioMouseClicked

    private void inventario_buscar_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventario_buscar_iconMouseClicked
        String codigo = txt_buscar_inventario.getText().trim();

        if (!codigo.equals("")) {

            try {
                Connection cn = BDConexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT `codigo_productos`, `nombre_producto`, `precio`, `stock` FROM `productos`"
                        + "WHERE codigo_productos='" + codigo + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    String nombre = rs.getString("nombre_producto");
                    int precio = rs.getInt("precio");
                    int stock = rs.getInt("stock");

                    if (stock > 0) {
                        txt_buscar_inventario.setBackground(Color.green);
                        panel_buscar_producto.setBackground(Color.green);

                        JOptionPane.showMessageDialog(null, "Confirmada existencia del Producto\n"
                                + "Producto: " + nombre + "\n"
                                + "Precio: " + precio + " $ \n"
                                + "Stock: " + stock);
                    } else {
                        txt_buscar_inventario.setBackground(Color.red);
                        panel_buscar_producto.setBackground(Color.red);
                        JOptionPane.showMessageDialog(null, "El Producto Agotado");
                    }

                    cn.close();
                } else {
                    JOptionPane.showMessageDialog(null, "El Proveedor no se encuentra registrado");
                }

            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "No se ha podido encontrar el Proveedor en la base de datos verifica "
                        + " el Codigo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes colocar la Cedula o Rif del Proveedor");
        }
    }//GEN-LAST:event_inventario_buscar_iconMouseClicked

    private void txt_buscar_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscar_inventarioMouseClicked
        txt_buscar_inventario.setBackground(new Color(204, 204, 204));
        panel_buscar_producto.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_txt_buscar_inventarioMouseClicked

    private void btn_cancelar_facturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar_facturacionMouseClicked

        String codigo = txt_codigoProductoVentas.getText().trim();
        String nombre = txt_nombreProductoVentas.getText().trim();
        String cantidad = txt_cantidadProductoVentas.getText().trim();
        String precio = txt_precioProductoVentas.getText().trim();
        String fecha = txt_fechaVentas.getText().trim();
        String descuento = txt_descuento_factura.getText().trim();
        int cantidad2 = Integer.parseInt(cantidad);
        int precio2 = Integer.parseInt(precio);
        int monto = cantidad2 * precio2;

        String documento = txt_documentoVentas.getText().trim();
        String telefono = txt_telefonoVentas.getText().trim();
        String direccion = txt_direccionVentas.getText().trim();
        String usuario = txt_usuario.getText().trim();

        String[] datosN = {precio, cantidad, descuento, telefono};
        String[] datosT = {codigo, documento, direccion};
        String[] datosL = {nombre};

        if (camposVaciosArray(datosT) && camposVaciosArray(datosN)) {

            if (validarNumerosC(datosN) && validarTodos(datosT) && validarLetras(datosL)) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT codigo_productos, stock FROM productos"
                            + " WHERE codigo_productos='" + codigo + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        int stock = rs.getInt("stock");
                        if (stock > 0) {

                            try {
                                Connection cn3 = BDConexion.conectar();
                                PreparedStatement pst3 = cn3.prepareStatement(
                                        "insert into ventas values (?,?,?,?,?,?,?,?,?)");

                                pst3.setInt(1, 0);
                                pst3.setString(2, codigo);
                                pst3.setString(3, fecha);
                                pst3.setString(4, hora + ":" + minutos + ":" + segundo);
                                pst3.setString(5, nombre);
                                pst3.setString(6, documento);
                                pst3.setString(7, usuario);
                                pst3.setString(8, "Confirmado");
                                pst3.setInt(9, (cantidad2 * precio2));

                                pst3.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Venta Registradda Registrada");

                                cn3.close();
                                cn.close();

                            } catch (Exception e) {
                                System.err.println(e);
                                System.err.println("Error con la Tabla Producto");
                                JOptionPane.showMessageDialog(null, "Error al Registrar Producto");
                            }

                            Object[] filas = new Object[6];

                            filas[0] = txt_documentoVentas.getText().trim();
                            filas[1] = txt_nombreProductoVentas.getText().trim();
                            filas[2] = txt_cantidadProductoVentas.getText().trim();
                            filas[3] = txt_precioProductoVentas.getText().trim();
                            filas[4] = monto;
                            filas[5] = txt_fechaVentas.getText().trim();

                            factura.addRow(filas);

                        } else {

                            JOptionPane.showMessageDialog(null, "El Producto Agotadoa en el inventario");
                        }

                    } else if (!rs.next()) {

                        JOptionPane.showMessageDialog(null, "No hay existencia del producto");
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


    }//GEN-LAST:event_btn_cancelar_facturacionMouseClicked

    private void cmb_productos_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_productos_ventasActionPerformed
        String producto = (String) cmb_productos_ventas.getSelectedItem();

        try {
            Connection cn2 = BDConexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT codigo_productos, nombre_producto "
                    + "from productos where nombre_producto='" + producto + "'");
            ResultSet rs2 = pst2.executeQuery();
            if (rs2.next()) {
                txt_codigoProductoVentas.setText(rs2.getString(1));
                txt_nombreProductoVentas.setText(rs2.getString(2));

            } else {
            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
    }//GEN-LAST:event_cmb_productos_ventasActionPerformed

    private void cmb_clientes_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_clientes_ventasActionPerformed
        String cliente = (String) cmb_clientes_ventas.getSelectedItem();

        try {
            Connection cn2 = BDConexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "SELECT documento_cliente, direccion, telefono "
                    + "from clientes where documento_cliente='" + cliente + "'");
            ResultSet rs2 = pst2.executeQuery();
            if (rs2.next()) {
                txt_documentoVentas.setText(rs2.getString(1));
                txt_direccionVentas.setText(rs2.getString(2));
                txt_telefonoVentas.setText(rs2.getString(3));
            } else {

            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion Contactar al abministrador de la base de datos");
        }
    }//GEN-LAST:event_cmb_clientes_ventasActionPerformed

    private void btn_Devolucion_facturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Devolucion_facturacionMouseClicked
        int salidaConfirm = JOptionPane.showConfirmDialog(null,
                "Desea hacer una Devolucion", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (salidaConfirm == 0) {
            String codigo = txt_codigoProductoVentas.getText().trim();

            if (!codigo.equals("")) {
                try {
                    Connection cn = BDConexion.conectar();

                    PreparedStatement pst = cn.prepareStatement(
                            "delete from ventas where codigo_venta=?");
                    pst.setString(1, codigo);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Se Elimino el Registro de la Venta");

                    cn.close();
                    dispose();
                    new MenuPrincipal().setVisible(true);

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "No se encontro Venta...");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifica el Codigo");
            }
        } else {
        }
    }//GEN-LAST:event_btn_Devolucion_facturacionMouseClicked

    private void btn_comprobante_facturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_comprobante_facturacionMouseClicked
        int salidaConfirm = JOptionPane.showConfirmDialog(null,
                "Confirmar Compra", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (salidaConfirm == 0) {
            JOptionPane.showMessageDialog(null, "Compra Realizada Con exito...");
            dispose();
            new MenuPrincipal().setVisible(true);
        } else {
        }
    }//GEN-LAST:event_btn_comprobante_facturacionMouseClicked

    private void btn_actualizar_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_inventarioMouseClicked

    }//GEN-LAST:event_btn_actualizar_inventarioMouseClicked

    private void btn_actualizar_inventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_inventarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizar_inventarioMouseEntered

    private void btn_actualizar_inventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizar_inventarioMouseExited
        documento = txt_buscar_inventario.getText();

        if (!documento.equals("")) {
            if (documento.matches("[0-9a-zA-Z]*")) {

                try {
                    Connection cn = BDConexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "SELECT codigo_productos FROM productos"
                            + " WHERE codigo_productos='" + documento + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        int salidaConfirm = JOptionPane.showConfirmDialog(null,
                                "Deseas Modificar un producto: " + documento, "Confirmar", JOptionPane.YES_NO_OPTION);

                        if (salidaConfirm == 0) {
                            dispose();
                            new NuevoProducto().setVisible(true);
                        } else {
                        }

                    } else if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Codigo de empleado No existe");

                    }

                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Error al conectar a base de datos");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Se ingresaron Datos Invalidos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El Campo de documento esta vacio");
        }
    }//GEN-LAST:event_btn_actualizar_inventarioMouseExited

    private void btn_generar_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generar_reporteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_generar_reporteMouseClicked

    private void btn_generar_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generar_reporteMouseEntered
        botones.colorBotonesEntrada(panel_generar_reporte, btn_generar_reporte);
    }//GEN-LAST:event_btn_generar_reporteMouseEntered

    private void btn_generar_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generar_reporteMouseExited
        botones.colorBotonesSalida(panel_generar_reporte, btn_generar_reporte);
    }//GEN-LAST:event_btn_generar_reporteMouseExited

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ventas_icon;
    private javax.swing.JLabel btn_Devolucion_facturacion;
    private javax.swing.JLabel btn_actualizar_empleados;
    private javax.swing.JLabel btn_actualizar_inventario;
    private javax.swing.JLabel btn_cancelar_facturacion;
    private javax.swing.JLabel btn_cliente_facturacion;
    private javax.swing.JLabel btn_comprobante_facturacion;
    private javax.swing.JLabel btn_eliminar_clientes;
    private javax.swing.JLabel btn_eliminar_empleados;
    private javax.swing.JLabel btn_eliminar_inventario;
    private javax.swing.JLabel btn_eliminar_proveedores;
    private javax.swing.JLabel btn_generar_reporte;
    private javax.swing.JLabel btn_nuevo_clientes;
    private javax.swing.JLabel btn_nuevo_empleado;
    private javax.swing.JLabel btn_nuevo_inventario;
    private javax.swing.JLabel btn_nuevo_proveedores;
    private javax.swing.JLabel btn_producto_facturacion;
    private javax.swing.JLabel cliente_buscar_icon;
    private javax.swing.JLabel cliente_cliente_icon;
    private javax.swing.JLabel cliente_icon;
    private javax.swing.JComboBox<String> cmb_clientes_ventas;
    private javax.swing.JComboBox<String> cmb_productos_ventas;
    private javax.swing.JComboBox<String> cmb_proveedor;
    private javax.swing.JComboBox<String> cmb_tipo_cliente;
    private javax.swing.JLabel empleado_buscar_icon;
    private javax.swing.JLabel empleado_empleado_icon;
    private javax.swing.JLabel empleado_icon;
    private javax.swing.JLabel facturacion_cliente_icon;
    private javax.swing.JLabel facturacion_producto_icon;
    private javax.swing.JLabel facturacion_venta_icon;
    private javax.swing.JLabel historial_historial_icon;
    private javax.swing.JLabel icon_ayuda;
    private javax.swing.JLabel icon_cliente;
    private javax.swing.JLabel icon_empleado;
    private javax.swing.JLabel icon_facturacion;
    private javax.swing.JLabel icon_historial;
    private javax.swing.JLabel icon_inicio;
    private javax.swing.JLabel icon_inventario;
    private javax.swing.JLabel icon_proveedor;
    private javax.swing.JLabel icon_salir;
    private javax.swing.JLabel icon_user;
    private javax.swing.JLabel inventario_buscar_icon;
    private javax.swing.JLabel inventario_inventario_icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel1_inicioSesion;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel_alerta1;
    private javax.swing.JLabel jLabel_alerta2;
    private javax.swing.JLabel jLabel_alerta3;
    private javax.swing.JLabel jLabel_alerta4;
    private javax.swing.JLabel jLabel_ayuda;
    private javax.swing.JLabel jLabel_cliente;
    private javax.swing.JLabel jLabel_empleado;
    private javax.swing.JLabel jLabel_factura;
    private javax.swing.JLabel jLabel_historial;
    private javax.swing.JLabel jLabel_inicio;
    private javax.swing.JLabel jLabel_inventario;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_proveedores;
    private javax.swing.JLabel jLabel_salir;
    private javax.swing.JPanel jPanel_cliente;
    private javax.swing.JPanel jPanel_empleado;
    private javax.swing.JPanel jPanel_factura;
    private javax.swing.JPanel jPanel_historial;
    private javax.swing.JPanel jPanel_inicio;
    private javax.swing.JPanel jPanel_inventario;
    private javax.swing.JPanel jPanel_menu;
    private javax.swing.JPanel jPanel_proveedor;
    private javax.swing.JScrollPane jScrollPane_registroClientesJuridico;
    private javax.swing.JScrollPane jScrollPane_registroClientesNatural;
    private javax.swing.JScrollPane jScrollPane_registroEmpleado;
    private javax.swing.JScrollPane jScrollPane_registroHistorial;
    private javax.swing.JScrollPane jScrollPane_registroInventario;
    private javax.swing.JScrollPane jScrollPane_registroProveedoresJuridico;
    private javax.swing.JScrollPane jScrollPane_registroProveedoresNatural;
    private javax.swing.JScrollPane jScroll_factura;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable_registroClientesJuridico;
    private javax.swing.JTable jTable_registroClientesNatural;
    private javax.swing.JTable jTable_registroEmpleado;
    private javax.swing.JTable jTable_registroHistorial;
    private javax.swing.JTable jTable_registroInventario;
    private javax.swing.JTable jTable_registroProveedoresJuridico;
    private javax.swing.JTable jTable_registroProveedoresNatural;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private prueba_diseño.PanelRound panelRound1;
    private prueba_diseño.PanelRound panelRound10;
    private prueba_diseño.PanelRound panelRound11;
    private prueba_diseño.PanelRound panelRound12;
    private prueba_diseño.PanelRound panelRound13;
    private prueba_diseño.PanelRound panelRound14;
    private prueba_diseño.PanelRound panelRound15;
    private prueba_diseño.PanelRound panelRound16;
    private prueba_diseño.PanelRound panelRound17;
    private prueba_diseño.PanelRound panelRound18;
    private prueba_diseño.PanelRound panelRound19;
    private prueba_diseño.PanelRound panelRound2;
    private prueba_diseño.PanelRound panelRound20;
    private prueba_diseño.PanelRound panelRound21;
    private prueba_diseño.PanelRound panelRound22;
    private prueba_diseño.PanelRound panelRound23;
    private prueba_diseño.PanelRound panelRound24;
    private prueba_diseño.PanelRound panelRound25;
    private prueba_diseño.PanelRound panelRound26;
    private prueba_diseño.PanelRound panelRound27;
    private prueba_diseño.PanelRound panelRound3;
    private prueba_diseño.PanelRound panelRound30;
    private prueba_diseño.PanelRound panelRound31;
    private prueba_diseño.PanelRound panelRound32;
    private prueba_diseño.PanelRound panelRound34;
    private prueba_diseño.PanelRound panelRound35;
    private prueba_diseño.PanelRound panelRound36;
    private prueba_diseño.PanelRound panelRound37;
    private prueba_diseño.PanelRound panelRound39;
    private prueba_diseño.PanelRound panelRound4;
    private prueba_diseño.PanelRound panelRound40;
    private prueba_diseño.PanelRound panelRound42;
    private prueba_diseño.PanelRound panelRound45;
    private prueba_diseño.PanelRound panelRound46;
    private prueba_diseño.PanelRound panelRound47;
    private prueba_diseño.PanelRound panelRound49;
    private prueba_diseño.PanelRound panelRound50;
    private prueba_diseño.PanelRound panelRound55;
    private prueba_diseño.PanelRound panelRound56;
    private prueba_diseño.PanelRound panelRound57;
    private prueba_diseño.PanelRound panelRound58;
    private prueba_diseño.PanelRound panelRound59;
    private prueba_diseño.PanelRound panelRound60;
    private prueba_diseño.PanelRound panelRound61;
    private prueba_diseño.PanelRound panelRound62;
    private prueba_diseño.PanelRound panelRound63;
    private prueba_diseño.PanelRound panelRound64;
    private prueba_diseño.PanelRound panelRound65;
    private prueba_diseño.PanelRound panelRound66;
    private prueba_diseño.PanelRound panelRound67;
    private prueba_diseño.PanelRound panelRound68;
    private prueba_diseño.PanelRound panelRound69;
    private prueba_diseño.PanelRound panelRound9;
    private prueba_diseño.PanelRound panel_Devolucion_facturacion;
    private prueba_diseño.PanelRound panel_actualizar_empleados;
    private prueba_diseño.PanelRound panel_actualizar_inventario;
    private prueba_diseño.PanelRound panel_ayuda;
    private prueba_diseño.PanelRound panel_buscar_clientes;
    private prueba_diseño.PanelRound panel_buscar_empleados;
    private prueba_diseño.PanelRound panel_buscar_historial;
    private prueba_diseño.PanelRound panel_buscar_inventario;
    private prueba_diseño.PanelRound panel_buscar_producto;
    private prueba_diseño.PanelRound panel_buscar_proveedores;
    private prueba_diseño.PanelRound panel_cancelar_facturacion;
    private prueba_diseño.PanelRound panel_cliente;
    private prueba_diseño.PanelRound panel_cliente_facturacion;
    private prueba_diseño.PanelRound panel_comprobante_facturacion;
    private prueba_diseño.PanelRound panel_eliminar_clientes;
    private prueba_diseño.PanelRound panel_eliminar_empleados;
    private prueba_diseño.PanelRound panel_eliminar_inventario;
    private prueba_diseño.PanelRound panel_eliminar_proveedores;
    private prueba_diseño.PanelRound panel_empleado;
    private prueba_diseño.PanelRound panel_factura;
    private prueba_diseño.PanelRound panel_generar_reporte;
    private prueba_diseño.PanelRound panel_historial;
    private prueba_diseño.PanelRound panel_imprimir_historial;
    private prueba_diseño.PanelRound panel_inicio;
    private prueba_diseño.PanelRound panel_inventario;
    private prueba_diseño.PanelRound panel_nuevo;
    private prueba_diseño.PanelRound panel_nuevo_empleado;
    private prueba_diseño.PanelRound panel_nuevo_inventario;
    private prueba_diseño.PanelRound panel_nuevo_proveedores;
    private prueba_diseño.PanelRound panel_producto_facturacion;
    private prueba_diseño.PanelRound panel_proveedor;
    private prueba_diseño.PanelRound panel_salir;
    private javax.swing.JLabel producto_icon;
    private javax.swing.JLabel proveedor_buscar_icon;
    private javax.swing.JLabel proveedor_icon;
    private javax.swing.JLabel proveedor_proveedor_icon;
    private javax.swing.JTable tabla_factura;
    private javax.swing.JTextField txt_apellido_empleado;
    private javax.swing.JTextField txt_buscar_cliente;
    private javax.swing.JTextField txt_buscar_empleado;
    private javax.swing.JTextField txt_buscar_inventario;
    private javax.swing.JTextField txt_buscar_proveedor;
    private javax.swing.JTextField txt_cantidadProductoVentas;
    private javax.swing.JTextField txt_cantidad_clientes;
    private javax.swing.JTextField txt_cantidad_empleados;
    private javax.swing.JTextField txt_cantidad_productos;
    private javax.swing.JTextField txt_cantidad_proveedores;
    private javax.swing.JTextField txt_cantidad_ventas;
    private javax.swing.JTextField txt_codigoProductoVentas;
    private javax.swing.JTextField txt_descuento_factura;
    private javax.swing.JTextField txt_direccionVentas;
    private javax.swing.JTextField txt_direccion_clientes;
    private javax.swing.JTextField txt_direccion_proveedor;
    private javax.swing.JTextField txt_documentoVentas;
    private javax.swing.JTextField txt_documento_clientes;
    private javax.swing.JTextField txt_documento_empleado;
    private javax.swing.JTextField txt_documento_proveedor;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JFormattedTextField txt_fechaVentas;
    private javax.swing.JTextField txt_nombreProductoVentas;
    private javax.swing.JTextField txt_nombre_clientes;
    private javax.swing.JTextField txt_nombre_empleado;
    private javax.swing.JTextField txt_nombre_proveedor;
    private javax.swing.JTextField txt_precioProductoVentas;
    private javax.swing.JTextField txt_telefonoVentas;
    private javax.swing.JTextField txt_telefono_clientes;
    private javax.swing.JTextField txt_telefono_empleado;
    private javax.swing.JTextField txt_telefono_proveedor;
    private javax.swing.JTextField txt_tipo_clientes;
    private javax.swing.JTextField txt_tipo_proveedor;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
