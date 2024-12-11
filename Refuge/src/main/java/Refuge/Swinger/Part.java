package Refuge.Swinger;

import java.awt.Rectangle;

import java.awt.*;

public class Part implements Palette {

  private Rectangle rect = new Rectangle();
  private Color color = DARK0;

  public Part() {
  }

  public Part(Rectangle rect, Color color) {
    this.rect = rect;
    this.color = color;
  }

  public Rectangle getRect() {
    return rect;
  }

  public void setRect(Rectangle rect) {
    this.rect = rect;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }
}
