package Refuge.View.Modal;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class SearchModal extends JDialog {
    private JTextField nameField, ageMinField, ageMaxField, raceField;
    private JComboBox<String> speciesField, genderComboBox;
    private JComboBox<String> sterilizedComboBox, vaccinatedComboBox;
    private JButton searchButton, resetButton;
    private JCheckBox useAgeRange;

    public SearchModal(Frame parent) {
        super(parent, "Rechercher un animal", true);

        // Configuration de base
        ImageIcon icon = new ImageIcon(getClass().getResource("/icones/placeholder.png"));
        setIconImage(icon.getImage());
        setSize(600, 700);
        setLocationRelativeTo(parent);

        // Panel principal
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titre
        JLabel titleLabel = new JLabel("Recherche d'Animaux", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        // Initialisation des champs
        int row = 1;

        // Critères de base
        addStyledField(mainPanel, gbc, row++, "Nom :", nameField = new JTextField());

        // ComboBox pour l'espèce avec option "Tous"
        String[] speciesOptions = { "Tous", "Chat", "Chien", "Autre" };
        addStyledField(mainPanel, gbc, row++, "Espèce :",
                speciesField = new JComboBox<>(speciesOptions));

        // Panel pour la plage d'âge
        JPanel agePanel = new JPanel(new GridBagLayout());
        agePanel.setBackground(new Color(245, 245, 245));
        TitledBorder ageBorder = BorderFactory.createTitledBorder("Âge (en mois)");
        ageBorder.setTitleFont(new Font("Segoe UI", Font.PLAIN, 14));
        agePanel.setBorder(ageBorder);

        useAgeRange = new JCheckBox("Utiliser une plage d'âge");
        useAgeRange.setBackground(new Color(245, 245, 245));
        GridBagConstraints ageGbc = new GridBagConstraints();
        ageGbc.gridwidth = 2;
        ageGbc.insets = new Insets(5, 5, 5, 5);
        agePanel.add(useAgeRange, ageGbc);

        ageMinField = new JTextField(5);
        ageMaxField = new JTextField(5);
        ageMinField.setEnabled(false);
        ageMaxField.setEnabled(false);

        useAgeRange.addActionListener(e -> {
            boolean selected = useAgeRange.isSelected();
            ageMinField.setEnabled(selected);
            ageMaxField.setEnabled(selected);
        });

        JPanel ageFieldsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ageFieldsPanel.setBackground(new Color(245, 245, 245));
        ageFieldsPanel.add(new JLabel("De:"));
        ageFieldsPanel.add(ageMinField);
        ageFieldsPanel.add(new JLabel("à:"));
        ageFieldsPanel.add(ageMaxField);
        agePanel.add(ageFieldsPanel);

        gbc.gridwidth = 2;
        gbc.gridy = row++;
        mainPanel.add(agePanel, gbc);
        gbc.gridwidth = 1;

        // Autres critères
        addStyledField(mainPanel, gbc, row++, "Race :", raceField = new JTextField());

        String[] genderOptions = { "Tous", "Mâle", "Femelle" };
        addStyledField(mainPanel, gbc, row++, "Sexe :",
                genderComboBox = new JComboBox<>(genderOptions));

        String[] yesNoOptions = { "Tous", "Oui", "Non" };
        addStyledField(mainPanel, gbc, row++, "Stérilisé :",
                sterilizedComboBox = new JComboBox<>(yesNoOptions));
        addStyledField(mainPanel, gbc, row++, "Vacciné :",
                vaccinatedComboBox = new JComboBox<>(yesNoOptions));

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBackground(new Color(245, 245, 245));

        // Bouton de réinitialisation
        resetButton = new JButton("Réinitialiser");
        resetButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resetButton.setForeground(Color.WHITE);
        resetButton.setBackground(new Color(158, 158, 158));
        resetButton.setFocusPainted(false);
        resetButton.addActionListener(e -> resetFields());
        buttonPanel.add(resetButton);

        // Bouton de recherche
        searchButton = new JButton("Rechercher");
        searchButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBackground(new Color(33, 150, 243));
        searchButton.setFocusPainted(false);
        searchButton.addActionListener(e -> handleSearch());
        buttonPanel.add(searchButton);

        gbc.gridwidth = 2;
        gbc.gridy = row;
        gbc.insets = new Insets(20, 10, 10, 10);
        mainPanel.add(buttonPanel, gbc);

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
        if (field instanceof JTextField) {
            field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        }
        panel.add(field, gbc);
    }

    private void resetFields() {
        nameField.setText("");
        speciesField.setSelectedIndex(0);
        ageMinField.setText("");
        ageMaxField.setText("");
        useAgeRange.setSelected(false);
        ageMinField.setEnabled(false);
        ageMaxField.setEnabled(false);
        raceField.setText("");
        genderComboBox.setSelectedIndex(0);
        sterilizedComboBox.setSelectedIndex(0);
        vaccinatedComboBox.setSelectedIndex(0);
    }

    private void handleSearch() {
        // Validation de l'âge si la plage est active
        if (useAgeRange.isSelected()) {
            try {
                if (!ageMinField.getText().trim().isEmpty()) {
                    Integer.parseInt(ageMinField.getText().trim());
                }
                if (!ageMaxField.getText().trim().isEmpty()) {
                    Integer.parseInt(ageMaxField.getText().trim());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Les valeurs d'âge doivent être des nombres entiers.",
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // TODO: Implémenter la logique de recherche
        dispose();
    }
}