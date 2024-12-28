package Refuge.View.Page;

import Refuge.Model.Animal;
import Refuge.Swinger.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class PageAnimalDetails {
    private static final double PHOTO_RATIO_WIDTH = 0.35;
    private static final double PHOTO_RATIO_HEIGHT = 0.45;
    private static final double INFO_RATIO_WIDTH = 0.4;
    private static final double INFO_RATIO_HEIGHT = 0.6;

    public static void open(Window window, Animal animal) {
        clear(window);

        double labelWidthRatio = 0.3;
        int windowWidth = window.getSize().width;
        double xCenter = (1 - labelWidthRatio) / 2;

        // Titre
        Label titleLabel = new Label(animal.getNom(), xCenter, 0.08, 0.3, 0.05);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Palette.LIGHT0_SOFT);
        window.put(titleLabel);

        // Image
        JLabel imageLabel = createScaledImageLabel(animal.getCheminPhotos().get(0),
                window.getSize().width * PHOTO_RATIO_WIDTH,
                window.getSize().height * PHOTO_RATIO_HEIGHT);

        if (imageLabel != null) {
            Frame photoFrame = new Frame(0.1, 0.15, PHOTO_RATIO_WIDTH, PHOTO_RATIO_HEIGHT);
            imageLabel.setBounds(photoFrame.toRectangle());
            imageLabel.setBackground(Palette.DARK1);
            imageLabel.setOpaque(true);
            window.put(imageLabel);
        }

        // Panneau d'informations
        Frame infoFrame = new Frame(0.55, 0.15, INFO_RATIO_WIDTH, INFO_RATIO_HEIGHT);
        JPanel infoPanel = new JPanel(null);
        infoPanel.setBounds(infoFrame.toRectangle());
        infoPanel.setBackground(Palette.DARK1);
        infoPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Palette.LIGHT0_SOFT, 1),
                "Informations", 0, 0, Text.MEDIUM_TEXT, Palette.LIGHT0_SOFT));

        // Informations de base (inchangées)
        addInfoLabel(infoPanel, "<html><b>Identification:</b> " + animal.getIdentification() + "</html>", 0.05);
        addInfoLabel(infoPanel, "<html><b>Espèce:</b> " + animal.getEspece() + "</html>", 0.10);
        addInfoLabel(infoPanel, "<html><b>Âge:</b> " + animal.getAgeMois() + " mois</html>", 0.15);
        addInfoLabel(infoPanel, "<html><b>Race:</b> " + animal.getRace() + "</html>", 0.20);
        addInfoLabel(infoPanel, "<html><b>Sexe:</b> " + (animal.getSexe().equals("M") ? "Mâle" : "Femelle") + "</html>",
                0.25);
        addInfoLabel(infoPanel, "<html><b>Couleur:</b> " + animal.getCouleur() + "</html>", 0.30);
        addInfoLabel(infoPanel, "<html><b>Stérilisé:</b> " + (animal.isSterilise() ? "Oui" : "Non") + "</html>", 0.35);
        addInfoLabel(infoPanel, "<html><b>Vacciné:</b> " + (animal.isVaccine() ? "Oui" : "Non") + "</html>", 0.40);

        // Description simple avec Label
        Label descriptionLabel = new Label("<html><b>Description:</b></html>", 0.05, 0.45, 0.9, 0.05);
        descriptionLabel.setForeground(Palette.LIGHT0_SOFT);
        descriptionLabel.setFont(Text.SMALL_TEXT);
        infoPanel.add(descriptionLabel);

        // Zone de description avec JTextArea
        Label descriptionText = new Label(animal.getDescription(), 0.05, 0.50, 0.9, 0.45);
        descriptionText.setForeground(Palette.LIGHT0_SOFT);
        descriptionText.setFont(Text.SMALL_TEXT);
        descriptionText.setVerticalAlignment(SwingConstants.TOP);
        infoPanel.add(descriptionText);

        window.put(infoPanel);

        // Bouton retour
        Button backButton = new Button("Retour", 0.05, 0.06, 0.1, 0.04);
        backButton.addActionListener(e -> {
            NavigationManager.navigateTo(window, () -> PageAnimalDetails.open(window, animal));
        });
        window.put(backButton);
    }

    private static void addInfoLabel(JPanel panel, String text, double y) {
        Label label = new Label(text, 0.05, y, 0.9, 0.05);
        label.setForeground(Palette.LIGHT0_SOFT);
        label.setFont(Text.SMALL_TEXT);
        panel.add(label);
    }

    private static void clear(Window window) {
        window.clear();
    }

    private static JLabel createScaledImageLabel(String imagePath, double maxWidth, double maxHeight) {
        try {
            java.net.URL imageUrl = PageAnimalDetails.class.getClassLoader().getResource(imagePath);
            if (imageUrl == null) {
                System.err.println("Image introuvable dans le classpath : " + imagePath);
                return null;
            }

            ImageIcon originalIcon = new ImageIcon(imageUrl);
            int originalWidth = originalIcon.getIconWidth();
            int originalHeight = originalIcon.getIconHeight();

            double ratio = Math.min(maxWidth / originalWidth, maxHeight / originalHeight);
            int newWidth = (int) (originalWidth * ratio);
            int newHeight = (int) (originalHeight * ratio);

            Image scaledImage = originalIcon.getImage().getScaledInstance(
                    newWidth, newHeight, Image.SCALE_SMOOTH);

            JLabel label = new JLabel(new ImageIcon(scaledImage));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            return label;
        } catch (Exception e) {
            System.err.println("Erreur de chargement de l'image : " + imagePath);
            e.printStackTrace();
            return null;
        }
    }
}