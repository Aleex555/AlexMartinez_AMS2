import java.io.File;
import java.io.IOException;

public class PR121Files {
    public static void main(String args[]) throws IOException {
        String basePath = System.getProperty("user.dir") + "/myFiles/";
            // Crear la carpeta 'myFiles' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'myFiles'");
            }
        }
        // Crear un arxiu
        File f1 = new File(basePath + "file1.txt");
        File f2 = new File(basePath + "file2.txt");
        boolean arxiuCreat = f1.createNewFile();
        boolean arxiuCreat2 = f2.createNewFile();
        if (arxiuCreat) {
            System.out.println("S'ha creat l'arxiu \"" + f1.getName() + "\"");
        } else {
            System.out.println("No s'ha pogut crear l'arxiu \"" + f1.getName() + "\"");
        }
        if (arxiuCreat2){
            System.out.println("S'ha creat l'arxiu \"" + f2.getName() + "\"");
        } else {
            System.out.println("No s'ha pogut crear l'arxiu \"" + f2.getName() + "\"");
        }


        File f2renamed = new File(basePath+"renamedFile.txt");
        if (f2.renameTo(f2renamed)) {
            System.out.println("Ya esta renombrado \"" + f2.getName() + "\"");
        } else {
            System.out.println("No s'ha pogut renombrar l'arxiu \"" + f2.getName() + "\"");
        }

        File carpeta1 = new File(basePath);
        if (carpeta1.isDirectory()){
            File[] archivos = carpeta1.listFiles();
            System.out.println("Los archivos son: ");
            for(File archivo: archivos){
                System.out.println(archivo.getName());
            } 
        }else{
            System.out.println("No existe la carpeta");
        }

        f1.delete();
        
        if (carpeta1.isDirectory()){
            File[] archivos = carpeta1.listFiles();
            System.out.println("\nLos archivos son: ");
            for(File archivo: archivos){
                System.out.println(archivo.getName());
            } 
        }else{
            System.out.println("No existe la carpeta");
        }


    

        System.out.println("");
    }

    
}
