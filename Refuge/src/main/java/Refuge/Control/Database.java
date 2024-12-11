package Refuge.Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
  // SQL query constants
  private static final String INSERT_FILM = "INSERT INTO films (titre, realisateur, annee) VALUES (?, ?, ?)";
  private static final String CHECK_FILM_EXISTS = "SELECT COUNT(*) FROM films WHERE titre = ? AND realisateur = ? AND annee = ?";
  private static final String CREATE_TABLE = """
      CREATE TABLE IF NOT EXISTS films (
          id INT AUTO_INCREMENT PRIMARY KEY,
          titre VARCHAR(255) NOT NULL,
          realisateur VARCHAR(255) NOT NULL,
          annee INT NOT NULL,
          UNIQUE KEY unique_film (titre, realisateur, annee)
      )""";

  // Instance of our connection class
  private static final Connexion connexion = new Connexion();

  public Database() {
    initializeDatabase();
  }

  private void initializeDatabase() {
    try (Statement stmt = connexion.getConnection().createStatement()) {
      stmt.execute(CREATE_TABLE);
      System.out.println("Table 'films' created or verified successfully.");
    } catch (SQLException e) {
      System.err.println("Error creating table: " + e.getMessage());
    }
  }

  public static boolean ajouterFilm(String titre, String realisateur, int annee) {
    // Input validation
    if (titre == null || titre.trim().isEmpty()) {
      throw new IllegalArgumentException("Le titre ne peut pas être vide");
    }
    if (realisateur == null || realisateur.trim().isEmpty()) {
      throw new IllegalArgumentException("Le réalisateur ne peut pas être vide");
    }
    if (annee < 1895 || annee > 2100) { // Basic year validation
      throw new IllegalArgumentException("L'année n'est pas valide");
    }

    Connection connection = null;
    PreparedStatement checkStatement = null;
    PreparedStatement insertStatement = null;
    ResultSet resultSet = null;

    try {
      connection = connexion.getConnection();
      connection.setAutoCommit(false); // Start transaction

      // Check if film already exists
      checkStatement = connection.prepareStatement(CHECK_FILM_EXISTS);
      checkStatement.setString(1, titre);
      checkStatement.setString(2, realisateur);
      checkStatement.setInt(3, annee);
      resultSet = checkStatement.executeQuery();

      if (resultSet.next() && resultSet.getInt(1) > 0) {
        System.out.println("Le film existe déjà dans la base de données.");
        return false;
      }

      // Insert new film
      insertStatement = connection.prepareStatement(INSERT_FILM);
      insertStatement.setString(1, titre.trim());
      insertStatement.setString(2, realisateur.trim());
      insertStatement.setInt(3, annee);

      int rowsInserted = insertStatement.executeUpdate();
      connection.commit(); // Commit transaction

      System.out.println(rowsInserted + " film(s) ajouté(s) avec succès.");
      return rowsInserted > 0;

    } catch (SQLException e) {
      try {
        if (connection != null) {
          connection.rollback(); // Rollback on error
        }
      } catch (SQLException ex) {
        System.err.println("Erreur lors du rollback : " + ex.getMessage());
      }
      System.err.println("Erreur lors de l'ajout du film : " + e.getMessage());
      return false;

    } finally {
      // Close resources in reverse order of creation
      try {
        if (resultSet != null)
          resultSet.close();
        if (checkStatement != null)
          checkStatement.close();
        if (insertStatement != null)
          insertStatement.close();
        if (connection != null) {
          connection.setAutoCommit(true); // Reset auto-commit
        }
      } catch (SQLException e) {
        System.err.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
      }
    }
  }
}
