package Refuge.Swinger;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JPanel;

import Refuge.App;
import Refuge.View.Login;
import Refuge.View.Welcome;

public class Bar extends JPanel implements Palette {

  private Frame frame = new Frame();
  private Color color = DARK0_SOFT;
  private Size padding = new Size(0.01, 0.01);
  public ArrayList<Button> buttons = new ArrayList<Button>(); // buttons

  public Bar() {

    this.frame = new Frame(1.0, 0.05);

    setLayout(null);
    setBackground(this.color);
    setBounds(this.frame.toRectangle());

    addLogo();
    addAccount();
  }

  private void addLogo() {
    Icon icon = new Icon("/icones/placeholder.png", 0.01, 0.0075, this.frame.getHeight() / 2.0);

    icon.setBackgroundColor(this.color);
    icon.setColor(Palette.LIGHT0_SOFT);

    icon.addClick(() -> {
      App.getWindow().clear();
      Welcome.open(App.getWindow());
    });
    icon.setHoverColor(Palette.YELLOW);
    add(icon);
  }

  private void addAccount() {
    Label name = new Label(Login.getAccount().getUsername(), 0.925, 0.015, 0.1, 0.1);

    add(name);
  }

  public void addButton(String name) {
    double others = this.buttons.size();
    double width = this.frame.getWidth() * 0.1;

    Button button = new Button(
        name,
        this.frame.getHeight() + padding.getwidth() + padding.getwidth() * others + width * others,
        padding.getheight(),
        width,
        frame.getHeight() * 0.6);

    this.buttons.add(button);
    add(button);
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
