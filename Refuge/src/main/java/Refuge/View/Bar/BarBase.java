package Refuge.View.Bar;

import Refuge.App;
import Refuge.Swinger.Bar;
import Refuge.Swinger.Icon;
import Refuge.Swinger.Label;
import Refuge.Swinger.Modal;
import Refuge.Swinger.Palette;
import Refuge.View.Modal.AccountModal;
import Refuge.View.Modal.AddAnimalModal;
import Refuge.View.Modal.ContactModal;
import Refuge.View.Modal.HelpModal;
import Refuge.View.Modal.ModalContact;
import Refuge.View.Modal.ModalHelp;
import Refuge.View.Modal.ModalSearch;
import Refuge.View.Modal.ModalAccount;
import Refuge.View.Modal.ModalAddAnimal;
import Refuge.View.Modal.SearchModal;
import Refuge.View.Modal.ModalAddAnimal;
import Refuge.View.Page.PageCat;
import Refuge.View.Page.PageDog;
import Refuge.View.Page.PageLogin;
import Refuge.View.Page.PageWelcome;

public class BarBase extends Bar {
  // private Label labelNomCompte = null;

  public BarBase() {
    super();

    addLogo();
    // addAccount();

  }

  // private void addAccount() {
  // Label name = new Label(Login.getAccount().getUsername(), 0.925, 0.015, 0.1,
  // 0.1);
  // labelNomCompte = name;
  // add(name);
  // }

  protected void ajouterBoutonContact() {
    this.ajouterBoutonGauche("Contact", () -> {
      // new ContactModal(App.getWindow()).setVisible(true);
      new ModalContact();
    });
  }

  protected void ajouterBoutonAide() {
    this.ajouterBoutonGauche("Aide", () -> {
      new ModalHelp();
    });
  }

  protected void ajouterBoutonChat() {
    ajouterBoutonDroit("Chat", () -> {
      System.out.println("Page Chat ouverte");
      PageCat.open(App.getWindow()); // Utiliser App.getWindow() à la place de window
    });
  }

  protected void ajouterBoutonChien() {
    ajouterBoutonDroit("Chien", () -> {
      // System.out.println("Page Chien ouverte");
      PageDog.open(App.getWindow()); // Utiliser App.getWindow() à la place de window
    });
  }

  protected void ajouterBoutonRecherche() {
    ajouterBoutonDroit("Recherche", () -> {
      System.out.println("Page Recherche ouverte");
      // new SearchModal(App.getWindow()).setVisible(true);
      new ModalSearch();
    });
  }

  protected void ajouterBoutonCreerCompte() {
    ajouterBoutonDroit("Créer un compte", () -> {
      new ModalAccount();
    });
  }

  protected void ajouterBoutonEmployer() {
    ajouterBoutonDroit("Employer", () -> {
      System.out.println("Page Employer ouverte");
    });
  }

  protected void ajouterBoutonAjouterAnimal() {
    ajouterBoutonDroit("Ajouter un Animal", () -> {
      System.out.println("Page Ajouter un Animal ouverte");
      new ModalAddAnimal().setVisible(true);
    });
  }

  private void addLogo() {
    Icon icon = new Icon("/icones/placeholder.png", 0.01, this.getFrame().getHeight() / 4.0,
        this.getFrame().getHeight() / 2.0);

    icon.setBackgroundColor(this.getColor());
    icon.setColor(Palette.LIGHT1);

    icon.addClick(() -> {
      App.getWindow().clear();
      PageWelcome.open(App.getWindow());
    });
    icon.setHoverColor(Palette.YELLOW);
    add(icon);
  }
}
