package Refuge.Swinger;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JPanel;

import Refuge.App;
import Refuge.View.Modal.CreateAccountModal;
import Refuge.View.Page.PageLogin;
import Refuge.View.Page.PageWelcome;

public class Bar extends JPanel implements Palette {

  private Frame frame = new Frame();
  private Color color = DARK0_SOFT;
  private Size padding = new Size(0.01, 0.01);
  private double width = 0.14;
  public ArrayList<Button> buttons = new ArrayList<Button>(); // buttons
  private ArrayList<Button> boutonsDroits = new ArrayList<Button>(); // boutons à droite
  private ArrayList<Button> boutonsGauches = new ArrayList<Button>(); // boutons à gauche

  public Bar() {
    this.frame = new Frame(1.0, 0.05);

    setLayout(null);
    setBackground(this.color);
    setBounds(this.frame.toRectangle());
  }

  public void ajouterBoutonDroit(String name, Runnable action) {
    double others = this.boutonsDroits.size();
    double width = this.frame.getWidth() * this.width;

    Button button = new Button(
        name,
        1 - width - padding.getwidth() - padding.getwidth() * others - width * others,
        padding.getheight(),
        width,
        frame.getHeight() * 0.6);

    button.onClick(action);

    this.boutonsDroits.add(button);
    add(button);
  }

  public void ajouterBoutonGauche(String name, Runnable action) {
    double others = this.boutonsGauches.size();
    double width = this.frame.getWidth() * this.width;

    Button button = new Button(
        name,
        this.frame.getHeight() + padding.getwidth() + padding.getwidth() * others + width * others,
        padding.getheight(),
        width,
        frame.getHeight() * 0.6);

    button.onClick(action);

    this.boutonsGauches.add(button);
    add(button);
  }

  public void centerButtons() {
    double totalButtonWidth = 0.1; // Largeur approximative d'un bouton en % de la barre
    double buttonHeight = this.frame.getHeight() * 0.6; // Hauteur du bouton
    double gap = 0.02; // Espacement entre les boutons (en %)
    int buttonCount = buttons.size();

    // Calculer la position X de départ pour centrer les boutons
    double totalWidth = (totalButtonWidth * buttonCount) + (gap * (buttonCount - 1));
    double startX = (1.0 - totalWidth) / 2.0; // Centrage horizontal

    for (int i = 0; i < buttons.size(); i++) {
      Button button = buttons.get(i);
      button.setBounds(
          (int) (this.frame.getWidth() * (startX + i * (totalButtonWidth + gap))),
          (int) (this.frame.getHeight() * 0.2), // Décalage Y pour centrer verticalement
          (int) (this.frame.getWidth() * totalButtonWidth),
          (int) buttonHeight);
    }
  }

  public Frame getFrame() {
    return frame;
  }

  public void setFrame(Frame frame) {
    this.frame = frame;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Size getPadding() {
    return padding;
  }

  public void setPadding(Size padding) {
    this.padding = padding;
  }
}
