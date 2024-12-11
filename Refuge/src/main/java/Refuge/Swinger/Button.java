package Refuge.Swinger;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton implements Palette, MouseListener {
  private Frame frame;
  private Color defaultColor = BLUE;
  private Color hoverColor = YELLOW;
  private String defaultText;

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
    this.defaultText = name;

    setText(name);
    customize();
  }

  private void customize() {
    setBorder(BorderFactory.createEmptyBorder());
    setOpaque(true);
    setBorderPainted(false);
    setBounds(frame.toRectangle());
    setBackground(defaultColor);
    setForeground(LIGHT0_SOFT);
    setFocusPainted(false);
    setFont(Text.MEDIUM_TEXT);
    // Add this button as its own MouseListener
    addMouseListener(this);
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

  // MouseListener Implementation
  @Override
  public void mouseClicked(MouseEvent e) {
    // Add click behavior if needed
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // Add press behavior if needed
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // Add release behavior if needed
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    setBackground(YELLOW);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    setBackground(defaultColor);
  }
}
