package Refuge.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Function;

import Refuge.Control.Connexion;

public final class RequeteSql {

    private static Connexion connexion = new Connexion();

    private RequeteSql() {
    }

    // Méthode générique pour exécuter une requête et traiter le ResultSet
    private static <T> T executerRequete(String requete, Function<ResultSet, T> handler) {
        try {

            Connection connection = connexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(requete);
            ResultSet resultSet = statement.executeQuery();

            // Passe le ResultSet au handler pour traitement
            return handler.apply(resultSet);

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> obtenirListePhotos(int identificationAnimal) {
        String query = "SELECT * FROM photos_animaux WHERE identification = " + identificationAnimal;

        // Appelle executerRequete avec un handler pour traiter les résultats
        return executerRequete(query, resultSet -> {
            ArrayList<String> listePhotos = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    listePhotos.add(resultSet.getString("photo_chemin"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listePhotos;
        });
    }

    public static ArrayList<Animal> obtenirListeAnimaux() {
        String query = "SELECT * FROM animaux";

        // Appelle executerRequete avec un handler pour traiter les résultats
        return executerRequete(query, resultSet -> {
            ArrayList<Animal> listeAnimaux = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    int identification = resultSet.getInt("identification");
                    String nom = resultSet.getString("nom");
                    int ageMois = resultSet.getInt("age_mois");
                    String espece = resultSet.getString("espece");
                    String sexe = resultSet.getString("sexe");
                    String race = resultSet.getString("race");
                    String couleur = resultSet.getString("couleur");
                    String description = resultSet.getString("description");
                    boolean sterilise = resultSet.getInt("sterilise") == 1;
                    boolean vaccine = resultSet.getInt("vaccine") == 1;
                    ArrayList<String> listePhotos = obtenirListePhotos(identification);

                    Animal animal;
                    if ("chat".equals(espece)) {
                        animal = new Cat(identification, nom, ageMois, sexe, race, couleur, description,
                                sterilise, vaccine, listePhotos);
                    } else {
                        animal = new Dog(identification, nom, ageMois, sexe, race, couleur, description,
                                sterilise, vaccine, listePhotos);
                    }
                    listeAnimaux.add(animal);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listeAnimaux;
        });
    }
}
