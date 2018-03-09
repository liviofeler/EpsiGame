package com.epsigames.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.epsigames.beans.Utilisateur;

public class InscriptionForm {
    public static final String  CHAMP_EMAIL   = "email";
    public static final String  CHAMP_PASS    = "motDePasse";
    public static final String  CHAMP_CONF    = "confirmation";
    public static final String  CHAMP_NOM     = "nom";
    public static final String  CHAMP_PRENOM  = "prenom";
    public static final String  CHAMP_ADRESSE = "adresse";
    public static final String  CHAMP_PC      = "pc";
    public static final String  CHAMP_CONSOLE = "console";

    private String              resultat;
    private Map<String, String> erreurs       = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String adresse = getValeurChamp( request, CHAMP_ADRESSE );
        String pc = getValeurChamp( request, CHAMP_PC );
        String console = getValeurChamp( request, CHAMP_CONSOLE );

        Utilisateur utilisateur = new Utilisateur();

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
        try {

            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, e.getMessage() );
        }

        utilisateur.setMotDePasse( motDePasse );
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );
        try {
            validationAdresse( adresse );
        } catch ( Exception e ) {
            setErreur( CHAMP_ADRESSE, e.getMessage() );
        }
        utilisateur.setAdresse( adresse );
        try {
            validationPlateforme( pc, console );
        } catch ( Exception e ) {
            setErreur( CHAMP_PC, e.getMessage() );
            setErreur( CHAMP_CONSOLE, e.getMessage() );
        }
        utilisateur.setPlateforme( console );
        /* Initialisation du résultat global de la validation */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription";
        } else {
            resultat = "Echec de l'inscription";
        }

        return utilisateur;

    }

    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau" );
            } else if ( motDePasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );

        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 3 ) {
            throw new Exception( "Le prenom doit contenir au moins 3 caractères." );

        }
    }

    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse != null && adresse.length() < 10 ) {
            throw new Exception( "L'adresse  doit contenir au moins 10 caractères." );

        }
    }

    private void validationPlateforme( String pc, String console ) throws Exception {
        if ( pc == null && console == null ) {
            throw new Exception( "Vous êtes obligés de choisir au moins une plateforme de jeux" );
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
