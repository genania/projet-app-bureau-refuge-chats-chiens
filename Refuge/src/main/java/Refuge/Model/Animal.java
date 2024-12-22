package Refuge.Model;

import java.awt.Color;
import java.util.ArrayList;

import Refuge.Swinger.Palette;

public class Animal {
  // Enum for animal type
  public enum Type {
    CAT, DOG
  }

  // Instance variables
  private int identification;
  private String nom;
  private int ageMois;
  private String espece;
  private String sexe;
  private String race;
  private String couleur;
  private String description;
  private boolean sterilise;
  private boolean vaccine;
  private ArrayList<String> cheminPhotos;
  private final Color COLOR = Palette.ORANGE;

  public Color getColor() {
    return COLOR;
  }

  // Constructor
  public Animal(int identification, String nom, int ageMois, String sexe,
      String race, String couleur, String description, boolean sterilise, boolean vaccine,
      ArrayList<String> cheminPhotos) {
    this.identification = identification;
    this.nom = nom;
    this.ageMois = ageMois;
    this.sexe = sexe;
    this.race = race;
    this.couleur = couleur;
    this.description = description;
    this.sterilise = sterilise;
    this.vaccine = vaccine;
    this.cheminPhotos = cheminPhotos;
  }

  // Getters et Setters
  public int getIdentification() {
    return identification;
  }

  public void setIdentification(int identification) {
    this.identification = identification;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getAgeMois() {
    return ageMois;
  }

  public void setAgeMois(int ageMois) {
    this.ageMois = ageMois;
  }

  public String getSexe() {
    return sexe;
  }

  public void setSexe(String sexe) {
    this.sexe = sexe;
  }

  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public String getEspece() {
    return espece;
  }

  public void setEspece(String espece) {
    this.espece = espece;
  }

  public String getCouleur() {
    return couleur;
  }

  public void setCouleur(String couleur) {
    this.couleur = couleur;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isSterilise() {
    return sterilise;
  }

  public void setSterilise(boolean sterilise) {
    this.sterilise = sterilise;
  }

  public boolean isVaccine() {
    return vaccine;
  }

  public void setVaccine(boolean vaccine) {
    this.vaccine = vaccine;
  }

  public ArrayList<String> getCheminPhotos() {
    return cheminPhotos;
  }

  public void setCheminPhotos(ArrayList<String> cheminPhotos) {
    this.cheminPhotos = cheminPhotos;
  }

  @Override
  public String toString() {
    return "Animal {" +
        "identification=" + identification +
        ", nom='" + nom + '\'' +
        ", ageMois=" + ageMois +
        ", espece='" + espece + '\'' +
        ", sexe='" + sexe + '\'' +
        ", race='" + race + '\'' +
        ", couleur='" + couleur + '\'' +
        ", description='" + description + '\'' +
        ", sterilise=" + sterilise +
        ", vaccine=" + vaccine +
        '}';
  }

}
