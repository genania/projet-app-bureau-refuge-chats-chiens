package Refuge.View.Modal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddAnimalModal extends JDialog {
    private JTextField nameField, ageField, speciesField, raceField, colorField;
    private JTextArea descriptionArea;
    private JComboBox<String> genderComboBox;
    private JRadioButton sterilizedYes, sterilizedNo;
    private JRadioButton vaccinatedYes, vaccinatedNo;
    private ButtonGroup sterilizedGroup, vaccinatedGroup;
    private JButton photoButton;
    private JButton submitButton;
    private List<String> photosPaths;

    public AddAnimalModal(Frame parent) {
        super(parent, "Ajouter un animal", true);

        // Configuration de base
        ImageIcon icon = new ImageIcon(getClass().getResource("/icones/placeholder.png"));
        setIconImage(icon.getImage());
        setSize(600, 850);
        setLocationRelativeTo(parent);
        photosPaths = new ArrayList<>();

        // Panel principal
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titre
        JLabel titleLabel = new JLabel("Ajouter un Animal", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        // Initialisation des champs
        int row = 1;
        addStyledField(mainPanel, gbc, row++, "Nom :", nameField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Âge (en mois) :", ageField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Espèce :", speciesField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Sexe :",
                genderComboBox = new JComboBox<>(new String[] { "Mâle", "Femelle" }));
        addStyledField(mainPanel, gbc, row++, "Race :", raceField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Couleur :", colorField = new JTextField());

        // Zone de description
        JLabel descLabel = new JLabel("Description :");
        descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descLabel.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = row;
        mainPanel.add(descLabel, gbc);

        descriptionArea = new JTextArea(4, 20);
        descriptionArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        gbc.gridx = 1;
        mainPanel.add(scrollPane, gbc);
        row++;

        // Radio buttons pour stérilisation
        addRadioButtonGroup(mainPanel, gbc, row++, "Stérilisé :",
                sterilizedYes = new JRadioButton("Oui"),
                sterilizedNo = new JRadioButton("Non"),
                sterilizedGroup = new ButtonGroup());

        // Radio buttons pour vaccination
        addRadioButtonGroup(mainPanel, gbc, row++, "Vacciné :",
                vaccinatedYes = new JRadioButton("Oui"),
                vaccinatedNo = new JRadioButton("Non"),
                vaccinatedGroup = new ButtonGroup());

        // Bouton pour les photos
        photoButton = new JButton("Ajouter des photos");
        photoButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        photoButton.setBackground(new Color(76, 175, 80));
        photoButton.setForeground(Color.WHITE);
        photoButton.setFocusPainted(false);
        photoButton.addActionListener(e -> handlePhotoSelection());
        gbc.gridwidth = 2;
        gbc.gridy = row++;
        mainPanel.add(photoButton, gbc);

        // Bouton de soumission
        submitButton = new JButton("Ajouter l'animal");
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(33, 150, 243));
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        submitButton.addActionListener(e -> handleSubmit());
        gbc.gridy = row;
        mainPanel.add(submitButton, gbc);

        add(mainPanel);
    }

    private void addStyledField(JPanel panel, GridBagConstraints gbc, int row, String labelText, JComponent field) {
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = row;

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(Color.DARK_GRAY);
        panel.add(label, gbc);

        gbc.gridx = 1;
        field.setPreferredSize(new Dimension(250, 30));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        panel.add(field, gbc);
    }

    private void addRadioButtonGroup(JPanel panel, GridBagConstraints gbc, int row,
            String labelText, JRadioButton btn1, JRadioButton btn2, ButtonGroup group) {

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = row;

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(Color.DARK_GRAY);
        panel.add(label, gbc);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.setBackground(new Color(245, 245, 245));

        group.add(btn1);
        group.add(btn2);
        btn1.setSelected(true);

        btn1.setBackground(new Color(245, 245, 245));
        btn2.setBackground(new Color(245, 245, 245));

        radioPanel.add(btn1);
        radioPanel.add(btn2);

        gbc.gridx = 1;
        panel.add(radioPanel, gbc);
    }

    private void handlePhotoSelection() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "Images", "jpg", "jpeg", "png", "gif"));

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
                ageField.getText().trim().isEmpty() ||
                speciesField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez remplir tous les champs obligatoires (nom, âge, espèce).",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validation de l'âge
        try {
            Integer.parseInt(ageField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "L'âge doit être un nombre entier.",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Animal ajouté avec succès!",
                "Succès", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}