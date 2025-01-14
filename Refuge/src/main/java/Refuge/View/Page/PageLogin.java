package Refuge.View.Page;

import Refuge.Swinger.*;
import Refuge.Model.*;

public class PageLogin extends PageBase {

  private static Field username = new Field("", 0.4, 0.4, 0.2, 0.025);
  private static Field password = new Field("", 0.4, 0.475, 0.2, 0.025);
  private static boolean logged = false;
  private static Account account = new Visitor();

  public static Button connect = new Button("Se connecter", 0.4, 0.525, 0.2, 0.025);

  public static void open(Window window) {
    Icon icon = new Icon("/icones/placeholder.png", 0.5, 0.175, 0.1);

    icon.setBackground(Palette.ORANGE);
    icon.setColor(Palette.YELLOW);

    window.put(icon);

    window.put(new Label("Nom d'utilisateur", 0.4, 0.375, 0.2, 0.025));
    window.put(username);

    window.put(new Label("Mot de passe", 0.4, 0.45, 0.2, 0.025));
    window.put(password);

    Button connect = new Button("Se connecter", 0.4, 0.525, 0.2, 0.025);

    connect.onClick(() -> log(window));

    window.put(connect);
  }

  public static void log(Window window) {
    logged = true;

    System.out.println("Nom d'utilisateur : " + username.getText());
    System.out.println("Mot de passe : " + password.getText());

    if (logged) {
      clear(window);
      PageAdmin.open(window);
    }
  }

  public static Field getUsername() {
    return username;
  }

  public static void setUsername(Field username) {
    PageLogin.username = username;
  }

  public static Field getPassword() {
    return password;
  }

  public static void setPassword(Field password) {
    PageLogin.password = password;
  }

  public static boolean isLogged() {
    return logged;
  }

  public static void setLogged(boolean logged) {
    PageLogin.logged = logged;
  }

  public static Account getAccount() {
    return account;
  }

  public static void setAccount(Account account) {
    PageLogin.account = account;
  }

  public static Button getConnect() {
    return connect;
  }

  public static void setConnect(Button connect) {
    PageLogin.connect = connect;
  }
}
