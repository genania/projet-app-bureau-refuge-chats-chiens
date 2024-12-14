package Refuge.Model;

import java.awt.Color;

import Refuge.Swinger.Palette;

public class Animal {
  // Enum for animal type
  public enum Type {
    CAT, DOG
  }

  // Instance variables
  private String name;
  private Type type;
  private int age;
  private double weight;
  private boolean isHungry;
  private final Color COLOR = Palette.ORANGE;

  public Color getColor() {
    return COLOR;
  }

  // Constructor
  public Animal(String name, Type type, int age, double weight) {
    this.name = name;
    this.type = type;
    this.age = age;
    this.weight = weight;
    this.isHungry = true;
  }

  // Getters and setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age >= 0) {
      this.age = age;
    }
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    if (weight > 0) {
      this.weight = weight;
    }
  }

  // Behavior methods
  public void eat() {
    if (isHungry) {
      System.out.println(name + " is eating " +
          (type == Type.CAT ? "fish" : "dog food") + "...");
      isHungry = false;
    } else {
      System.out.println(name + " is not hungry right now.");
    }
  }

  public void makeSound() {
    switch (type) {
      case CAT:
        System.out.println(name + " says: Meow!");
        break;
      case DOG:
        System.out.println(name + " says: Woof!");
        break;
    }
  }

  public void play() {
    switch (type) {
      case CAT:
        System.out.println(name + " is chasing a laser pointer!");
        break;
      case DOG:
        System.out.println(name + " is fetching a ball!");
        break;
    }
    isHungry = true; // Playing makes them hungry
  }

  public void sleep() {
    switch (type) {
      case CAT:
        System.out.println(name + " is curled up in a sunny spot, sleeping...");
        break;
      case DOG:
        System.out.println(name + " is sleeping in their bed...");
        break;
    }
    isHungry = true; // Animals get hungry after sleeping
  }

  // Override toString method for better object representation
  @Override
  public String toString() {
    return "Animal{" +
        "name='" + name + '\'' +
        ", type=" + type +
        ", age=" + age +
        ", weight=" + weight +
        ", isHungry=" + isHungry +
        '}';
  }
}
