package Refuge.View.Modal;

import javax.swing.*;
import java.awt.*;

public class ContactModal extends JDialog {
    private JLabel emailLabel, phoneLabel;
    private JTextField userContactEmailField;
    private JTextArea messageField;
    private JButton submitButton;

    public ContactModal(Frame parent) {
        super(parent, "Contact", true);

        // Définir une icône personnalisée pour le modal
        ImageIcon icon = new ImageIcon(getClass().getResource("/icones/placeholder.png"));
        setIconImage(icon.getImage());

        // Configuration de la fenêtre
        setSize(500, 500); // Taille fixe ajustée
        setLocationRelativeTo(parent); // Centrer la fenêtre

        // Panel principal avec fond moderne
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titre stylisé
        JLabel titleLabel = new JLabel("Contactez-nous", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        // Champs du formulaire
        int row = 1;
        addReadOnlyField(mainPanel, gbc, row++, "Numéro de téléphone :", phoneLabel = new JLabel("450-654-6789"));
        addReadOnlyField(mainPanel, gbc, row++, "Notre adresse courriel :",
                emailLabel = new JLabel("Parapluie@gmail.com"));
        addStyledField(mainPanel, gbc, row++, "Votre courriel :", userContactEmailField = new JTextField());

        // Champ de texte pour le message
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel messageLabel = new JLabel("Votre message :");
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        messageLabel.setForeground(Color.DARK_GRAY);
        mainPanel.add(messageLabel, gbc);

        gbc.gridx = 1;
        messageField = new JTextArea(5, 20);
        messageField.setLineWrap(true);
        messageField.setWrapStyleWord(true);
        messageField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        messageField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        JScrollPane scrollPane = new JScrollPane(messageField);
        mainPanel.add(scrollPane, gbc);

        // Bouton stylisé
        submitButton = new JButton("Envoyer");
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

    private void addReadOnlyField(JPanel panel, GridBagConstraints gbc, int row, String labelText, JLabel label) {
        gbc.gridwidth = 1;

        // Label pour le texte
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel fieldLabel = new JLabel(labelText);
        fieldLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fieldLabel.setForeground(Color.DARK_GRAY);
        panel.add(fieldLabel, gbc);

        // Champ de texte en lecture seule
        gbc.gridx = 1;
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setOpaque(true);
        label.setBackground(new Color(245, 245, 245));
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        panel.add(label, gbc);
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
        String userContactEmail = userContactEmailField.getText();
        String message = messageField.getText();

        if (userContactEmail.isEmpty() || message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Votre message a été envoyé avec succès !\n" +
                        "Nous vous répondrons à : " + userContactEmail,
                "Succès", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
