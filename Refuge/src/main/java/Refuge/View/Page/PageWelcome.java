package Refuge.View.Page;

import Refuge.App;
import Refuge.Swinger.*;
import Refuge.View.Bar.BarWelcome;
import Refuge.View.Bar.BarAdmin;
import Refuge.View.Bar.BarEmployer;

public class PageWelcome extends PageBase {

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

    // Bouton "Interface Employee"
    Button employee = new Button("TEMPORAIRE Interface Employer", 0.4, 0.525, 0.2, 0.025); // Temporaire pour tester les
                                                                                           // pages
    employee.onClick(() -> afficherPageEmployer(window));
    window.put(employee);

    // Bouton "Interface Admin"
    Button admin = new Button("TEMPORAIRE Interface Administrateur", 0.4, 0.575, 0.2, 0.025);// Temporaire pour tester
                                                                                             // les pages
    admin.onClick(() -> afficherPageAdministrateur(window));
    window.put(admin);
  }

  private static void visit(Window window) {
    window.clear();
    PageVisitor.open(window);
  }

  private static void login(Window window) {
    window.clear();
    PageLogin.open(window);
  }

  private static void afficherPageEmployer(Window window) {
    window.clear();
    PageEmployee.open(window);
  }

  private static void afficherPageAdministrateur(Window window) {
    window.clear();
    PageAdmin.open(window);
  }

}
