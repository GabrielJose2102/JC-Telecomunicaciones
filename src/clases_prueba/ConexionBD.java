package clases_prueba;

import java.sql.*;

public class ConexionBD {

    public static ResultSet conectar() {

        String resultado;
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_sistema_jc", "root", "");
            PreparedStatement pst = cn.prepareStatement("select numero_almacen from almacen");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                resultado = rs.getNString("numero_almacen");

                System.out.println("resultado = " + resultado);
            }

            return rs;
        } catch (Exception e) {
            System.err.println("Error en la conexion principal: " + e);
        }
        return (null);
    }

    public static void main(String[] args) {
        conectar();
    }
}
