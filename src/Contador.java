import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        File archivo = new File("carta.txt");
        int contadorCaracteres = 0;
        int contadorLineas = 0;
        int contadorPalabras = 0;
        try {
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                contadorLineas++;
                contadorCaracteres += linea.length();
                contadorPalabras += contarPalabras(linea);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se ha encontrado.");
        }
        System.out.println("Caracteres: " + contadorCaracteres);
        System.out.println("Lineas: " + contadorLineas);
        System.out.println("Palabras: " + contadorPalabras);
    }

    private static int contarPalabras(String linea) {
        int contador = 0;
        boolean enPalabra = false;
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (c == ' ' || c == '\n') {
                if (enPalabra) {
                    contador++;
                    enPalabra = false;
                }
            } else {
                enPalabra = true;
            }
        }
        if (enPalabra) {
            contador++;
        }
        return contador;
    }
}
