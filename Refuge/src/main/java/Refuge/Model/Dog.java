package Refuge.Model;

import java.awt.Color;
import java.util.ArrayList;

import Refuge.Swinger.Palette;

public class Dog extends Animal {

  private final Color COLOR = Palette.RED; // Light pink

  public Dog(int identification, String nom, int ageMois, String sexe,
      String race, String couleur, String description, boolean sterilise, boolean vaccine,
      ArrayList<String> cheminPhotos) {
    super(identification, nom, ageMois, sexe,
        race, couleur, description, sterilise, vaccine,
        cheminPhotos);

    setEspece("chien");
  }

  @Override
  public Color getColor() {
    return COLOR;
  }

}
