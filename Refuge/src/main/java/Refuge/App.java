package Refuge;

import java.awt.Dimension;
import Refuge.Control.Connexion;
import Refuge.Control.Database;
import Refuge.Swinger.*;

public class App {

  private static Dimension size = new Dimension();

  public static void main(String[] args) {

    // Database database = new Database();
    // Database.ajouterFilm("Inception", "Christopher Nolan", 2010);

    Window window = new Window();

    size = window.getSize();

    Bar bar = new Bar();

    bar.addButton(new Button());
    bar.addButton(new Button());
    bar.addButton(new Button());
    // Button button1 = new Button(
    // bar.getFrame().getX() + bar.getPadding().getwidth(),
    // bar.getFrame().getY() + bar.getPadding().getheight(),
    // bar.getFrame().getWidth() * 0.1,
    // bar.getFrame().getHeight() * 0.8);
    // Button button2 = new Button(
    // bar.getFrame().getX() + bar.getPadding().getwidth() * 2.0 +
    // button1.getFrame().getWidth(),
    // bar.getFrame().getY() + bar.getPadding().getheight(),
    // bar.getFrame().getWidth() * 0.1,
    // bar.getFrame().getHeight() * 0.8);
    // Button button3 = new Button(
    // bar.getFrame().getX() + bar.getPadding().getwidth() * 3.0 +
    // button1.getFrame().getWidth() * 2.0,
    // bar.getFrame().getY() + bar.getPadding().getheight(),
    // bar.getFrame().getWidth() * 0.1,
    // bar.getFrame().getHeight() * 0.8);
    //
    // bar.add(button1);
    // bar.add(button2);
    // bar.add(button3);
    //
    window.add(bar);

    window.open();
  }

  public static Dimension getSize() {
    return size;
  }

  public static void setSize(Dimension size) {
    App.size = size;
  }
}
