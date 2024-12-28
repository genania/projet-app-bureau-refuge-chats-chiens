package Refuge.View.Modal;

import javax.swing.*;
import java.awt.*;

public class HelpModal extends JDialog {

    public HelpModal(Frame parent) {
        super(parent, "Aide", true);

        // Définir une icône personnalisée pour le modal
        String iconPath = "/icones/help_icon.png";
        java.net.URL iconURL = getClass().getResource(iconPath);
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
        } else {
            System.err.println("Icône non trouvée : " + iconPath);
        }

        // Configuration de la fenêtre
        setSize(400, 300); // Taille fixe ajustée
        setLocationRelativeTo(parent); // Centrer la fenêtre

        // Panel principal avec fond moderne
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Titre stylisé
        JLabel titleLabel = new JLabel("Besoin d'aide ?", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Zone de texte d'aide
        JTextArea helpText = new JTextArea();
        helpText.setText("Voici quelques informations utiles pour vous aider :\n\n"
                + "1. Pour toute question technique, contactez le support.\n"
                + "2. Consultez la documentation pour plus de détails.\n"
                + "3. En cas de problème urgent, appelez le 450-654-6789.\n");
        helpText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        helpText.setEditable(false);
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);
        helpText.setBackground(new Color(245, 245, 245));
        JScrollPane scrollPane = new JScrollPane(helpText);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bouton pour fermer le modal
        JButton closeButton = new JButton("Fermer");
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(new Color(33, 150, 243));
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        closeButton.addActionListener(e -> dispose());
        mainPanel.add(closeButton, BorderLayout.SOUTH);

        // Ajouter le panel principal dans la fenêtre
        add(mainPanel);
    }
}
