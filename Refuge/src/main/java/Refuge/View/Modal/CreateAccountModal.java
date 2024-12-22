package Refuge.View.Modal;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateAccountModal extends JDialog {
    private JTextField nameField, firstNameField, emailField, phoneField, departmentField, categoryField, dobField;
    private JPasswordField passwordField, confirmPasswordField;
    private JComboBox<String> genderComboBox;
    private JButton submitButton;

    private JRadioButton employeButton, adminButton; // Boutons radio
    private ButtonGroup roleGroup; // Groupe pour les boutons radio

    public CreateAccountModal(Frame parent) {
        super(parent, "Créer un compte", true); // Modale bloquante

        // Définir une icône personnalisée pour le modal
        ImageIcon icon = new ImageIcon(getClass().getResource("/icones/placeholder.png"));
        setIconImage(icon.getImage());

        // Configuration de la fenêtre
        setSize(600, 850); // Taille fixe ajustée
        setLocationRelativeTo(parent); // Centrer la fenêtre

        // Panel principal avec fond moderne
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titre stylisé
        JLabel titleLabel = new JLabel("Créer un Compte", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        // Champs du formulaire
        int row = 1;
        addStyledField(mainPanel, gbc, row++, "Nom complet :", nameField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Prénom complet :", firstNameField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Sexe :",
                genderComboBox = new JComboBox<>(new String[] { "Masculin", "Féminin", "Autre" }));
        addStyledField(mainPanel, gbc, row++, "Date de naissance :", dobField = new JTextField("yyyy-MM-dd"));
        addStyledField(mainPanel, gbc, row++, "Courriel :", emailField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Cellulaire :", phoneField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Département :", departmentField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Catégorie :", categoryField = new JTextField());
        addStyledField(mainPanel, gbc, row++, "Mot de passe :", passwordField = new JPasswordField());
        addStyledField(mainPanel, gbc, row++, "Confirmer le mot de passe :",
                confirmPasswordField = new JPasswordField());

        // Choix du rôle : Employé/Bénévole ou Admin
        JLabel roleLabel = new JLabel("Rôle :");
        roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        roleLabel.setForeground(Color.DARK_GRAY);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = row;
        mainPanel.add(roleLabel, gbc);

        employeButton = new JRadioButton("Employé/Bénévole", true);
        adminButton = new JRadioButton("Admin");

        roleGroup = new ButtonGroup();
        roleGroup.add(employeButton);
        roleGroup.add(adminButton);

        JPanel rolePanel = new JPanel();
        rolePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        rolePanel.add(employeButton);
        rolePanel.add(adminButton);
        rolePanel.setBackground(new Color(245, 245, 245));

        gbc.gridx = 1;
        mainPanel.add(rolePanel, gbc);

        // Bouton stylisé
        submitButton = new JButton("Créer");
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(33, 150, 243));
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        submitButton.addActionListener(e -> handleSubmit());

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = ++row;
        mainPanel.add(submitButton, gbc);

        // Ajout du panel dans la fenêtre
        add(mainPanel);
    }

    private void addStyledField(JPanel panel, GridBagConstraints gbc, int row, String labelText, JComponent field) {
        gbc.gridwidth = 1;

        // Label ajusté pour plus de largeur
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(Color.DARK_GRAY);
        panel.add(label, gbc);

        // Champ de texte avec largeur ajustée
        gbc.gridx = 1;
        field.setPreferredSize(new Dimension(250, 30));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        panel.add(field, gbc);
    }

    private void handleSubmit() {
        String name = nameField.getText();
        String firstName = firstNameField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String dob = dobField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String department = departmentField.getText();
        String category = categoryField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        String role = employeButton.isSelected() ? "Employé/Bénévole" : "Admin";

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Les mots de passe ne correspondent pas.", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidDate(dob)) {
            JOptionPane.showMessageDialog(this, "Date de naissance invalide (format: yyyy-MM-dd).", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Compte créé avec succès!\nRôle : " + role,
                "Succès", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private boolean isValidDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
