package org.example.service;

import org.example.dao.ClientDAO;
import org.example.dao.CompteBancaireDAO;
import org.example.model.Client;

import org.example.model.CompteBancaire;
import org.example.util.DatabaseManager;


import java.sql.Connection;
import java.sql.SQLException;

public class CompteBancaireService {
    private CompteBancaireDAO compteBancaireDAO;
    private Connection connection;

    public CompteBancaireService() {
        try {

            connection = new DatabaseManager().getConnection();
            compteBancaireDAO = new CompteBancaireDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createCompte(int id_client) {
        CompteBancaire compteBancaire = new CompteBancaire(id_client);
        try {
            if (compteBancaireDAO.save(compteBancaire)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
