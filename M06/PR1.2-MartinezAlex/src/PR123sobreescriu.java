import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR123sobreescriu {
    public static void main(String args[]) throws IOException {
        String basePath = System.getProperty("user.dir") + "/myFiles/frasesMatrix.txt";
        File f1 = new File(basePath);
        if (f1.exists()){
            FileWriter fw0 = new FileWriter(basePath);
            fw0.write("Yo sólo puedo mostrarte la puerta\n");
            fw0.write("Tú eres quien la tiene que atravesar");
            fw0.close();
        }else{
            File f2 = new File(basePath);
            f2.createNewFile();
            FileWriter fw1 = new FileWriter(basePath);
            fw1.write("Yo sólo puedo mostrarte la puerta\n");
            fw1.write("Tú eres quien la tiene que atravesar");
            fw1.close();

        }
    }

}
