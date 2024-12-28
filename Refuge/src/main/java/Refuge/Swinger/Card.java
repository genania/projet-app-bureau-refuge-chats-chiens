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

    customize();

    add(new Label("Nom : " + animal.getNom(), 0.004, 0.0, 0.5, 0.1));
    add(new Label("Type : " + animal.getEspece(), 0.004, 0.025, 0.5, 0.1));
    add(new Label("Age : " + animal.getAgeMois() + " mois", 0.004, 0.05, 0.5, 0.1));
    add(new Label("Race : " + animal.getRace(), 0.004, 0.075, 0.5, 0.1));

    // Ajouter une logique pour afficher "Mâle" ou "Femelle"
    String sexe = animal.getSexe().equals("M") ? "Mâle" : "Femelle";
    add(new Label("Sexe : " + sexe, 0.004, 0.1, 0.5, 0.1));
    String sterile = animal.isSterilise() ? "Oui" : "Non";
    add(new Label("Stérilisé : " + sterile, 0.004, 0.125, 0.5, 0.1));

    // Ajout de la photo de l'animal avec des dimensions ajustées et position collée
    // à droite
    JLabel imageLabel = createImageLabel(animal.getCheminPhotos().get(0), 300, 300); // Augmenter les dimensions
    if (imageLabel != null) {
      int cardHeight = this.getHeight(); // Hauteur de la carte
      int imageHeight = 300; // Hauteur de l'image
      int yCenter = (cardHeight - imageHeight) / 2; // Calcul pour centrer verticalement

      imageLabel.setBounds(this.getWidth() - 320, yCenter, 300, 300); // Ajuster uniquement la position verticale
      add(imageLabel);
    }

    // Add hover effect
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
          // Récupérer la fenêtre parente
          Window window = (Window) SwingUtilities.getWindowAncestor(Card.this);
          // Ouvrir la page de détails
          PageAnimalDetails.open(window, animal);
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // Vérifier que l'animal a une couleur valide avant d'appliquer le changement
        Color hoverColor = Palette.BRIGHT_ORANGE; // Exemple de couleur claire
        setBackground(hoverColor);
        repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // Revenir à la couleur de fond d'origine
        setBackground(animal.getColor());
        repaint();
      }
    });
  }

  public void customize() {
    setLayout(null);
    setBounds(frame.toRectangle());
    setBackground(Palette.PURPLE);
    setForeground(Palette.LIGHT0_SOFT);
    setFont(Text.MEDIUM_TEXT);
  }

  private JLabel createImageLabel(String imagePath, int targetWidth, int targetHeight) {
    try {
      // Charger l'image
      java.net.URL imageUrl = getClass().getClassLoader().getResource(imagePath);
      if (imageUrl == null) {
        System.err.println("Image introuvable dans le classpath : " + imagePath);
        return null;
      }

      ImageIcon imageIcon = new ImageIcon(imageUrl);
      Image originalImage = imageIcon.getImage();

      // Calcul des nouvelles dimensions tout en respectant les proportions
      int originalWidth = originalImage.getWidth(null);
      int originalHeight = originalImage.getHeight(null);
      double widthRatio = (double) targetWidth / originalWidth;
      double heightRatio = (double) targetHeight / originalHeight;
      double scaleRatio = Math.min(widthRatio, heightRatio); // Respect des proportions

      int newWidth = (int) (originalWidth * scaleRatio);
      int newHeight = (int) (originalHeight * scaleRatio);

      // Redimensionner l'image
      Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

      // Créer et retourner le JLabel avec l'image redimensionnée
      JLabel label = new JLabel(new ImageIcon(scaledImage));
      label.setHorizontalAlignment(SwingConstants.CENTER); // Centrer horizontalement
      label.setVerticalAlignment(SwingConstants.CENTER); // Centrer verticalement
      label.setPreferredSize(new Dimension(newWidth, newHeight)); // Fixer la taille préférée
      return label;
    } catch (Exception e) {
      System.err.println("Erreur de chargement de l'image : " + imagePath);
      e.printStackTrace();
      return null;
    }
  }

}
