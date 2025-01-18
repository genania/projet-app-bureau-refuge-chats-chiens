package Refuge.Swinger;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Modal extends JDialog {
  Frame frame = new Frame(0.25, 0.25, 0.5, 0.5);

  public Modal() {
    setBounds(this.frame.toRectangle());
    customize();
  }

  public Modal(Frame frame) {
    setBounds(frame.toRectangle());
    customize();
  }

  private void customize() {
    setLayout(null);
    getContentPane().setBackground(Palette.DARK2); // Use any Color
    setFont(Text.MEDIUM_TEXT); // Initialize object
    setLocationRelativeTo(null); // Center on screen
    setVisible(true);

    addKey(KeyEvent.VK_ESCAPE, () -> {
      this.dispose();
    });

    String iconPath = "/icones/placeholder.png";
    java.net.URL iconURL = getClass().getResource(iconPath);
    if (iconURL != null) {
      ImageIcon icon = new ImageIcon(iconURL);
      setIconImage(icon.getImage());
    } else {
      System.err.println("Icône non trouvée : " + iconPath);
    }
  }

  public void addKey(int keyCode, Runnable action) {
    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(keyCode, 0), action.toString());
    getRootPane().getActionMap().put(action.toString(), new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        action.run();
      }
    });
  }
}
