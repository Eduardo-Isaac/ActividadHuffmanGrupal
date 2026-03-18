import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TraductorASCII {

    public static void main(String[] args) {

        String filePath = "GREEN EGGS AND HAM.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            int c;

            while ((c = reader.read()) != -1) {
                char caracter = (char) c;

                System.out.println("'" + caracter + "' -> " + c);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }
    }
}
