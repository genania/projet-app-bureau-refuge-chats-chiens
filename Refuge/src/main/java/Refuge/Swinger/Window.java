package Refuge.Swinger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Window extends JFrame {
  private Dimension size = new Dimension(1200, 800);

  public Window() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      System.out.println("Error : No look, no feel");
    }

    SwingUtilities.invokeLater(() -> {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

      setBounds(
          (screenSize.width - size.width) / 2,
          (screenSize.height - size.height) / 2,
          size.width, size.height);
      setExtendedState(JFrame.NORMAL);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }

  public void open() {
    setVisible(true);
  }
}
