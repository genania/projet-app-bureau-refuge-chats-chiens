package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;

public class Field extends JTextField {
  Frame frame = new Frame(0.1, 0.1, 0.2, 0.025);
  int alignment = LEFT;

  public Field() {
    customize();
  }

  public Field(Frame frame) {
    this.frame = frame;
    setBounds(this.frame.toRectangle());

    customize();
  }

  public Field(String text, Frame frame) {
    this.frame = frame;

    setBounds(this.frame.toRectangle());
    setText(text);

    customize();
  }

  public Field(String text, double x, double y, double width, double height) {
    this.frame = new Frame(x, y, width, height);

    setBounds(this.frame.toRectangle());
    setText(text);

    customize();
  }

  public void customize() {
    setBounds(frame.toRectangle());
    // setBorder(BorderFactory.createEmptyBorder());
    setBorder(BorderFactory.createLineBorder(Palette.GREEN, 4));
    setEditable(true);
    setBackground(Palette.DARK3);
    setForeground(Palette.LIGHT0);
    setFont(Text.MEDIUM_TEXT); // Initialize object
    setHorizontalAlignment(alignment);
  }
}
