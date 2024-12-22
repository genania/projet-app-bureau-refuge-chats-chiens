package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Refuge.Model.Animal;

public class Card extends JPanel {
  private Frame frame;
  public static final Size size = new Size(0.1, 0.1);

  private Animal animal;

  public Card(Animal animal, double x, double y) {
    this.frame = new Frame(x, y, size.getwidth(), size.getheight());
    this.animal = animal;

    customize();

    add(new Label("Nom : " + animal.getNom(), 0.0, 0.0, 0.5, 0.1));
    add(new Label("Type : " + animal.getEspece(), 0.0, 0.025, 0.5, 0.1));
    add(new Label("Age : " + animal.getAgeMois(), 0.0, 0.05, 0.5, 0.1));
    add(new Label("Race : " + animal.getRace(), 0.0, 0.075, 0.5, 0.1));

    // Add hover effect
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        setBackground(Palette.ORANGE);
        repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
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
}
