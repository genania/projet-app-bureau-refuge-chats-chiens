package Refuge.Swinger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public class Window extends JFrame {
  private static Point size = new Point(1200, 800);

  public Window() {
    // Initialize object
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      System.out.println("Error : No look, no feel");
    }

    SwingUtilities.invokeLater(() -> {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

      // Application app = new Application();

      setBounds(
          (screenSize.width - size.x) / 2,
          (screenSize.height - size.y) / 2,
          size.x, size.y);

      setExtendedState(JFrame.NORMAL);
      //
      // app.setVisible(true);
    });
  }
}
