package Refuge.Swinger;

import java.awt.Dimension;

import Refuge.App;

public class Size {
  private double width;
  private double height;

  public double getwidth() {
    return width;
  }

  public void setwidth(double width) {
    this.width = width;
  }

  public double getheight() {
    return height;
  }

  public void setheight(double height) {
    this.height = height;
  }

  public Size() {
    // Initialize object
    width = 0.0;
    height = 0.0;
  }

  public Size(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public Dimension toDimension() {
    Dimension window = App.getSize();

    return new Dimension((int) (width * window.width), (int) (height * window.height));
  }
}
