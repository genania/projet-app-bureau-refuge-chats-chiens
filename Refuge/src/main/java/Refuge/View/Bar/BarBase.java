package Refuge.View.Bar;

import Refuge.App;
import Refuge.Swinger.Bar;
import Refuge.Swinger.Icon;
import Refuge.Swinger.Label;
import Refuge.Swinger.Palette;
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

  private void addLogo() {
    Icon icon = new Icon("/icones/placeholder.png", 0.01, this.getFrame().getHeight() / 4.0,
        this.getFrame().getHeight() / 2.0);

    icon.setBackgroundColor(this.getColor());
    icon.setColor(Palette.LIGHT0_SOFT);

    icon.addClick(() -> {
      App.getWindow().clear();
      PageWelcome.open(App.getWindow());
    });
    icon.setHoverColor(Palette.YELLOW);
    add(icon);
  }
}