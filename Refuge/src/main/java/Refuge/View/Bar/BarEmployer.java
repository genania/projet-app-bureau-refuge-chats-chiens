package Refuge.View.Bar;

import Refuge.Swinger.*;
import java.awt.Color;

public class BarEmployer extends BarBase {

    public BarEmployer() {
        super(); // Appel au constructeur de la classe BarBase

        // Configuration générale de la barre
        setBackground(Palette.DARK0_SOFT);
        setLayout(null);

        // Ajouter les boutons spécifiques à droite
        ajouterBoutonsDroite();
    }

    private void ajouterBoutonsDroite() {
        ajouterBoutonChat();
        ajouterBoutonChien();
        ajouterBoutonRecherche();
        ajouterBoutonTrier();
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

    private void ajouterBoutonRecherche() {
        ajouterBoutonDroit("Recherche", () -> {
            System.out.println("Page Recherche ouverte");
        });
    }

    private void ajouterBoutonTrier() {
        ajouterBoutonDroit("Trier", () -> {
            System.out.println("Page Trier ouverte");
        });
    }
}
