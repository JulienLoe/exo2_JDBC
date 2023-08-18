package org.example.model;

import java.util.ArrayList;

public class Client {
    private int id;
    private String nom;
    private String prenom;

    private ArrayList<CompteBancaire> compteBancairesListe = new ArrayList<CompteBancaire>();
    private String nb_phone ;

    public Client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;

    }
    public Client(String nom, String prenom, String nb_phone){
        this.nom = nom;
        this.prenom = prenom;
        this.nb_phone = nb_phone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<CompteBancaire> getCompteBancairesListe() {
        return compteBancairesListe;
    }

    public void setCompteBancairesListe(ArrayList<CompteBancaire> compteBancairesListe) {
        this.compteBancairesListe = compteBancairesListe;
    }

    public String getNb_phone() {
        return nb_phone;
    }

    public void setNb_phone(String nb_phone) {
        this.nb_phone = nb_phone;
    }
}
