package Refuge.View;

import Refuge.App;

import Refuge.Swinger.*;
import Refuge.Model.*;

public class Welcome extends Page {

  public static void open(Window window) {
    // double ratio = App.getSize().getHeight() / App.getSize().getWidth();
    // double iconSize = 0.15;
    // double xIcon = (1 - iconSize * ratio) / 2;

    // Icon icon = new Icon("/icones/placeholder.png", xIcon, 0.175, iconSize);
    Icon icon = new Icon("/icones/placeholder.png", 0.5, 0.175, 0.1);

    icon.setBackground(Palette.DARK0_SOFT);
    icon.setColor(Palette.LIGHT0_SOFT);

    window.put(icon);

    Label nom = new Label("Parapluie", 0.4, 0.35, 0.2, 0.025);

    nom.setAlign(1);
    window.put(nom);

    Button visitor = new Button("Visiter", 0.4, 0.425, 0.2, 0.025);

    visitor.onClick(() -> visit(window));

    Button connect = new Button("Se connecter", 0.4, 0.475, 0.2, 0.025);

    connect.onClick(() -> login(window));

    window.put(visitor);
    window.put(connect);
  }

  private static void visit(Window window) {
    clear(window);
    Animals.open(window);

  }

  private static void login(Window window) {
    clear(window);
    Login.open(window);
  }
}
