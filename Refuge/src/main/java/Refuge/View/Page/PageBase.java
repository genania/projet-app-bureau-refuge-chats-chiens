package Refuge.View.Page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.util.ArrayList;
import java.util.List;
import Refuge.Model.Animal;
import Refuge.Model.RequeteSql;
import Refuge.Swinger.*;

public abstract class PageBase {
  private static final double PANEL_WIDTH = 0.1;
  private static final double PANEL_HEIGHT = 0.1;
  private static final double GAP = 0.1;
  private static List<Animal> animals = new ArrayList<>();

  public static void open(Window window) {
  }

  public static void clear(Window window) {
    window.clear();
  }

  // Classe personnalisée pour le style de la scrollbar
  private static class CustomScrollBarUI extends BasicScrollBarUI {
    @Override
    protected JButton createDecreaseButton(int orientation) {
      return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
      return createZeroButton();
    }

    private JButton createZeroButton() {
      JButton button = new JButton();
      button.setPreferredSize(new Dimension(0, 0));
      return button;
    }

    @Override
    protected void configureScrollBarColors() {
      // Couleur de la "poignée" de la scrollbar
      this.thumbColor = new Color(73, 156, 154);
      // Couleur de la piste de la scrollbar
      this.trackColor = new Color(44, 44, 44);
    }
  }

  public static void showAnimal(Window window, Runnable loadMethod) {
    loadMethod.run();

    JPanel containerPanel = new JPanel(null) {
      @Override
      public Dimension getPreferredSize() {
        int rows = (int) Math.ceil(animals.size() / 3.0);
        int height = (int) (window.getSize().height * (0.1 + rows * (PANEL_HEIGHT + GAP)));
        return new Dimension(window.getSize().width, height);
      }
    };

    containerPanel.setBackground(window.getBackground());

    for (int i = 0; i < animals.size(); i++) {
      double x = 0.2 + (i % 3) * (PANEL_WIDTH + GAP);
      double y = 0.1 + (i / 3) * (PANEL_HEIGHT + GAP);

      Card card = new Card(animals.get(i), x, y);
      card.setBackground(animals.get(i).getColor());
      containerPanel.add(card);
    }

    JScrollPane scrollPane = new JScrollPane(containerPanel);
    scrollPane.setBounds(0, 0, window.getSize().width, window.getSize().height);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);

    // Personnalisation de la scrollbar
    scrollPane.setBackground(window.getBackground());
    scrollPane.getViewport().setBackground(window.getBackground());
    scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Enlève la bordure
    scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());

    // Définir la largeur de la scrollbar
    scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));

    window.putScrollable(scrollPane);
  }

  public static void loadAnimals() {
    animals = RequeteSql.obtenirListeAnimaux();
  }

  public static void loadCat() {
    animals = RequeteSql.obtenirListeChats();
  }

  public static void loadDog() {
    animals = RequeteSql.obtenirListeChiens();
  }
}