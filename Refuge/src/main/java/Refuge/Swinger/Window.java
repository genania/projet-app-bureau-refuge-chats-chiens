package Refuge.Swinger;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Palette {

  Color background = DARK0_HARD;

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
    Bar bar = new Bar();

    bar.addButton("Lister");
    bar.addButton("Trier");
    bar.addButton("Chercher");

    add(bar);
  }

  public void clear() {
    getContentPane().removeAll();

    showBar();

    revalidate();
    repaint();
  }

  public void addKeybinding(int keyCode, int modifiers, Runnable action) {
    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(keyCode, modifiers), action.toString());
    getRootPane().getActionMap().put(action.toString(),
        new AbstractAction() {
          public void actionPerformed(ActionEvent e) {
            action.run();
          }
        });
  }

  public Dimension getSize() {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    return size;
  }
}
