package util;

public class Validador {

    public static boolean esCorreoValido(String correo) {
        return correo.contains("@") && correo.contains(".");
    }

    public static boolean esNumero(String texto) {
        return texto.matches("[0-9]+");
    }

    public static boolean esPositivo(double numero) {
        return numero > 0;
    }

    public static boolean esEdadValida(int edad) {
        return edad > 0 && edad < 150;
    }
}