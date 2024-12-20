package BALOKA.Emmanuel;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private final String filePath = "locations.txt";

    public void ajouterObjet(ObjetLocation objet) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(objet.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ObjetLocation> lireObjets() {
        List<ObjetLocation> objets = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                objets.add(ObjetLocation.fromString(ligne));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objets;
    }

    public void supprimerObjet(String titre) {
        List<ObjetLocation> objets = lireObjets();
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (ObjetLocation objet : objets) {
                if (!objet.getTitre().equalsIgnoreCase(titre)) {
                    writer.write(objet.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
