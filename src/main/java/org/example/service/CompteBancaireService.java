package org.example.service;

import org.example.dao.ClientDAO;
import org.example.dao.CompteBancaireDAO;
import org.example.dao.OperationDAO;
import org.example.model.Client;

import org.example.model.CompteBancaire;
import org.example.model.Operation;
import org.example.util.DatabaseManager;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    public boolean updateCompte(CompteBancaire compteBancaire) {
        try {
            if(compteBancaireDAO.update(compteBancaire)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public CompteBancaire compteBancaire(int id) {
        try {
            return compteBancaireDAO.getIdCompte(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CompteBancaire> getAllCompteBancaire(int id) {
        try {
            return compteBancaireDAO.getAllCompte(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
