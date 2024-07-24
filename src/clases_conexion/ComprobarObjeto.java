package clases_conexion;

import java.sql.*;

public class ComprobarObjeto {
    
    public static Object[] comprobarCliente(String consulta, int modulo, String documento) {
        String[] cliente = new String[4];
        
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/sistema_jc_bd", "root", "");
            
        } catch (Exception e) {
        }
        
        
        
        
        
        
        
        
//        int i=0;
//        int i3=1;
//        
//        while (i<4) {
//            
//            i3++;
//            String i2= i3+"";
//            cliente[i]=i2;
//            i++;
//        }
        
        return cliente;
    }
    
    
    public static void main(String[] args) {
        
        
    }
}
