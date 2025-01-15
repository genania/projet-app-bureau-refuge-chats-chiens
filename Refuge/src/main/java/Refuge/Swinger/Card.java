package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Refuge.App;
import Refuge.Model.Animal;
import Refuge.View.Page.PageAnimalDetails;

public class Card extends JPanel {
  private Frame frame;
  private Animal animal;
  private Photo picture;

  public Card(Animal animal, double x, double y, double width, double height) {
    this.frame = new Frame(x, y, width, height);
    this.animal = animal;

    customize();

    int panelWidth = getWidth();
    int panelHeight = getHeight();

    JPanel panel = new JPanel();

    panel.setBounds(10, 10, panelWidth - 20, panelHeight - 20);
    panel.setLayout(null);
    panel.setBackground(Palette.DARK2);
    panel.setForeground(Palette.LIGHT1);

    Label name = new Label(animal.getNom(), 0.0, 0.0, panelWidth, panelHeight) {
      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        String text = getText();
        Font font = getFont();
        FontMetrics metrics = g2d.getFontMetrics(font);
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        // int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        int y = getHeight() / 2;
        // Draw the outline
        g2d.setColor(Palette.DARK2);
        g2d.setStroke(new BasicStroke((int) (panelWidth * 0.025)));

        Shape textShape = font.createGlyphVector(g2d.getFontRenderContext(), text).getOutline(x, y);
        g2d.draw(textShape);

        Color color = Palette.BLUE;

        if (animal.getSexe().equals("F")) {
          color = Palette.RED;
        }
        // Fill with white color
        g2d.setColor(color);
        g2d.fill(textShape);
      }
    };

    int optimalSize = panelWidth / (animal.getNom().length() - 1);
    Font currentFont = name.getFont();
    Font newFont = currentFont.deriveFont(Font.BOLD, (float) optimalSize);

    name.setBounds(0, (int) (panelHeight * 0.6375), panelWidth, (int) (panelHeight * 0.6));
    name.setAlign(1);
    name.setFont(newFont);

    add(name);

    picture = new Photo("/" + animal.getCheminPhotos().get(0), 0.0, 0.0, width, height);

    int pictureWidth = picture.getWidth();
    int pictureHeight = picture.getHeight();

    Dimension coverDimensions = calculateCoverDimensions(panelWidth, panelHeight,
        pictureWidth, pictureHeight);

    int pictureX = (panelWidth - coverDimensions.width) / 2;
    int pictureY = (panelHeight - coverDimensions.height) / 2;

    picture.setBounds(pictureX, pictureY, coverDimensions.width, coverDimensions.height);

    panel.add(picture);

    add(panel);
  }

  private void customize() {
    setLayout(null);
    setBounds(frame.toRectangle());
    setBackground(Palette.DARK2);
    setForeground(Palette.LIGHT1);
    setFont(Text.MEDIUM_TEXT);
    setupMouseListeners();
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
        setBackground(Palette.GRAY);
        repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        setBackground(Palette.DARK2);
        repaint();
      }
    });
  }

  private Dimension calculateCoverDimensions(int containerWidth, int containerHeight, int imageWidth, int imageHeight) {
    double containerRatio = (double) containerWidth / containerHeight;
    double imageRatio = (double) imageWidth / imageHeight;

    int resultWidth, resultHeight;

    if (imageRatio > containerRatio) {
      // Image is wider than container proportionally - scale based on height
      resultHeight = containerHeight;
      resultWidth = (int) (containerHeight * imageRatio);
    } else {
      // Image is taller than container proportionally - scale based on width
      resultWidth = containerWidth;
      resultHeight = (int) (containerWidth / imageRatio);
    }

    return new Dimension(resultWidth, resultHeight);
  }
}
