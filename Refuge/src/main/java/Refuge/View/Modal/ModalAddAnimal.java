package Refuge.View.Modal;

import Refuge.Swinger.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ModalAddAnimal extends Modal {
    private Field nameField, ageField, raceField, colorField;
    private Scroll descriptionArea;
    private Combo genderCombo, sterilizedCombo, vaccinatedCombo, speciesField;
    private Button photoButton, submitButton;
    private List<String> photosPaths;

    public ModalAddAnimal() {
        super();
        setTitle("Ajouter un animal");
        photosPaths = new ArrayList<>();

        double labelX = 0.05;
        double fieldX = 0.25;
        double startY = 0.05;
        double gap = 0.05;
        double labelWidth = 0.15;
        double fieldWidth = 0.2;
        double height = 0.025;

        // Titre
        add(new Label("Ajouter un Animal", labelX, startY, labelWidth, height));

        // Nom
        add(new Label("Nom :", labelX, startY + gap, labelWidth, height));
        nameField = new Field("", fieldX, startY + gap, fieldWidth, height);
        add(nameField);

        // Âge
        add(new Label("Âge (en mois) :", labelX, startY + gap * 2, labelWidth, height));
        ageField = new Field("", fieldX, startY + gap * 2, fieldWidth, height);
        add(ageField);

        // Espèce
        add(new Label("Espèce :", labelX, startY + gap * 3, labelWidth, height));
        speciesField = new Combo(new String[] { "Chat", "Chien" }, fieldX, startY + gap * 3, fieldWidth, height);
        add(speciesField);

        // Sexe
        add(new Label("Sexe :", labelX, startY + gap * 4, labelWidth, height));
        genderCombo = new Combo(new String[] { "Mâle", "Femelle" }, fieldX, startY + gap * 4, fieldWidth, height);
        add(genderCombo);

        // Race
        add(new Label("Race :", labelX, startY + gap * 5, labelWidth, height));
        raceField = new Field("", fieldX, startY + gap * 5, fieldWidth, height);
        add(raceField);

        // Couleur
        add(new Label("Couleur :", labelX, startY + gap * 6, labelWidth, height));
        colorField = new Field("", fieldX, startY + gap * 6, fieldWidth, height);
        add(colorField);

        // Description
        add(new Label("Description :", labelX, startY + gap * 7, labelWidth, height));
        descriptionArea = new Scroll("", fieldX, startY + gap * 7, fieldWidth, height * 3);
        add(descriptionArea);

        // Stérilisation
        add(new Label("Stérilisé :", labelX, startY + gap * 10, labelWidth, height));
        String[] sterilizedOptions = new String[] { "Non", "Oui" };
        sterilizedCombo = new Combo(sterilizedOptions, fieldX, startY + gap * 10, fieldWidth, height);
        add(sterilizedCombo);

        // Vaccination
        add(new Label("Vacciné :", labelX, startY + gap * 11, labelWidth, height));
        String[] vaccinatedOptions = new String[] { "Non", "Oui" };
        vaccinatedCombo = new Combo(vaccinatedOptions, fieldX, startY + gap * 11, fieldWidth, height);
        add(vaccinatedCombo);

        // Boutons Photos
        photoButton = new Button("Ajouter des photos", 0.2, startY + gap * 12, fieldWidth, height);
        photoButton.onClick(() -> handlePhotoSelection());
        add(photoButton);

        // Bouton Submit
        submitButton = new Button("Ajouter l'animal", 0.2, startY + gap * 13, fieldWidth, height);
        submitButton.onClick(() -> handleSubmit());
        add(submitButton);
    }

    private void handlePhotoSelection() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif"));

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            java.io.File[] files = fileChooser.getSelectedFiles();
            for (java.io.File file : files) {
                photosPaths.add(file.getPath());
            }
            photoButton.setText("Photos ajoutées (" + photosPaths.size() + ")");
        }
    }

    private void handleSubmit() {
        // Validation de base
        if (nameField.getText().trim().isEmpty() ||
                ageField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Veuillez remplir tous les champs obligatoires (nom, âge, espèce).",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validation de l'âge
        try {
            Integer.parseInt(ageField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "L'âge doit être un nombre entier.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Animal ajouté avec succès!",
                "Succès",
                JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}