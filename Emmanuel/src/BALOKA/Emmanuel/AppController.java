package BALOKA.Emmanuel;

import javax.swing.*;
import java.util.List;

public class AppController {
    private FileService fileService;
    private MainFrame mainFrame;

    public AppController() {
        fileService = new FileService();
        mainFrame = new MainFrame(this);
        chargerListe();
    }

    public void ajouterObjet() {
        String titre = JOptionPane.showInputDialog("Titre de l'objet :");
        String auteur = JOptionPane.showInputDialog("Auteur de l'objet :");
        if (titre != null && auteur != null && !titre.isEmpty() && !auteur.isEmpty()) {
            ObjetLocation objet = new ObjetLocation(titre, auteur);
            fileService.ajouterObjet(objet);
            chargerListe();
        }
    }

    public void supprimerObjet(String titre) {
        int confirm = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cet objet ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            fileService.supprimerObjet(titre);
            chargerListe();
        }
    }

    public void chargerListe() {
        List<ObjetLocation> objets = fileService.lireObjets();
        mainFrame.afficherListe(objets);
    }

    public void lancerApplication() {
        mainFrame.setVisible(true);
    }
}
