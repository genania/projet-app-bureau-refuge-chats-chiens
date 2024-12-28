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
        ajouterBoutonAjouterAnimal();
        ajouterBoutonChien();
        ajouterBoutonChat();
        ajouterBoutonRecherche();

    }

}
