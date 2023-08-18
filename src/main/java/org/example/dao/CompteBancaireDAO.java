package org.example.dao;

import org.example.model.Client;
import org.example.model.CompteBancaire;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompteBancaireDAO extends BaseDAO<CompteBancaire> {
    public CompteBancaireDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(CompteBancaire element) throws SQLException {
        request = "INSERT INTO comptebancaire (id_client, solde) VALUES (?, ?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, element.getId());
        statement.setDouble(2, element.getSolde());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;

    }

    @Override
    public Client get(int id) throws SQLException {
        return null;
    }

    @Override
    public Client get(String nb_phone) throws SQLException {
        return null;
    }

    @Override
    public Client getId(int id) throws SQLException {
        return null;
    }

}