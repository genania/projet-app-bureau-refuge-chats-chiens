package Refuge.View.Page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
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
      this.thumbColor = new Color(73, 156, 154); // Couleur de la poignée
      this.trackColor = new Color(44, 44, 44); // Couleur de la piste
    }
  }

  public static void showAnimal(Window window, Runnable loadMethod) {
    loadMethod.run();

    // Calculer le nombre de colonnes en fonction de la taille de la fenêtre
    int numColumns = Math.max(3, window.getSize().width / 600);

    JPanel containerPanel = new JPanel(new GridLayout(0, numColumns, 20, 20));
    containerPanel.setBackground(window.getBackground());

    for (Animal animal : animals) {
      Card card = new Card(animal, 0, 0);
      card.setBackground(animal.getColor());
      card.setMaximumSize(new Dimension(600, 350));
      containerPanel.add(card);
    }

    JScrollPane scrollPane = new JScrollPane(containerPanel);
    scrollPane.setBounds(0, 0, window.getSize().width, window.getSize().height);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);

    // Personnalisation de la scrollbar
    scrollPane.setBackground(window.getBackground());
    scrollPane.getViewport().setBackground(window.getBackground());
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());

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
