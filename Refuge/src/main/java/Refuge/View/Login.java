package Refuge.View;

import Refuge.Swinger.*;

public class Login {

  private static Field username = new Field("", 0.4, 0.4, 0.2, 0.025);
  private static Field password = new Field("", 0.4, 0.475, 0.2, 0.025);
  private static boolean logged = false;

  public static void open(Window window) {
    Icon icon = new Icon("/icones/placeholder.png", 0.45, 0.175, 0.1);

    window.add(icon);

    window.add(new Label("Nom d'utilisateur", 0.4, 0.375, 0.2, 0.025));
    window.add(username);

    window.add(new Label("Mot de passe", 0.4, 0.45, 0.2, 0.025));
    window.add(password);

    Button connect = new Button("Se connecter", 0.4, 0.525, 0.2, 0.025);

    connect.setOnClick(() -> {
      System.out.println("Login button clicked!");
      String usernameField = username.getText();
      String passwordFiend = password.getText();
      // Process login
    });

    window.add(connect);
  }
}
