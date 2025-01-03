package Refuge.View.Page;

import Refuge.Model.Animal;
import Refuge.Swinger.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Cursor;
import java.util.List;

public class PageAnimalDetails {
    private static final double PHOTO_RATIO_WIDTH = 0.35;
    private static final double PHOTO_RATIO_HEIGHT = 0.45;
    private static final double INFO_RATIO_WIDTH = 0.4;
    private static final double INFO_RATIO_HEIGHT = 0.6;
    private static final double THUMBNAIL_SIZE = 0.07;
    private static final int THUMBNAIL_SPACING = 10;

    public static void open(Window window, Animal animal) {
        clear(window);

        double labelWidthRatio = 0.3;
        double xCenter = (1 - labelWidthRatio) / 2;

        // Titre
        Label titleLabel = new Label(animal.getNom(), xCenter, 0.08, 0.3, 0.05);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 38));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Palette.LIGHT0_SOFT);
        window.put(titleLabel);

        // Conteneur pour la photo principale
        Frame photoFrame = new Frame(0.1, 0.15, PHOTO_RATIO_WIDTH, PHOTO_RATIO_HEIGHT);
        JPanel photoContainer = new JPanel();
        photoContainer.setLayout(null);
        photoContainer.setBounds(photoFrame.toRectangle());
        photoContainer.setBackground(Palette.DARK1);

        // Image principale
        JLabel mainImageLabel = createScaledImageLabel(
                animal.getCheminPhotos().get(0),
                window.getSize().width * PHOTO_RATIO_WIDTH,
                window.getSize().height * PHOTO_RATIO_HEIGHT);

        if (mainImageLabel != null) {
            mainImageLabel.setBounds(0, 0, photoFrame.toRectangle().width, photoFrame.toRectangle().height);
            photoContainer.add(mainImageLabel);
            System.out.println("Grosse photo ajoutée avec succès.");
        } else {
            System.err.println("Échec du chargement de la grosse photo : " + animal.getCheminPhotos().get(0));
        }

        System.out.println("Dimensions du conteneur photo : " + photoContainer.getBounds());
        window.put(photoContainer);
        photoContainer.revalidate();
        photoContainer.repaint();

        // Conteneur pour les miniatures
        Frame thumbnailFrame = new Frame(0.1, 0.61, PHOTO_RATIO_WIDTH, 0.25);
        JPanel thumbnailsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, THUMBNAIL_SPACING, 0)); // Alignement en
                                                                                                    // haut
        thumbnailsPanel.setBounds(thumbnailFrame.toRectangle());
        thumbnailsPanel.setBackground(Palette.DARK1);

        // Création des miniatures
        List<String> photos = animal.getCheminPhotos();
        for (String photoPath : photos) {
            JLabel thumbnail = createScaledImageLabel(
                    photoPath,
                    window.getSize().width * THUMBNAIL_SIZE,
                    window.getSize().width * THUMBNAIL_SIZE);

            if (thumbnail != null) {
                thumbnail.setBorder(BorderFactory.createLineBorder(Palette.LIGHT0_SOFT, 1));
                thumbnail.setCursor(new Cursor(Cursor.HAND_CURSOR));

                // Référence finale pour le lambda
                final String finalPhotoPath = photoPath;
                thumbnail.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        JLabel newMainImage = createScaledImageLabel(
                                finalPhotoPath,
                                window.getSize().width * PHOTO_RATIO_WIDTH,
                                window.getSize().height * PHOTO_RATIO_HEIGHT);
                        if (newMainImage != null) {
                            photoContainer.removeAll();
                            newMainImage.setBounds(0, 0, photoFrame.toRectangle().width,
                                    photoFrame.toRectangle().height);
                            photoContainer.add(newMainImage);
                            photoContainer.revalidate();
                            photoContainer.repaint();
                        }
                    }
                });

                thumbnailsPanel.add(thumbnail);
            }
        }

        // Ajoutez le panneau au conteneur principal
        window.put(thumbnailsPanel);

        // Panneau d'informations
        Frame infoFrame = new Frame(0.55, 0.15, INFO_RATIO_WIDTH, INFO_RATIO_HEIGHT);
        JPanel infoPanel = new JPanel(null);
        infoPanel.setBounds(infoFrame.toRectangle());
        infoPanel.setBackground(Palette.DARK1);
        infoPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Palette.LIGHT0_SOFT, 1),
                "Informations", 0, 0, Text.MEDIUM_TEXT, Palette.LIGHT0_SOFT));

        // Informations de base
        addInfoLabel(infoPanel, "<html><b>Identification:</b> " + animal.getIdentification() + "</html>", 0.05);
        addInfoLabel(infoPanel, "<html><b>Espèce:</b> " + animal.getEspece() + "</html>", 0.10);
        addInfoLabel(infoPanel, "<html><b>Âge:</b> " + animal.getAgeMois() + " mois</html>", 0.15);
        addInfoLabel(infoPanel, "<html><b>Race:</b> " + animal.getRace() + "</html>", 0.20);
        addInfoLabel(infoPanel, "<html><b>Sexe:</b> " + (animal.getSexe().equals("M") ? "Mâle" : "Femelle") + "</html>",
                0.25);
        addInfoLabel(infoPanel, "<html><b>Couleur:</b> " + animal.getCouleur() + "</html>", 0.30);
        addInfoLabel(infoPanel, "<html><b>Stérilisé:</b> " + (animal.isSterilise() ? "Oui" : "Non") + "</html>", 0.35);
        addInfoLabel(infoPanel, "<html><b>Vacciné:</b> " + (animal.isVaccine() ? "Oui" : "Non") + "</html>", 0.40);
        // Remplacez la section de description par ceci :
        addInfoLabel(infoPanel,
                "<html><div style='width: 45%; text-align: justify; text-justify: inter-word; white-space: normal; line-height: 1.4;'><b>Description:</b> "
                        + animal.getDescription() + "</div></html>",
                0.45, 0.5);

        window.put(infoPanel);

        // Bouton retour
        Button backButton = new Button("Retour", 0.05, 0.06, 0.1, 0.04);
        backButton.addActionListener(e -> {
            NavigationManager.navigateTo(window, () -> PageAnimalDetails.open(window, animal));
        });
        window.put(backButton);
    }

    private static void addInfoLabel(JPanel panel, String text, double y, double height) {
        Label label = new Label(text, 0.02, y, 0.96, height); // Réduire la marge gauche (0.02) et ajuster la largeur
                                                              // (0.96)
        label.setForeground(Palette.LIGHT0_SOFT);
        label.setFont(Text.SMALL_TEXT);
        label.setVerticalAlignment(SwingConstants.TOP);
        panel.add(label);
    }

    // Gardez l'ancienne méthode pour la compatibilité avec les autres labels
    private static void addInfoLabel(JPanel panel, String text, double y) {
        addInfoLabel(panel, text, y, 0.05);
    }

    private static void clear(Window window) {
        window.clear();
    }

    private static JLabel createScaledImageLabel(String imagePath, double maxWidth, double maxHeight) {
        try {
            System.out.println("Chargement de l'image : " + imagePath);
            java.net.URL imageUrl = PageAnimalDetails.class.getClassLoader().getResource(imagePath);
            if (imageUrl == null) {
                System.err.println("Image introuvable dans le classpath : " + imagePath);
                return null;
            }

            ImageIcon originalIcon = new ImageIcon(imageUrl);
            int originalWidth = originalIcon.getIconWidth();
            int originalHeight = originalIcon.getIconHeight();

            // Calculez le ratio tout en respectant les dimensions maximales
            double ratio = Math.min(maxWidth / originalWidth, maxHeight / originalHeight);
            int newWidth = (int) (originalWidth * ratio);
            int newHeight = (int) (originalHeight * ratio);
            System.out.println("Dimensions redimensionnées : " + newWidth + "x" + newHeight);

            // Redimensionnez l'image
            Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // Créez le JLabel et centrez-le dans son conteneur
            JLabel label = new JLabel(new ImageIcon(scaledImage));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            return label;
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'image : " + imagePath);
            e.printStackTrace();
            return null;
        }
    }

}
