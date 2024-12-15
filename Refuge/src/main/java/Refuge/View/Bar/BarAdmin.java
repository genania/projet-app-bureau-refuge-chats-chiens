package Refuge.View.Bar;

import Refuge.App;
import Refuge.Swinger.*;
import java.awt.Color;

public class BarAdmin extends BarBase {

    public BarAdmin() {
        super(); // Appel au constructeur de la classe Bar

        // Ajouter les boutons spécifiques à droite
        ajouterBoutonsDroite();
    }

    private void ajouterBoutonsDroite() {
        ajouterBoutonAjouterAnimal();
        ajouterBoutonChat();
        ajouterBoutonChien();
        ajouterBoutonEmployer();
    }

    private void ajouterBoutonAjouterAnimal() {
        ajouterBoutonDroit("Ajouter un Animal", () -> {
            System.out.println("Page Ajouter un Animal ouverte");
        });
    }

    private void ajouterBoutonChat() {
        ajouterBoutonDroit("Chat", () -> {
            System.out.println("Page Chat ouverte");
        });
    }

    private void ajouterBoutonChien() {
        ajouterBoutonDroit("Chien", () -> {
            System.out.println("Page Chien ouverte");
        });
    }

    private void ajouterBoutonEmployer() {
        ajouterBoutonDroit("Employer", () -> {
            System.out.println("Page Employer ouverte");
        });
    }
}
