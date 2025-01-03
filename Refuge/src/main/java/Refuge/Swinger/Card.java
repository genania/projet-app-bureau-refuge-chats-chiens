package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Refuge.Model.Animal;
import Refuge.View.Page.PageAnimalDetails;

public class Card extends JPanel {
  private Frame frame;
  public static final Size size = new Size(0.15, 0.15);
  private Animal animal;

  public Card(Animal animal, double x, double y) {
    this.frame = new Frame(x, y, size.getwidth(), size.getheight());
    this.animal = animal;

    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    // Panel pour les informations textuelles
    JPanel infoPanel = new JPanel(new GridLayout(6, 1, 5, 5));
    infoPanel.setOpaque(false);

    // Ajouter les informations
    infoPanel.add(new JLabel("Nom : " + animal.getNom()));
    infoPanel.add(new JLabel("Type : " + animal.getEspece()));
    infoPanel.add(new JLabel("Age : " + animal.getAgeMois() + " mois"));
    infoPanel.add(new JLabel("Race : " + animal.getRace()));
    String sexe = animal.getSexe().equals("M") ? "Mâle" : "Femelle";
    infoPanel.add(new JLabel("Sexe : " + sexe));
    String sterile = animal.isSterilise() ? "Oui" : "Non";
    infoPanel.add(new JLabel("Stérilisé : " + sterile));

    // Configurer les contraintes pour le panel d'information
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 0.4; // Réduit pour donner plus d'espace à l'image
    gbc.weighty = 1.0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(10, 10, 10, 10);
    add(infoPanel, gbc);

    // Créer et ajouter l'image avec des dimensions plus grandes
    JLabel imageLabel = createImageLabel(animal.getCheminPhotos().get(0), 300, 300); // Dimensions augmentées
    if (imageLabel != null) {
      // Panel conteneur pour l'image avec une taille fixe plus grande
      JPanel imageContainer = new JPanel(new GridBagLayout());
      imageContainer.setPreferredSize(new Dimension(320, 320)); // Dimensions augmentées
      imageContainer.setMinimumSize(new Dimension(300, 300)); // Taille minimum garantie
      imageContainer.setOpaque(false);
      imageContainer.add(imageLabel);

      // Configurer les contraintes pour l'image
      gbc.gridx = 1;
      gbc.weightx = 0.6; // Augmenté pour donner plus d'espace à l'image
      gbc.anchor = GridBagConstraints.CENTER; // Centré plutôt qu'à droite
      gbc.fill = GridBagConstraints.BOTH;
      add(imageContainer, gbc);
    }

    customize();
    setupMouseListeners();
  }

  private void customize() {
    setBounds(frame.toRectangle());
    setBackground(Palette.PURPLE);
    setForeground(Palette.LIGHT0_SOFT);
    setFont(Text.MEDIUM_TEXT);
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Définir une taille minimum pour la carte entière
    setMinimumSize(new Dimension(500, 200));
  }

  private void setupMouseListeners() {
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
          Window window = (Refuge.Swinger.Window) SwingUtilities.getWindowAncestor(Card.this);
          PageAnimalDetails.open(window, animal);
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        setBackground(Palette.BRIGHT_ORANGE);
        repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        setBackground(animal.getColor());
        repaint();
      }
    });
  }

  private JLabel createImageLabel(String imagePath, int targetWidth, int targetHeight) {
    try {
      java.net.URL imageUrl = getClass().getClassLoader().getResource(imagePath);
      if (imageUrl == null) {
        System.err.println("Image introuvable dans le classpath : " + imagePath);
        return null;
      }

      ImageIcon imageIcon = new ImageIcon(imageUrl);
      Image originalImage = imageIcon.getImage();

      // Calculer les dimensions en préservant les proportions
      int originalWidth = originalImage.getWidth(null);
      int originalHeight = originalImage.getHeight(null);
      double ratio = Math.min(
          (double) targetWidth / originalWidth,
          (double) targetHeight / originalHeight);

      int newWidth = (int) (originalWidth * ratio);
      int newHeight = (int) (originalHeight * ratio);

      Image scaledImage = originalImage.getScaledInstance(
          newWidth, newHeight, Image.SCALE_SMOOTH);

      JLabel label = new JLabel(new ImageIcon(scaledImage));
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setVerticalAlignment(SwingConstants.CENTER);

      return label;
    } catch (Exception e) {
      System.err.println("Erreur de chargement de l'image : " + imagePath);
      e.printStackTrace();
      return null;
    }
  }
}