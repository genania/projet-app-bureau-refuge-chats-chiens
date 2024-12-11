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

    bar.addButton("Hello");
    bar.addButton("Hi");
    bar.addButton("Wazaaa");

    window.add(bar);

    window.add(new Field("Hello", new Frame(0.1, 0.1, 0.2, 0.025)));
    window.open();
  }

  public static Dimension getSize() {
    return size;
  }

  public static void setSize(Dimension size) {
    App.size = size;
  }
}
