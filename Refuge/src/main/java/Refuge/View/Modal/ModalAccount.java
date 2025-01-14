package Refuge.View.Modal;

import java.util.ArrayList;
import java.util.List;

import Refuge.Swinger.*;

public class ModalAccount extends Modal {
    private Field name, mail, phone, password1, password2;
    private Combo department;

    public ModalAccount() {
        super();
        setTitle("Créer un compte");

        Label nom = new Label("Nom", 0.05, 0.05, 0.1, 0.025);

        add(nom);

        name = new Field("", 0.25, 0.05, 0.2, 0.025);

        add(name);

        Label courriel = new Label("Courriel", 0.05, 0.1, 0.1, 0.025);

        add(courriel);

        mail = new Field("", 0.25, 0.1, 0.2, 0.025);

        add(mail);

        Label telephone = new Label("Téléphone", 0.05, 0.15, 0.1, 0.025);

        add(telephone);

        phone = new Field("", 0.25, 0.15, 0.2, 0.025);

        add(phone);

        Label mdp = new Label("Mot de passe", 0.05, 0.2, 0.1, 0.025);

        add(mdp);

        password1 = new Field("", 0.25, 0.2, 0.2, 0.025);

        add(password1);

        password2 = new Field("", 0.25, 0.25, 0.2, 0.025);

        add(password2);

        Label departement = new Label("Département", 0.05, 0.30, 0.1, 0.025);

        add(departement);

        String[] departments = { "Client", "Employé", "Gestion" };
        department = new Combo(departments, 0.25, 0.30, 0.2, 0.025);

        add(department);

        Button button = new Button("S'inscrire", 0.2, 0.375, 0.1, 0.025);
        button.onClick(() -> subscribe());

        add(button);
    }

    private void subscribe() {
        List<String> fields = new ArrayList<>();
        System.out.println("TODO : Subscription button");
    }
}
