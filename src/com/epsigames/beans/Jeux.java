package com.epsigames.beans;

public class Jeux {
    private String titre;
    private String sousTitre;
    private String societeDeProduction;
    private String description;
    private String paysDeProduction;
    private String anneeDeRealisation;
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre( String genre ) {
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre( String titre ) {
        this.titre = titre;
    }

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre( String sousTitre ) {
        this.sousTitre = sousTitre;
    }

    public String getSocieteDeProduction() {
        return societeDeProduction;
    }

    public void setSocieteDeProduction( String societeDeProduction ) {
        this.societeDeProduction = societeDeProduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getPaysDeProduction() {
        return paysDeProduction;
    }

    public void setPaysDeProduction( String paysDeProduction ) {
        this.paysDeProduction = paysDeProduction;
    }

    public String getAnneeDeRealisation() {
        return anneeDeRealisation;
    }

    public void setAnneeDeRealisation( String anneeDeRealisation ) {
        this.anneeDeRealisation = anneeDeRealisation;
    }

}
