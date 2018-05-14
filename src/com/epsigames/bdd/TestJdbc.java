package com.epsigames.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    {
        try {
            Class.forName( "com.mysql.jdbc.Driver " );

        } catch ( ClassNotFoundException e ) {

        }
        // Connexion à la base de donnée
        String url = "jdbc:mysql://localhost:3306/EpsiGames";
        String utilisateur = "sdz";
        String motDePasse = "livio";
        Connection connexion = null;
        // etablissement de la connexion
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
            // Ici se trouverons les requêtes vers la bdd
        } catch ( SQLException e ) {
            // Gère les erreurs
        } finally {
            if ( connexion != null )
                try {
                    // Fermeture de la connexion
                    connexion.close();
                } catch ( SQLException ignore ) {
                    // Si une erreur survient lors de la fermeture , il suffit
                    // d'ignorer

                }

        }

    }
}