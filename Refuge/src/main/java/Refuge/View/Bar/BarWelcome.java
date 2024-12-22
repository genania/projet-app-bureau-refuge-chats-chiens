package Refuge.View.Bar;

import Refuge.App;
import Refuge.View.Modal.CreateAccountModal;

public class BarWelcome extends BarBase {
  public BarWelcome() {
    super();
    ajouterBoutonAide();
    ajouterBoutonContact();
    ajouterBoutonCreerCompte();
  }

  private void ajouterBoutonContact() {
    this.ajouterBoutonGauche("Contact", () -> {
      System.out.println("Contact"); // TODO Afficher Contact
    });
  }

  private void ajouterBoutonAide() {
    this.ajouterBoutonGauche("Aide", () -> {
      System.out.println("Aide"); // TODO Afficher aide
    });
  }

  private void ajouterBoutonCreerCompte() {
    ajouterBoutonDroit("Créer un compte", () -> {
      new CreateAccountModal(App.getWindow()).setVisible(true); // TODO Afficher model Créer un compte
    });
  }

}