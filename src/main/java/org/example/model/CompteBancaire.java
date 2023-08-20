package org.example.model;

import java.util.ArrayList;

public class CompteBancaire {
    private int id;
    private double solde;
    private Client client;
    private ArrayList<Operation> listeOperations= new ArrayList<Operation>();

    public CompteBancaire(int id, double solde, Client client, ArrayList<Operation> listeOperations) {
        this.id = id;
        this.solde = solde;
        this.client = client;
        this.listeOperations = listeOperations;
    }

    public  CompteBancaire(int id){
        this.id = id;
        this.solde = 0;
    }

    public CompteBancaire(int id, double solde){
        this.id = id;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(ArrayList<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }
}
