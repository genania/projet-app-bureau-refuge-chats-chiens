package Refuge.Swinger;

import javax.swing.*;
import Refuge.App;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Icon extends JPanel {
  private final int SIZE = 256;
  private Frame frame;
  private BufferedImage originalImage;
  private BufferedImage coloredImage;
  private Color currentColor = Palette.RED;
  private Color hover = Palette.YELLOW;
  private Color background = Palette.RED;

  public Icon(String resourcePath, double x, double y, double size) {
    double ratio = App.getSize().getHeight() / App.getSize().getWidth();
    // double iconSize = 0.15;
    double xIcon = (1 - size * ratio) / (1 / x);

    double width = size * ((double) App.getSize().getHeight() / (double) App.getSize().getWidth());
    this.frame = new Frame(xIcon, y, width, size);
    Rectangle rect = this.frame.toRectangle();
    setBounds(rect);
    setBackground(Palette.AQUA);
    setColor(Palette.LIGHT1);

    try {
      // Load original image
      originalImage = ImageIO.read(getClass().getResourceAsStream(resourcePath));

      // Create colored image with correct dimensions
      coloredImage = new BufferedImage(rect.width, rect.height,
          BufferedImage.TYPE_INT_ARGB);

      // Initial draw of the colored image
      updateColoredImage();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addClick(Runnable action) {
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        action.run();
      }
    });
  }

  public void setColor(Color color) {
    this.currentColor = color;
    updateColoredImage();
    repaint();
  }

  public void setHoverColor(Color color) {
    hover = color;
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        setBackground(hover);
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        setBackground(background);
      }
    });
  }

  public void setBackgroundColor(Color color) {
    super.setBackground(color);
    background = color;
  }

  private void updateColoredImage() {
    if (originalImage == null || coloredImage == null)
      return;

    Graphics2D g2d = coloredImage.createGraphics();
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    // Clear previous image
    g2d.setComposite(AlphaComposite.Clear);
    g2d.fillRect(0, 0, coloredImage.getWidth(), coloredImage.getHeight());
    g2d.setComposite(AlphaComposite.SrcOver);

    // Draw resized original
    g2d.drawImage(originalImage, 0, 0, coloredImage.getWidth(), coloredImage.getHeight(), null);

    // Apply color to white areas while preserving transparency
    int rgb = currentColor.getRGB();
    for (int x = 0; x < coloredImage.getWidth(); x++) {
      for (int y = 0; y < coloredImage.getHeight(); y++) {
        int pixel = coloredImage.getRGB(x, y);
        int alpha = (pixel >> 24) & 0xff;
        if (alpha > 0) {
          int r = (pixel >> 16) & 0xff;
          int g = (pixel >> 8) & 0xff;
          int b = pixel & 0xff;
          if (r > 200 && g > 200 && b > 200) {
            coloredImage.setRGB(x, y, (alpha << 24) | (rgb & 0x00ffffff));
          }
        }
      }
    }
    g2d.dispose();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (coloredImage != null) {
      g.drawImage(coloredImage, 0, 0, getWidth(), getHeight(), null);
    }
  }

  public int getSIZE() {
    return SIZE;
  }

  public Frame getFrame() {
    return frame;
  }
}
