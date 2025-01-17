package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements Palette {
  private Color background = DARK2;
  private Bar bar;

  public Window() {
    SwingUtilities.invokeLater(() -> {
      setTitle("Parapluie");
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setBackground(background);
      getContentPane().setBackground(background);
      setLayout(null);

      ImageIcon icon = new ImageIcon(getClass().getResource("/icones/placeholder.png"));

      setIconImage(icon.getImage());
    });

    addKeybinding(KeyEvent.VK_ESCAPE, 0, () -> {
      this.dispose();
      System.exit(0);
    });
    addKeybinding(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK, () -> {
      this.dispose();
      System.exit(0);
    });
  }

  public void putScrollable(JScrollPane scrollPane) {
    clear();
    // Ajuster la position et la taille du scrollPane pour tenir compte de la barre
    int barHeight = (bar != null) ? bar.getHeight() : 0;
    scrollPane.setBounds(0, barHeight,
        getSize().width,
        getSize().height - barHeight);
    getContentPane().add(scrollPane);
    showBar();
    revalidate();
    repaint();
  }

  public void put(Component component) {
    getContentPane().add(component);
  }

  public void open() {
    setVisible(true);
  }

  public void showBar() {
    if (bar != null) { // Ajouter la barre si elle est définie
      add(bar);
      bar.setVisible(true);
    }
  }

  public void setBar(Bar bar) { // Setter pour la barre
    if (this.bar != null) {
      remove(this.bar);
    }

    this.bar = bar;
  }

  public Bar getBar() { // Getter pour la barre
    return this.bar;
  }

  public void clear() {
    getContentPane().removeAll();
    showBar(); // Affiche la barre s'il y en a une
    revalidate();
    repaint();
  }

  public void addKeybinding(int keyCode, int modifiers, Runnable action) {
    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(keyCode, modifiers), action.toString());
    getRootPane().getActionMap().put(action.toString(), new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        action.run();
      }
    });
  }

  public Dimension getSize() {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }
}
