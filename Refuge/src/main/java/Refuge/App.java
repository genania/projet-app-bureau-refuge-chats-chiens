package Refuge;

import Refuge.Control.Connexion;
import Refuge.Model.*;
import Refuge.Swinger.*;
import Refuge.View.Modal.ModalAnimal;
import Refuge.View.Modal.ModalSearch;
import Refuge.View.Page.*;
import java.awt.Dimension;

public class App {
  private static Dimension size = new Dimension();
  private static Window window = new Window();

  public static void main(String[] args) {
    new Connexion();

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
