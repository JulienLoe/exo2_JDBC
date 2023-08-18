package org.example.service;

import org.example.dao.ClientDAO;
import org.example.model.Client;

import org.example.util.DatabaseManager;


import java.sql.Connection;
import java.sql.SQLException;

public class ClientService {
    private ClientDAO clientDAO;
    private Connection connection;

    public ClientService() {
        try {

            connection = new DatabaseManager().getConnection();
            clientDAO = new ClientDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createPerson(String nom, String prenom, String nb_phone) {
        Client client = new Client(nom, prenom, nb_phone);
        try {
            if (clientDAO.save(client)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Client getPerson(String nb_phone) {
        try {
            return clientDAO.get(nb_phone);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}