package BALOKA.Emmanuel;

public class ObjetLocation {
    private String titre;
    private String auteur;

    public ObjetLocation(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return titre + "|" + auteur;
    }

    public static ObjetLocation fromString(String ligne) {
        String[] parts = ligne.split("\\|");
        return new ObjetLocation(parts[0], parts[1]);
    }
}
