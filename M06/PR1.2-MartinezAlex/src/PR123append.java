import java.io.FileWriter;
import java.io.IOException;

public class PR123append {
    public static void main(String args[]) throws IOException {
        String basePath = System.getProperty("user.dir") + "/myFiles/frasesMatrix.txt";
        FileWriter f1 = new FileWriter(basePath,true);
        f1.write("\nYo sólo puedo mostrarte la puerta\n");
        f1.write("Tú eres quien la tiene que atravesar");
        f1.close();
    }
}
