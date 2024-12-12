package Refuge.Swinger;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Palette {

  Color background = DARK0_HARD;

  public Window() {
    SwingUtilities.invokeLater(() -> {
      setTitle("Refuge");
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      getContentPane().setBackground(background);
      setLayout(null);
    });

    // Add escape key binding
    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");

    getRootPane().getActionMap().put("escape", new AbstractAction() {
      public void actionPerformed(ActionEvent event) {
        dispose();
      }
    });
  }

  public void open() {
    setVisible(true);
  }

  public Dimension getSize() {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }
}
