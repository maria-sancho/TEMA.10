import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuardarDatos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce tu edad: ");
        int edad = scanner.nextInt();

        File archivo = new File("datos.txt");
        try {
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.write(nombre + "," + edad + "\n");
            escritor.close();
            System.out.println("Los datos se han guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Se ha producido un error al guardar los datos.");
            e.printStackTrace();
        }
    }
}
