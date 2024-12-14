package Refuge;

import java.awt.Dimension;
import Refuge.Control.Connexion;
import Refuge.Control.Database;
import Refuge.Swinger.*;
import Refuge.View.*;
import Refuge.Model.*;

public class App {

  private static Dimension size = new Dimension();
  private static Window window = new Window();

  public static void main(String[] args) {

    // TODO:
    // Code temporaire qui reussit a se connecter sur mon ordi et ajoute un film

    // Database database = new Database();
    // Database.ajouterFilm("Inception", "Christopher Nolan", 2010);

    Account.addAccount(new Visitor());

    size = window.getSize();

    Welcome.open(window);

    window.showBar();
    window.open();
  }

  public static Dimension getSize() {
    return size;
  }

  public static void setSize(Dimension size) {
    App.size = size;
  }

  public static Window getWindow() {
    return window;
  }

  public static void setWindow(Window window) {
    App.window = window;
  }
}
