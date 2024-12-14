package Refuge.Model;

import java.awt.Color;

import Refuge.Swinger.Palette;

public class Dog extends Animal {

  private final Color COLOR = Palette.RED; // Light pink

  public Dog(String name, Type type, int age, double weight) {
    super(name, type, age, weight);
  }

  @Override
  public Color getColor() {
    return COLOR;
  }

}
