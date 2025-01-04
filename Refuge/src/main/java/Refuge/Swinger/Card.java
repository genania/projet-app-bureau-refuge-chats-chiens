package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Refuge.Model.Animal;
import Refuge.View.Page.PageAnimalDetails;

public class Card extends JPanel {
  private Frame frame;
  public static final Size size = new Size(0.2, 0.2);
  private Animal animal;

  public Card(Animal animal, double x, double y) {
    this.frame = new Frame(x, y, size.getwidth(), size.getheight());
    this.animal = animal;

    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    // Panel pour les informations textuelles
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    infoPanel.setOpaque(false);

    // Ajouter les informations avec un espacement et un style de police en gras
    addInfoLabel(infoPanel, "Nom : " + animal.getNom());
    addInfoLabel(infoPanel, "Type : " + animal.getEspece());
    addRaceInfoLabel(infoPanel, "Race :", animal.getRace());
    addInfoLabel(infoPanel, "Age : " + animal.getAgeMois() + " mois");
    addInfoLabel(infoPanel, "Sexe : " + (animal.getSexe().equals("M") ? "Mâle" : "Femelle"));
    addRaceInfoLabel(infoPanel, "Couleur : ", animal.getCouleur());
    addInfoLabel(infoPanel, "Stérilisé : " + (animal.isSterilise() ? "Oui" : "Non"));
    addInfoLabel(infoPanel, "Vacciné : " + (animal.isVaccine() ? "Oui" : "Non"));

    // Configurer les contraintes pour le panel d'information
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 0.5;
    gbc.weighty = 1.0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(10, 10, 10, 10);
    add(infoPanel, gbc);

    // Créer et ajouter l'image avec des dimensions plus grandes
    JLabel imageLabel = createImageLabel(animal.getCheminPhotos().get(0), 400, 400);
    if (imageLabel != null) {
      JPanel imageContainer = new JPanel(new GridBagLayout());
      imageContainer.setPreferredSize(new Dimension(420, 420));
      imageContainer.setMinimumSize(new Dimension(400, 400));
      imageContainer.setOpaque(false);
      imageContainer.add(imageLabel);

      // Configurer les contraintes pour l'image
      gbc.gridx = 1;
      gbc.weightx = 0.5;
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.fill = GridBagConstraints.BOTH;
      add(imageContainer, gbc);
    }

    customize();
    setupMouseListeners();
  }

  private void addInfoLabel(JPanel panel, String text) {
    JLabel label = new JLabel(text);
    label.setAlignmentX(Component.LEFT_ALIGNMENT);
    label.setFont(new Font("Arial", Font.BOLD, 16)); // Police en gras et taille 16
    panel.add(label);
    panel.add(Box.createRigidArea(new Dimension(0, 24))); // Ajout d'un espacement vertical de 8 pixels
  }

  private void addRaceInfoLabel(JPanel panel, String label, String value) {
    JLabel raceLabel = new JLabel("<html><b>" + label + "</b><br>" + value + "</html>");
    raceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    raceLabel.setFont(new Font("Arial", Font.BOLD, 16));
    panel.add(raceLabel);
    panel.add(Box.createRigidArea(new Dimension(0, 24)));
  }

  private void customize() {
    setBounds(frame.toRectangle());
    setBackground(Palette.PURPLE);
    setForeground(Palette.LIGHT0_SOFT);
    setFont(Text.MEDIUM_TEXT);
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Limiter la largeur des cartes
    setMinimumSize(new Dimension(400, 250));
    setPreferredSize(new Dimension(500, 300));
    setMaximumSize(new Dimension(600, 350));
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
