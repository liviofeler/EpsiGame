package com.epsigames.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epsigames.beans.Utilisateur;

public class UtilisateurBDD {
    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        // Chargement du driver
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {

        }

        // Connexion à la base
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/epsigames", "sdz", "livio" );
            statement = connexion.createStatement();

            // Exécution de la requète
            resultat = statement.executeQuery( "Select * FROM utilisateur;" );

            // Récupération des données
            while ( resultat.next() ) {

                String nom = resultat.getString( "nom" );
                String prenom = resultat.getString( "prenom" );
                String adresse = resultat.getString( "adresse" );
                String plateform = resultat.getString( "plateforme" );
                String motDePasse = resultat.getString( "motDePasse" );

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom( nom );
                utilisateur.setPrenom( prenom );
                utilisateur.setAdresse( adresse );
                utilisateur.setPlateforme( plateform );
                utilisateur.setMotDePasse( motDePasse );

                utilisateurs.add( utilisateur );
            }
        } catch ( SQLException e ) {

        } finally {
            // Fermeture de la connexion
            try {
                if ( resultat != null )
                    resultat.close();
                if ( statement != null )
                    statement.close();
                if ( connexion != null )
                    connexion.close();
            } catch ( SQLException ignore ) {

            }
        }
        return utilisateurs;

    }

}
