package org.example.model;

public class Operation {
    private int id;
    private int nb_transaction;
    private double montant;
    private boolean statut;

    public Operation(int id, int nb_transaction, boolean statut) {
        this.id = id;
        this.nb_transaction = nb_transaction;
        this.statut = statut;
    }

    public Operation(int id, double montant, boolean statut) {
        this.id = id;
        this.montant = montant;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_transaction() {
        return nb_transaction;
    }

    public void setNb_transaction(int nb_transaction) {
        this.nb_transaction = nb_transaction;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
