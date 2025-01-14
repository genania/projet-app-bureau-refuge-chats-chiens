package Refuge.Swinger;

import javax.swing.*;

public class Modal extends JDialog {
  Frame frame = new Frame(0.25, 0.25, 0.5, 0.5);

  public Modal() {
    customize();
    setVisible(true);
  }

  private void customize() {
    setLayout(null);
    getContentPane().setBackground(Palette.DARK2); // Use any Color
    setBounds(frame.toRectangle());
    setFont(Text.MEDIUM_TEXT); // Initialize object
    setLocationRelativeTo(null); // Center on screen
  }
}
