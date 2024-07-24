package clases_conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDConexion {
    
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/sistema_jc_bd?serverTimezone=UTC", "root", "");
            return cn;
        } catch (Exception e) {
            System.err.println("Error en la conexion principal: " + e);
        }
        return (null);
    }
}
