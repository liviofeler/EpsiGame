package com.epsigames.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epsigames.beans.Jeux;

public class JeuxBDD {
    private Connection connexion;

    public List<Jeux> recupererJeux() {
        List<Jeux> jeux = new ArrayList<Jeux>();

        // Represente la requete Sql
        Statement statement = null;
        // Représente les résultats
        ResultSet resultat = null;

        loadDatabase();
        try {

            statement = connexion.createStatement();

            // Exécution de la requète
            resultat = statement.executeQuery( "Select titre, societeDeProduction FROM jeux;" );

            // Récupération des données
            while ( resultat.next() ) {

                String titre = resultat.getString( "titre" );
                String societeDeProduction = resultat.getString( "societeDeProduction" );

                Jeux jeux1 = new Jeux();
                jeux1.setTitre( titre );
                jeux1.setSocieteDeProduction( societeDeProduction );

                jeux.add( jeux1 );
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
        return jeux;

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

    public void ajouterJeux( Jeux jeux ) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(
                    "Insert INTO jeux (titre, sousTitre, societeDeProduction, description, genre, paysDeProduction, anneeDeProduction) VALUES (?, ?, ?, ?, ?, ?,?);" );
            preparedStatement.setString( 1, jeux.getTitre() );
            preparedStatement.setString( 2, jeux.getSousTitre() );
            preparedStatement.setString( 3, jeux.getSocieteDeProduction() );
            preparedStatement.setString( 4, jeux.getPaysDeProduction() );
            preparedStatement.setString( 5, jeux.getDescription() );
            preparedStatement.setString( 6, jeux.getGenre() );
            preparedStatement.setString( 7, jeux.getAnneeDeRealisation() );

            preparedStatement.executeUpdate();
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
