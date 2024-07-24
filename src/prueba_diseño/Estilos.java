package prueba_diseño;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Estilos {

    public Estilos() {

    }

    public void btnSalir(JLabel boton) {
        ImageIcon logo_menu = new ImageIcon("src/iconos32px_azul/salida.png");
        Icon logoIcon_menu = new ImageIcon(logo_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        boton.setIcon(logoIcon_menu);
    }

    public void iconoPrincipal(JLabel boton, String icono) {
        ImageIcon logo_menu = new ImageIcon(icono);
        Icon logoIcon_menu = new ImageIcon(logo_menu.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
        boton.setIcon(logoIcon_menu);
    }

    public void colorBotonesEntrada(JPanel boton, JLabel letra) {
        boton.setBackground(new Color(123, 169, 255));
        letra.setForeground(new Color(16, 23, 39));
    }

    public void colorBotonesSalida(JPanel boton, JLabel letra) {
        boton.setBackground(new Color(16, 23, 39));
        letra.setForeground(new Color(204, 204, 204));
    }

    
}
