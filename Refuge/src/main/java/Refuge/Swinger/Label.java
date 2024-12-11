package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
  Frame frame = new Frame(0.1, 0.1, 0.2, 0.025);
  Color color = Palette.ORANGE;
  int alignment = LEFT;

  public Label() {
    customize();
  }

  public Label(Frame frame) {
    this.frame = frame;
    setBounds(this.frame.toRectangle());

    customize();
  }

  public Label(String text, Frame frame) {
    this.frame = frame;
    setBounds(this.frame.toRectangle());

    setText(text);

    customize();
  }

  public void customize() {
    setBounds(frame.toRectangle());
    setBorder(BorderFactory.createEmptyBorder());
    setBackground(Palette.PURPLE);
    setForeground(Palette.LIGHT0_SOFT);
    setFont(Text.MEDIUM_TEXT); // Initialize object
    setHorizontalAlignment(alignment);
  }
}
