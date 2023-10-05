import java.io.Serializable;

public class PR132main{
    class PR132persona implements Serializable{
        String nom;
        String cognom;
        int edat;


        public PR132persona(String nom, String cognom,int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        }

    }

    public static void main(String args[]) {
        PR132main.PR132persona persona = new PR132main().new PR132persona("Cristian", "Alvarez", 12);
        PR132main.PR132persona persona2 = new PR132main().new PR132persona("Alex", "Martinez", 20);
        PR132main.PR132persona persona3 = new PR132main().new PR132persona("Yuheng", "Zhou", 25);
        PR132main.PR132persona persona4 = new PR132main().new PR132persona("Valeria", "Motos", 45);
    }

}
