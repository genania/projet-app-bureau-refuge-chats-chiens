package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements Palette {

  private Color background = DARK0_HARD;
  private Bar bar; // Variable membre pour la barre

  public Window() {
    SwingUtilities.invokeLater(() -> {
      setTitle("Parapluie");
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      getContentPane().setBackground(background);
      setLayout(null);
    });

    addKeybinding(KeyEvent.VK_ESCAPE, 0, this::dispose);
    addKeybinding(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK, () -> dispose());
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
