package Refuge.Swinger;

import java.awt.Dimension;
import java.awt.Rectangle;

import Refuge.App;

public class Frame {
  private double x;
  private double y;
  private double width;
  private double height;

  public Frame() {
    this.x = 0.0;
    this.y = 0.0;
    this.width = 0.0;
    this.height = 0.0;
  }

  public Frame(double width, double height) {
    this.x = 0.0;
    this.y = 0.0;
    this.width = width;
    this.height = height;
  }

  public Frame(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public Frame(Rectangle rectangle) {
    this.x = rectangle.getX();
    this.y = rectangle.getY();
    this.width = rectangle.getWidth();
    this.height = rectangle.getHeight();
  }

  public Dimension toDimension() {
    Dimension window = App.getSize();

    return new Dimension((int) (width * window.width), (int) (height * window.height));
  }

  public Rectangle toRectangle() {
    Dimension window = App.getSize();

    return new Rectangle(
        (int) (this.x * window.width),
        (int) (this.y * window.height),
        (int) (this.width * window.width),
        (int) (this.height * window.height));
  }

  public Size toSize() {
    return new Size(this.width, this.height);
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Frame [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
  }

  public Rectangle toPoints() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toPoints'");
  }
}
