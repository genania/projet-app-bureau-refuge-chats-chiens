package Refuge.View;

import Refuge.App;
import Refuge.Swinger.*;
import Refuge.View.Bar.BarWelcome;
import Refuge.View.Bar.BarAdmin;
import Refuge.View.Bar.BarEmployer;

public class Welcome extends Page {

  public static void open(Window window) {
    // Définir la barre de navigation
    window.setBar(new BarWelcome());
    window.showBar(); // Afficher la barre

    // Icone
    Icon icon = new Icon("/icones/placeholder.png", 0.5, 0.175, 0.1);
    icon.setBackground(Palette.DARK0_SOFT);
    icon.setColor(Palette.LIGHT0_SOFT);
    window.put(icon);

    // Titre
    Label nom = new Label("Parapluie", 0.4, 0.35, 0.2, 0.025);
    nom.setAlign(1);
    window.put(nom);

    // Bouton "Visiter"
    Button visitor = new Button("Visiter", 0.4, 0.425, 0.2, 0.025);
    visitor.onClick(() -> visit(window));
    window.put(visitor);

    // Bouton "Se connecter"
    Button connect = new Button("Se connecter", 0.4, 0.475, 0.2, 0.025);
    connect.onClick(() -> login(window));
    window.put(connect);
  }

  private static void visit(Window window) {
    window.clear();
    Animals.open(window);
  }

  private static void login(Window window) {
    window.clear();
    Login.open(window);
  }
}
