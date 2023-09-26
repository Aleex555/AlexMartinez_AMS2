package PR1;

public class PR431Objecte {
    private static PR431Objecte instance;
    private String nom;
    private String cognom;
    private Integer edat;

    private PR431Objecte(String nom, String cognom, Integer edat) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.cognom=cognom;
        this.edat=edat;
        this.nom=nom;
    }

    public static PR431Objecte getInstance(String nom, String cognom, Integer edat) {
        if (instance == null) {
            instance = new PR431Objecte(nom,cognom,edat);
        }
        return instance;
        
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return this.cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public Integer getEdat() {
        return this.edat;
    }

    public void setEdat(Integer edat) {
        this.edat = edat;
    }



    @Override
    public String toString() {
        return
            " nom='" + getNom() + "'" +
            ", cognom='" + getCognom() + "'" +
            ", edat='" + getEdat() + "'";
    }

}
