import java.io.File;

public class PR122cat {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/src/";
        // Comprovar si una ruta és un directori
        if (!basePath.equals("")){
            File f1 = new File(basePath);
        boolean esDirectori = f1.isDirectory();
        if (esDirectori) {
            System.out.println("La ruta \"" + f1.getName() + "\" és un directori");
        } else {
            System.out.println("La ruta \"" + f1.getName() + "\" NO és un directori");
        }
        // Comprovar si una ruta és un arxiu
        boolean esArxiu = f1.isFile();
        if (esArxiu) {
            System.out.println("La ruta \"" + f1.getName() + "\" és un arxiu");
        } else {
            System.out.println("La ruta \"" + f1.getName() + "\" NO és un arxiu");
        }
        }else{
            System.out.println("Está vacio el path");
        }
        
}   }
