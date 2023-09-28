import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PR120ReadFile {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/src/";
        String fileName = "PR120ReadFile.java";
        String filePath = basePath + fileName;
        int i=0;
        try {
            List<String> linies = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            for (int cnt = 0; cnt < linies.size(); cnt = cnt + 1) {
                i++;
                System.out.println(i+" "+linies.get(cnt));
            }
        } catch (IOException e) { e.printStackTrace(); }

    }
}
