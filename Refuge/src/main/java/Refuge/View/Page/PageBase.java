package Refuge.View.Page;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import Refuge.Model.Animal;
import Refuge.Model.Cat;
import Refuge.Model.Dog;
import Refuge.Model.RequeteSql;
import Refuge.Swinger.*;

public abstract class PageBase {
  private static final double PANEL_WIDTH = 0.1;
  private static final double PANEL_HEIGHT = 0.1;
  private static final double GAP = 0.05; // Gap between panels
  private static List<Animal> animals = new ArrayList<>();

  public static void open(Window window) {

  };

  public static void clear(Window window) {
    window.clear();
  }

  public static void showAnimal(Window window) {

    // TODO:
    // changer la fonction loadAnimals()
    // pour charger les animaux de la base de donnees
    loadAnimals();

    // for (int row = 0; row < 4; row++) {
    // for (int col = 0; col < 4; col++) {
    // double x = 0.2 + col * (PANEL_WIDTH + GAP);
    // double y = 0.2 + row * (PANEL_HEIGHT + GAP);

    // Card card = new Card(animals.get(row + col), x, y);

    // card.setBackground(animals.get(row + col).getColor());

    // window.put(card);
    // }
    // }
    for (int i = 0; i < animals.size(); i++) {
      double x = 0.2 + (i % 4) * (PANEL_WIDTH + GAP);
      double y = 0.2 + i / 4 * (PANEL_HEIGHT + GAP);

      Card card = new Card(animals.get(i), x, y);
      card.setBackground(animals.get(i).getColor());

      window.put(card);
    }

  }

  public static void loadAnimals() {
    animals = RequeteSql.obtenirListeAnimaux();
  }
}
