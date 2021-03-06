package com.epsigames.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epsigames.beans.Utilisateur;

public class UtilisateurBDD {

    private Connection connexion;

    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        // Represente la requete Sql
        Statement statement = null;
        // Repr�sente les r�sultats
        ResultSet resultat = null;

        loadDatabase();
        try {

            statement = connexion.createStatement();

            // Ex�cution de la requ�te
            resultat = statement.executeQuery( "Select nom, prenom FROM utilisateur;" );

            // R�cup�ration des donn�es
            while ( resultat.next() ) {

                String nom = resultat.getString( "nom" );
                String prenom = resultat.getString( "prenom" );

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom( nom );
                utilisateur.setPrenom( prenom );

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

    private void loadDatabase() {
        // Chargement du driver
        // Chargement du driver
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {

        }

        try {
            connexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/epsigames", "root", "livio" );
        } catch ( SQLException e ) {
            e.printStackTrace();

        }

    }

    public void ajouterUtilisateur( Utilisateur utilisateur ) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(
                    "Insert INTO utilisateur (nom, prenom, adresse, motDePasse,email) VALUES (?, ?, ?, ?, ?);" );
            preparedStatement.setString( 1, utilisateur.getNom() );
            preparedStatement.setString( 2, utilisateur.getPrenom() );
            preparedStatement.setString( 3, utilisateur.getAdresse() );
            preparedStatement.setString( 4, utilisateur.getMotDePasse() );
            preparedStatement.setString( 5, utilisateur.getEmail() );

            preparedStatement.executeUpdate();
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
