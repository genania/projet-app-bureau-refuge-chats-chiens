package Refuge.Swinger;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton implements Palette {
  private Frame frame;
  private Color defaultColor = BLUE;
  private Color hoverColor = YELLOW;

  public Button() {
    this.frame = new Frame();

    customize();
  }

  public Button(Frame frame) {
    this.frame = frame;

    customize();
  }

  public Button(Frame frame, Color color) {
    this.frame = frame;
    this.defaultColor = color;

    customize();
  }

  public Button(double width, double height) {
    this.frame = new Frame(width, height);

    customize();
  }

  public Button(double width, double height, Color color) {
    this.frame = new Frame(width, height);
    this.defaultColor = color;

    customize();
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

  private void customize() {
    setOpaque(true);
    setBorderPainted(false);
    setBounds(frame.toRectangle());
    setBackground(defaultColor);
    setForeground(LIGHT0_SOFT);
    setFocusPainted(false);
    setFont(Text.MEDIUM_TEXT);
    setupHoverEffect();
  }

  private void setupHoverEffect() {
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        setBackground(hoverColor);
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        setBackground(defaultColor);
      }
    });
  }

  public void onClick(Runnable action) {
    addActionListener(e -> action.run());
  }

  // Getters and Setters
  public Frame getFrame() {

    return frame;
  }

  public void setFrame(Frame frame) {
    this.frame = frame;
    setBounds(frame.toRectangle());
  }

  public Color getDefaultColor() {
    return defaultColor;
  }

  public void setDefaultColor(Color color) {
    this.defaultColor = color;
    setBackground(color);
  }

  public Color getHoverColor() {
    return hoverColor;
  }

  public void setHoverColor(Color color) {
    this.hoverColor = color;
  }
}
