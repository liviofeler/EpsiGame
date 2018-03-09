package com.epsigames.bdd;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.epsigames.beans.Utilisateur;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestJDBC {
    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> Utilisateur = new ArrayList<Utilisateur>();
        // chargement du driver
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {

        }

        // Connexion à la base de données
        /*
         * String url = "jdbc:mysql://localhost:3306/epsiGames"; String
         * utilisateur = "sdz"; String motDePasse = "livio";
         */
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

    return List<Utilisateur>;}
}