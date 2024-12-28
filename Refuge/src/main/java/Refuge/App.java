package Refuge;

import java.awt.Dimension;
import Refuge.Control.Connexion;
import Refuge.Swinger.*;
import Refuge.View.Page.PageWelcome;
import Refuge.Model.*;

public class App {

  private static Dimension size = new Dimension();
  private static Window window = new Window();

  public static void main(String[] args) {

    // TODO:
    // Code temporaire qui reussit a se connecter sur mon ordi et ajoute un film

    // Database database = new Database();
    // Database.ajouterFilm("Inception", "Christopher Nolan", 2010);

    Connexion connexion = new Connexion();
    System.out.println(connexion.isConnected());

    Account.addAccount(new Visitor());

    size = window.getSize();

    PageWelcome.open(window);

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
