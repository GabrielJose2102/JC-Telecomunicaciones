package clases_validacion;

public class ValidacionesGenerales {

    public ValidacionesGenerales() {

    }

    public static boolean camposVaciosArray(String[] campos) {

        for (String campo : campos) {
            if (campo.equals("")) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarTodos(String datos) {

        return datos.matches("[0-9a-zA-Z ]*");
    }
    
    public static boolean validarTodos(String[] datos) {

        for (String dato : datos) {

            if (!validarTodos(dato)) {
                return false;
            }

        }
        return true;
    }
    
    public static boolean validarNumeros(String datos) {

        return datos.matches("[0-9]*");
    }

    public static boolean validarNumerosC(String[] datos) {

        for (String dato : datos) {

            if (!validarNumeros(dato)) {
                return false;
            }

        }
        return true;
    }

    public static boolean validarLetras(String datos) {

        return datos.matches("[a-zA-Z ]*");
    }
    
    public static boolean validarLetras(String[] datos) {

        for (String dato : datos) {

            if (!ValidacionesGenerales.validarLetras(dato)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        
    }

}
