package org.afpa.model;

public class Client {
    private String nom;
    private String prenom;
    private String ville;

    public Client() {
    }

    public Client(String nom, String prenom, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getVille() {
        return ville;
    }
}
