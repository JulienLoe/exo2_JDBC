package org.example.dao;

import org.example.model.Client;
import org.example.model.CompteBancaire;
import org.example.model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientDAO extends BaseDAO<Client> {
    public ClientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Client element) throws SQLException {
        request = "INSERT INTO client (nom, prenom, nb_phone) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getNom());
        statement.setString(2, element.getPrenom());
        statement.setString(3, element.getNb_phone());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;

    }

    @Override
    public List<Operation> getIdOperation(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Operation> getIdOperation() throws SQLException {
        return null;
    }

    @Override
    public boolean update(CompteBancaire element) throws SQLException {
        return false;
    }

    @Override
    public CompteBancaire getIdCompte(int id) throws SQLException {
        return null;
    }

    @Override
    public List<CompteBancaire> getAllCompte(int id) throws SQLException {
        return null;
    }


    @Override
    public Client get(int id) throws SQLException {
        return null;
    }

    @Override
    public Client get(String nb_phone) throws SQLException {
        Client client = null;
        request = "select * from client where nb_phone = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, nb_phone);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            client = new Client(resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"));
        }
        return client;
    }

    @Override
    public Client getId(int id) throws SQLException {
        Client client = null;
        request = "select * from client where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            client = new Client(resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"));
        }
        return client;
    }
}
