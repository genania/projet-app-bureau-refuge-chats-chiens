package Refuge.Swinger;

import javax.swing.*;
import Refuge.App;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Photo extends JPanel {
  private Frame frame;
  private BufferedImage originalImage;
  private BufferedImage coloredImage;
  private Color currentColor = Palette.RED;
  private Color hover = Palette.YELLOW;
  private Color background = Palette.DARK2;

  public Photo(String resourcePath, double x, double y, double width, double height) {
    try {
      coloredImage = ImageIO.read(getClass().getResourceAsStream(resourcePath));

      this.frame = new Frame(
          x, y,
          coloredImage.getWidth() / App.getSize().getWidth(),
          coloredImage.getHeight() / App.getSize().getHeight());

      Rectangle rect = this.frame.toRectangle();
      setBounds(rect);
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

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (coloredImage != null) {
      g.drawImage(coloredImage, 0, 0, getWidth(), getHeight(), null);
    }
  }

  public Frame getFrame() {
    return frame;
  }
}
