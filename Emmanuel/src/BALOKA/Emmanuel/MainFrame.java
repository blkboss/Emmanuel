package BALOKA.Emmanuel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private AppController controller;
    
    private static final long serialVersionUID = 1L; 

    public MainFrame(AppController controller) {
        this.controller = controller;
        initUI();
    }

    private void initUI() {
        setTitle("Gestion de Location");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new String[]{"Titre", "Auteur"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton addButton = new JButton("Ajouter");
        JButton deleteButton = new JButton("Supprimer");

        addButton.addActionListener(e -> controller.ajouterObjet());
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String titre = tableModel.getValueAt(selectedRow, 0).toString();
                controller.supprimerObjet(titre);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void afficherListe(List<ObjetLocation> objets) {
        tableModel.setRowCount(0);
        for (ObjetLocation objet : objets) {
            tableModel.addRow(new Object[]{objet.getTitre(), objet.getAuteur()});
        }
    }
}
