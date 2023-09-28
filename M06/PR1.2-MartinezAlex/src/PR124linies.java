import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PR124linies {
    public static void main(String args[]) throws IOException {
        String basePath = System.getProperty("user.dir") + "/src/";
        Random rand = new Random();
        File f1 = new File(basePath+"numeros.txt");
        if(!f1.exists()){
            f1.createNewFile();
            FileWriter fw1 = new FileWriter(f1,true);
            for (int i = 0; i < 10; i++) {
                fw1.write(rand.nextInt(100)+1+"\n");
            }
            fw1.close();
        }else{
            FileWriter fw1 = new FileWriter(f1);
            for (int i = 0; i < 10; i++) {
                fw1.write(rand.nextInt(100)+1+"\n");
            }
            fw1.close();
        }

    }

}
