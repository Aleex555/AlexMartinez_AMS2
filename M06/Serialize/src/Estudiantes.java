import java.io.RandomAccessFile;


public class Estudiantes {
    private static final int ID_SIZE = 4; // bytes
    private static final int NOTA = 4; 
    private static final int CHAR_SIZE = 2; // bytes per caràcter en UTF-16
    private static final int NAME_SIZE = 20; // Longitud màxima en caràcters del nom


    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("./data/estudiantes.dat", "rw")) {
            // Afegir videojocs
            afegirVideojoc(raf, 1, "Assassin's Creed",13.3f);
            afegirVideojoc(raf, 2, "Assassin' Creed",13.45f);
            mostrarVideojoc(raf, 1);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    


    public static void afegirVideojoc(RandomAccessFile raf, int id, String nom, float nota) throws Exception {
        raf.seek(raf.length());
        raf.writeInt(id);
        raf.writeChars(getPaddedName(nom));
        raf.writeFloat(nota); // Usar writeFloat para la nota
    }
    
    public static String consultarVideojoc(RandomAccessFile raf, int id) throws Exception {
        raf.seek(getSeekPosition(id));
        raf.readInt();
        String name = raf.readUTF(); // Usar readUTF para el nombre
        float grade = raf.readFloat(); // Usar readFloat para la nota
        return name+" "+grade;
    }
    


    public static void actualitzarNomVideojoc(RandomAccessFile raf, int id, String nouNom) throws Exception {
        raf.seek(getSeekPosition(id) + ID_SIZE);
        raf.writeChars(getPaddedName(nouNom));
    }


    public static void mostrarVideojoc(RandomAccessFile raf, int id) throws Exception {
        System.out.println(id + ": " + consultarVideojoc(raf, id));
    }


    /**
     * Calcula la posició (offset) dins del fitxer on s'inicia el registre del videojoc amb l'ID especificat.
     *
     * @param id L'identificador del videojoc.
     * @return La posició dins del fitxer on s'inicia el registre del videojoc.
     */
    private static long getSeekPosition(int id) {
        // L'operació (id - 1) serveix per obtenir un índex basat en 0.
        // (ID_SIZE + NAME_SIZE * CHAR_SIZE) calcula la mida total en bytes d'un registre de videojoc.
        // ID_SIZE representa la mida en bytes de l'ID del videojoc.
        // NAME_SIZE * CHAR_SIZE representa la mida total en bytes del nom del videojoc.
        return (id - 1) * (ID_SIZE + NAME_SIZE* CHAR_SIZE+NOTA);
    }


    /**
     * Retorna una versió del nom del videojoc que sempre té una longitud fixa (NAME_SIZE).
     * Si el nom és més llarg que NAME_SIZE, es trunca. Si és més curt, s'omple amb espais en blanc.
     *
     * @param name El nom original del videojoc.
     * @return El nom amb una longitud fixa de NAME_SIZE caràcters.
     */
    private static String getPaddedName(String name) {
        // Si el nom és més llarg que la mida màxima permesa (NAME_SIZE),
        // es trunca per ajustar-se a aquesta mida.
        if (name.length() > NAME_SIZE) {
            return name.substring(0, NAME_SIZE);
        }
        // Si el nom és més curt que NAME_SIZE, s'omple amb espais en blanc fins a assolir aquesta mida.
        // String.format amb "%1$-" + NAME_SIZE + "s" assegura que la cadena resultant tingui una longitud fixa
        return String.format("%1$-" + NAME_SIZE + "s", name);
    }
}
