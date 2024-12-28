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
        ajouterBoutonEmployer();
        ajouterBoutonAjouterAnimal();
        ajouterBoutonChien();
        ajouterBoutonChat();
        ajouterBoutonRecherche();
    }

}
