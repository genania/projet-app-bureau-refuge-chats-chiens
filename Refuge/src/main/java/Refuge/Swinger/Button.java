package Refuge.Swinger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton implements Palette {

  Frame frame = new Frame();
  Color color = BLUE;

  public Button() {
  }

  public Button(Frame frame) {
    // this.part = new Part(rect, BLUE);

    setBounds(frame.toRectangle());
    // setPreferredFrame(frame);
    setBackground(this.color);
    setForeground(LIGHT0);
    setToolTipText("Butt");
    // setFont(new Font("Arial", 0, 14));
  }

  public Button(Frame frame, Color color) {
    this.frame = frame;
    this.color = color;
  }

  public Button(double width, double height) {
    this.frame = new Frame(width, height);

    setBounds(frame.toRectangle());
    // setPreferredFrame(frame);
    setBackground(this.color);
    setForeground(LIGHT0);
    setToolTipText("Butt");
  }

  public Button(double width, double height, Color color) {
    this.frame = new Frame(width, height);
    this.color = color;
  }

  public Button(double x, double y, double width, double height) {

    this.frame = new Frame(x, y, width, height);

    customize();
  }

  public Button(String name, double x, double y, double width, double height) {

    this.frame = new Frame(x, y, width, height);

    setText(name);
    customize();
  }

  public void customize() {
    setBorder(BorderFactory.createLineBorder(Color.black));
    setOpaque(true);
    setBorderPainted(false);
    // System.out.println(this.frame.toRectangle());
    setBounds(frame.toRectangle());
    // setPreferredFrame(frame);
    setBackground(this.color);
    setForeground(LIGHT0_SOFT);
    setToolTipText("Butt");
    setFocusPainted(false);

    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        setBackground(BRIGHT_BLUE); // Darker blue on hover
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        setBackground(BLUE);
      }
    });
  }

  public Frame getFrame() {
    return frame;
  }

  public void setFrame(Frame frame) {
    this.frame = frame;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
