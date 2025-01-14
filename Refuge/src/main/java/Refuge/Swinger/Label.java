package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

  Frame frame = new Frame(0.1, 0.1, 0.1, 0.025);
  Color color = Palette.ORANGE;
  int alignment = LEFT;

  public Label() {
    customize();
  }

  public Label(String text, double x, double y) {
    this.frame = new Frame(x, y, this.frame.getWidth(), this.frame.getHeight());
    setText(text);
    // setBounds(this.frame.toRectangle());

    customize();
  }

  public Label(String text, double x, double y, double width, double height) {
    frame = new Frame(x, y, width, height);

    setText(text);
    // setBounds(this.frame.toRectangle());
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
    // setBackground(Palette.DARK0_SOFT);
    setForeground(Palette.LIGHT0_SOFT);
    setFont(Text.MEDIUM_TEXT);
    setHorizontalAlignment(alignment);
    // setVerticalAlignment(TOP);
  }

  public void setAlign(int alignment) {
    this.alignment = alignment;

    switch (alignment) {
      case 0 -> setHorizontalAlignment(LEFT);
      case 1 -> setHorizontalAlignment(CENTER);
      case 2 -> setHorizontalAlignment(RIGHT);
    }

    // setHorizontalAlignment(CENTER);
  }
}
