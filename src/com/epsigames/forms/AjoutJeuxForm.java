package com.epsigames.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.epsigames.bdd.JeuxBDD;
import com.epsigames.beans.Jeux;

public class AjoutJeuxForm {
    public static final String  CHAMP_Titre               = "titre";
    public static final String  CHAMP_SousTitre           = "sousTitre";
    public static final String  CHAMP_SocieteDeProduction = "societeDeProduction";
    public static final String  CHAMP_Description         = "description";
    public static final String  CHAMP_Genre               = "genre";
    public static final String  CHAMP_PaysDeProduction    = "paysDeProduction";
    public static final String  CHAMP_AnneeDeProduction   = "anneeDeProduction";

    private String              resultat;
    private Map<String, String> erreurs                   = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Jeux ajouterJeux( HttpServletRequest request ) {
        String titre = getValeurChamp( request, CHAMP_Titre );
        String sousTitre = getValeurChamp( request, CHAMP_SousTitre );
        String societeDeProduction = getValeurChamp( request, CHAMP_SocieteDeProduction );
        String description = getValeurChamp( request, CHAMP_Description );
        String genre = getValeurChamp( request, CHAMP_Genre );
        String paysDeProduction = getValeurChamp( request, CHAMP_PaysDeProduction );
        String anneeDeProduction = getValeurChamp( request, CHAMP_AnneeDeProduction );

        Jeux jeux = new Jeux();

        try {
            validationChamp( titre );
        } catch ( Exception e ) {
            setErreur( CHAMP_Titre, e.getMessage() );
        }
        jeux.setTitre( titre );
        try {

            validationChamp( sousTitre );
        } catch ( Exception e ) {

            setErreur( CHAMP_SousTitre, e.getMessage() );
        }

        jeux.setSousTitre( sousTitre );
        try {
            validationChamp( societeDeProduction );
        } catch ( Exception e ) {
            setErreur( CHAMP_SocieteDeProduction, e.getMessage() );
        }
        jeux.setSocieteDeProduction( societeDeProduction );
        jeux.setDescription( description );

        try {
            validationChamp( genre );
        } catch ( Exception e ) {
            setErreur( CHAMP_Genre, e.getMessage() );
        }
        jeux.setGenre( genre );
        try {
            validationChamp( paysDeProduction );
        } catch ( Exception e ) {
            setErreur( CHAMP_PaysDeProduction, e.getMessage() );
        }
        jeux.setPaysDeProduction( paysDeProduction );
        ;
        try {
            validationAnnee( anneeDeProduction );
        } catch ( Exception e ) {
            setErreur( CHAMP_AnneeDeProduction, e.getMessage() );
        }
        jeux.setAnneeDeRealisation( anneeDeProduction );
        /* Initialisation du résultat global de la validation */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout";

            JeuxBDD tableJeux = new JeuxBDD();
            tableJeux.ajouterJeux( jeux );

        } else {
            resultat = "Echec de l'ajout";
        }

        return jeux;

    }

    private void validationChamp( String champ ) throws Exception {
        if ( champ != null && champ.length() < 3 ) {
            throw new Exception( "Le champ doit comporter au moins 3 caractères" );
        } else {
            throw new Exception( "Merci de remplir le champs." );
        }
    }

    private void validationAnnee( String champ ) throws Exception {
        if ( champ != null && champ.length() < 3 ) {
            throw new Exception( "La date doit contenir 5 chiffres" );
        } else {
            throw new Exception( "Merci de remplir le champs de date." );
        }
    }

    /*
     * Ajoute un message correspondant au champs spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }

    }

}
