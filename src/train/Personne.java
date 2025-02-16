package train;

public class Personne {
    private static int compteurC = 1;
    private int numC;
    private String nom;
    private String prenom;

    public Personne( String nom , String prenom ) {
        this.numC = compteurC++;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getNumC() {
        return numC;
    }
    public void setNumC(int numC) {
        this.numC = numC;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personne{\n");
        sb.append("numC=").append(numC);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append("\n}\n");
        return sb.toString();
    }
}
