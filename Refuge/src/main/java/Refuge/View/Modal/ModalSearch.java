package Refuge.View.Modal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Refuge.Model.Animal;
import Refuge.Swinger.*;

public class ModalSearch extends Modal {
    private Field name, old, race;
    private Combo kind, gender, sterilized, vaccinated;

    public ModalSearch() {

        super();
        setTitle("Rechercher un animal");

        Label nom = new Label("Nom", 0.05, 0.05, 0.1, 0.025);

        add(nom);

        name = new Field("", 0.25, 0.05, 0.2, 0.025);

        add(name);

        Label age = new Label("Âge", 0.05, 0.1, 0.1, 0.025);

        add(age);

        old = new Field("", 0.25, 0.1, 0.2, 0.025);

        add(old);

        Label raceLabel = new Label("Race", 0.05, 0.15, 0.1, 0.025);

        add(raceLabel);

        race = new Field("", 0.25, 0.15, 0.2, 0.025);

        add(race);

        Label kindLabel = new Label("Espèce", 0.05, 0.2, 0.1, 0.025);

        add(kindLabel);

        String[] kinds = { "Tous", "Chats", "Chiens" };
        kind = new Combo(kinds, 0.25, 0.2, 0.2, 0.025);

        add(kind);

        Label genderLabel = new Label("Sexe", 0.05, 0.25, 0.1, 0.025);

        add(genderLabel);

        String[] genders = { "Tous", "Mâle", "Femelle" };
        gender = new Combo(genders, 0.25, 0.25, 0.2, 0.025);

        add(gender);

        Label vaccinatedLabel = new Label("Vaccination", 0.05, 0.30, 0.1, 0.025);

        add(vaccinatedLabel);

        String[] vaccinateds = { "Peu importe", "Vacciné", "Pas vacciné" };
        vaccinated = new Combo(vaccinateds, 0.25, 0.30, 0.2, 0.025);

        add(vaccinated);

        Label sterilizedLabel = new Label("Stérilisation", 0.05, 0.35, 0.1, 0.025);

        add(sterilizedLabel);

        String[] sterilizeds = { "Peu importe", "Stérilisé", "Pas stérilisé" };
        sterilized = new Combo(sterilizeds, 0.25, 0.35, 0.2, 0.025);

        add(sterilized);

        Button button = new Button("Rechercher", 0.2, 0.4, 0.1, 0.025);
        button.onClick(() -> search());

        add(button);
    }

    private List<Animal> search() {
        System.out.println("TODO : Recherche d'animaux");
        return new ArrayList<>();
    }
}
