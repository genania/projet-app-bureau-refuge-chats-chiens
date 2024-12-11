package Refuge.Swinger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Window extends JFrame implements Palette {

  Color background = DARK0_HARD;

  public Window() {
    // try {
    // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    // } catch (Exception e) {
    // System.out.println("Error : No look, no feel");
    // }

    SwingUtilities.invokeLater(() -> {
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      getContentPane().setBackground(background);
      setLayout(null);
    });
  }

  public void open() {
    setVisible(true);
  }

  public Dimension getSize() {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }
}
