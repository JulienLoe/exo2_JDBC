package org.example.dao;

import org.example.model.Client;
import org.example.model.CompteBancaire;
import org.example.model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public List<Operation> getIdOperation(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Operation> getIdOperation() throws SQLException {
        return null;
    }


    @Override
    public boolean update(CompteBancaire element) throws SQLException {
        request = "UPDATE compteBancaire set solde = ? where id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1,element.getSolde());
        statement.setInt(2,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public CompteBancaire getIdCompte(int id) throws SQLException {
        CompteBancaire compteBancaire = null;
        request = "select * from compteBancaire where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            compteBancaire = new CompteBancaire(resultSet.getInt("id"),
                    resultSet.getDouble("solde"));
        }
        return compteBancaire;
    }

    @Override
    public List<CompteBancaire> getAllCompte(int id) throws SQLException {
        List<CompteBancaire> result = new ArrayList<>();
        request = "select * from compteBancaire where id_client = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            CompteBancaire compteBancaire = new CompteBancaire(resultSet.getInt("id"),
                    resultSet.getDouble("solde"));
            result.add(compteBancaire);
        }
        return result;
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