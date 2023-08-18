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

public class OperationService {
    private OperationDAO operationDAO;
    private Connection connection;

    public OperationService() {
        try {

            connection = new DatabaseManager().getConnection();
            operationDAO = new OperationDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createOperation(int id_compte_bancaire, double montant, boolean statut) {
        Operation operation = new Operation(id_compte_bancaire, montant, statut);
        try {
            if (operationDAO.save(operation)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}