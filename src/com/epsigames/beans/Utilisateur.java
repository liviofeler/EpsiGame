package com.epsigames.beans;

public class Utilisateur {
    private String email;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String adresse;
    private String plateforme;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public String getPlateforme() {
        return plateforme;
    }

    public void setPlateforme( String plateforme ) {
        this.plateforme = plateforme;
    }

}
