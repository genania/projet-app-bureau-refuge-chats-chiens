package Refuge.Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
  // Database Configuration Constants
  // Note: If using Docker Toolbox on Windows, you might need to use
  // "host.docker.internal" instead of "localhost"
  private static final String DB_HOST = "localhost";
  private static final String DB_PORT = "3306"; // Should match your ${MYSQL_PORT}
  private static final String DB_NAME = "bd_refuge";
  private static final String DB_URL = String.format(
      "jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
      DB_HOST, DB_PORT, DB_NAME);
  private static final String DB_USER = "user_refuge";
  private static final String DB_PASSWORD = "fg4HGTr85h28"; // Should match your ${MYSQL_ROOT_PASSWORD}

  // Database connection objects
  private Connection connexion;
  private Statement statement;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  public Connexion() {
    try {
      // Explicitly load the MySQL driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // Establish connection
      connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
      statement = connexion.createStatement();

      System.out.println("Database connection established successfully!");

    } catch (ClassNotFoundException e) {
      System.err.println("MySQL JDBC Driver not found!");
      e.printStackTrace();
    } catch (SQLException e) {
      System.err.println("Connection failed! Check if Docker container is running.");
      System.err.println("Error: " + e.getMessage());
      System.err.println("SQLState: " + e.getSQLState());
      System.err.println("Error Code: " + e.getErrorCode());
      System.err.println("Make sure:");
      System.err.println("1. Docker container is running (docker ps)");
      System.err.println("2. Port " + DB_PORT + " is correctly mapped");
      System.err.println("3. Password matches MYSQL_ROOT_PASSWORD");
      System.err.println("4. Database '" + DB_NAME + "' exists");
      e.printStackTrace();
    }
  }

  // Get connection method
  public Connection getConnection() {
    return connexion;
  }

  // Close all resources
  // public void closeConnection() {
  // try {
  // if (resultSet != null) {
  // resultSet.close();
  // }
  // if (statement != null) {
  // statement.close();
  // }
  // if (preparedStatement != null) {
  // preparedStatement.close();
  // }
  // if (connexion != null) {
  // connexion.close();
  // System.out.println("Database connection closed successfully!");
  // }
  // } catch (SQLException e) {
  // System.err.println("Error closing database resources!");
  // e.printStackTrace();
  // }
  // }

  // Test if connection is valid
  public boolean isConnected() {
    try {
      return connexion != null && !connexion.isClosed();
    } catch (SQLException e) {
      return false;
    }
  }

  // // Method to test the connection
  // public static void test(String[] args) {
  // Connexion conn = new Connexion();

  // if (conn.isConnected()) {
  // System.out.println("Connection test successful!");
  // // Try to create the database if it doesn't exist
  // try {
  // Statement stmt = conn.getConnection().createStatement();
  // stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
  // System.out.println("Database verified/created successfully!");
  // } catch (SQLException e) {
  // System.err.println("Error creating database: " + e.getMessage());
  // }
  // conn.closeConnection();
  // } else {
  // System.out.println("Connection test failed!");
  // }
  // }
}
