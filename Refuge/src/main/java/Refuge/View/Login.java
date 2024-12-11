package Refuge.View;

import Refuge.Swinger.*;

public class Login {

  public static void open(Window window) {

    System.out.println("Login");

    window.add(new Label("ID", new Frame(0.4, 0.375, 0.2, 0.025)));
    window.add(new Field("", new Frame(0.4, 0.4, 0.2, 0.025)));

    window.add(new Label("Password", new Frame(0.4, 0.45, 0.2, 0.025)));
    window.add(new Field("", new Frame(0.4, 0.475, 0.2, 0.025)));

    window.add(new Button("Se connecter", 0.4, 0.525, 0.2, 0.025));

  }
}
