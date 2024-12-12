package Refuge;

import java.awt.Dimension;
import Refuge.Control.Connexion;
import Refuge.Control.Database;
import Refuge.Swinger.*;
import Refuge.View.*;

public class App {

  private static Dimension size = new Dimension();

  public static void main(String[] args) {

    // Database database = new Database();
    // Database.ajouterFilm("Inception", "Christopher Nolan", 2010);

    Window window = new Window();

    size = window.getSize();

    Bar bar = new Bar();

    bar.addButton("Lister");
    bar.addButton("Trier");
    bar.addButton("Chercher");

    window.add(bar);

    Login.open(window);

    window.open();
  }

  public static Dimension getSize() {
    return size;
  }

  public static void setSize(Dimension size) {
    App.size = size;
  }
}
