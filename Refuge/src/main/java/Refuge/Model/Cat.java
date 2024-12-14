package Refuge.Model;

import java.awt.Color;

import Refuge.Swinger.Palette;

public class Cat extends Animal {
  private final Color COLOR = Palette.BLUE; // Light blue

  public Cat(String name, Type type, int age, double weight) {
    super(name, type, age, weight);
  }

  @Override
  public Color getColor() {
    return COLOR;
  }
}
