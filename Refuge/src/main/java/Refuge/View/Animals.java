package Refuge.View;

import Refuge.Swinger.Window;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Refuge.Model.*;
import Refuge.Swinger.*;
import Refuge.Swinger.Frame;
import Refuge.Swinger.Icon;
import Refuge.Swinger.Label;
import Refuge.Swinger.Palette;

public class Animals extends Page {
  private static final double PANEL_WIDTH = 0.1;
  private static final double PANEL_HEIGHT = 0.1;
  private static final double GAP = 0.05; // Gap between panels
  private static List<Animal> animals = new ArrayList<>();

  public static void open(Window window) {
    // TODO:
    // changer la fonction loadAnimals()
    // pour charger les animaux de la base de donnees
    loadAnimals();

    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        double x = 0.2 + col * (PANEL_WIDTH + GAP);
        double y = 0.2 + row * (PANEL_HEIGHT + GAP);

        Card card = new Card(animals.get(row + col), x, y);

        card.setBackground(animals.get(row + col).getColor());

        window.put(card);
      }
    }
    window.revalidate();
    window.repaint();
  }

  public static void loadAnimals() {
    Random random = new Random();

    // Cat names
    String[] catNames = { "Whiskers", "Luna", "Oliver", "Bella", "Leo", "Milo", "Lucy", "Shadow" };
    // Dog names
    String[] dogNames = { "Max", "Bailey", "Charlie", "Rocky", "Cooper", "Duke", "Bear", "Buddy" };

    // Add 8 cats and 8 dogs
    for (int i = 0; i < 8; i++) {
      // Add a cat
      animals.add(new Cat(
          catNames[i],
          Animal.Type.CAT,
          random.nextInt(15) + 1, // Age 1-15
          2.0 + random.nextDouble() * 4.0 // Weight 2-6 kg
      ));

      // Add a dog
      animals.add(new Dog(
          dogNames[i],
          Animal.Type.DOG,
          random.nextInt(12) + 1, // Age 1-12
          5.0 + random.nextDouble() * 25.0 // Weight 5-30 kg
      ));
    }
  }
}
