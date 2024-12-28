package Refuge.View.Bar;

import Refuge.App;
import Refuge.Swinger.*;
import Refuge.View.Modal.AccountModal;
import Refuge.View.Modal.ContactModal;

import java.awt.Color;

public class BarVisitor extends BarBase {

    public BarVisitor() {
        super(); // Appel au constructeur de la classe BarBase

        // Configuration générale de la barre
        setBackground(Palette.DARK0_SOFT);
        setLayout(null);
        // Ajouter Bouton Specifique à gauche
        ajouterBoutonAide();
        ajouterBoutonContact();

        // Ajouter les boutons spécifiques à droite
        ajouterBoutonChien();
        ajouterBoutonChat();
        ajouterBoutonRecherche();
    }

}
