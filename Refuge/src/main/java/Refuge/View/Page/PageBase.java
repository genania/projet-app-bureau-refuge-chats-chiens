package Refuge.View.Page;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import Refuge.Model.Animal;
import Refuge.Model.RequeteSql;
import Refuge.Swinger.*;

public abstract class PageBase {
  private static List<Animal> animals = new ArrayList<>();

  public static void open(Window window) {
  }

  public static void clear(Window window) {
    window.clear();
  }

  public static void showAnimal(Window window, Runnable loadMethod) {
    loadMethod.run();
    window.clear();

    int columns = 5;
    int column = 0;
    int row = 0;

    JPanel panel = new JPanel();

    panel.setBackground(Palette.DARK3);
    panel.setLayout(null);

    double pad = 0.02;
    double scrollWidth = 1.0;
    double scrollHeight = 0.95;
    double cardWidth = (scrollWidth - (pad * 2.0) - columns * pad) / columns;
    double cardHeight = cardWidth * 2.0;

    for (Animal animal : animals) {
      System.out.println(animal.getNom());
      Card card = new Card(animal, pad + column * (cardWidth + pad), pad + row * (cardHeight + pad), cardWidth,
          cardHeight);

      panel.add(card);

      column++;
      if (column % (columns + 1) == columns) {
        column = 0;
        row++;
      }
    }

    panel.setBounds(new Frame(0.0, 0.0, scrollWidth, (row + 1) * (cardHeight + pad) + pad * 2.0).toRectangle());
    panel.setPreferredSize(panel.getSize());

    Scroll scroll = new Scroll(panel, 0.0, 0.05, scrollWidth, scrollHeight);

    scroll.setFinal();

    window.add(scroll);
  }

  public static void loadAnimals() {
    animals = RequeteSql.obtenirListeAnimaux();
  }

  public static void loadCat() {
    animals = RequeteSql.obtenirListeChats();
  }

  public static void loadDog() {
    animals = RequeteSql.obtenirListeChiens();

    // for (Animal animal : animals) {
    // System.out.println(animal.getEspece());
    // }
  }
}
