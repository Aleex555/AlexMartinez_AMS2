import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PR125cp {
    public static void main(String args[]) throws IOException {
        String base = System.getProperty("user.dir") + "/myFiles/frasesMatrix.txt";
        Path basePath = Paths.get(base);
        String base1 = System.getProperty("user.dir") + "/src/frasesMatrix.txt";
        Path destino = Paths.get(base1);
        try {
            // Copia el archivo desde la ubicación de origen a la ubicación de destino
            Files.copy(basePath, destino, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Archivo copiado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
        }

    }
}
